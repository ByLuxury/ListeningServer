<%--
  Created by IntelliJ IDEA.
  User: zhoushuai
  Date: 24/04/2017
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
out.clear();
String action=request.getParameter("action");
if("login".equals(action)){
    out.print("{\"status\":1,\"token\":\"zhoushuai\"}");
}
    out.print("{\"status\":1,\"token\":\"zhoushuai\"}");


%>