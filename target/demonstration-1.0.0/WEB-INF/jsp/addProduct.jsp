
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Demonstration</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<div class="row">
<center><h2>Add Product</h2></center>
</div>
<div class="row">
<form class="form-horizontal" action="productAddition" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Product Name:</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" name="name" placeholder="Enter Name Of Product" required/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="productId">Product Id:</label>
    <div class="col-sm-8"> 
      <input type="number" class="form-control" name="productId" placeholder="Enter Product Id" required/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="productDescrption">Product Description:</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" name="productDescription" placeholder="Enter Product Description" required/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="productDescrption">Related Products:</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" name="relatedProducts" placeholder="Enter Related Products" required/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="productCategory">Product Category:</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" name="productCategory" placeholder="Enter Product Category" required/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="productImageUrl">Product Image Url:</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control" name="productImageUrl" placeholder="Enter Product Image Url" required/>
    </div>
  </div>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-1">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
    <div class="col-sm-9">
      <a href="dashboard"><button type="button" class="btn btn-default">Back</button></a>
    </div>
  </div>
</form>
</div>
</div>


</body>
</html>