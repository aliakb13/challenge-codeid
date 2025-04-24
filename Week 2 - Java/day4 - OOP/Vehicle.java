import java.time.LocalDate;

public class Vehicle {
    private String noPolice;
    private VType type;
    private int year;
    private long price;
    private long tax;
    private int seat;
    private LocalDate transactionDate;
    private long total;

    public Vehicle(String noPolice, VType type, int year, long price,
                   long tax, int seat, LocalDate transactionDate) {

        this.noPolice = noPolice;
        this.type = type;
        this.year = year;
        this.price = price;
        this.tax = tax;
        this.seat = seat;
        this.transactionDate = transactionDate;
    }

    public String getNoPolice() {
        return noPolice;
    }

    public VType getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public long getPrice() {
        return price;
    }

    public long getTax() {
        return tax;
    }

    public int getSeat() {
        return seat;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public long getTotal() {
        return this.total;
    }


}
