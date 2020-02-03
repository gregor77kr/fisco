<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>N1</title>
</head>
<body>
	<form action="<c:url value='N2' />" method="get" id="form">
		<label for="headCount">수간호사 수 : </label>
		<input type="text" id="headCount" name="headCount" value="0">
		<br />
		<label for="nurseCount">간호사 수 : </label>
		<input type="text" id="nurseCount" name="nurseCount" value="0">
		<br />
		<label for="assistCount">간호조무사 수 : </label>
		<input type="text" id="assistCount" name="assistCount" value="0">
		<br />
		<label for="startDate">시작기간 : </label>
		<input type="text" id="startDate" name="startDate" value="0">
		<br />
		<label for="endDate">종료기간 : </label>
		<input type="text" id="endDate" name="endDate" value="0">
		<br />
	</form>
	<input type="button" id="next" value="next">

	<script type="text/javascript">
		document.querySelector('#next').addEventListener('click', function() {
			document.querySelector("#form").submit();
		});
	</script>
</body>
</html>