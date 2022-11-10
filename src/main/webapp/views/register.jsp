<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
form{
background-color:skyblue;
 width:280px;
 height:280px;
 border-style:solid;
 border-color: blue;
 padding:10px
}
table, th, td {
  border: 1px solid;
}
</style>
</head>
<body>
<h1>Register here!!</h1>
<h1 color:red>${errormsg}</h1>
<form  action="/register" method=POST>
<input type="text" name="firstname" placeholder="Enter first name">
<br></br>
<input type="text" name="lastname" placeholder="Enter last name">
<br></br>
<input type="text" name="address" placeholder="Enter address">
<br></br>
<input type="email" name="email" placeholder="Enter email">
<br></br>
<input type="password" name="password" placeholder="Enter password">
<br></br>
<input type="tel" name="mobile" placeholder="Enter mobile">
<br></br>
<button>Register</button>
</form>
<br></br>
<table>
<tr>
    <th>FirstName</th>
    <th>lastName</th>
    <th>Address</th>
    <th>Email</th>
    <th>Mobile</th>
  </tr>
  <tr>
    <th>${stu.getFirstName()}</th>
    <th>${stu.getLastName()}</th>
    <th>${stu.getAddress()}</th>
    <th>${stu.getEmail()}</th>
    <th>${stu.getMobile()}</th>
  </tr>
</table>
</body>
</html>