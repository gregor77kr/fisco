let temp="0", k=0;
var array=[];
var numArray=[];
let oper1 = null;
let num1 = null, num2 = null;
var flag=0,answer=0,n1;
//화면상단
function show(n1)
{
    temp=n1;
    document.getElementById('viewbar1').value += temp;
}
//연산자표시
function doOperator(operator)
{
	document.getElementById('viewbar1').value += operator;
	oper1 = operator;
}
//equal
function operate()
{
    //기본사칙연산
	if(flag==0)
	{
        var answer=document.getElementById('viewbar1').value;
        answer=answer.replace("(","");
        answer=answer.replace(")","");
        //합
        if(oper1 == '+')
        {
        	numArray = (answer.split('+'));
        	num1 = Number(numArray[0]); 
        	num2 = Number(numArray[1]);
        	document.getElementById('viewbar2').value = "num1="+num1;
        	document.getElementById('viewbar2').value += "num2="+num2;
        	document.getElementById('viewbar1').value = Number(num1 + num2);
        	num1 = Number(document.getElementById('viewbar1').value);
    	//빼기
        }
        else if(oper1 == '-')
        {
        	numArray = (answer.split('-'));
        	num1 = Number(numArray[0]); 
        	num2 = Number(numArray[1]);
        	document.getElementById('viewbar2').value = "num1="+num1;
        	document.getElementById('viewbar2').value += "num2="+num2;
        	document.getElementById('viewbar1').value = Number(num1 - num2);
        	num1 = Number(document.getElementById('viewbar1').value);
    	//곱하기
        }
        else if(oper1 == '*')
        {
        	numArray = (answer.split('*'));
        	num1 = Number(numArray[0]); 
        	num2 = Number(numArray[1]);
        	document.getElementById('viewbar2').value = "num1="+num1;
        	document.getElementById('viewbar2').value += "num2="+num2;
        	document.getElementById('viewbar1').value = Number(num1*num2);
        	num1 = Number(document.getElementById('viewbar1').value);
    	//나누기
        }
        else if(oper1 == '/')
        {
        	numArray = (answer.split('/'));
        	num1 = Number(numArray[0]); 
        	num2 = Number(numArray[1]);
        	document.getElementById('viewbar2').value = "num1="+num1;
        	document.getElementById('viewbar2').value += "num2="+num2;
        	document.getElementById('viewbar1').value = Number(num1/num2);
        	num1 = Number(document.getElementById('viewbar1').value);
        //에러
        }
        else
        {
        	calcForm.txt1.value="MATH ERROR";
        }
        
    }
	else if(flag==1)
	{
        k=0;
        answer=0;
        k=document.getElementById('viewbar1').value;
        k=k.replace("sin","");
        k=k.replace("(","");
        k=k.replace(")","");
        answer= Math.sin(k);
        calcform.txt1.value=answer;
        flag=0;
        answer=0;
    }
    else if(flag==2)
    {
        k=0;
        answer=0;
        k=document.getElementById('viewbar1').value;
        k=k.replace("cos","");
        k=k.replace("(","");
        k=k.replace(")","");
        answer= Math.cos(k);
        calcform.txt1.value=answer;
        flag=0;
        answer=0;
    }
    else if(flag==3)
    {
        k=0;
        answer=0;
        k=document.getElementById('viewbar1').value;
        k=k.replace("tan","");
        k=k.replace("(","");
        k=k.replace(")","");
        answer= Math.tan(k);
        calcform.txt1.value=answer;
        flag=0;
        answer=0;
        
    //전체 에러    
    }else{
        calcform.txt1.value="MATH ERROR";
    }
}

//AC
function reload(){
    document.location.reload();
}

//DEL
function del(){
    answer=document.getElementById('viewbar1').value;
    answer=answer.replace(answer[answer.length-1],"");
    calcform.txt1.value=answer;
}
// ()
function fbo()
{
    calcform.txt1.value+="(";
}
function fbc()
{
    calcform.txt1.value+=")";
}

//sin flag value
function mysin()
{
    flag=1;
    calcform.txt1.value="sin";
}
//cos flag value
function mycos()
{
    flag=2;
    calcform.txt1.value="cos";
}
//tan flag value
function mytan()
{
   flag=3;
   calcform.txt1.value="tan";
}
