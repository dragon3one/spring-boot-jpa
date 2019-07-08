<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--bootstrap--%>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script><!DOCTYPE html>

<style>
    {
         width: 20%;
     }
</style>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>손님등록</title>
</head>
<body>
    <form action="/customer/insert" method="post">
        <span class="input-group-addon" id="basic-addon1">이름</span>
        <input type="text" class="form-control" id="name" name="name" placeholder="name" aria-describedby="basic-addon1">

        <br>

        <span class="input-group-addon" id="basic-addon2"phone>전화</span>
        <input type="text" class="form-control" id="phone" name="phone" placeholder="phone" aria-describedby="basic-addon2">

        <br>

        <button type="submit" class="btn btn-lg btn-primary">Primary</button>
    </form>
</body>
</html>