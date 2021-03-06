package com.swuorange.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static String saveFile(String originalFilename, String projectPath, MultipartFile file) {
		try {
			// 获取文件后缀
			String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
			// 生成uuid的文件名
			String fileName = UUID.randomUUID().toString();
			// 文件名加后缀
			fileName = fileName + suffix;
			// 项目名+/
			String path = projectPath + File.separator;
			// 根据年月日生成文件夹
			Date date = new Date();
			String year = new SimpleDateFormat("yyyy").format(date);
			String month = new SimpleDateFormat("MM").format(date);
			String day = new SimpleDateFormat("dd").format(date);
			// 文件夹路径

			path = path + "uploaded" + "/" + year + "/" + month + "/" + day;
			path = path.replace("\\", "/");
			// 创建文件夹
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			// 文件全路径
			String url = path + "/" + fileName;
			File desFile = new File(url);
			// 保存文件到本地
			file.transferTo(desFile);
			String access = "uploaded" + "/" + year + "/" + month + "/" + day + "/" + fileName;

			return access;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
