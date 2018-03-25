package ua.danit.dao;

import ua.danit.model.Category;
import ua.danit.model.Product;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ProductMockDaoImpl implements ProductDao {

    private Map<Category, List<Product>> products = new HashMap<>();

    public ProductMockDaoImpl() {
        ArrayList<Product> mobile = new ArrayList<>();
        mobile.add(new Product(
                "iPhoneX",
                "iPhone X is a smartphone designed, developed, and marketed by Apple Inc. It was announced on September 12, 2017, alongside the iPhone 8 and iPhone 8 Plus at the Steve Jobs Theater in the Apple Park campus. The phone was released on November 3, 2017. This device marks the iPhone series' tenth anniversary, with \"X\" being the symbol for \"ten\" in Roman numerals.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/IPhone_X_vector.svg/330px-IPhone_X_vector.svg.png",
                1000));
        mobile.add(new Product(
                "iPhone5",
                "The iPhone 5 is a smartphone designed and marketed by Apple Inc. It is the sixth generation of the iPhone, succeeding the iPhone 4S and preceding the iPhone 5S and iPhone 5C. Formally unveiled as part of a press event on September 12, 2012, it was released on September 21, 2012.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/IPhone_5.png/300px-IPhone_5.png",
                200));
        mobile.add(new Product(
                "iPhone6",
                "The iPhone 6 is a smartphone designed and marketed by Apple Inc. The device is a part of the iPhone series and were announced on September 9, 2014, and released on September 19, 2014.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/IPhone6_silver_frontface.png/330px-IPhone6_silver_frontface.png",
                500));
        mobile.add(new Product(
                "iPhone7",
                "Phone 7 and iPhone 7 Plus are smartphones designed, developed, and marketed by Apple Inc. They were announced on September 7, 2016, at the Bill Graham Civic Auditorium in San Francisco by Apple CEO Tim Cook, and were released on September 16, 2016, succeeding the iPhone 6S and iPhone 6S Plus as the flagship devices in the iPhone series.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/IPhone_7_Plus_Jet_Black.svg/330px-IPhone_7_Plus_Jet_Black.svg.png",
                800));
        this.products.put(Category.mobile, mobile);

        ArrayList<Product> computer = new ArrayList<>();
        computer.add(new Product(
                "MacBook Pro",
                "The MacBook Pro is a line of Macintosh portable computers introduced in January 2006 by Apple Inc. Replacing the PowerBook G4, the MacBook Pro was the second model to be announced during the Apple–Intel transition, after the iMac. It is the high-end model of the MacBook family and is currently available in 13- and 15-inch screen sizes. A 17-inch version was available between April 2006 and June 2012.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/MacBook_Pro_15_inch_%282017%29_Touch_Bar.jpg/450px-MacBook_Pro_15_inch_%282017%29_Touch_Bar.jpg",
                2000));
        computer.add(new Product(
                "Asus Zenbook",
                "Zenbook (also known as ZenBook) are a family of ultrabooks – low-bulk laptop computers – produced by Asus. The first Zenbooks were released in October 2011, and the original range of products was amended and expanded during 2012. Models range from 12-inch laptops, featuring power efficient components but lacking connectivity and having only integrated graphics processors, to 15-inch laptops with discrete graphics processing units and optical disc drives. Most (though not all) Zenbooks use Intel Core ultra-low-voltage processors and Nvidia GPUs when integrated graphics are not used. ",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Asus_x21_ultrabook.jpg/1280px-Asus_x21_ultrabook.jpg",
                1500));
        this.products.put(Category.computer, computer);

        ArrayList<Product> book = new ArrayList<>();
        book.add(new Product(
                "GoF: Design Patterns",
                "Design Patterns: Elements of Reusable Object-Oriented Software is a software engineering book describing software design patterns. The book's authors are Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides with a foreword by Grady Booch. The book is divided into two parts, with the first two chapters exploring the capabilities and pitfalls of object-oriented programming, and the remaining chapters describing 23 classic software design patterns. The book includes examples in C++ and Smalltalk.",
                "https://images-eu.ssl-images-amazon.com/images/I/51kuc0iWoKL.jpg   ",
                30));
        book.add(new Product(
                "Clean Code, by Robert Martin",
                "Even bad code can function. But if code isn’t clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn’t have to be that way. Noted software expert Robert C. Martin presents a revolutionary paradigm with Clean Code: A Handbook of Agile Software Craftsmanship . Martin has teamed up with his colleagues from Object Mentor to distill their best agile practice of cleaning code “on the fly” into a book that will instill within you the values of a software craftsman and make you a better programmer—but only if you work at it.",
                "https://images-na.ssl-images-amazon.com/images/I/71QQhJuMlPL.jpg",
                40));
        this.products.put(Category.book, book);
    }

    @Override
    public Map<Category, List<Product>> getAll() {
        return products;
    }

    @Override
    public List<Product> getByCategory(Category category) {
        if (category == null || products.get(category) == null) {
            System.out.println("Empty category for getProducts");
            return Collections.EMPTY_LIST;
        }
        return products.get(category);
    }

    @Override
    public void add(Product product, Category category) {
        List<Product> products = this.products.get(category);

        if (products == null) {
            ArrayList<Product> item = new ArrayList<>();
            item.add(product);
            this.products.put(category, item);
        } else {
            products.add(product);
        }
    }

    @Override
    public void remove(Long id) {
        /*Map<Category, List<Product>> allProducts = getAll();
        Product product;

        allProducts.forEach(
                (Category k, List<Product> v) -> v.removeAll(
                        Collections.singleton(product)
                )
        );*/

        /*allProducts.forEach(
                (k, v) -> v.removeIf(
                        e -> {
                            return e.getId().equals(id);
                        }
                )
        );*/
    }


}
