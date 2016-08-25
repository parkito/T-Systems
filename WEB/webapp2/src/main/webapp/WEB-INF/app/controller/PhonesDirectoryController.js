/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 3:14
 * To change this template use File | Settings | File Templates.
 */
Ext.define('PhonesDir.controller.PhonesDirectoryController', {
    extend: 'Ext.app.Controller',

    views: [
        'AddWindowForm',
        'PhonesDirectory',
        'PhonesGrid',
        'SearchPhones'
    ],

    stores: ['PhonesDirectoryStore'],
    models: ['PhonesDirectoryModel'],

    refs: [
        {selector: 'phonesGrid',
            ref: 'phonesGrid'},
        {selector: 'phonesGrid button[action="add"]',
            ref: 'phonesGridAdd'},
        {selector: 'phonesGrid button[action="delete"]',
            ref: 'phonesGridDelete'},
        {selector: 'searchPhones button[action="search"]',
            ref: 'searchPhones'},
        {selector: 'addWindowForm',
            ref: 'addWindowForm'},
        {selector: 'phonesDirectory',
            ref: 'phonesDirectory'},
        {selector: 'addWindowForm textfield[name=name] ',
            ref: 'addWindowFormName'},
        {selector: 'addWindowForm textfield[name=phone]',
            ref: 'addWindowFormPhone'},
        {selector: 'addWindowForm button[action=save]',
            ref: 'addWindowFormPhoneSave'}
    ],

    init: function () {
        this.control({
            'phonesGrid button[action=add]': {
                click: this.onAddPhone
            },
            'phonesGrid button[action=delete]': {
                click: this.onDelPhone
            },
            'searchPhones textfield[name="search"]': {
                change: this.onChangeText
            },
            'phonesGrid': {
                cellclick: this.onLineGrid
            },
            'addWindowForm button[action=save]': {
                click: this.onSavePhone
            },
            'addWindowForm textfield[name=name]': {
                change: this.onValidation
            },
            'addWindowForm textfield[name=phone]': {
                change: this.onValidation
            }
        });
    },

    onSavePhone: function (button) {
        var me = this;
        var phoneModel = Ext.create('PhonesDir.model.PhonesDirectoryModel');
        phoneModel.set(this.getAddWindowForm().down('form').getValues());
        phoneModel.save({
            success: function (operation, response) {
                var objAjax = operation.data;
                me.getPhonesDirectoryStoreStore().add(objAjax);
                me.getAddWindowForm().close();
            },
            failure: function (dummy, result) {
                Ext.MessageBox.show({
                    title: 'Дубликат!',
                    msg: 'Такое имя и телефон уже существуют',
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.ERROR
                });
            }

        });
    },

    onAddPhone: function () {
        Ext.widget('addWindowForm');
    },

    onDelPhone: function () {
        var sm = this.getPhonesGrid().getSelectionModel();
        var rs = sm.getSelection();
        this.getPhonesGrid().store.remove(rs[0]);
        this.getPhonesGrid().store.commitChanges();
        this.getPhonesGridDelete().disable();
    },

    onChangeText: function () {
        this.getPhonesDirectoryStoreStore().load({
            params: {
                search: this.getPhonesDirectory().down('searchPhones').getValues()
            }
        });
    },

    onLineGrid: function () {
        this.getPhonesGridDelete().enable();
    },

    onValidation: function () {
        if (this.getAddWindowFormName().validate() && this.getAddWindowFormPhone().validate()) {
            this.getAddWindowFormPhoneSave().enable();
        } else {
            this.getAddWindowFormPhoneSave().disable();
        }
    }

});