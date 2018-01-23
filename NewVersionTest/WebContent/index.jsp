<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/supersized.css">
<link rel="stylesheet" href="css/style.css">
<title>welcome</title>
</head>
<body>

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body oncontextmenu="return false">

        <div class="page-container">
            <h1>hello</h1>
            <form action='<c:url value="/ShowServlet"/>' method="post">
				<div>
					<input type="text" name="username" class="username" value="admin" autocomplete="off"/>
				</div>
                <div>
					<input type="password" name="password" class="password" value="admin" oncontextmenu="return false" onpaste="return false" />
                </div>
                <button id="submit" type="submit">Sign in</button>
            </form>
            <div class="connect">
                <p>where there is a will,there is a way.</p>
				<p style="margin-top:20px;">有志者，事竟成。</p>
            </div>
        </div>
		<div class="alert" style="display:none">
			<h2>消息</h2>
			<div class="alert_con">
				<p id="ts"></p>
				<p style="line-height:70px"><a class="btn">确定</a></p>
			</div>
		</div>

        <!-- Javascript -->
		<script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
        <script src="js/supersized.3.2.7.min.js"></script>
        <script src="js/supersized-init.js"></script>
		<script>
		$(".btn").click(function(){
			is_hide();
		})
		var u = $("input[name=username]");
		var p = $("input[name=password]");
		$("#submit").live('click',function(){
			if(u.val() == '' || p.val() =='')
			{
				$("#ts").html("用户名或密码不能为空~");
				is_show();
				return false;
			}
			else{
				var reg = /^[0-9A-Za-z]+$/;
				if(!reg.exec(u.val()))
				{
					$("#ts").html("用户名错误");
					is_show();
					return false;
				}
			}
		});
		window.onload = function()
		{
			$(".connect p").eq(0).animate({"left":"0%"}, 600);
			$(".connect p").eq(1).animate({"left":"0%"}, 400);
		}
		function is_hide(){ $(".alert").animate({"top":"-40%"}, 300) }
		function is_show(){ $(".alert").show().animate({"top":"45%"}, 300) }
		</script>
    </body>
</html>
</body>
</html>