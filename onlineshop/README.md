# FS4

OnlineShop project

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