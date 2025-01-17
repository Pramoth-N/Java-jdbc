package JDBC;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JPanel{
	private JTextField usernameField;
	private JPasswordField userPasswordField;
	
	public LoginPage(RegistrationApplication mainApp) {
		setLayout(new GridLayout(3,1,10,20));
		
		usernameField = new JTextField();
		userPasswordField = new JPasswordField();
		JButton loginButton = new JButton("Login");
		JButton registerButton = new JButton("Register");
		add(new JLabel("User Id"));
		add(usernameField);
		add(new JLabel("Password"));
		add(userPasswordField);
		add(loginButton);
		add(registerButton);
		loginButton.addActionListener(e->login(mainApp));
		registerButton.addActionListener(e->{
			mainApp.showCard("RegistrationPage");
		});
	}
	
	
	private void login(RegistrationApplication mainApp) {
		try(Connection connection = Database.getConnection()){
			String querry = "SELECT * FROM userdata WHERE user_name = ? AND password = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(querry);
			String username = usernameField.getText();
			String password = new String(userPasswordField.getPassword());
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet result = preparedStatement.executeQuery();
			if(result.next()) {
				mainApp.userId = result.getInt("id");
				JOptionPane.showMessageDialog(mainApp, "Success");
				mainApp.showCard("Cart");
			} else {
				JOptionPane.showMessageDialog(mainApp, "Invalid userName or Password");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
