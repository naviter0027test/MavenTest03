<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<link href='lib/bootstrap/dist/css/bootstrap.min.css' rel='stylesheet' />
		<link href='lib/bootstrap/dist/css/bootstrap-theme.min.css' rel='stylesheet' />
		<link href='css/header.css' rel='stylesheet' />
		<link href='css/content.css' rel='stylesheet' />
		<title>捐款首頁</title>
	</head>
	<body>
		<div id="header">
			<h1 id="logo">
				<span class="icon glyphicon glyphicon-heart"></span>
				<span class="logo">慈心基金會</span>
			</h1>
		</div>
		<div id="nav">
			<a class="item" href="about.jsp">
				<span class="icon glyphicon glyphicon-user"></span>
				<span class="item-text">關於我們</span>
			</a>
			<a class="item clicked" href="index.jsp">
				<span class="icon glyphicon glyphicon-barcode"></span>
				<span class="item-text">線上捐款</span>
			</a>
			<a class="item" href="search.jsp">
				<span class="icon glyphicon glyphicon-search"></span>
				<span class="item-text">查詢捐款</span>
			</a>
			<a class="item" href="list.jsp">
				<span class="icon glyphicon glyphicon-list-alt"></span>
				<span class="item-text">芳名錄</span>
			</a>
			<a class="item" href="faq.jsp">
				<span class="icon glyphicon glyphicon-question-sign"></span>
				<span class="item-text">FAQ</span>
			</a>
		</div>
		<div id="content">
			<div class="body">
				<h2>線上捐款</h2>
				<div class="product">
					<img src="https://fakeimg.pl/150/" />
					<p>專案名 : 艾蒙專案</p>
					<p>一次捐款金額 : 300 NTD</p>
					<a href="pay.jsp?pid=2">前往捐款</a>
				</div>
				<div class="product">
					<img src="https://fakeimg.pl/150/" />
					<p>專案名 : 艾蒙專案</p>
					<p>一次捐款金額 : 300 NTD</p>
					<a href="pay.jsp?pid=2">前往捐款</a>
				</div>
				<div class="product">
					<img src="https://fakeimg.pl/150/" />
					<p>專案名 : 艾蒙專案</p>
					<p>一次捐款金額 : 300 NTD</p>
					<a href="pay.jsp?pid=2">前往捐款</a>
				</div>
				<div class="product">
					<img src="https://fakeimg.pl/150/" />
					<p>專案名 : 艾蒙專案</p>
					<p>一次捐款金額 : 300 NTD</p>
					<a href="pay.jsp?pid=2">前往捐款</a>
				</div>
				<div class="product">
					<img src="https://fakeimg.pl/150/" />
					<p>專案名 : 艾蒙專案</p>
					<p>一次捐款金額 : 300 NTD</p>
					<a href="pay.jsp?pid=2">前往捐款</a>
				</div>
			</div>
			<div id="footer">
				<h3>洽詢電話：(02) XXXX-XXXX 分機 711、722</h3>
				<h3>傳真：(02) XXXX-XXXX</h3>
				<h3>地址：100000 台北市XX區XX路X段XXX號X樓</h3>
			</div>
		</div>
	</body>
	<script src="lib/jquery-2.1.4.min.js"></script>
	<script>
		$(document).ready(function() {
			console.log('test 我要測試'); 
		});
	</script>
</html>
