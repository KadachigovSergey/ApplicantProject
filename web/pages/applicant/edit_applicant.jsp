<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html style= background-color:#e3f2ff;>
<head>
    <title><c:out value="${title}"/></title>
    <%@include file="../include/style.jsp" %>
</head>
<body>
<%@include file="../include/template.jsp" %>
<div class="container">
    <fieldset>
        <legend style="font-size:150%; color: #306589;"><c:out value="${title}"/></legend>

        <form style=" font-size:130%;" method="post" action="controller?command=saveApplicant">
            <c:choose>
                <c:when test="${applicant ne null}">
                    <span>First Name</span >
                    <input class="inp" type="text" name="first_name"
                           value="${applicant.getFirstName()}"/><br/>
                    <span>Last Name</span>
                    <input class="inp" type="text" name="last_name" value="${applicant.getLastName()}"/><br/>
                    <span>Profession id</span>
                    <select class="inp" name="profession">
                        <c:forEach items="${professions}" var="profession">
                            <option value="${profession.getId()}">${profession.getProfessionName()}</option>
                        </c:forEach>
                    </select><br/>
                    <span>Entrance Year</span>
                    <input class="inp" type="text" name="entrance_year"
                           value="${applicant.getEntranceYear()}"/>
                    <input type="hidden" name="applicant_id" value="${applicant.getId()}"/><br/>
                </c:when>
                <c:otherwise>
                    <span>First Name</span>
                    <input class="inp" type="text" name="first_name"/><br/>
                    <span>Last Name</span>
                    <input class="inp" type="text" name="last_name"/><br/>
                    <span>Profession</span>
                    <select class="inp" name="profession">
                    <c:forEach items="${professions}" var="profession">
                    <option value="${profession.getId()}">${profession.getProfessionName()}</option>
                    </c:forEach>
                    </select><br/>
                    <span>Entrance Year</span>
                    <input class="inp" type="text" name="entrance_year"/><br/>
                </c:otherwise>
            </c:choose>
            <input type="submit" value="Save" style= background-color:#47698d;color:white;font-size:20px;/>
        </form>
    </fieldset>
</div>
</body>
</html>