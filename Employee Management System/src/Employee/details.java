package Employee;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.*;

class details  implements ActionListener{

    JFrame f;
    JLabel l1,l2,l3;
    JButton b1,b2,b3,b4,b5,b6;

    details(){
    	
        f=new JFrame("Employee Detail");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,1000,650);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/details.jpg"));
        l1.setIcon(i1);
        f.add(l1);

        l2 = new JLabel("Employee Information ");
        l2.setBounds(40,30,500,40);
        l2.setFont(new Font("Tahoma",Font.BOLD,30));
        l2.setForeground(Color.yellow);
        l1.add(l2);
        
        l3 = new JLabel("Details..");
        l3.setBounds(230,80,200,40);
        l3.setFont(new Font("Tahoma",Font.BOLD,30));
        l3.setForeground(Color.yellow);
        l1.add(l3);

        b1=new JButton("Add");
        b1.setBounds(50,170,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);


        b2=new JButton("View");
        b2.setBounds(200,170,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Remove");
        b3.setBounds(50,250,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("Update");
        b4.setBounds(200,250,100,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);
        
        b5=new JButton("Logout");
    	b5.setForeground(Color.white);
    	b5.setBackground(Color.black);
        b5.setBounds(50,320,100,40);
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.addActionListener(this);
        l1.add(b5);
        
        b6=new JButton("Exit");
    	b6.setForeground(Color.white);
    	b6.setBackground(Color.black);
        b6.setBounds(200,320,100,40);
        b6.setFont(new Font("serif",Font.BOLD,15));
        b6.addActionListener(this);
        l1.add(b6);
      
        f.setVisible(true);
        f.setSize(1000,650);
        f.setLocation(250,50);

    }

    public void actionPerformed(ActionEvent ae){
    	
        if(ae.getSource()==b1){
            f.setVisible(false);
            new Add_Employee();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new View_Employee();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new Remove_Employee();
        }
        if(ae.getSource()==b4){
            f.setVisible(false);
            new Search_Employee();
        }
        if(ae.getSource()==b5){
            f.setVisible(false);
            new Login_user().setVisible(true);
        }
        if(ae.getSource()==b6){
            f.setVisible(true);
            JFrame frame = new JFrame("Exit");
            while (JOptionPane.showConfirmDialog(frame,"Confirm if you want Exit Application", "Exit",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION )
        {
        	System.exit(0);
        }
       }
    }

    public static void main(String[ ] arg){
       new details();
       
    }
}