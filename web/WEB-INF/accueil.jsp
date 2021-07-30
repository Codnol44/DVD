<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Choix</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
</head>
<body>

<p id="res">BIENVENUE DANS VOTRE DVDTHEQUE !</p>

<div class="row">
    <div class="col">
        <form action="http://localhost:8080/DVD_war_exploded/selectionS" method="get">
            <button class="btn2" type="submit">Ajouter un DVD</button>
        </form>

        <form action="http://localhost:8080/DVD_war_exploded/collectionS" method="get">
            <button class="btn2" type="submit">Voir le catalogue</button>
        </form>
    </div>
</div>

</p>

</body>
</html>
