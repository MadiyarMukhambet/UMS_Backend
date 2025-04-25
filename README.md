# University Management System (UMS)

## 📚 Описание проекта

University Management System — это RESTful веб-приложение, разработанное на Spring Boot для управления системой университета. Проект поддерживает ролевую авторизацию и полные CRUD-операции для администрирования студентов, преподавателей и курсов.

---

## 🚀 Как запустить проект

1. Установите **PostgreSQL** и создайте базу данных `unims_db`.
2. Настройте параметры подключения в `application.properties` и `build.gradle.kts`.
3. Выполните миграции Flyway.
4. Соберите и запустите проект:
./gradlew clean build
./gradlew bootRun
 Директория:
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


   💻 Используемые технологии
Java 21
Spring Boot 3
Spring Security
Spring Data JPA
PostgreSQL
Flyway
JWT (JSON Web Token)
MapStruct
Lombok


Автор: [Mukhambet Madiyar]
Email: [madiyarmuhambetov@gmail.com]
GitHub: [https://github.com/MadiyarMukhambet/UMS_Backend]
