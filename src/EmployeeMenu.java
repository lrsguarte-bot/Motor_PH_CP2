import javax.swing.*;
import java.awt.*; 
import java.io.IOException;

public class EmployeeMenu {

 public static JPanel employeeInterface(CardLayout cardLayout, JPanel containerPanel) {

 JPanel panel = new JPanel();

 panel.setLayout(new GridBagLayout());
 panel.setBackground(Color.gray);
 GridBagConstraints gbc = new  GridBagConstraints();
 gbc.insets = new Insets(10, 10, 10, 10);

 JTextField textField1 = new JTextField();
 textField1.setPreferredSize(new Dimension(200, 50));
 textField1.setFont(new Font("Comic Sans",Font.BOLD,15));
 
 JLabel Enter_emp = new JLabel("Enter Employee No. :");
 Enter_emp.setFont(new Font("Comic Sans",Font.BOLD,15));
 
 JButton button = new JButton("Enter");
 button.setPreferredSize(new Dimension(150, 50));
 button.setFocusable(false);
 button.setBackground(Color.white);
 button.setFont(new Font("Comic Sans",Font.BOLD,15));

 JButton LogoutButton = new JButton("Log out");
 LogoutButton.setPreferredSize(new Dimension(150, 50));
 LogoutButton.setFocusable(false);
 LogoutButton.setBackground(Color.white);
 LogoutButton.setFont(new Font("Comic Sans",Font.BOLD,15));
 
 JTextArea textArea = new JTextArea(10, 18);
 textArea.setEditable(false);
 textArea.setFont(new Font("Comic Sans",Font.BOLD,20));
 
 JScrollPane scrollPane = new JScrollPane(textArea);
 
 gbc.gridx = 2; gbc.gridy = 1;
 panel.add(textField1, gbc);

 gbc.gridx = 1; gbc.gridy = 1;
 panel.add(Enter_emp, gbc);

 gbc.gridx = 2; gbc.gridy = 2;
 panel.add(button, gbc);
 
 gbc.gridx = 2; gbc.gridy = 3;
 panel.add(LogoutButton, gbc);
 
 gbc.gridx = 3; 
 gbc.gridy = 0;
 gbc.gridheight = 8; 
 gbc.fill = GridBagConstraints.BOTH;
 panel.add(scrollPane, gbc);

 button.addActionListener(e -> {
 
 String input = textField1.getText();

 try {
      
 
 Employee result = ProcessPayroll.employeeDetails(input);

 if (result !=null) {
 	textArea.setText("Employee Details\n=====================\n" +
 	                 "Employee ID: " + result.getid() + "\n"+
                     "First Name: "  + result.getFname() + "\n" +
                     "Last Name: "   + result.getLname() + "\n" +
                     "Birth Date: "  + result.getBday() + "\n" +  
                     "=============================");
                      textField1.setText("");
 }
 
  else {
      DialogCustomizer.show("Employee Number Not Found!");
      textField1.setText(""); 
      } 
      }	

 catch (IOException ex){
       DialogCustomizer.show("Please Enter Employee Number!");// it should not Please Enter Employee Number! since what if there is error in backend so its temporary if have solution tyaka ko na gagawam :) 
       textField1.setText("");
       }
 
 });
 
 LogoutButton.addActionListener(e -> {
     
 	cardLayout.show(containerPanel, "Login_Screen");
 });


 return panel;
 
 	
 }
 
   
 }	


