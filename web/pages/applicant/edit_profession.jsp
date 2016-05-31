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

        <form method="post" action="controller?command=saveProfession">
            <c:choose>
                <c:when test="${profession ne null}">
                    <span style=" font-size:110%;" >Profession Name</span>
                    <input style=" font-size:107%;" type="text" name="profession_name"
                           value="${profession.getProfessionName()}"/><br/>
                    <input type="hidden" name="profession_id" value="${profession.getId()}"/><br/>
                </c:when>
                <c:otherwise>
                    <span style=" font-size:110%;" >Profession Name</span>
                    <input style=" font-size:107%;" type="text" name="profession_name"/><br/>

                </c:otherwise>
            </c:choose>
            <input type="submit" value="Save"style= background-color:#306589;color:white;font-size:20px;/>
        </form>
    </fieldset>
</div>
</body>
</html>
