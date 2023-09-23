import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Login implements ActionListener {
	JFrame frame = new JFrame();
	JButton rst = new JButton("Reset");
	JButton login = new JButton("Login");
	JPasswordField password = new JPasswordField("");
	JTextField username = new JTextField("");
	JLabel flabel = new JLabel();
	JLabel ulabel = new JLabel();
	JLabel plabel = new JLabel();
	ImageIcon image = new ImageIcon("login.png");
	JLabel back = new JLabel(image);

	Login() {
		frame.setSize(700, 400);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setTitle("LOGIN PAGE");
		addcomp();
		addActionEvent();
		back.setBounds(0, 0, 700, 400);
		frame.add(back);
	}

	private void addcomp() {
		flabel.setFont(new Font("Arial", 1, 18));
		flabel.setHorizontalAlignment(SwingConstants.CENTER);
		flabel.setVerticalAlignment(SwingConstants.TOP);
		flabel.setForeground(new Color(0, 0, 0));
		flabel.setText("Login / Нэвтрэх");
		flabel.setBounds(250, 30, 200, 50);
		frame.add(flabel);
		ulabel.setFont(new Font("Arial", 1, 16));
		ulabel.setHorizontalAlignment(SwingConstants.CENTER);
		ulabel.setForeground(new Color(0, 0, 0));
		ulabel.setText("Username");
		ulabel.setBounds(80, 100, 100, 50);
		frame.add(ulabel);
		plabel.setFont(new Font("Arial", 1, 16));
		plabel.setHorizontalAlignment(SwingConstants.CENTER);
		plabel.setText("Password");
		plabel.setForeground(new Color(0, 0, 0));
		plabel.setBounds(80, 170, 100, 50);
		frame.add(plabel);
		username.setBounds(260, 105, 300, 40);
		username.setBackground(new Color(242, 242, 242));
		username.setForeground(new Color(0, 0, 0));
		username.setEditable(true);
		username.setHorizontalAlignment(SwingConstants.LEADING);
		username.setFont(new Font("Arial", Font.BOLD, 14));
		username.setFocusable(true);
		frame.add(username);
		password.setBounds(260, 175, 300, 40);
		password.setBackground(new Color(242, 242, 242));
		password.setForeground(new Color(0, 0, 0));
		password.setEditable(true);
		password.setHorizontalAlignment(SwingConstants.LEADING);
		password.setFont(new Font("Arial", Font.BOLD, 14));
		password.setFocusable(true);
		frame.add(password);
		login.setBounds(105, 245, 175, 35);
		MyDefaultMethodSetFont(login, new Font("Arial", Font.BOLD, 17));
		login.setBackground(new Color(53, 91, 192));
		frame.add(login);
		rst.setBounds(380, 245, 175, 35);
		MyDefaultMethodSetFont(rst, new Font("Arial", Font.BOLD, 17));
		rst.setBackground(new Color(53, 91, 192));
		frame.add(rst);
	}

	public void addActionEvent() {
		rst.addActionListener(this);
		login.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ans = e.getSource();
		if (ans == rst) {
			resetButtonPreformed();
		} else if (ans == login) {
			loginButtonPreformed();
		}
	}

	public void resetButtonPreformed() {
		username.setText("");
		password.setText("");
	}

	public void loginButtonPreformed() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"HelloUniverse2005");
			Statement stm = con.createStatement();
			@SuppressWarnings("deprecation")
			String query = "SELECT * FROM login_info WHERE username='" + username.getText() + "' and password='"
					+ password.getText() + "'";
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				frame.dispose();
				new MainPage(username.getText());
			} else {
				JOptionPane.showMessageDialog(null, "Username or Password is wrong!!!", "Warning!!!",
						JOptionPane.PLAIN_MESSAGE);
				resetButtonPreformed();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void MyDefaultMethodSetFont(JButton button, Font font) {
		button.setFont(font);
	}
}