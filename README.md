# Subshub - Subscription Management API

A **Spring Boot** application for managing subscriptions, users, and services.  
This project provides REST APIs for public access, user-level operations, and admin functionalities.

---

## 🚀 Features
- User authentication with JWT
- Admin APIs to manage users & subscriptions
- User APIs to manage personal services
- Search subscription services
- Health check endpoint

---

## ⚙️ Tech Stack
- Java 21
- Spring Boot 3.5.0
- Spring Security (JWT)
- Hibernate & JPA
- Database: Configurable (Postgres/MySQL/etc.)
- Maven

---

## 📂 Project Structure
```
src
└── main
├── java/com/manishjajoriya/subshub
│ ├── config/               # Security-related configuration
│ ├── controller/           # REST API controllers
│ ├── dto/                  # Data Transfer Objects
│ ├── entity/               # JPA Entities 
│ ├── exceptionhandler/     # Global exception handling (validation errors, security exceptions)
│ ├── filter/               # Custom JWT authentication/authorization filters
│ ├── repository/           # JPA repositories (interface layer for DB access)
│ ├── service/              # Business logic layer
│ ├── util/                 # Utility/helper classes
│ └── SubshubApplication.java
│
└── resources
  └── application.properties # Central configuration file (DB, logging, server, JWT properties)
```

## ▶️ Running the Project

### 1. Clone repository
```bash
git clone git@github.com:manishjajoriya/subshub-backend.git
cd subshub-backend
````

### 2. Configure environment variables

Set the required database & app variables in your system or in `application.properties`:

```properties
spring.application.name=subshub

# Logging
logging.pattern.console=${LOGPATTERN_CONSOLE:%green(%d{HH:mm:ss.SSS}) %blue(%-5level) %red([%thread]) %yellow(%logger{15}) - %msg%n}
logging.level.org.springframework.security=${SPRING_SECURITY_LOG_LEVE:TRACE}

# Database
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=${DATABASE_USERNAME:postgres}
spring.datasource.password=${DATABASE_PASSWORD:postgres}
spring.jpa.database-platform=${HIBERNATE_DIALECT:org.hibernate.dialect.PostgreSQLDialect}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=${JPA_SHOW_SQL:true}

# Base url
server.servlet.context-path=/api/v1

# JWT
JWT_SECRET = ${JWT_SECRET:t9BXEIzc682tw9TY}
```

### 3. Build the project

```bash
mvnw clean install
```

### 4. Run the application

```bash
mvnw spring-boot:run
```

The API will be available at:  
👉 `http://localhost:8080/api/v1`

---

## 📌 Available Endpoints

### 🔓 Public (`/public`)

- `GET /health-check` → Health status
    
- `POST /sign-up` → Register new user
    
- `POST /login` → Authenticate and receive JWT token
    

### 👤 User (`/user`)

- `GET /my-data` → Get logged-in user’s data
    
- `POST /add-new-service` → Add new subscription service
    
- `DELETE /delete-service?did={uuid}` → Delete a subscription
    
- `GET /last-update` → Last update timestamp
    

### 👮 Admin (`/admin`)

- `GET /all-users` → Fetch all users
    
- `GET /all-user-data` → Fetch all user data
    
- `GET /all-subscription` → Fetch all subscriptions
    
- `POST /add-admin-user` → Create new admin user
    

### 📡 Subscription (`/service`)

- `GET /search?name={subscriptionName}` → Search subscription service
    

---

## 🛡️ Authentication

- Uses **JWT tokens** for securing `/user` and `/admin` routes.
    
- Obtain token from `/public/login` and pass it in:
    

```http
Authorization: Bearer <token>
```

---

## 🧪 Example cURL Requests

### 1. Health Check

```bash
curl -X GET http://localhost:8080/api/v1/public/health-check
```

### 2. Sign Up

```bash
curl -X POST http://localhost:8080/api/v1/public/sign-up \
  -H "Content-Type: application/json" \
  -d '{
    "email": "john@example.com",
    "password": "SecurePass123",
    "name": "John Doe"
  }'
```

### 3. Login (Get JWT Token)

```bash
curl -X POST "http://localhost:8080/api/v1/public/login?email=john@example.com&password=SecurePass123"
```

### 4. Access User Data (Requires JWT)

```bash
curl -X GET http://localhost:8080/api/v1/user/my-data \
  -H "Authorization: Bearer <your_jwt_token>"
```

---

## ✅ Health Check

```bash
GET /api/v1/public/health-check
```

Response:

```json
"health-check : OK"
```

---
