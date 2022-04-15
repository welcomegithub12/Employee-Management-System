package Employee;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
    @SuppressWarnings("rawtypes")
	private JComboBox comboBox;
   

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Signup() {
    	
        setBounds(350, 150, 520, 380);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
    contentPane.setBackground(Color.pink);
	contentPane.setLayout(null);

	JLabel lblUsername = new JLabel("Username :");
	lblUsername.setForeground(Color.black);
	lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblUsername.setBounds(99, 50, 92, 26);
	contentPane.add(lblUsername);

	JLabel lblName = new JLabel("Name :");
	lblName.setForeground(Color.black);
	lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblName.setBounds(99, 100, 92, 26);
	contentPane.add(lblName);

	JLabel lblPassword = new JLabel("Password :");
	lblPassword.setForeground(Color.black);
	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPassword.setBounds(99, 150, 92, 26);
	contentPane.add(lblPassword);

	JLabel lblAnswer = new JLabel("Answer :");
	lblAnswer.setForeground(Color.black);
	lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblAnswer.setBounds(99, 250, 92, 26);
	contentPane.add(lblAnswer);
	
	String[] colum = { "Your NickName?", "Your Lucky Number?",
		"Your child SuperHero?", "Your childhood Name ?" };
	comboBox = new JComboBox(colum);
	contentPane.add(comboBox);
	comboBox.setBounds(265, 202, 148, 20);

	JLabel lblSecurityQuestion = new JLabel("Security Question :");
	lblSecurityQuestion.setForeground(Color.black);
	lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblSecurityQuestion.setBounds(99, 200, 140, 26);
	contentPane.add(lblSecurityQuestion);

    textField = new JTextField();
	textField.setBounds(265, 50, 148, 20);
	contentPane.add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(265, 100, 148, 20);
	contentPane.add(textField_1);

    textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(265, 150, 148, 20);
	contentPane.add(textField_2);

	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(265, 250, 148, 20);
	contentPane.add(textField_3);

	b1 = new JButton("Create");
	b1.addActionListener(this);
	b1.setFont(new Font("Tahoma", Font.BOLD, 13));
	b1.setBounds(140, 296, 100, 30);
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 13));
	b2.setBounds(300, 296, 100, 30);
	b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	//JPanel panel = new JPanel();
	//panel.setForeground(new Color(34, 139, 34));
	//panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
			//TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	//panel.setBounds(10, 20, 476, 296);
    //panel.setBackground(Color.PINK);
	//contentPane.add(panel);
	
	
	JLabel l1=new JLabel();
	l1.setBounds(0,0,520,380);
	l1.setLayout(null);
    ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/sign.jpg"));
    l1.setIcon(img);
    contentPane.add(l1);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            
            if(ae.getSource() == b1){
                String sql = "insert into account(username, name, password, sec_q, sec_ans) values(?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
		st.setString(3, textField_2.getText());
		st.setString(4, (String) comboBox.getSelectedItem());
		st.setString(5, textField_3.getText());

		int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "successfully Created");
                }

                textField.setText("");
                textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Login_user().setVisible(true);
			
            }
        }catch(Exception e){
            
        }
    }
}