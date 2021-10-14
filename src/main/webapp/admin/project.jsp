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
			<h3>專案管理</h3>
			<table class="table1">
                <thead>
                    <tr>
                        <td>標題</td>
                        <td>一次捐贈金</td>
                        <td>建立日期</td>
                        <td>修改日期</td>
                        <td>操作</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>慈善A</td>
                        <td>500</td>
                        <td>2021-10-04 14:03:27</td>
                        <td>2021-10-04 14:03:27</td>
                        <td>
                            <a href='admin-project-edit?pid=8953' class="glyphicon glyphicon-pencil"></a>
                            <a href='admin-project-remove?pid=8953' class="glyphicon glyphicon-remove recordRemove"></a>
                        </td>
                    </tr>
                                    <tr>
                        <td>慈善B</td>
                        <td>4200</td>
                        <td>2021-09-29 13:52:05</td>
                        <td>2021-09-29 13:52:05</td>
                        <td>
                            <a href='admin-project-edit?pid=8952' class="glyphicon glyphicon-pencil"></a>
                            <a href='admin-project-remove?pid=8952' class="glyphicon glyphicon-remove recordRemove"></a>
                        </td>
                    </tr>
                </tbody>
            </table>

            <div class="pagination paginationCenter">
            	<label>1</label>
            </div>
		</div>
	</body>
</html>