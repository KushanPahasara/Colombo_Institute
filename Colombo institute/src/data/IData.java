package data;
import Colombo.Employee;
import java.util.ArrayList;

public interface IData {
	boolean add(Employee l);
	boolean update(Employee l);
	boolean delete(int id);
	Employee get(int id);
	ArrayList<Employee> getAll();
	
	

}
