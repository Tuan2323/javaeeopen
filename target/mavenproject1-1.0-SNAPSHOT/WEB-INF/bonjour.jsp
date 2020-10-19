<%-- 
    Document   : bonjour
    Created on : 15 oct. 2020, 16:27:48
    Author     : Tuan
--%>

<%--@ page pageEncoding="UTF-8" %>  plus besoin grace a la JSTP configurer dans web.xml--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
    <%@ include file="menu.jsp" %>
<%--<p>Bonjour ${ 6*5 } ${ name } ${ empty name ? '':name} ${ noms[0] }
    <% String name = (String) request.getAttribute("name");
    out.println(name);
        %></p>--%>

<p><c:out value="Bonjour !" /></p>
<p>${auteur.prenom} ${auteur.nom}</p>
<p>${auteur.actif ? 'Vous etes Actif !': 'Vous etes Inactif!' }</p>
<p>
    <%-- String variable =(String) request.getAttribute("variable");
    out.println(variable);
    String heure =(String) request.getAttribute("heure");
    out.println(heure);
    %>
    <%
        
        if (heure.equals("jour")) {
            out.println("Bonjour"); 
        }
        else {
            out.println("Bonsoir");
        }
    %>
</p>
<p>
    <%
        for (int i = 0 ; i < 20 ; i++) {
            out.println("Une nouvelle ligne !<br />");
        }
    %>
</p>--%>
<%--    
<c:if test="${ !empty nom}"><p><c:out value="bonjour vous vous appeler ${nom}"/></p></c:if>    
<form method="post" action="bonjour">
    <label for="nom">Nom: </label>
    <input type="text" name="nom" id="nom">   
    <input type="submit"/>
</form>--%>
<%--
    <c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /></p></c:if>
    <form method="post" action="bonjour" enctype="multipart/form-data" >
        <p>
            <label for="description">Description du fichier : </label>
            <input type="text" name="description" id="description" />
        </p>
        <p>
            <label for="fichier">Fichier à envoyer : </label>
            <input type="file" name="fichier" id="fichier" />
        </p>
        
        <input type="submit" />
    </form>--%>


    <c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom }">
        <p>Vous êtes ${ sessionScope.prenom } ${ sessionScope.nom } !</p>
    </c:if>
    <form method="post" action="bonjour">
        <p>
            <label for="nom">Nom : </label>
            <input type="text" name="nom" id="nom" />
        </p>
        <p>
            <label for="prenom">Prénom : </label>
            <input type="text" name="prenom" id="prenom" />
        </p>
        
        <input type="submit" />
    </form>

</body>
</html>
#
J'AI TERMINÉ CE CHAPITRE ET JE PASSE AU SUIVANT