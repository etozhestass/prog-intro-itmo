# prog-intro-itmo
1st semester java-programming course at CT ITMO

[Условия домашних заданий](https://www.kgeorgiy.info/courses/prog-intro/homeworks.html)

## Домашнее задание 13. Обработка ошибок

Модификации
 * *Base*
    * Класс `ExpressionParser` должен реализовывать интерфейс
        [TripleParser](java/expression/exceptions/TripleParser.java)
    * Классы `CheckedAdd`, `CheckedSubtract`, `CheckedMultiply`,
        `CheckedDivide` и `CheckedNegate` должны реализовывать интерфейс
        [TripleExpression](java/expression/TripleExpression.java)
    * Нельзя использовать типы `long` и `double`
    * Нельзя использовать методы классов `Math` и `StrictMath`
    * [Исходный код тестов](java/expression/exceptions/ExceptionsTest.java)
        * Первый аргумент: `easy` или `hard`
        * Последующие аргументы: модификации
 * *SetClear*
    * Дополнительно реализуйте бинарные операции (минимальный приоритет):
        * `set` – установка бита, `2 set 3` равно 10;
        * `clear` – сброс бита, `10 clear 3` равно 2.
 * *Count*
    * Дополнительно реализуйте унарную операцию
      `count` – число установленных битов, `count -5` равно 31.
 * *PowLog10*
    * Дополнительно реализуйте унарные операции:
        * `log10` – логарифм по уснованию 10, `log10 1000` равно 3;
        * `pow10` – 10 в степени, `pow10 4` равно 10000.


## Домашнее задание 12. Разбор выражений

Модификации
 * *Base*
    * Класс `ExpressionParser` должен реализовывать интерфейс
        [TripleParser](java/expression/parser/TripleParser.java)
    * Результат разбора должен реализовывать интерфейс
        [TripleExpression](java/expression/TripleExpression.java)
    * [Исходный код тестов](java/expression/parser/ParserTest.java)
        * Первый аргумент: `easy` или `hard`
        * Последующие аргументы: модификации
 * *SetClear*
    * Дополнительно реализуйте бинарные операции (минимальный приоритет):
        * `set` – установка бита, `2 set 3` равно 10;
        * `clear` – сброс бита, `10 clear 3` равно 2.
 * *Count*
    * Дополнительно реализуйте унарную операцию
      `count` – число установленных битов, `count -5` равно 31.

## Домашнее задание 11. Выражения

Модификации
 * *Base*
    * Реализуйте интерфейс [Expression](java/expression/Expression.java)
    * [Исходный код тестов](java/expression/ExpressionTest.java)
    * [Исходный код тестов для групп 32-35](java/expression/ExpressionEasyTest.java)
        * Первый аргумент: `easy` или `hard`.
        * Последующие аргументы: модификации.
 * *Triple*
    * Дополнительно реализуйте поддержку выражений с тремя переменными: `x`, `y` и `z`.
    * Интерфейс [TripleExpression](java/expression/TripleExpression.java).


## Домашнее задание 10. Игра m,n,k

Тесты не предусмотрены. Решение должно находиться в пакете `game`.

Модификации
 * *Матчи*
    * Добавьте поддержку матчей: последовательность игр до указанного числа побед.
    * Стороны в матче должны меняться каждую игру.
 * *Дополнительные ходы*
    * Если в результате хода игрока на доске появляется новая последовательность
      из 4+ одинаковых символов, то он делает дополнительный ход.
    * Игрок может сделать несколько дополнительных ходов подряд.




## Домашнее задание 9. Markdown to HTML

Модификации
 * *Базовая*
    * [Исходный код тестов](java/md2html/Md2HtmlTester.java)
    * [Откомпилированные тесты](artifacts/Md2HtmlTest.jar)
        * Аргументы командной строки: модификации
 * *Underline*
    * Добавьте поддержку `++подчеркивания++`: `<u>подчеркивания</u>`


## Домашнее задание 7. Разметка

Модификации
 * *Base*
    * Исходный код тестов:
        * [MarkupTester.java](java/markup/MarkupTester.java)
        * [MarkupTest.java](java/markup/MarkupTest.java)
        * Аргументы командной строки: модификации
    * Откомпилированных тестов не существуют, 
      так как они зависят от вашего кода
 * *Tex*
    * Дополнительно реализуйте метод `toTex`, генерирующий TeX-разметку:
      * выделеный текст заключается в `\emph{` и `}`;
      * сильно выделеный текст заключается в `\textbf{` и `}`;
      * зачеркнутый текст заключается в `\textst{` и `}`.

## Домашнее задание 6. Подсчет слов++

Модификации
 * *Base*
    * Класс должен иметь имя `Wspp`
    * Исходный код тестов:
        [WsppTest.java](java/wspp/WsppTest.java),
        [WsppTester.java](java/wspp/WsppTester.java)
    * Откомпилированные тесты: [WsppTest.jar](artifacts/WsppTest.jar)
        * Аргументы командной строки: модификации
 * *CountPosition*
    * В выходном файле слова должны быть упорядочены по возрастанию числа
      вхождений, а при равном числе вхождений – по порядку первого вхождения
      во входном файле.
    * Вместо номеров вхождений во всем файле надо указывать
      `<номер строки>:<номер в строке>`
    * Класс должен иметь имя `WsppCountPosition`


## Домашнее задание 5. Свой сканнер

Модификации
 * *Base*
    * Исходный код тестов: [FastReverseTest.java](java/reverse/FastReverseTest.java)
    * Откомпилированные тесты: [FastReverseTest.jar](artifacts/FastReverseTest.jar)
        * Аргументы командной строки: модификации
 * *Abc*
    * Во вводе и выводе используются числа, записаные буквами:
      нулю соответствует буква `a`, единице – `b` и так далее
    * Класс должен иметь имя `ReverseAbc`


## Домашнее задание 4. Подсчет слов

Модификации
 * *Base*
    * Класс должен иметь имя `hw4.WordStatInput`
    * Исходный код тестов:
        [WordStatTest.java](java/wordStat/WordStatTest.java),
        [WordStatTester.java](java/wordStat/WordStatTester.java),
        [WordStatChecker.java](java/wordStat/WordStatChecker.java)
    * Откомпилированные тесты: [WordStatTest.jar](artifacts/WordStatTest.jar)
        * Аргументы командной строки: модификации
 * *WordsSuffix*
    * Выходной файл должен содержать все различные суффиксы длины 3
      слов встречающихся во входном файле,
      в лексикографическом порядке.
      Слова длины меньшей 3 используются как есть.
    * Класс должен иметь имя `hw4.WordStatWordsSuffix`


## Домашнее задание 3. Реверс

Модификации
 * *Base*
    * Исходный код тестов:
        [ReverseTest.java](java/reverse/ReverseTest.java),
        [ReverseTester.java](java/reverse/ReverseTester.java)
    * Откомпилированные тесты: [ReverseTest.jar](artifacts/ReverseTest.jar)
        * Аргументы командной строки: модификация
 * *Transpose*
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      выведите ее в транспонированном виде
    * Класс должен иметь имя `ReverseTranspose`


## Домашнее задание 2. Сумма чисел

Модификация
 * *Double*
    * Входные данные являются 64-битными числами с формате с плавающей точкой
    * Класс должен иметь имя `hw2.SumDouble`

Для того, чтобы протестировать исходную программу:

 1. Скачайте откомпилированные тесты ([SumTest.jar](artifacts/SumTest.jar))
 1. Откомпилируйте `hw2.Sum.java`
 1. Проверьте, что создался `hw2.Sum.class`
 1. В каталоге, в котором находится `hw2.Sum.class`, выполните команду
    ```
       java -ea -jar <путь к SumTest.jar> Base
    ```
    * Например, если `SumTest.jar` находится в текущем каталоге, выполните команду
    ```
        java -ea -jar SumTest.jar Base
    ```
 1. Для ускорени отладки рекомендуется сделать скрипт, выполняющий шаги 2−4.

Исходный код тестов:

* [SumTest.java](java/sum/SumTest.java)
* [SumTester.java](java/sum/SumTester.java)
* [Базовые классы](java/base/)
 
