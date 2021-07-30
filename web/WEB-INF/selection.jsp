<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Ajout</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
</head>
<body>

<p>AJOUT DVD</p>

<div class="fond">
    <div class="col">
        <form action="http://localhost:8080/DVD_war_exploded/selectionS" method="post">
            <label for="title">Titre du film : </label><textarea name="title" id="title" cols="30" rows="2" required></textarea>
            <label for="year">Année de sortie : </label><textarea name="year" id="year" cols="30" rows="2" required></textarea>
            <label for="actor">Acteur principal : </label><textarea name="actor" id="actor" cols="30" rows="2" required></textarea>
            <label for="price">Prix du DVD : </label><textarea name="price" id="price" cols="30" rows="2" required></textarea>
            <select name="categorie" id="categorie"  required>
                <option value="">--Sélectionner une catégorie--</option>
                <option name="categorie" value="1" ${categorieChoix == 1 ? "selected" : ""}>Action</option>
                <option name="categorie" value="2" ${categorieChoix == 2 ? "selected" : ""}>Comedie</option>
                <option name="categorie" value="3" ${categorieChoix == 3 ? "selected" : ""}>Horreur</option>
                <option name="categorie" value="4" ${categorieChoix == 4 ? "selected" : ""}>Romantique</option>
                <option name="categorie" value="5" ${categorieChoix == 5 ? "selected" : ""}>Polar</option>
            </select>
            <input type="submit" value="Ajouter">
        </form>

        <div id="res"><%
            String ajout = (String) request.getAttribute("ajout");
            if (ajout != null) {
                out.print("<div>" + ajout + "</div>");
            }
        %></div>

        <form action="http://localhost:8080/DVD_war_exploded/collectionS" method="get">
            <button class="btn" type="submit">Voir le catalogue</button>
        </form>
    </div>
</div>

</body>
</html>