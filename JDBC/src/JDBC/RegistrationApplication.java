package JDBC;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RegistrationApplication extends JFrame{

//	private static final long serialVersionUID = 1L;
		private CardLayout cardLayout;
		private JPanel mainPanel;
		public int userId;
		public RegistrationApplication() {
			setTitle("Registration and  Login ");
			setSize(414,896);
			setResizable(false);
			
			cardLayout = new CardLayout();
			mainPanel = new JPanel();
			
			mainPanel.setLayout(cardLayout);
			mainPanel.add(new LoginPage(this),"LoginPage");
			mainPanel.add(new RegistrationPage(this),"RegistrationPage");
			mainPanel.add(new Cart(this),"Cart");
			add(mainPanel);
			cardLayout.show(mainPanel, "LoginPage");
		}
		public void showCard(String pageName) {
			cardLayout.show(mainPanel,pageName);
		}
		
		public static void main(String[] args) {
			SwingUtilities.invokeLater(()-> new RegistrationApplication().setVisible(true));
		}
}
