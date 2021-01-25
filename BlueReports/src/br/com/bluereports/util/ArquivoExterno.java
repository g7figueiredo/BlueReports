package br.com.bluereports.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

public class ArquivoExterno {
	
	public StreamedContent getStreamedContent(byte[] buffer) {
        try {

             InputStream is = new ByteArrayInputStream(buffer);
             DefaultStreamedContent image = new DefaultStreamedContent(is);
            return image;
        } catch (Exception e) {
            return new DefaultStreamedContent();
        }
    }
	
	public byte[] getBytes(File file){
		int len = (int) file.length();
		byte[] sendBuf = new byte[len];
		
		FileInputStream inFile = null;
		
		try{
			inFile = new FileInputStream(file);
			inFile.read(sendBuf, 0, len);
		}catch (FileNotFoundException fnfex) {
			fnfex.printStackTrace();
		}catch (IOException ioex) {
			ioex.printStackTrace();
		}
		
		return sendBuf;
	}
	
	
	public byte[] getBytes(UploadedFile uFile){
		
		if(uFile == null) {
			return null;
		}
		
		byte[] sendBuf = null;
		
		try {
			InputStream is = uFile.getInputstream();
			sendBuf = new byte[is.available()];
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return sendBuf;
	}
	
}
