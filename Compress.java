/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream; 

/**
 *
 * @author Girish Doshi
 */
public class Compress {
    public static void method(File file) throws IOException{ //take care of file not found execption 
       String fileDirectory = file.getParent();//it will teke the file path anem
       System.out.println(fileDirectory);
       FileInputStream fis = new FileInputStream(file); //read the content which is inside this file 
       FileOutputStream fos = new FileOutputStream(fileDirectory + "\\compressedfile.gz");//store the content into file
      
//now we need to convert our file into gz format      
       GZIPOutputStream gzipOS = new GZIPOutputStream(fos); //convert file into GZIP format 
       byte [] buffer = new byte[1024];
       int len;
      while((len=fis.read(buffer))!=-1) // it will read the content from fis and store it into buffer array 
       {
           gzipOS.write(buffer,0,len);
       }
       fis.close();
       gzipOS.close();
       fos.close();
       
    }
    public static void main(String args []) throws IOException{
        File path = new File("C:\\Users\\Girish Doshi\\OneDrive\\Desktop\\hello.txt");
        method(path);
    }
}
