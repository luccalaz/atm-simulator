import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction implements Serializable {
    // ------------------------------------------------------------ variable initialization
    private String description;
    private double amount;
    private Date timestamp;
    private SimpleDateFormat dateFormat;

    // ------------------------------------------------------------ constructor method
    public Transaction(String desc, double amt) {
        description = desc;
        amount = amt;
        timestamp = new Date();
        dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    }

    // ------------------------------------------------------------ gets/sets
    public String getTransaction() {
        String dateTime = dateFormat.format(timestamp);
        String transaction = dateTime + ": $" + String.format("%,.2f", amount) + " [" + description + "]";
        return transaction;
    }
}