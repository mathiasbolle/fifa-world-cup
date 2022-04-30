<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
	<title>Fifa World Cup Quatar 2022</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <spring:url value="/img/favicon.ico" var="favicon" />
    <link href="${favicon}" rel="icon" type="image/x-icon" />
</head>
<spring:url value="/img/background_stadium.jpg" var="background" />
<body>
    <%-- background with position absolute --%>
    <div class="brightness-50 absolute inset-0 h-screen bg-fixed bg-cover bg-no-repeat bg-center bg-[url('${background}')]">
    </div>
    <%-- content of page --%>
    <div class="blur-none flex flex-col items-center justify-center h-screen">
        <div class="border-8 border-[#4a524d] border-double rounded px-14 py-8 bg-white flex flex-col items-center">
	    <h1 class="text-black uppercase text-5xl pb-3 font-bold">FIFA World Cup Quatar 2022</h1>
	    <form:form method="POST" modelAttribute="stadiumSelection" class="flex flex-col items-center">
		    <label class="text-black" name="selectedStadium">Stadiums</label>
		    <form:select path="stadiumName" class="mb-2 inline-flex">
		        <c:forEach var="stadium" items="${stadiumList}">
                    <option value="${stadium}">${stadium}</option>
		        </c:forEach>
		    </form:select>
		    </br>
		    <button type="submit" class="px-4 py-2 font-semibold text-sm bg-[#4a524d] text-white rounded-md shadow-sm opacity-100">Voer uit</button>
	    </form:form>
    </div>
    </div>
</body>
