# Spring Boot User API

This is intentionally small. It connects the Java concepts from the earlier folders to Spring Boot.

## Flow

```text
HTTP Request
   ↓
UserController
   ↓
UserRequest DTO
   ↓
UserService
   ↓
User entity
   ↓
UserRepository
   ↓
H2 database
```

## Important Java lines to study

```java
User user = new User();
```
Creates a `User` object.

```java
user.setName(name);
```
Calls a method on that object and stores data in it.

```java
return userRepository.save(user);
```
Passes the `User` object to the repository.

## Run

```bash
mvn spring-boot:run
```

## Create a user

```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John","email":"john@test.com"}'
```

## Get all users

```bash
curl http://localhost:8080/users
```
