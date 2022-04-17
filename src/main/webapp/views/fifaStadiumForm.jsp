<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<head>
	<title>Fifa World Cup Quatar 2022</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<spring:url value="/img/background_stadium.jpg" var="background" />
<body>
    <%-- background with position absolute --%>
    <div class="brightness-50 absolute inset-0 h-screen bg-fixed bg-cover bg-no-repeat bg-center bg-[url('${background}')]">
    </div>
    <%-- content of page --%>
    <div class="blur-none flex flex-col items-center justify-center h-screen">
        <div class="border-2 rounded px-14 py-8 bg-white">
	    <h1 class="text-black uppercase text-5xl pb-3 font-bold">FIFA World Cup Quatar 2022</h1>
	    <form:form method="GET">
		    <label class="text-black">Stadiums</label>
		    <select name="stadiums">
		    </select>
		    </br>
		    <button type="submit" class="px-4 py-2 font-semibold text-sm bg-sky-500 text-white rounded-md shadow-sm opacity-100">Voer uit</button>
	    </form:form>
    </div>
    </div>
</body>
