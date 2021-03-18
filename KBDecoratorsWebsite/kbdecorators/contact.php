<!DOCTYPE html>
<html>
<head>
	<title>Contact</title>

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-167530546-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag(){dataLayer.push(arguments);}
		gtag('js', new Date());

		gtag('config', 'UA-167530546-1');
	</script>

	<!-- Keywords -->
	<meta name="keywords" content="decorators, interior, exterior, builders, construction, va, VA, Virginia, 
		Northern Virginia, NoVA, NOVA, rennovation, addition, bathroom, bedroom, roof, backyard, front yard, 
		sheds, install, open space, space, garden, roofing, floor, flooring, tiles, tiling, paint, painting, 
		spring, special, custom, ideal, modern, traditional, style, stylish, update, decor, colonial, shingles, 
		baseboards, deck, siding, downsprout, storm drain, kbdecorators, knickers, knicker, knickerbocker, 
		knickerbocker decorators, knicker bocker, zero, 1, 2, 3, 4, beds, baths, rooms, ceiling, townhouse, house, 
		condo, apartment, fixture, repair, replace, replacement, fixing, budget friendly, budget, affordable, competitive, 
		customer, satisfaction, customer satisfaction, licensed, bonded, insured, return customers, family owned.">

	<!-- 	viewport -->
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- 	Font awesome and SuperSlides -->
	<script src="https://kit.fontawesome.com/e294a45d38.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="css/all.min.css">
	<link rel="stylesheet" type="text/css" href="css/superslides.css">
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

	<?php
		require "customer-nav.php";
	?>

	
	<div id ="contact">
		<div class="container">
			<h1 style="text-align: center;">Contact Us</h1>
			<p style="text-align: center;">Are you looking to renovate your home but have questions?<br> Fill out this form 
				to contact us and we will get back to you as soon as possible.
			</p>
			<br>
			<form action = "contact.php" method = "post">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="First Name">First Name</label>
						<input type="text" class="form-control" name="fname" id="contactFName" placeholder="First Name" required>
					</div>
					<div class="form-group col-md-6">
						<label for="Last Name">Last Name</label>
						<input type="text" class="form-control" name="lname" id="contactLName" placeholder="Last Name" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="Phone Number">Phone Number</label>
						<input type="tel" class="form-control" name="phone" id="contactPhone" placeholder="Phone Number (Optional)" pattern="[0-9]{3}[0-9]{3}[0-9]{4}|[0-9]{3}-[0-9]{3}-[0-9]{4}">
					</div>
					<div class="form-group col-md-6">
						<label for="Email">Email</label>
						<input type="email" class="form-control" name="email" id="contactEmail" placeholder="Email" required
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="Message">Message</label>
						<textarea class="form-control" name="message" id="contactMessage" rows="5" cols="50" required></textarea>
					</div>
				</div>
				<br>
				<button type="submit" name="submit" class="btn btn-primary">Submit</button>

				<?php
					// If the form has been submitted, stay on same page but process the data
					if(isset($_POST["submit"])) {
							
						$fname = $_POST["fname"];
						$lname = $_POST["lname"];
						$phone = $_POST["phone"];
						$email = $_POST["email"];
						$message = $_POST["message"];
						$fullMessage = "";
						if($phone) {
							$fullMessage = "$message\n\nName: $fname $lname\nPhone: $phone";
						} else {
							$fullMessage = "$message\n\nName: $fname $lname";
						}
						$successfulMail = mail("kbdecorators493@gmail.com", "Contact email", $fullMessage, "From: $fname $lname <$email>");
						if($successfulMail) {
							echo "<div id='snackbar'>Email sent!</div>";
						} else {
							echo "<div id='snackbar'>Error!</div>";
						}
					}
				?>
			</form>
		</div>
	</div>

	<script src="js/typed.min.js"></script>
	<script src="js/jquery.superslides.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://unpkg.com/isotope-layout@3.0.6/dist/isotope.pkgd.min.js"></script>
	<script src="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.js"></script>
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