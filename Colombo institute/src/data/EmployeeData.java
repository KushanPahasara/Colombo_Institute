package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Colombo.Employee;

public class EmployeeData implements IData{
	private File fileObj;
	
    public EmployeeData() {
    	fileObj= new File("A:/hd54/book.txt");
	}
	
	
	@Override
	public boolean add(Employee m) {
		try {
			FileWriter fw= new FileWriter(fileObj,true);
			String line=m.getName()+"\t"+m.getEpf()+"\t"+m.getDepartment()+"\t"+m.getSection()+"\t"+m.getDesignation()+"\n";
			fw.write(line);
			fw.close();
			return true;
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage() );
			return false;
		}
		catch(IOException e) {
			System.out.println(e.getMessage() );
		     return false;
			
		}
	}

	@Override
	public boolean update(Employee l) {
		int epf=l.getEpf();
  	  boolean deleted=delete(epf);
  	  if(deleted) {
  		  add(l);
  		  return true;
  		  
  	  }else {
  		  return false;
  	  }
	}

	@Override
	public boolean delete(int id) {
		boolean flag=false;
  	  ArrayList<Employee> Employeelist= getAll();
  	  for(Employee l: Employeelist) {
  		  if(l.getEpf()==id) {
  			  Employeelist.remove(l);
  			  flag=true;
  			  break;
  		  }
  		  
  	  }
  	  try {
			FileWriter fw= new FileWriter(fileObj);
			fw.write(" ");
			fw.close();
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage() );
			flag= false;
		}
		catch(IOException e) {
			System.out.println(e.getMessage() );
			flag= false;
		}
  	  for(Employee l: Employeelist) {
  		  add(l);
  	  }
  	  return flag;
	}

	@Override
	public Employee get(int id) {
		 for(Employee l:getAll()) {
   		  if(l.getEpf()== id) {
   			  return l;
   		  }
   	  }
   	  return null;
	}

	@Override
	public ArrayList<Employee> getAll() {
		ArrayList<Employee> Employeelist= new ArrayList<Employee>();
		try {
			Scanner sc=new Scanner(fileObj) ;
			while(sc.hasNextLine()) {
				String line=sc.nextLine();
				String [] arr= line.split("\t");
				String name=arr [0];
                int epf=Integer.valueOf(arr[1]);
                String department=arr[2];
                String section=arr[3];
                String designation=arr[4];
               Employee em= new Employee(name , epf , department,section,designation);
               Employeelist.add(em);
		}
			return Employeelist;
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage() );
			return null;
		}
		catch(Exception e) {
			System.out.println(e.getMessage() );
			return null;
		
			
		}
	}

}
