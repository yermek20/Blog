<%--
  Created by IntelliJ IDEA.
  User: Dom
  Date: 03.02.2020
  Time: 0:25
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
    <h1>Addblog</h1>
    <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

            <h1 class="my-4">
            </h1>
            <%
                String success = request.getParameter("success");
                if (success!=null&&success.equals("1")){
            %>
            <div class="alert alert-success" role="alert">
                Blog added successfully!
            </div>
            <%
                }
            %>
            <form action="/" method="post">
                <input type="hidden" name="act" value="addblog">
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label">Title</label>
                    <div class="col-sm-9">
                        <input type="text" name="title" class="form-control"placeholder="Title">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label">Content</label>
                    <div class="col-sm-9">
                        <textarea class="form-control" name="content" id = "content"></textarea>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-12">
                        <button class="btn btn-primary float-right">ADD BLOG</button>
                    </div>
                </div>
            </form>

        </div>

        <%@include file="templates/sidebar.jsp"%>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<%@include file="templates/footer.jsp"%>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.js"></script>
</body>
</html>

