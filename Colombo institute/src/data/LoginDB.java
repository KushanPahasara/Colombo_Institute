package data;
import java.io.*;
import Colombo.Login;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginDB {
	private File fileObj;

	public LoginDB() {
		// TODO Auto-generated constructor stub
		fileObj= new File("A:/hd54/login.txt");
		
	}
	public void add(Login m ) {
		try {
			FileWriter fw= new FileWriter(fileObj,true);
			String line=m.getUserID()+"\t"+m.getPassword()+"\n";
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
		ArrayList<Login> loglist= new ArrayList<Login>();
		try {
			Scanner sc=new Scanner(fileObj) ;
			while(sc.hasNextLine()) {
				String line=sc.nextLine();
				String [] arr= line.split("\t");
				String UserID=arr [0];
                String password=arr[1];
               Login log= new Login(UserID,password);
               loglist.add(log);
		}
			return loglist;
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage() );
			return null;
		}
		catch(Exception e) {
			System.out.println(e.getMessage() );
			return null;
		
			
		}
		
	}
	
	      public Login get(String UserID) {
	    	  for(Login l:getAll()) {
	    		  if(l.getUserID().equals(UserID)) {
	    			  return l;
	    		  }
	    	  }
	    	  return null;
	    	  
	      }
	      
	      public boolean delete(String UserID ) {
	    	  boolean flag=false;
	    	  ArrayList<Login> loglist= getAll();
	    	  for(Login l: loglist) {
	    		  if(l.getUserID().equals(UserID)) {
	    			  loglist.remove(l);
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
	    	  for(Login l: loglist) {
	    		  add(l);
	    	  }
	    	  return flag;
	    	  
	      }
	      
	      public boolean update(Login l) {
	    	  String UserID=l.getUserID();
	    	  boolean deleted=delete(UserID);
	    	  if(deleted) {
	    		  add(l);
	    		  return true;
	    		  
	    	  }else {
	    		  return false;
	    	  }
	      }
	
}
