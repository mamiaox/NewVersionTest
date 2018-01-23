<%@page import="com.whn.domain.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css">
<style media="screen">
.table {
	text-align: center;
}
</style>
</head>
<body>
	<table class="table table-bordered table-hover">
		<tr class="info">
			<td>姓名</td>
			<td>身份证号码</td>
			<td>性别</td>
			<td>出生日期</td>
			<td>婚姻状况</td>
			<td>配偶姓名</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${aList}" var="person">
			<tr class="info">
				<td>${person.name}</td>
				<td>${person.idnumber}</td>
				<td>
    				<c:choose>
    					<c:when test="${person.sex eq 'unknownsex' }">未知的性别</c:when>
    					<c:when test="${person.sex eq 'man' }">男</c:when>
    					<c:when test="${person.sex eq 'woman' }">女</c:when>
    					<c:when test="${person.sex eq 'unexplainedsex' }">未说明的性别</c:when>
    				</c:choose>
    			</td>
				<td>${person.birth}</td>
				<td>
    				<c:choose>
    					<c:when test="${person.marrage eq 'unmarried' }">未婚</c:when>
    					<c:when test="${person.marrage eq 'firstmarriage' }">初婚</c:when>
    					<c:when test="${person.marrage eq 'remarriage' }">再婚</c:when>
    					<c:when test="${person.marrage eq 'remarry' }">复婚</c:when>
    					<c:when test="${person.marrage eq 'widowed' }">丧偶</c:when>
    					<c:when test="${person.marrage eq 'divorce' }">离婚</c:when>
    					<c:when test="${person.marrage eq 'unexplainedmaritalstatus' }">未说明的婚姻状况</c:when>
    				</c:choose>
    			</td>
				<td>${person.matename}</td>
				<td>
					<!-- <button class="btn btn-primary btn-sm"
					onClick="window.open('../NewVersionTest/jsp/update.jsp', '', 'width=500,height=400 left=400 top=200')">更改</button> -->
					<!-- <a href="${pageContext.request.contextPath }/UpdateServlet?id=${person.id}" onclick="window.open('../NewVersionTest/jsp/update.jsp', '', 'width=500,height=400 left=400 top=200');"><span class="btn btn-primary btn-sm">更改</span></a> -->
					<a href="#" onclick="openUpdate('${person.id}')"><span class="btn btn-primary btn-sm">更改</span></a>
					<a href="${pageContext.request.contextPath }/DeleteServlet?method=doPost&id=${person.id}"><span class="btn btn-primary btn-sm">删除</span></a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" class="danger">
				<button class="btn btn-primary btn-sm"
					onClick="window.open('../NewVersionTest/jsp/add.jsp', '', 'width=500,height=400 left=400 top=200')">增加</button>
			</td>
		</tr>
	</table>
	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/openupdate.js"></script>
</body>
</html>
