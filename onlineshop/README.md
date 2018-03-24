# FS4

OnlineShop project


#Lesson 4 (24.03)
(Servlets part.2)


1. Code review та code conventions
- почитати про іменування методів класів в java Naming Conventions
http://www.oracle.com/technetwork/java/codeconventions-150003.pdf
також це описано в книжці по clean code (robert martin)
- відповідальність одного блок коду за одну дію або S принцип з SOLID
Single responsibility principle[4]
a class should have only a single responsibility (i.e. changes to only one part of the software's specification should be able to affect the specification of the class).
https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)
- поговорили про  3 layer web architecture strategy (controller, service, dao)

2. Freemarker https://freemarker.apache.org/
https://www.javaworld.com/article/2074899/java-web-development/freemarker-an-open-alternative-to-jsp.html
Напишіть hello world на freemarker з додаванням java обєкту  http://viralpatel.net/blogs/freemarker-servlet-tutorial-example/
one more example https://javabeat.net/freemarker-template-servlet-integration-example/

3. Servlets
- раджу почтита про request dispatcher https://www.javatpoint.com/requestdispatcher-in-servlet
- знати чим відрізняються atributes та  parameters в HttpServletRequest https://stackoverflow.com/questions/5243754/difference-between-getattribute-and-getparameter
- ми розібрали як повертати статичний файл з сервлету. Перегляньте ще раз як це робити 
- ще раз переглянте,  що таке post request та його особливості https://en.wikipedia.org/wiki/POST_(HTTP)

H/W:
1. встановити mysql workbench
2. (servlets tasks) 
2.1 Доробити головну сторінку:
- Розподіл товарів по категоріям. Я хочу щоб в нас зявився блок категорій і при натисканні на категрію я бачив тільки товари з даної категорії. Якщо я ще не вибрав категорії - я бачу всі товари.  
- (optional) оформити список товарі та категорій з використанням класів bootstrap https://getbootstrap.com/ https://getbootstrap.com/docs/4.0/examples/album/
- Додати можливість додавати коментарі та оцінку товару на сторінці з описом товару
- Створити нову стоінку з додаванням та прибиранням нового товара (Admin level)
- На сторінці /cart додати можливість прибирати товар з корзини та очистити корзину
- (optional) перевести захардкожені сторінки в html template файли з використанням template framework (freemarker) freemarker

3. почитати про template framework freemarker 
https://freemarker.apache.org/

#Lesson 3 (21.03)
1. Servlet_Api
Рекомендовано переглянути та почитати спеку по servlet api 3.1
https://javaee.github.io/servlet-spec/downloads/servlet-3.1/Final/servlet-3_1-final.pdf
Також наступні туторіали
https://gitlab.com/dan-it/fs-book/blob/master/projects/store/servlets.md#servlets
https://www.javatpoint.com/servlet-tutorial
https://www.journaldev.com/1877/servlet-tutorial-java
https://www.ntu.edu.sg/home/ehchua/programming/java/JavaServlets.html

2. Servlet containers and type of servlet containers

Хочу щоб ви знали як запускати на .war (web application) на 2 типах сервлет контейнерів
tomcat та jetty

https://dzone.com/articles/what-servlet-container
tomcat: http://www.vogella.com/tutorials/ApacheTomcat/article.html
jetty: http://www.vogella.com/tutorials/Jetty/article.html


3. Ми розібрали що таке MVC патерн
4. Розібрали, що є HTTP та види HTTP requests
5. Зупинились більш детально на http post 
Раджу ще раз почитати які в нього особливості з get запитом 
https://en.wikipedia.org/wiki/POST_(HTTP)

6. Почали працювати над onlineshop
Зараз в нас є одна сторінка з товарами та можливістю додавати наші товари в кошик через http form


H/W:

(!обовязково) 
1. пройти туторіал по servlet api та tomcat/jetty та позапускати приклади:
https://gitlab.com/dan-it/fs-book/blob/master/projects/store/servlets.md#todo-app
2. написати сторінку з деталями нашого товару. Я хочу щоб по кліку на назву товару відкривалась окрема сторінка з описом товара (title, description, name, image)
3. написати сторінку оформлення нашого замовлення. Нехай на main page буде кнопка після натискання на яку ми переходимо на сторінку замовлення де ми побачимо список того що ми замовили та кнопка купити наші товари

(!рекомендовано)
- почитати про scopes in maven (test, provided, system)
- почитати про mvc patterns
- почитати про http request and differences between them