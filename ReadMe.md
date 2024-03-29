# Общие положения
1 Стартер для spring
2 Отдельную библиотеку для spring, которой будет ползоваться стартер
3 Основная библиотека. Запускаться java -jar или её можно влючить в зависимости и пользоваться её API
4 Начать с обеспечения рабаты с postgres (создание схемы и таблицы)
5 Сообщения об ошибках должны содержать подсказки по их устранению
6 Должна быть документация и включить её в либу jar

# Терминология
dbspec - котлин скрипт со схемами для базы

# Задачи

* Обеспечить возможность задавать источник данных либо это наш класс с заполненными полями и мы сами создаём датасорс либо берём из спринга либо возможность задать jndi для датасорса
* Обеспечить возможность создания схем таблиц столбцов
* Информация о версии хранится в той же базе (новая схема) в специальных таблицах
* Обеспечить автоматическое ведение номеров версий
* Возможность указывать путь до dbspec
* Возможность задавать путь к скриптам миграции с одной версии dbspec на другую
* Обеспечить возможность автоматического составления скрипта миграции из одной версии в другую версию dbspecи
* Предыдущая версии спеки не обязательна должна быть доступна для новой версии для построения миграции
* Обеспечить возможность экспорта из базы в dbspec в том числе и с данными
* Обеспечить возможность отката с новой версии на старую
* Обеспечить возможность создания таблиц из хибернейт сущностей 
* Обеспечить возможность создания таблиц из классов помеченных аннотациями jpa из скомпилированного класса
* Обеспечить возможность наполнения таблиц данными из: файла csv, из другой базы, написать свой собственный доставатель данных для заполнения таблицы
* Сделать автоматическую проверку необходимости миграции данных при переходе со старой версии на новую
* Возможность обеспечить указание драйвера для работы с базой
* Обеспечить транзакционность создания таблиц и записи в них данных 
* Обеспечить возможность задать политику откатываемости до предыдущей версии по атрибутному составу копирование в другую таблицу столбец
* Рассмотреть возможность удаления данных для отката предыдущей версии
* Возможность возможность задать в dbspec индексы, констреенты, партишены, тэйблспейсы, сиквенсы
* Возможность задать прогон sql скрипта до и после наката dbspec
* Обеспечить возможность создавать в dbspec триггеры и хранимки
* Как обеспечить совместимость версий при использовании sql скриптов? 
* Добавить возможность защищённого соединения с базой
* Обеспечить возможность задать тип для столбцов и атрибуты к нему unique, nonnull
* Обеспечить возможность откатывать insert, update, delete, create