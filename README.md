# 🔐 Spring Boot JWT Authentication & Role-Based Authorization

## 📌 Project Overview

This project is a complete implementation of **JWT Authentication with Spring Boot and Spring Security**.
It demonstrates how to secure REST APIs using **JSON Web Token (JWT)** and restrict access based on user roles like **ADMIN** and **USER**.

The application provides a full authentication flow including:

* User Registration
* Login Authentication
* JWT Token Generation
* Token Validation using Filter
* Role-Based Access Control
* Secure REST APIs

This project follows **real-world backend security architecture** used in modern applications.

---

## 🚀 Key Features

✅ User Registration API
✅ Secure Login with Spring Security
✅ JWT Token Generation & Validation
✅ Password Encryption using BCrypt
✅ Role-Based Authorization (ADMIN / USER)
✅ Custom JWT Authentication Filter
✅ Stateless Authentication (No Session)
✅ Protected APIs using Authorization Header
✅ Database Integration with JPA
✅ Clean Layered Architecture

---

## 🛠️ Tech Stack

* Java 21
* Spring Boot
* Spring Security
* JWT (jjwt)
* PostgreSQL / MySQL
* Spring Data JPA
* Maven
* Lombok
* Postman (API Testing)

---

## 📂 Project Structure

```
security-demo
│
├── controller
│   ├── AuthController
│   ├── AdminController
│   ├── UserController
│
├── service
│   ├── AuthService
│   ├── CustomUserDetailsService
│
├── security
│   ├── JwtFilter
│   ├── JwtUtil
│   ├── SecurityConfig
│
├── repository
│   └── UserRepository
│
├── entity
│   └── User
│
├── dto
│   ├── LoginRequest
│   └── RegisterRequest
│
└── SecurityDemoApplication
```

---

## 🔄 Authentication Flow

```
User Register
     ↓
User Login
     ↓
Spring Security Authentication
     ↓
JWT Token Generated
     ↓
Client stores token
     ↓
Client sends token in header
     ↓
JwtFilter validates token
     ↓
Spring Security checks role
     ↓
Access Granted / Access Denied
```

---

## 🔑 How JWT Works in This Project

1. User logs in with email & password
2. Spring Security authenticates user
3. JWT token is generated
4. Token is sent to client
5. Client sends token in every request
6. JwtFilter validates token
7. Role is checked before accessing API

Example header:

```
Authorization: Bearer <JWT_TOKEN>
```

---

## 📡 API Endpoints

### 1️⃣ Register User

POST

```
/auth/register
```

Request Body

```
{
  "name": "Abhi",
  "email": "abhi@gmail.com",
  "password": "1234",
  "role": "USER"
}
```

Response

```
User Registered Successfully
```

---

### 2️⃣ Login

POST

```
/auth/login
```

Request

```
{
  "email": "abhi@gmail.com",
  "password": "1234"
}
```

Response

```
JWT_TOKEN
```

---

### 3️⃣ Access User API

GET

```
/user/profile
```

Header

```
Authorization: Bearer <TOKEN>
```

Response

```
User Profile
```

---

### 4️⃣ Access Admin API

GET

```
/admin/dashboard
```

Header

```
Authorization: Bearer <TOKEN>
```

Response

```
Welcome Admin
```

---

## 👑 Role-Based Authorization

| Role  | Access    |
| ----- | --------- |
| ADMIN | /admin/** |
| USER  | /user/**  |

Example

```java
@PreAuthorize("hasRole('ADMIN')")
```

```java
@PreAuthorize("hasRole('USER')")
```

---

## 🗄️ Database Table

### users

| Column   | Type   |
| -------- | ------ |
| id       | Long   |
| name     | String |
| email    | String |
| password | String |
| role     | String |

Example roles:

```
ROLE_ADMIN
ROLE_USER
```

---

## 🔒 Security Features

* BCrypt Password Encoding
* Stateless Authentication using JWT
* Custom JWT Filter
* Secure REST APIs
* Role-Based Access Control
* Spring Security Configuration
* Authorization Header Validation

---

## ▶️ How to Run

### 1️⃣ Clone Project

```
git clone https://github.com/yourusername/springboot-jwt-authentication
```

### 2️⃣ Open Project

```
cd springboot-jwt-authentication
```

### 3️⃣ Configure Database

application.properties

```
spring.datasource.url=jdbc:postgresql://localhost:5432/securitydb
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4️⃣ Run

```
mvn spring-boot:run
```

### 5️⃣ Test APIs

Use Postman

* Register
* Login
* Copy token
* Use Bearer token
* Access APIs

---

## 🔮 Future Improvements

* Refresh Token
* Logout API
* Exception Handling
* Permission Based Security
* Docker Deployment
* Spring Security OAuth2
* API Rate Limiting

---

## 👨‍💻 Author

Abhijeet Kumar

GitHub:
https://github.com/Abhijeetkumar17

Backend Developer | Spring Boot | Java | Security | JWT
