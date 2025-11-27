package bank.management.syste;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTow extends JFrame implements ActionListener {

    JTextField aadharTextField;
    JButton next;
    JComboBox religionComboBox, category, occupation, education, income;
    String formno;

    SignupTow(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel religionLabel = new JLabel("Religion: ");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 140, 600, 30);
        add(religionLabel);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionComboBox = new JComboBox(valReligion);
        religionComboBox.setBounds(300, 140, 350, 28);
        add(religionComboBox);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100, 190, 200, 30);
        add(categoryLabel);

        String valCategory[] = {"General", "OBC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 350, 28);
        add(category);

        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 240, 350, 30);
        add(incomeLabel);

        String incomeCategory[] = {"null", "< 1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 350, 28);
        add(income);

        JLabel educationLabel = new JLabel("Educational:");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationLabel.setBounds(100, 290, 350, 30);
        add(educationLabel);

        JLabel qualificationLabel = new JLabel("Qualification:");
        qualificationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        qualificationLabel.setBounds(100, 315, 200, 30);
        add(qualificationLabel);

        String educationValues[] = {"Non Graduation", "Graduate", "Post Graduation", "Doctorate", "Other"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 300, 350, 28);
        add(education);

        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLabel.setBounds(100, 390, 200, 30);
        add(occupationLabel);

        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 350, 28);
        add(occupation);

        JLabel aadharLabel = new JLabel("Aadhar Number:");
        aadharLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharLabel.setBounds(100, 440, 200, 30);
        add(aadharLabel);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 440, 350, 28);
        add(aadharTextField);
        
        JLabel pan = new JLabel("PAN:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 490, 200, 30);
        add(pan);
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 350, 28);
        add(aadharTextField);

        // Optional placeholders for Senior Citizen and Existing Account
        // Add JComboBoxes or JRadioButtons here as needed.

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(435, 650, 80, 30);
        next.addActionListener(this);
        add(next);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religionComboBox.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String saadhar = aadharTextField.getText();

        try {
            conn c = new conn();
            String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + saadhar + "')";
            c.s.executeUpdate(query);
            // Navigate to next form page
            setVisible(false);
            new SignupTow(formno); // only if SignupThree exists
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignupTow("1234"); // Test with a dummy formno
    }
}
