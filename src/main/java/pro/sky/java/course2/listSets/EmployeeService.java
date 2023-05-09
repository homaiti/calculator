package pro.sky.java.course2.listSets;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.listSets.EmployeeAlreadyAddedException;
import pro.sky.java.course2.listSets.EmployeeNotFoundException;
import pro.sky.java.course2.listSets.Employee;
import pro.sky.java.course2.listSets.EmployeeStorageFullException;

import java.util.ArrayList;

@Service
public class EmployeeService {

    private static final int MAX_SIZE = 8;
    private final ArrayList<Employee> emplList = new ArrayList<>(MAX_SIZE);

    public Employee addEmpl(String firstName, String lastName) {
        if (emplList.size() > MAX_SIZE) {
            throw new EmployeeStorageFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (emplList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        emplList.add(employee);
        return employee;
    }


    public Employee delEmpl(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        if (!emplList.remove(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Employee serachEmpl(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        for (Employee empl : emplList) {
            if (emplList.contains(employee)) {
                return empl;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public ArrayList<Employee> getEmplList() {
        return emplList;
    }
}






