# 🔐 Spring Boot JWT Authentication with Role-Based Access Control

## 📌 Overview
This project demonstrates secure REST API authentication and authorization using **Spring Boot**, **Spring Security**, and **JWT (JSON Web Token)**.

It implements a complete authentication flow including:

- User Registration
- Login Authentication
- JWT Token Generation
- Role-Based Authorization
- Secure API Access

The system restricts access to APIs based on user roles such as **ADMIN** and **USER**.

---

# 🚀 Features

- User Registration API
- Secure Login Authentication
- JWT Token Generation
- Password Encryption using BCrypt
- Spring Security Integration
- Role-Based Authorization
- Custom JWT Filter
- Protected APIs using Authorization Header

---

# 🛠️ Tech Stack

- **Java**
- **Spring Boot**
- **Spring Security**
- **JWT (jjwt library)**
- **MySQL**
- **Maven**
- **Lombok**
- **Postman** (API Testing)

---

# 📂 Project Structure

```
security-demo
│
├── controller
│   ├── AuthController
│   ├── AdminController
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
└── dto
    ├── LoginRequest
    └── RegisterRequest
```

---

# 🔄 Authentication Flow

```
User Registers
      ↓
User Login
      ↓
JWT Token Generated
      ↓
Client Sends Token in Request Header
      ↓
JwtFilter Validates Token
      ↓
Spring Security Checks User Role
      ↓
Access Granted / Denied
```

---

# 📡 API Endpoints

## 1️⃣ Register User

**POST**

```
/auth/register
```

### Request Body

```json
{
  "name": "Snehal",
  "email": "admin@gmail.com",
  "password": "12345",
  "role": "ROLE_ADMIN"
}
```

---

## 2️⃣ Login

**POST**

```
/auth/login
```

### Request Body

```json
{
  "email": "admin@gmail.com",
  "password": "12345"
}
```

### Response

```
JWT_TOKEN
```

---

## 3️⃣ Access Admin Endpoint

**GET**

```
/admin/dashboard
```

### Header

```
Authorization: Bearer <JWT_TOKEN>
```

### Response

```
Welcome Admin
```

---

# 👑 Role-Based Authorization

| Role | Access |
|-----|------|
| ADMIN | /admin/dashboard |
| USER | Restricted |

Example security annotation:

```java
@PreAuthorize("hasRole('ADMIN')")
```

---

# 🗄️ Database Structure

## Users Table

| Column | Type |
|------|------|
| id | Long |
| name | String |
| email | String |
| password | String |
| role | String |

### Example Role Values

```
ROLE_ADMIN
ROLE_USER
```

---

# 🔒 Security Features Implemented

- Password hashing using **BCrypt**
- Stateless authentication using **JWT**
- Custom **JWT validation filter**
- Role-based endpoint protection
- Secure API access via **Authorization header**

---

# ▶️ How to Run the Project

### 1️⃣ Clone the Repository

```
git clone https://github.com/snehalsuman/Springboot-jwt-authentication.git
```

### 2️⃣ Navigate to Project Folder

```
cd Springboot-jwt-authentication
```

### 3️⃣ Configure MySQL

Update `application.properties`

```
spring.datasource.url=jdbc:mysql://localhost:3306/securitydb
spring.datasource.username=root
spring.datasource.password=yourpassword
```

### 4️⃣ Run Application

```
mvn spring-boot:run
```

### 5️⃣ Test APIs

Use **Postman** to test authentication APIs.

---

# 🔮 Future Improvements

- Refresh Token Implementation
- Global Exception Handling
- Logout with JWT blacklist
- Role & Permission Management
- Docker Deployment

---

# 👨‍💻 Author

**Snehal Suman**

GitHub:  
https://github.com/snehalsuman
