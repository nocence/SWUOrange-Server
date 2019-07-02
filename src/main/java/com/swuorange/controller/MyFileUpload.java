package com.swuorange.controller;

import java.io.InputStream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.swuorange.data.ResultData;
import com.swuorange.dto.Result;
import com.swuorange.util.FileUploadUtil;

@RestController
@RequestMapping("MyFile")
public class MyFileUpload {
	
	
	//获取用户上传的文件名
	@RequestMapping("checkName")
	@ResponseBody
	public Result checkFileName(String fileName){
		//获取上传文件名	
		
		System.out.println("用户上传文件的请求"+fileName);
		
		long upByte;
		Result res = null;		
		//获取服务器已传文件大小
		upByte = FileUploadUtil.getFileSize(fileName, "upload");
		res=new Result(ResultData.SUCCESS_CODE,"返回已上传大小成功",upByte);		
		//返回已上传大小
		return res;
		
	}
	
	//获取用户上传的文件名
	@RequestMapping("uploadFile")
	@ResponseBody
	public Result getQualityList(MultipartFile file,String fileName){
		Result res = null;	

		try {
			InputStream fis = file.getInputStream();	
			byte[] byts = new byte[10 * 1024 * 1024];
			int len = fis.read(byts);
			long endByte = FileUploadUtil.addFileContent(fileName, "upload", len, byts);
			
			res=new Result(ResultData.SUCCESS_CODE,"返回已上传大小成功",endByte);		

			
			//获取服务器已传文件大小
		
			//返回已上传大小
			return res;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	

}
