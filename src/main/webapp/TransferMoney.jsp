<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	if (session.getAttribute("userID") == null) {
		response.sendRedirect("welcome");
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
						<ul class="nav">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="home">Home</a></li>
							<li class="nav-item"><a class="nav-link" href="#">About
									us</a></li>
							<li class="nav-item"><a class="nav-link disabled" href="#"
								tabindex="-1">Extra Button</a></li>
						</ul>
					</div>
					<div class="nav" id="navbarNav">
						<ul class="nav justify-content-end">
							<li class="nav-item font-monospace text-success">userID:
								${userID}</li>
						</ul>
					</div>
					<div class="nav" id="navbarNav">
						<ul class="nav justify-content-end">
							<li class="nav-item"><a class="nav-link" href="logout">logout</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>

			<div class="row justify-content-center">
				<div class="col-2">
					<div class="btn-group-vertical" role="group">
						<a href="deposit_withdraw_form" class="btn btn-success"
							role="button">Deposit/Withdraw</a> <a href="Balance"
							class="btn btn-success" role="button">Check Balance</a> <a
							href="TransferMoney" class="btn btn-success" role="button">Transfer
							to a Different Account</a>


						<div class="btn-group" role="group">
							<button id="btnGroupDrop1" type="button"
								class="btn btn-success dropdown-toggle"
								data-bs-toggle="dropdown" aria-expanded="false">
								Transaction History</button>
							<ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
								<li><a class="dropdown-item" href="CheckingTransactions">Checking</a></li>
								<li><a class="dropdown-item" href="SavingsTransactions">Savings</a></li>
							</ul>
						</div>

					</div>
				</div>

				<div class="col align-self-center">
					<div class="container">

						<div class="card">
							<div class="card-header display-5 text-center fw-bolde">Deposit
								or Withdraw</div>
							<div class="card-body">
								<form class="row g-3 needs-validation" action="TransferToOther"
									method="post">
									<div class="col-md-4">
										<label for="validationCustom01" class="form-label">Select
											which account to transfer from</label> <select class="form-select"
											id="validationCustom04" required name="account">
											<option selected disabled value="">Choose...</option>
											<option>Checking</option>
											<option>Savings</option>
										</select>
									</div>

									<div class="col-md-4">
										<label for="validationCustom03" class="form-label">Amount</label>
										<div class="input-group has-validation">
											<span class="input-group-text" id="inputGroupPrepend">$</span>
											<input type="text" class="form-control" name="amount"
												placeholder="00.00" pattern="^\d+(\.)\d{2}$"
												required="required" name="amount" title="##.##">
											<div class="valid-feedback">Looks good!</div>
										</div>
									</div>

									<div class="col-md-4">
										<label for="validationCustom01" class="form-label">UserID (Other account)</label>
										<input type="number" class="form-control" name="OtherAccount"
											placeholder="ID" required="required">
										<div class="valid-feedback">Looks good!</div>
									</div>

									<div class="col-12">
										<button class="btn btn-success" type="submit">Transfer
										</button>
									</div>
								</form>
							</div>

						</div>
					</div>

				</div>
			</div>



		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>
</html>