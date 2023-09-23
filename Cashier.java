import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Cashier extends javax.swing.JFrame {
	Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
	ImageIcon back = new ImageIcon("PngItem_1771756.png");
	JLabel label = new JLabel(back);

	public Cashier() {
		this.setResizable(false);
		this.setTitle("HOME PAGE");
		label.setBounds(0, 0, 716, 389);
		initComponents();
		this.setIconImage(icon);
		this.setLayout(null);
		this.add(label);
	}

	private void initComponents() {
		this.setIconImage(icon);
		this.setLayout(null);
		jLabel1 = new javax.swing.JLabel();
		login = new javax.swing.JButton();
		signup = new javax.swing.JButton();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Дэлгүүр");
		login.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		login.setText("Login / Нэвтрэх");
		login.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginActionPerformed(evt);
			}
		});
		signup.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		signup.setText("Signup / Бүртгэх");
		signup.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				signupActionPerformed(evt);
			}
		});
		this.setIconImage(icon);
		this.setLayout(null);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(254, 254, 254)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(246, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(56, 56, 56)
				.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(35, 35, 35)
				.addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap(119, Short.MAX_VALUE)));
		jLabel1.getAccessibleContext().setAccessibleDescription("");
		login.setBackground(new Color(53, 91, 192));
		signup.setBackground(new Color(53, 91, 192));

		pack();
	}

	private void loginActionPerformed(java.awt.event.ActionEvent evt) {
		new Login();
	}

	private void signupActionPerformed(java.awt.event.ActionEvent evt) {
		new Signup();
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
				Cashier cash = new Cashier();
				cash.setVisible(true);
				cash.setIconImage(icon);
				cash.setLayout(null);
			}
		});
	}

	private javax.swing.JLabel jLabel1;
	private javax.swing.JButton login;
	private javax.swing.JButton signup;
}