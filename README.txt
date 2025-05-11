# Family Tracker - JavaFX Application

## Overview
Family Tracker is a desktop application built with JavaFX that allows users to manage information about family members. The app enables adding, viewing, and organizing personal data such as names, dates of birth, medical info, notes, and photos. Tasks and a calendar interface are also provided for basic scheduling features.

## Features
- Add new family members via a form with validation
- Upload and preview profile pictures (stored in base64 in the database)
- View dynamically loaded family members from a MySQL database
- Add tasks with due dates (stored temporarily in-memory)
- Interactive calendar (JavaFX DatePicker)
- Responsive layout with shared navigation bar

## Requirements
- Java 23+
- JavaFX SDK 23 (added via Maven)
- MySQL Server (can use XAMPP)
- NetBeans IDE or Maven-compatible IDE

## Setup Instructions

### 1. MySQL Database Setup
1. Start MySQL server via XAMPP or your preferred method.
2. Create the database:
    ```sql
    CREATE DATABASE sdev200fp;
    USE sdev200fp;
    ```
3. Create the `members` table:
    ```sql
    CREATE TABLE members (
        id INT AUTO_INCREMENT PRIMARY KEY,
        firstName VARCHAR(50) NOT NULL,
        lastName VARCHAR(50) NOT NULL,
        middleName VARCHAR(50),
        dob DATE NOT NULL,
        email VARCHAR(100),
        medicalinfo TEXT,
        notes TEXT,
        photo LONGTEXT
    );
    ```

### 2. NetBeans / Maven Setup
- Open the project in NetBeans.
- Ensure Maven downloads dependencies (right-click → Reload Project if needed).
- JavaFX SDK is managed via the `pom.xml` file.

### 3. Running the App
Use the following Maven command:
```sh
mvn javafx:run
```
Or run from within NetBeans via the "Run Project" option.

## File Structure
- `MainApp.java`: Application entry point
- `ui/`: Contains all JavaFX page components (Home, Family, Tasks, Calendar)
- `model/`: Contains class definitions like Person, FamilyMember, Task, Event
- `util/`: Contains validation utilities and DBManager for JDBC access

