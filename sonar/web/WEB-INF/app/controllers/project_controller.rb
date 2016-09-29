#
# SonarQube, open source software quality management tool.
# Copyright (C) 2008-2014 SonarSource
# mailto:contact AT sonarsource DOT com
#
# SonarQube is free software; you can redistribute it and/or
# modify it under the terms of the GNU Lesser General Public
# License as published by the Free Software Foundation; either
# version 3 of the License, or (at your option) any later version.
#
# SonarQube is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
# Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public License
# along with this program; if not, write to the Free Software Foundation,
# Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
#
class ProjectController < ApplicationController
  verify :method => :post, :only => [:set_links, :set_exclusions, :delete_exclusions, :update_key, :perform_key_bulk_update],
         :redirect_to => {:action => :index}
  verify :method => :delete, :only => [:delete], :redirect_to => {:action => :index}

  SECTION=Navigation::SECTION_RESOURCE

  def index
    # this URL should not be called. Replaced by dashboard/index
    redirect_to :overwrite_params => {:controller => :dashboard, :action => 'index'}
  end

  def delete_form
    @project = get_current_project(params[:id])
    render :partial => 'delete_form'
  end

  def delete
    @project = get_current_project(params[:id])

    # Ask the resource deletion manager to start the migration
    # => this is an asynchronous AJAX call
    ResourceDeletionManager.instance.delete_resources([@project.id])

    # and return some text that will actually never be displayed
    render :text => ResourceDeletionManager.instance.message
  end

  def deletion
    @project = get_current_project(params[:id])

    if java_facade.getResourceTypeBooleanProperty(@project.qualifier, 'deletable')
      deletion_manager = ResourceDeletionManager.instance
      if deletion_manager.currently_deleting_resources? ||
          (!deletion_manager.currently_deleting_resources? && deletion_manager.deletion_failures_occured?)
        # a deletion is happening or it has just finished with errors => display the message from the Resource Deletion Manager
        render :template => 'project/pending_deletion'
      else
        @snapshot=@project.last_snapshot
      end
    else
      redirect_to :action => 'index', :id => params[:id]
    end
  end

  def pending_deletion
    deletion_manager = ResourceDeletionManager.instance

    if deletion_manager.currently_deleting_resources? ||
        (!deletion_manager.currently_deleting_resources? && deletion_manager.deletion_failures_occured?)
      # display the same page again and again
      # => implicit render "pending_deletion.html.erb"
    else
      redirect_to_default
    end
  end

  def dismiss_deletion_message
    # It is important to reinit the ResourceDeletionManager so that the deletion screens can be available again
    ResourceDeletionManager.instance.reinit

    redirect_to :action => 'deletion', :id => params[:id]
  end

  # GET /project/profile?id=<project id>
  def profile
    require_parameters :id
    @project_id = Api::Utils.project_id(params[:id])
    @project = Project.by_key(@project_id)
    access_denied unless (is_admin?(@project.uuid) || has_role?(:profileadmin))

    call_backend do
      @all_quality_profiles = Internal.quality_profiles.allProfiles().to_a
    end
  end

  # POST /project/set_profile?id=<project id>&language=<language>[&profile_id=<profile id>]
  def set_profile
    verify_post_request

    language = params[:language]
    project = get_current_project(params[:id])
    profile_id = params[:profile_id]

    call_backend do
      if profile_id.blank?
        Internal.quality_profiles.removeProjectByLanguage(language, project.id())
      else
        profile = Internal.quality_profiles.profile(profile_id.to_i)
        Internal.quality_profiles.addProject(profile.key(), project.uuid())
      end
    end

    redirect_to :action => 'profile', :id => project
  end

  # GET /project/qualitygate?id=<project id>
  def qualitygate
    require_parameters :id
    @project_id = Api::Utils.project_id(params[:id])
    @project = Project.by_key(@project_id)
    access_denied unless (is_admin?(@project.uuid) || has_role?(:gateadmin))

    call_backend do
      @all_quality_gates = Internal.quality_gates.list().to_a
      @selected_qgate = Property.value('sonar.qualitygate', @project, '').to_i
    end
  end

  # POST /project/set_qualitygate?id=<project id>[&qgate_id=<qgate id>]
  def set_qualitygate
    verify_post_request

    project_id = params[:id].to_i
    qgate_id = params[:qgate_id].to_i
    previous_qgate_id = params[:previous_qgate_id].to_i

    call_backend do
      if qgate_id == 0
        Internal.quality_gates.dissociateProject(previous_qgate_id, project_id)
      else
        Internal.quality_gates.associateProject(qgate_id, project_id)
      end
    end

    redirect_to :action => 'qualitygate', :id => project_id
  end

  def key
    @project = get_current_project(params[:id])
    @snapshot = @project.last_snapshot
  end

  def update_key
    project = get_current_project(params[:id])

    new_key = params[:new_key].strip
    if new_key.blank?
      flash[:error] = message('update_key.new_key_cant_be_blank_for_x', :params => project.key)
    elsif new_key == project.key
      flash[:warning] = message('update_key.same_key_for_x', :params => project.key)
    elsif Project.by_key(new_key)
      flash[:error] = message('update_key.cant_update_x_because_resource_already_exist_with_key_x', :params => [project.key, new_key])
    else
      call_backend do
        Internal.component_api.updateKey(project.key, new_key)
        flash[:notice] = message('update_key.key_updated')
      end
    end

    redirect_to :action => 'key', :id => project.root_project.id
  end

  def prepare_key_bulk_update
    @project = get_current_project(params[:id])

    @string_to_replace = params[:string_to_replace].strip
    @replacement_string = params[:replacement_string].strip
    if @string_to_replace.blank? || @replacement_string.blank?
      flash[:error] = message('update_key.fieds_cant_be_blank_for_bulk_update')
      redirect_to :action => 'key', :id => @project.id
    else
      call_backend do
        @key_check_results = Internal.component_api.checkModuleKeysBeforeRenaming(@project.key, @string_to_replace, @replacement_string)
        @can_update = false
        @duplicate_key_found = false
        @key_check_results.each do |key, value|
          if value=="#duplicate_key#"
            @duplicate_key_found = true
          else
            @can_update = true
          end
        end
        @can_update = false if @duplicate_key_found
      end
    end
  end

  def perform_key_bulk_update
    project = get_current_project(params[:id])

    string_to_replace = params[:string_to_replace].strip
    replacement_string = params[:replacement_string].strip

    unless string_to_replace.blank? || replacement_string.blank?
      call_backend do
        Internal.component_api.bulkUpdateKey(project.key, string_to_replace, replacement_string)
        flash[:notice] = message('update_key.key_updated')
      end
    end

    redirect_to :action => 'key', :id => project.id
  end

  def history
    @project = get_current_project(params[:id])

    unless java_facade.getResourceTypeBooleanProperty(@project.qualifier, 'modifiable_history')
      redirect_to :action => 'index', :id => params[:id]
    end

    @snapshot = @project.last_analysis
    @analyses = Snapshot.all(:conditions => ["status='P' AND component_uuid=?", @project.uuid],
                              :include => 'events', :order => 'snapshots.created_at DESC')
  end

  def background_tasks
    @project = get_current_project(params[:id])
  end

  def delete_snapshot_history
    @project = get_current_project(params[:id])

    sid = params[:snapshot_id]
    if sid
      Snapshot.update_all("status='U'", ["id=?", sid.to_i])
      flash[:notice] = message('project_history.snapshot_deleted')
    end

    redirect_to :action => 'history', :id => @project.id
  end

  def links
    @project = get_current_project(params[:id])

    if !@project.project?
      redirect_to :action => 'index', :id => params[:id]
    end
    @snapshot = @project.last_snapshot
  end

  def set_links
    project = get_current_project(params[:project_id])

    project.custom_links.each { |link| link.delete }

    params.each_pair do |param_key, value|
      if (param_key.starts_with?('name_'))
        id = param_key[5..-1]
        name=value
        url=params["url_#{id}"]
        key=params["key_#{id}"]
        if key.blank?
          key=ProjectLink.name_to_key(name)
        end
        unless key.blank? || name.blank? || url.blank?
          project.links.create(:href => url, :name => name, :link_type => key)
        end
      end
    end
    project.save!

    flash[:notice] = 'Links updated.'
    redirect_to :action => 'links', :id => project.id
  end

  def settings
    @resource = get_current_project(params[:id])

    if !java_facade.getResourceTypeBooleanProperty(@resource.qualifier, 'configurable')
      redirect_to :action => 'index', :id => params[:id]
    end

    @snapshot = @resource.last_snapshot
    definitions_per_category = java_facade.propertyDefinitions.propertiesByCategory(@resource.qualifier)
    processProperties(definitions_per_category)
  end

  def update_version
    snapshot=Snapshot.find(params[:sid], :include => 'project')
    not_found("Snapshot not found") unless snapshot
    access_denied unless is_admin?(snapshot)

    unless params[:version_name].blank?
      if Event.already_exists(snapshot.component_uuid, params[:version_name], EventCategory::KEY_VERSION)
        flash[:error] = message('project_history.version_already_exists', :params => h(params[:version_name]))
      else
        # We update the snapshot to have a version attribute in sync with the new name
        snapshot.version = params[:version_name]
        snapshot.save!
        # And then we update/create the event on the snapshot
        if snapshot.event(EventCategory::KEY_VERSION)
          # This is an update: we update the event
          Event.update_all({:name => params[:version_name]},
                           ["category = ? AND analysis_uuid = ?", EventCategory::KEY_VERSION, snapshot.uuid])
          flash[:notice] = message('project_history.version_updated', :params => h(params[:version_name]))
        else
          # We create an event on the snapshot
          event = Event.create!(:name => params[:version_name], :snapshot => snapshot,
                                :component_uuid => snapshot.project.uuid, :category => EventCategory::KEY_VERSION,
                                :event_date => snapshot.created_at)
          flash[:notice] = message('project_history.version_created', :params => h(params[:version_name]))
        end
      end
    end

    redirect_to :action => 'history', :id => snapshot.project.id
  end

  def delete_version
    parent_snapshot=Snapshot.find(params[:sid])
    not_found("Snapshot not found") unless parent_snapshot
    access_denied unless is_admin?(parent_snapshot)

    # We update all the related snapshots to have the same version as the next snapshot
    next_snapshot = Snapshot.find(:first, :conditions => ['created_at>? and component_uuid=?', parent_snapshot.created_at_long, parent_snapshot.component_uuid], :order => 'created_at asc')
    parent_snapshot.version = next_snapshot.version
    parent_snapshot.save!

    # and we delete the events
    event = parent_snapshot.event(EventCategory::KEY_VERSION)
    old_version_name = event.name
    events = find_events(event)

    Event.transaction do
      events.map { |e| e.id }.each_slice(999) do |safe_for_oracle_ids|
        Event.delete(safe_for_oracle_ids)
      end
    end

    flash[:notice] = message('project_history.version_removed', :params => h(old_version_name))
    redirect_to :action => 'history', :id => parent_snapshot.project.id
  end

  def create_event
    snapshot=Snapshot.find(params[:sid])
    not_found("Snapshot not found") unless snapshot
    access_denied unless is_admin?(snapshot)

    if Event.already_exists(snapshot.component_uuid, params[:event_name], EventCategory::KEY_OTHER)
      flash[:error] = message('project_history.event_already_exists', :params => h(params[:event_name]))
    else
      e = Event.new({:name => params[:event_name],
                     :category => EventCategory::KEY_OTHER,
                     :snapshot => snapshot,
                     :component_uuid => snapshot.project.uuid,
                     :event_date => snapshot.created_at})
      e.save!
      flash[:notice] = message('project_history.event_created', :params => h(params[:event_name]))
    end

    redirect_to :action => 'history', :id => snapshot.project.id
  end

  def update_event
    event = Event.find(params[:id])
    not_found("Event not found") unless event
    access_denied unless is_admin?(event.resource)

    if Event.already_exists(event.component_uuid, params[:event_name], EventCategory::KEY_OTHER)
      flash[:error] = message('project_history.event_already_exists', :params => h(event.name))
    else
      events = find_events(event)
      events.each do |e|
        e.name = params[:event_name]
        e.save!
      end
      flash[:notice] = message('project_history.event_updated')
    end

    redirect_to :action => 'history', :id => event.resource.id
  end

  def delete_event
    event = Event.find(params[:id])
    not_found("Event not found") unless event
    access_denied unless is_admin?(event.resource)

    name = event.name
    resource_id = event.resource.id
    events = find_events(event)
    Event.transaction do
      events.map { |e| e.id }.each_slice(999) do |safe_for_oracle_ids|
        Event.delete(safe_for_oracle_ids)
      end
    end

    flash[:notice] = message('project_history.event_deleted', :params => h(name))
    redirect_to :action => 'history', :id => resource_id
  end

  protected

  def get_current_project(project_id)
    project=Project.by_key(project_id)
    not_found("Project not found") unless project
    access_denied unless is_admin?(project)
    project
  end

  # Returns all an array that contains the given event + all the events that are the same
  def find_events(event)
    events = []
    name = event.name
    category = event.category
    event.snapshot.events.reject { |e| e.name!=name || e.category!=category }.each do |event|
      events << event
    end
    events
  end

  def redirect_to_default
    redirect_to home_path
  end

end
