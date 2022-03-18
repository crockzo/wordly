<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  
</head>
<body>

<%@include file = "nav.jsp" %>


<%

if(user == null){
	response.sendRedirect("login");
}

user = (UserModel) request.getAttribute("user");

%>

<div class="card" style="width: 18rem; margin:auto; margin-top : 10px;">
  <div class="card-body">
    <h5 class="card-title"><b><%= user.getName()%></b></h5>
    <p class="card-text">Welcome to your wordly profile : )</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><b>Username  </b> : <%= user.getUsername()%></li>
    <li class="list-group-item"><b>Email  </b> : <%= user.getEmail()%></li>
    <li class="list-group-item"><b>Word Count : </b><%= user.getWordCount()%></li>
  </ul>
  <div class="card-body" style="text-align:center;">
    <a href="profileupdateform" class="card-link" style="background-color:green; padding:10px; color:white; ">Update</a>
  </div>
</div>
</body>
</html>