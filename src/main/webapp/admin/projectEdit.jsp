<%@page import="java.util.HashMap"%>
<%@page import="java.lang.Integer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<link href='lib/bootstrap/dist/css/bootstrap.min.css' rel='stylesheet' />
		<link href='lib/bootstrap/dist/css/bootstrap-theme.min.css' rel='stylesheet' />
		<link href='css/admin/header.css' rel='stylesheet' />
		<link href='css/admin/body.css' rel='stylesheet' />
		<title>管理者 - 專案管理</title>
	</head>
	<body>
		<div class="admin-header">
			<span>管理者系統</span>
			<div class="tool-right">
				<a href="admin-logout">登出</a>
			</div>
		</div>
		<div class="admin-menu">
			<div class="menu1">
				<a href="admin-home" class="">
					<span class="glyphicon glyphicon-home"></span>
					首頁
				</a>
			</div>
			<div class="menu1">
				<a href="admin-pass" class="">
					<span class="glyphicon glyphicon-lock"></span>
					密碼更換
				</a>
			</div>
			<div class="menu1">
				<a href="admin-project" class="clicked">
					<span class="glyphicon glyphicon-file"></span>
					專案管理
				</a>
			</div>
			<div class="menu1">
				<a href="admin-donate" class="">
					<span class="glyphicon glyphicon-list-alt"></span>
					捐贈管理
				</a>
			</div>
		</div>
		<div class="admin-content">
			<h3>專案管理 - 編輯</h3>
			<form class="form1" method="post" action="admin-project-edit"  enctype="multipart/form-data">
			<% HashMap<String, String> item = (HashMap<String, String>) request.getAttribute("item"); %>
			<input type="hidden" name="id" value='<%= (String) item.get("id") %>' />
				<h5>標題</h5>
				<p>
                    <input type="text" name="title" required value='<%= (String) item.get("title") %>' /> 
                    <label for="title" class="error col-xs-12"></label>
                </p>
                <h5>描述</h5>
				<p>
                    <input type="text" name="desc" required value='<%= (String) item.get("desc") %>' /> 
                    <label for="desc" class="error col-xs-12"></label>
                </p>
                <h5>圖片</h5>
				<p>
					<img src='<%= (String) item.get("img") %>' />
					更換如下:
                    <input type="file" name="img" /> 
                    <label for="img" class="error col-xs-12"></label>
                </p>
                <h5>金額</h5>
				<p>
                    <input type="number" name="pay" required value='<%= (String) item.get("pay") %>' /> 
                    <label for="pay" class="error col-xs-12"></label>
                </p>
				<button>修改</button>
			</form>
		</div>
	</body>
</html>