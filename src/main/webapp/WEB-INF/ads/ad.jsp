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


    <%--&lt;%&ndash;title, description, priority, risk, payout&ndash;%&gt;--%>
        <div class="col-md-6">
            <h2>Title: ${ad.title}</h2>
            <p>Description: ${ad.description}</p>
    <%--        <p>${ad.priority}</p>--%>
    <%--        <p>${ad.risk}</p>--%>
    <%--        <p>${ad.payout}</p>--%>
        </div>


    <%--comment section--%>

</div>

</body>
</html>
