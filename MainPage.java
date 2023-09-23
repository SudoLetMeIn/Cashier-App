import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class MainPage implements ActionListener {
	String username;
	JFrame frame = new JFrame();
	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	JButton res = new JButton();
	int Dx = size.width, Dy = size.height;
	JMenuBar menu = new JMenuBar();
	JMenu add = new JMenu("New");
	JMenu edit = new JMenu("Edit");
	JMenu acc = new JMenu("Account");
	JMenuItem addProduct = new JMenuItem("New Product");
	JMenuItem editProduct = new JMenuItem("Edit Product");
	JMenuItem logout = new JMenuItem("Log Out");
	JMenuItem delacc = new JMenuItem("Delete Account");
	JMenuItem passreset = new JMenuItem("Change Password");
	JMenuItem delproduct = new JMenuItem("Delete Product");

	public MainPage(String username) {
		this.username = username;
		frame.setSize(Dx, Dy);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setBackground(new Color(242, 242, 242));
		frame.setLayout(null);
		frame.setTitle("MAIN PAGE");
		addcomp();
		frame.setVisible(true);
		addaction();
	}

	public void addcomp() {
		add.add(addProduct);
		edit.add(editProduct);
		edit.add(delproduct);
		acc.add(logout);
		acc.add(passreset);
		acc.add(delacc);
		menu.add(add);
		menu.add(edit);
		menu.add(acc);
		frame.setJMenuBar(menu);

	}

	public void addaction() {
		addProduct.addActionListener(this);
		delproduct.addActionListener(this);
		editProduct.addActionListener(this);
		logout.addActionListener(this);
		delacc.addActionListener(this);
		passreset.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == addProduct) {
			addProductPreformed();
		} else if (source == editProduct) {
			editProductPreformed();
		} else if (source == logout) {
			logoutPreformed();
			System.out.println("logout");
		} else if (source == delacc) {
			accountdeletionPreformed();
		} else if (source == passreset) {
			passwordreset();
		} else if (source == delproduct) {
			deleteproduct();
		}
	}

	public void addProductPreformed() {
		new AddProduct();
	}

	public void editProductPreformed() {
		new EditProduct();
	}

	public void logoutPreformed() {
		frame.dispose();
		new Login();
	}

	public void passwordreset() {
		new PassReset(username);
	}

	public void deleteproduct() {
		new DeleteProduct();
	}

	public void accountdeletionPreformed() {

		int a = JOptionPane.showConfirmDialog(null, "ARE YOU SURE??", "ALERT!!", JOptionPane.WARNING_MESSAGE, 1);
		if (a == 0)
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
						"HelloUniverse2005");
				Statement stm = con.createStatement();
				String query = "DELETE FROM login_info WHERE username='" + username + "'";
				boolean shin = stm.execute(query);
				shin = alreadyhaveit(username);
				if (!shin) {
					frame.dispose();
					JOptionPane.showMessageDialog(null, "Your account has been successfully deleted from the DataBase",
							"Alert!!!", JOptionPane.PLAIN_MESSAGE);
					new Login();
				} else {
					JOptionPane.showMessageDialog(null, "Failed to do it!!", "Warning!!!", JOptionPane.PLAIN_MESSAGE);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

	public boolean alreadyhaveit(String username) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root",
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
