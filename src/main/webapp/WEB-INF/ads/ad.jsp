<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">


        <div class="col-md-6">
            <h1>${ad.title}</h1>
            <h4>${ad.description}</h4>
            <form action="/ads/delete?id=${ad.id}" method="post">
                <input value="delete" type="submit" class="btn btn-block btn-primary">
            </form>
        </div>



    <%--comment section--%>

</div>

</body>
</html>
