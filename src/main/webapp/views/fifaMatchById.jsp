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
<spring:url value="/img/background_stadium.jpg" var="background" />
<body>
            <div class="flex flex-col justify-center items-center h-screen">
            <div class="border-8 border-[#4a524d] border-double rounded px-14 py-8 bg-white">
                <h3>${match_title}</h3>
                <h3>Aantal tickets beschikbaar: ${available_tickets}</h3>
                <form:form method="POST" modelAttribute="purchase">


                    <label>Email:</label>
                    <form:input path="email" size="20"/>
                    <br />

                    <label>Aantal tickets:</label>
                    <form:input value="1" path="amount_tickets" />
                    <br />

                    <label>VoetbalCode1:</label>
                    <form:input value="10" path="voetbalCode_1" />
                    <br />

                    <label>VoetbalCode2</label>
                    <form:input value="20" path="voetbalCode_2" />
                    <br />

		            <button type="submit" class="px-4 py-2 font-semibold text-sm bg-[#4a524d] text-white rounded-md shadow-sm opacity-100">Koop</button>
		            <br/>
                    <form:errors path="*" class="text-red-500" />
                </form:form>
            </div>
        </div>
</body>
