<%@page import="vo.Loc"%>
<%@page import="dao.LocDao"%>
<%@page import="java.util.List"%>
<%@page import="vo.Emp"%>
<%@page import="dao.EmpDao"%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>신규부서 등록하기</title>
</head>
<body>
<h1>신규 부서 등록 페이지</h1>
<p>부서명, 부서관리자, 부서소재지를 지정하고 새 부서를 등록시킨다.</p>
<%
	// 1. 부서 이름은 자유롭게 입력할 수 있게 한다.
	// 2. 부서 관리자와 소재지는 정해진 목록중에 입력하도록 한다.
	// 	- 부서 관리자 후보는 employees에서 조회해오는 메소드
	//	- 부서 소재지 후보는 locations에서 조회해오는 메소드
	// 3. 등록버튼을 누르면 insert.jsp가 호출되도록 한다.
	
	// 2-1 . 부서 관리자 후보 조회를 위한 DAO 생성 및 메서드 실행
	EmpDao empDao = new EmpDao();
	List<Emp> emps = empDao.getAllEmployees();
	// 2-2. 소재지 후보 조회를 위한 DAO 생성 및 메서드 실행
	LocDao locDao = new LocDao();
	List<Loc> locs = locDao.getAllLocations();
%>
<form method="post" action="insert.jsp">
	<div>
		<label>부서이름</label><br>
		<input type="text" name="deptName">
	</div>
	<div>
		<label>부서관리자</label><br>
		<select name="managerId">
<%
	// 관리자 후보 리스트들로 option 태그를 만든다.
	for (Emp emp : emps) {
%>
			<option value="<%=emp.getId()%>">
				<%=emp.getFirstName() %><%=emp.getLastName() %>
			</option>
<%
	}
%>
		</select>
	</div>
	<div>
		<label>부서소재지</label><br>
		<select name="locationId">
<%
	// 소재지 후보 리스트들로 option 태그를 만든다.
	for (Loc loc : locs) {
%>
			<option value="<%=loc.getLocationId()%>">
				<%=loc.getCity() %>(<%=loc.getCountryId() %>)
			</option>
<%
	}
%>
		</select>
	</div>
	<div>
		<button type="submit">등록</button>
	</div>
</form>
</body>
</html>