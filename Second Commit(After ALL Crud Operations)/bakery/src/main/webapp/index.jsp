<html>
<body>
<head>
  <title>Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <style>
  .carousel-inner img {
      -webkit-filter: grayscale(90%);
      filter: grayscale(10%); /* make all photos black and white */ 
      width: 100%; 
      margin: auto;
  }
  .carousel-caption h3 {
      color: #fff !important;
  }
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file='WEB-INF/view/header.jsp' %>

<div class="container">
   <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXLB54ag8wXSnPphW97COhlDj2dMW5XTr9YVsDItfNemQoJ2yOCg" alt="Bread" style="width:100%;">
      </div>

      <div class="item">
        <img src="https://bizimages.withfloats.com/actual/57d7ee4b9ec66836ac6fb8c6.jpg" alt="Pastries" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="http://www.lynchburgparksandrec.com/wp-content/uploads/2017/03/Pastries-and-Party-Cakes.jpg" alt="Cakes" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>


<%@ include file='WEB-INF/view/footer.jsp' %>


</body>
</html>
