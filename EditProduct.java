import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class EditProduct extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditProduct() {
		this.setSize(400, 300);
		this.setBackground(new Color(98, 207, 209));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("New Product");
		initComponents();
		this.setVisible(true);
	}

	private void initComponents() {

		tag = new javax.swing.JLabel();
		blabel = new javax.swing.JLabel();
		barcode = new javax.swing.JTextField();
		check = new javax.swing.JButton();
		blabel1 = new javax.swing.JLabel();
		blabel3 = new javax.swing.JLabel();
		price = new javax.swing.JTextField();
		quantity = new javax.swing.JTextField();
		clear = new javax.swing.JButton();
		submit = new javax.swing.JButton();

		tag.setFont(new java.awt.Font("Arial", 1, 14));
		tag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		tag.setText("EDIT PRODUCT");

		blabel.setFont(new java.awt.Font("Arial", 1, 14));
		blabel.setText("ENTER BARCODE");

		check.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				barcodeActionPerformed(evt);
			}
		});

		check.setBackground(new java.awt.Color(53, 182, 137));
		check.setFont(new java.awt.Font("Arial", 1, 14));
		check.setText("check");
		submit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitActionPerformed(evt);
			}
		});

		blabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		blabel1.setText("ENTER NEW PRICE");

		blabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		blabel3.setText("ENTER QUANTITY");

		clear.setBackground(new java.awt.Color(53, 182, 137));
		clear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		clear.setText("CLEAR");
		clear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearActionPerformed(evt);
			}
		});

		submit.setBackground(new java.awt.Color(53, 182, 137));
		submit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		submit.setText("SUBMIT");
		submit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitActionPerformed(evt);
			}
		});
		price.setEnabled(false);
		quantity.setEnabled(false);
		price.setBackground(new Color(192, 192, 192));
		quantity.setBackground(new Color(192, 192, 192));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout
								.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 106,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(64, 64, 64).addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 106,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(blabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(blabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(blabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(barcode).addComponent(price)
														.addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE,
																181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(check)
						.addGap(38, 38, 38)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(30, 30, 30)
				.addComponent(tag, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(blabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(check))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(blabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup().addComponent(price).addGap(0, 0, 0)))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(blabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(49, 49, 49)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(18, Short.MAX_VALUE)));

		pack();
	}

	private void barcodeActionPerformed(java.awt.event.ActionEvent evt) {
		action();
	}

	private void submitActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"HelloUniverse2005");
			Statement stm = con.createStatement();
			String query = "UPDATE products SET price = " + price.getText() + " , quantity = " + quantity.getText()
					+ " WHERE barcode = '" + barcode.getText() + "'";
			stm.execute(query);

			JOptionPane.showMessageDialog(null, "Successfully modified!!", "Alert!!!", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void clearActionPerformed(java.awt.event.ActionEvent evt) {
		barcode.setText("");
		price.setText("");
		quantity.setText("");
	}

	private javax.swing.JTextField barcode;
	private javax.swing.JLabel blabel;
	private javax.swing.JLabel blabel1;
	private javax.swing.JLabel blabel3;
	private javax.swing.JButton check;
	private javax.swing.JButton clear;
	private javax.swing.JButton submit;
	private javax.swing.JTextField price;
	private javax.swing.JTextField quantity;
	private javax.swing.JLabel tag;

	public boolean alreadyhaveit(String barcode) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
					"HelloUniverse2005");
			Statement stm = con.createStatement();
			String query = "SELECT * FROM products WHERE barcode='" + barcode + "'";
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void action() {
		if (alreadyhaveit(barcode.getText())) {
			price.setEnabled(true);
			quantity.setEnabled(true);
			price.setBackground(new Color(255, 255, 255));
			quantity.setBackground(new Color(255, 255, 255));
			JOptionPane.showMessageDialog(null, "Found!!!", "Alert!!!", JOptionPane.INFORMATION_MESSAGE);
		} else {
			barcode.setText("");
			JOptionPane.showMessageDialog(null, "Not found!!!", "Warning!!!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
