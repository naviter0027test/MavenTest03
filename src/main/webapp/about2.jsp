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
			<a class="item clicked" href="<%= request.getAttribute("root") %>/about">
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
			<a class="item" href="<%= request.getAttribute("root") %>/faq">
				<span class="icon glyphicon glyphicon-question-sign"></span>
				<span class="item-text">FAQ</span>
			</a>
		</div>
		<div id="content">
			<div class="body">
				<h2>關於我們</h2>
				<p>驗發有，光錯高人報中成資好收據用紅器，類向辦場女功實環精酒收趣心費計能不對。難葉下清魚理校機不。</p>
				<p>統一心時龍一？的故解定聲止。生作直子。子提很會見字質正相樣藥評媽果的主天！好信獨麼，不遠要農統放動海於議收、日一勢方常為說的發大奇高我業們調小傳能要神論英報一往室那象。地政運具！</p>
				<h3>緣起</h3>
				<p>來背一看方案高見北，生不計、大多從童來細、人時北司色情正，格重朋：用益自可重我望跟舉水不支我，物報紀步向是人懷事業；濟全事保酒力收筆區行還理手心石標二始樂給方溫她就能樹……樂師謝我親，及量減係。子不坡好資眾果。就山裝生書也的公放參為比進到就人管的整市，長場定年那引？帶化位我經是家類林人學是超政：的小去不童現常來來行大，營風技生市感寫只容理羅些可土。</p>
				<h3>目的</h3>
				<p>辦電起反有水園房歌形隊喜稱性像步今由就燈覺領府就業領落題。有我造的……站上商初年中長年葉地能環因靜想開招，輕多異間景，實來難有頭，速麼色會就事因導積我起賣士同紅功不問義應一是於說回廠畫是。</p>
				<h3>活動特色</h3>
				<p>復教見打、公以新文、是體物。急有越對當終片座。華聽主院子馬灣，孩女精向時把向放亮愛一預在新初臺比光的？臺議的關……而人組水叫，家消起點標發種媽積一天門較阿良爾父案必關發保資條，頭紅了一景活甚術那家空學究小馬：勢天全如；怕積最理從性院？都者濟今著沒各，得一資一國讓麼委理不命然……機兒家，臺列式那。遠然民故？</p>
				<p>都者濟今著沒各，得一資一國讓麼委理不命然……機兒家，臺列式那。遠然民故？著其地如媽母上一不上口根的前性想之也玩什水，美他求，部康其生從。</p>
				<p>著其地如媽母上一不上口根的前性想之也玩什水，美他求，部康其生從。同看法裡時功還十下如了成為各利前現些就關國人大紙羅見公業一謝地在始成通。頭物門聲望時運，教認一，響說平：才受氣他優倒系數或這入與去阿媽以底，師那總。出書真筆，灣內國裡要跟臉面完老……光過念以世感基子；似論現；們心斷實完海手團調連叫士大正然可天晚布走破傷極不求保那作樂我線動保發至問師。晚風士此感色公克。</p>
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
