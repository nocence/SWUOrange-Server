//封装ajax
//参数依次为url data数据   成功的函数   失败的函数
function sendAjax(myUrl, myData, mySuccess,myError){
	//创建加解密对象
	var encrypt = new JSEncrypt();
	//设置公钥
	encrypt.setPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPV1BM0YOsrfQIbYDkzyqsxtwIQT2ETYAskfUDxl7RNfZAAJGVxKD2KAyHdAv5bYRLKejAvPUBulSII45pM7iWK4Fb0D5YNomVtcMYijGn2B9vumKtLxBxOQAkt5VVVJE2zu6Dj1S/IGhgdkdBwLvmnsyogrmFIW6AqRnOV/JkLQIDAQAB");
	//获取时间
	var nowtime = Date.parse(new Date());
	//获取密码加时间的密钥
    var mykey = "swuOrange" +"|"+ nowtime;
	//进行编码
    var m = encrypt.encrypt(mykey);
	//向数据中添加签名
	myData.passSign = m;
	$.ajax({
		xhrFields:	{withCredentials: true},
		url:myUrl,
		type:"POST",
		data:myData,
		dataType:'json',
		success:mySuccess,
		error:myError
	});
}


//封装vue的ajax请求

function sendAxios(myUrl, myData){
	//在每次ajax提交之前加上签名内容
    //创建加解密对象
    var encrypt = new JSEncrypt();
    //设置公钥
    encrypt.setPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPV1BM0YOsrfQIbYDkzyqsxtwIQT2ETYAskfUDxl7RNfZAAJGVxKD2KAyHdAv5bYRLKejAvPUBulSII45pM7iWK4Fb0D5YNomVtcMYijGn2B9vumKtLxBxOQAkt5VVVJE2zu6Dj1S/IGhgdkdBwLvmnsyogrmFIW6AqRnOV/JkLQIDAQAB");
    var nowtime = Date.parse(new Date());
	//获取密码加时间的密钥
    var mykey = "swuOrange" +"|"+ nowtime;
	//进行编码
    var m = encrypt.encrypt(mykey);
	//向数据中添加签名
	myData.passSign = m;
    //向数据中添加签名
	//返回promise对象
    return new Promise((resolve,reject) =>{
        //创建axios实例，把基本的配置放进去
        const instance = axios.create({
    	    method: "POST",//请求方式
            url:myUrl,//请求地址
    	    params: myData
         });
        //请求成功后执行的函数
         instance(myUrl,"POST", myData).then(res =>{
             resolve(res);
         //失败后执行的函数
         }).catch(err => {
             reject(err);
         })
     });
}