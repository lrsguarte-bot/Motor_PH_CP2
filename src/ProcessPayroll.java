import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException;

public class ProcessPayroll {

 public static Employee employeeDetails(String id_Number) throws IOException {
 	  
 	   String empFile = "resources/MotorPh.csv";
 	   String line = "";   
 	   
 	 try( BufferedReader br = new BufferedReader(new FileReader(empFile))) {
 	    br.readLine();
 	   	    
 	   while ((line = br.readLine()) !=null ) {
 	   String[] values = line.split(",");
 	                 
 	       if(values.length < 4 ){
 	       continue;
 	       }
 	              
 	      if(id_Number.equals(values[0])){
 	      return new Employee(values[0], values[1], values[2], values[3]);                             	      
 	      }       	
 	    }
 	  }
 	   	return null; 
 	  } 

   public static Admin admin(String id_Number, int targetMonth ) throws IOException {
  
    String attendance = "resources/attendance.csv";
    String line = "";
    
    double overall = 0.0;
    double overall2 = 0.0;

    boolean employeeFound = false;   
    
    
    try(BufferedReader br = new BufferedReader(new FileReader(attendance))) {
    	br.readLine();
    	
    	while((line = br.readLine()) !=null ) {
    	
        String[] values = line.split(",");
        
        if (id_Number.equals(values[0])) {    
          
            String[] dateParts = values[3].split("/");
            int m = Integer.parseInt(dateParts[0]);
            int d = Integer.parseInt(dateParts[1]);

         if (m == targetMonth) {
            employeeFound = true;
            double totalH = CalculationForHours.totalHours(values[4], values[5]);

            if (d >= 1 && d <= 15) { 
                overall += totalH;
               }
            else if (d >= 16 && d <= 31){
            	overall2 += totalH;
               }   
           
           } 
        } 
        }
        }
        
        if (!employeeFound) {
        	return null;
        }
      
        
        double getRate = Rate.getRate(id_Number);
       
        String firstCutOff = month(targetMonth) + " 1 - 15";    
        
        double grossSalary = rawSalary (overall, getRate);
        double netSalary = grossSalary;

        String secondCutOff = month(targetMonth) + " 16 - 31";      
        double grossSalary2 = rawSalary(overall2, getRate);
        
        double combinedSalary = netSalary + grossSalary2;
        double getSSS = Deductions.computeSSS(combinedSalary);
        double getphilHealth = Deductions.computePhilhealth(combinedSalary);
        double getpagIbig = Deductions.computePagibig(combinedSalary);
        double getTax = Deductions.computeMonthlyTax(combinedSalary);
        double getnetSalary = computeAll(getSSS, getphilHealth, getpagIbig, getTax, grossSalary2);
        
        return new Admin(firstCutOff, overall, grossSalary, netSalary, secondCutOff, overall2, grossSalary2, getSSS, getphilHealth, 
                         getpagIbig, getTax, getnetSalary);
                  	
        
      
    }
  
  
  public static double computeAll(double SSS, double philHealth, double pagIbig, double Tax, double grossSalary2) {
  	double totalDeduction = SSS + philHealth + pagIbig + Tax;
  	double netSalary = grossSalary2 - totalDeduction;
  	return netSalary;
  }
  public static double rawSalary (double totalHours, double getRate) {
   return totalHours * getRate;
  }
 
  
  public static String month(int m){
  
  	switch (m) {
  		case 6:  return "June";
  		case 7:  return "July";
  	    case 8:  return "August";
        case 9:  return "September";
  	    case 10: return "October";
  	    case 11: return "November";
  	    case 12: return "December";
  	    default: return "unknown";
  	    
  	}
  	
  }	
}
