<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>검색</title>
</head>

<script>
    function search(id){
        var location = "/";

        switch (id) {
            case "findAll":
                location = "/customer/findAll";
                break;
            case "like":
                location = "/customer/findNameLike";
                break;
            case "named":
                location = "/customer/Named";
                break;
            case "query":
                location = "/customer/query";
                break;
            case "findById":
                location = "/customer/findById";
                break;
        }
        document.getElementsByTagName("form")[0].action = location;
        document.getElementsByTagName("form")[0].submit();
    }

</script>
<body>
    검색 페이지
    <br>
    <form action="/customer/findNameLike" method="post">

        KEYWORD <input type="text" name="keyword" >
        <br>
        name <input type="text" name="name" >
        <br>
        phone <input type="text" name="phone" >
        <br>
        ID <input type="text" name="id" >

    </form>

    <input type="button" onclick="search('findAll')" value="findAll">
    <input type="button" onclick="search('like')" value="Like 검색 keyword">
    <input type="button" onclick="search('named')" value="Named 검색 keyword">
    <input type="button" onclick="search('query')" value="query 검색 name phone">
    <input type="button" onclick="search('findById')" value="findById">
</body>
</html>