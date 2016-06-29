/**
 * Created by hebowei on 16/6/10.
 */
$(document).ready(function () {
    $("#btnSubmitLogin").click(function (event) {
        event.preventDefault();
        var submitData = {
            email: $('#inputEmail').val(),
            password: md5($('#inputPassword').val()),
            remember: false
        };
        if($("#checkRemember").prop('checked')){
            submitData['remember'] = true;
        }
        $.ajax({
            method: "POST",
            url: homeUrl + 'user/login',
            data: JSON.stringify(submitData),
            contentType : "application/json; charset=utf-8",
            dataType: 'json',
            success: function (data) {
                switch (data.state){
                    case 200:
                        window.location.href = homeUrl;
                        break;
                    default:
                        alert("错误" + data.state + ": " + data.message);
                        break;
                }
            }
        });
    });
});