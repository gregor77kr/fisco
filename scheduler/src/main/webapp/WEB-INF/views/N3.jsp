<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>N3</title>
</head>
<body>
	<table id="table">
		<thead id="thead"></thead>
		<tbody id="tbody"></tbody>
	</table>

	<script type="text/javascript">
		var head = ${head};
		head.unshift("이름");

		var dom = {
			createRow : function(id) {
				let node = document.createElement('tr');
				node.id = id;
				return node;
			},
			createColumn : function(id, value) {
				let node = document.createElement('td');
				node.id = id;
				
				let text = document.createTextNode(value);
				node.appendChild(text);
				return node;
			}
		}

		function createHead() {
			let row = document.getElementById('thead');
			head.forEach(function(value, index) {
				let column = dom.createColumn('thead' + index, value);
				row.appendChild(column);
			});
		}
		
		window.onload = function() {
			createHead();
		}
	</script>
</body>
</html>