package happiest.hiring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileUploadException;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;

import com.oreilly.servlet.MultipartRequest;

import happiest.hiring.model.WordHandler;

@MultipartConfig
@WebServlet({ "/FileUploadApi", "/api/file/upload" })
public class FileUploadApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
 

	//Controller according to (MVC architecture) that will serve when file will upload
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().write("wring request");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Part file = request.getPart("file");
	        String filename = getFilename(file);
	        InputStream filecontent = file.getInputStream();
	        System.out.println("Done");
	        Scanner sn = new Scanner(filecontent);
	        WordHandler hand = new WordHandler();
	        while(sn.hasNextLine()) {
	        	
	        	//System.out.println(sn.nextLine());
	        	boolean b = hand.insertAllWords(sn.nextLine());
	        	System.out.println(b);
	        	
	        }
	        sn.close();
	        System.out.println("Finished operation");
	        response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write("File " + filename + " successfully uploaded");
	    }

	    private static String getFilename(Part part) {
	        for (String cd : part.getHeader("content-disposition").split(";")) {
	            if (cd.trim().startsWith("filename")) {
	                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	            }
	        }
	        return null;
	    }

}
