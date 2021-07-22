#  Упаковка простого Spring Boot приложения в Docker  контейнер

* Упаковать приложение в jar-файл и запустить его
```
mvnw package && java -jar target/simple-docker-spring-0.0.1-SNAPSHOT.jar

```
Чтобы остановить приложение, 
в терминале, откуда было оно запущено, 
нажать комбинацию клавиш Ctrl+C.

* Собираем образ и запускаем контейнер
```
docker build -t simple-docker-spring:0.0.1 .
```
* Запустить контейнер
```
docker run -d -p 8080:8080 -t --name sds simple-docker-spring:0.0.1
```
* Проверить работу приложения
```
curl http://localhost:8080
```
* Остановить работу контейнера
```
docker stop sds
```