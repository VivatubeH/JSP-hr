<%@page import="dao.DeptDao"%>
<%@page import="vo.Dept"%>
<%@page import="utils.Utils"%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!-- 
	요청 URL	
		http://localhost/clonehr/dept/insert.jsp
	요청 URI
		/clonehr/dept/insert.jsp
	쿼리스트링
		없음
	폼 데이터
		deptName=xxx&managerId=xxx&locationId=xxx
	요청파라미터 정보
		name			value
		----------------------
		"deptName"		"xxx"
		"managerId"		"xxx"
		"locationId"	"xxx"
		----------------------
	1. 요청파라미터 전달받은 정보를 조회한다.
	2. 전달받은 정보를 VO에 저장한다.
	3. VO에 저장한 객체를 DAO를 통해 DB에 등록한다.
	4. 등록한 후에는 deptlist를 보여준다.
-->
<%
	// 1. 요청파라미터 전달받은 정보 조회
	String deptName = request.getParameter("deptName");
	int managerId = Utils.toInt(request.getParameter("managerId"));
	int locationId = Utils.toInt(request.getParameter("locationId"));
	
	// 2. 전달받은 정보를 VO에 저장한다.
	// 부서 아이디는 insert 메서드에서 시퀀스를 통해 입력하도록 한다.
	Dept dept = new Dept();
	dept.setDepartmentName(deptName);
	dept.setManagerId(managerId);
	dept.setLocationId(locationId);
	
	// 3. DAO의 메서드를 통해 DB에 등록한다.
	DeptDao deptDao = new DeptDao();
	deptDao.insertDept(dept);
	
	// 4. 등록 후에 deptlist를 보여주자.
	response.sendRedirect("deptlist.jsp");
%>