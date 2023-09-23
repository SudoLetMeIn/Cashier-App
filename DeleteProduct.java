import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class DeleteProduct extends javax.swing.JFrame {

	public DeleteProduct() {
		this.setVisible(true);
		this.setSize(440, 204);
		initComponents();
		x = this.getWidth();
		y = this.getHeight();
	}

	private void initComponents() {

		tag = new javax.swing.JLabel();
		plabel = new javax.swing.JLabel();
		barcode = new javax.swing.JTextField();
		check = new javax.swing.JButton();
		reset = new javax.swing.JButton();
		del = new javax.swing.JButton();
		warning = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(new java.awt.Color(158, 238, 107));

		tag.setBackground(new java.awt.Color(51, 188, 144));
		tag.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		tag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		tag.setText("DELETE PRODUCTS");
		tag.setPreferredSize(new java.awt.Dimension(100, 20));

		plabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		plabel.setText("PRODUCT BARCODE");

		barcode.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		barcode.setOpaque(true);

		check.setBackground(new java.awt.Color(53, 91, 192));
		check.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		check.setText("CHECK");
		check.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkActionPerformed(evt);
			}
		});

		reset.setBackground(new java.awt.Color(53, 91, 192));
		reset.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		reset.setText("DISCARD");
		reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				discardPerformed(e);

			}
		});

		del.setBackground(new java.awt.Color(53, 91, 192));
		del.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		del.setText("DELETE");
		del.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				deleteProductPerformed(e);

			}
		});
		reset.setVisible(false);
		del.setVisible(false);

		warning.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
		warning.setText("														 ");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup()
										.addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, 142,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(125, 125, 125))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												layout.createSequentialGroup().addComponent(plabel)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(barcode))
										.addGroup(layout.createSequentialGroup()
												.addComponent(warning, javax.swing.GroupLayout.PREFERRED_SIZE, 284,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(check).addGap(0, 0, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup().addGap(27, 27, 27)
												.addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 142,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 142,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(27, 27, 27)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(plabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(warning, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(29, Short.MAX_VALUE)));

		pack();
	}

	private void checkActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"HelloUniverse2005");
			Statement stm = con.createStatement();
			String query = "SELECT * FROM products WHERE barcode='" + barcode.getText() + "'";
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Pruduct found!!!", "Alert!!!", JOptionPane.PLAIN_MESSAGE);
				reset.setVisible(true);
				del.setVisible(true);
				warning.setText("Once you delete the item. There is no way of coming back");
				this.setSize(440, 227);

			} else {
				JOptionPane.showMessageDialog(null, "Product not found!!!", "Warning!!!", JOptionPane.ERROR_MESSAGE);
				barcode.setText("");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void discardPerformed(java.awt.event.ActionEvent e) {
		barcode.setText("");
		reset.setVisible(false);
		del.setVisible(false);
		this.setSize(x, y);
	}

	private void deleteProductPerformed(java.awt.event.ActionEvent e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"HelloUniverse2005");
			Statement stm = con.createStatement();
			String query = "DELETE FROM products WHERE barcode='" + barcode.getText() + "'";
			stm.execute(query);
			boolean state = find(barcode.getText());
			if (state) {
				JOptionPane.showMessageDialog(null, "Pruduct successfully removed from DataBase!!!", "Alert!!!",
						JOptionPane.PLAIN_MESSAGE);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Something is wrong!!!", "Warning!!!", JOptionPane.ERROR_MESSAGE);
				barcode.setText("");
			}
		} catch (Exception evt) {
			System.out.println(evt.getMessage());
		}
	}

	public static boolean find(String barcode) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"HelloUniverse2005");
			Statement stm = con.createStatement();
			String query = "DELETE FROM products WHERE barcode='" + barcode + "'";
			boolean state = stm.execute(query);
			return state;
		} catch (Exception evt) {
			System.out.println(evt.getMessage());
		}
		return false;
	}

	private javax.swing.JButton check;
	private javax.swing.JButton reset;
	private javax.swing.JButton del;
	private javax.swing.JLabel tag;
	private javax.swing.JLabel plabel;
	private javax.swing.JLabel warning;
	private javax.swing.JTextField barcode;
	private int x, y;
}
