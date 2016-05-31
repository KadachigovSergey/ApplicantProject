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

        <form style=" font-size:20px;" method="post" action="controller?command=saveApplicantResult">
            <c:choose>
                <c:when test="${applicantResult ne null}">
                    <span style=" font-size:110%;" >Applicant ID</span>
                    <input style=" font-size:107%;" type="text" name="applicant_id" value="${applicantResult.getApplicantId()}"/><br/>
                    <span style=" font-size:110%;" >Subject ID</span>
                    <input style=" font-size:107%;" type="text" name="subject_id" value="${applicantResult.getSubjectId()}"/><br/>
                    <span style=" font-size:110%;" >Marc</span>
                    <input style=" font-size:107%;" type="text" name="mark" value="${applicantResult.getMark()}"/><br/>
                    <input type="hidden" name="applicant_result_id" value="${applicantResult.getId()}"/><br/>
                </c:when>
                <c:otherwise>
                    <span style=" font-size:110%;" >Applicant ID</span>
                    <input style=" font-size:107%;" type="text" name="applicant_id"/><br/>
                    <span style=" font-size:110%;" >Subject ID</span>
                    <input style=" font-size:107%;" type="text" name="subject_id"/><br/>
                    <span style=" font-size:110%;" >Mark</span>
                    <input style=" font-size:107%;" type="text" name="mark"/><br/>
                </c:otherwise>
            </c:choose>
            <input type="submit" value="Save"style= background-color:#306589;color:white;font-size:20px;/>
        </form>
    </fieldset>
</div>
</body>
</html>