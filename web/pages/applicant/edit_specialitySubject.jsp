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
        <legend style="font-size:150%; color: #306589"><c:out value="${title}"/></legend>

        <form style=" font-size:130%;" method="post" action="controller?command=saveSpecialitySubject">
            <c:choose>
                <c:when test="${specialitySubject ne null}">
                    <span>Profession Id</span>
                    <select class="inp" name="profession1">
                        <c:forEach items="${professions1}" var="profession">
                            <option value="${profession.getId()}">${profession.getProfessionName()}</option>
                        </c:forEach>
                    </select>
                    <span STYLE="margin-left: 250px">Subject Id</span>
                    <select class="inp" name="subject">
                        <c:forEach items="${subjects}" var="subject">
                            <option value="${subject.getId()}">${subject.getSubjectName()}</option>
                        </c:forEach>
                    </select><br/>
                    <input type="hidden" name="SP_SB_ID" value="${specialitySubject.getId()}"/><br/>
                </c:when>
                <c:otherwise>
                    <span>Profession Id</span>
                    <select  class="inp" name="profession1">
                        <c:forEach items="${professions1}" var="profession">
                            <option value="${profession.getId()}">${profession.getProfessionName()}</option>
                        </c:forEach>
                    </select>
                    <span STYLE="margin-left: 250px">Subject Id</span>
                    <select  class="inp" name="subject">
                        <c:forEach items="${subjects}" var="subject">
                            <option value="${subject.getId()}">${subject.getSubjectName()}</option>
                        </c:forEach>
                    </select><br/>
                </c:otherwise>
            </c:choose>
            <input type="submit" value="Save"style= background-color:#47698d;color:white;font-size:20px;/>
        </form>
    </fieldset>
</div>
</body>
</html>
