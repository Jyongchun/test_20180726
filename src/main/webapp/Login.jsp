<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<style type="text/css">
		.login{
			width: 100%;
			height: 700px;
			background: black;
			opacity: 0.7;
			position: relative;
		}
		span{
			display: block;
			color: white;
			font-size: 25px;
			text-align: center;
		}
		._1{
			width: 571px;
			height: 125px;

			position: absolute;
			left: 50%;
			transform: translateX(-50%);
			top: 200px;
		}
		#quan{
			font-size: 45px;
		}
		._2{
			width: 576px;
			height: 103px;

			position: absolute;
			left: 50%;
			transform: translateX(-50%);
			top: 325px;
		}
		input{
			width: 150px;
			height: 19px;
			background: black;
			color: white;
			font-size: 15px;
			display: block;
			float: left;
			margin: 15px 15px;
		}
	</style>
</head>
<body>
<div class="login">
	<div class="_1">
		<span id="quan">全民惠</span><br />
		<span>全民惠便利店后台管理系统</span>
	</div>
	<div class="_2">
		<form action="/test/Login.do">
		<input type="text" placeholder="用户名" name="username"/>
		<input type="text" placeholder="密码" name="password"/>
		<input style="height: 25px;" type="submit" value="登录"/></a>
		</form>
	</div>
</div>
</body>
</html>