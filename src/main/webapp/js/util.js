
var userAction="http://localhost:8082/springboot-rolefunc/user/";
var userPage="http://localhost:8080/springboot-front/page/userspage/";

//用户检查请求合法性
function userCheck(res){
	if(res.code=="-2"){
		window.location.href=userPage+"userlogin.html";
	}
}
//封装ajax
function myAjax(myUrl, myData, mySuccess){
	$.ajax({
		xhrFields:	{withCredentials: true},
		url:myUrl,
		type:"post",
		data:myData,
		dataType:'json',
		success:mySuccess
	});
}
