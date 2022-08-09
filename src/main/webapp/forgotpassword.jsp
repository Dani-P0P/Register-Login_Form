<%@ page import="com.example.loginform.model.User" %>
<%@ page import="com.example.loginform.dbRunTime.Users" %>
<%@ page import="com.example.loginform.database.UserData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
    />
<head>
    <style>
        label {
            display: inline-block;
            width: 150px;
            text-align: right;
            margin-bottom: 15px;
        }

        input {
            width: 150px;
        }
        .redirectBtns {
            display: flex;
            flex-direction: row;
            align-items: center;
            gap: 10px;
        }

        button {
            width: 70px;
        }

        h1 {
            margin-bottom: 163px;
        }
    </style>
    <title>Forgot Password</title>
    <meta name="description" content="Sign up" />
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/forgotPassword" style="display: flex; flex-direction: row; justify-content: center; align-items: center">
    <div style="display: flex; flex-direction: column; width: 300px; height:300px; justify-content: center; align-items: center ">
        <h1>Forgot Password</h1>
        <div class="redirectBtns">
            <button name="exit" value="${pageContext.request.contextPath}/login.jsp">Exit</button>
        </div>
    </div>
    <div style="display: flex; width: 300px; height:300px; flex-direction: column; justify-content: center; align-items: center">
        <% UserData userData = new UserData();
            Users users = userData.getDatabaseContent();
            User currentUser = users.findUserByUsername(request.getSession().getAttribute("username").toString());%>
        <div>
            <div class="form-group row">
                <label class="col-sm-4 col-form-label">Username</label>
                <div class="col-sm-8"><text> <%=currentUser.getUsername()%></text></div>
            </div>
            <div class="form-group row">
                <label class="col-sm-4 col-form-label">Password</label>
                <div class="col-sm-8"><input type="password" name="password"></div>
            </div>
            <div class="form-group row">
                <label class="col-sm-4 col-form-label">Repeat password</label>
                <div class="col-sm-8"><input type="password" name="confirmpassword"></div>
            </div>
        </div>
        <button name="save" value="${pageContext.request.contextPath}/home.jsp">Save</button>
    </div>
</form>
</body>
</html>

