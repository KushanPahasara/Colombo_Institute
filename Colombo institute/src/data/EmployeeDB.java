package data;
import java.util.ArrayList;
import Colombo.Employee;


public class EmployeeDB {
	private ArrayList<Employee> Employeelist;
	
	public EmployeeDB() {
		// TODO Auto-generated constructor stub
		
		Employeelist=new ArrayList<Employee>();
	}
	
	public void add(Employee e) {
		Employeelist.add(e);
	}

	public ArrayList<Employee> getAll() {
		return Employeelist;
		
	}
	
	public boolean delete (int epf) {
		for( Employee e: Employeelist) {
			if(e.getEpf()==epf) {
				Employeelist.remove(e);
				return true;
			}
		}
		return false;
	}
	
	public Employee get (int epf) {
		for( Employee e: Employeelist) {
			if(e.getEpf()==epf) {
				return e;
			}
		}
		return null;
	}
}
