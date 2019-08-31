package happiest.hiring.model;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

public class Payload {
	public static String readJson(HttpServletRequest rq)
	{
		StringBuilder sb=new StringBuilder();
		BufferedReader bf;
		try
		{
			bf=rq.getReader();
			String line;
			while((line=bf.readLine())!=null)
				sb.append(line).append("\n");
			
		}
		catch(Exception e)
		{
			
		}
		return sb.toString();
	}

}

