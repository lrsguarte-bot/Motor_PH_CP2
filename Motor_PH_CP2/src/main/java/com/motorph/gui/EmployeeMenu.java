package com.motorph.gui;


import com.motorph.backend.*;

import javax.swing.*;
import java.awt.*; 
import java.io.IOException;

public class EmployeeMenu extends JPanel {

 private JPanel subPanel;
 private JPanel subPanel2;
 private JPanel subPanel3;
 private JPanel subPanel4;
 private JTextField textField;
 private JButton button;
 private JButton button1;
 private JLabel result1;
 private JLabel result2;
 private JLabel result3;
 private JLabel result4;
 private JLabel result5;
 private JLabel result6;
 private JLabel result7;
 private JLabel result8;
 
 

 public EmployeeMenu(CardLayout cardLayout, JPanel containerPanel) {

 this.setLayout(new GridBagLayout());
 this.setBackground(Color.black);

 addComponents();
 listener(cardLayout, containerPanel);
 
 
}

private JPanel subPanel1() {

  JPanel panel = new JPanel( new GridBagLayout());
  panel.setBackground(Color.white);
    
  GridBagConstraints  gbc = new GridBagConstraints(); 
  gbc.insets =  new Insets(10, 10, 5, 10); 

  button = new JButton("Log out");
  button.setPreferredSize(new Dimension(100, 30));
  button.setFocusable(false); 
  button.setBackground(Color.gray);
  button.setFont(new Font("Comic Sans",Font.BOLD,15));
   
  gbc.weighty = 0.0;
  gbc.anchor = GridBagConstraints.NORTH;
 
  gbc.gridx = 0; gbc.gridy = 0;
  panel.add(button, gbc);
 
  gbc.weighty = 1.0; 
  gbc.gridx = 0; gbc.gridy = 1;
  panel.add(Box.createVerticalGlue(), gbc);

  return panel;

	
}

private JPanel subPanel2() {  

  JPanel panel = new JPanel( new GridBagLayout());
  panel.setBackground(Color.white);
  
  GridBagConstraints  gbc = new GridBagConstraints(); 
  gbc.insets =  new Insets(10, 10, 10, 0);  
  
  textField = new JTextField();
  textField.setPreferredSize(new Dimension(200, 30));
  textField.setFont(new Font("Comic Sans",Font.BOLD,15));
 
  JLabel label = new JLabel("Enter Employee No. :");
  label.setFont(new Font("Comic Sans",Font.BOLD,15));
  
  button1 = new JButton("Enter");
  button1.setPreferredSize(new Dimension(100, 30));
  button1.setFocusable(false);
  button1.setBackground(Color.white);
  button1.setFont(new Font("Comic Sans",Font.BOLD,15));
  

  gbc.weightx = 0.0;
  gbc.anchor = GridBagConstraints.WEST;
      
  gbc.gridx = 0; gbc.gridy = 0;
  panel.add(label, gbc);
  
  gbc.gridx = 1; gbc.gridy = 0;   
  panel.add(textField, gbc); 
    
  gbc.gridx = 2; gbc.gridy = 0;   
  panel.add(button1, gbc); 

  gbc.weightx = 1.0; 
  gbc.gridx = 3; gbc.gridy = 0;
  panel.add(Box.createHorizontalGlue(), gbc);   

  return panel;
      
}

private JPanel subPanel3() {
 JPanel panel = new JPanel(new GridBagLayout());
 panel.setBackground(Color.white);
 
 GridBagConstraints  gbc = new GridBagConstraints(); 

 gbc.fill = GridBagConstraints.BOTH;
 gbc.gridx = 2; gbc.gridy = 0;
 gbc.weightx = 1.0;
 gbc.weighty = 1.0; 
 panel.add(subPanel4(), gbc); 

 return panel;
 
}

private JPanel subPanel4() {

 JPanel panel = new JPanel( new GridBagLayout());
 panel.setBackground(Color.white);

 GridBagConstraints  gbc = new GridBagConstraints(); 
 gbc.insets =  new Insets(5, 10, 5, 10);

 JLabel empIDL = new JLabel("Employee ID: ");
 empIDL.setFont(new Font ("Comic Sans", Font.BOLD,20));
 
 JLabel empFNL = new JLabel("First Name: ");
 empFNL.setFont(new Font ("Comic Sans", Font.BOLD,20));
 
 JLabel empLNL = new JLabel("Last Name: ");
 empLNL.setFont(new Font ("Comic Sans", Font.BOLD,20));

 JLabel empBDL = new JLabel("Birth Date: ");
 empBDL.setFont(new Font ("Comic Sans", Font.BOLD,20));
 
 JLabel empSSS = new JLabel("SSS No.: ");
 empSSS.setFont(new Font ("Comic Sans", Font.BOLD,20));
 
 JLabel empPhil = new JLabel("PhilHealth No.: ");
 empPhil.setFont(new Font ("Comic Sans", Font.BOLD,20));
 
 JLabel empTIN = new JLabel("TIN No.: ");
 empTIN.setFont(new Font ("Comic Sans", Font.BOLD,20));
 
 JLabel empPagI = new JLabel("PagIbig No.: ");
 empPagI.setFont(new Font ("Comic Sans", Font.BOLD,20));

 result1 = new JLabel("");
 result1.setFont(new Font ("Comic Sans", Font.BOLD,20));
    
 result2 = new JLabel("");
 result2.setFont(new Font ("Comic Sans", Font.BOLD,20));
  
 result3 = new JLabel("");
 result3.setFont(new Font ("Comic Sans", Font.BOLD,20));
  
 result4 = new JLabel("");
 result4.setFont(new Font ("Comic Sans", Font.BOLD,20));

 result5 = new JLabel("");
 result5.setFont(new Font ("Comic Sans", Font.BOLD,20));
 
 result6 = new JLabel("");
 result6.setFont(new Font ("Comic Sans", Font.BOLD,20));
 
 result7 = new JLabel("");
 result7.setFont(new Font ("Comic Sans", Font.BOLD,20));
 
 result8 = new JLabel("");
 result8.setFont(new Font ("Comic Sans", Font.BOLD,20));
 
 
 gbc.anchor = GridBagConstraints.WEST;   
 gbc.fill = GridBagConstraints.NONE;
   
 gbc.gridx = 0; gbc.gridy = 0; 
 
 panel.add(empIDL, gbc);
 
 gbc.gridx = 0; gbc.gridy = 1; 
 panel.add(empFNL, gbc);
 
 gbc.gridx = 0; gbc.gridy = 2; 
 panel.add(empLNL, gbc);
   
 gbc.gridx = 0; gbc.gridy = 3; 
 panel.add(empBDL, gbc);
 
 gbc.gridx = 0; gbc.gridy = 4; 
 panel.add(empSSS, gbc);
 
 gbc.gridx = 0; gbc.gridy = 5; 
 panel.add(empPhil, gbc);
  
 gbc.gridx = 0; gbc.gridy = 6; 
 panel.add(empTIN, gbc);
 
 gbc.gridx = 0; gbc.gridy = 7; 
 panel.add(empPagI, gbc);
  
   
  
 
 // result
 gbc.weightx = 1.0;
 gbc.gridx = 1; gbc.gridy = 0;   
 panel.add(result1, gbc);
     
 gbc.gridy = 1; 
 panel.add(result2, gbc);
     
 gbc.gridy = 2; 
 panel.add(result3, gbc);
     
 gbc.gridy = 3; 
 panel.add(result4, gbc);

 gbc.gridy = 4; 
 panel.add(result5, gbc);
  
 gbc.gridy = 5; 
 panel.add(result6, gbc); 
 
 gbc.gridy = 6; 
 panel.add(result7, gbc);
 
 gbc.gridy = 7; 
 panel.add(result8, gbc);
 
 gbc.weighty = 1.0; 
 gbc.gridy = 8;
 panel.add(Box.createHorizontalGlue(), gbc); 

 return panel;
  
}

 private void addComponents() {
 
   GridBagConstraints gbc = new GridBagConstraints();
   gbc.insets = new Insets(5, 5, 5, 0); 
   gbc.gridx = 0; gbc.gridy = 0;
   
   gbc.fill = GridBagConstraints.BOTH;
   gbc.weightx = 0.1; gbc.weighty = 1.0; 
   gbc.gridheight= 2;
   this.add(subPanel1(), gbc);
    
   //sub_panel_2
   gbc = new GridBagConstraints();
   gbc.insets = new Insets(5, 5, 0, 5); 
   gbc.gridx = 1; gbc.gridy = 0;
   gbc.fill = GridBagConstraints.BOTH;
   gbc.weightx = 0.9; gbc.weighty = 0.0;
   this.add(subPanel2(), gbc);   
 
   //sub_panel_3
   gbc = new GridBagConstraints();
   gbc.insets = new Insets(5, 5, 5, 5); 
   gbc.gridx = 1; gbc.gridy = 1;
   gbc.fill = GridBagConstraints.BOTH;
   gbc.weightx = 0.9; gbc.weighty = 1.0;
   this.add(subPanel3(), gbc);   
   
 }

 private void listener(CardLayout cardLayout, JPanel containerPanel) {

  button1.addActionListener(e -> {
 
 String input = textField.getText();

 try {
 
 if(input == null || input.trim().isEmpty() ) {
    DialogCustomizer.show("Please Enter Employee Number!");    
    return;
    }      
 
 Employee result = ProcessPayroll.employeeDetails(input);
 IDs resultId = ProcessPayroll.id(input);

 if (result !=null) {

  result1.setText( result.getid() );
  result2.setText( result.getFname() );
  result3.setText( result.getLname() );
  result4.setText( result.getBday() );  
  result5.setText( resultId.getSSS() );
  result6.setText( resultId.getPhilhealth() );
  result7.setText( resultId.getTIN() );
  result8.setText( resultId.getPagIbig() );
        
    
  

  textField.setText("");
 }
 
  else {
      DialogCustomizer.show("Employee Number Not Found!");
      textField.setText(""); 
      
      result1.setText("");
      result2.setText("");
      result3.setText("");
      result4.setText("");
      result5.setText("");
      result6.setText("");
      result7.setText("");
      result8.setText("");
    
      } 
      }	

 catch (IOException ex){
       DialogCustomizer.show("Something Went Wrong!"); 
       textField.setText("");
       }
 
 });
 
 button.addActionListener(e -> {
     
 	cardLayout.show(containerPanel, "Login_Screen");
    result1.setText("");
    result2.setText("");
    result3.setText("");
    result4.setText("");
    result5.setText("");
    result6.setText("");
    result7.setText("");
    result8.setText("");
    
    
 });
 	
 }

 	
 }
 




  

 

        
 

