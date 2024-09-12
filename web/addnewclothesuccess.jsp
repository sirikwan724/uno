<%-- 
    Document   : addnewclothessuccess
    Created on : 18 ก.ค. 2567, 14:10:48
    Author     : Siric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.addclothes" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>Add clothes</h1>
        <%
            addclothes newclothes = (addclothes) session.getAttribute("addclothes");
        %>
        clothesname: <%= newclothes.getclothesname() %><br/>
        clothes: <%= newclothes.getclothes() %><br/>
        site: <%= newclothes.getsite() %><br/>
        colori: <%= newclothes.getcolori() %><br/>
        clothesprice: <%= newclothes.getclothesprice() %><br/>
        <a href="ShowUpdataclothes.jsp">Edit clothes</a>
        <a href="index.html">HOME</a>
    </body>
</html>
