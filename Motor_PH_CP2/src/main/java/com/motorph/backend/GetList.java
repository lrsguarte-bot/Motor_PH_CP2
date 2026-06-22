package com.motorph.backend;

import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException;
import java.util.ArrayList;

public class GetList {

public static ArrayList <Employee> GetList() throws IOException {
	ArrayList<Employee> employeeList = new ArrayList<>();
	String empFile = "resources/MotorPh.csv";

	try(BufferedReader br = new BufferedReader(new FileReader(empFile))) {
		br.readLine();
		String line = "";

		while((line = br.readLine()) != null) {
		
			String[] values = line.split(",");
			
			if (values.length >= 4 ) {
				employeeList.add(new Employee(values[0], values[1], values[2], values[3]));
			}
		}
	}
  return employeeList;
 }
 

 public static String[][] getTableData() throws IOException {
 	ArrayList<Employee>  list = GetList(); // bucket
 	String[][] tableData = new String[list.size()][4]; // container

 	for (int i = 0; i < list.size(); i++) {
 		Employee emp = list.get(i);
 		tableData[i][0] = emp.getid();
 	    tableData[i][1] = emp.getFname();
 		tableData[i][2] = emp.getLname();
 		tableData[i][3] = emp.getBday();
 		
 	}
 	return tableData;
 }
}
