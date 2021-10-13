<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<link href='lib/bootstrap/dist/css/bootstrap.min.css' rel='stylesheet' />
		<link href='lib/bootstrap/dist/css/bootstrap-theme.min.css' rel='stylesheet' />
		<link href='css/admin/login.css' rel='stylesheet' />
		<title>管理者</title>
	</head>
	<body>
		<div class="login-form">
			<form method="post" action="admin-login">
				<h2>管理者登入頁面</h2>
				<p><span>帳號:</span><input type="text" name="account" /></p>
				<p><span>密碼:</span><input type="text" name="password" /></p>
				<button>登入</button>
			</form>
		</div>
	</body>
</html>