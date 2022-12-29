package data;
import java.io.*;
import Colombo.Employee;
import java.util.ArrayList;
import java.util.Scanner;
import Colombo.Login;

public class Employeefile {
	private File fileObj;

	public Employeefile() {
		// TODO Auto-generated constructor stub
		fileObj= new File("A:/hd54/login.txt");
		
	}
	public void add(Login m ) {
		try {
			FileWriter fw= new FileWriter(fileObj,true);
			String line=m.getUserID()+"\t"+m.getPassword()+ "\n";
			fw.write(line);
			fw.close();
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage() );
		}
		catch(IOException e) {
			System.out.println(e.getMessage() );
		
			
		}
		
	}
	public ArrayList<Login> getAll(){
		ArrayList<Login> Loglist= new ArrayList<Login>();
		try {
			Scanner sc=new Scanner(fileObj) ;
			while(sc.hasNextLine()) {
				String line=sc.nextLine();
				String [] arr= line.split("\t");
				String UserID=arr [0];
                String password=arr[1];
                
               Login em= new Login( UserID, password);
               Loglist.add(em);
		}
			return Loglist;
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage() );
			return null;
		}
		catch(Exception e) {
			System.out.println(e.getMessage() );
			return null;
		
			
		}
		
	}
	
	    //  public Employee get(int epf) {
	    //	  for(Employee l:getAll()) {
	   // 		  if(l.getEpf()== epf) {
	   // 			  return l;
	   // 		  }
	   // 	  }
	    //	  return null;
	    	  
	   //   }
	      
	  //    public boolean delete(int epf ) {
	   // 	  boolean flag=false;
	   // 	  ArrayList<Employee> Employeelist= getAll();
	    //	  for(Employee l: Employeelist) {
	    //		  if(l.getEpf()==epf) {
	    //			  Employeelist.remove(l);
	    //			  flag=true;
	    //			  break;
	    //		  }
	    		  
	    //	  }
	    //	  try {
	  	//		FileWriter fw= new FileWriter(fileObj);
	  	//		fw.write(" ");
	  	//		fw.close();
	  	//		
	  	//	}catch(FileNotFoundException e) {
	  	//		System.out.println(e.getMessage() );
	  	//		flag= false;
	  	//	}
	  	//	catch(IOException e) {
	  	//		System.out.println(e.getMessage() );
	  	//		flag= false;
	  	//	}
	    //	  for(Employee l: Employeelist) {
	    //		  add(l);
	    //	  }
	    //	  return flag;
	    	  
	   //   }
	      
	   //   public boolean update(Employee l) {
	    //	  int epf=l.getEpf();
	    //	  boolean deleted=delete(epf);
	    //	  if(deleted) {
	    //		  add(l);
	    //		  return true;
	    //		  
	    //	  }else {
	    //		  return false;
	    //	  }
	     // }
	
}
