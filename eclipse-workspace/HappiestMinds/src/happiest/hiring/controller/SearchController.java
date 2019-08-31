package happiest.hiring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import happiest.hiring.model.Payload;
import happiest.hiring.model.WordHandler;

// Controller for search API


@WebServlet({ "/SearchController", "/search/word" })
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
    public SearchController() {
        super();
        
    }

	// Parameter value word will be search 
    //Not: It case sensitive search 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String str= request.getParameter("word");
		
		if(str == null) {
			response.setStatus(501); // Wrong input
		}
		else {
			try {
				search(str,response.getWriter());
				response.setStatus(200); // result ok 
			}catch(Exception e) {
				System.out.println(e);
				response.setStatus(502); // Server error
			}
		}
		
		
		
		
	}

	//Post request should pass JSON Data e.g {"word":"design"}
	//Not: It case sensitive search
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			
			//Post request read JSON Data
		
		
			String str = Payload.readJson(request);
			response.setContentType("application/json");
			try {
				JSONObject json = new JSONObject(str);
				search(json,response.getWriter());
				response.setStatus(200); // Result OK 
				
			}catch(Exception e) {
				
				System.out.println(e.toString());
				response.setStatus(502);
			}
			
			
			
			
					
			
			
			
		
	}
	
	private void search(String str, PrintWriter out)throws Exception {
		WordHandler handler = new WordHandler();
		
		if(handler.isWordExists(str.trim())) {
			out.write("Word found successfully");
		}
		else {
			out.write("Word does not exists in DB");
		}
		
	}
	private void search(JSONObject json , PrintWriter out) throws Exception{
		WordHandler handler = new WordHandler();
		JSONObject responseData =new JSONObject();
		String str = json.getString("word");
		
		if(handler.isWordExists(str.trim())) {
			
			responseData.put("status", 1);
		}
		else {
			responseData.put("status", 0);
		}
		out.write(responseData.toString());
		
	}

}
