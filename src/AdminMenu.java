import javax.swing.*;
import java.awt.*; 
import java.io.IOException;

 public class AdminMenu extends JPanel {

 private JButton button;
 private JButton button1;
 private JButton button2;
 private JTextArea textArea;
 private JTextField textField;
 private JScrollPane scrollPane;
 private JComboBox<Month> monthBox; 

 public AdminMenu(CardLayout cardLayout, JPanel containerPanel) {
  
  this.setBackground(Color.black);
  this.setLayout(new GridBagLayout());

  addComponents();
  listener(cardLayout, containerPanel);
  

  }
   
 private JPanel subPanel1 (){
 
 	JPanel panel = new JPanel( new GridBagLayout());
 	panel.setBackground(Color.white);
 	GridBagConstraints gbc = new GridBagConstraints();
 	gbc.insets = new Insets(10, 10, 5, 10);

    button = new JButton("All Employee");
    button.setPreferredSize(new Dimension(100, 30));
    button.setFocusable(false);
    button.setBackground(Color.gray);
    button.setFont(new Font("Comic Sans",Font.BOLD,15));
    
    button1 = new JButton("Logout");
    button1.setPreferredSize(new Dimension(100, 30));
    button1.setFocusable(false);
    button1.setBackground(Color.gray);
    button1.setFont(new Font("Comic Sans",Font.BOLD,15));
    
 	gbc.weighty = 0.0;
 	gbc.anchor = GridBagConstraints.NORTH;

    gbc.gridx = 0; gbc.gridy = 0;
 	panel.add(button, gbc);

    gbc.insets =  new Insets(5, 10, 10, 10); 
    gbc.gridx = 0; gbc.gridy = 1;
 	panel.add(button1, gbc);

    gbc.weighty = 1.0; 
    gbc.gridx = 0; gbc.gridy = 2;

    panel.add(Box.createVerticalGlue(), gbc); 
   

    return panel;
 	
    }
    
 private JPanel subPanel2 (){

 	JPanel panel = new JPanel(new GridBagLayout());
 	panel.setBackground(Color.white);
 	
    JLabel label = new JLabel("Please Enter Employee No. :");
    label.setFont(new Font("Comic Sans",Font.BOLD,15));
     
    textField = new JTextField();
    textField.setPreferredSize(new Dimension(200, 30));
    textField.setFont(new Font("Comic Sans",Font.BOLD,15));
    
    button2 = new JButton("Enter");
    button2.setPreferredSize(new Dimension(100, 30));
    button2.setFocusable(false);
    button2.setBackground(Color.white);
    button2.setFont(new Font("Comic Sans",Font.BOLD,15));
        
    monthBox = new JComboBox<>(new Month[] {
  
    new Month("June", 6),
    new Month("July", 7),
    new Month("August", 8),
    new Month("September", 9),
    new Month("October", 10),
    new Month("November", 11),
    new Month("December", 12) }); 
 	
 	GridBagConstraints gbc = new GridBagConstraints();
 	gbc.insets = new Insets(10, 10, 10, 10);
 	
 	gbc.weightx = 0.0; 
 	gbc.anchor = GridBagConstraints.WEST;

    gbc.gridx = 0; gbc.gridy = 0;
    panel.add(label, gbc);

    gbc.gridx = 1; gbc.gridy = 0;
    panel.add(monthBox, gbc);
     
    gbc.gridx = 2; gbc.gridy = 0;   
    panel.add(textField, gbc); 
    
    gbc.gridx = 3; gbc.gridy = 0;   
    panel.add(button2, gbc); 
        
    gbc.weightx = 1.0;
    gbc.gridx = 4; gbc.gridy = 0;
  
    panel.add(Box.createHorizontalGlue(), gbc); 

    return panel;
       	
    } 

 private JPanel subPanel3() {

    JPanel panel = new JPanel( new GridBagLayout());
    panel.setBackground(Color.white);
    GridBagConstraints gbc = new GridBagConstraints();

    textArea = new JTextArea(10, 18);
    textArea.setEditable(false);
    textArea.setFont(new Font("Comic Sans",Font.BOLD,20));
    
    scrollPane = new JScrollPane(textArea);
    
    gbc = new GridBagConstraints();
    gbc.insets =  new Insets(10, 5, 10, 5);
      
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridx = 0; gbc.gridy = 0; 
    gbc.weightx = 1.0; gbc.weighty = 1.0; 
    gbc.gridheight= 1;
    panel.add(scrollPane, gbc);

    return panel; 	
 } 
 
 private void addComponents() {

    GridBagConstraints gbc = new GridBagConstraints();
    gbc = new GridBagConstraints();
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
  button2.addActionListener(e -> {   
   
   String input = textField.getText();

   Month selectedMonth = (Month) monthBox.getSelectedItem();
   
    try { 
    
       
      Employee result = ProcessPayroll.employeeDetails(input);
      Admin result2 = ProcessPayroll.admin(input, selectedMonth.getValue());

       if(input == null || input.trim().isEmpty() ) {
       DialogCustomizer.show("Please Enter Employee Number!");    
       return;
       } 

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
                           "=============================\n" +
                           "Total Salary: " + result2.getnetSalary()
                           );
                           
       	
       }
       else {
       DialogCustomizer.show("Employee Number Not Found!");
       textField.setText("");
       }
       }
       
    catch (IOException ex){
       DialogCustomizer.show("Something went wrong! ");	   
       textField.setText("");
       }
   	
   });

   button.addActionListener(e -> {
   
   //cardLayout2.show(containerPanel2, "All employee");
    	
   });
      
   button1.addActionListener(e -> {
   cardLayout.show(containerPanel, "Login_Screen");
   textField.setText("");
   textArea.setText("");
    
  });
  
 
 	
 }
    
 
 	
 }

