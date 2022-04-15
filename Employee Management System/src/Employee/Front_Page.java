package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class Front_Page implements ActionListener{
    JFrame f; 
    JLabel id,l1,l2,l3,l4;
    JButton b;

    Front_Page(){
 
        f=new JFrame("Employee Management System");
        f.setBackground(Color.red);
        f.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1400,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        
        l1.setBounds(0,0,1360,700);
        f.add(l1);


        b = new JButton("CLICK HERE TO CONTINUE");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        

        b.setBounds(180,400,300,70);
        b.addActionListener(this);

        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);
        
        l2 = new JLabel("EMPLOYEE");
        l2.setBounds(50,100,400,60);
        l2.setFont(new Font("Tahoma",Font.BOLD,70));
        l2.setForeground(Color.white);
        l1.add(l2);
        
        l3 = new JLabel("MANAGEMENT");
        l3.setBounds(100,200,600,60);
        l3.setFont(new Font("Tahoma",Font.BOLD,70));
        l3.setForeground(Color.white);
        l1.add(l3);
        
        l4 = new JLabel("SYSTEM");
        l4.setBounds(250,300,400,60);
        l4.setFont(new Font("Tahoma",Font.BOLD,70));
        l4.setForeground(Color.white);
        l1.add(l4);

 
        id.add(b);
        f.add(id);
        
        
        f.getContentPane().setBackground(Color.white);
        f.setVisible(true);
        f.setSize(1360,700);
        f.setLocation(0,0);

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            f.setVisible(false);
            new Login_user().setVisible(true);    
        }
    }

    public static void main(String[] arg){
           new Front_Page();
    }
}