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
    <fieldset style="font-size:150%; color: #306589">
        <legend>SpecialitySubjects</legend>
        <c:choose>
        <c:when test="${specialitySubjects.size() == 0}">
            <p><c:out value="No SpecialitySubject yet"></c:out></p>
        </c:when>
        <c:otherwise>
        <table>
            <tr>
                <th>ID</th>
                <%--<th>Profession ID</th>--%>
                <th>Profession Name</th>
                <%--<th>Subject ID</th>--%>
                <th>Subject Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${specialitySubjects}" var="specialitySubject">
                <tr style=" font-size:110%;">
                    <td>
                        <c:out value="${specialitySubject.getId()}"/>
                    </td>
                    <%--<td>--%>
                        <%--<c:out value="${specialitySubject.getProfessionId()}"/>--%>
                    <%--</td>--%>
                    <td>
                        <c:out value="${specialitySubject.getProfessionName()}"/>
                    </td>
                    <%--<td>--%>
                        <%--<c:out value="${specialitySubject.getSubjectId()}"/>--%>
                    <%--</td>--%>
                    <td>
                        <c:out value="${specialitySubject.getSubjectName()}"/>
                    </td>
                    <td>
                        <a style= "color:#2b2b2b;"
                           title="Edit ${specialitySubject.getSubjectId()} ${specialitySubject.getProfessionId()}"
                           href="controller?command=editSpecialitySubject&id=${specialitySubject.getId()}">
                            <i class="fa fa-pencil"></i></a>
                        <a style= "color:#2b2b2b;"
                           title="Delete ${specialitySubject.getSubjectId()} ${specialitySubject.getProfessionId()}"
                           href="controller?command=deleteSpecialitySubject&id=${specialitySubject.getId()}">
                            <i class="fa fa-trash-o"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
    </c:otherwise>
    </c:choose>
    <div class="add_button" style= background-color:#47698d;font-size:20px;>
        <i class="fa fa-plus-circle"></i>
        <a href="controller?command=addSpecialitySubject">Add new Speciality Subject</a>
    </div>
</div>
</body>
</html>