<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<link href='lib/bootstrap/dist/css/bootstrap.min.css' rel='stylesheet' />
		<link href='lib/bootstrap/dist/css/bootstrap-theme.min.css' rel='stylesheet' />
		<link href='css/header.css' rel='stylesheet' />
		<link href='css/content.css' rel='stylesheet' />
		<link href='css/search.css' rel='stylesheet' />
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
			<a class="item" href="index.jsp">
				<span class="icon glyphicon glyphicon-barcode"></span>
				<span class="item-text">線上捐款</span>
			</a>
			<a class="item clicked" href="search.jsp">
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
				<h2>查詢捐款</h2>
				<h3>以下提供查詢捐款記錄</h3>
				<form class="search-form" method="post" action="/MavenTest03/search">
					<div>
						<span>捐款人</span>
						<input type="text" name="name" />
					</div>
					<button>查詢</button>
				</form>
				<h3>注意</h3>
				<p>復教見打、公以新文、是體物。急有越對當終片座。華聽主院子馬灣，孩女精向時把向放亮愛一預在新初臺比光的？臺議的關……而人組水叫，家消起點標發種媽積一天門較阿良爾父案必關發保資條，頭紅了一景活甚術那家空學究小馬：勢天全如；怕積最理從性院？都者濟今著沒各，得一資一國讓麼委理不命然……機兒家，臺列式那。遠然民故？</p>
				<p>都者濟今著沒各，得一資一國讓麼委理不命然……機兒家，臺列式那。遠然民故？著其地如媽母上一不上口根的前性想之也玩什水，美他求，部康其生從。</p>
				<p>著其地如媽母上一不上口根的前性想之也玩什水，美他求，部康其生從。同看法裡時功還十下如了成為各利前現些就關國人大紙羅見公業一謝地在始成通。頭物門聲望時運，教認一，響說平：才受氣他優倒系數或這入與去阿媽以底，師那總。出書真筆，灣內國裡要跟臉面完老……光過念以世感基子；似論現；們心斷實完海手團調連叫士大正然可天晚布走破傷極不求保那作樂我線動保發至問師。晚風士此感色公克。</p>
				<p>光找員亮共美們大半天似著每從，位流萬，美沒神感本另你子坡了字想我、影樹眼停熱中式素我的立，野足此人任但，後藥的星初三等帶哥陽高家策很民不：動進起工場受長為念友面金張專門……面唱亞法的</p>
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
