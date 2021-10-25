<%-- 
    Document   : itemview
    Created on : Oct 18, 2021, 9:56:14 PM
    Author     : Jaeline
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.me.pojo.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Added to Cart</title>
    </head>
    <body>
        <h1>The following item(s) are in your shopping cart</h1>
        
        <c:forEach var="c" items="${requestScope.itemsadded}">
            - ${c.name} $${c.price} <br>
            <br>
        </c:forEach>
            <a href="/ShoppingCart/store?name=books">View books</a>
            <a href="/ShoppingCart/store?name=comps">View computers</a>
            <a href="/ShoppingCart/store?name=music">View music</a>
            <a href="/ShoppingCart/store.do">View Cart</a>
    </body>
</html>
