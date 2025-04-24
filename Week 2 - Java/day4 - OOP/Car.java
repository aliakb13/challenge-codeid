import java.time.LocalDate;

public class Car extends Vehicle {

    private Integer rent;
    private Integer driver;
    private Integer order;
    private Integer orderPerKm;
    public static int totalCar;

    public Car(String noPolice, VType type, int year, int price, long tax, int seat, LocalDate transactionDate, Integer rent, Integer driver, Integer order, Integer orderPerKm) {
        super(noPolice, type, year, price, tax, seat, transactionDate);

        this.rent = rent;
        this.driver = driver;
        this.order = order;
        this.orderPerKm = orderPerKm;
        totalCar++;
    }

    @Override
    public long getTotal() {
        if (super.getType() == VType.SUV){
            return rent + driver;
        } else {
            return (long) order * orderPerKm;
        }
    }

    @Override
    public String toString() {
        String message = "";

        if(super.getType() == VType.SUV) {
            message = this.getClass().getName() + " with {NoPolice = " + super.getNoPolice()
                    + ", Type = " + super.getType() + ", Year = " + super.getYear()
                    + ", Price = " + super.getPrice() + ", Tax(InYear) = " + super.getTax() + ", Seat = " + super.getSeat()
                    + ", TransactionDate = " + super.getTransactionDate() + ", Rent = " + rent + ", Driver = " + driver
                    + ", Total = " + getTotal() + "}";
        } else {
            message = this.getClass().getName() + " with {NoPolice = " + super.getNoPolice()
                    + ", Type = " + super.getType() + ", Year = " + super.getYear()
                    + ", Price = " + super.getPrice() + ", Tax(InYear) = " + super.getTax() + ", Seat = " + super.getSeat()
                    + ", TransactionDate = " + super.getTransactionDate() + ", Order = " + order + ", OrderPerKM = " + orderPerKm
                    + ", Total = " + getTotal() + "}";
        }

        return message;
    }

    public static long totalIncomeCar(Car... cars) {
        long sum = 0;
        for (Car car: cars) {
            sum += car.getTotal();
        }
        return sum;
    }
}
