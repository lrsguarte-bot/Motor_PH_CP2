package com.motorph.backend;

import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

 public class CalculationForHours {
 
  public static double totalHours(String rawIn, String rawOut) {

    DateTimeFormatter time = DateTimeFormatter.ofPattern("H:mm");

    LocalTime workStart = LocalTime.of(8,0); 

    LocalTime lateLimit = LocalTime.of(8,5);

    LocalTime workEnd = LocalTime.of(17,0);

    LocalTime in = LocalTime.parse(rawIn, time);

    LocalTime out = LocalTime.parse(rawOut, time);

    LocalTime calIn = (in.isBefore(lateLimit)) ? workStart : in;

    LocalTime calOut = (out.isAfter(workEnd)) ? workEnd : out;

    if (calOut.isBefore(calIn)) return 0.0;
    
    java.time.Duration total = Duration.between(calIn, calOut);

    double totalHoursWorked = total.toMinutes() / 60.0;

    if (totalHoursWorked >= 1.0) {
    	return totalHoursWorked - 1.0;
  } 
	return 0.0;
  } 
}  

