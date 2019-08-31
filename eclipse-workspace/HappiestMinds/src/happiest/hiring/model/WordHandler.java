package happiest.hiring.model;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public class WordHandler {
	
	
	public boolean insertAllWords(String line) {
		
		boolean result = false;
		
		
		try {
			line = line.trim();
			//Split for individual words
			String[]  words = line.split(" ");
		
			for(String str: words) {
				str = str.trim();
				if(!str.equals("")) {
					//Saving to Doc
					//Inserting as value of key _id that will always be unique 
					 Document doc = new Document();
					 doc.append("_id", str);
					 saveWord(str);
				}
				
			} 
			  result = true;
			
			
		}catch(Exception e) {
			System.out.println(e.toString());
			result = false;
		}
		
		return result;
		
		
	}
	
	private void saveWord(String word) {
		
		  MongoDatabase db= DatabaseConnection.getMongoConnection();
		  MongoCollection<Document> col=db.getCollection("wordCollection");
		 Document doc = new Document();
		 doc.append("_id", word);
		 col.insertOne(doc);
	}
	
	
	public boolean isWordExists(String word) {
		
		boolean result = false;

		  MongoDatabase db= DatabaseConnection.getMongoConnection();
		  MongoCollection<Document> col=db.getCollection("wordCollection");
		 Document doc = new Document();
		 doc.append("_id", word);
		 
		 if(col.find(doc).iterator().hasNext()) {
			 result =true;
		 }
		 return result;
		 
		
		
		
	}
	
	public static void main(String [] args) {
		
		WordHandler hand = new WordHandler();
		//hand.saveWord("test");
		
		System.out.println("Search result "+hand.isWordExists("test"));
		
	}
	
	
	

}
