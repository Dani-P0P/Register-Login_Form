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

        h1 {
            margin-bottom: 90px;
        }
    </style>

    <title>Login</title>
    <meta name="description" content="Login" />
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/login"  style="display: flex; flex-direction: row; justify-content: center; align-items: center">
    <div style="display: flex; flex-direction: column; width: 300px; height:300px; justify-content: center; align-items: center ">
        <h1>Log In</h1>
        <div class="redirectBtns">
            <button name="signup" value="${pageContext.request.contextPath}/register.jsp">Sign up</button>
            <button name="forgotPassword" value="${pageContext.request.contextPath}/forgotPassword.jsp">Forgot password</button>
        </div>
    </div>
    <div style="display: flex; width: 300px; height:300px; flex-direction: column; justify-content: center; align-items: center">
        <div class="form-group row">
            <label class="col-sm-4 col-form-label">Username</label>
            <div class="col-sm-8"><input name="username" type="text" ></div>
        </div>
        <div class="form-group row">
            <label class="col-sm-4 col-form-label">Password</label>
            <div class="col-sm-8"><input name="password" type="password"></div>
        </div>
        <button name="login" value="${pageContext.request.contextPath}/details.jsp">Login</button>
    </div>
</form>
</body>
</html>
