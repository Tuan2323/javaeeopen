<%-- 
    Document   : autre
    Created on : 16 oct. 2020, 12:49:24
    Author     : Tuan
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test</title>
</head>
<body>
    <p>Vous etes sur autre.jsp</p>

    <c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom }">
        <p>Vous �tes ${ sessionScope.prenom } ${ sessionScope.nom } !</p>
    </c:if>

</body>
</html>
#
J'AI TERMIN� CE CHAPITRE ET JE PASSE AU SUIVANT