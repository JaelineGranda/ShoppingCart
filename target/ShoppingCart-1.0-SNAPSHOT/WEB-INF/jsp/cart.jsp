<%-- 
    Document   : cart
    Created on : Oct 20, 2021, 11:11:08 PM
    Author     : Jaeline
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your Cart: </h1>
        <c:if test="${not empty sessionScope.totalitems}">
        <c:forEach var="c" items="${sessionScope.totalitems}">
            <form method="post" action="/ShoppingCart/store.do">
            <input type="checkbox" name="delete" value="${c.name}"> ${c.name} $${c.price} <br>
        </c:forEach>
            <br>
            <input type="hidden" name="task" value="delete"/>
            <input type="submit" value="Delete from cart"/>
            </form>
        </c:if>
        <br>
        <a href="/ShoppingCart/store?name=books">View books</a>
        <a href="/ShoppingCart/store?name=comps">View computers</a>
        <a href="/ShoppingCart/store?name=music">View music</a>
    </body>
</html>
