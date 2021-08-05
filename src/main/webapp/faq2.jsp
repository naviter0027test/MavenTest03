<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<link href='lib/bootstrap/dist/css/bootstrap.min.css' rel='stylesheet' />
		<link href='lib/bootstrap/dist/css/bootstrap-theme.min.css' rel='stylesheet' />
		<link href='css/header.css' rel='stylesheet' />
		<link href='css/content.css' rel='stylesheet' />
		<link href='css/faq.css' rel='stylesheet' />
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
			<a class="item" href="<%= request.getAttribute("root") %>/about">
				<span class="icon glyphicon glyphicon-user"></span>
				<span class="item-text">關於我們</span>
			</a>
			<a class="item" href="<%= request.getAttribute("root") %>/index">
				<span class="icon glyphicon glyphicon-barcode"></span>
				<span class="item-text">線上捐款</span>
			</a>
			<a class="item" href="<%= request.getAttribute("root") %>/search">
				<span class="icon glyphicon glyphicon-search"></span>
				<span class="item-text">查詢捐款</span>
			</a>
			<a class="item" href="<%= request.getAttribute("root") %>/list">
				<span class="icon glyphicon glyphicon-list-alt"></span>
				<span class="item-text">芳名錄</span>
			</a>
			<a class="item clicked" href="<%= request.getAttribute("root") %>/faq">
				<span class="icon glyphicon glyphicon-question-sign"></span>
				<span class="item-text">FAQ</span>
			</a>
		</div>
		<div id="content">
			<div class="body">
				<h2>FAQ</h2>
				<div class="faq">
					<p class="q">Q : 受助學生從哪來?</p>
					<p class="a">本活動助學對象，包含經濟弱勢、單親、失親、隔代教養等高風險家庭之學生（國小、國中及高中職）。透過學校老師協助提出申請，經本會審核通過者。每位學生每月接受助學金600元，為期一年；一年到期重新評估，如仍有需求再提出申請。</p>
				</div>
				<hr />
				<div class="faq">
					<p class="q">Q : 受助學生從哪來?</p>
					<p class="a">本活動助學對象，包含經濟弱勢、單親、失親、隔代教養等高風險家庭之學生（國小、國中及高中職）。透過學校老師協助提出申請，經本會審核通過者。每位學生每月接受助學金600元，為期一年；一年到期重新評估，如仍有需求再提出申請。</p>
				</div>
				<hr />
				<div class="faq">
					<p class="q">Q : 受助學生從哪來?</p>
					<p class="a">本活動助學對象，包含經濟弱勢、單親、失親、隔代教養等高風險家庭之學生（國小、國中及高中職）。透過學校老師協助提出申請，經本會審核通過者。每位學生每月接受助學金600元，為期一年；一年到期重新評估，如仍有需求再提出申請。</p>
				</div>
				<hr />
				<div class="faq">
					<p class="q">Q : 受助學生從哪來?</p>
					<p class="a">本活動助學對象，包含經濟弱勢、單親、失親、隔代教養等高風險家庭之學生（國小、國中及高中職）。透過學校老師協助提出申請，經本會審核通過者。每位學生每月接受助學金600元，為期一年；一年到期重新評估，如仍有需求再提出申請。</p>
				</div>
				<hr />
				<div class="faq">
					<p class="q">Q : 受助學生從哪來?</p>
					<p class="a">本活動助學對象，包含經濟弱勢、單親、失親、隔代教養等高風險家庭之學生（國小、國中及高中職）。透過學校老師協助提出申請，經本會審核通過者。每位學生每月接受助學金600元，為期一年；一年到期重新評估，如仍有需求再提出申請。</p>
				</div>
				<hr />
				<div class="faq">
					<p class="q">Q : 受助學生從哪來?</p>
					<p class="a">本活動助學對象，包含經濟弱勢、單親、失親、隔代教養等高風險家庭之學生（國小、國中及高中職）。透過學校老師協助提出申請，經本會審核通過者。每位學生每月接受助學金600元，為期一年；一年到期重新評估，如仍有需求再提出申請。</p>
				</div>
				<hr />
				<div class="faq">
					<p class="q">Q : 受助學生從哪來?</p>
					<p class="a">本活動助學對象，包含經濟弱勢、單親、失親、隔代教養等高風險家庭之學生（國小、國中及高中職）。透過學校老師協助提出申請，經本會審核通過者。每位學生每月接受助學金600元，為期一年；一年到期重新評估，如仍有需求再提出申請。</p>
				</div>
				<hr />
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
