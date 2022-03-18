<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

.lp-content{
    display: flex;
    justify-content: space-around;
}

.lp-text-content{
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin-right: 500px;
    
    font-size: 2.5rem;
    margin-bottom: 300px;
}




.lp-content img{
    height: 700px;
    width: 700px;
}

</style>
<body>
<%@ include file = "nav.jsp" %>

      <div class="lp-content">
        <img src="https://ebookfriendly.com/wp-content/uploads/2021/02/Book-Collection-best-cartoons-about-books.jpg" alt="">

<div class = "lp-text-content">

    <h1><i>Wordly.</i></h1>
    <button type="button" class="btn btn-primary btn-lg">Getting Started..</button>
</div>
      </div>
      

</body>
</html>