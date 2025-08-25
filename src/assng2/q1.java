package assng2;

class Book{
    String title;
    String author;
    double Price;

    Book(String title, String author, double Price){
        this.author = author;
        this.title  = title;
        this.Price = Price;
    }
    void display(){
        System.out.printf("Book Title: %s\n",title);
        System.out.printf("Author: %s",author);
        System.out.printf("Price:$ %.2f%n",Price);
    }
}
public class q1 {
    public static void main(String[] args){
        Book book1 = new Book("Harry Potter", "J K Rowling", 399.99);
        Book book2 = new Book("Lord of the rings", "J R R Tolkien", 199.50);
        Book book3 = new Book("The Hobbit", "J R R Tolkien", 99.00);

        book1.display();
        book2.display();
        book3.display();
    }
}
