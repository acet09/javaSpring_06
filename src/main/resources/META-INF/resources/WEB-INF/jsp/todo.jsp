<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<title>add Todo page</title>
</head>
<body>
	<div class="container">
		<h1>Enter Todo Details</h1>
		<form method="POST">
			Description: <input type="text" name="description"/>
			<input type="submit" class="btn btn-success"/>
		</form>
		
	</div>
	<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
	<!-- <script src="http://code.jquery.com/jquery-latest.min.js"></script> -->
</body>
</html>