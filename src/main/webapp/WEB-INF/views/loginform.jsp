<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  
  <!--   <link rel="stylesheet" href="css/styleLoginForm.css"> -->
    <title>Document</title>
</head>

<body>

<%@ include file = "nav.jsp" %>


<%

	if(user != null){
		response.sendRedirect("displayword");
	}


%>

 
 <section class="vh-100 bg-image" >
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border:0px; border-radius: 0px;">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5">Login Account</h2>

              <form action = "LoginUser" method = "GET">

                <div class="form-outline mb-4">
                  <input type="text" name = "username" id="form3Example1cg" class="form-control form-control-lg" />
                  <label class="form-label" for="form3Example1cg">Your Username</label>
                </div>

                

                <div class="form-outline mb-4">
                  <input type="password" name = "password" id="form3Example4cg" class="form-control form-control-lg" />
                  <label class="form-label" for="form3Example4cg">Password</label>
                </div>

                
                <div class="d-flex justify-content-center">
                  <button type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Login</button>
                </div>

               <p style="font-size : 15px; margin-top:10px;">Don't have an account? <a href="register"
                class="link-danger" style="color:blue;">Register</a></p>
              </form>


            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>

</html>