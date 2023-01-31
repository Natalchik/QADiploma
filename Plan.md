# Тест-план по автоматизации тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.
## 1. Перечень автоматизируемых сценариев:
### 1.1. Переход к форме оплаты тура в веб-приложении:
- Открыть сайт;
- Выбрать тур;
- Нажать кнопку "Купить"/"Купить в кредит";
### Тестовые данные.
Сервис обрабатывает только специальные номера карт, которые предоставлены для тестирования:
APPROVED карта - 4444 4444 4444 4441;
DECLINED карта - 4444 4444 4444 4442;
### 1.2. Тестирование формы по оплате тура в веб-приложении.
Позитивные сценарии:
1. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка отправляется, появляется сообщение "Успешно. Операция одобрена Банком".
2. После нажатия на кнопку "Купить" заполнить поле "Номер карты" невалидным значением для проведения тестирования "4444 4444 4444 4442" (карта со статусом "DECLINED"), в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение "Ошибка. Операция отклонена".
3. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка отправляется, появляется сообщение "Успешно. Операция одобрена Банком".
4. После нажатия на кнопку "Купить в кредит " заполнить поле "Номер карты" невалидным значением для проведения тестирования "4444 4444 4444 4442" (карта со статусом "DECLINED"), в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение "Ошибка. Операция отклонена".

Негативные сценарии:
1. После нажатия на кнопку "Купить" заполнить поле "Номер карты" рандомным 16-тизначным номером "1234 5678 1234 5678", в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка  не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
2. После нажатия на кнопку "Купить" поле "Номер карты" оставить пустым, в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка  не отправляется, появляется сообщение об ошибке "Ошибка. Обязательное поле".
3. После нажатия на кнопку "Купить" заполнить поле "Номер карты" нулями "0000 0000 0000 0000", в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка  не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
4. После нажатия на кнопку "Купить" заполнить поле "Номер карты" спецсимволами "$$$$ $$$$ $$$$$ $$$$$", в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка  не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
5. После нажатия на кнопку "Купить" заполнить поле "Номер карты" буквами (кириллица) "фффф фффф фффф фффф", в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка  не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
6. После нажатия на кнопку "Купить" заполнить поле "Номер карты" буквами (латиница) "wwww wwww wwww wwww", в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка  не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
7. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" рандомным 16-тизначным номером "1234 5678 1234 5678", в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка  не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
8. После нажатия на кнопку "Купить в кредит" поле "Номер карты" оставить пустым, в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка  не отправляется, появляется сообщение об ошибке "Ошибка. Обязательное поле".
9. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" нулями "0000 0000 0000 0000", в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка  не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
10. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" спецсимволами "$$$$ $$$$ $$$$$ $$$$$", в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка  не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
11. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" буквами (кириллица) "фффф фффф фффф фффф", в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка  не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
12. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" буквами (латиница) "wwww wwww wwww wwww", в поле Месяц/Год ввести валидное значение 11/24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка  не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
13. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести невалидное значение >12 (13), поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
14. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), поле Месяц заполнить нулями (00), поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
15. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести невалидное буквенное значение (латиница) AM, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
16. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести невалидное буквенное значение (кириллица) ФН, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
17. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести невалидное значение одну цифру 1, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
18. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести спецсимволы !!, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
19. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), поле Месяц оставить пустым, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Обязательно для заполнения".
20. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести невалидное значение >12 (13), поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
21. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), поле Месяц заполнить нулями (00), поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
22. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести невалидное буквенное значение (латиница) AM, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
23. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести невалидное буквенное значение (кириллица) ФН, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
24. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести невалидное значение одну цифру 1, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
25. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести спецсимволы !!, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
26. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), поле Месяц оставить пустым, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Обязательно для заполнения".
27. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить невалидным значением 22(на год меньше текущего), поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
28. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить невалидным значением 24(на год больше текущего), поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
29. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить невалидным значением 30(больше пяти лет от текущего), поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
30. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить невалидным значением 2(одним числом), поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Обязательно для заполнения".
31. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить нулями 00, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
32. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить спецсимволами ??, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
33. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить буквенным значением AM(латиница/кириллица), поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
34. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить одним словом на латинице Ivan, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение."
35. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить одной буквой на латинице I, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение."
36. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить данные на кириллице Иван Петров, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение."
37. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить цифрами 1234 567890, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение."
38. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить спецсимволами $$$$ $$$$$$, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение."
39. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец оставить пустым, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Обязательно для заполнения".
40. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить невалидным значением 22(на год меньше текущего), поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
41. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить невалидным значением 24(на год больше текущего), поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
42. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить невалидным значением 30(больше пяти лет от текущего), поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Операция отклонена".
43. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить невалидным значением 2(одним числом), поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Обязательно для заполнения".
44. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить нулями 00, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
45. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить спецсимволами ??, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
46. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить буквенным значением AM(латиница/кириллица), поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
47. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить одним словом на латинице Ivan, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение."
48. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить одной буквой на латинице I, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение."
49. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить данные на кириллице Иван Петров, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение."
50. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить цифрами 1234 567890, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение."
51. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить спецсимволами $$$$ $$$$$$, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение."
52. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец оставить пустым, поле CVS/CVV заполнить любым трехзначным числом 508. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Обязательно для заполнения".
53. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить буквами смс. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
54. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить одной цифрой, 1. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
55. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить двумя цифрами 12. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
56. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить четырьмя цифрами 1234. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
57. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить спецсимволами @@@. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
58. После нажатия на кнопку "Купить" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV оставить пустым. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Обязательное поле".
59. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить буквами смс. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
60. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить одной цифрой, 1. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
61. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить двумя цифрами 12. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
62. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить четырьмя цифрами 1234. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
63. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV заполнить спецсимволами @@@. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Недопустимое значение".
64. После нажатия на кнопку "Купить в кредит" заполнить поле "Номер карты" валидным значением для проведения тестирования "4444 4444 4444 4441" (карта со статусом "APPROVED"), в поле Месяц ввести валидное значение 11, поле Год заполнить валидным значением 24, поле Владелец заполнить валидными данными на латинице Ivan Petrov, поле CVS/CVV оставить пустым. Нажать кнопку "Продолжить". Заявка не отправляется, появляется сообщение об ошибке "Ошибка. Обязательное поле".


## 2. Перечень используемых инструментов с обоснованием выбора:
- Java 11 - язык программирования (проверенная версия, на ней разрабатываются большинство проектов).
- Gradle - система автоматической сборки, инструмент управления проектами (более гибкая и современная система сборки по сравнению с другими)
- JUnit5 - фреймворк для тестирования ПО на языке Java (наиболее удобный).
- Selenide - фреймворк для автоматизированного запуска веб-приложений по поиску веб-элементов на странице (в отличие от Selenium не требует настройки окружения, установки специального драйвера)
- Allure — фреймворк, предназначенный для создания визуально наглядной картины отчета о выполнении тестов. (наиболее распространен)
- Git - система контроля версий (самая популярная).
- GitHub - веб-сервис для хостинга IT-проектов основанный на системе контроля версий Git (крупнейший).
## 3. Перечень необходимых разрешений/данных/доступов:
- Разрешение на тестирование и автоматизацию;
- Доступ к API сайта "Нетология" и базе данных;
- Доступ к техническому заданию (документации) по тестированию, при наличии.
## 4. Перечень и описание возможных рисков при автоматизации:
- Отсутствие тз;
- Сложности в настройки Docker. Необходимо проверить поддержку 2х СУБД - MySQL и PostgreSQL. А также настроить работу симулятора банковских сервисов.
- Поскольку в качестве банковского сервиса выступает заглушка, есть риск, что при подключении реальной системы появятся не выявленные дефекты.
- Необходимость поддержки кода автотестов;
- Изменения верстки повлекут за собой неработоспособность автотестов.
## 5. Интервальная оценка с учётом рисков (в часах):
Ориентировочно 120 рабочих часов.