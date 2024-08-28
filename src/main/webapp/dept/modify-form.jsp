<%@page import="vo.Dept"%>
<%@page import="vo.Emp"%>
<%@page import="dao.EmpDao"%>
<%@page import="vo.DeptDetail"%>
<%@page import="vo.Loc"%>
<%@page import="java.util.List"%>
<%@page import="dao.LocDao"%>
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
<!-- 
	요청 URL
		http://localhost/clonehr/dept/modify-form.jsp?id=xx
	요청 URI
		/clonehr/dept/modify-form
	쿼리 스트링
	 	id=xx
	 요청 파라미터
	 	name	value
	 	-------------
	 	"id"	"xx"
	 	
	 로직짜기
	 1. 요청파라미터 조회를 통해서 부서 아이디를 얻는다.
	 2. 부서 아이디를 바탕으로 
	 	아이디, 부서명, 부서 관리자, 부서 소재지를 얻는다.
	 3. 기본값인 value는 위에서 얻어온 정보를 바탕으로 세팅한다.
	 4. 부서명은 자유롭게 입력 가능하지만,
	    부서 관리자, 부서 소재지는 정해진 범위 중 선택하게 해야한다.
	 	부서 관리자 후보 - employees 테이블에서 전체
	 	부서 소재지 후보 - locations 테이블에서 전체
	 5. 값을 입력하고 나서 수정 버튼을 누르면 DB에 결과가 반영되고
	 6. 반영된 결과를 다시 보여줘야 한다.
-->
<%
	// 1. 요청 파라미터정보를 조회해서 부서 아이디 얻기
	int deptId = Utils.toInt(request.getParameter("id"));
	// 2. 부서 아이디를 통해 아이디, 부서명, 관리자, 소재지 정보 얻기
	DeptDao deptDao = new DeptDao();
	Dept dept = deptDao.getDeptByDeptId(deptId);
	// 3. 입력 가능한 부서 관리자 목록 얻기
	EmpDao empDao = new EmpDao();
	List<Emp> emps = empDao.getAllEmployees();
	// 4. 입력 가능한 소재지 목록 얻기
	LocDao locDao = new LocDao();
	List<Loc> locs = locDao.getAllLocations();
%>
<body>
	<h1>부서정보 수정화면</h1>
	<p>부서이름, 관리자, 소재지를 수정해보세요</p>

	<form method="post" action="update.jsp">
	<div>
		<label>아이디</label><br>
		<input type="text" name="id" value="<%=dept.getDepartmentId() %>" readonly>
	</div>
	<div>
		<label>부서명</label><br>
		<input type="text" name="deptName" value="<%=dept.getDepartmentName()%>">
	</div>
	<div>
		<label>부서 관리자</label><br>
		<select name="managerId">
<%
	// 모든 직원 목록중에서 선택할 수 있도록 option 태그 생성하기
	// 만약에 해당 직원의 id가 부서의 관리자 아이디와 일치하면
	// 그 사람이 해당 부서의 관리자이므로 selected한다. 아니면 패스
	for (Emp emp : emps) {
%>
			<option value="<%=emp.getId()%>"<%=emp.getId() == dept.getManagerId() ? "selected" : "" %>>
				<%=emp.getFirstName() %><%=emp.getLastName() %>
			</option>
<%
	}	
%>
		</select>
	</div>
	<div>
		<label>부서 소재지</label><br>
		<select name="locationId">
<%
	// 모든 소재지 중에서 선택할 수 있도록 option 태그 생성하기
	// 만약 소재지의 소재지 id가 부서의 소재지 id와 일치하면
	// 해당 부서의 소재지이므로 selected한다. 아니면 패스
	for (Loc loc : locs) {
%>
			<option value="<%=loc.getLocationId()%>"<%=loc.getLocationId()==dept.getLocationId()?"selected":"" %>>
				<%=loc.getCity()%>(<%=loc.getCountryId() %>)
			</option>
<%
	}
%>
		</select>
	</div>
	<button type="submit">수정</button>
</form>
</body>
</html>