<%@page import="vo.Emp"%>
<%@page import="java.util.List"%>
<%@page import="dao.EmpDao"%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>직원 목록</title>
</head>
<body>
<!-- 
	요청 URL
		http://localhost/clonehr/emp/emplist.jsp
	요청 URI
		/clonehr/emp/emplist.jsp
	쿼리 스트링 x
	폼 데이터 x
	요청 파라미터 정보 x
 -->
<h1>전체 직원 목록</h1>
<p>전체 직원 목록을 확인하세요.</p>
<table border="1" style="width: 80%">
	<thead>
		<tr>
			<th>아이디</th>	
			<th>이름</th>	
			<th>이메일</th>	
			<th>연락처</th>	
			<th></th>	
		</tr>
	</thead>
	<tbody>
<%
	// 1. EmpDao의 모든 직원 목록 조회 메소드 사용을 위해
	// EmpDao 객체를 생성한다.
	EmpDao empDao = new EmpDao();	
	// 2. empDao 메서드를 통해서 직원 리스트를 조회한다.
	List<Emp> emps = empDao.getAllEmployees();
%>
<%
	// 3. DB에서 조회한 직원 리스트를 목록에서 보여준다.
	for (Emp emp : emps) {
%>
		<tr>
			<td><%=emp.getId() %></td>
			<td><a href="detail.jsp?id=<%=emp.getId()%>"><%=emp.getFirstName() %><%=emp.getLastName() %></a></td>
			<td><%=emp.getEmail() %></td>
			<td><%=emp.getPhoneNumber() %></td>
			<td><a href="modify-form.jsp">수정</a></td>
		</tr>
<%
	}
%>
<%

%>
	</tbody>
</table>
</body>
</html>