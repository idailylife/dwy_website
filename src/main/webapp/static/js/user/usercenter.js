/**
 * Created by hebowei on 16/7/6.
 */
$(document).ready(function () {
    var getPhoneVerifyCode = function () {
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
    }

    $("#btnGetVerifyCodeChgPswd").click(function () {
       getPhoneVerifyCode();
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
    
    $("#btnGetPhoneVCodeChgTransPswd").click(function () {
       getPhoneVerifyCode();
    });

    $("#btnSetTradePswd").click(function () {
        var oldPswd = $("input[name='oldPassword']")[0].value;
        var newPswd = $("input[name='newPassword']")[0].value;
        var vCode = $("input[name='phoneVerifyCode']")[0].value;
        var dataSend = {
            oldPasswordMd5 : md5(oldPswd),
            newPasswordMd5 : md5(newPswd),
            phoneVerifyCode : vCode
        };
        $.ajax({
            method: "POST",
            url: homeUrl + "user/changeTransPassword",
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