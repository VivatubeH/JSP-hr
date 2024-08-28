<%@page import="vo.Job"%>
<%@page import="java.util.List"%>
<%@page import="dao.JobDao"%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>직종목록</title>
</head>
<body>
<!-- 
	요청 URL
		http://localhost/clonehr/job/jobslist.jsp
	요청 URI
		/clonehr/job/jobslist.jsp
	쿼리스트링 및 폼 데이터 : 없음
	요청 파라미터 : 없음
 -->
<h1>직종목록</h1>
<p>전체 직종목록을 표시합니다.</p>
<table border="1" style="width : 90%;">
	<thead>
		<tr>
			<th>아이디</th>
			<th>제목</th>
			<th>최소급여</th>
			<th>최대급여</th>
		</tr>
	</thead>
	<tbody>
<%
	// 1. 직종목록 조회를 위한 DAO 객체 생성
	JobDao jobDao = new JobDao();
	// 2. DAO 객체의 메소드를 통해 VO 객체 List를 얻어온다.
	List<Job> jobs = jobDao.getAllJobLists();
%>
<%
	// 3. 얻어온 List를 <td> 태그 내의 데이터로 뿌려준다.
	for (Job job : jobs) { 
%>
		<tr>
			<td><%=job.getJobId() %></td>
			<td><%=job.getJobTitle() %></td>
			<td><%=job.getMinSalary() %></td>
			<td><%=job.getMaxSalary() %></td>
		</tr>
<%
	}
%>
	</tbody>
</table>
</body>
</html>