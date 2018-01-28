$(function(){     
            /*JQuery 限制文本框只能输入数字*/  
             $('#count').keyup(function(){    
                    $(this).val($(this).val().replace(/\D|^0/g,''));  
                }).bind("paste",function(){  //CTR+V事件处理    
                    $(this).val($(this).val().replace(/\D|^0/g,''));     
                }).css("ime-mode", "disabled"); //CSS设置输入法不可用         
             
             $('.txtfree').keyup(function(){    
                 $(this).val($(this).val().replace(/\D|^0/g,''));  
             }).bind("paste",function(){  //CTR+V事件处理    
                 $(this).val($(this).val().replace(/\D|^0/g,''));     
             }).css("ime-mode", "disabled"); //CSS设置输入法不可用     
          });