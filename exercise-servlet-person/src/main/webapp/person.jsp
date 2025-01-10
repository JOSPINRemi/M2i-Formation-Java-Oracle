<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste de personnes</title>
</head>
<body>
<h1>La liste des personnes</h1>
<c:forEach items="${people}" var="person">
    <div>
        Nom: ${person.getLastName()}
        Prénom: ${person.getFirstName()}
        Age: ${person.getAge()}
    </div>
</c:forEach>
</body>
</html>
