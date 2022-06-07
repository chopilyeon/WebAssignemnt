<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@ page import="java.sql.*" %>
<%@ page import="kr.ac.kopo.util.ConnectionFactory" %>    
    
    
    
    

 <%
  Connection conn = new ConnectionFactory().getConnection();
  StringBuilder sql = new StringBuilder();
  sql.append("SELECT ID,NAME,PASSWORD,EMAIL_ID,TEL1,to_char(reg_date,'yyyy-mm-dd') as reg_date");
  sql.append(" from T_MEMBER ");
  
		
  PreparedStatement pstmt = conn.prepareStatement(sql.toString());
  ResultSet rs =pstmt.executeQuery();
  	
 %>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/Assignment/resource/js/jquery-3.6.0.min.js"></script>


</head>
<body>
	<div align ="center">
		<hr>
		<h2>회원정보 조회</h2>
		<hr>
		<table border="1" style="width:80%">
			<tr>
				<th width ="7%">ID</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>이메일</th>
				<th>전화번호></th>
				<th>등록날짜></th>
			</tr>
			
			<%
				while(rs.next()){
					String ID=rs.getString("ID");
					String name=rs.getString("NAME");
					String password=rs.getString("PASSWORD");
					String email_ID=rs.getString("EMAIL_ID");
					String tel=rs.getString("TEL1");
					String reg_date=rs.getString("reg_date");
			
			%>
				<tr>
					<td><%=ID %></td>
					<td><%=name %></td>
					<td><%=password %></td>
					<td><%=email_ID %></td>
					<td><%=tel %></td>
					<td><%=reg_date %></td>
				</tr>
			<%
				}
			%>
			
	
		 </table>
		 <br>
	</div>






</body>
</html>

<%
  JDBCClose.close(pstmt,conn);
%>