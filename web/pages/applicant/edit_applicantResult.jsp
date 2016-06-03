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

        <form style=" font-size:130%;" method="post" action="controller?command=saveApplicantResult">
            <c:choose>
                <c:when test="${applicantResult ne null}">
                    <span>Applicant ID</span>
                    <input class="inp" type="text" name="applicant_id" value="${applicantResult.getApplicantId()}"/><br/>
                    <span>Subject ID</span>
                    <input class="inp" type="text" name="subject_id" value="${applicantResult.getSubjectId()}"/><br/>
                    <span>Marc</span>
                    <input class="inp" type="text" name="mark" value="${applicantResult.getMark()}"/><br/>
                    <input type="hidden" name="applicant_result_id" value="${applicantResult.getId()}"/><br/>
                </c:when>
                <c:otherwise>
                    <span>Applicant ID</span>
                    <input class="inp" type="text" name="applicant_id"/><br/>
                    <span>Subject ID</span>
                    <input class="inp" type="text" name="subject_id"/><br/>
                    <span>Mark</span>
                    <input class="inp" type="text" name="mark"/><br/>
                </c:otherwise>
            </c:choose>
            <input type="submit" value="Save"style= background-color:#47698d;color:white;font-size:20px;/>
        </form>
    </fieldset>
</div>
</body>
</html>