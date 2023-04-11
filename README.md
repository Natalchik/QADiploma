## Описание приложения

Приложение представляет из себя веб-сервис.

![nbn](https://user-images.githubusercontent.com/97524452/183943467-3c377e3f-f191-43a5-a6e4-81ff6c7de8b8.JPG)


Приложение предлагает купить тур по определённой цене с помощью двух способов:
1. Обычная оплата по дебетовой карте
1. Уникальная технология: выдача кредита по данным банковской карты

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:
* сервису платежей (далее - Payment Gate)
* кредитному сервису (далее - Credit Gate)

Приложение должно в собственной СУБД сохранять информацию о том, каким способом был совершён платёж и успешно ли он был совершён (при этом данные карт сохранять не допускается).


## Как запустить автотесты:
1. Запустить Docker Desktop
2. Выполнить git clone https://github.com/Natalchik/QADiploma.git
3. Открыть проект в редакторе кода (например, IntelliJ IDEA) 
4. Для запуска приложения с БД MySQL выполняем следующую команду:
   `java -jar artifacts/aqa-shop.jar "-
   Dspring.datasource.url=jdbc:mysql://localhost:3306/app" "-
   Dspring.datasource.username=app" "-Dspring.datasource.password=pass"`
5. Для запуска приложения с БД PostgreSQL выполняем следующую команду:
   `java -jar artifacts/aqa-shop.jar "-
   Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" "-
   Dspring.datasource.username=app" "-Dspring.datasource.password=pass"`
6. Открыть терминал и выполнить команду запуска контейнеров `docker-compose up`
7. Запустить тесты командой `gradlew test` в новой вкладке терминала
8. После прохождения всех тестов в новой вкладке терминала выполнить команду `gradlew allureServe` для просмотра отчета по результатам выполнения тестов
