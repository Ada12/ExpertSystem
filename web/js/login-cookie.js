/**
 * Created by chenweiyi on 02/07/2017.
 */

function addCookie(name, value, days, path) { /**添加设置cookie**/
    var name = escape(name);
    var value = escape(value);
    var expires = new Date();
    expires.setTime(expires.getTime() + days * 3600000 * 24);
    //path=/，表示cookie能在整个网站下使用，path=/temp，表示cookie只能在temp目录下使用
    path = path == "" ? "" : ";path=" + path;
    //GMT(Greenwich Mean Time)是格林尼治平时，现在的标准时间，协调世界时是UTC
    //参数days只能是数字型
    var _expires = (typeof days) == "string" ? "" : ";expires=" + expires.toUTCString();
    document.cookie = name + "=" + value + _expires + path;
}

function getCookieValue(name) { /**获取cookie的值，根据cookie的键获取值**/
    //用处理字符串的方式查找到key对应value
    var name = escape(name);
    //读cookie属性，这将返回文档的所有cookie
    var allcookies = document.cookie;
    //查找名为name的cookie的开始位置
    name += "=";
    var pos = allcookies.indexOf(name);
    //如果找到了具有该名字的cookie，那么提取并使用它的值
    if (pos != -1) { //如果pos值为-1则说明搜索"version="失败
        var start = pos + name.length; //cookie值开始的位置
        var end = allcookies.indexOf(";", start); //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置
        if (end == -1) end = allcookies.length; //如果end值为-1说明cookie列表里只有一个cookie
        var value = allcookies.substring(start, end); //提取cookie的值
        return (value); //对它解码
    } else { //搜索失败，返回空字符串
        return "";
    }
}

function deleteCookie(name, path) { /**根据cookie的键，删除cookie，其实就是设置其失效**/
    var name = escape(name);
    var expires = new Date(0);
    path = path == "" ? "" : ";path=" + path;
    document.cookie = name + "=" + ";expires=" + expires.toUTCString() + path;
}

function checkCookie() {
    var userNameValue = getCookieValue("userName");
    var userPassValue = getCookieValue("userPass");
    var userId = getCookieValue("userId");
    return {
        username: userNameValue,
        password: userPassValue,
        userid: userId
    }
}

function userLogin() {
    var userName = document.getElementById("username").value;
    var userPass = document.getElementById("password").value;
    var user_data = {}
    user_data.username = userName
    user_data.password = userPass
    // var login_url = "http://100.64.3.181:8080/expert/login"
    var login_url = "/login"
        // window.location.href = "design.html";
    $.ajax({
        type: "POST",
        url: login_url,
        // jsonp:"callback",
        header: {
            'content-type': 'application/json'
        },
        // contentType: "application/json; charset=utf-8",
        data: user_data,
        success: function(data) {
            var results = data.results
            if (results.auth == true) {
                console.log("login successfully")
                addCookie("userName", results.user.userName, 7, "/");
                addCookie("userPass", results.user.password, 7, "/");
                addCookie("userId", results.user.userId, 7, "/");
                window.location.href = "/design";
            } else {
                $("#login-note").text("Wrong username or password, please reenter.")
                $("#login-note").css("color", "yellow")
            }

        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            console.log('login error');
            console.log(errorThrown);
            $("#login-note").text("Wrong username or password, please reenter.")
            $("#login-note").css("color", "yellow")
        }
    });
    // addCookie("userName",userName,7,"/");
    // addCookie("userPass",userPass,7,"/");
    // addCookie("userId",1,7,"/");
    // window.location.href = "design.html";
}

$("#login").click(function() {
    userLogin()
})

$(function() {
    $("#password").keydown(function(e) {
        // console.log(e)
        if (e.keyCode == 13) {
            userLogin()
        }
    });
});

$(function() {
    $("#logout").click(function() {
        deleteCookie("userName", "/")
        deleteCookie("userPass", "/")
        deleteCookie("userId", "/")
    })
})