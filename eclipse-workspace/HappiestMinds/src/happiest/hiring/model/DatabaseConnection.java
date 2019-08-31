 package happiest.hiring.model;

import java.util.Arrays;


import org.bson.Document;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnection {
	
	public static MongoDatabase getMongoConnection(int x) {
	
		MongoClient mongoClient=MongoClients.create();
		MongoDatabase db = mongoClient.getDatabase("mydb");
		return db;
		
	}
	
	
	
	
	
	public static MongoDatabase getMongoConnection() {
		String user="nex2medb";
		
		
		
		String source="mydb"; // the name of the database in which the user is defined
		char[] password="introtuceno1".toCharArray(); // the password as a character array
		MongoCredential credential = MongoCredential.createScramSha256Credential(user, source, password);
		MongoClient mongoClient = MongoClients.create(
		        MongoClientSettings.builder()
		                .applyToClusterSettings(builder -> 
		                        builder.hosts(Arrays.asList(new ServerAddress("18.188.71.33", 27017))))
		                .credential(credential)
		                .build());
		 MongoDatabase db = mongoClient.getDatabase("mydb");
		// mongoClient.close();
		 return db;
		//return getMongodata();
		
	}


	
	
	
	
}
