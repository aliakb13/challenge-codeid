import com.learning.EmployeeImpl;

public class Main {
    public static void main(String[] args) {


        EmployeeImpl empImp = new EmployeeImpl();

        var listOfEmp = empImp.initListEmployee();

        empImp.printEmployee(listOfEmp);
        empImp.generateTaxAndSalary(listOfEmp);
        System.out.println("=".repeat(15));
        empImp.printEmployee(listOfEmp);

    }
}
