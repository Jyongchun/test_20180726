<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
			
			/*
			 * 清除默认样式
			 */
			*{
				margin:0;
				padding:0;
			}
			
			/*
			 * 设置ul
			 */
			.nav{
				/*去除项目符号*/
				list-style: none;
				/*为ul设置一个背景颜色*/
				background-color: cadetblue;
				/*设置一个宽度*/
				/*
				 * 在IE6中，如果为元素指定了一个宽度，则会默认开启hasLayout
				 */
				width: 300px;
				/*设置元素居中*/
				margin: 100px auto;
				/*解决高度塌陷*/
				
			}
			
			/**
			 * 设置li
			 */
			.nav li{
			
				
				
			}
			
			.nav a{
				/*将a转换为块元素*/
				display: block;
				/*为a指定一个宽度*/
				width: 100%;
				/*设置文字居中*/
				text-align: center;
				/*设置一个上下内边距*/
				padding: 5px 0;
				/*去除下划线*/
				text-decoration: none;
				/*设置字体颜色*/
				color: white;
				/*设置加粗*/
				font-weight: bold;
			}
			
			/*
			 * 设置a的鼠标移入的效果
			 */
			.nav a:hover{
				background-color: #c00;
			}
			h1{
				text-align: center;
			}

			._h{
				display: none;
			}
		</style>

</head>
<body>

<!-- 创建导航条的结构 -->
		<ul class="nav">
			<li class="control"><a>商品管理</a></li>
			<li class="_h"><a href="product?operation=2&pageNo=1" target="show">查看商品</a></li>
			<li class="_h"><a href="CategoryPage?pageNo=1" target="show">查看类别</a></li>
			<li ><a href="cartservlet?operation=2" target="show">查看购物车   </a></li>
			<li class="_li"><a href="OrderServlet?operation=2" target="show">查看我的订单</a></li>
			<li class="orderitem" style="display: none"><a>早安,午安，晚安</a></li>

		</ul>
		
</body>
</html>
<script src="../js/jquery-3.3.1.js"></script>
<script>

	$(function () {
		$("._li").click(function () {
			$(".orderitem").toggle(1000)
        })
		$(".control").click(function () {
			$("._h").toggle(1000)
        })
    })

</script>