# FileContentsSaveAndSearch
Repository contains complete project full filing the requirments defined in problem statement ]

# API 1 Upload file 
This Api requires only file as input with Multipart parameter key 'file'
This API will save all unique words in DB (That does not already contains in DB) 
MongoDB document DB is used in this application Deployed on AWS 

# API 2 to search word

# 2.1 GET Request 
This will require 'word' key parameter value e.g Server_Path /search/word?word=design 
Response type  : String (A Simple message )
Response Status : 200 Search success 501 wrong input parameter 

$ 2.2 POST Request 
It requires JSON data e.g {"word":"design"}
Response type  : Application / json e.g {status:1/0} 1 if word found 0 if not found
Response Status : 200 Search success 501 wrong input parameter 

Note: This project also contains Credential of DB that will valid for some time, Also the project has been deployed on AWS elastic beanstalk 
for testing purpose. Can be tested with following URLs (Will be valid for some time )

# Frond end application for File Upload 
http://testhippest-env.t9wbntypma.us-east-2.elasticbeanstalk.com/fileUpload.html 

# Search API URL
http://testhippest-env.t9wbntypma.us-east-2.elasticbeanstalk.com/search/word
