<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table class="new-table">
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
		</tr>
	</c:forEach>


</table>