<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DollarBanks Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<style>
/* Works for Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

/* Works for Firefox */
input[type="number"] {
	-moz-appearance: textfield;
}
</style>
</head>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if (session.getAttribute("userID") != null) {
		response.sendRedirect("home");
	}
	%>
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
							<li class="nav-item"><a class="nav-link" href="login">Login</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="#">Pricing</a>
							</li>
							<li class="nav-item"><a class="nav-link disabled" href="#"
								tabindex="-1" aria-disabled="true">Disabled</a></li>
						</ul>
					</div>
				</div>
			</nav>

			<div class="container col-md-5">

				<div class="card justify-content-center">
					<div class="card-head display-5 text-center fw-bolde">Login</div>
					<div class="card-body">
						<form class="row g-3 needs-validation justify-content-center"
							action="loginValidation" method="post">

							<div class="col-md-4">
								<label for="validationCustom01" class="form-label">UserID</label>
								<input type="number" class="form-control" name="userID"
									placeholder="ID" required="required">
								<div class="valid-feedback">Looks good!</div>
							</div>
							<div class="col-md-4">
								<label for="validationCustom02" class="form-label">Password</label>
								<input type="password" class="form-control" name="password"
									placeholder="password" required="required">
								<div class="valid-feedback">Looks good!</div>
							</div>

							<div class="d-grid gap-2 d-md-flex justify-content-md-center">
								<button class="btn btn-success" type="submit">Login</button>
							</div>
						</form>
					</div>
					<div class="card-body text-center">
						<a href="newUser" class="card-link">Create New User</a>
					</div>
				</div>
			</div>



		</div>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>