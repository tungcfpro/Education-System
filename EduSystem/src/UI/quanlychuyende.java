/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.ChuyenDeDAO;
import Helper.ShareHelper;
import Helper.DialogHelper;
import Model.ChuyenDe;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
//import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author Acer
 */
public class quanlychuyende extends javax.swing.JFrame {
	public String ErrorMes = "";

	/**
	 * Creates new form quanlychuyende
	 */
	public quanlychuyende() {
		initComponents();
		setLocationRelativeTo(null);
		setIconImage(ShareHelper.APP_ICON);
		setLocationRelativeTo(null);
		if (ShareHelper.USER != null) {
			this.load();
		} else {
			DialogHelper.alert(this, "Vui lòng đăng nhập");
			this.tabs.removeAll();
		}
	}

	boolean check() {
		if (txtMaCD.getText().length() == 0) {
			DialogHelper.alert(this, "Mã chuyên đề không được bỏ trống");
			ErrorMes = "Mã chuyên đề không được bỏ trống";
			return false;
		}
		if (txtMaCD.getText().length() > 5 || txtMaCD.getText().length() < 5) {
			DialogHelper.alert(this, "Mã chuyên đề phải nhập đúng 5 ký tự");
			ErrorMes = "Mã chuyên đề phải nhập đúng 5 ký tự";
			return false;
		}
		if (txtTenCD.getText().length() == 0) {
			DialogHelper.alert(this, "Tên chuyên đề không được bỏ trống");
			return false;
		}
//		if (lblHinh.getIcon() == null) {
//			DialogHelper.alert(this, "Bạn chưa chọn hình! click vào khu vực hình để chọn");
//			return false;
//		}
		if (txtThoiLuong.getText().equals("")) {
			DialogHelper.alert(this, "Không bỏ trống thời lượng!");
			return false;
		}
		if (txtHocPhi.getText().equals("")) {
			DialogHelper.alert(this, "Không bỏ trống học phí!");
			return false;
		}
		try {
			double thoiluong = Double.parseDouble(txtThoiLuong.getText());
			double hocphi = Double.parseDouble(txtHocPhi.getText());

			if (thoiluong <= 0) {
				DialogHelper.alert(this, "Thời lượng là số dương và phải lớn hơn 0");
				ErrorMes = "Thời lượng là số dương và phải lớn hơn 0";
				return false;
			}
			if (hocphi <= 0) {
				DialogHelper.alert(this, "Học phí là số dương và phải lớn hơn 0");
				ErrorMes = "Học phí là số dương và phải lớn hơn 0";
				return false;
			}

		} catch (Exception e) {
			ErrorMes = "Thời lượng là số dương và phải lớn hơn 0";
		}

		return true;
	}

	//
	int index = 0;
	ChuyenDeDAO dao = new ChuyenDeDAO();

	void load() {
		DefaultTableModel model = (DefaultTableModel) tblGridView.getModel();
		model.setRowCount(0);
		try {
			List<ChuyenDe> list = dao.select();
			for (ChuyenDe cd : list) {
				Object[] row = { cd.getMaCD(), cd.getTenCD(), cd.getHocPhi(), cd.getThoiLuong(), cd.getHinh() };
				model.addRow(row);
			}
		} catch (Exception e) {
			DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
		}
	}

	void insert() {
		ChuyenDe model = getModel();
		try {
			dao.insert(model);
			this.load();
			this.clear();
			DialogHelper.alert(this, "Thêm mới thành công!");
			ErrorMes = "Thêm mới thành công!";
		} catch (Exception e) {
			DialogHelper.alert(this, "Chuyên đề này đã có!");
		}

	}

	void update() {
		ChuyenDe model = getModel();
		try {
			dao.update(model);
			this.load();
			DialogHelper.alert(this, "Cập nhật thành công!");
			ErrorMes = "Cập nhật thành công!";
		} catch (Exception e) {
			DialogHelper.alert(this, "Cập nhật thất bại!");

		}

	}

	void delete() {
		if (DialogHelper.confirm(this, "Bạn có muốn xóa hay không?")) {
			String macd = txtMaCD.getText();
			try {
				dao.delete(macd);
				this.load();
				this.clear();
				DialogHelper.alert(this, "Xóa thành công!");
			} catch (Exception e) {
				DialogHelper.alert(this, "Xóa thất bại! Chuyên đề đang áp dụng cho các khóa học");
			}
		}
	}

	void clear() {
		this.setModel(new ChuyenDe());
		this.setStatus(true);
		lblHinh.setIcon(null);
	}

	void edit() {
		try {
			String macd = (String) tblGridView.getValueAt(this.index, 0);
			ChuyenDe model = dao.findById(macd);
			if (model != null) {
				this.setModel(model);
				this.setStatus(false);
			}
		} catch (Exception e) {
			DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
		}
	}

	void setModel(ChuyenDe model) {

		txtMaCD.setText(model.getMaCD());
		txtTenCD.setText(model.getTenCD());
		txtThoiLuong.setText(String.valueOf(model.getThoiLuong()));
		txtHocPhi.setText(String.valueOf(model.getHocPhi()));
		txtMoTa.setText(model.getMoTa());
		lblHinh.setToolTipText(model.getHinh());
		if (model.getHinh() != null) {
			lblHinh.setIcon(ShareHelper.readLogo(model.getHinh()));
		}
	}

	ChuyenDe getModel() {
		ChuyenDe model = new ChuyenDe();
		model.setMaCD(txtMaCD.getText());
		model.setTenCD(txtTenCD.getText());
		model.setThoiLuong(Integer.valueOf(txtThoiLuong.getText()));
		model.setHocPhi(Double.valueOf(txtHocPhi.getText()));
		model.setHinh(lblHinh.getToolTipText());
		model.setMoTa(txtMoTa.getText());
		return model;
	}

	void setStatus(boolean insertable) {
		txtMaCD.setEditable(insertable);
		btnInsert.setEnabled(insertable);
		btnUpdate.setEnabled(!insertable);
		btnDelete.setEnabled(!insertable);

		boolean first = this.index > 0;
		boolean last = this.index < tblGridView.getRowCount() - 1;
		btnFisrt.setEnabled(!insertable && first);
		btnPrev.setEnabled(!insertable && first);
		btnLast.setEnabled(!insertable && last);
		btnNext.setEnabled(!insertable && last);
	}

	void selectImage() {
		if (FileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = FileChooser.getSelectedFile();
			if (ShareHelper.saveLogo(file)) {
				// Hiển thị hình lên form
				lblHinh.setIcon(ShareHelper.readLogo(file.getName()));
				lblHinh.setToolTipText(file.getName());
			}
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel5 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		tabs = new javax.swing.JTabbedPane();
		jPanel2 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		txtMaCD = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtTenCD = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		txtThoiLuong = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		txtHocPhi = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtMoTa = new javax.swing.JTextArea();
		btnInsert = new javax.swing.JButton();
		btnUpdate = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();
		btnClear = new javax.swing.JButton();
		btnFisrt = new javax.swing.JButton();
		btnPrev = new javax.swing.JButton();
		btnNext = new javax.swing.JButton();
		btnLast = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		lblHinh = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		tblGridView = new javax.swing.JTable();
		FileChooser = new javax.swing.JFileChooser();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jPanel5.setBackground(new java.awt.Color(0, 0, 102));
		jPanel5.setForeground(new java.awt.Color(0, 102, 102));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 102, 102));
		jLabel1.setText("QUẢN LÝ CHUYÊN ĐỀ");

		jLabel2.setText("Hình logo");

		jLabel3.setText("Mã chuyên đề");

		jLabel4.setText("Tên chuyên đề");

		jLabel5.setText("Thời lượng (giờ)");

		jLabel6.setText("Học phí");

		jLabel7.setText("Mô tả chuyên đề");

		txtMoTa.setColumns(20);
		txtMoTa.setRows(5);
		jScrollPane1.setViewportView(txtMoTa);

		btnInsert.setText("Thêm");
		btnInsert.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnInsertActionPerformed(evt);
			}
		});

		btnUpdate.setText("Sửa");
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUpdateActionPerformed(evt);
			}
		});

		btnDelete.setText("Xóa");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});

		btnClear.setText("Mới");
		btnClear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnClearActionPerformed(evt);
			}
		});

		btnFisrt.setText("|<");
		btnFisrt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnFisrtActionPerformed(evt);
			}
		});

		btnPrev.setText("<<");
		btnPrev.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPrevActionPerformed(evt);
			}
		});

		btnNext.setText(">>");
		btnNext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNextActionPerformed(evt);
			}
		});

		btnLast.setText(">|");
		btnLast.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLastActionPerformed(evt);
			}
		});

		jPanel3.setBackground(new java.awt.Color(0, 0, 102));

		lblHinh.setBackground(new java.awt.Color(0, 0, 102));
		lblHinh.setForeground(new java.awt.Color(0, 0, 102));
		lblHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblHinh.setMaximumSize(new java.awt.Dimension(196, 196));
		lblHinh.setMinimumSize(new java.awt.Dimension(196, 196));
		lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblHinhMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblHinh,
						javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblHinh, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtHocPhi).addComponent(txtThoiLuong)
										.addComponent(txtMaCD, javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(txtTenCD, javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel6).addComponent(jLabel5)
												.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel4)).addGap(0, 0, Short.MAX_VALUE))))
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel7).addComponent(jLabel2)
										.addGroup(jPanel2Layout.createSequentialGroup().addComponent(btnInsert)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnUpdate)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnDelete)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnClear).addGap(30, 30, 30).addComponent(btnFisrt)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnPrev)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnNext)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnLast)))
								.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel3)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtMaCD, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel4)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtTenCD, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel5)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel6)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel7)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnInsert).addComponent(btnUpdate).addComponent(btnDelete)
								.addComponent(btnClear).addComponent(btnFisrt).addComponent(btnPrev)
								.addComponent(btnNext).addComponent(btnLast))
						.addContainerGap(80, Short.MAX_VALUE)));

		tabs.addTab("CẬP NHẬT", jPanel2);

		jPanel1.setBackground(new java.awt.Color(0, 0, 102));

		tblGridView.setBackground(new java.awt.Color(240, 240, 240));
		tblGridView.setForeground(new java.awt.Color(0, 102, 102));
		tblGridView.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "Mã CD", "TÊN CD", "HỌC PHÍ", "THỜI LƯỢNG", "HÌNH" }));
		tblGridView.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblGridViewMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(tblGridView);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(540, 540, 540)
										.addComponent(FileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												Short.MAX_VALUE)
										.addGap(540, 540, 540))
								.addGroup(
										jPanel1Layout.createSequentialGroup()
												.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 892,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(FileChooser,
								javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		tabs.addTab("DANH SÁCH", jPanel1);

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1).addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 684,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(245, 245, 245)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(tabs,
								javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
		if (check()) {
			update();
		}

	}// GEN-LAST:event_btnUpdateActionPerformed

	private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblHinhMouseClicked
		this.selectImage();
	}// GEN-LAST:event_lblHinhMouseClicked

	private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInsertActionPerformed
		if (check()) {
			insert();
		}

	}// GEN-LAST:event_btnInsertActionPerformed

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
		delete();
	}// GEN-LAST:event_btnDeleteActionPerformed

	private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnClearActionPerformed
		clear();
	}// GEN-LAST:event_btnClearActionPerformed

	private void tblGridViewMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblGridViewMouseClicked
		if (evt.getClickCount() == 1) {
			this.index = tblGridView.rowAtPoint(evt.getPoint());
			if (this.index >= 0) {
				this.edit();
				tabs.setSelectedIndex(0);
			}
		}
	}// GEN-LAST:event_tblGridViewMouseClicked

	private void btnFisrtActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFisrtActionPerformed
		this.index = 0;
		this.edit();
	}// GEN-LAST:event_btnFisrtActionPerformed

	private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPrevActionPerformed
		this.index--;
		this.edit();
	}// GEN-LAST:event_btnPrevActionPerformed

	private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNextActionPerformed
		this.index++;
		this.edit();
	}// GEN-LAST:event_btnNextActionPerformed

	private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLastActionPerformed
		this.index = tblGridView.getRowCount() - 1;
		this.edit();
	}// GEN-LAST:event_btnLastActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(quanlychuyende.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(quanlychuyende.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(quanlychuyende.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(quanlychuyende.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new quanlychuyende().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JFileChooser FileChooser;
	public javax.swing.JButton btnClear;
	public javax.swing.JButton btnDelete;
	private javax.swing.JButton btnFisrt;
	public javax.swing.JButton btnInsert;
	private javax.swing.JButton btnLast;
	private javax.swing.JButton btnNext;
	private javax.swing.JButton btnPrev;
	public javax.swing.JButton btnUpdate;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel lblHinh;
	private javax.swing.JTabbedPane tabs;
	private javax.swing.JTable tblGridView;
	public javax.swing.JTextField txtHocPhi;
	public javax.swing.JTextField txtMaCD;
	public javax.swing.JTextArea txtMoTa;
	public javax.swing.JTextField txtTenCD;
	public javax.swing.JTextField txtThoiLuong;
	// End of variables declaration//GEN-END:variables
}
