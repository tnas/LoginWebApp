<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Registration</title>
    </head>
    <body>
        <form action="./addUser" method="post">
            <input type="hidden" name=methodType" value="addUser"/>
            First name : <input type="text" name="fname" /><br/><br/>
            Last name :  <input type="text" name="lname" /><br/><br/>
            Email :      <input type="text" name="email" /><br/><br/>
            Role Name : 
            <select name="rolename">
                <option value="">Select Role Type</option>
                <option value="admin">Admin</option>
                <option value="ops_user">Operation User</option>
                <option value="ops_user">Finance</option>
            </select>
        </select><br/><br/>
        User Name :  <input type="text" name="userid" /><br/><br/>
        Password :   <input type="password" name="pwd" /><br/><br/>
                
        <input type="submit" value="submit" />
    </form>
</body>
</html>