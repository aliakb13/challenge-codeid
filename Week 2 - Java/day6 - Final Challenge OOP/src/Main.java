import com.learning.HRServiceImpl;

public class Main {
    public static void main(String[] args) {
        HRServiceImpl impl = new HRServiceImpl();

       var listOfEmp = impl.initEmployee();
       impl.generateTotalSalary(listOfEmp);
       impl.displayEmployee(listOfEmp);
       impl.summary(listOfEmp);
    }
}
