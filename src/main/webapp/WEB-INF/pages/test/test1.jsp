<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table class="new-table">
	<h>资料显示<h>
	<tr>
		<th>用户Id</th>
		<th>用户名称</th>
		<th>用户密码</th>
		<th>注册时间</th>
	</tr>
	<c:forEach items="${userList}" var="item">
		<tr>
			<td class="id_1">${item.id}</td>
			<td class="userAccount">${item.userAccount}</td>
			<td class="userPassword">${item.userPassword}</td>
			<td class="regTime"><fmt:formatDate value="${item.regTime}"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</td>
			<td><a href="shishi.do?p=shishis&id=${item.id}"><button type="button">删除</button></a></td>			
		</tr>
		<form class="form-horizontal" role="form" action="/shishi.do?p=shishig" method="post">
		<td><input type="text"  id="firstname" name="userAccount" ></td>
		<td><button type="submit" class="btn btn-default">修改</button></td>	
		</form>		
		</tr>
	</c:forEach>


</table>