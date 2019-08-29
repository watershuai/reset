/**
 * Created by yangzhao on 18/9/15.
 */
jQuery(function () {
    var url = window.location.href
    var qrcode = jQuery('#qrcode').qrcode(url);
    var canvas = qrcode.find('canvas').get(0);
    $('.qrcode img').attr('src', canvas.toDataURL('image/jpg'))
})

var url = window.location.href
var shortLink = url.substr((url.lastIndexOf("/") + 1), 4)
var osName;
if (isAndroid) {
    $("#page_Android").show();
    document.title = $("#Android_appName").text()
    osName = "Android";
    $("#untrusted").hide()
} else if (isiOS) {
    $("#page_iOS").show();
    document.title = $("#iOS_appName").text()
    osName = "iOS";
} else {
    $("div[link='" + shortLink + "']").show();
    document.title = $("." + shortLink + "_appName").text()
    osName=$("div[link='"+shortLink+"']").attr("osName")
    if (osName=="Android"){
        $("#actions").show()
    }else{
        $("#actions").hide()
    }
    $("#footer").hide()
}

if ((isAndroid || isiOS) && $("#page_" + osName).length == 0) {
    layer.msg('该应用不存在 '+osName+' 安装包<br>请联系应用提供方', {
        time: 2000000000, //20s后自动关闭
    });
}

//判断用户在微信
if (is_weixin() && isAndroid) {
    $(".weixin-tip").css("height", getScreenHeight());
    $(".weixin-tip").show();
    $("#" + osName + "_tips").show()
}

//判断iOS用户在第三方打开提示
if (isiOS && (isQQBrowser()||isUCBrowser()||isFirefoxBrowser())) {
    $(".weixin-tip").css("height", getScreenHeight());
    $(".weixin-tip").show();
    $("#" + osName + "_tips").show()
}

function is_weixin() {
    var ua = navigator.userAgent.toLowerCase();
    if (ua.match(/MicroMessenger/i) == "micromessenger") {
        return true;
    } else {
        return false;
    }
}

var interval

function install() {
    if (isiOS && isSafari()) {
        $("#down_success").hide()
        if (isiOS) {
            $('#installModal').modal('show')
            $("#quan").show()
            var angle = 0;
            interval = setInterval(function () {
                angle += 3;
                $("#quan").rotate(angle);
            }, 10);
            var it = setInterval(function () {
                $("#down_success").show()
                $("#quan").hide()
                clearInterval(interval)
                clearInterval(it)
            }, 8000);
        }
    }

    $.ajax({
        type: "post",
        url: "/" + shortLink + "/install?osName=" + osName,
        timeout: 5000,
        cache: false,
        async: false,
        dataType: "json",
        success: function (data) {
            messgeHandle(data, function (respData) {

                if (isiOS) {
                    window.location.href = "itms-services://?action=download-manifest&url=" + encodeURIComponent(respData)
                }else{
                    window.location.href = respData
                }
            })
        }

    });

}

$('#installModal').on('shown.bs.modal', function () {
    var $this = $(this);
    var dialog = $this.find('.modal-dialog');

    //此种方式，在使用动画第一次显示时有问题
    //解决方案，去掉动画fade样式
    var top = ($(window).height() - dialog.height()) / 2;
    dialog.css({
        marginTop: top
    });
});

$('#installModal').on('hide.bs.modal', function () {
    console.log("关闭模态框")
    clearInterval(interval)
})

function open_settings() {
    window.location.href = "https://tiger-public.oss-cn-beijing.aliyuncs.com/com.furu._.mobileprovision"
}

function install_warn() {
    $('#myModal').modal('show')
}

function advertisementLink() {
    var url=$("#advertisementLink").val()
    window.location.href=url
}