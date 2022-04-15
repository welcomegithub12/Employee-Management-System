package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login_user extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
    private JButton b1,b2,b3;
   

	public Login_user() {
		      
	setBackground(new Color(169, 169, 169));	
    setBounds(400, 170, 550, 380);
    
   
    panel = new JPanel();
	panel.setBackground(new Color(176, 224, 230));
	setContentPane(panel);
	panel.setLayout(null);
	
	JLabel l1 = new JLabel("Username : ");
	l1.setBounds(50,100,100,30);
	l1.setForeground(Color.white);
	l1.setFont(new Font("serif",Font.BOLD,18));
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(50,150,100,30);
	l2.setForeground(Color.white);
	l2.setFont(new Font("serif",Font.BOLD,18));
	panel.add(l2);

	
	
	textField = new JTextField();
	textField.setBounds(150,100,150,30);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(150,150,150,30);
	panel.add(passwordField);

	JLabel l3 = new JLabel("");
	l3.setBounds(377, 79, 46, 34);
	panel.add(l3);
	

	JLabel l4 = new JLabel("");
	l4.setBounds(377, 124, 46, 34);
	panel.add(l3);

	b1 = new JButton("Login");
	b1.addActionListener(this);
                
	b1.setForeground(Color.white);
	b1.setBackground(Color.black);
	b1.setBounds(40,200,120,30);
	panel.add(b1);
		
    b2 = new JButton("SignUp");
	b2.addActionListener(this);
	
	b2.setForeground(Color.green);
	b2.setBackground(Color.black);
	b2.setBounds(180,200,120,30);
	panel.add(b2);

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
	
    b3.setForeground(Color.red);
	b3.setBackground(Color.black);
	b3.setBounds(150,250,150,30);
	panel.add(b3);

	JLabel l5 = new JLabel("Trouble in Login?");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	l5.setForeground(Color.red);
	l5.setBounds(30,250,150,30);
	panel.add(l5);
	
	    JLabel l7 = new JLabel("LOGIN USER");
		l7.setBounds(80,30,200,50);
		l7.setForeground(Color.white); 
		l7.setFont(new Font("Tahoma",Font.BOLD,30));
		panel.add(l7);
	
	JLabel l6=new JLabel();
	l6.setBounds(0,0,550,350);
	l6.setLayout(null);
    ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/11.jpg"));
    l6.setIcon(img);
    panel.add(l6);
    
   
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(176, 224, 230));
		panel2.setBounds(24, 40, 250, 200);
		panel.add(panel2);
		
		
	}
        
        @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                //Boolean status = false;
		try {
                    conn con = new conn();
                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, textField.getText());
                    st.setString(2, passwordField.getText());

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                    	new details().f.setVisible(true);
                        this.setVisible(false);
                    } else
			JOptionPane.showMessageDialog(null, "Invalid Login...!.");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }   
            if(ae.getSource() == b3){
                setVisible(false);
		Forgot forgot = new Forgot();
		forgot.setVisible(true);
            }
        }
        
  	public static void main(String[] args) {
                new Login_user().setVisible(true);
	}

}