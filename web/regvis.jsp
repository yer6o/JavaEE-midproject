<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Visitor Registration</title>
</head>
<body>
<div align="center">
    <h1>Visitor Register Form</h1>
    <form action="<%= request.getContextPath() %>/visitor-register" method="post">
        <table style="with: 80%">
            <tr>
                <td>First Name</td>
                <td><input type="text" name="fName" /></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lName" /></td>
            </tr>
            <tr>
                <td>UserName</td>
                <td><input type="text" name="Email" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>