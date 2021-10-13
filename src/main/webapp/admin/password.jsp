<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<link href='lib/bootstrap/dist/css/bootstrap.min.css' rel='stylesheet' />
		<link href='lib/bootstrap/dist/css/bootstrap-theme.min.css' rel='stylesheet' />
		<link href='css/admin/header.css' rel='stylesheet' />
		<link href='css/admin/body.css' rel='stylesheet' />
		<title>管理者 - 密碼更改</title>
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
				<a href="admin-pass" class="clicked">
					<span class="glyphicon glyphicon-lock"></span>
					密碼更換
				</a>
			</div>
			<div class="menu1">
				<a href="admin-project" class="">
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
			<h3>密碼更換</h3>
			<form method='post' action='admin-pass' class='form1'>
                <h5>請輸入舊密碼:</h5>
                <p>
                    <input type="password" name="passwordOld" id="passwordOld" required /> 
                    <label for="passwordOld" class="error col-xs-12"></label>
                </p>
                <h5>請輸入新密碼:</h5>
                <p>
                    <input type="password" name="password" id="password" required />
                    <label for="password" class="error col-xs-12"></label>
                </p>
                <h5>請輸入新密碼:</h5>
                <p>
                    <input type="password" name="passwordConfirm" id="passwordConfirm" required />
                    <label for="passwordConfirm" class="error col-xs-12"></label>
                </p>
                <p class="loginBtnP"> <button class="btn">更改</button> </p>
            </form>
		</div>
	</body>
</html>