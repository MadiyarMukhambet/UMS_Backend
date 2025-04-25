# University Management System (UMS)

---

University Management System is a RESTful web application developed on Spring Boot for managing the university system. The project supports role-based authorization and full CRUD operations for administering students, teachers and courses.

---

## 🚀 How to start

1. Install PostgreSQL and create the unims_db database.
2. Configure connection settings in application.properties and build.gradle.kts.
3. Run Flyway migrations.
4. Build and run the project:
./gradlew clean build
./gradlew bootRun
 Directory:
 src
└── main
    ├── java/com/unims
    │   ├── config         # Конфигурации Spring
    │   ├── controller     # REST контроллеры
    │   ├── dto            # DTO классы
    │   ├── entity         # JPA-сущности
    │   ├── exception      # Обработка исключений
    │   ├── factory        # Фабрики для создания сущностей и DTO
    │   ├── map            # MapStruct мапперы
    │   ├── repository     # Интерфейсы JPA-репозиториев
    │   ├── security       # JWT и Spring Security
    │   ├── service        # Сервисный слой
    │   └── strategy       # Стратегии сортировки курсов
    └── resources
        ├── db/migration   # Flyway миграции
        ├── application.yml


Examples of API endpoints:
POST /auth/register – регистрация пользователя
POST /auth/login – авторизация, возврат JWT токена
POST /students – создать студента (ADMIN)
GET /students/{id} – получить информацию о студенте
GET /courses – список курсов (доступно всем)
GET /courses?sort=byStudents Курсы по числу студентов
POST /courses – создать курс (TEACHER, ADMIN)
GET /courses?sort=byDate Сортировать по дате
POST /enrollments – записать студента на курс (TEACHER, ADMIN)


   💻 Technologies used
Java 21
Spring Boot 3
Spring Security
Spring Data JPA
PostgreSQL
Flyway
JWT (JSON Web Token)
MapStruct
Lombok


Author: [Mukhambet Madiyar]
Email: [madiyarmuhambetov@gmail.com]
GitHub: [https://github.com/MadiyarMukhambet/UMS_Backend]
