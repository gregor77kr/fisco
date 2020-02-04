<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>N2</title>
</head>
<body>

	<form action="<c:url value='N3' />" method="post" id="form">
		<input type="hidden" id="headCount" name="headCount" value="${headCount}">
		<input type="hidden" id="nurseCount" name="nurseCount" value="${nurseCount}">
		<input type="hidden" id="assistCount" name="assistCount" value="${assistCount}">
		<input type="hidden" id="startDate" name="startDate" value="${startDate}">
		<input type="hidden" id="endDate" name="endDate" value="${endDate}">
	</form>
	<input type="button" id="next" value="next">

	<script type="text/javascript">
		document.querySelector('#next').addEventListener('click', function() {
			document.querySelector("#form").submit();
		});
	
		var dom = {
			createLabel : function(text) {
				let node = document.createElement("label");
				let textNode = document.createTextNode(text);
				node.appendChild(textNode);
				return node;
			},
			createInput : function(value, name, id) {
				let node = document.createElement("input");
				node.type = "text";
				node.value = value;
				node.name = name;
				node.id = id;
				return node;
			},
			createDiv : function() {
				return document.createElement('div');
			}
		};

		function createBirthDay() {
			let month = Math.floor((Math.random() * 12) + 1);
			let lastDate = new Date(new Date().getFullYear(), month, 0)
					.getDate();
			let date = Math.floor((Math.random() * lastDate) + 1);

			month = month < 10 ? "0" + month : month.toString();
			date = date < 10 ? "0" + date : date.toString();

			return month + date;
		}

		// 간호사 생일 입력 input 생성
		(function() {
			let headCount = document.querySelector("#headCount").value;
			let nurseCount = document.querySelector("#nurseCount").value;
			let assistCount = document.querySelector("#assistCount").value;
			let form = document.querySelector("#form");

			// 수간호사
			for (let i = 0; i < headCount; i++) {
				let id = 'head' + i;

				let div = dom.createDiv();
				div.appendChild(dom.createLabel('수간호사' + i + ' : '));
				div.appendChild(dom.createInput(createBirthDay(), id, id));

				form.appendChild(div);
			}

			// 일반간호사
			for (let i = 0; i < nurseCount; i++) {
				let id = 'nurse' + i;

				let div = dom.createDiv();
				div.appendChild(dom.createLabel('간호사' + i + ' : '));
				div.appendChild(dom.createInput(createBirthDay(), id, id));

				form.appendChild(div);
			}

			// 간호조무사
			for (let i = 0; i < assistCount; i++) {
				let id = 'assist' + i;

				let div = dom.createDiv();
				div.appendChild(dom.createLabel('간호조무사' + i + ' : '));
				div.appendChild(dom.createInput(createBirthDay(), id, id));

				form.appendChild(div);
			}
		})();
	</script>
</body>
</html>