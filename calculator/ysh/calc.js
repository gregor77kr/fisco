const handleEquals = (input) => {
	// turn input to an array of number and operator
	let box = input.split(' ').map(inputData => {
		return inputData.match(/\d/) ? parseFloat(inputData) : inputData;
	});
	// loop through the expression to calculate
    for (let i = 0; i < box.length; i++) {
    	// set i = 0 to loop from the first index until no operator left
        // calculate multiply and divide 
    	if (box[i] == '*') {
    		box.splice(i - 1, 3, box[i-1] * box[i+1]);
    		i = 0;
    	} else if (box[i] == '/') {
    		box.splice(i - 1, 3, box[i-1] / box[i+1]);
    		i = 0;
    	}
    	// calculate addition and subtraction after finishing '*' and '/'
    	if (box.indexOf('*') == -1 && box.indexOf('/') == -1) {
	    	if (box[i] == '+') {
	            box.splice(i - 1, 3, box[i-1] + box[i+1]);
	            i = 0;
	        } else if (box[i] == '-') {
	            box.splice(i - 1, 3, box[i-1] - box[i+1]);
	            i = 0;
	        } 
	    }
	}      
    return box[0];
};

const display = document.querySelector('#display'); //diplay 변수
var countDot = 1; // 소수점 변수
var startExpression = true; // 시작표시 

//클리어버튼
document.querySelector('#clear').addEventListener('click', () => {
	display.value = '0'; 
	countDot = 1;
	startExpression = true;
});

//연산자버튼
document.querySelectorAll('.operator').forEach((button) => {
	button.addEventListener('click', () => {
		// 전 부호 지우기
		if (display.value.slice(-3).match(/^\s[\+\-\*\/]\s$/)) {
			display.value = display.value.slice(0, -3);
		}
		display.value += ' ' + button.value + ' '; // 연산자 더하기		
		countDot = 1; //		
		startExpression = false;
	});
});

//숫자버튼
document.querySelectorAll('.number').forEach((button) => {
	button.addEventListener('click', () => {
		if (startExpression == true) {
			display.value = button.value;
			countDot = 1; //
		} else if (display.value == '0' || display.value.slice(-2) == ' 0') {
			display.value = display.value.slice(0, -1) + button.value;
		} else {
			display.value += button.value;
		}
		startExpression = false;
	});
});

//소수점
document.querySelector('#decimal').addEventListener('click', () => {
	if (countDot == 1 && display.value.slice(-1).match(/\d/)) {
		display.value += '.';
		countDot = 0;
		startExpression = false;
	} 
});

// = 버튼
document.querySelector('#equals').addEventListener('click', () => {
	var result = handleEquals(display.value);
	result = Math.round(result * 1000000000) / 1000000000;
	display.value = result.toString();
	if (display.value.indexOf('.') !== -1) {
		countDot = 0;
	} else {
		countDot = 1;
	}
	startExpression = true;
});