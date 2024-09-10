package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import java.util.Arrays;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
public class login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField EditPassword;
    private JCheckBox showPasswordCheckBox;
    private JPasswordField text_Pass;
	private JComboBox<String> comboBox;
    // Database connection details
    private static final String DB_URL = "jdbc:sqlserver://DESKTOP-UJM6TJ3\\SQLEXPRESS:1433;databaseName=login;encrypt=true;trustServerCertificate=true;";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123";
    private JTextField EditUsername;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private Button Login;
    private Button Reset;
    private JLabel RolePanel;
    private JButton RegisterButton;
    private JCheckBox checkPass;
	/**
	 * Launch the application.
	 */
	 public static void main(String[] args) throws ClassNotFoundException {
	    	
    	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 409);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(165, 42, 42));
		lblNewLabel.setBounds(46, 71, 120, 30);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
	
		
		
		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(165, 42, 42));
		lblNewLabel_1.setBounds(46, 124, 96, 33);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);
		
		EditPassword = new JPasswordField();
		EditPassword.setForeground(new Color(165, 42, 42));
		EditPassword.setBounds(145, 124, 204, 31);
		contentPane.add(EditPassword);
		
		
		
		//nút login
		Button Login = new Button("Login");
		Login.setForeground(new Color(165, 42, 42));
		Login.setBounds(46, 289, 120, 39);
		Login.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performLogin();
			}
		});
		contentPane.add(Login);
		
		
		
		
		
		
		
		
		Button Reset = new Button("Reset");
		Reset.setForeground(new Color(165, 42, 42));
		Reset.setBounds(267, 289, 120, 39);
		Reset.setFont(new Font("Bodoni MT", Font.PLAIN, 20));
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		            // Call a method to reset the input fields
		            resetFields();
		        }
		    });
		contentPane.add(Reset);
		
		EditUsername = new JTextField();
		EditUsername.setForeground(new Color(165, 42, 42));
		EditUsername.setBounds(145, 71, 204, 30);
		contentPane.add(EditUsername);
		EditUsername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome ");
		lblNewLabel_2.setBounds(194, 10, 161, 39);
		lblNewLabel_2.setFont(new Font("VNI-Avo", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_2);
		
		JLabel RolePanel = new JLabel("Role");
		RolePanel.setForeground(new Color(165, 42, 42));
		RolePanel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		RolePanel.setBounds(46, 174, 96, 30);
		contentPane.add(RolePanel);
	
		
		
		
		//Cômbobox
		
		comboBox = new JComboBox<>(new String[]{"Select", "Admin", "User"});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setForeground(new Color(165, 42, 42));
		comboBox.setBounds(145, 179, 204, 30);
		contentPane.add(comboBox);
		
		
		
		
		//nút đăng kí
		
		JButton RegisterButton = new JButton("Register");
        RegisterButton.setBackground(SystemColor.activeCaptionBorder);
        RegisterButton.setForeground(SystemColor.textHighlight);
        RegisterButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        RegisterButton.setBounds(324, 0, 131, 30);
        RegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 dispose();
            	 RegistrationForm RegistrationForm = new RegistrationForm();
            	 RegistrationForm.setLocationRelativeTo(null);
                RegistrationForm.setVisible(true);
            }
            
        });
        contentPane.add(RegisterButton);
		JCheckBox checkPass = new JCheckBox("Show password");
		checkPass.setBackground(SystemColor.activeCaption);
		checkPass.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == checkPass) {
		            if (checkPass.isSelected()) {
		                EditPassword.setEchoChar((char) 0); // Show the password
		            } else {
		                EditPassword.setEchoChar('●'); // Hide the password
		            }
		        }
		    }
		});
		checkPass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		checkPass.setBounds(145, 237, 182, 30);
		contentPane.add(checkPass);
		
		JComboBox languagebox = new JComboBox<>(new String[] {"English" ,"Tiếng Việt"} );
		languagebox.setBounds(10, 10, 96, 20);
		contentPane.add(languagebox);
		languagebox.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String selectedLanguage = languagebox.getSelectedItem().toString();
		        String localeCode = selectedLanguage.equalsIgnoreCase("English") ? "en" : "vi";
		        setLocale(localeCode);
		        updateGuiComponents();
		    }
		});
	}
private void resetFields() {
    EditUsername.setText(""); 
    EditPassword.setText(""); 
    comboBox.setSelectedItem("Select");
}                                         

private void performLogin() {
    String username = EditUsername.getText();
    String password = String.valueOf(EditPassword.getPassword());
    String option = comboBox.getSelectedItem().toString();

    if (username.equals("") || password.equals("") || option.equals("Select")) {
        JOptionPane.showMessageDialog(null, "Some Fields Are Empty", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;

        try {
            conn = JDBCUtil.connect();
            if (conn != null) {
                System.out.println("Connected to the database");
            String sql = "SELECT * FROM accounts WHERE username = ? AND password = ?";
            System.out.println("Executing SQL query: " + sql);
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                String role = resultSet.getString("role");
                System.out.println("Role from Database: " + role);

                if ((option.equalsIgnoreCase("Admin") && role.equalsIgnoreCase("Admin")) ||
                        (option.equalsIgnoreCase("User") && role.equalsIgnoreCase("User"))) {
                    JOptionPane.showMessageDialog(this, "Login Successfully");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "User Name or Password not Matched", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "User Name or Password not Matched", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
            }
            else {
                System.out.println("Failed to connect to the database");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
private void updateGuiComponents() {
	String welcomeMessageKey = "welcome.message";
	lblNewLabel_2.setText(LanguageManager.getMessage(welcomeMessageKey));
    String usernameLabelKey = "username.label";
    String passwordLabelKey = "password.label";
    String loginButtonKey = "login.button";
    String resetButtonKey = "reset.button";
    String roleLabelKey = "role.label";
    String[] comboBoxItems = new String[]{"select.option", "admin.option", "user.option"};
    String registerButtonKey = "register.button";
    String showPasswordCheckBoxKey = "show.password.checkbox";

    // Set localized text for each component
    lblNewLabel_2.setText(LanguageManager.getMessage(welcomeMessageKey));
    lblNewLabel.setText(LanguageManager.getMessage(usernameLabelKey));
    lblNewLabel_1.setText(LanguageManager.getMessage(passwordLabelKey));
    Login.setLabel(LanguageManager.getMessage(loginButtonKey));
    Reset.setLabel(LanguageManager.getMessage(resetButtonKey));
    RolePanel.setText(LanguageManager.getMessage(roleLabelKey));
    comboBox.setModel(new DefaultComboBoxModel<>(Arrays.stream(comboBoxItems)
            .map(LanguageManager::getMessage)
            .toArray(String[]::new)));
    RegisterButton.setText(LanguageManager.getMessage(registerButtonKey));
    checkPass.setText(LanguageManager.getMessage(showPasswordCheckBoxKey));
}
private void setLocale(String languageCode) {
    try {
        Locale locale = new Locale(languageCode);
        ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);
        LanguageManager.setMessages(messages);
    } catch (MissingResourceException e) {
        e.printStackTrace();
    }
}

}