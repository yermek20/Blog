<%--
  Created by IntelliJ IDEA.
  User: Dom
  Date: 03.02.2020
  Time: 1:00
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
<div class="container mt-3">
    <div class="row">
        <div class="col-6 offset-3">
            <%
                String success = request.getParameter("success");
                if (success!=null&&success.equals("1")){
            %>
            <div class="alert alert-success" role="alert">
                User added successfully!
            </div>
            <%
                }
            %>
            <%
                String error = request.getParameter("error");
                if (error!=null&&error.equals("1")){
            %>
            <div class="alert alert-danger" role="alert">
                User NOT added!
            </div>
            <%
                }
            %>
            <form action="/" method="post">
                <input type="hidden" name="act" value="add_user">
                <div class="row mt-2">
                    <div class="col-4">
                        <label>Email:</label>
                    </div>
                    <div class="col-8">
                        <input type="text" class="form-control" name="email">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-4">
                        <label>Password:</label>
                    </div>
                    <div class="col-8">
                        <input type="text" class="form-control" name="password">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-4">
                        <label>Re-Password:</label>
                    </div>
                    <div class="col-8">
                        <input type="text" class="form-control" name="re_password">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-4">
                        <label>Full Name:</label>
                    </div>
                    <div class="col-8">
                        <input type="text" class="form-control" name="full_name">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <button class="btn btn-success float-right">ADD</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- /.container -->
<%@include file="templates/footer.jsp"%>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


</body>
</html>
