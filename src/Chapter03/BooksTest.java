class Books {
    String title;
    String author;
}

public class BooksTest {
    public static void main(String[] args) {
        Books[] myBooks = new Books[3];
        
        myBooks[0] = new Books();
        myBooks[1] = new Books();
        myBooks[2] = new Books();
        
        myBooks[0].title = "The Grapes of Java";
        myBooks[1].title = "The Java Gatsby";
        myBooks[2].title = "The Java Cookbook";
        myBooks[0].author = "bob";
        myBooks[1].author = "sue";
        myBooks[2].author = "ian";
        for (Books myBook : myBooks) {
            System.out.print(myBook.title);
            System.out.print(" by ");
            System.out.println(myBook.author);
        }
    }
}