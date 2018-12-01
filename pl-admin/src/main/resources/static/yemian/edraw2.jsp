<%@page import="com.pl.model.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>echart1</title>
	<style>
			#header{
				color:black;
				text-align:left;
				margin-top:15px;
				height:100px;}

				#main{
				background-color:#CCFFFF;
				color:black;
				text-align:center;
				padding:10px;
				height:850px;}

		</style>
</head>
<body>
<script src="Resources/js/jquery-1.11.3.min.js"></script>
<div id = 'header'>
		<h2 align="center"> 员工评价和画像功能</h2>
			<form action="targetshow.do" method="get">
			<select id="department" name="department_id">
			部门：<option value="">请选择部门</option>
			<c:forEach items="${depts}" var="dept">
			 <option value="${dept.id}">${dept.department}</option>
			</c:forEach>
			</select>
			姓名：<select id="employee" name="employee">
			<option value="">请选择员工姓名</option>
			</select>
			开始月份：<input type="text" name="AaminNo" id = txtBeginDate>
			结束月份：<input type="text" name="AaminNo" id = txtEndDate>
			<input type="submit"></input>
	   </form> 
	</div>	
    <div id="main" ></div><script src="../../plugins/echars/js/echarts-all.js"></script>
	<link href="../../plugins/riqi/css/lyz.calendar.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../../plugins/riqi/js/jquery-1.5.1.js"></script>
    <script src="../../plugins/riqi/js/lyz.calendar.min.js" type="text/javascript"></script>
    <style>
    body {
    font-size: 12px;
    font-family: "微软雅黑", "宋体", "Arial Narrow";
    }
    </style>
    <script>    
            $(function () {
                            $("#txtBeginDate").calendar({
                                controlId: "divDate",                                 // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
                                speed: 200,                                           // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
                                complement: true,                                     // 是否显示日期或年空白处的前后月的补充,默认：true
                                readonly: true,                                       // 目标对象是否设为只读，默认：true
                                upperLimit: new Date(),                               // 日期上限，默认：NaN(不限制)
                                lowerLimit: new Date("2011/01/01"),                   // 日期下限，默认：NaN(不限制)
                                // callback: function () {                               // 点击选择日期后的回调函数
                                //     alert("您选择的日期是：" + $("#txtBeginDate").val());
                                // }
                            });
                            $("#txtEndDate").calendar();
                        });
            </script>
            <script type="text/javascript">
			$(function(){	
				$("#department").change(function(){
					$("#employee option:not(:first)").remove();
					var department = $(this).val()
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
    <script type="text/javascript">
 
               var myChart = echarts.init(document.getElementById('main'));
					var data = [
{"cnName":"蔡卓","department":"AA集团高层","title":"副总经理"},
{"tagName":"公司发帖参与度","tagPid":"07","parentTagName":"归属感与忠诚度","tagValue":"0"},
{"tagName":"公司回帖参与度","tagPid":"07","parentTagName":"归属感与忠诚度","tagValue":"0"},
{"tagName":"调查参与度","tagPid":"07","parentTagName":"归属感与忠诚度","tagValue":"0"},
{"tagName":"发起调查参与度","tagPid":"07","parentTagName":"归属感与忠诚度","tagValue":"0"},
{"tagName":"发起投票参与度","tagPid":"07","parentTagName":"归属感与忠诚度","tagValue":"0"},
{"tagName":"发起投票参与度2","tagPid":"07","parentTagName":"归属感与忠诚度","tagValue":"0"},
{"tagName":"lync通信最多的人","tagPid":"05","parentTagName":"工作圈","tagValue":"zhangyz@hyn.com"},
{"tagName":"lync通信最多的人2","tagPid":"05","parentTagName":"工作圈","tagValue":"zhangyz@hyn.com"},
{"tagName":"lync通信最多的人1","tagPid":"05","parentTagName":"工作圈","tagValue":"zhangyz@hyn.com"}]; 
					var node = [];
                    var link = [];
					var data1=[];
					var data2=[];
					var data3=[];
					var data4=[];
					data4=data[0].cnName;
				for(var i=1;i<data.length;i++){
					data1[i]=data[i].parentTagName;
                    data2[i]=(data[i].tagName+'='+data[i].tagValue);
					data3.push(data1[i]);
					data3.push(data2[i]);
				    
					link.push({
					source : data1[i],
					target : data2[i],
					weight : 1 
				});
					link.push({
						source:data4,
						target :data1[i],
						weight:4
					});
					node.push({
							category:1,
							name : data1[i],
							value : 2,
							});
							node.push({
							category:2,
							name : data2[i],
							value : 1,
							});
				
				}
				node.push({category:0, name:data4, value : 10,
									symbol:'image://../../yemian/images/calendar.jpg',
									symbolSize: 30,
									draggable: true,
									itemStyle: {
										normal: {
											label: {
												position: 'right',
												textStyle: {
													color: 'black'
												}
											}
										}
									}
								})
               
					option = {
						title : {
							text: '员工评价和画像功能',
							
							x:'center',
							y:'top'
						},
						tooltip : {
							trigger: 'item',
							formatter: '{a} : {b}'
						},
						toolbox: {
							show : true,
							feature : {
								restore : {show: true},
								magicType: {show: true, type: ['force', 'chord']},
								saveAsImage : {show: true}
							}
						},
						legend: {
							x: 'left',
							data:['一级标签','二级标签']
						},
						series : [
							{
								type:'force',
								name : "Force tree",
								ribbonType: false,
								gravity: 0.5,
								draggable :false,
								linkSymbol: "arrow",
								categories : [
									{
										name: '一级标签',
										  itemStyle: {
												normal: {
													color : '#ff7f50'
												}
											}
							},
									{
										name: '二级标签',
										  itemStyle: {
												normal: {
													color : '#87cefa'
												}
											}
									}
									
								],
								itemStyle: {
									normal: {
								
										label: {
											show: true,
											 textStyle: {
											 color: '#333'	
												},
										},
										nodeStyle : {
											brushType : 'both',
											borderColor : 'rgba(123,123,123,0.5)',
											borderWidth : 1
										}
									}
								},
								minRadius :15,
								maxRadius : 35,
								coolDown: 0.995,
								steps: 50,
								 nodes:
								     
									
								node,
							
								
								links:link,
							
								steps: 1
							}
						]
					};
									
                    
        myChart.setOption(option);
    </script>
</body>
</html>