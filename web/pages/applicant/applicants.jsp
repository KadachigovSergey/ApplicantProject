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
        <legend>Applicants</legend>
        <c:choose>
        <c:when test="${applicants.size() == 0}">
            <p><c:out value="No applicants yet"></c:out></p>
        </c:when>
        <c:otherwise>
        <table>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Profession Name</th>
                <th>Entrance Year</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${applicants}" var="applicant">
                <tr style=" font-size:110%;">
                    <td>
                        <c:out value="${applicant.getId()}"/>
                    </td>
                    <td>
                        <c:out value="${applicant.getFirstName()}"/>
                    </td>
                    <td>
                        <c:out value="${applicant.getLastName()}"/>
                    </td>
                    <td>
                        <c:out value="${applicant.getProfessionName()}"/>
                    </td>
                    <td>
                        <c:out value="${applicant.getEntranceYear()}"/>
                    </td>
                    <td>
                        <a style= "color:#2b2b2b;"
                           title="Edit ${applicant.getFirstName()} ${applicant.getLastName()}"
                           href="controller?command=editApplicant&id=${applicant.getId()}">
                            <i class="fa fa-pencil"></i></a>
                        <a style= "color:#2b2b2b;"
                           title="Delete ${applicant.getFirstName()} ${applicant.getLastName()}"
                           href="controller?command=deleteApplicant&id=${applicant.getId()}">
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
        <a href="controller?command=addApplicant">Add new Applicant</a>
    </div>
</div>
</body>
</html>