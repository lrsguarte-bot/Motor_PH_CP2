
import java.io.*;

 public class AddingEmployee { 

 public void add(String lastname,
                 String firstname,
                 String birthday,
                 String address,
                 String phonenumber, 
                 String SSS, 
                 String philhealth, 
                 String TIN, 
                 String pagibig,
                 String status, 
                 String position, 
                 String supervisor, 
                 String basicSalary,
                 String riceSub, 
                 String phoneAll, 
                 String clothingAll, 
                 String grossSemi,
                 String hourlyRate) throws IOException {

  //   String validationResult = 

     int nextId = getNextEmployeeNumber();

     String newRow = String.join(",",

     String.valueOf(nextId),
     wrap(lastname),
     wrap(firstname), 
     wrap(birthday),
     wrap(address),
     wrap(phonenumber),
     wrap(SSS),
     wrap(philhealth),
     wrap(TIN),
     wrap(pagibig),
     wrap(status),
     wrap(position),
     wrap(supervisor),
     wrap(basicSalary),
     wrap(riceSub),
     wrap(phoneAll),
     wrap(clothingAll), 
     wrap(grossSemi),
     wrap(hourlyRate));
                 	
     

     try(BufferedWriter bw = new BufferedWriter(new FileWriter("resources/MotorPh.csv", true ))) {
      	bw.newLine();
      	bw.write(newRow);     	
      }
     }
     
     private String  wrap(String data){

        String clean;

        if (data == null) {
        	clean = "";        	
        }
        
        else {
        	clean = data.replace("\"", "\"\"");
        }
        
        return "\"" + clean + "\"";
     	}           
 
      private int getNextEmployeeNumber() throws IOException {

      	int maxId = 1000;
      	File  empfile = new File("resources/MotorPh.csv");

      	if(!empfile.exists()) {
      		return 1001;
      	    }

      	try (BufferedReader br = new BufferedReader(new FileReader(empfile))) {
      	     br.readLine();
      	     
      		String line;
      		while ((line = br.readLine())  !=null ) {

      		String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
      		
      		if (columns.length > 0 && !columns[0].isEmpty()) {
      		
      		   int currentId = Integer.parseInt(columns[0].replace("\"", ""));
      		   if (currentId > maxId) {
      			  maxId = currentId;
      					
      				}
      			}
      		
      		}
      		}
      	    

      	return maxId + 1;
      }    

            

 


 

 


 	
 }
