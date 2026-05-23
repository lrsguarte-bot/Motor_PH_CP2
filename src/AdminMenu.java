import javax.swing.*;
import java.awt.*; 
import java.io.IOException;

 public class AdminMenu {

 
 public static JPanel adminInterface(CardLayout cardLayout, JPanel containerPanel) {
 
  JPanel panel = new JPanel(); 
  
  panel.setBackground(Color.gray);
  panel.setLayout(new GridBagLayout());
  GridBagConstraints gbc = new  GridBagConstraints();
  gbc.insets = new Insets(10, 10, 10, 10); 

  JTextField textField1 = new JTextField();
  textField1.setPreferredSize(new Dimension(200, 50));
  textField1.setFont(new Font("Comic Sans",Font.BOLD,15));

  JButton button = new JButton("Enter");
  button.setPreferredSize(new Dimension(150, 50));
  button.setFocusable(false);
  button.setBackground(Color.white);
  button.setFont(new Font("Comic Sans",Font.BOLD,15));
  
  JButton button2 = new JButton("Logout");
  button2.setPreferredSize(new Dimension(150, 50));
  button2.setFocusable(false);
  button2.setBackground(Color.white);
  button2.setFont(new Font("Comic Sans",Font.BOLD,15));

  JLabel label = new JLabel("Please Enter Employee No. :");
  label.setFont(new Font("Comic Sans",Font.BOLD,15));
  
  JTextArea textArea = new JTextArea(10, 18);
  textArea.setEditable(false);
  textArea.setFont(new Font("Comic Sans",Font.BOLD,20));
  
  JScrollPane scrollPane = new JScrollPane(textArea);
    
  JComboBox<Month> monthBox = new JComboBox<>(new Month[] {
  
   new Month("June", 6),
   new Month("July", 7),
   new Month("August", 8),
   new Month("September", 9),
   new Month("October", 10),
   new Month("November", 11),
   new Month("December", 12) }); 

   gbc.gridx = 0; gbc.gridy = 0;
   panel.add(label, gbc);

   gbc.gridx = 1; gbc.gridy = 0;
   panel.add(textField1, gbc);
 
   gbc.gridx = 1; gbc.gridy = 2;
   panel.add(button, gbc);
   
   gbc.gridx = 1; gbc.gridy = 3;
   panel.add(button2, gbc);

   gbc.gridx = 2; gbc.gridy = 0; 
   panel.add(monthBox, gbc);

   gbc.weightx = 1.0;
   gbc.weighty = 1.0;
   
   gbc.gridx = 3; 
   gbc.gridy = 0;
   gbc.gridheight = 8; 
   gbc.fill = GridBagConstraints.BOTH;
   panel.add(scrollPane, gbc);

   button.addActionListener(e -> {   
   
   String input = textField1.getText();

   Month selectedMonth = (Month) monthBox.getSelectedItem();
   
    try { 
    
       
      Employee result = ProcessPayroll.employeeDetails(input);
      Admin result2 = ProcessPayroll.admin(input, selectedMonth.getValue());

      // if(input == null || input.trim().isEmpty() ) {
       //  DialogCustomizer.show("Please Enter Employee Number!");    catch will also executed
     // } 

       if (result !=null && result2 !=null ) { 
       
         textArea.setText("Salary Report\n============================\n" +
                           "Employee ID: " + result.getid() + "\n"+
                           "First Name: "  + result.getFname() + "\n" +
                           "Last Name: "   + result.getLname() + "\n" +
                           "Birth Date: "  + result.getBday() + "\n" +                           
                           "First CutOFF: " + result2.getcutOff() + "\n" +                          
                           "Total Hours: " + result2.gettotalHours() + "\n" +
                           "Gross Salary: " + result2.getgrossSalary() + "\n" +
                           "Net Salary: " + result2.getnetSalary() + "\n" +                           
                           "Second CutOFF:  " + result2.getcutOff2() + "\n" +
                           "Total Hours: " + result2.gettotalHours2() + "\n" +
                           "Gross Salary: " + result2.getgrossSalary2() + "\n" +
                           "SSS Deduction: " + result2.getSSS() + "\n" +
                           "PhilHealth Deduction: " + result2.getphilHealth() + "\n" +
                           "PagIbig Deduction: " + result2.getpagIbig() + "\n" +
                           "Tax Deduction: " + result2.gettax() + "\n" + 
                           "================================================\n" +
                           "Total Salary: " + result2.getnetSalary()
                           );
                           textField1.setText("");
       	
       }
       else {
       DialogCustomizer.show("Employee Number Not Found!");
       textField1.setText("");
       }
       }
       
    catch (IOException ex){
       DialogCustomizer.show("Please Enter Employee Number!");	 // it should not Please Enter Employee Number! since what if there is error in backend so its temporary if have solution tyaka ko na gagawam :) 
       textField1.setText("");
       }
   	
   });
      
   button2.addActionListener(e -> {
   cardLayout.show(containerPanel, "Login_Screen");
  });
 
  
  return panel;
 }
 
 
 	
 }

