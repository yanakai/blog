$(document).ready(function () { 
    
   //nav    
    var As=document.getElementById('starlist').getElementsByTagName('a');
    var obj = As[0];
    for(i=1;i<As.length;i++){
        if(window.location.href.indexOf(As[i].href)>=0){
            obj=As[i];
        }else if(window.location.href.indexOf("/web/column")>=0){
            obj=As[2];
        }
    }
    obj.id='selected';
   
     //nav
  $("#mnavh").click(function(){
    $("#starlist").toggle();
  $("#mnavh").toggleClass("open");
  });
  
    //search  
  $(".searchico").click(function(){
  $(".search").toggleClass("open");
  });
  
   //searchclose  
    $(".searchclose").click(function(){
  $(".search").removeClass("open");
  }); 
  
  //banner
    $('#banner').easyFader();
    
   //nav menu   
   $(".menu").click(function(event) {
   $(this).children('.sub').slideToggle();
   });
   
   $('.tab_buttons li').live('click',function(){
     $(this).addClass('newscurrent').siblings().removeClass('newscurrent');
     $('.newstab>div:eq('+$(this).index()+')').show().siblings().hide();
   });
    
});