<%--자바의 import--%>
<%@ page import="com.example.myservlet.domain.Member" %>
<%@ page import="com.example.myservlet.domain.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--자바 코드 입력 <% 자바코드 %>--%>
<%

    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");;
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <%--    자바 코드를 출력하는 부분 <%= 자바 출력코드 입력%>--%>
    <li>id=<%=member.getId()%></li>
    <li>name=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
