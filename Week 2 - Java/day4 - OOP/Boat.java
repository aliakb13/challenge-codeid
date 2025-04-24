import java.time.LocalDate;

public class Boat extends Vehicle {
    private int orderPerHours;
    public static int totalBoat;

    public Boat(String noPolice, int year, long price, long tax, int seat, LocalDate transactionDate, int orderPerHours) {
        super(noPolice, VType.Boat, year, price, tax, seat, transactionDate);
        this.orderPerHours = orderPerHours;
        totalBoat++;
    }

    @Override
    public long getTotal() {
        return orderPerHours;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " with {NoPolice = " + super.getNoPolice()
                + ", Type = " + super.getType() + ", Year = " + super.getYear()
                + ", Price = " + super.getPrice() + ", Tax(InYear) = " + super.getTax() + ", Seat = " + super.getSeat()
                + ", TransactionDate = " + super.getTransactionDate() + ", OrderPerHours = " + orderPerHours
                + ", Total = " + getTotal() + "}";
    }

    public static long totalIncomeBoat(Boat... boats) {
        long sum = 0;
        for (Boat b: boats) {
            sum += b.getTotal();
        }
        return sum;
    }
}
