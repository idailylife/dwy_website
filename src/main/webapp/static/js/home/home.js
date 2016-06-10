/**
 * Created by hebowei on 16/6/9.
 */
$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        e.target // activated tab
        e.relatedTarget // previous tab
    });
    $('#myTab a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    });
    if(window.chrome) {
        $('.banner li').css('background-size', '100% 100%');
    }

    $('.banner').unslider({
        fluid: true,
        dots: true,
        speed: 600,               // 动画的速度,没有过度效果时为 false  (整型或布尔型)
        delay: 2500,              // 幻灯片之间的延迟，没有自动播放时为false（整数或布尔）
        complete: function() {},  // 播放每张幻灯片后调用的函数
        keys: true,               // 允许键盘左右键控制
        dots: true,               // 显示点导航
        fluid: false
    });

    //  Find any element starting with a # in the URL
    //  And listen to any click events it fires
    $('a[href^="#"]').click(function() {
        //  Find the target element
        var target = $($(this).attr('href'));

        //  And get its position
        var pos = target.offset(); // fallback to scrolling to top || {left: 0, top: 0};

        //  jQuery will return false if there's no element
        //  and your code will throw errors if it tries to do .offset().left;
        if(pos) {
            //  Scroll the page
            $('html, body').animate({
                scrollTop: pos.top,
                scrollLeft: pos.left
            }, 1000);
        }

        //  Don't let them visit the url, we'll scroll you there
        return false;
    });
});