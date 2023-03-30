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
								aria-current="page" href="home">Home</a></li>
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

				<div class="card">
					<div class="card-head display-5 fw-bolde">New User</div>
					<div class="card-body">
						<form class="row g-3 needs-validation" action="NewCustomer"
							method="post">

							<div class="col-md-5">
								<label for="validationCustom01" class="form-label">First
									name</label> <input type="text" class="form-control" name="firstName"
									placeholder="First Name" required="required">
								<div class="valid-feedback">Looks good!</div>
							</div>
							<div class="col-md-4">
								<label for="validationCustom02" class="form-label">Last
									name</label> <input type="text" class="form-control" name="lastName"
									placeholder="Last Name" required="required">
								<div class="valid-feedback">Looks good!</div>
							</div>
							<div class="col-md-4">
								<label for="validationCustom03" class="form-label">
									Phone Number</label> <input type="tel" class="form-control"
									name="ContactInfo" placeholder="###-###-####"
									pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required="required" title="###-###-####">
								<div class="valid-feedback">Looks good!</div>
							</div>
							<div class="col-md-4">
								<label for="validationCustom04" class="form-label">Password</label>
								<input type="text" class="form-control" name="password"
									placeholder="password" required="required">
								<div class="valid-feedback">Looks good!</div>
							</div>
							<div class="col-md-4">
										<label for="validationCustom03" class="form-label">Initial Deposit</label>
										<div class="input-group has-validation">
											<span class="input-group-text" id="inputGroupPrepend">$</span>
											<input type="text" class="form-control" name="deposit"
												placeholder="00.00" pattern="^\d+(\.)\d{2}$"
												required="required" name="amount" title="##.##">
											<div class="valid-feedback">Looks good!</div>
										</div>
									</div>

							<div class="col-12">
								<button class="btn btn-primary" type="submit">Create
									New User</button>
							</div>
						</form>
					</div>

				</div>
			</div>



		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
</body>
</html>