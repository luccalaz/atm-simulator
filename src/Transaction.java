import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private String description;
    private double amount;
    private Date timestamp;
    private SimpleDateFormat dateFormat;

    public Transaction(String desc, double amt) {
        description = desc;
        amount = amt;
        timestamp = new Date();
        dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    }

    public String getTransaction() {
        String dateTime = dateFormat.format(timestamp);
        String transaction = dateTime + ": $" + amount + " [" + description + "]";
        return transaction;
    }
}