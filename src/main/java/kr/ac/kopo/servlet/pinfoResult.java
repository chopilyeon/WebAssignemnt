package kr.ac.kopo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pinfoResult extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getMethod(); 
		
		String url =request.getRequestURI();
		
		String ID =	request.getParameter("ID");
		String name =	request.getParameter("name");
		String password =	request.getParameter("password");
		String[] gender = request.getParameterValues("gender");
		String[] receive = request.getParameterValues("receive");
		String[] job=request.getParameterValues("job");
		
		response.setContentType("text/html; charset=utf-8"); 
		
		PrintWriter out=response.getWriter();
		
		out.println("<html>"); // out 이 통로를 통해서 html 문서를 넘기겠다는 의미임
		out.println(" <head>");
		out.println("    <title>메소드 요청방식</title>");
		out.println(" </head>");
		out.println(" <body>");
		out.println("<h1> 개인정보 출력 </h1>  <br>");
		out.println("name: "+name+"<br>");
		out.println("ID: "+ID+"<br>");
		out.println("password: "+password+"<br>");
		for(String str:gender) {
			out.println("gender: "+str+"<br>");
		}
		if(Arrays.asList(receive).contains("공지메일")){
			out.println("공지메일: 받음<br>");
		}else {
			out.println("공지메일: 받지 않음<br>");
		}
		if(Arrays.asList(receive).contains("광고메일")){
			out.println("광고메일: 받음<br>");
		}else {
			out.println("광고메일: 받지 않음<br>");
		}
		if(Arrays.asList(receive).contains("배송확인 메일")){
			out.println("배송확인 메일: 받음<br>");
		}else {
			out.println("배송확인 메일: 받지 않음<br>");
		}
		
		
		
		
		for(String str:job) {
			out.println("job: "+ str);
		}
		
		out.println(" </body>");
		out.println("</html");
			
		//id란 속성으로 들어온 value값이 궁금함 
		 System.out.println("요청 Method : "+method);
		 System.out.println("요청 URI" + url);
		 //우리한테 중요한건 uri 
		 //url은 실제 각각의 server가 갖고 있는 요소들을 구분할 수 있는 구분자를 포트 프로토콜 경로들을 포함한 것임 리소스가 진짜 어디에 있는지  
		 //uri 오직 그냥 내 서버내에서 자원들을 구분할 수 있는 경로들을 의미함
		 //server입자에서 Lectureweb밑에 여기저기 있는 자원들을 접근할 수 있는 경로를 표현하는데 프로토콜들과 포트를 포함하느냐 이 차이임. 
		
		
		
		
		
	}
	
	

}
