
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Demonstration</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.bgcolorblue{
background-color:blue;
color: white;
}
</style>
</head>
<body>

<div class="container">
<div class="row">
<div class="col-sm-11 bgcolorblue">
<center><b>DashBoard</b></center>
</div>
<div class="col-sm-1"><a  href="logout"><button>Logout</button></a></div>
</div>

<div class="row"><center> Product List</center> </div>

<div class="row">
<div class="col-sm-1">
</div>
<div class="col-sm-10">

 <table class="table table-bordered">
    <thead>
      <tr>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Description</th>
        <th>ImageUrl</th>
        <th>Update</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody id="table">
     
    </tbody>
  </table>
</div>
<div class="col-sm-1">
</div>
</div>


</div>

Hello Authenticated User.<a href="addProduct"><button>Add Product</button></a>



<script>
$(document).ready(function(){
	
	 $.ajax({
	        type: 'GET',
	        url: 'http://localhost:8080/demonstration/products',
	        //data: $('#data').serialize(),
	        dataType:"json", //to parse string into JSON object,
	        success: function(data){ 
	        	 if(data){
	                var len = data.length;
	                var txt = "";
	                if(len > 0){
	                    for(var i=0;i<len;i++){
	                        if(data[i].id && data[i].name && data[i].description && data[i].imageUrl){
	                            txt += "<tr><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].description+"</td><td>"+data[i].imageUrl+"</td>"+
	                            "<td><a href='update?cid="+data[i].id+"&category="+data[i].category+"'><button>Update</button></a></td>"+
	                            "<td><button class='delete' cid='"+data[i].id+"' category='"+data[i].category+"'>Delete</button></td></tr>";
	                        }
	                    }
	                    if(txt != ""){
	                       // $("#table").append(txt).removeClass("hidden");
	                       $("#table").append(txt)
	                    } 
	            }
	                }
	        },
	        error: function(jqXHR, textStatus, errorThrown){
	            alert('error: ' + textStatus + ': ' + errorThrown);
	        }
	    });
	
	}).on("click",".delete", function(){
		 console.log("Clicked");
			console.log($(this).attr('class'));
			console.log($(this).attr('cid'));
			console.log($(this).attr('category'));
			var category = $(this).attr('category');
			var id = $(this).attr('cid');
			$("#table").empty();
			 $.ajax({
			        type: 'GET',
			        url: 'http://localhost:8080/demonstration/delete?id='+id+'&category='+category,
			        //data: $('#data').serialize(),
			        dataType:"json", //to parse string into JSON object,
			        success: function(data){ 
			        	 if(data){
			                var len = data.length;
			                var txt = "";
			                if(len > 0){
			                    for(var i=0;i<len;i++){
			                        if(data[i].id && data[i].name && data[i].description && data[i].imageUrl){
			                            txt += "<tr><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].description+"</td><td>"+data[i].imageUrl+"</td>"+
			                            "<td><a href='update?cid="+data[i].id+"&category="+data[i].category+"'><button>Update</button></a></td>"+
			                            "<td><button class='delete' cid='"+data[i].id+"' category='"+data[i].category+"'>Delete</button></td></tr>";
			                        }
			                    }
			                    
			                    if(txt != ""){
			                       // $("#table").append(txt).removeClass("hidden");
			                       
			                       $("#table").append(txt);
			                    } 
			            }
			                }
			        },
			        error: function(jqXHR, textStatus, errorThrown){
			            alert('error: ' + textStatus + ': ' + errorThrown);
			        }
			    });
	 });






</script>



	
</body>
</html>