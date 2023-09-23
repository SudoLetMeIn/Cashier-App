import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class PassReset extends javax.swing.JFrame {
	public PassReset(String username) {
		this.setVisible(true);
		this.username = username;
		initComponents();
	}

	private void initComponents() {

		tag = new javax.swing.JLabel();
		enterpasslabel = new javax.swing.JLabel();
		oldpass = new javax.swing.JPasswordField();
		newpasslabel = new javax.swing.JLabel();
		newpass = new javax.swing.JPasswordField();
		retypepass = new javax.swing.JPasswordField();
		newpass1label = new javax.swing.JLabel();
		submit = new javax.swing.JButton();
		rst = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(new java.awt.Color(242, 154, 21));

		tag.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		tag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		tag.setText("CHANGE PASSWORD");

		enterpasslabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		enterpasslabel.setText("ENTER YOUR OLD PASSWORD");

		oldpass.setText("");

		newpasslabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		newpasslabel.setText("ENTER YOUR NEW PASSWORD");

		newpass.setText("");

		retypepass.setText("");

		newpass1label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		newpass1label.setText("RETYPE YOUR NEW PASSWORD");

		submit.setBackground(new java.awt.Color(169, 121, 224));
		submit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		submit.setText("SUBMIT");

		rst.setBackground(new java.awt.Color(169, 121, 224));
		rst.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		rst.setText("CLEAR");
		submit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitPerformed(evt);
			}
		});
		rst.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resetPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(newpass1label, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(newpasslabel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(enterpasslabel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(oldpass).addComponent(newpass).addComponent(retypepass,
												javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
								.addGap(16, 16, 16))
						.addGroup(layout.createSequentialGroup().addGap(125, 125, 125)
								.addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addGap(43, 43, 43)
								.addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rst, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(49, 49, 49)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(30, 30, 30)
				.addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(6, 6, 6)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(enterpasslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(oldpass, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(6, 6, 6)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(newpasslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(newpass, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(6, 6, 6)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(newpass1label, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(retypepass, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(rst, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(30, Short.MAX_VALUE)));

		pack();
	}

	@SuppressWarnings("deprecation")
	public void submitPerformed(java.awt.event.ActionEvent evt) {
		if (checkoldpass()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
						"HelloUniverse2005");
				Statement stm = con.createStatement();
				String query = "UPDATE login_info SET password='" + newpass.getText() + "' WHERE username='" + username
						+ "'";
				boolean rs = stm.execute(query);
				rs = check();
				if (rs) {
					JOptionPane.showMessageDialog(null, "Your password has been changed successfully!!!", "Alert!!!",
							JOptionPane.PLAIN_MESSAGE);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Something went wrong!!!", "Warning!!!",
							JOptionPane.PLAIN_MESSAGE);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "You entered wrong password", "Warning!!!", JOptionPane.PLAIN_MESSAGE);
			resetPerformed(evt);
		}
	}

	@SuppressWarnings("deprecation")
	public boolean checkoldpass() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"HelloUniverse2005");
			Statement stm = con.createStatement();
			String query = "SELECT * FROM login_info WHERE username='" + username + "' and password='"
					+ oldpass.getText() + "'";
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				return true;

			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void resetPerformed(java.awt.event.ActionEvent e) {
		oldpass.setText("");
		newpass.setText("");
		retypepass.setText("");
	}

	public boolean check() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"HelloUniverse2005");
			Statement stm = con.createStatement();
			@SuppressWarnings("deprecation")
			String query = "SELECT * FROM login_info WHERE username='" + username + "' and password='"
					+ newpass.getText() + "'";
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				return true;

			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return (boolean) false;
	}

	private javax.swing.JLabel enterpasslabel;
	private javax.swing.JPasswordField newpass;
	private javax.swing.JLabel newpass1label;
	private javax.swing.JLabel newpasslabel;
	private javax.swing.JPasswordField oldpass;
	private javax.swing.JPasswordField retypepass;
	private javax.swing.JButton rst;
	private javax.swing.JButton submit;
	private javax.swing.JLabel tag;
	private String username;
}
