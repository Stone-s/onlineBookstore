<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>
    <script>
        <!--页面加载结束-->
        $(function () {
            $("#sub_btn").click(function () {
                //    校验用户名 要求5-12个字符 由字母和下划线组成
                var userName = $("#username").val();
                //    创建正则表达式  正则表达式是不用添加引号的
                var usernamePatt = /^\w{5,12}$/;
                var isRight = usernamePatt.test(userName);
                if (!isRight) {
                    //提示用户错误信息  元素名类名
                    $("span.errorMsg").text("用户名不合法,请重新输入!");
                    return false;
                }
                //    校验密码 要求5-12个字符 由字母和下划线组成
                var password = $("#password").val();
                //    创建正则表达式  正则表达式是不用添加引号的
                var passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(password)) {
                    //提示用户错误信息  元素名类名
                    $("span.errorMsg").text("密码不合法,请重新输入!");
                    return false;
                }
                //  验证确认密码 不一致,提示用户错误信息
                var repwd = $("#repwd").val();
                if (repwd != password) {
                    $("span.errorMsg").text("两次密码输入不一致!");
                    return false;
                }
                //验证邮箱
                var emailPatt = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
                var emailText = $("#email").val();
                if (!emailPatt.test(emailText)) {
                    $("span.errorMsg").text("请输入正确的邮箱!");
                    return false;
                }
                //校验验证码
                var codeText = $("#code").val().trim();
                if (codeText == null || codeText == "") {
                    $("span.errorMsg").text("验证码错误");
                    return false;
                }
                //    校验正确以后,取消显示错误提示信息
                $("span.errorMsg").text("");

            });
        });
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
                        <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="register">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username" value="<%= request.getAttribute("username")==null?"shimin":request.getAttribute("username")%>"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password" value="<%= request.getAttribute("password")==null?"123123":request.getAttribute("password")%>"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd" value="<%= request.getAttribute("password")==null?"123123":request.getAttribute("password")%>"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email"  value="<%= request.getAttribute("email")==null?"123@qq.com":request.getAttribute("email")%>"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 150px;" name="code" id="code" value="123"/>
                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/foot.jsp"%>
</body>
</html>