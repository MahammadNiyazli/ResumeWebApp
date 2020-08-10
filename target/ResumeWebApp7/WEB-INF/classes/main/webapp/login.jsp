<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/6/2020
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <link rel="stylesheet" type="text/css" href="assets/css/users.css">
</head>
<body>
<%
 if(request.getAttribute("notFound")!=null){ %>
<div class="alert alert-warning" style="text-align: center">
    <strong>Warning!</strong> This user not found.
</div>
 <%}%>
<div class="login">
<form style="margin-top: 100px" method="POST" action="login">
    <div class="form-group">
     <%--@declare id="name"--%><label for="name" >Name</label>
        <input  class="form-control" style="padding:25px" type="text" name="name" placeholder="Enter name">
    </div>
    <div class="form-group">
        <%--@declare id="surname"--%><label for="surname" >Surname</label>
            <input style="padding:25px" class="form-control" type="text" name="surname" placeholder="Enter surname">
    </div>
    <input type="submit" name="Submit" VALUE="Submit" class="btn btn-outline-info" style="color: aliceblue">
</form>
</div>
</body>
</html>
