<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- ----------------------- STYLES----------------------------------- -->
 <jsp:include page="style.jsp"></jsp:include>
<!-------------------------------------------------------------------- --->

<title>Home</title>
</head>
<body>
<div class='container'>
	<div class='wrapper'>
		<form action="addnewtask.html" method="post" name="LoginForm" class="form-signin">
  			<h3 class="form-signin-heading">
  			
  			<img src="${pageContext.request.contextPath}/resources/images/icon2.png" />
  			Welcome ${user.userName}!</h3>
  			
  			 <hr class="colorgraph"><br>
  			
			    <br><br>   		  
			  <button class="btn btn-lg btn-primary btn-block"  name="create" value="create" type="Submit">Create new task</button>
			  <h6>Accomplish more, every day.</h6>  
		</form>
	</div>
</div>

</body>
</html>