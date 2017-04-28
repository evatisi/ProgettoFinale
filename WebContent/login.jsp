<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<style>
#main_panel {
	width: 350px;
	height: 280px;
	margin: auto;
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	margin: auto;
}
</style>
</head>
<body>


	<div class="panel panel-info" id="main_panel">
		<div class="panel-heading">
			<h3 class="panel-title">Login</h3>
		</div>
		<div class="panel-body">
			<form method="post" action="Login" class="form-horizontal">

				Inserire credenziali:
				<ul>
					<li>username</li>
					<li>password</li>
				</ul>

				<div
					<c:if test="${not empty param.error}">class="form-group has-feedback has-error"</c:if>
					<c:if test="${empty param.error}">class="form-group has-feedback"</c:if>>

					<div class="col-sm-12">
						<div class="input-group">

							<span class="input-group-addon"><span
								class="glyphicon glyphicon-user" aria-hidden="true"></span></span> <input
								type="text" class="form-control" id="username" name="username"
								value="" placeholder="Inserisci username" />
						</div>
						<c:if test="${not empty param.error}">
							<span class="glyphicon glyphicon-remove form-control-feedback"
								aria-hidden="true"></span>
						</c:if>
					</div>
				</div>
				<div
					<c:if test="${not empty param.error}">class="form-group has-feedback has-error"</c:if>
					<c:if test="${empty param.error}">class="form-group has-feedback"</c:if>>

					<div class="col-sm-12">
						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-lock" aria-hidden="true"></span></span> <input
								class="form-control" id="password" type="password"
								name="password" value="" placeholder="Inserisci password" />
						</div>
						<c:if test="${not empty param.error}">
							<span class="glyphicon glyphicon-remove form-control-feedback"
								aria-hidden="true"></span>
						</c:if>
					</div>
				</div>
				<button type="submit" class="btn btn-info btn-block">Login</button>
				<a href="RegistrazioneUser"> <button type="button" class="btn btn-info btn-block">Registration</button> </a>
			</form>

		</div>
	</div>


</body>
</html>