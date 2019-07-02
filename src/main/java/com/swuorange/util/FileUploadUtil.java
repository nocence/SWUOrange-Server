package com.swuorange.util;



import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class FileUploadUtil {
	/**
	 * 文件分割	新文件生成在目标文件夹中
	 * @param sourceFile	要分隔的目标文件
	 * @throws IOException 
	 * 分割的文件为:	原文件名.原后缀.序号
	 */
	public static void divisionFile(File sourceFile) throws IOException{
		//文件夹路径
		String folder = sourceFile.getParent();
		// 默认文件切割的数量
		int np = 5;
		//每一个小文件的大小
		long fileLength = sourceFile.length() / np; 
		byte[] b = new byte[1024];
		RandomAccessFile readRAF = new RandomAccessFile(sourceFile, "r");
		int len = -1;
		for (int i = 0; i < np; i++) {
			//分割的子文件名
			String name = sourceFile.getName() + "." + (i + 1);
			File file = new File(folder + File.separator + name);
			file.createNewFile();
			RandomAccessFile writeRAF = new RandomAccessFile(file, "rw");
			while ((len = readRAF.read(b)) != -1) {
				writeRAF.write(b, 0, len);
				// 到达写入量，换下一个文件
				if (writeRAF.length() > fileLength)break;
			}
			writeRAF.close();
		}
		readRAF.close();
	}
	
	/**
	 * 文件合并->文件格式:前缀名.后缀名.节点
	 * @param pdFilePath	片段文件夹路径
	 * @throws IOException 
	 * 合并的文件默认在同一个文件夹
	 * @return	合并后的文件名
	 */
	public static String mergeFile( String pdFilePath ) throws IOException{
		File folder = new File(pdFilePath);
		File[] pdFiles = folder.listFiles();
		if( pdFiles == null || pdFiles.length <= 0 )throw new IOException("没找到合并文件！");
		//合并后的文件名
		String newFileName = pdFiles[0].getName().substring(0, pdFiles[0].getName().lastIndexOf("."));
		//待合并的片段文件
		String pdFile = pdFilePath + File.separator + newFileName + ".";
		
		File newFile = new File(pdFilePath + File.separator + newFileName);
		newFile.createNewFile();
		
		//合并操作
		RandomAccessFile writeRAF = new RandomAccessFile(newFile, "rw");
		writeRAF.setLength(0);
		writeRAF.seek(0);
		byte[] bytes = new byte[1024];
		int len = -1;
		for(int i = 0; i < pdFiles.length; i++) {
			pdFiles[i] = new File(pdFile + (i + 1));
		    RandomAccessFile readRSF = new RandomAccessFile(pdFiles[i], "r");
		    while((len = readRSF.read(bytes)) != -1) {
		        writeRAF.write(bytes, 0, len);
		    }
		    readRSF.close();
		}
		writeRAF.close();
		return newFileName;
	}
	
	/**
	 * 获取文件夹中文件总大小,不包含子文件夹
	 * @param fileFolder	文件夹路径
	 * @return	文件总大小字节数
	 */
	public static long getFileTotalSize(String fileFolder){
		long totalBytes = 0;
		File folder = new File(fileFolder);
		File[] files = folder.listFiles();
		for (File file : files) {
			if( file.isFile() ){
				totalBytes += file.length();
			}
		}
		return totalBytes;
	}
	
	/**
	 * 删除除指定文件之外的文件
	 * @param excFileName	指定文件名
	 * @param folderPath	文件夹路径
	 */
	public static void delExcFile( String excFileName, String folderPath){
		File folder = new File(folderPath);
		File[] files = folder.listFiles();
		for (File file : files) {
			if( !file.getName().equals(excFileName) ){
				file.delete();
			}
		}
	}
	
	/**
	 * 获取WebRoot中指定文件夹中对应文件大小
	 * @param fileName		文件名
	 * @param folderPath	文件夹名称
	 * @return
	 */
	public static Long getFileSize(String fileName, String folderName){
		try {
			File upFile = getUpFile(fileName, folderName);
			if(!upFile.exists()) {	
				
				upFile.createNewFile();
			} 
			return upFile.length();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 获取已经上传文件对象
	 * @param fileName		文件名
	 * @param folderName	上传文件夹
	 * @return
	 */
	public static File getUpFile(String fileName, String folderName){
		String clasPath = FileUploadUtil.class.getResource("/").getPath();
		String newclassPath = clasPath.replaceAll("WEB-INF/classes/", "");		
		String uploadFolder = newclassPath + File.separator + folderName;
		File upFileFolder = new File(uploadFolder + File.separator);
		
		if(!upFileFolder.isDirectory()){
			upFileFolder.mkdir();
		}
		File upFile = new File(uploadFolder + File.separator + fileName);
		
		return upFile;
	}
	
	
	/**
	 * 向文件中追加内容
	 * @param fileName
	 * @param folderName
	 * @param len
	 * @param byts
	 */
	public static Long addFileContent(String fileName, String folderName, int len, byte[] byts){
		File file = getUpFile(fileName, folderName);
		//RandomAccessFile是File的一个封装类，可以用于操作文件指针，调整文件大小（分割，合并）
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "rw");
			//将文件内容的指针移动到指定位置
			raf.seek(getFileSize(fileName, folderName));
			
			raf.write(byts, 0, len);
			raf.close();
			return getFileSize(fileName, folderName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
}









