<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>员工饱和度</title>
<style>
	.green h1{font-size:24px;float:left;margin: 0 0 20px;font-family: ""Source Sans Pro",sans-serif;}
</style>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<div style="padding:0 20px 10px">
	<div class="alert">
		<div class="green">
			<h1>工作详情</h1>
			<div style="text-align:right;float:right;">
			<button onclick ="location.href='javascript:history.go(-1);'">返回</button>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="widget">
			<div class="content">
				<table id="myTable" border="0" width="100"
					class="table table-bordered table-hover dataTable">
					<thead>
						<tr>
							<th>姓名</th>
							<th>日期</th>
							<th>行为类别</th>
							<th>持续时长</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jobs" items="${list }">
							<tr>
								<td class="avatar">${jobs.mailname }</td>
								<td>${jobs.date }</td>
								<td>${jobs.type }</td>
								<td>${jobs.slot }s</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!--  <select name="status">
    <option value="all" <c:if test="${status eq 'all'}">selected</c:if>>状态</option>
    <option value="notstart" <c:if test="${status == 'notstart'}">selected</c:if>>未开始</option>
    <option value="running" <c:if test="${status eq 'running'}">selected</c:if>>进行中</option>
    <option value="end" <c:if test="${status eq 'end'}">selected</c:if>>已结束</option>
   </select> -->
</body>
</html>
