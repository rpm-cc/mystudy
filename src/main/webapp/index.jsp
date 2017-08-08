<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<body>
<%
    // 重定向到新地址
    String site = new String("/login");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
%>
</body>
</html>
