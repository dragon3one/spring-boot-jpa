<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
Main Page!
<br>
${name}
    <a href="/page/customerInsert">손님입력</a>
    <br>
    <a href="/page/customerFind">이름 Like 검색</a>
</body>
</html>