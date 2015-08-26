<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/metro-bootstrap.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/iconFont.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/metro-bootstrap-responsive.css">
<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery/jquery.mousewheel.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery/jquery.widget.min.js"></script>
<script src="${pageContext.request.contextPath}/js/load-metro.js"></script>
<script src="${pageContext.request.contextPath}/js/metro.min.js"></script>

<style>
	.element:hover {
		background-color: darkGreen !important;
	}
</style>

<style>
.container {
	width: 940px !important;
	padding-top: 10px;
}

.rodape {
	background-color: lightGreen;
	width: 500px !important;
	padding-left: 10px;
}

.linha {
	background-color: #AAAAAA !important;
}
</style>
</head>

<body class="metro">
	<div class="container">
		<header>
			<tiles:insertAttribute name="header" />
		</header>
		<nav>
			<tiles:insertAttribute name="menu" />
		</nav>
		<div class="margin15">
			<tiles:insertAttribute name="body" />
		</div>
		<footer class="margin15">
			<tiles:insertAttribute name="footer" />
		</footer>
		
	</div>
</body>
</html>