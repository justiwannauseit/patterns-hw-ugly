/*
 * Золотое правило: если что-то и так работает, то лучше к этому не лезть.
 * Но у нас тут как раз давольно рискованное задание:
 * "произвести рефакторинг, да ещё и ничего не сломать"
 *
 * В некоторых случаях я просто менял код, потому что моё внутреннее чутье подсказавало мне:
 * "тут что-то не так...меняй!". А вот сказать какой шаблон я приминил...Уф вот это оказалось непросто...
 *
 * Если какой-то из шаблонов я не применял, значит скорее всего я либо боялся сломать,
 * либо я просто не нашел паттерну достойного применения в коде.
 *
 * Единственный момень вот который меня немного смущает это про длинну волос...
 * Вот я чувствую, что там можно было сделать enum например или еще чего...
 * но с другой стороны, как сейчас так вроде тоже правильно...менять не стал.
 *
 * Builder:     применён в классе InputProcessor (сразу в папке java лежит) для генерации Person (java/person/...)
 *              Применил...подумал будет уместно собирать человека в билдере.
 * DTO:         применён в классе InputProcessor...тут я конечно не уверен он это или не он. Ну вроде он.
 *
 * Помимо двух этих шаблонов, я еще немного отредактировал код, но точно прям сказать по какому принципу...
 * (опять же повторусь) я точно прям сказать не могу...
 *
 * В свою защиту конечно хочется добавить (а как же себя то не защитить?):
 * на мой взгляд, когда часто пишешь (или читаешь чей-то) код, то автоматически, ты перенимаешь какие-то фишечки.
 * И потом уже тебе будет легче узнать, что вот оказывается такая-то фишечка называется, например: Синглтон.
 * Наверное в силу того, что у меня не так много опыта (совсем мало если быть точнее), то конечно тяжеловато...
 * Хотя казалось бы: вот шаблон, а вот код. Дерзай!
 * Но что-то все таки пошло не так :)
 *
 * P.S. Поднял глаза на экран и увидел сколько Вам придется читать...
 * а я наверняка не один такой, любитель по-дискутировать.
 */