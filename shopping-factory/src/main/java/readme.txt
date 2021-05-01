Steps to Import and Run the project

Step 1:
Clone to your Local by using below path or download zip
https://github.com/RavikiranMPatel/demoShopping.git

Step 2:
open Eclipse or Any IDE and import as Maven project

Step 3:
update the maven project and clean the project

Step 4:
In application.properties file Database setting are mentioned.
I have used mysql server as it is open source (just create the schema in the name of "shopping_factory_schema" in mysql Server)

Step 5;
Right Click on top of the project and Run as Java Application

Once the application is up and running, you can use the below Http Methods using Postman 

by Default there is basic Authentication to secure end points
username : Admin
password : Admin1

# GET
	http://localhost:8081/users

# GET By ID
	http://localhost:8081/userById/1

# POST
	http://localhost:8081/addUser

# PUT
	http://localhost:8081/updateUser
Specify the id and update the fields which needs to be updated

# DELETE
	http://localhost:8081/deleteUser/1

# Requests

	{
	"name":"Ravikiran",
"phoneNumber":"+91888418888",
"emailId":"rkmpatel8@gmail.com",
"active":"true",
"gender":"Male",
"city":"Mysore",
"state":"Kar",
"pincode":570008,
"address":"Jp Nagar"
}


 For Update
 
 {
 "id":"1",
	"name":"Ravikiran",
"phoneNumber":"+91888418888",
"emailId":"rkmpatel8@gmail.com",
"active":"true",
"gender":"Male",
"city":"Mysore",
"state":"Kar",
"pincode":570008,
"address":"Jp Nagar"
}
	
Note : I could not implement swagger as dead line is saturday and i could not concentrate on this because of my office work