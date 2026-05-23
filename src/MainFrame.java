import javax.swing.*;
import java.awt.*; 

public class MainFrame {

   private JFrame frame;
   private JPanel containerPanel;
   private CardLayout cardLayout;    

 

   public MainFrame(){
 
     frame = new JFrame();
     cardLayout = new CardLayout();
     containerPanel = new JPanel(cardLayout);

     JPanel loginScreen = loginPanel();
     JPanel employeeScreen = EmployeeMenu.employeeInterface(cardLayout, containerPanel);
     JPanel admin = AdminMenu.adminInterface(cardLayout, containerPanel);
                 
     containerPanel.add(loginScreen, "Login_Screen");
     containerPanel.add(employeeScreen,"Employee_Screen" );
     containerPanel.add(admin, "Admin_Screen");
              
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(1200, 800);
     frame.add(containerPanel);
     frame.setLocationRelativeTo(null);
     frame.setVisible(true);
              
     }
     
 public JPanel loginPanel () {
    
    JPanel panel = new JPanel();  
    
    panel.setBackground(Color.gray);
    panel.setLayout(new GridBagLayout());    
    GridBagConstraints gbc = new  GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10); 
    
    JButton button = new JButton("Login");
    button.setPreferredSize(new Dimension(150, 50));
    button.setFocusable(false);
    button.setBackground(Color.white);
    button.setFont(new Font("Comic Sans",Font.BOLD,15));
    
    JTextField textField1 = new JTextField();
    textField1.setPreferredSize(new Dimension(200, 50));
    textField1.setFont(new Font("Comic Sans",Font.BOLD,15));
    
    JPasswordField textField2 = new JPasswordField();
    textField2.setPreferredSize(new Dimension(200, 50));  
    textField2.setFont(new Font("Comic Sans",Font.BOLD,15));
         
    JLabel userLabel = new JLabel("Username");
    JLabel passLabel = new JLabel("Password");
       
    userLabel.setFont(new Font("Comic Sans",Font.BOLD,15));
    passLabel.setFont(new Font("Comic Sans",Font.BOLD,15));
              
    gbc.gridx = 0; gbc.gridy = 1;
    panel.add(userLabel, gbc);

    gbc.gridx = 1; gbc.gridy = 1;
    panel.add(textField1, gbc);

    gbc.gridx = 0; gbc.gridy = 2;
    panel.add(passLabel, gbc);

    gbc.gridx = 1; gbc.gridy = 2;
    panel.add(textField2, gbc);

    gbc.gridx = 1; gbc.gridy = 3;
    panel.add(button, gbc);
 
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
    	DialogCustomizer.show("Incorrect Password Please Try Again");
    	break;
        }
     
      	
    });
    
    return panel;
 }   
	
}
