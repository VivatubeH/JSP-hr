<%@page import="vo.DeptList"%>
<%@page import="java.util.List"%>
<%@page import="dao.DeptDao"%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>부서목록 조회하기</title>
</head>
<body>
<div class="text-center">
<h1>부서목록</h1>
<p>전체 부서목록을 제공합니다.</p>
</div>
<table border="1" style="width: 60%;">
	<thead>
		<tr>
			<th>부서아이디</th>
			<th>부서명</th>
			<th>부서관리자</th>
			<th>소재지</th>
			<th>소속직원수</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
<%
	DeptDao deptDao = new DeptDao();
	List<DeptList> deptlists = deptDao.getAllDeptLists();
%>
	<tbody>
<%
	for (DeptList deptlist : deptlists) {
%>
		<tr>
		<td><%=deptlist.getId() %></td>
		<td><a href="detail.jsp?id=<%=deptlist.getId()%>"><%=deptlist.getDepartmentName() %></a></td>
		<td><%=deptlist.getManagerName() %></td>
		<td><%=deptlist.getCity() %></td>
		<td><%=deptlist.getCnt() %></td>
		<td><a href="modify-form.jsp?id=<%=deptlist.getId()%>">수정</a></td>
		<td><a href="delete-form.jsp?id=<%=deptlist.getId()%>">삭제</a></td>
		</tr>
<%
	}

%>
	</tbody>
</table>
</body>
</html>