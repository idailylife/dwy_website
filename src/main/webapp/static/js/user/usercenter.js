/**
 * Created by hebowei on 16/7/6.
 */
$(document).ready(function () {
    $("#btnGetVerifyCodeChgPswd").click(function () {
       $.ajax({
           method: "POST",
           url :   homeUrl + "verify/phoneForExistingUser",
           data :  "{}",
           contentType : "application/json; charset=utf-8",
           dataType: 'json',
           success : function (data) {
               switch(data.state){
                   case 200:
                       alert("msg sent (DEBUG: 1234 as vCode)");
                       break;
                   case 401: case 402:
                       alert(data.message);
                       break;
                   default:
                       alert("unknown return??!");
                       break;
               }
           }
           
       });
    });
    
    $("#btnSubmitChgPswd").click(function () {
       var dataSend = {
           oldPasswordMd5 : md5($("#oldpswd").val()),
           newPasswordMd5 : md5($("#newpswd").val()),
           phoneVerifyCode : $("#inputPhoneVCodeChgPswd").val() 
       } ;
        $.ajax({
            method: "POST",
            url: homeUrl + "user/changePassword",
            data: JSON.stringify(dataSend),
            contentType : "application/json; charset=utf-8",
            dataType: 'json',
            success : function (data) {
                switch(data.state){
                    case 200:
                        alert("PASSWORD HAS BEEN RESET TO" + $("#newpswd").val());
                        break;
                    case 400: case 401: case 402:
                    alert(data.message);
                    break;
                    default:
                        alert("unknown return??!");
                        break;
                }
            }
        });
    });
});