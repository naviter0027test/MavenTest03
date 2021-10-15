<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
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
			<div class="nav">
				<a href="admin-project-add">新增</a>
			</div>
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
                <% if(request.getAttribute("list") != null) { %>
				<% ArrayList<HashMap> list = (ArrayList<HashMap>) request.getAttribute("list"); %>
				<% for(int i = 0;i < list.size();++i) { %>
				<% HashMap<String, String> item = (HashMap<String, String>) list.get(i); %>
                    <tr>
                        <td><%= (String) item.get("title") %></td>
                        <td><%= (String) item.get("pay") %></td>
                        <td><%= (String) item.get("createdDate") %></td>
                        <td><%= (String) item.get("updatedDate") %></td>
                        <td>
                            <a href='admin-project-edit?pid=<%= (String) item.get("id") %>' class="glyphicon glyphicon-pencil"></a>
                            <a href='admin-project-remove?pid=<%= (String) item.get("id") %>' class="glyphicon glyphicon-remove recordRemove"></a>
                        </td>
                    </tr>
                <% } %>
				<% } %>
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