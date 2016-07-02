/**
 * Created by hebowei on 16/7/2.
 */
$(document).ready(function () {
    new PCAS("province","city","district");
    // var container2 = document.getElementById("vCode2");
    // var code = new vCode(container2, {
    //     len: 5,
    //     bgColor: "#444444",
    //     colors: [
    //         "#DDDDDD",
    //         "#DDFF77",
    //         "#77DDFF",
    //         "#99BBFF",
    //         //"#7700BB",
    //         "#EEEE00"
    //     ]
    // });
    // document.getElementById("btn2").addEventListener("click", function () {
    //     alert(code.verify(document.getElementById("code").value));
    // }, false);

    $("#registerForm").validate();
    $('#register').click(function (event) {
        event.preventDefault();
        var formData = new FormData(document.getElementById('formVerify'));
        $.ajax({
            url: homeUrl + 'user/verify',
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