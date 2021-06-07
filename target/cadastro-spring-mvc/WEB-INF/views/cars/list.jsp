<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Carros</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
</head>
<body>
	<div class="container">
	    <h1>Lista de Carros</h1>
	    <hr>
	    <div>
			<spring:url value="/carro/cadastro" var="cadastro"/>
	        <a class="btn btn-default" href="${cadastro}">Novo carro</a>
	    </div>
	    <hr>
	
	    <div class="${message == null ? 'panel-default' : 'panel-success'}">
	
	        <div class="panel-heading">
	            <span>${message == null ? '&nbsp;' : message}</span>
	        </div>
	
	        <table class="table table-striped table-condensed">
	            <thead>
	            <tr>
	                <th>Id</th>
	                <th>Carro</th>
	                <th>Ação</th>
	            </tr>
	            </thead>
	            <tbody>
	            <c:forEach var="carro" items="${carros}">
	                <tr>
	                    <td>${carro.id}</td>
	                    <td>${carro.marca}&nbsp;${carro.modelo}</td>
	                    <td>
	                    	<spring:url value="/carro/update/${carro.id}" var="update"/>
	                        <a class="btn btn-info" href="${update}">Editar</a>
	                        <spring:url value="/carro/delete/${carro.id}" var="delete"/>
	                        <a class="btn btn-danger" href="${delete}">Excluir</a>
	                    </td>
	                </tr>
	            </c:forEach>
	            </tbody>
	        </table>
	    </div>
	    <hr>
	    <footer class="footer">
	        <p>&copy; 2021 TheMykael</p>
	    </footer>
	</div>
</body>
</html>