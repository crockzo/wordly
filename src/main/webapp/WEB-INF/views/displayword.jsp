<%@page import = "in.wordly.model.*" %>
<%@page import = "java.util.*" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/word.css">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>
<body>

<%@ include file = "nav.jsp" %>


<%

if(user == null){
	response.sendRedirect("login");
}


%>
    <div class = "word-container">
    
  <div class="card card-body d-flex flex-column bd-highlight mb-3">
    <form action="filterword" class="d-flex flex-column bd-highlight mb-3">
    
    <input type = "text" name = "word" placeholder = "search Word.." class = "form-control" style="margin-top:10px;">
    
    <button type = "submit" class="btn btn-secondary btn-lg" style="margin-top:10px;">submit</button>
    </form>
  </div>
<%
	List<WordModel> list = (ArrayList<WordModel>)request.getAttribute("word");
	int count = 0;
	int deleteId = -1;
	for(WordModel w : list){
	count++;
%>




<div class="card mt-2 mb-2">
  <h5 class="card-header" style="background-color:#a9f8bb; font-weight:900" ><%= count%>. <%= w.getWord().toUpperCase() %></h5>
  
  <div class="card-body">
    <h5 class="card-title"><%= w.getMeaning() %></h5>
    <p class="card-text"><%= w.getSentence1() %></p>
    <a href="updatewordform?id=<%=w.getId() %>" class="btn btn-primary">Update</a>
    <a href="deleteword?word_id=<%=w.getId() %>" class="btn btn-primary" >Delete</a> 
     </div>
</div>



 <%
	}
 %>
    </div>
    
 

 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap.min.js"></script>
    
</body>
</html>