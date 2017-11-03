<html>
<body>
<head>
   <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<%@ include file='header.jsp' %>
<body>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="https://www.supplybunny.com/uploads/product/main_image/3103/54d4c7ba-3ecc-454a-902d-75f214d99d25.jpg" alt="New York" width="2000" height="700">
        <div class="carousel-caption">
          <h3>Bread</h3>
          
        </div>      
      </div>

      <div class="item">
        <img src="https://bizimages.withfloats.com/actual/57d7ee4b9ec66836ac6fb8c6.jpg" alt="Chicago" width="2000" height="700">
        <div class="carousel-caption">
          <h3>Cakes</h3>
          
        </div>      
      </div>
    
      <div class="item">
        <img src="https://danielchocolates.com/wp-content/uploads/2016/05/pastries.jpg" alt="Los Angeles" width="2000" height="700">
        <div class="carousel-caption">
          <h3>Pastries</h3>
          
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>


<%@ include file='footer.jsp' %>


</body>
</html>
