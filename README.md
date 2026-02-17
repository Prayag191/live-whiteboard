# Live Whiteboard Backend

This is the backend for a **Live Whiteboard App** using **Java Spring Boot** and **PostgreSQL**.  
It supports multiple participants connecting simultaneously and storing sessions in a database.

## **Project Structure**

- `controller/` - Handles REST API requests for boards, shapes, and sessions.
- `service/` - Contains business logic, like updating drawings in real-time.
- `repository/` - Interfaces for DB operations using Spring Data JPA.
- `model/` - Database entity classes (Board, Shape, Session, User, etc.).
- `dto/` - Data Transfer Objects for API requests/responses.
- `resources/application.properties` - Contains DB connection and server configurations.
- `db/migration/` - Optional SQL scripts or Flyway migrations for table setup.

## **Database Plan**

We are using **PostgreSQL** to store live whiteboard data.

### **Entities and Tables**

1. **User**
   - `id` (PK)
   - `username`
   - `email`
   - `created_at`

2. **Board**
   - `id` (PK)
   - `name`
   - `owner_id` (FK → User)
   - `created_at`

3. **Shape**
   - `id` (PK)
   - `board_id` (FK → Board)
   - `type` (line, rectangle, circle, text, etc.)
   - `coordinates` (JSON)
   - `color`
   - `stroke_width`
   - `created_at`

4. **Session**
   - `id` (PK)
   - `board_id` (FK → Board)
   - `active_users` (JSON array of user IDs)
   - `started_at`
   - `ended_at`

### **Database Relationships**

- **User → Board**: One-to-Many (a user can create multiple boards)
- **Board → Shape**: One-to-Many (a board contains multiple shapes)
- **Board → Session**: One-to-One or One-to-Many depending on history tracking
- **Session → User**: Many-to-Many (active users in session, stored as JSON or separate join table)

### **Real-time Collaboration**

- Each shape drawn is sent via REST/WebSocket to the server.
- Server saves it to the database and broadcasts to all participants in the session.

## **How to Run**

1. Clone the repo:
   ```bash
   git clone https://github.com/yourusername/live-whiteboard-backend.git
