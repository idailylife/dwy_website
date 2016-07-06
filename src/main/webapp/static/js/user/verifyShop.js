/**
 * Created by hebowei on 16/7/4.
 */
$(document).ready(function () {
   $('#btnShopverify').click(function () {
        var formData = new FormData(document.getElementById('formShopValidation'));
        $.ajax({
            url: homeUrl + 'user/verifyShop',
            type: 'POST',
            data: formData,
            success: function (data) {
                console.log(data);
                if(data.state == 200){
                    //window.location.href = homeUrl + "task/edit/" + data.content;
                    alert('succeed');
                } else if(data.state == 400){
                    alert("表单输入不完整，请重试");
                } else if(data.state == 403){
                    alert("用户校验错误,请重新登录");
                }
            },
            cache: false,
            contentType: false,
            processData: false
        });
   });
});