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
    <%-- background with position absolute --%>
    <div class="brightness-50 absolute inset-0 h-screen bg-fixed bg-cover bg-no-repeat bg-center bg-[url('${background}')]">
    </div>
    <%-- content of page --%>
    <div class="blur-none flex flex-col items-center h-screen mt-2 overflow-hidden">
            <div class="border-8 border-[#4a524d] border-double rounded px-14 py-8 bg-white absolute ">
	            <h1 class="text-black uppercase text-5xl pb-3 font-bold">FIFA World Cup Quatar 2022</h1>
	            <h2 class="text-black text-3xl font-bold">Stadion: ${stadiumName}</h1>
            </div>
            <div class="flex flex-col justify-center items-center h-screen">
            <div class="border-8 border-[#4a524d] border-double rounded px-14 py-8 bg-white">
                <table class="table-auto border-2 ">
                    <tr>
                        <%-- forEach! --%>
                        <th>Nr</th>
                        <th>Voetbalmatch</th>
                        <th>Datum</th>
                        <th>Aftrap</th>
                        <th>Tickets</th>
                    </tr>
		            <c:forEach var="wedstrijdData" items="${wedstrijden}">
		                <tr>
		                    <td>${wedstrijdData.getWedstrijd().getId()}</td>
		                    <td>${wedstrijdData.getWedstrijd().getLanden()[0]}-${wedstrijdData.getWedstrijd().getLanden()[1]}</td>
		                    <td><fmt:formatDate value="${wedstrijdData.getWedstrijd().getDatum()}" pattern= "dd MMMMM"/></td>
		                    <td>${wedstrijdData.getWedstrijd().getUur()}</td>
		                    <td>${wedstrijdData.getTickets()}</td>
		                </tr>
		            </c:forEach>
                </table>
            </div>
        </div>
</body>
