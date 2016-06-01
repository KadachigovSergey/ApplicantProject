<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html style= background-color:#e3f2ff;>
<head>
    <title></title>
    <%@include file="../include/style.jsp" %>
</head>
<body>
<%@include file="../include/template.jsp" %>
<div class="container">
    <fieldset>
        <legend>ApplicantResults</legend>
        <c:choose>
        <c:when test="${applicantResults.size() == 0}">
            <p><c:out value="No applicantResults yet"></c:out></p>
        </c:when>
        <c:otherwise>
        <table>
            <tr>
                <th>ID</th>
                <th>Applicant ID</th>
                <th>Applicant Last Name</th>
                <th>Subject Name</th>
                <th>Mark</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${applicantResults}" var="applicantResult">
                <tr style=" font-size:110%;">
                    <td>
                        <c:out value="${applicantResult.getId()}"/>
                    </td>
                    <td>
                        <c:out value="${applicantResult.getApplicantId()}"/>
                    </td>
                    <td>
                        <c:out value="${applicantResult.getApplicantName()}"/>
                    </td>
                    <td>
                        <c:out value="${applicantResult.getSubjectName()}"/>
                    </td>
                    <td>
                        <c:out value="${applicantResult.getMark()}"/>
                    </td>
                    <td>
                        <a style= "color:#2b2b2b;"
                           href="controller?command=editApplicantResult&id=${applicantResult.getId()}">
                            <i class="fa fa-pencil"></i></a>
                        <a style= "color:#2b2b2b;"
                           href="controller?command=deleteApplicantResult&id=${applicantResult.getId()}">
                            <i class="fa fa-trash-o"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
    </c:otherwise>
    </c:choose>
    <div class="add_button" style= background-color:#306589;font-size:20px;>
        <i class="fa fa-plus-circle"></i>
        <a href="controller?command=addApplicantResult">Add new Applicant Result</a>
    </div>
</div>
</body>
</html>