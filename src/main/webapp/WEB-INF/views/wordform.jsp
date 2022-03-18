

<%@ page import = "in.wordly.model.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="css/styleWordForm.css"> -->
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>


 

<%@ include file = "nav.jsp" %>
    
     <% 
 		if(user == null){
 			response.sendRedirect("login");	
 		}
     
     WordModel w = (WordModel) request.getAttribute("word");
     
     String word = "";
     String meaning  = "";
     String sentence1 = "";
     String sentence2 = "";
     String sentence3 = "";
     int id = 0;
     
     if(w != null){
    	 word = w.getWord();
    	 meaning = w.getMeaning();
    	 sentence1 = w.getSentence1();
    	 sentence2 = w.getSentence2();
    	 sentence3 = w.getSentence3();
    	 id = w.getId();
     }
      
  %>
    <section class="vh-100" >
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border:0px; border-radius: 0px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Your New Word</p>

                <form class="mx-1 mx-md-4" action = "wordsave" method = "POST">

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example1c" name = "word" class="form-control" value = "<%= word %>" />
                      <label class="form-label" for="form3Example1c">Enter Word</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example3c" name="meaning" class="form-control" value = "<%=meaning %>"/>
                      <label class="form-label" for="form3Example3c">Enter Meaning</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="form3Example4c" name = "sentence1" class="form-control" value = "<%=sentence1 %>" />
                      <label class="form-label" for="form3Example4c">Enter Sentence</label>
                    </div>
                  </div>
                  
                  
                  <div class="d-flex flex-row align-items-center mb-4 sentence2" >
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="sentence2"  name = "sentence2" class="form-control sentence2" value = "<%= sentence2%>" />
                      <label class="form-label sentence2" for="form3Example4c">Enter Sentence</label>
                    </div>
                  </div>
                  
                  
                  <div class="d-flex flex-row align-items-center mb-4 sentence3" >
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="sentence3" name = "sentence3" class="form-control sentence3" value = "<%= sentence3 %>" />
                      <label class="form-label sentence3" for="form3Example4c">Enter Sentence </label>
                    </div>
                  </div>

				<input type = "hidden" name = "id" value = "<%= id%>">

                  
				<p class="add-sentence" style="background-color: rgb(155, 179, 119);
				    color : black;
				    border-radius: 4px;
				    padding : 4px 12px;
				    cursor:grab;
				    ">+ Add New Sentence</p>
                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                    
                  </div>
                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <p   class="reset btn btn-primary btn-lg" style="margin-left:10px; ">reset</p>
                  </div>
                 
                </form>

              </div>
              <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                <img src="https://media.istockphoto.com/photos/stack-of-books-picture-id490482158?k=20&m=490482158&s=612x612&w=0&h=Poyxl40IhiPiagLti2m858_Ma-2-7Ux4BtExPEISYqI=" class="img-fluid" alt="Sample image">

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
        

 
<script>

$(document).ready(function(){

    var count = 1;
    
    $(".sentence2").hide();
    $(".sentence3").hide();

    $(".add-sentence").on("click",function(){
        count = count + 1;
        if(count == 2){
            $(".sentence2").show();
        }
        if(count == 3){
            $(".sentence3").show();
            $(".add-sentence").hide();
        }
    });


    $(".reset").on("click", function(){

        count = 1;
        $(".form-box").attr("height", "500");
        $(".sentence2").hide();
        $(".sentence3").hide();
        $(".add-sentence").show();
    });
});

</script>
</body>

</html>