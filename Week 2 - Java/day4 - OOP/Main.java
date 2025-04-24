import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        // Car
        Car suv1 = new Car("D 1001 UM", VType.SUV, 2010, 350_000_000, 3_500_000, 4, LocalDate.of(2023,1,10),500_000,150_000,null,null);
        Car suv2 = new Car("D 1002 UM", VType.SUV, 2010, 350_000_000, 3_500_000, 4, LocalDate.of(2023,1,10),500_000,150_000,null,null);
        Car suv3 = new Car("D 1003 UM", VType.SUV, 2015, 350_000_000, 3_500_000, 4, LocalDate.of(2023,1,12),500_000,150_000,null,null);
        Car suv4 = new Car("D 1004 UM", VType.SUV, 2015, 350_000_000, 3_500_000, 4, LocalDate.of(2023,1,13),500_000,150_000,null,null);

        Car taxi1 = new Car("D 11 UK", VType.Taxi, 2002, 175_000_000, 1_750_000, 4, LocalDate.of(2023,1,12),null, null,45, 4500);
        Car taxi2 = new Car("D 12 UK", VType.Taxi, 2015, 225_000_000, 2_250_000, 4, LocalDate.of(2023,1,13),null,null,75,4500);
        Car taxi3 = new Car("D 13 UK", VType.Taxi, 2020, 275_000_000, 2_750_000, 4, LocalDate.of(2023,1,13), null, null, 90, 4500);

        // Plane
        Plane plane1 = new Plane("ID8089", 2015, 150_000_000_000L, 1_500_000_000, 12, LocalDate.of(2023,12,23),55_000_000);
        Plane plane2 = new Plane("ID8099", 2018, 175_000_000_000L, 1_750_000_000, 15, LocalDate.of(2023,12,25),75_000_000);

        // Boat
        Boat boat = new Boat("Boat18", 2020, 2_000_000_000, 20_000_000, 12, LocalDate.of(2023,12,25),10_000_000);

//        List<Vehicle> listOfVehicle = List.of(suv1, suv2, suv3, suv4, taxi1, taxi2, taxi3, plane1, plane2, boat);
        Vehicle[] listOfVehicle = new Vehicle[]{suv1, suv2, suv3, suv4, taxi1, taxi2, taxi3, plane1, plane2, boat};

//        printVehicle(listOfVehicle);

        printTotalTax(listOfVehicle);
        System.out.println("=".repeat(15));
        printTotalAndIncomeCar(suv1, suv2, suv3, suv4, taxi1, taxi2, taxi3);
        System.out.println("=".repeat(15));
        printTotalAndIncomePlane(plane1,plane2);
        System.out.println("=".repeat(15));
        printTotalAndIncomeBoat(boat);
    }

    public static void printVehicle(Vehicle[] listOfVehicle) {
        for (Vehicle vec : listOfVehicle) {
            System.out.println(vec);
            System.out.println("#".repeat(10));
        }
    }

    public static void printTotalAndIncomeCar(Car... cars) {
        System.out.printf("Total Income Car: %,d%n", Car.totalIncomeCar(cars));
        System.out.println("Total Car: " + Car.totalCar);
    }

    public static void printTotalAndIncomePlane(Plane... planes) {
        System.out.printf("Total Income Plane: %,d%n", Plane.totalIncomePlane(planes));
        System.out.println("Total Plane: " + Plane.totalPlane);
    }

    public static void printTotalAndIncomeBoat(Boat... boats) {
        System.out.printf("Total Income Boat: %,d%n", Boat.totalIncomeBoat(boats));
        System.out.println("Total Boat: " + Boat.totalBoat);
    }

    public static void printTotalTax(Vehicle[] listOfVehicle) {
        long total = 0;
        for(Vehicle v : listOfVehicle) {
            total += v.getTax();
        }
        System.out.printf("Total Tax: %,d%n", total);
    }
}
