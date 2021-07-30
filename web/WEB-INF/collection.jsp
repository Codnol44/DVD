<%@ page import="fr.eni.bo.DVD" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.eni.bo.Categorie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Collection</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
</head>

<body>

<div class="row">
    <div class="col">
        <form action="http://localhost:8080/DVD_war_exploded/collectionS" method=post>
             <select name="categorie" id="categorie"  required>
                 <option value="">--Sélectionner une catégorie--</option>
                 <option name="categorie" value="1" ${categorieChoix == 1 ? "selected" : ""}>Action</option>
                 <option name="categorie" value="2" ${categorieChoix == 2 ? "selected" : ""}>Comedie</option>
                 <option name="categorie" value="3" ${categorieChoix == 3 ? "selected" : ""}>Horreur</option>
                 <option name="categorie" value="4" ${categorieChoix == 4 ? "selected" : ""}>Romantique</option>
                 <option name="categorie" value="5" ${categorieChoix == 5 ? "selected" : ""}>Polar</option>
             </select>
             <button class="btn" type="submit">Filtrer par catégorie</button>
     </form>
    </div>
</div>

<div id="res">
<%
    out.print("<div><u>Voici la liste de vos films préférés : </u></div></br>");
    List<DVD> listDVD = (List<DVD>) request.getAttribute("listDvd");
    for (DVD item : listDVD) {
        out.print("<div>-" + item.getTitle() + " sorti en : " + item.getYear() + " avec : " + item.getActor() + ", vendu au prix de : " + item.getPrice() + " Euros.</div></br>");
    }
%>
</div>

<div class="row">
    <div class="col">
        <form action="http://localhost:8080/DVD_war_exploded/selectionS" method="get">
            <button class="btn" type="submit">Ajouter un nouveau film</button>
        </form>
    </div>
</div>

<div class="row">
    <div class="col">
        <form action="http://localhost:8080/DVD_war_exploded/collectionS" method="post">
            <input type="text" name="title"  class="form-control" id="text" placeholder="Titre ?"/>
            <button class="btn" type="submit">Saisissez un nom de film à retirer de la liste</button>
        </form>
    </div>
</div>

</body>
</html>
