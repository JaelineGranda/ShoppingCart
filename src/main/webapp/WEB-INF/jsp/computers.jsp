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
        <title>Shopping</title>
    </head>
    <body>
        <h1>Shop for Computers</h1>
        <form method="post" action="/ShoppingCart/store.do">
        <c:forEach var="c" items="${applicationScope.computers}">
            <input type="checkbox" name="item" value="${c.name}">${c.name} -$${c.price}<br>
            <input type="hidden" name="price" value="${c.price}">
        </c:forEach>
            <br>
            <input type="submit" value="Add to cart"/>
            <input type="hidden" name="task" value="add"/>
        </form>
        <br>
        <br>
        <a href="/ShoppingCart/store?name=books">View books</a>
        <a href="/ShoppingCart/store?name=comps">View computers</a>
        <a href="/ShoppingCart/store?name=music">View music</a>
        <a href="/ShoppingCart/store.do">View Cart</a>
    </body>
</html>