<?php
	// Snackbar error messages for when the username or password is wrong. 
	if (isset($_GET['error'])) {
		if ($_GET['error'] == "wrongpassword"){
			echo "<div id='snackbar'>Wrong Password Entered</div>";
		}else if ($_GET['error'] == "nouser"){
			echo "<div id='snackbar'>User Not Found</div>";
		}
	}
?>


<html>
<head>


	<title>Emp-KbDecorators</title>

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-167530546-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag(){dataLayer.push(arguments);}
		gtag('js', new Date());

		gtag('config', 'UA-167530546-1');
	</script>

	<!-- 	viewport -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- 	Font awesome and SuperSlides -->
	<script src="https://kit.fontawesome.com/e294a45d38.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="css/all.min.css">
	<!-- Bootstrap CDN -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<!-- Jquery CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.css" />
	
</head>
<body>

	<div class="loader">
		<div class="inner">

		</div>
	</div>

	<nav id = "navigation" class="navbar navbar-expand-lg">
		<a class="navbar-brand" href="index.php" ><img src="img/logo3.png" width="120" height="110">

		</a>
	</nav>

	<div class="loginWrapper">
		<form class="form-signin" action="login_action.php" method="POST">
			<h2 class ="form-signin-heading text-center">Login</h2>
				<input type="email" class="form-control" name="email" placeholder="Email Address" required="" autofocus=""
					pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
				<input type="password" class="form-control" name="password" placeholder="Password" required="">
			<label class="checkbox">
				<input type="checkbox" value="remember-me" id="remember-me" name="rememberMe">
				Remember me
			</label>
			<button type="submit" class="btn btn-lg btn-primary btn-block" name="login_submit">Submit</button>
		</form>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	<script src="js/script.js"></script>

</body>

<footer>
	<div class = "copyright">
		<div class = "col-md-12 text-center">
			<p>&copy; Copyright 2020. Zero Index Solutions. All Rights Reserved.</p>
		</div>
	</div>
</footer>

</html>