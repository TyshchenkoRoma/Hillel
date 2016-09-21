<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="ua.hillel.tyshenko.carRental.model.Client" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <link rel="stylesheet" type="text/css" href='<c:url value="/css/main.css"/>' />
  <link rel="stylesheet" type="text/css" href='<c:url value="/css/input_form.css"/>' />
  <title>Create Client</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<c:if test="${errorString != null}"><p class="error">${errorString}</p></c:if>
<div id="form_container" style="height: 560px;">
  <div id="form_input" style="height: 550px;">
    <form action="${pageContext.request.contextPath}/client_list/edit?id=${client.id}" method="POST" id="subForm">
      <p><strong>EDIT CLIENT ID: #${client.id}</strong></p>
      <div class="form_labels">

        <label for="firstName">First Name</label><br/><input type="text" name="firstName" value="${client.firstName}" id="firstName"/><br/>
        <label for="lastName">Last Name</label><br/><input type="text" name="lastName" value="${client.lastName}" id="lastName"/><br/>
        <label for="birthday">Birthday</label><br/><input type="text" name="birthday" value="${client.birthday}" id="birthday"/><br/>
        <label for="dLNumber">dLNumber</label><br/><input type="text" name="dLNumber" value="${client.dLNumber}" id="dLNumber"/><br/>
        <label for="lengthOfDrivingExperience">Length Of Drv Expr</label><br/><input type="text" name="lengthOfDrivingExperience" value="${client.lengthOfDrivingExperience}" id="lengthOfDrivingExperience"/><br/>

        <br/><input type="submit" value="Submit" id="button"/>
      </div>
    </form>
  </div>
</div>
<jsp:include page="_footer.jsp"/>
</body>
</html>
