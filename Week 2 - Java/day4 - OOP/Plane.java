import java.time.LocalDate;

public class Plane extends Vehicle{
    private long orderPerHours;
    public static int totalPlane;

    public Plane(String noPolice, int year, long price, long tax, int seat, LocalDate transactionDate, int orderPerHours) {
        super(noPolice, VType.PrivateJet, year, price, tax, seat, transactionDate);
        this.orderPerHours = orderPerHours;
        totalPlane++;
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

    public static long totalIncomePlane(Plane... planes) {
        long sum = 0;
        for (Plane jet: planes) {
            sum += jet.getTotal();
        }
        return sum;
    }
}
