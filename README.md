# 🏨 Hostel Grievance & Outpass Management System  

A **full-stack web application** built with  Spring Boot, and MySQL** to manage hostel complaints and outpass requests seamlessly.  

## 🚀 Features  

### 🏠 **Student Dashboard**  
- Submit outpass requests & check approval status  
- File complaints about hostel facilities  
- View the status of submitted complaints  

### 🛡️ **Warden Dashboard**  
- Approve or reject student outpass requests  
- Review and resolve student complaints  

### 🔐 **Authentication**  
- Students login using **Reg No & DOB**  
- Wardens login using **Username & Password**  

## 🛠️ Tech Stack  
**Frontend:** React, Tailwind CSS  
**Backend:** Spring Boot, MySQL  
**Database:** MySQL (Tables: `stu_log`, `war_log`)  

2️⃣ Backend (Spring Boot Setup)
Open the backend folder in your IDE
Configure application.properties for MySQL
Run the Spring Boot application


📜 API Endpoints
Endpoint	Method	Description
/api/login/student	POST	Student login
/api/login/warden	POST	Warden login
/api/outpass/request	POST	Submit outpass request
/api/outpass/status/{regNo}	GET	Check outpass status
/api/complaint/submit	POST	File a complaint
/api/complaint/status/{regNo}	GET	View complaint status

