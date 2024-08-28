<%@page import="dao.DeptDao"%>
<%@page import="vo.Dept"%>
<%@page import="utils.Utils"%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!-- 
	부서정보 수정에 관한 데이터베이스 작업을 구현하고,
	수정 작업을 마친 이후에는 다시 deptlist를 호출하도록 한다.
	
	요청 URL
		http://localhost/clonehr/dept/update.jsp
	요청 URI
		/clonehr/dept/update.jsp
	폼 데이터
		id=xxx&deptId=xxx&managerId=xxx&locationId=xxx
	요청파라미터 정보
		name			value
		------------------------
		"id"	    	"xxx"
		"deptName"		"xxx"
		"managerId"		"xxx"
		"locationId"	"xxx"
		---------------------
		
	1. 요청 파라미터 정보를 조회한다.
	2. 부서 아이디, 부서명, 관리자 아이디, 소재지 아이디를
		VO 객체에 저장한다.
	3. DAO 객체를 생성해서 VO 객체를 DB에 등록시킨다.
	4. DB 작업이 끝난 후 다시 deptlist를 보여준다.
-->
<%
	// 1. 요청 파라미터 정보를 조회한다.
	int id = Utils.toInt(request.getParameter("id"));
	String deptName = request.getParameter("deptName");
	int managerId = Utils.toInt(request.getParameter("managerId"));
	int locationId = Utils.toInt(request.getParameter("locationId"));
	
	// 2. 부서 아이디, 부서명, 관리자 아이디, 소재지 아이디를
	// VO 객체에 저장한다.
	Dept dept = new Dept();
	dept.setDepartmentId(id);
	dept.setDepartmentName(deptName);
	dept.setManagerId(managerId);
	dept.setLocationId(locationId);
	
	// 3. DAO 객체를 생성해서 VO 객체를 DB에 등록시키는 수정작업
	DeptDao deptDao = new DeptDao();
	deptDao.updateDept(dept);
	
	// 4. DB 작업이 끝난 후 다시 deptlist를 보여주자.
	response.sendRedirect("deptlist.jsp");
	
%>