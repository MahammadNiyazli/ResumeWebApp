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
</head>
<body>

<div style="width: 50%;margin:0 auto">
<form style="margin-top: 100px" method="POST" action="login">
    <div class="form-group">
     <%--@declare id="email"--%><label for="email" >Email</label>
        <input  class="form-control" style="padding:25px" type="email" name="email" placeholder="Enter email">
    </div>
    <div class="form-group">
        <%--@declare id="password"--%><label for="password" >Password</label>
            <input style="padding:25px" class="form-control" type="password" name="password" placeholder="Enter password">
    </div>
    <input type="submit" name="Submit" value="Submit" class="btn btn-outline-success">
</form>
</div>
</body>
</html>
