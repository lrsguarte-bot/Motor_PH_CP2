package com.motorph.gui;

import com.motorph.backend.*;

import javax.swing.*;
import java.awt.*; 

public class Login extends JPanel {


private JButton button;
private JTextField textField1;
private JPasswordField textField2;

public Login( CardLayout cardLayout, JPanel containerPanel ){
	           
    this.setBackground(Color.black);
    this.setLayout(new GridBagLayout());   
    
    mainPanel();
    verification(cardLayout, containerPanel); 
    
  
        }
        
    //subPanel1
    
    private JPanel subPanel1() {
    
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(Color.white);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);

    button = new JButton("Login");
    button.setPreferredSize(new Dimension(200, 30));
    button.setFocusable(false);
    button.setBackground(Color.white);
    button.setFont(new Font("Comic Sans",Font.BOLD,15));
      
    textField1 = new JTextField();
    textField1.setPreferredSize(new Dimension(300, 30));
    textField1.setFont(new Font("Comic Sans",Font.BOLD,15));
      
    textField2 = new JPasswordField();
    textField2.setPreferredSize(new Dimension(300, 30));  
    textField2.setFont(new Font("Comic Sans",Font.BOLD,15));
      
    JLabel userLabel = new JLabel("Username");  
    JLabel passLabel = new JLabel("Password");
       
    userLabel.setFont(new Font("Comic Sans",Font.BOLD,15));
    passLabel.setFont(new Font("Comic Sans",Font.BOLD,15));
    
    //coordinates
        
    gbc.gridx = 0; gbc.gridy = 1; panel.add(userLabel, gbc);
    gbc.gridx = 1; gbc.gridy = 1; panel.add(textField1, gbc);
    gbc.gridx = 0; gbc.gridy = 2; panel.add(passLabel, gbc);
    gbc.gridx = 1; gbc.gridy = 2; panel.add(textField2, gbc);
    gbc.gridx = 1; gbc.gridy = 3; panel.add(button, gbc);
    
    return panel;
    
    }   

    //subPanel2
    
    private JPanel subPanel2() {

    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(Color.white);
    
    return panel;   
    	
    }

    //add_subPanels to container
    private void mainPanel() {

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5); 
    
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridx = 0; gbc.gridy = 0; 
    gbc.weightx = 0.7; gbc.weighty = 1.0; 
    this.add(subPanel1(), gbc);
 
    gbc = new  GridBagConstraints(); 
    gbc.insets = new Insets(5, 0, 5, 5); 
    gbc.fill = GridBagConstraints.BOTH;

    gbc.gridx = 1; gbc.gridy = 0; 
    gbc.weightx = 0.3; gbc.weighty = 1.0; 
    this.add(subPanel2(), gbc);   
  	
    }

    private void verification(CardLayout cardLayout, JPanel containerPanel) {

    button.addActionListener(e -> {

    String input1 = textField1.getText();
      
    String input2 = new String (textField2.getPassword());
            
    String Verify = Verification.verify(input1, input2);
         
    switch (Verify)	{
    
       case "failed":
       
        DialogCustomizer.show("Please Enter Username and Password");                  
      	break;
      	
       case "admin":
       
        cardLayout.show(containerPanel, "Admin_Screen");   
        textField1.setText("");
        textField2.setText("");
      	break;
      	
       case "employee":
      
        cardLayout.show(containerPanel, "Employee_Screen");   
        textField1.setText("");
        textField2.setText("");    
      	break; 
      	
      case "incorrect":
      
        DialogCustomizer.show("Incorrect Password and Username");
        textField1.setText("");
        textField2.setText("");
      	break;
      	
       }

     });
    
    }
 

 }
 
	

