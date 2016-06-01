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
        <legend><c:out value="${title}"/></legend>

        <form method="post" action="controller?command=saveApplicant">
            <c:choose>
                <c:when test="${applicant ne null}">
                    <span style=" font-size:110%;" >First Name</span>
                    <input style=" font-size:107%;" type="text" name="first_name"
                           value="${applicant.getFirstName()}"/><br/>
                    <span style=" font-size:110%;" >Last Name</span>
                    <input style="font-size:107%;" type="text" name="last_name" value="${applicant.getLastName()}"/><br/>
                    <span style=" font-size:110%;" >Profession id</span>
                    <input style=" font-size:107%;" type="text" name="profession_id"
                           value="${applicant.getProfessionId()}"/><br/>
                    <span style=" font-size:110%;" >Entrance Year</span>
                    <input style=" font-size:107%;" type="text" name="entrance_year"
                           value="${applicant.getEntranceYear()}"/>
                    <input type="hidden" name="applicant_id" value="${applicant.getId()}"/><br/>
                </c:when>
                <c:otherwise>
                    <span style=" font-size:110%;" >First Name</span>
                    <input style=" font-size:107%;" type="text" name="first_name"/><br/>
                    <span style=" font-size:110%;" >Last Name</span>
                    <input style=" font-size:107%;" type="text" name="last_name"/><br/>
                    <span style=" font-size:110%;" >Profession</span>
                    <input style=" font-size:107%;" type="text" name="profession_id"/><br/>
                    <select>
                    <c:forEach items="${professions}" var="profession">
                    <option value="${profession.getProfessionName()}">${profession.getProfessionName()}</option>
                    </c:forEach>
                    </select><br/>
                    <span style=" font-size:110%;" >Entrance Year</span>
                    <input style=" font-size:107%;" type="text" name="entrance_year"/><br/>
                </c:otherwise>
            </c:choose>
            <input type="submit" value="Save" style= background-color:#306589;color:white;font-size:20px;/>
        </form>
    </fieldset>
</div>
</body>
</html>