import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class AddProduct extends javax.swing.JFrame {

	public AddProduct() {
		this.setSize(400, 300);
		this.setBackground(new Color(98, 207, 209));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("New Product");
		initComponents();
		this.setVisible(true);

	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		plabel = new javax.swing.JLabel();
		qlabel = new javax.swing.JLabel();
		blabel = new javax.swing.JLabel();
		price = new javax.swing.JTextField();
		quantity = new javax.swing.JTextField();
		code = new javax.swing.JTextField();
		add = new javax.swing.JButton();
		reset = new javax.swing.JButton();

		setBackground(new java.awt.Color(221, 210, 100));
		setIconImages(null);
		setPreferredSize(new java.awt.Dimension(400, 300));

		jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("ADD NEW PRODUCT");

		plabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		plabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		plabel.setText("PRICE");

		qlabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		qlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		qlabel.setText("QUANTITY");

		blabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		blabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		blabel.setText("BAR CODE");

		price.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				priceActionPerformed(evt);
			}
		});

		code.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				codeActionPerformed(evt);
			}
		});
		quantity.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				quantityActionPerformed(evt);
			}
		});

		add.setBackground(new java.awt.Color(188, 204, 215));
		add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		add.setForeground(new java.awt.Color(52, 175, 171));
		add.setText("ADD");
		add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addActionPerformed(evt);
			}
		});

		reset.setBackground(new java.awt.Color(188, 204, 215));
		reset.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		reset.setForeground(new java.awt.Color(52, 175, 171));
		reset.setText("RESET");
		reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resetActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(126, 126, 126))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup().addGap(46, 46, 46)
										.addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(
												reset, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(blabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(qlabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(plabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34,
												Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(price, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 195,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(quantity, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 195,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(code, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 195,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(59, 59, 59)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(18, 18, 18)
				.addComponent(
						jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(plabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(qlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(blabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(55, Short.MAX_VALUE)));

		pack();
	}

	private void priceActionPerformed(java.awt.event.ActionEvent evt) {
		price.setBackground(new Color(98, 207, 209));
	}

	private void codeActionPerformed(java.awt.event.ActionEvent evt) {
		code.setBackground(new Color(98, 207, 209));
	}

	private void quantityActionPerformed(java.awt.event.ActionEvent evt) {
		quantity.setBackground(new Color(98, 207, 209));
	}

	private void resetActionPerformed(java.awt.event.ActionEvent evt) {
		code.setText("");
		quantity.setText("");
		price.setText("");
	}

	private void addActionPerformed(java.awt.event.ActionEvent evt) {
		int p = Integer.parseInt(price.getText());
		int q = Integer.parseInt(quantity.getText());
		if (presentindb(code.getText())) {
			JOptionPane.showMessageDialog(null, "Product already exists in the DataBase!!", "Warning!!!",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://root@localhost:3306/shop?useSSL=false&allowPublicKeyRetrieval=true", "root",
						"HelloUniverse2005");
				Statement stm = con.createStatement();
				String query = "INSERT INTO products VALUES('" + code.getText() + "'," + q + "," + p + ")";
				boolean shin = stm.execute(query);
				shin = presentindb(code.getText());
				if (!shin) {
					JOptionPane.showMessageDialog(null, "Failed to do it!!", "Warning!!!", JOptionPane.PLAIN_MESSAGE);
					resetActionPerformed(evt);
				} else {
					JOptionPane.showMessageDialog(null, "Successfully added to the DataBase!!", "Alert!!!",
							JOptionPane.PLAIN_MESSAGE);
					this.dispose();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public boolean presentindb(String barcode) {
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

	private javax.swing.JButton add;
	private javax.swing.JLabel blabel;
	private javax.swing.JTextField code;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel plabel;
	private javax.swing.JTextField price;
	private javax.swing.JLabel qlabel;
	private javax.swing.JTextField quantity;
	private javax.swing.JButton reset;
}
