<%@page import="utils.Utils"%>
<%@page import="dao.DeptDao"%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!-- 
	요청 URL
		http://localhost/clonehr/dept/delete-form.jsp?id=xxx
	요청 URI
		/clonehr/dept/delete-form.jsp
	쿼리스트링
		id=xxx
	폼 데이터
		x
	요청 파라미터
		name		value
		------------------
		"id"		"xxx"
		------------------
	
	1. 요청 파라미터값인 id를 조회한다.
	2. 조회한 부서 아이디를 바탕으로 DeptDao에서 부서를 삭제하는 메소드 실행
	3. 실행 이후 다시 부서 목록 창으로 돌아온다.	
-->
<%
	// 1. 요청 파라미터값인 id를 조회하기
	int id = Utils.toInt(request.getParameter("id"));

	// 2. 조회한 부서 아이디를 바탕으로 DeptDao에서 부서 삭제 메소드 실행
	DeptDao deptDao = new DeptDao();
	deptDao.deleteDept(id);
	
	// 3. 실행 이후 다시 부서 목록 창으로 돌아오기
	response.sendRedirect("deptlist.jsp");
%>