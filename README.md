# Hotel Reservation Management System

A Java console application for managing hotel reservations, including hotel management, room booking, cancellation, and reservation history tracking.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Learning Objectives](#learning-objectives)
- [Features](#features)
- [User Roles](#user-roles)
- [Business Rules](#business-rules)
- [Domain Model](#domain-model)
- [Architecture](#architecture)
- [User Journey](#user-journey)
- [Expected Results](#expected-results)
- [Getting Started](#getting-started)

## 🎯 Project Overview

### Target Audience
Java learners focusing on Object-Oriented Programming (OOP), best practices including encapsulation, collections, and data validation.

### Vision
Develop a clean, testable, and understandable foundation for a hotel reservation system that demonstrates solid software engineering principles.

## 🎓 Learning Objectives

- **Object-Oriented Programming**: Implement entities (Hotel, Reservation, Client), services, repositories with clear separation of responsibilities
- **Data Manipulation**: Handle numerical and textual data with proper validation (room count, reservation nights, email format)
- **Authentication**: Implement basic email + password authentication for secure reservations and sensitive operations
- **Business Logic**: Apply domain rules (room availability, cancellation policies, client-specific reservations)
- **Code Quality**: Produce structured, readable, and testable code

## ✨ Features

### 🔐 Authentication & Profile Management
- **Registration**: Create account with first name, last name, unique email, and password (minimum 6 characters)
- **Login**: Authenticate with email and password
- **Session Management**: Access personal reservations and hotels while logged in; logout functionality
- **Profile Updates**: Modify email or password with format validation

### 🏨 Hotel Management
- **Hotel Creation**: Generate unique identifier, set name, address, available room count, and rating
- **Hotel Listing**: View all hotels or filter by availability
- **Hotel Updates**: Modify name, address, and room count
- **Hotel Deletion**: Remove hotels only if no active reservations exist

### 📅 Reservation System
- **Room Booking**: Reserve rooms with automatic available room decrement
- **Reservation Cancellation**: Cancel bookings with automatic room count increment
- **Reservation History**: Chronologically sorted history with detailed information (date, client, nights, hotel)

### 💻 Console Interface
- Clear menu navigation
- Explicit error messages
- Guided input process
- Input validation (room count > 0, non-empty email, password ≥ 6 characters)

## 👥 User Roles

| Role | Permissions |
|------|-------------|
| **Authenticated User** | Create and cancel reservations, view reservation history, update profile |
| **Administrator** *(optional)* | Create, modify, and delete hotels |

## 📋 Business Rules

### Core Requirements
- **Availability Check**: Reservations rejected if no rooms available
- **Cancellation Policy**: Only existing reservations can be cancelled
- **Ownership**: Users can only cancel their own reservations
- **Audit Trail**: All reservations and cancellations recorded in history
- **Email Uniqueness**: Registration fails if email already exists

### Data Constraints
- `availableRooms >= 0` for reservation eligibility
- `nights > 0` for all reservations

## 🏗️ Domain Model

### Client
```java
- id: UUID
- fullName: String
- email: String
- password: String
```

### Hotel
```java
- hotelId: String
- name: String
- address: String
- availableRooms: int
- rating: double
```

### Reservation
```java
- id: UUID
- timestamp: Instant
- hotelId: String
- clientId: UUID
- nights: int
```

## 🏛️ Architecture

### Layers

#### **Presentation Layer**
- **Main (Console UI)**: Menu management, user input, display output, application flow control

#### **Service Layer**
- **AuthService**: User registration, authentication, profile management, password operations
- **HotelService**: Hotel CRUD operations, availability checking, listing functionality
- **ReservationService**: Booking management, cancellation handling, history consultation

#### **Data Layer**
- **Repository Interfaces**: `ClientRepository`, `HotelRepository`, `ReservationRepository`
- **In-Memory Implementations**: `InMemoryClientRepository`, `InMemoryHotelRepository`, `InMemoryReservationRepository`

#### **Utility Layer**
- **Console Utils**: Input handling, data validation utilities

## 🚀 User Journey

### Unauthenticated Menu
```
┌─ Welcome to Hotel Reservation System ─┐
│ 1. Register                            │
│ 2. Login                               │
│ 3. Exit                                │
└────────────────────────────────────────┘
```

### Authenticated Menu
```
┌─ Logged in as: user@example.com ─┐
│ 1. Create Hotel (Admin)          │
│ 2. List Hotels                   │
│ 3. Reserve Room                  │
│ 4. Cancel Reservation            │
│ 5. Reservation History           │
│ 6. Update Profile                │
│ 7. Change Password               │
│ 8. Logout                        │
│ 9. Exit                          │
└──────────────────────────────────┘
```

## ✅ Expected Results

### Functional Requirements
- ✅ Working registration and login system with email uniqueness validation
- ✅ Complete hotel CRUD operations following business rules
- ✅ Reservation and cancellation system with automatic room count updates and history recording
- ✅ Chronologically sorted reservation history with complete details
- ✅ Clear error messaging for various scenarios:
  - No available rooms
  - Non-existent reservations
  - Unauthorized cancellation attempts
  - Invalid input data

### Quality Standards
- Clean, maintainable code structure
- Proper error handling and user feedback
- Comprehensive input validation
- Separation of concerns across architectural layers

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Your favorite IDE or text editor

### Installation
1. Clone the repository
```bash
git clone [your-repo-url]
cd hotel-reservation-system
```

2. Compile the project
```bash
javac -d bin src/**/*.java
```

3. Run the application
```bash
java -cp bin Main
```

### Usage
1. Start the application
2. Register a new account or login with existing credentials
3. Explore the menu options to manage hotels and reservations
4. Follow the guided prompts for each operation

---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
