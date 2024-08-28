<%@page import="vo.Emp"%>
<%@page import="java.util.List"%>
<%@page import="dao.EmpDao"%>
<%@page import="java.util.Optional"%>
<%@page import="vo.DeptDetail"%>
<%@page import="dao.DeptDao"%>
<%@page import="utils.Utils"%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>애플리케이션</title>
</head>
<body>
<!-- 
	요청 URL
		http://localhost/clonehr/dept/detail.jsp?id=10
	요청 URI
		/clonehr/dept/detail.jsp
	쿼리스트링
		id=10
	요청파라미터 정보
		name		value
		------------------
		"id"		"10"
 -->
<h1>부서 상세정보</h1>
<p>부서의 상세정보와 소속직원 목록을 표시합니다.</p>
<h3>부서 상세정보</h3>
<table border="1" style="width: 90%;">
	<tbody>
	<%
		// 요청파라미터로 전달된 정보를 조회한다.
		String str = request.getParameter("id");
		// 전달된 정보를 Utils.toInt 메소드를 이용해서 int로 변환한다.
		int deptId = Utils.toInt(str);
		
		// DeptDao 객체를 생성해서, getDeptDetail을 호출해 부서 상세정보를 얻어온다.
		DeptDao deptDao = new DeptDao();
		DeptDetail deptDetail = deptDao.getDeptDetail(deptId);
		
		// 아래에서 얻어온 DeptDetail을 뿌려준다.
	%>
		<tr>
			<th>아이디</th><td><%=deptDetail.getDepartmentId() %></td>
			<th>부서명</th><td><%=deptDetail.getDepartmentName() %></td>
		</tr>
		<tr>
			<th>관리자 아이디</th><td><%=deptDetail.getManagerId() %></td>
			<th>관리자 이름</th><td><%=deptDetail.getManagerName() %></td>
		</tr>
		<tr>
			<th>소재지 도시명</th><td><%=deptDetail.getCity() %></td>
			<th>소재지 국가명</th><td><%=deptDetail.getCountryName() %></td>
		</tr>
	</tbody>
</table>

<h3>소속 직원 목록</h3>
<table border="1" style="width : 90%">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>입사일</th>
			<th>직종</th>
			<th>급여</th>
		</tr>
	</thead>
	<tbody>
<%
	// EmpDao 객체를 생성해서, getEmployeesByDeptId 메소드를 호출해서
	// 부서에 해당 하는 모든 직원 목록을 조회하자.
	EmpDao empDao = new EmpDao();
	List<Emp> emps = empDao.getEmployeesByDeptId(deptId);
%>
<%
	if (emps.isEmpty()) { // 해당 부서에 속한 직원이 없으면	
%>
		<tr>
			<td colspan="6">소속된 직원이 없습니다.</td>
		</tr>
<%
	} else {
		for(Emp emp : emps) {
%>
		<tr>
			<td><%=emp.getId() %></td>
			<td><%=emp.getFirstName() %><%=emp.getLastName() %></td>
			<td><%=emp.getPhoneNumber() %></td>
			<td><%=emp.getHireDate() %></td>
			<td><%=emp.getJobId() %></td>
			<td><%=emp.getSalary() %></td>
		</tr>
<%							
		}
	}
%>
	</tbody>
</table>
</body>
</html>