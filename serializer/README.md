# FS4

Serializer project

#Lesson 2 (17.03)
1. Maven

це інструмент для збірки Java проекту: компіляції, створення jar, створення дистрибутива програми, генерації документації. Прості проекти можна зібрати в командному рядку. Якщо збирати великі проекти з командного рядка, то команда для збірки буде дуже довгою, тому її іноді записують в bat / sh скрипт. Але такі скрипти залежать від платформи. Для того щоб позбутися від цієї залежності і спростити написання скрипта використовують інструменти для збірки проекту.

вміє:
- збирати
- тестування
- документація
- і багато іншого

інші інструменти для зборки проекту: grade(more  in use with android), ant

основні поняття maven:
- plugins - розширення функціоналу для сборки проекту - наприклад встановити на видалений сервер, чи зібрати якийсь конретний файл
- repository локальний .m2 та видалений
- dependencies
- в результаті роботи maven створює артифакт (.jar, .war, .ear)
- coordinates (groupId, artifactId, version) основні ідентифікатори бібліотеки)
- archetype (шаблон нового проекту. багато шаблонів існує при створенні)

життєвий цикл побудови проекту в maven

почитати про maven - в принципі в них непогана документація https://maven.apache.org/what-is-maven.html тому раджу починати з неї

2. Patterns:
- factory https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
- composite https://www.tutorialspoint.com/design_pattern/composite_pattern.htm
- singleton https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm

3. Work on Serializer project

H/W: 
1. дописати JsonCircleSerializer
2. GroupJsonSerialezer
3. BinarySerializer

#Lesson 1 (16.03)
java core:
1. class, interface, abstract class
маємо чітко розуміти різницю між ними та коли, що використовувати
https://docs.oracle.com/javase/tutorial/java/concepts/
2. generic
раджу прочитати розділ з книги ‘Effective Java’ Josh Bloch 
http://www.eecs.qmul.ac.uk/~mmh/APD/bloch/generics.pdf
Дорчі це книга musthave для прочитання і в майбутньому я б навть радив її придбати
3. OOP принципи
https://www.javatpoint.com/java-oops-concepts
4. java.io
 https://docs.oracle.com/javase/tutorial/essential/io/streams.html тут потрібно прочитати про I/O Streams 
 подивіться на туторіал тут https://www.tutorialspoint.com/java/io/index.htm
5. exceptions
     hierarchy  
       key words: try,catch,throw,throws,finally
   checked/unchecked
6. patterns
decorator https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
