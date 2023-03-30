<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>
<%	if (session.getAttribute("userID") != null) {
	response.sendRedirect("home");
} %>
	<div class="container-fluid">
		<header>
			<h1 class="bg-success">Money Banks</h1>
		</header>


		<div class="container-fluid">

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<a class="navbar-brand" href="#">Banking</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNav"
						aria-controls="navbarNav" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="nav justify-content-end">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="welcome">Home</a></li>
							<li class="nav-item"><a class="nav-link" href="#">About us</a>
							</li>
							<li class="nav-item"><a class="nav-link disabled" href="#"
								tabindex="-1" >Extra Button</a></li>
						</ul>
					</div>
					<div class="nav" id="navbarNav">
						<ul class="nav justify-content-end">
							<li class="nav-item"><a class="nav-link" href="login">Login</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>

			<div class="row">
				<div class="col-4 border"></div>

				<div class="col"></div>
			</div>



		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>