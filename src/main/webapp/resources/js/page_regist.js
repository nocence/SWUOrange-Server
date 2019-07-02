$(document).ready(function(){
/*		// 在键盘按下并释放及提交后验证提交表单	
		$(".selector").validate({ 
			rules: {
	      		account: {
	        		required: true,
	        		minlength: 2
	      		},
	      		password: {
	        		required: true,
	        		minlength: 5
	      		},
	      		rePassword: {
	        		required: true,
	        		minlength: 5,
	        		equalTo: "#password"
	      		},
	      		tel: {
	        		required: true,
	        		digits:true
	      		},
	      		email: {
	        		required: true,
	        		email: true
	      		},
	      		realname: {
	        		required: true,
	        		minlength: 2
	      		},
	      		telCode: {
	        		required: true,
	        		
	      		},
	      		agree: "required"
	    	},
	    	messages: {
	      
	      		account: {
	        		required: "请输入用户名",
	        		minlength: "用户名长度大于2"
	      		},
	      		password: {
	       	 		required: "请输入密码",
	        		minlength: "密码长度不能小于 5 个字母"
	     		},
	      		rePassword: {
	        		required: "请输入密码",
	        		minlength: "密码长度不能小于 5 个字母",
	        		equalTo: "两次密码输入不一致"
	      		},
	      		tel:{
	      			required: "请输入一个正确的手机号",
	        		minlength: "密码长度不能小于 11个数字"
	      		},
	      		email: "请输入一个正确的邮箱",
	      		realname: {
	        		required: "请输入真实姓名",
	        		minlength: "用户名长度大于2"
	      		},
	      		telCode:{
	      			required: "请输入正确的验证码",
	        		
	      		},
	      		agree: "请接受我们的声明"
	      
	    	},
			
			submitHandler: function(form) {      
     			 $(form).ajaxSubmit({
					type:"post",
					url:"user/register",
					dataType:"json",
					data:{
						"account":$("#account").val(),
						"password":$("#password").val(),
						"rePassword":$("#rePassword").val(),
						"tel":$("#tel").val(),
						"email":$("#email").val(),
						"realname":$("#realname").val(),
						"telCode":$("#telCode").val()
					},
					
					success:function(res){
						if(res.code=="200"){//前往注册成功页面
							$(".tip").html("注册成功!");
							//window.location.href="regIndex.html"
						}else if(res.code=="400"){
							
							$(".tip").html("注册失败!");
							//window.location.href="reg.html"
						}
					}

				});

   			}  
 		}) */

	
	
	
	
	
	
	
	
	
	//获取JS传递的语言参数
	var utils = new Utils();
	var args = utils.getScriptArgs();	
	
	
	//隐藏Loading/注册失败 DIV
	$(".loading").hide();
	$(".login-error").hide();
	registError = $("<label class='error repeated'></label>");
	
	//加载国际化语言包资源
	utils.loadProperties(args.lang);
	
	//输入框激活焦点、移除焦点
	jQuery.focusblur = function(focusid) {
		var focusblurid = $(focusid);
		var defval = focusblurid.val();
		focusblurid.focus(function(){
			var thisval = $(this).val();
			if(thisval==defval){
				$(this).val("");
			}
		});
		focusblurid.blur(function(){
			var thisval = $(this).val();
			if(thisval==""){
				$(this).val(defval);
			}
		});
	 
	};
	/*下面是调用方法*/
	$.focusblur("#email");
	
	
	
	
	
	//获取表单验证对象[填写验证规则]
	var validate = $("#signupForm").validate({
		rules: {
			email: {
				required: true,
				email: true
			},
			password: {
				required: true,
				minlength: 4,
				maxlength: 16
			},
			rePassword: {
				required: true,
				minlength: 4,
				maxlength: 16,
				equalTo: "#password"
			},
			account: {
				required: true
			},
			realname: {
				required: true
			},
			tel: {
				required: true,
				digits:true
			},
			
		},
		messages: {
			email: {
				required: $.i18n.prop("Form.PleaseInputEmail"),
				email: $.i18n.prop("Form.PleaseInputCorrectEmail")
			},
			password: {
				required: $.i18n.prop("Form.PleaseInputPassword"),
				minlength: jQuery.format($.i18n.prop("Form.PasswordFormat")),
				maxlength: jQuery.format($.i18n.prop("Form.PasswordFormatMax"))
			},
			rePassword: {
				required: $.i18n.prop("Form.PleaseInputRePassword"),
				minlength: jQuery.format($.i18n.prop("Form.PasswordFormat")),
				maxlength: jQuery.format($.i18n.prop("Form.PasswordFormatMax")),
				equalTo: jQuery.format($.i18n.prop("Form.PasswordDifferent"))
			},
			account: {
				required: $.i18n.prop("Form.PleaseInputAccount")
			},
			realname: {
				required: $.i18n.prop("Form.PleaseInputRealName")
			},
			tel: {
				required: $.i18n.prop("Form.PleaseInputTel"),
				digits: $.i18n.prop("Form.IncorrectFormatTel")
			},
			
		}
	});
	
	
	//输入框激活焦点、溢出焦点的渐变特效
	if($("#email").val()){
		$("#email").prev().fadeOut();
	};
	$("#email").focus(function(){
		$(this).prev().fadeOut();
	});
	$("#email").blur(function(){
		if(!$("#email").val()){
			$(this).prev().fadeIn();
		};		
	});
	if($("#password").val()){
		$("#password").prev().fadeOut();
	};
	$("#password").focus(function(){
		$(this).prev().fadeOut();
	});
	$("#password").blur(function(){
		if(!$("#password").val()){
			$(this).prev().fadeIn();
		};		
	});
	if($("#rePassword").val()){
		$("#rePassword").prev().fadeOut();
	};
	$("#rePassword").focus(function(){
		$(this).prev().fadeOut();
	});
	$("#rePassword").blur(function(){
		if(!$("#rePassword").val()){
			$(this).prev().fadeIn();
		};		
	});
	if($("#account").val()){
		$("#account").prev().fadeOut();
	};
	$("#account").focus(function(){
		$(this).prev().fadeOut();
	});
	$("#account").blur(function(){
		if(!$("#account").val()){
			$(this).prev().fadeIn();
		};		
	});
	if($("#realname").val()){
		$("#realname").prev().fadeOut();
	};
	$("#realname").focus(function(){
		$(this).prev().fadeOut();
	});
	$("#realname").blur(function(){
		if(!$("#realname").val()){
			$(this).prev().fadeIn();
		};		
	});
	if($("#tel").val()){
		$("#tel").prev().fadeOut();
	};
	$("#tel").focus(function(){
		$(this).prev().fadeOut();
	});
	$("#tel").blur(function(){
		if(!$("#tel").val()){
			$(this).prev().fadeIn();
		};		
	});
	
	

	
});



var Utils = function(){};

Utils.prototype.loadProperties = function(lang){
	jQuery.i18n.properties({// 加载资浏览器语言对应的资源文件
		name:'ApplicationResources',
		language: lang,
		path:'resources/i18n/',
		mode:'map',
		callback: function() {// 加载成功后设置显示内容
		} 
	});	
};

Utils.prototype.getScriptArgs = function(){//获取多个参数
    var scripts=document.getElementsByTagName("script"),
    //因为当前dom加载时后面的script标签还未加载，所以最后一个就是当前的script
    script=scripts[scripts.length-1],
    src=script.src,
    reg=/(?:\?|&)(.*?)=(.*?)(?=&|$)/g,
    temp,res={};
    while((temp=reg.exec(src))!=null) res[temp[1]]=decodeURIComponent(temp[2]);
    return res;
};
