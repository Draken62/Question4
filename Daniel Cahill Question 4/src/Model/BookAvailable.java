package Model;

@SuppressWarnings("serial")
public class BookAvailable extends ObjectList{

    public BookAvailable(int maxsize) {
        super(maxsize);
    }

    public Book getBook(int index) {
        return (Book)getObject(index);
    }

    public int search(int isbn) {
        // Transverse the list of objects to return position of the object based on the isbn
        int position = 0;
        for(Object obj:getList()) {
            Book current = (Book)obj;
            if(current.getISBN() == isbn) {
                return position;
            }
            position++;
        }
        return -1; // Returns -1 if not found
    }

    public boolean removeBook(int isbn) {
        // Handles removing a book from the list of books
        int position = search(isbn);
        if(position > -1) { // If we found the book, remove it and return true
            getList().remove(position);
            return true;
        } else {
            return false;
        }
    }

    public double calculateYearlyBookPayment() {
        // Return -1 if list of books if empty
        if (isEmpty()) return -1;

        // Transverse the list of books and Calculate the total price
        double total = 0;
        for(Object obj:getList()) {
            Book current = (Book)obj;
            total += current.getPrice();
        }
        return total;
    }
}
