<%--
  Created by IntelliJ IDEA.
  User: Dom
  Date: 04.02.2020
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <%@include file="templates/head.jsp"%>

</head>

<body>

<%@include file="templates/navbar.jsp"%>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

            <h1 class="my-4">
                404 PAGE NOT FOUND
            </h1>

        </div>


        <%@include file="templates/sidebar.jsp"%>

    </div>

</div>
<!-- /.container -->
<%@include file="templates/footer.jsp"%>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
