# Cinema REST API

![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green?logo=springboot)
![Gradle](https://img.shields.io/badge/Gradle-7%2B-blue?logo=gradle)
![Status](https://img.shields.io/badge/Status-Complete-brightgreen)
![Architecture](https://img.shields.io/badge/Architecture-REST%20API-blueviolet)

A Spring Boot REST API for managing a cinema hall with seat booking functionality. The application simulates a cinema ticket booking system with seat reservation, ticket return, and statistics tracking.
This project was completed as part of the [Hyperskill](https://hyperskill.org/projects/189) educational project.

## Project Structure

```
cinema-rest/
├── src/main/java/irmalerrr/cinemaRest/
│   ├── controller/
│   │   ├── CinemaController.java         # Main REST controller
│   │   └── ControllerExceptionHandler.java # Global exception handler
│   ├── dto/
│   │   ├── CinemaHallDto.java           # Data Transfer Objects
│   │   └── SeatDto.java
│   ├── model/
│   │   ├── CinemaHall.java              # Domain models
│   │   ├── Reservation.java
│   │   ├── Seat.java
│   │   └── Statistic.java
│   └── CinemaRestApplication.java       # Spring Boot application entry point
├── src/main/resources/
│   └── application.properties           # Application configuration
└── build.gradle                         # Gradle build configuration
```

## Features

- **Seat Management**: View available seats in a 9x9 cinema hall
- **Ticket Booking**: Purchase tickets with unique token generation
- **Ticket Return**: Return purchased tickets using tokens
- **Statistics**: View cinema statistics with password protection
- **Error Handling**: Comprehensive error responses for invalid operations

## API Endpoints

### 1. **Get Available Seats**
```http
GET /seats
```

**Response (200 OK):**
```json
{
  "total_rows": 9,
  "total_columns": 9,
  "available_seats": [
    {
      "row": 1,
      "column": 1,
      "price": 10
    },
    {
      "row": 1,
      "column": 2,
      "price": 10
    }
    // ... more seats
  ]
}
```

### 2. **Purchase a Ticket**
```http
POST /purchase
Content-Type: application/json
```

**Request:**
```json
{
  "row": 3,
  "column": 4
}
```

**Success Response (200 OK):**
```json
{
  "token": "e631a5e3-49c5-4fe5-9bb7-7f55e8156a8e",
  "ticket": {
    "row": 3,
    "column": 4,
    "price": 10
  }
}
```

**Error Responses:**
- `400 BAD_REQUEST`: Seat out of bounds or already purchased
- `404 NOT_FOUND`: Seat not found

### 3. **Return a Ticket**
```http
POST /return
Content-Type: application/json
```

**Request:**
```json
{
  "token": "e631a5e3-49c5-4fe5-9bb7-7f55e8156a8e"
}
```

**Success Response (200 OK):**
```json
{
  "returned_ticket": {
    "row": 3,
    "column": 4,
    "price": 10
  }
}
```

**Error Response:**
- `400 BAD_REQUEST`: Invalid or expired token

### 4. **Get Statistics**
```http
GET /stats?password=super_secret
```

**Success Response (200 OK):**
```json
{
  "current_income": 150,
  "number_of_available_seats": 78,
  "number_of_purchased_tickets": 3
}
```

**Error Response:**
- `401 UNAUTHORIZED`: Incorrect or missing password

## Pricing Strategy

- **First 4 rows**: $10 per seat
- **Remaining rows**: $8 per seat

## Security

- Statistics endpoint protected with password: `super_secret`
- Each ticket purchase generates a unique UUID token
- Token-based seat return system

## Technology Stack

![Spring Web](https://img.shields.io/badge/Spring%20Web-REST%20Controller-brightgreen)
![DTO Pattern](https://img.shields.io/badge/Pattern-Data%20Transfer%20Object-blue)
![Exception Handling](https://img.shields.io/badge/Error%20Handling-Global%20Handler-red)
![JSON](https://img.shields.io/badge/Data%20Format-JSON-ff69b4)

- **Spring Boot 3.x** - Application framework
- **Java 17+** - Programming language
- **Gradle** - Build tool and dependency management
- **RESTful Architecture** - Resource-oriented API design
- **DTO Pattern** - Clean separation between models and API responses

## Getting Started

### Prerequisites
- Java 17 or higher
- Gradle 7+ (wrapper included)

### Build and Run

```bash
# Build the application
./gradlew build

# Run the application
./gradlew bootRun

# Or run the JAR directly
java -jar build/libs/cinema-rest-0.0.1-SNAPSHOT.jar
```

### Default Configuration
- **Port**: 8080 (spring default)
- **Cinema Hall**: 9 rows × 9 columns
- **Password**: `super_secret` for statistics
