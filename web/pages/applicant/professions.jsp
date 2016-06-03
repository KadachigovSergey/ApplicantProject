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
        <legend style="font-size:150%; color: #306589">Profession</legend>
        <c:choose>
        <c:when test="${professions.size() == 0}">
            <p><c:out value="No profession yet"></c:out></p>
        </c:when>
        <c:otherwise>
        <table>
            <tr>
                <th>ID</th>
                <th>Profession Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${professions}" var="profession">
                <tr style=" font-size:110%;">
                    <td>
                        <c:out value="${profession.getId()}"/>
                    </td>
                    <td>
                        <c:out value="${profession.getProfessionName()}"/>
                    </td>
                    <td>
                        <a style= "color:#2b2b2b;"
                           title="Edit ${profession.getProfessionName()} "
                           href="controller?command=editProfession&id=${profession.getId()}">
                            <i class="fa fa-pencil"></i></a>
                        <a style= "color:#2b2b2b;"
                           title="Delete ${profession.getProfessionName()} "
                           href="controller?command=deleteProfession&id=${profession.getId()}">
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
        <a href="controller?command=addProfession">Add new Profession</a>
    </div>
</div>
</body>
</html>
