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

public class Signup implements ActionListener {
	JFrame frame = new JFrame();
	JButton rst = new JButton("Reset");
	JButton signup = new JButton("Signup");
	JPasswordField password = new JPasswordField("");
	JPasswordField password1 = new JPasswordField("");
	JTextField username = new JTextField("");
	JTextField username1 = new JTextField("");
	JLabel flabel = new JLabel();
	JLabel ulabel = new JLabel();
	JLabel plabel = new JLabel();
	JLabel ulabel1 = new JLabel();
	JLabel plabel1 = new JLabel();
	ImageIcon image = new ImageIcon("signup.png");
	JLabel back = new JLabel(image);

	Signup() {
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		back.setBounds(0, 0, 700, 500);
		frame.setLayout(null);
		frame.setTitle("SIGNUP PAGE");
		addcomp();
		addActionEvent();
		frame.add(back);
	}

	private void addcomp() {
		flabel.setFont(new Font("Arial", 1, 18));
		flabel.setHorizontalAlignment(SwingConstants.CENTER);
		flabel.setVerticalAlignment(SwingConstants.TOP);
		flabel.setText("Signup / Бүртгэх");
		flabel.setBounds(250, 30, 200, 50);
		flabel.setForeground(new Color(255, 255, 255));
		frame.add(flabel);
		ulabel.setFont(new Font("Arial", 1, 16)); // NOI18N
		ulabel.setHorizontalAlignment(SwingConstants.LEADING);
		ulabel.setText("Username");
		ulabel.setBounds(80, 100, 100, 50);
		ulabel.setForeground(new Color(255, 255, 255));
		frame.add(ulabel);
		ulabel1.setFont(new Font("Arial", 1, 16)); // NOI18N
		ulabel1.setHorizontalAlignment(SwingConstants.LEADING);
		ulabel1.setText("Retype Username");
		ulabel1.setBounds(80, 170, 150, 50);
		ulabel1.setForeground(new Color(255, 255, 255));
		frame.add(ulabel1);
		plabel.setFont(new Font("Arial", 1, 16)); // NOI18N
		plabel.setHorizontalAlignment(SwingConstants.LEADING);
		plabel.setText("Password");
		plabel.setBounds(80, 240, 100, 50);
		plabel.setForeground(new Color(255, 255, 255));
		frame.add(plabel);
		plabel1.setFont(new Font("Arial", 1, 16)); // NOI18N
		plabel1.setHorizontalAlignment(SwingConstants.LEADING);
		plabel1.setText("Retype Password");
		plabel1.setBounds(80, 310, 150, 50);
		plabel1.setForeground(new Color(255, 255, 255));
		frame.add(plabel1);
		username.setBounds(260, 105, 300, 40);
		username.setBackground(new Color(242, 242, 242));
		username.setForeground(new Color(0, 0, 0));
		username.setEditable(true);
		username.setHorizontalAlignment(SwingConstants.LEADING);
		username.setFont(new Font("Arial", Font.BOLD, 14));
		username.setFocusable(true);
		frame.add(username);
		username1.setBounds(260, 175, 300, 40);
		username1.setBackground(new Color(242, 242, 242));
		username1.setForeground(new Color(0, 0, 0));
		username1.setEditable(true);
		username1.setHorizontalAlignment(SwingConstants.LEADING);
		username1.setFont(new Font("Arial", Font.BOLD, 14));
		username1.setFocusable(true);
		frame.add(username1);
		password.setBounds(260, 245, 300, 40);
		password.setBackground(new Color(242, 242, 242));
		password.setForeground(new Color(0, 0, 0));
		password.setEditable(true);
		password.setHorizontalAlignment(SwingConstants.LEADING);
		password.setFont(new Font("Arial", Font.BOLD, 14));
		password.setFocusable(true);
		frame.add(password);
		password1.setBounds(260, 315, 300, 40);
		password1.setBackground(new Color(242, 242, 242));
		password1.setForeground(new Color(0, 0, 0));
		password1.setEditable(true);
		password1.setHorizontalAlignment(SwingConstants.LEADING);
		password1.setFont(new Font("Arial", Font.BOLD, 14));
		password1.setFocusable(true);
		frame.add(password1);
		signup.setBounds(105, 245 + 150, 175, 35);
		MyDefaultMethodSetFont(signup, new Font("Arial", Font.BOLD, 17));
		signup.setBackground(new Color(53, 91, 192));
		frame.add(signup);
		rst.setBounds(380, 245 + 150, 175, 35);
		MyDefaultMethodSetFont(rst, new Font("Arial", Font.BOLD, 17));
		rst.setBackground(new Color(53, 91, 192));
		frame.add(rst);
	}

	public void addActionEvent() {
		rst.addActionListener(this);
		signup.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ans = e.getSource();
		if (ans == rst) {
			resetButtonPreformed();
		} else if (ans == signup) {
			signupButtonPreformed();
		}
	}

	public void resetButtonPreformed() {
		username.setText("");
		password.setText("");
		username1.setText("");
		password1.setText("");
	}

	@SuppressWarnings("deprecation")
	public void signupButtonPreformed() {
		if (!alreadyhaveit(username.getText())) {
			if (username.getText().equals(username1.getText()) && password.getText().equals(password1.getText())) {
				String usr = username.getText();
				String pass = password.getText();
				store(usr, pass);
			} else {
				JOptionPane.showMessageDialog(null, "Enter matching usernames and passwords", "Warning!!!",
						JOptionPane.PLAIN_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Something went wrong!!!", "Warning!!!", JOptionPane.PLAIN_MESSAGE);
			resetButtonPreformed();
		}
	}

	public void store(String usr, String pass) {
		if (presentindb(usr, pass)) {
			JOptionPane.showMessageDialog(null, "Account already exists!!", "Warning!!!", JOptionPane.PLAIN_MESSAGE);
		} else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
						"HelloUniverse2005");
				Statement stm = con.createStatement();
				String query = "INSERT INTO login_info VALUES(null,'" + usr + "','" + pass + "')";
				boolean shin = stm.execute(query);
				shin = presentindb(usr, pass);
				if (!shin) {
					JOptionPane.showMessageDialog(null, "Failed to do it!!", "Warning!!!", JOptionPane.PLAIN_MESSAGE);
					resetButtonPreformed();
				} else {
					new Login();
					frame.dispose();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void MyDefaultMethodSetFont(JButton button, Font font) {
		button.setFont(font);
	}

	@SuppressWarnings("deprecation")
	public boolean presentindb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"HelloUniverse2005");
			Statement stm = con.createStatement();
			String query = "SELECT * FROM login_info WHERE username='" + username.getText() + "' and password='"
					+ password.getText() + "'";
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean presentindb(String username, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root",
					"HelloUniverse2005");
			Statement stm = con.createStatement();
			String query = "SELECT * FROM login_info WHERE username='" + username + "' and password='" + password + "'";
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean alreadyhaveit(String username) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"HelloUniverse2005");
			Statement stm = con.createStatement();
			String query = "SELECT * FROM login_info WHERE username='" + username + "'";
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}