<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#">BLOG</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="">en</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">kz</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">ru</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <%
                boolean userOnline = (boolean)request.getAttribute("userOnline");
                if (userOnline){
            %>
            <li class="nav-item active">
                <a class="nav-link" href="?page=home">Home </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="load?page=profile">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="load?page=addblog">Add Blog</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
            </li>
            <%
                }else {
            %>
            <li class="nav-item active">
                <a class="nav-link" href="?page=home">Home </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="load?page=login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="load?page=adduser">Register</a>
            </li>
            <%
                }
            %>
        </ul>
    </div>
</nav>
