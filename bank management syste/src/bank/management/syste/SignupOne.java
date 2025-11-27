
package bank.management.syste;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fnameTextField,maritalTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female;
     JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);
        Random ran = new Random();
         random = (Math.abs(ran.nextLong() %9000L ) + 1000L);
        JLabel formno = new JLabel("APPLICATION FROM NO. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
         JLabel personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
         JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,600,30);
        add(name);
        
         nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,350,28);
        add(nameTextField);
        
         JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
         fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,350,28);
        add(fnameTextField);
                
         JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,350,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,350,30);
        add(dateChooser);
        
         JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,350,30);
        add(gender);
        
         male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        add(male);
         female = new JRadioButton("Female");
        female.setBounds(450,290,70,30);
        add(female);
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
         JLabel email = new JLabel("email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
          maritalTextField = new JTextField();
        maritalTextField.setFont(new Font("Raleway",Font.BOLD,14));
        maritalTextField.setBounds(300,340,350,28);
        add(maritalTextField);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
         address.setBounds(100,390,200,30);
        add( address);
        
          addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,390,350,28);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city .setFont(new Font("Raleway",Font.BOLD,20));
         city.setBounds(100,440,200,30);
        add( city );
        
          cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,440,350,28);
        add(cityTextField);
        
        
        JLabel state = new JLabel("State:");
        state .setFont(new Font("Raleway",Font.BOLD,20));
         state.setBounds(100,490,200,30);
        add( state );
        
         stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,490,350,28);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode .setFont(new Font("Raleway",Font.BOLD,20));
         pincode.setBounds(100,540,200,30);
        add( pincode );
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,540,350,28);
        add(pinTextField);
        
         next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(435,650,80,30);
        next.addActionListener(this);
        add(next);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
         String formno = "" +random;
         String name = nameTextField.getText();
         String fname = fnameTextField.getText();
         String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
         String gender = null;
         if(male.isSelected()){
             gender = "Male";
         }else if(female.isSelected()){
             gender = "Female";
         }
         String email = maritalTextField.getText();
         String address = addressTextField.getText();
         String city = cityTextField.getText();
         String state = stateTextField.getText();
         String pin = pinTextField.getText();
         
         try{
             if(name.equals("")){
                 JOptionPane.showMessageDialog(null,"Name is Required" );
             }
             else if(fname.equals("")){
                 JOptionPane.showMessageDialog(null,"Father Name is Required" );
             }
             else if(dob.equals("")){
                 JOptionPane.showMessageDialog(null,"Dob is Required" );
             }
             else if(pin.equals("")){
                 JOptionPane.showMessageDialog(null,"Enter The PIN" );
             }
             else if(email.equals("")){
                 JOptionPane.showMessageDialog(null,"Email Name is Required" );
             }
             
             else if(address.equals("")){
                 JOptionPane.showMessageDialog(null,"Fill The Address" );
             }
             else if(city.equals("")){
                 JOptionPane.showMessageDialog(null,"Fill The City" );
             }
             
             else if(state.equals("")){
                 JOptionPane.showMessageDialog(null,"Fill The State" );
             }
             else{
                 conn c = new conn();
                 String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                 c.s.executeUpdate(query);
                 setVisible(false);
                 new SignupTow(formno).setVisible(true);
             }
             
         } catch (Exception e){
             System.out.println(e);
         }
         
     }
    
   
    public static void main(String args[]) {
        new SignupOne();
    }
}


