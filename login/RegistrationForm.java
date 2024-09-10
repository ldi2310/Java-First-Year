package GiaoDien;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationForm extends JFrame {

    private JPanel contentPane;
    private JTextField textField_fullname;
    private JTextField textField_address;
    private JTextField textField_username;
    private JTextField textField_password1;
    private JTextField textField_password2;
    private static final String DB_URL =
            "jdbc:sqlserver://localhost:1433;" +
            "databaseName=login;" +
            "encrypt=true;trustServerCertificate=true";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123";
    private ButtonGroup btn_group;
    private String gender = "";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistrationForm frame = new RegistrationForm();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RegistrationForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 537, 491);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblFullname = new JLabel("Fullname");
        lblFullname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFullname.setBounds(46, 49, 136, 23);
        contentPane.add(lblFullname);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblGender.setBounds(46, 95, 136, 23);
        contentPane.add(lblGender);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAddress.setBounds(46, 146, 136, 23);
        contentPane.add(lblAddress);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsername.setBounds(46, 203, 136, 23);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBounds(46, 252, 136, 23);
        contentPane.add(lblPassword);

        JLabel lblRewritePassword = new JLabel("Rewrite password");
        lblRewritePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblRewritePassword.setBounds(46, 309, 136, 23);
        contentPane.add(lblRewritePassword);

        textField_fullname = new JTextField();
        textField_fullname.setBounds(192, 53, 275, 19);
        contentPane.add(textField_fullname);
        textField_fullname.setColumns(10);

        textField_address = new JTextField();
        textField_address.setColumns(10);
        textField_address.setBounds(192, 150, 275, 19);
        contentPane.add(textField_address);

        textField_username = new JTextField();
        textField_username.setColumns(10);
        textField_username.setBounds(192, 207, 275, 19);
        contentPane.add(textField_username);

        textField_password1 = new JTextField();
        textField_password1.setColumns(10);
        textField_password1.setBounds(192, 256, 275, 19);
        contentPane.add(textField_password1);

        textField_password2 = new JTextField();
        textField_password2.setColumns(10);
        textField_password2.setBounds(192, 313, 275, 19);
        contentPane.add(textField_password2);

        JButton btn_return = new JButton("Return");
        btn_return.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                if (e.getActionCommand().equals("Return")) {
                    // Create a new instance of the login class
                    login loginFrame = new login();
                    loginFrame.setLocationRelativeTo(null);
                    loginFrame.setVisible(true);
                }
            }
        });
        btn_return.setBounds(428, 10, 85, 23);
        contentPane.add(btn_return);

        btn_group = new ButtonGroup();
        JRadioButton btn_gender_male = new JRadioButton("Male");
        btn_gender_male.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (btn_gender_male.isSelected()) {
                    gender = "Male";
                }
            }
        });
        btn_gender_male.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_gender_male.setBounds(188, 96, 103, 21);
        btn_group.add(btn_gender_male);
        contentPane.add(btn_gender_male);

        JRadioButton btn_gender_female = new JRadioButton("Female");
        btn_gender_female.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_gender_female.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (btn_gender_female.isSelected()) {
                    gender = "Female";
                }
            }
        });
        btn_gender_female.setBounds(334, 96, 103, 21);
        btn_group.add(btn_gender_female);
        contentPane.add(btn_gender_female);

        JButton btn_register = new JButton("Register");
        btn_register.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Register")) {
                    if (textField_fullname.getText().equals("") || textField_address.getText().equals("") || textField_password1.getText().equals("") || textField_password2.getText().equals("") || textField_username.getText().equals("")) {
                        JOptionPane.showMessageDialog(btn_register, "No blank answer");
                    } else {
                        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                            String sql1 = "INSERT INTO users (fullname, gender, address) VALUES (?,?,?);";
                            String sql2 = "INSERT INTO accounts (username, password, role) VALUES (?,?,?);";

                            try (PreparedStatement pStatement1 = connection.prepareStatement(sql1);
                                 PreparedStatement pStatement2 = connection.prepareStatement(sql2)) {

                                pStatement1.setString(1, textField_fullname.getText());
                                pStatement1.setString(2, gender);
                                pStatement1.setString(3, textField_address.getText());

                                pStatement2.setString(1, textField_username.getText());
                                pStatement2.setString(2, textField_password1.getText());
                                pStatement2.setString(3, "User");

                                if (textField_password1.getText().equals(textField_password2.getText())) {
                                    pStatement1.executeUpdate();
                                    pStatement2.executeUpdate();
                                    JOptionPane.showMessageDialog(btn_register, "Registered successfully!");

                                    // Close the registration form
                                    dispose();

                                    // Open the login form
                                    login loginFrame = new login();
                                    loginFrame.setLocationRelativeTo(null);
                                    loginFrame.setVisible(true);
                                } else {
                                    JOptionPane.showMessageDialog(btn_register, "Password not match");
                                }
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        btn_register.setBounds(317, 355, 120, 23);
        contentPane.add(btn_register);
    }
}
