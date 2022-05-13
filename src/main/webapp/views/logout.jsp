<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<head>
	<title>Fifa World Cup Quatar 2022</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <spring:url value="/img/favicon.ico" var="favicon" />
    <link href="${favicon}" rel="icon" type="image/x-icon" />
</head>

<div class="absolute px-6 py-4 m mb-1 mr-1 bottom-0 left-0 border-4 border-sky-500 border-double bg-white round-lg">
    <a href=/logout><button id="logout" class="px-4 py-2 font-semibold text-sm bg-[#4a524d] text-white rounded-md shadow-sm opacity-100">Logout</button></a>
</dv>
