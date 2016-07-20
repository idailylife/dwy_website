/**
 * Created by hebowei on 16/7/20.
 */
$(document).ready(function () {
    $("#taskpublishmentform").validate();
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
});

function to_change(){
    var obj  = document.getElementsByName('searchgate');
    for (i = 0; i < obj.length; i++) {
        if (obj[i].checked) document.cookie = 'radioindex =' + i;
    }

    for(var i=0;i<obj.length;i++){
        if(obj[i].checked==true){
            var currentradio = obj[i].value;
            if(currentradio=='taocommand'){
                document.getElementById('taocommanddiv').style.display='block';
                document.getElementById('activitydiv').style.display='none';
                document.getElementById('naturalsearchdiv').style.display='none';
            }else if(currentradio=='activity'){
                document.getElementById('activitydiv').style.display='block';
                document.getElementById('taocommanddiv').style.display='none';
                document.getElementById('naturalsearchdiv').style.display='none';
            }else{
                document.getElementById('naturalsearchdiv').style.display='block';
                document.getElementById('activitydiv').style.display='none';
                document.getElementById('taocommanddiv').style.display='none';
            }
        }
    }
}