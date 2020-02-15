<%@ page import="java.util.ArrayList" %>
<%@ page import="com.project.db.Blogs" %>
<%--
  Created by IntelliJ IDEA.
  User: Dom
  Date: 28.01.2020
  Time: 2:30
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
      </h1>
        <%
            ArrayList<Blogs> blogs = (ArrayList<Blogs>) request.getAttribute("blogs");
            if (blogs!=null){
                for (Blogs b : blogs){

        %>

        <div class="card mb-4">

          <div class="card-body">

            <h2 class="card-title"><%=b.getTitle()%></h2>
            <p class="card-text">
              <%=b.getShortContent()%>
            </p>
            <a href="load?page=readblog&id=<%=b.getId()%>" class="btn btn-primary">Read More &rarr;</a>

          </div>
          <div class="card-footer text-muted">
            Posted on <%=b.getPostDate()%> by
            <a href="#"><%=b.getAuthor().getFull_name()%></a>
          </div>



    </div>
        <%
                }
            }
        %>


<%--      <!-- Pagination -->--%>
<%--      <ul class="pagination justify-content-center mb-4">--%>
<%--        <li class="page-item">--%>
<%--          <a class="page-link" href="#">&larr; Older</a>--%>
<%--        </li>--%>
<%--        <li class="page-item disabled">--%>
<%--          <a class="page-link" href="#">Newer &rarr;</a>--%>
<%--        </li>--%>
<%--      </ul>--%>

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
