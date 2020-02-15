<%@ page import="com.project.db.Blogs" %><%--
  Created by IntelliJ IDEA.
  User: Dom
  Date: 04.02.2020
  Time: 19:00
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
        <%
            Blogs blog = (Blogs) request.getAttribute("blog");

        %>
        <!-- Blog Entries Column -->
        <div class="col-md-8">

            <h1 class="my-4">
                <%=blog.getTitle()%>

            </h1>
            <p>
                <%=blog.getShortContent()%>

            </p>
            <p>
                <%=blog.getContent()%>
            </p>
            <b>
                Posted on <%=blog.getPostDate()%>> by
                <a href="#"><%=blog.getAuthor().getFull_name()%>></a>
            </b>
            <br>
            <c:choose>
                <c:when test="${userOnline&&blog.author.id==userProfile.id}">
                    <br>
                    <a href="?page=editblog&id=${blog.id}" class="btn btn-success btn-sm">Edit Blog</a>
                </c:when>
            </c:choose>
            <br>
            <c:choose>
                <c:when test="${userOnline}">
                    <div class="row mt-3">
                        <div class="col-12">
                            <textarea rows="2" class="form-control" id = "comment"></textarea>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <button type="button" id="add_comment_button" class="btn btn-info">Add Comment</button>
                        </div>
                    </div>
                </c:when>
            </c:choose>
            <br>
            <div id = "comments_list">
            </div>
            <br><br>
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
