//  Mobile menu
/* =================================================== */
	jQuery(document).ready(function () {
		jQuery('nav').meanmenu();
	});


//  JMPRESS Slideshow
/* =================================================== */
	jQuery(function() {
		jQuery( '#jms-slideshow' ).jmslideshow();
	});

	
//  style for "last"
/* =================================================== */
jQuery('ul.footer-menu li:last').addClass('last');


//  tab articles widget
/* =================================================== */
	jQuery(".tab_content").hide();
	jQuery(".tab_content:first").show(); 

	jQuery("ul.tabs li").click(function() {
		jQuery("ul.tabs li").removeClass("active");
				
		jQuery(".tab_content").hide();
		var activeTab =  jQuery(this).find("em").attr("title");
		jQuery(this).addClass("active");
		jQuery("#"+activeTab).fadeIn(); 
	});
	

//  home page gallery
/* =================================================== */
	jQuery('#gallery_1_left').click(function() {
		jQuery('.content_gallery_1_left').fadeToggle();
		return false;
	});

	jQuery('#gallery_1_right').click(function() {
		jQuery('.content_gallery_1_right').fadeToggle();
		return false;
	});

	jQuery('#gallery_2_left').click(function() {
		jQuery('.content_gallery_2_left').fadeToggle();
		return false;
	});

	jQuery('#gallery_2_right').click(function() {
		jQuery('.content_gallery_2_right').fadeToggle();
		return false;
	});

	jQuery(".close").click(function(){
	  jQuery(".content_gallery_1_left, .content_gallery_1_right, .content_gallery_2_left, .content_gallery_2_right").fadeOut(500);
	});
	
	
//  prettyPhoto
/* =================================================== */
	jQuery(document).ready(function(){
		jQuery(".galley_item_sm a[data-rel^='prettyPhoto']").prettyPhoto({animation_speed:'normal',theme:'dark_square',slideshow:3000});
	});

	
//  Fixed nav bar
/* =================================================== */
	jQuery("document").ready(function($){
		
		var nav = $('.nav_container');
		var hasScrolled = $('.hasScrolled_fix');
		var arrows = $('.jms-arrows');
		var shadow = $('.shadow');
		var logo = $('nav ul li:first');
		
		$(window).scroll(function () {
			if ($(this).scrollTop() > 100) {
				nav.addClass("fixed_nav");
				hasScrolled.addClass("hasScrolled");
				shadow.fadeIn(200);
				logo.removeClass("home");
				logo.addClass("home_logo");
				$('nav ul li a:first').hide();
			} else {
				nav.removeClass("fixed_nav");
				hasScrolled.removeClass("hasScrolled");
				shadow.fadeOut(100);
				logo.removeClass("home_logo");
				logo.addClass("home");
				$('nav ul li a:first').show();
			}
			if ($(this).scrollTop() > 130) {
				arrows.fadeOut(200);
			} else {
				arrows.fadeIn(200);
			}
		});
	 
	});	
	
	
//  forms infield labels 
/* =================================================== */
	jQuery(function(){ jQuery("label").inFieldLabels(); });
	
	
//  faq
/* =================================================== */
	jQuery(document).ready(function () { 
			  
		jQuery('#accordion a.item').click(function () { 
			  
			/* FIRST SECTION */
				  
			//slideup or hide all the Submenu 
			jQuery('#accordion li').children('ul').slideUp('fast');   
					  
			//remove all the "Over" class, so that the arrow reset to default 
			jQuery('#accordion a.item').each(function () { 
				if (jQuery(this).attr('rel')!='') { 
					jQuery(this).removeClass(jQuery(this).attr('rel') + 'Over');   
				} 
			}); 
					  
			/* SECOND SECTION */        
					  
			//show the selected submenu 
			jQuery(this).siblings('ul').slideDown('fast'); 
					  
			//add "Over" class, so that the arrow pointing down 
			jQuery(this).addClass(jQuery(this).attr('rel') + 'Over');          
				  
				return false; 
			  
		}); 
		  
	}); 
	
//  Mobile layout simplicity
/* =================================================== */
	jQuery(window).load(function(){
	
		if ($(window).width() <= 600) {
			jQuery('.carousel li:last-child').hide();
		}
		if ($(window).width() <= 320) {
			jQuery('.carousel li:last-child').show();
		}
	});
	
	
//  Share button
/* =================================================== */
    jQuery(function(){
      jQuery('.share-button').share({
        title: 'Share Button Test',
        background: 'rgba(255,255,51,1)',
        color: '#3B2B45'
      })
    });
