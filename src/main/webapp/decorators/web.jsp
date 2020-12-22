<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>

<link rel="stylesheet" href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>" />
<!-- Custom styles for this template -->
<link rel="stylesheet" href="<c:url value='/template/web/css/shop-homepage.css'/>" />

</head>
<body>
	<!-- Navigation -->

	<%@include file="/common/web/header.jsp"%>

	<dec:body />
	<!-- Page Content -->

	<!-- /.container -->

	<!-- Footer -->
	<%@include file="/common/web/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	
	<script src="<c:url value='/template/web/vendor/jquery/jquery.min.js"'/>"></script>
	
	<script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js"'/>"></script>
</body>
</html>