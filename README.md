1.      Create a project using a Spring Initializr  
   [https://start.spring.io/](https://start.spring.io/)  
2.      1. With the following settings
           1. Project => Maven
           2. Language => Java
           3. Spring Boot => 3.0.4 (Whatever similar to this)
           4. Project Metadata according to your need
           5. Packaging => Jar
           6. Java => 17 or higher

       2.  Add following dependencies
           1. Spring Web  **Web**  
              Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
           2. Spring Data JPA **SQL**  
              Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
           4. H2 Database **SQL**  
              Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. Supports embedded and server modes as well as a browser based console application.

3.      Open Project in Intellij
4.      Building a Spring Boot Web App
    1.       Add Entities
        1. Author
           1. add **@Entity** annotation
           2. add **@Id** annotation to primary key for particular entity
           3. Add desire data variables 
           4. Add Constructor
           5. Create there Getter and Setter
           6. Add equal and hashCode methods
           7. add toString method
        2. Book
           1. add **@Entity** annotation
           2. add **@Id** annotation to primary key for particular entity
           3. Add desire data variables 
           4. Add Constructor
           5. Create there Getter and Setter
           6. Add equal and hashCode methods
           7. add toString method
        3. Publisher
           1. add **@Entity** annotation
           2. add **@Id** annotation to primary key for particular entity
           3. Add desire data variables 
           4. Add Constructor
           5. Create there Getter and Setter
           6. Add equal and hashCode methods
           7. add toString method
    2.       Add Repository Interfaces
        1. AuthorRepository Extended with **CRUDRepository<EntityClass,Data Type of Primary Key of Entity Class>**
        2. BookRepository Extended with **CRUDRepository<EntityClass,Data Type of Primary Key of Entity Class>**
        3. PublisherRepository Extended **with CRUDRepository<EntityClass,Data Type of Primary Key of Entity Class>**
    3.       Create A Bootstrap Class to save data in **H2 Database**
        1. Add **@Component** annotation
        2. add implements **CommandLineRunner**
        3.   @Override
             public void run(String... args) throws Exception {  
                //this method is used to manipulate data in **H2 Database**  
             }
        4. Add The data of your choice in above method
        5. Create Services Interface
            1. BookService
                1. With the following method
                    1. Iterable<Book> findAllBooks();
                    2. And create BookServiceImpl Class
                        1. **@Service** annotation
                        2. Create a variable of Book Repository
                            1. private final BookRepository bookRepository;
                        3. Public **Constructor** of **BookServiceImpl**
                        4. Implement findAllAuthors() method by @override call
                            1. With return bookRepository.findAll();
            2. AuthorService
                1. With the following method
                    1. Iterable<Author> findAllAuthors();
                    2. And create AuthorServiceImpl Class
                        1. **@Service** annotation
                        2. Create a variable of Author Repository
                            1. private final AuthorRepository authorRepository;
                        3. Public **Constructor** of **AuthorServiceImpl**
                        4. Implement findAllAuthors() method by @override call
                            1. With return authorRepository.findAll();

       6. Configure Spring Controller
             1. BookController
                1. add **@Controller** annotation
                2. Create BookService variable  
                   private final BookService bookService;
                3. Create BookController Constructor
                4. Create a method to get all the book from database
                    1. With the following things
                       1. add @RequestMapping("/books") annotation  
                         where @RequestMapping is used for request mapping in spring and "/books" is path
                       2. with Model as Parameter whereas Model is inherited from org.springframework.ui
                       3. model.addAttribute("books",bookService.findAll());  
                       Whereas "books" is the name of template for displaying books Details in web browsers and is attributeName for model.addAttribute
                       4. returns "books"
             2. AuthorController
                 1. add **@Controller** annotation
                 2. Create BookService variable  
                    private final AuthorService authorService;
                 3. Create BookController Constructor
                 4. Create a method to get all the book from database
                     1. With the following things
                         1. add @RequestMapping("/authors") annotation  
                            where @RequestMapping is used for request mapping in spring and "/books" is path
                         2. with Model as Parameter whereas Model is inherited from org.springframework.ui
                         3. model.addAttribute("authors",bookService.findAll());  
                            Whereas "authors" is the name of template for displaying Authors details in web browsers and is attributeName for model.addAttribute
                         4. returns "authors"
                        
       7. Add Thymeleaf Dependency in pom.xml file  
          `<dependency>  
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-thymeleaf</artifactId>
          </dependency>`
          **Sync Maven**
       8. Add following line in application.properties  
          spring.h2.console.enabled=true
       9. Build and Run Project (If any error occur please sort out first that error)
       10. GO on this link for Books list  
          [http://localhost:8080/books](http://localhost:8080/books)
       11. GO on this link for Authors list  
           [http://localhost:8080/authors](http://localhost:8080/authors)  
               
       ## **_Congratulation on your first success_**
5.      Dependency Injection with Spring
   1.       Add Controller  
      1. Named **MyController**
      2. **@Controller** annotation
      3. Create a method String sayHello() 
   2. Go to SpringApplication Class
      1. Add Following code  
         `ApplicationContext ctx = SpringApplication.run(SpringFrameworkAndSpringBootApplication.class, args);
         MyController myController = ctx.getBean(MyController.class);
         System.out.println(myController.sayHelloFromMyController());`  
      into **main** method 
   3. Add Test for MyController 
      1. By selecting it name and pressing alt + enter together
      2. Go to MyControllerTest
         1. Add **@SpringBootTest** Annotation at start
         2. Add **@Autowired** to  (Individually)
            1. ApplicationContext application
            2. MyController myController
         3. Add **@Test** annotation to the following method  
            void **testAutowiredOfController()**
         4. Add **@Test** annotation to the following method  
            void **testControllerFromCtx()**
         5. Add **@Test** annotation to the following method  
             void **contextLoad()**  
         Run the test
                    1. Author
                        1. add **@Entity** annotation
                        2. add **@Id** annotation to primary key for particular entity
                        3. Add desire data variables
                        4. Add Constructor
                        5. Create there Getter and Setter
                        6. Add equal and hashCode methods
                        7. add toString method
                    2. Book
                        1. add **@Entity** annotation
                        2. add **@Id** annotation to primary key for particular entity
                        3. Add desire data variables
                        4. Add Constructor
                        5. Create there Getter and Setter
                        6. Add equal and hashCode methods
                        7. add toString method
                    3. Publisher
                        1. add **@Entity** annotation
                        2. add **@Id** annotation to primary key for particular entity
                        3. Add desire data variables
                        4. Add Constructor
                        5. Create there Getter and Setter
                        6. Add equal and hashCode methods
                        7. add toString method
   4.       Dependency Without Injection
       1. Create a **GreetingService** Interface
          1. add **String sayGreeting();**
          2. Create a **GreetingServiceImpl**
             1. Add **@Service** annotation
             2. Implementation of GreetingService via **implementation GreetingService**
             3. Implement the **sayGreeting()** method returning a string message.
          3. Add GreetingService variable in MyController
          4. In MyController Constructor make GreetingService variable a connection to GreetingServiceImpl() by using a **new** keyword   
          5. return **greetingService.sayGreeting()** in MyController method sayHelloFromMyController()
          6. and run a test.
   5.       Dependency Injection Without Spring
       1. Create a **PropertyInjectionController** class
           1. add **String sayHelloFromPropertyController();**
           2.  Create a **PropertyInjectionControllerTest**
                1. Create a PropertyInjectionController variable
                2. Add **@BeforeEach** annotation
                3. add below stated code of lines  
                   `propertyInjectionController=new PropertyInjectionController();`  
                   `propertyInjectionController.greetingService=new GreetingServiceImpl();`
                4. Implement the sayHelloFromPropertyController() method with calling `propertyInjectionController.sayHelloFromPropertyController()`
           3. And Run the test.  
       
       2. Create a **SetterInjectionController** class
           
           1. add **String sayHelloFromSetterController();**
           2. Add Setter method for greeting Service variable via setGreetingService(GreetingService greetingService)
           3. Create a **SetterInjectionControllerTest**
               1. Create a SetterInjectionController variable
               2. Add **@BeforeEach** annotation
               3. add below stated code of lines  
                  `setterInjectionController =new SetterInjectionController();`  
                  `setterInjectionController.setGreetingService(new GreetingServiceImpl());`
               4. Implement the sayHelloFromSetterController() method with calling `setterInjectionController.sayHelloFromSetterController()`
           4. And Run the test.  
       
       3. Create a **ConstructorInjectionController** class
           1. add **String sayHelloFromConstructorController();**
           2. Add Constructor with parameter GreetingService like ConstructorInjectionController(GreetingService greetingService)
           3. Create a **ConstructorInjectionControllerTest**
               1. Create a ConstructorInjectionController variable
               2. Add **@BeforeEach** annotation
               3. add below stated code of lines  
                  `constructorInjectionController=new ConstructorInjectionController(new GreetingServiceImpl());`
               4. Implement the sayHelloFromConstructorController() method with calling `ConstructorInjectionController.sayHelloFromSetterController()`
           4. And Run the test.  
   
   6.       Dependency Injection With Spring Framework
      1. In ConstructorInjectorController
          1. add **@Controller** annotation
      2. In ConstructorInjectorControllerTest   
          1. add **@SpringBootTest** annotation to ConstructorInjectorControllerTest
          2. add **@Autowired** to ConstructorInjectorController variable 
          3. And Run the test.
      3. In PropertyInjectedController
         1. add **@Controller** annotation
         2. add **@Autowired** to **GreetingService** variable
      4. In PropertyInjectedControllerTest
          1. add **@SpringBootTest** annotation to PropertyInjectedControllerTest
          2. add **@Autowired** to PropertyInjectedController variable
          3. And Run the test.
      5. In SetterInjectedController
          1. add **@Controller** annotation
          2. add **@Autowired** to **setGreetingService()** method
      6. In SetterInjectedControllerTest
          1. add **@SpringBootTest** annotation to SetterInjectedControllerTest
          2. add **@Autowired** to SetterInjectedController variable
          3. And Run the test.
      