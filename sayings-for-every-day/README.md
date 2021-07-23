# Фраза дня
Простое Spring Boot приложение, работающее с базой данных PostgreSQL:
хранит различные высказывания и может выдавать случайно выбранное выказывание. 
Запуск приложения и базы данных выполняется в контейнерах Docker. 

### Запуск PostreSQL в контейнере

```
docker run --name pg-sayingsdb --volume db-data:/var/lib/postgresql/data -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=sayingsdb -p 5434:5432 postgres:12-alpine
```
### Сборка jar-файла приложения
```
mvnw clean package
```
### Сборка контейнеров и запуск

Файл sayings-for-every-day-0.0.1-SNAPSHOT.jar 
необходимо предварительно скопировать в папку проекта /docker/services/app 
и выполнить команду
```
docker-compose up
```

### Проверка API сервиса

Если операционная система Windows, команды лучше выполнять в Git Bash. 
Через командное Windows не удается выполнить POST-запрос: не воспринимается тело запроса.

* Получить все высказывания
```
curl http://localhost:8080
```

* Получить одно случайно выбранное высказывание
```
curl http://localhost:8080/random
```

* Сохранить в базе данных новое высказывание
```
curl -X POST -H 'Content-Type: application/json' -d '{"text": "Всё приходит в своё время для тех, кто умеет ждать."}' http://localhost:8080
```

* Удалить высказывание по его идентификатору
```
curl -X DELETE http://localhost:8091/1
```
