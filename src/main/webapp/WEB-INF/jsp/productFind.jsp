<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>상품 검색</title>
</head>

<script>
    function search(id){
        var location = "/";

        switch (id) {
            case "findAll":
                location = "/product/findAll";
                break;
            case "insert":
                location = "/product/insert";
                break;
            case "findAllSort":
                location = "/product/findAllSort";
                break;
            case "findAllPage":
                location = "/product/findAllPage";
                break;
        }
        document.getElementsByTagName("form")[0].action = location;
        document.getElementsByTagName("form")[0].submit();
    }

</script>
<body>
    상품 검색 페이지
    <br>
    <form action="" method="post">

        KEYWORD <input type="text" name="keyword" value="">
        <br>
        name <input type="text" name="name" value="">
        <br>
        PRICE <input type="text" name="price" value="">
        <br>
        ID <input type="text" name="id" value="">
        <br>
        page <input type="text" name="page" value="0">
        </form>
    <input type="button" onclick="search('insert')" value="insert">
    <input type="button" onclick="search('findAll')" value="findAll">
    <input type="button" onclick="search('findAllPage')" value="findAllPage">
    <input type="button" onclick="search('findAllSort')" value="findAllSort">

</body>
</html>