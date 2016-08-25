    //Preloader
    $(window).load(function() {
      $("#loader .icon").fadeOut();
      $("#loader").fadeOut("slow");
    });

    //Scroll Top
    $(window).scroll(function() {
      if ($(this).scrollTop() > 300) {
        $('.scroll-up').fadeIn();
      } else {
        $('.scroll-up').fadeOut();
      }
    });    


    jQuery(document).ready(function() {
         
      //Sticky Navigation
      $(function() {
          $('#navigation').height($("#nav").height());
            $('#nav').affix({
                offset: { top: $('#nav').offset().top -70 }
          });
      });

      //Smooth Page Scrolling requires - Jquery Easing
      jQuery('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
          $('html, body').stop().animate({
              scrollTop: $($anchor.attr('href')).offset().top
            }, 1500, 'easeInOutExpo');
          event.preventDefault();
      });

      //Highlight top nav as scrolling occurs
        jQuery('body').scrollspy({
            target: '.navbar-static-top'
        })

      //Closes Responsive Menu on Menu Item Click
        jQuery('.navbar-collapse ul li a').click(function() {
          $('.navbar-toggle:visible').click();
      });

      //Header slider
        jQuery("#header-slider").owlCarousel({
            items : 1,
            itemsDesktop : [1199,1],
            itemsDesktopSmall : [979,1],
            itemsTablet: [600,1],
            itemsMobile : [479,1],
            pagination : true,
            autoPlay : true
        });        
      
      //About slider
        jQuery("#about-slider").owlCarousel({
            items : 1,
            itemsDesktop : [1199,1],
            itemsDesktopSmall : [979,1],
            itemsTablet: [600,1],
            itemsMobile : [479,1],
            pagination : true,
            autoPlay : true     
        });

      //Video Popup
        jQuery('.app-video').magnificPopup({
            disableOn: 200,
            type: 'iframe',
            mainClass: 'mfp-fade',
            removalDelay: 160,
            preloader: false,
            fixedContentPos: false
        });
     
      //Testimonials slider
        jQuery("#testimonial-slider").owlCarousel({
            items : 1,
            itemsDesktop : [1199,1],
            itemsDesktopSmall : [979,1],
            itemsTablet: [600,1],
            itemsMobile : [479,1],
            pagination : true,
            autoPlay : true,
            transitionStyle : "goDown"          
        });

      //Screenshot slider
        jQuery("#screenshot").owlCarousel({
            items : 4,
            itemsDesktop : [1199,3],
            itemsDesktopSmall : [979,2],
            itemsTablet: [767,2],
            itemsMobile : [600,1],
            pagination : true,
            autoPlay : false
        });      
   
      //Magnific Popup
        jQuery('.zoom').magnificPopup({type: 'image'});

      //Animation
        new WOW().init(); 

      //Contact Form
        $('.form-horizontal').on('submit',function(){
                 
        var form = $(this);
        $.ajax({
            url: form.attr('action'),
            method: form.attr('method'),
            data: form.serialize(),
            success: function(result){
                if (result == 'success'){
                    $('.send-success').fadeIn().delay(4000).fadeOut();;  
                } else {
                    $('.send-error').fadeIn().delay(4000).fadeOut();;
                }
                $('.form-horizontal').trigger("reset");
            }
          });
         
         // Prevents default submission of the form after clicking on the submit button. 
          return false;   
        });   
        

    });
