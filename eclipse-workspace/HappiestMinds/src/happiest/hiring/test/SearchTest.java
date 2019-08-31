package happiest.hiring.test;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;



public class SearchTest {

	
	static String aws="http://testhippest-env.t9wbntypma.us-east-2.elasticbeanstalk.com";
	static String local="http://localhost:8080/HappiestMinds";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		post_data();
		//getTest();
		

}

	public static void post_data() {
		String query_url = aws +"/search/word";

	        JSONObject json1=new JSONObject();
	     
	        try {
	       
	        	
	     	   // searching word Design
	     	 json1.put("word", "Design");
	     	
	     	 
	    
	     	 
	     	   
	     	  String json=json1.toString();
	      	
	    
	         URL url = new URL(query_url);
	         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	         conn.setConnectTimeout(5000000);
	         
	         conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	         conn.setDoOutput(true);
	         conn.setDoInput(true);
	         conn.setRequestMethod("POST");
	         OutputStream os = conn.getOutputStream();
	         os.write(json.getBytes("UTF-8"));                     
	         os.close(); 
	         // read the response
	         InputStream in = new BufferedInputStream(conn.getInputStream());
	         String result = IOUtils.toString(in, "UTF-8");
	       
	
	         System.out.println(result);
	         JSONObject responseData = new JSONObject(result);
	         int status = responseData.getInt("status");
	         
	         if(status == 1) {
	        	 System.out.println("Test Successfull : Word found");
	        	 
	         }
	         else {
	        	 System.out.println("Test Successfull : Word Not found");
	         }
	         
	         in.close();
	         conn.disconnect();
	         } catch (Exception e) {
	        	 System.out.println("Test Unsuccessful");
	 			System.out.println(e);
	         }
		}
	
	
	
}
