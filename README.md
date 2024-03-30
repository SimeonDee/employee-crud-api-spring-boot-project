# employee-crud-api-spring-boot-project

A SpringBoot RESTful CRUD API for Employee Resource.
A simple Employee CRUD API Implementation with SpringBoot and MySQL Database.

---

- `Author: Adedoyin Simeon`

---

## **Tools used:**

- SpringBoot
- MySQL
- Tomcat embedded server

## **Dependencies used:**

- spring-boot-starter-web (for Spring MVC and RESTful API dev)

- spring-boot-starter-data-jpa (For DB Persistent Storage)

- spring-boot-devtools (for auto-restart on save)

- mysql-connector-j (MySQL Driver for Java connectivity)

- Lombok (for boilerplates code generation using @rate e.g. @RestController, @Data, etc)

## **My application Properties:**

```code:java
spring.datasource.url=jdbc:mysql://localhost:3306/my_db_name?useSSL=false
spring.datasource.username=my_db_username
spring.datasource.password=my_db_password

// To allow Auto-update of DB Table definition based on model (Entity class)
spring.jpa.hibernate.ddl-auto=update
```

## **Activities Carried out:**

- Set up the structure for Backend (created packages for `model`, `repository`, `service`, `service.impl`, `controller`, `exception`)

## **API structure:**

- **Endpoint:** `POST "/employees"`
- **Desc:** create a new employee
- **Payload Sample:**

```json
{
  "firstName": "value",
  "lastName": "value",
  "email": "value",
  "age": 20
}
```

---

- **Endpoint:** `GET "/employees"`
- **Desc:** fetch all employee records

---

- **Endpoint:** `GET "/employees/:id"`
- **Desc:** fetch record of employee with given "id".

---

- **Endpoint:** `PATCH "/employees/:id"`
- **Desc:** Updates record of employee with given "id" using the data provided in the payload.
- **Payload Sample:**

```json
{
  "firstName": "value",
  "lastName": "value",
  "email": "value",
  "age": 20
}
```

_Note:_ Configured to allow partial update.

---

- **Endpoint:** `DELETE "/employees/:id"`
- **Desc:** deletes employee with given "id"
