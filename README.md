# Reactive Employee Management Service

This project is a Spring Boot-based reactive microservice that demonstrates functional programming and reactive programming principles using Spring WebFlux. It provides RESTful endpoints for managing employee data through a clean and decoupled architecture.

## Features

- **Reactive Programming:** Leverages Spring WebFlux for non-blocking, asynchronous request handling.
- **Functional Endpoints:** Uses functional routing with `RouterFunction` and `HandlerFunction` instead of traditional annotation-based controllers.
- **Clean Architecture:** Organized into clear layers (model, repository, service, handler, configuration) to promote separation of concerns.
- **Functional Constructs:** Utilizes Java 8 features like lambda expressions, Streams, and Optionals to build concise and expressive code.

## Project Structure

```txt
src/
└── main/
├── java/com/webflux/reactive_programming/
│   ├── ReactiveProgrammingApplication.java
│   ├── config/
│   │   └── RouterConfig.java
│   ├── handler/
│   │   └── EmployeeHandler.java
│   ├── model/
│   │   └── Employee.java
│   ├── repository/
│   │   └── EmployeeRepository.java
│   └── service/
│       └── EmployeeService.java
└── resources/
└── application.properties
```

## Getting Started

### Prerequisites

- **Java 8 or higher**
- **Maven**

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/reactive-employee-service.git
    cd reactive-employee-service
    ```

2. **Build the project:**

    ```bash
    mvn clean install
    ```

3. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

The service will start running on [http://localhost:8080](http://localhost:8080).

## API Endpoints

### 1. Get All Employees

- **URL:** `/employees`
- **Method:** `GET`
- **Response:** Returns a JSON array of all employee objects.

### 2. Get Employee by ID

- **URL:** `/employees/{id}`
- **Method:** `GET`
- **Response:** Returns a JSON object of the employee with the specified ID.  
- **Note:** This endpoint uses `pathVariable` from `ServerRequest` to extract the employee ID from the URL. Ensure that the method signature in the handler is defined with a `ServerRequest` parameter to avoid errors.

### 3. Create Employee

- **URL:** `/employees`
- **Method:** `POST`
- **Body:** JSON object representing the new employee (e.g., `{"id":3, "name":"Alice", "role":"Developer"}`)
- **Response:** Returns the created employee object.

## Error Handling

- **404 Not Found:** Returned if the requested employee is not found.
- **400 Bad Request:** Returned for malformed requests.

## Tests

<img width="1146" alt="Screenshot 2025-03-09 at 1 10 35 AM" src="https://github.com/user-attachments/assets/de3f9fc8-1f3e-42db-bd78-0ee0983dc72a" />
<img width="816" alt="Screenshot 2025-03-09 at 1 09 17 AM" src="https://github.com/user-attachments/assets/11c69cb4-17d5-4db7-9878-5deb52e27934" />
<img width="1147" alt="Screenshot 2025-03-09 at 1 16 02 AM" src="https://github.com/user-attachments/assets/33e38440-5316-40ff-b1fc-2b9c65ff3fc4" />
<img width="811" alt="temp" src="https://github.com/user-attachments/assets/74d8efbe-438d-4155-8d70-f045e2b552d7" />
