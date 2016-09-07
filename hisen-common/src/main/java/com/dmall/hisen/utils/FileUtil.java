package com.dmall.hisen.utils;

import java.io.*;

public class FileUtil {
	//读取文件
	public static byte[] getContent(String filePath){  
        File file = new File(filePath);  
        long fileSize = file.length();  
        if (fileSize > Integer.MAX_VALUE) {  
            System.out.println("file too big...");  
            return null;  
        } 
        FileInputStream fi = null;
        byte[] buffer = null;
        try{
        	fi = new FileInputStream(file);  
            buffer = new byte[(int) fileSize];  
            int offset = 0;  
            int numRead = 0;  
            while (offset < buffer.length && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {  
                	offset += numRead;  
            }  
            // 确保所有数据均被读取  
            if (offset != buffer.length) {  
            	throw new IOException("Could not completely read file " + file.getName());  
            }  
            fi.close();  
            
        }catch(Exception e){
        	e.printStackTrace();
        }
        return buffer;  
    }
	//写入文件
	public static void createFile(String path, byte[] content){
       try{
    	   FileOutputStream fos = new FileOutputStream(path);
           fos.write(content);
           fos.close(); 
       }catch(IOException e){
    	   e.printStackTrace();
       }
        
    }

    public static String readFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists() || file.isDirectory())
            throw new FileNotFoundException();
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[1024];
        StringBuffer sb = new StringBuffer();
        while ((fis.read(buf)) != -1) {
            sb.append(new String(buf));
            buf = new byte[1024];// 重新生成，避免和上次读取的数据重复
        }
        return sb.toString();

    }
}
