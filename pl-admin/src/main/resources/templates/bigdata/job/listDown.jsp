<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>员工饱和度减法(全天)</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/jedate/jedate.js"></script>
<style>
.green h1 {
	font-size: 24px;
	margin: 0 0 20px;
	font-family: "" Source Sans Pro ", sans-serif;
}
.selectStyle{height: 30px;width: 170px;margin:0 10px 2px 0;border: 1px solid #A9A9A9;}
.black_overlay {
	display: none;
	position: absolute;top: 0%;left: 0%;width: 100%;height: 100%;background-color: #000;z-index: 1001;-moz-opacity: 0.3;opacity: 0.3;filter: alpha(opacity = 30);}
.white_content {
	display: none;
	position: absolute;top: 30%;left: 42%;width: 20%;height:140px; background-color: white;z-index: 1002;margin-left: -110px;margin-top: -70px;}
.guanbi {cursor: pointer;position: absolute;z-index: 999;top:-8px;right: -6px;}
.guanbi img {width: 22px;height: 22px;}
.centerTsWrap{margin-top: 50px;}
.verify{margin:10px 10px;width:35%; height:25px;background: #357CA5;color: #fff;cursor: pointer;border:1px solid #357CA5;}
.cancel{color: #a1a1a1;background: #fff;border:1px solid #ccc;}
.centerButtonWrap{text-align: center;}
</style>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="Resources/js/jquery-1.11.3.min.js"></script>
<script src="bootstrap-3.3.0/dist/js/bootstrap.min.js"></script>
<script src="Resources/js/bootstrap-paginator.js"></script>
<script>
$(function(){
	$("#mySelect").change(function(){
		 var href = $(this).children('option:selected').val();
		 if(href!=""){
		 window.location.href=href;
		 }
		});
});
function detail(mailname,date){
	window.location = "${pageContext.request.contextPath}/lookDownDetails.do?mailname="+mailname+"&date="+date;
}
</script>
</head>
<body style="min-height:350px">
<div style="padding:0 20px 10px;">
	<div class="alert">
		<div class="green">
			<h1>工作饱和度列表(减法_8:30-17:30)</h1>
			<form method="post" action="jobStaDownGetDetailCtrl.do">
				<div class="selectWrap">
					部门：<select class="selectStyle" id="department" name="department">
                           <option value="">请选择部门</option>
                        <c:forEach items="${depts}" var="dept">
                           <option value="${dept.id}">${dept.department}</option>
                        </c:forEach>
                        </select> 
                        <span style="margin-left:10px;">员工：</span>
					    <select class="selectStyle" id="employee" name="mailname">
                           <option value="">请选择员工</option>
                        </select><span style="margin-left:10px;">日期：</span>
                        <input id="startime" name="startime" formate="yyyyMMdd" style="width:190px" placeholder="开始日期" readonly> - 
					<input id="endtime" name="endtime" formate="yyyyMMdd" style="width:190px" placeholder="结束日期" readonly>
					<button id="saveButton" type="submit" value="查询">查询</button>
				</div>
			</form>
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
							<th>饱和度</th>
						<!--  <th>操作</th> -->
						</tr>
					</thead>
					<tbody>
						<c:forEach var="jobs" items="${list }">
							<tr>
								<td class="avatar">${jobs.mailname }</td>
								<td>${jobs.date }</td>
								<td><fmt:formatNumber maxFractionDigits="2" value="${jobs.saturability*100 }"></fmt:formatNumber>%</td>
								
								<%-- <c:if test="${jos.mailname!='admin' }">
									<td><a onclick="detail('${jobs.mailname }','${jobs.date}')">详细信息</a> 
									</td>
								</c:if> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		共${totalRecord }条记录，共${page.totalPage }页，当前第${page.currentPage}页     
	   <ul class="pager">
	    <li><a href="jobSatDownListCtrl.do?pageNum=0" >首页</a>  </li>
	   	<li><a href="jobSatDownListCtrl.do?pageNum=${page.currentPage-1}" >上一页</a></li>
	   	<li>
	   	<select id="mySelect">
             <c:forEach begin="1" end="${page.totalPage}" var="li">
              <option value="jobSatDownListCtrl.do?pageNum=${li}" class="" <c:if test="${pageNum == li}">selected</c:if>>${li}
              </option>
              </c:forEach>
          </select>
	   	</li>
	   	<li><a href="jobSatDownListCtrl.do?pageNum=${page.currentPage+1}" >下一页</a></li>
	   	<li><a href="jobSatDownListCtrl.do?pageNum=${page.totalPage}" >尾页</a></li>
	   </ul>
	</div>
</div>
<script type="text/javascript">
	//选择日期
	jeDate({
		dateCell:"#startime",
		format:"YYYY-MM-DD", 
		isinitVal:false,
		isTime:false, //isClear:false,
		minDate:"2014-09-19 00:00:00",
		okfun:function(val){}
	});
	jeDate({
		dateCell:"#endtime",
		format:"YYYY-MM-DD", 
		isinitVal:false,
		isTime:false, //isClear:false,
		minDate:"2014-09-19 00:00:00",
		okfun:function(val){}
	});
	$(function() {
		$("#department").change(function(){
			$("#employee option:not(:first)").remove();
			var department = $(this).val();
			if(department != ""){
				var selectval = $('#department').val();
				var url1 = "listEmps.do?id="+selectval;
				var args = {"department_id":employee,"time":new Date()};
				$.ajax({
					type:"post",
					url:url1,
					dataType:"json",
					success:function(data){
						var emps=eval(data);
						if(emps.length==0){
							alert("该部门没有员工");
						}else{                  
							for(var i=0;i<emps.length;i++){
								var mail_name=emps[i].mail_name;
								var cn_name=emps[i].cn_name;						
								$("#employee").append("<option value='"+cn_name+"'>"+cn_name+"</option>");
							}
						}
					}
				});
				}
		});
	});
</script>
</body>
</html>

