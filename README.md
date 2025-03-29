1) Настройки можно менять в src/main/resources/application.yaml, но все должно работать из коробки.


Запуск проекта:
(подрузумивается заранее установленный CLI tool docker-compose)
1) Зайти в папку с проектом и выполнить команду docker-compose up -d для запуска Postgresql 14
2) Выполнить в этой же папке maven package
3) Запустить сервис при помощи java -jar test.task.dynamica-0.0.1-SNAPSHOT.jar.jar
