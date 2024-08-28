<%@page import="vo.EmpSalary"%>
<%@page import="vo.DeptDetail"%>
<%@page import="dao.DeptDao"%>
<%@page import="vo.Emp"%>
<%@page import="utils.Utils"%>
<%@page import="dao.EmpDao"%>
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
		http://localhost/clonehr/emp/detail.jsp?id=xxx
	요청 URI
		/clonehr/emp/detail.jsp
	쿼리스트링
		id=xxx
	폼 데이터
		x
	요청파라미터 정보
		name		value
		------------------
		"id"		"xxx"
		------------------
		
	가져와야 할 직원 정보
	: 아이디, 이름, 이메일, 전화번호, 급여, 커미션, 직종, 입사일
	-  EmpDao의 getEmp 메소드 사용한다.
	
	가져와야 할 부서 정보
	: 직원 아이디를 바탕으로 부서 아이디, 부서명, 관리자명, 소재지
	- EmpDao의 getEmp 메서드를 사용해서 부서 아이디를 얻어온다.
	- 얻어온 부서 아이디를 통해 DeptDao의 getDeptDetail 메소드를 호출한다.
	
	가져와야 할 급여 정보
	: 직원 아이디를 바탕으로 급여, 커미션, 연봉, 급여등급
	- EmpDao의 getEmpSalaryByEmpId 메서드를 사용한다.
	 
-->
<%
	// 요청파라미터에서 직원 아이디를 조회한다.
	int empId = Utils.toInt(request.getParameter("id"));
%>
<h1>직원 상세 정보</h1>
<p>직원의 상세정보를 확인하세요</p>

<h3>직원 정보</h3>
<table border="1" style="width : 90%">
	<tbody>
<%
	// EmpDao 메서드 사용을 위해 EmpDao 객체를 생성한다.
	EmpDao empDao = new EmpDao();
	// getEmp 메서드를 통해 직원 정보를 조회한다.
	Emp emp = empDao.getEmp(empId);
	
%>
		<tr>
			<th>아이디</th><td><%=emp.getId() %></td>
			<th>이름</th><td><%=emp.getFirstName() %><%=emp.getLastName() %></td>
		</tr>
		<tr>
			<th>이메일</th><td><%=emp.getEmail() %></td>
			<th>전화번호</th><td><%=emp.getPhoneNumber() %></td>
		</tr>
		<tr>
			<th>급여</th><td><%=emp.getSalary() %></td>
			<th>커미션</th><td><%=emp.getCommissionPct() %></td>
		</tr>
		<tr>
			<th>직종</th><td><%=emp.getJobId() %></td>
			<th>입사일</th><td><%=emp.getHireDate() %></td>
		</tr>
	</tbody>
</table>

<h3>소속 부서 정보</h3>
<table border="1" style="width: 90%">
<%
	// getEmp를 통해 얻어온 Emp 객체에서 부서 아이디를 얻어온다.
	int deptId = emp.getDepartmentId();
	// DeptDao의 getDeptDetail 메소드 사용을 위해 DeptDao 객체 생성한다.
	DeptDao deptDao = new DeptDao();
	// DeptDao의 getDeptDetail 메서드를 호출해서 부서 정보를 얻어온다.
	DeptDetail deptDetail = deptDao.getDeptDetail(deptId);
%>
	<tr>
		<th>부서 아이디</th><td><%=deptDetail.getDepartmentId()%></td>
		<th>부서명</th><td><%=deptDetail.getDepartmentName() %></td>
	</tr>
	<tr>	
		<th>관리자명</th><td><%=deptDetail.getManagerName() %></td>
		<th>소재지</th><td><%=deptDetail.getCity() %></td>
	</tr>
</table>

<h3>급여 상세 정보</h3>
<table border="1" style="width: 90%">
<%
	// empId를 바탕으로 empDao의 getEmpSalaryByEmpId 메서드를 사용한다.
	EmpSalary empSalary = empDao.getEmpSalaryByEmpId(empId);
%>
	<tr>
		<th>급여</th><td><%=empSalary.getSalary() %></td>
		<th>커미션</th><td><%=empSalary.getCommissionPct() %></td>
	</tr>
	<tr>
		<th>연봉</th><td><%=empSalary.getAnnualSalary() %></td>
		<th>급여등급</th><td><%=empSalary.getSalgrade() %></td>
	</tr>
</table>
</body>
</html>