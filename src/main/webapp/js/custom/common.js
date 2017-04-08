$().ready(function () {

    //定义base64全局解码utf8
    $.base64().utf8encode = true;

    //绑定登陆时用户名框失去焦点时的处理函数
    $("#loginInputAccount").blur(function () {
        var userAccount = $("#loginInputAccount").val();
        $.post(
            "/userCheck.action",
            {
                userAccount: userAccount
            },
            function (data, status) {
                if (status == "success") {
                    if (data.message == "error") {
                        //删除之前遗留
                        $(".mustclear").remove();
                        $("#loginInputAccount").parent().append(
                            "<small class='text-muted text-danger mustclear'>" + data.detailed_message + "</small>");
                        $("#submitLoginBtn").addClass("btn-outline-danger disabled").removeClass("btn-outline-primary");
                    } else {
                        $(".mustclear").remove();
                        $("#submitLoginBtn").removeClass("btn-outline-danger disabled").addClass("btn-outline-primary");
                    }
                }
            }
        );
    });

    //绑定注册时用户名框失去焦点的处理函数
    $("#inputAccount").blur(function () {
        var userAccount = $("#inputAccount").val();
        $.post(
            "/userCheck.action",
            {
                userAccount: userAccount
            },
            function (data, status) {
                if (status == "success") {
                    if (data.message == "success") {
                        $(".mustclear").remove();
                        $("#inputAccount").parent().append(
                            "<small class='text-muted text-danger mustclear'>" + data.detailed_message + "</small>");
                        $("#submitRegisterBtn").addClass("btn-outline-danger disabled").removeClass("btn-outline-primary");
                    } else {
                        $(".mustclear").remove();
                        $("#submitRegisterBtn").removeClass("btn-outline-danger disabled").addClass("btn-outline-primary");
                    }
                }
            }
        )
    });

    //表单验证
    $("#loginForm").validate({
        onsubmit: true,
        onfocusout: function (element) {
            $(element).valid();
        },
        onkeyup: function (element) {
            $(element).valid();
        },
        errorElement: "small",
        onclick: true,
        success: "valid"
    });
    $("#registerForm").validate({
        onsubmit: true,
        onfocusout: function (element) {
            $(element).valid();
        },
        onkeyup: function (element) {
            $(element).valid();
        },
        errorElement: "small",
        onclick: true,
        success: "valid"
    });

//    用户状态判断
    $(function () {
        var token = $.cookie("token");
        if (token == undefined || token == null) {
            //    不处理
        } else {
            //token 尚未过期
            var payload_encoded = token.split("\.")[1];
            var payload = $.parseJSON($.base64("atob", payload_encoded, true));
            $("#loginA").parent().append("<a class='nav-link' href='#' id='userDetailA' onclick='goUserDetails()'>你好，" + $.cookie("user_nickname") + "</a>");
            $("#loginA").remove();
            $("#registerA").parent().append("<a class='nav-link' href='#' id='logoutA' onclick='logout()'>登出</a>");
            $("#registerA").remove();
        }
    });
});

function login() {
    var flag = false;
    var length = $("#loginForm input").length;
    var temp = 0;
    //检查是否有空值表单
    $("#loginForm input").each(function () {
        if ($(this).val() == "") {
            $(this).focus();
            return false;
        }
    });
    //检查所有输入框是否都有值
    $("#loginForm input").each(function () {
        if ($(this).val() != "") {
            temp++;
        }
    });
    //如果所有输入框都有值
    if (temp == length) {
        flag = true;
        $("#loginModal").modal("hide");
    }
    if (flag) {
        $.post(
            "/login.action",
            {
                userAccount: $("#loginInputAccount").val(),
                userPassword: $("#loginInputPassword").val()
            },
            function (data, status) {
                if (status == "success") {
                    if (data.message == "success") {
                        var token = data.token;
                        var payload_encoded = token.split("\.")[1];
                        var payload = $.parseJSON($.base64("atob", payload_encoded, true));
                        $.cookie("token", token);
                        $.cookie("user_nickname", data.user_nickname);
                        $("#loginA").parent().append("<a class='nav-link' href='#' id='userDetailA' onclick='goUserDetails()'>你好，" + data.user_nickname + "</a>");
                        $("#loginA").remove();
                        $("#registerA").parent().append("<a class='nav-link' href='#' id='logoutA' onclick='logout()'>登出</a>");
                        $("#registerA").remove();
                    }
                }
            }
        );
    } else {
        return false;
    }
}

function register() {
    var flag = false;
    var length = $("#registerForm input").length;
    var temp = 0;
    //检查是否有空值表单
    $("#registerForm input").each(function () {
        if ($(this).val() == "") {
            $(this).focus();
            return false;
        }
    });

    //检查所有输入框是否都有值
    $("#registerForm input").each(function () {
        if ($(this).val() != "") {
            temp++;
        }
    });
    if (temp == length) {
        flag = true;
        $("#registerModal").modal("hide");
    }

    if (flag) {
        $.post(
            "/register.action",
            {
                userAccount: $("#inputAccount").val(),
                userPassword: $("#inputPassword").val(),
                userNickName: $("#inputNickName").val(),
                userRealName: $("#inputRealName").val(),
                userPhoneNum: $("#inputPhoneNum").val(),
                userEmail: $("#inputEmail").val()
            },
            function (data, status) {
                if (status == "success") {
                    if (data.message == "success") {
                        var token = data.token;
                        var payload_encoded = token.split("\.")[1];
                        var payload = $.parseJSON($.base64("atob", payload_encoded, true));
                        $.cookie("token", token);
                        $.cookie("user_nickname", data.user_nickname);
                        $("#loginA").parent().append("<a class='nav-link' href='#' id='userDetailA' onclick='goUserDetails()'>你好，" + data.user_nickname + "</a>");
                        $("#loginA").remove();
                        $("#registerA").parent().append("<a class='nav-link' href='#' id='logoutA' onclick='logout()'>登出</a>");
                        $("#registerA").remove();
                    }
                }
            }
        )
    } else {
        return false;
    }

}

function logout() {
    if ($.cookie("token") != null && $.cookie("token") != undefined) {
        $.removeCookie("token");
        $.removeCookie("user_nickname");
        window.location.reload();
    }
}

//TODO
function goUserDetails() {
    alert("haha");
}

function test() {

}