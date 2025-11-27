package bank.management.syste; // fixed typo in package name

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener{
    
    JButton login , signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        // Adding the ATM logo
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        // Adding the welcome text
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 500, 40); // Adjusted position to show clearly
        add(text);
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Releway", Font.BOLD, 38));
        cardno.setBounds(120, 150, 250, 40); // Adjusted position to show clearly
        add(cardno);
         cardTextField = new JTextField();
        cardTextField.setBounds(300,155,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Releway", Font.BOLD, 38));
        pin.setBounds(120, 220, 500, 40); // Adjusted position to show clearly
        add(pin);

         pinTextField = new JPasswordField ();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);// This line was missing
        
        login = new JButton("SIGH IN");
        login.setBounds(300,300,100,30);
        login.addActionListener(this);
        add(login);
        
         clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.addActionListener(this);
        add(signup);

        // Set background and frame properties
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 500);
        setLocation(350, 200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
          
        }else if (ae.getSource() == login){
            
        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
    }
    }

    public static void main(String[] args) {
        new Login();
    }
}
