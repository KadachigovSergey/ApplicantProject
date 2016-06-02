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

        <form style=" font-size:130%;" method="post" action="controller?command=saveSpecialitySubject">
            <c:choose>
                <c:when test="${specialitySubject ne null}">
                    <span>Profession Id</span>
                    <input type="text" name="Profession_id" value="${specialitySubject.professionId}"/><br/>
                    <span>Subject Id</span>
                    <input type="text" name="Subject_id" value="${specialitySubject.getSubjectId()}"/><br/>
                    <input type="hidden" name="SP_SB_ID" value="${specialitySubject.getId()}"/><br/>
                </c:when>
                <c:otherwise>
                    <span>Profession Id</span>
                    <input type="text" name="Profession_id"/><br/>
                    <span>Subject Id</span>
                    <input type="text" name="Subject_id"/><br/>
                </c:otherwise>
            </c:choose>
            <input type="submit" value="Save"style= background-color:#306589;color:white;font-size:20px;/>
        </form>
    </fieldset>
</div>
</body>
</html>
