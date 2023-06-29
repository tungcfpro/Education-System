/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Helper.ShareHelper;
import Helper.DialogHelper;
import DAO.NhanVienDAO;
import Model.NhanVien;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class quanlynhanvien extends javax.swing.JFrame {

	/**
	 * Creates new form quanlynhanvien
	 */
	public quanlynhanvien() {
		initComponents();
		init();

	}

	public String ErrorMes = "";

	int index = 0; // vị trí của nhân viên đang hiển thị trên form
	NhanVienDAO dao = new NhanVienDAO();

	void init() {
		setIconImage(ShareHelper.APP_ICON);
		setLocationRelativeTo(null);
		if (ShareHelper.USER != null) {
			load();
		} else {
			DialogHelper.alert(this, "Vui lòng đăng nhập");
			this.tabs.removeAll();
		}
	}

	void load() {
		DefaultTableModel model = (DefaultTableModel) tblGridView.getModel();
		model.setRowCount(0);
		try {
			List<NhanVien> list = dao.select();
			for (NhanVien nv : list) {
				Object[] row = { nv.getMaNV(), nv.getMatKhau(), nv.getHoTen(),
						nv.getVaiTro() ? "Trưởng phòng" : "Nhân viên"

				};
				model.addRow(row);
			}
		} catch (Exception e) {
			DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
		}
	}

	boolean check() {
		if (txtMaNV.getText().length() < 3) {
			if (txtMaNV.getText().length() == 0) {
				DialogHelper.alert(this, "Mã nhân viên không được để trống");
				ErrorMes = "Mã nhân viên không được để trống";
				return false;
			}
			if (txtMaNV.getText().length() > 0 && txtMaNV.getText().length() < 3) {
				DialogHelper.alert(this, "Mã nhân viên phải nhập ít nhất 3 ký tự");
				return false;
			}
		}
		if (txtMatKhau.getText().length() < 3) {
			if (txtMatKhau.getText().length() == 0) {
				DialogHelper.alert(this, "Mật khẩu không được để trống");
				return false;
			}
			if (txtMatKhau.getText().length() > 0 && txtMatKhau.getText().length() < 3) {
				DialogHelper.alert(this, "Mật khẩu phải nhập ít nhất 3 ký tự");
				return false;
			}
		}
		if (txtXacNhanMK.getText().length() < 3) {
			if (txtXacNhanMK.getText().length() == 0) {
				DialogHelper.alert(this, "Xác nhận mật khẩu không được để trống");
				return false;
			}
		}
		if (txtHoTen.getText().length() == 0) {
			DialogHelper.alert(this, "Họ tên không được để trống");
			return false;
		} else if (txtHoTen.getText().matches(".*[^a-zA-Z ].*")) {
			DialogHelper.alert(this, "Họ tên chỉ được chứa chữ cái và khoảng trắng");
			ErrorMes = "Họ tên chỉ được chứa chữ cái và khoảng trắng";
			return false;
		}

		return true;
	}

	void insert() {
		NhanVien model = getModel();
		String confirm = new String(txtXacNhanMK.getText());
		if (confirm.equals(model.getMatKhau())) {
			try {
				dao.insert(model);
				this.load();
				this.clear();
				DialogHelper.alert(this, "Thêm mới thành công!");
				ErrorMes = "Thêm mới thành công!";
			} catch (Exception e) {
				DialogHelper.alert(this, "Mã nhân viên đã tồn tại! thao tác thêm thất bại!");
				ErrorMes = "Mã nhân viên đã tồn tại! thao tác thêm thất bại!";
			}
		} else {
			DialogHelper.alert(this, "Xác nhận mật khẩu không đúng!");
			ErrorMes = "Xác nhận mật khẩu không đúng!";
		}
	}

	void update() {
		NhanVien model = getModel();

		String confirm = new String(txtXacNhanMK.getText());
		String manv = new String(txtMaNV.getText());
		if (!confirm.equals(model.getMatKhau())) {
			DialogHelper.alert(this, "Xác nhận mật khẩu không đúng!");
			ErrorMes = "Xác nhận mật khẩu không đúng!";
		} else {
			try {
				dao.update(model);
				this.load();
				DialogHelper.alert(this, "Cập nhật thất bại!");
				ErrorMes = "Cập nhật thất bại!";
			} catch (Exception e) {
				DialogHelper.alert(this, "Cập nhật thất bại!");
				ErrorMes = "Cập nhật thất bại!";
			}
		}
	}

	void delete() {
		if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa nhân viên này?")) {
			String manv = txtMaNV.getText();
			
			if (manv.isEmpty()) {
				DialogHelper.alert(this, "Mã nhân viên trống!");
				ErrorMes = "Mã nhân viên trống!";
			} else {
//				String manv2 = ShareHelper.USER.getMaNV();
				if (1 == 0) {
					DialogHelper.alert(this, "Bạn không thể xóa chính mình!");
				} else {
					try {
						dao.delete(manv);
						this.load();
						this.clear();
						DialogHelper.alert(this, "Xóa thành công!");
						ErrorMes = "Xóa thành công!";
					} catch (Exception e) {
						DialogHelper.alert(this,
								"Nhân viên này không thể xóa, các học viên được thêm từ nhân này vẫn đang trong khóa học");
					}
				}
			}

		}
	}

	void edit() {
		try {
			String manv = (String) tblGridView.getValueAt(this.index, 0);
			NhanVien model = dao.findById(manv);
			if (model != null) {
				this.setModel(model);
				this.setStatus(false);
			}
		} catch (Exception e) {
			DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
		}
	}

	void clear() {
		this.setModel(new NhanVien());
		index = 0;
		this.setStatus(false);
	}

	void setModel(NhanVien model) {
		txtMaNV.setText(model.getMaNV());
		txtHoTen.setText(model.getHoTen());
		txtMatKhau.setText(model.getMatKhau());
		txtXacNhanMK.setText(model.getMatKhau());
		rdoTruongPhong.setSelected(model.getVaiTro());
		rdoNhanVien.setSelected(!model.getVaiTro());
	}

	NhanVien getModel() {
		NhanVien model = new NhanVien();
		model.setMaNV(txtMaNV.getText());
		model.setHoTen(txtHoTen.getText());
		model.setMatKhau(new String(txtMatKhau.getText()));
		model.setVaiTro(rdoTruongPhong.isSelected());
		return model;
	}

	void setStatus(boolean insertable) {
		if (tblGridView.getRowCount() > 0) {
			txtMaNV.setEditable(!insertable);
			btnInsert.setEnabled(!insertable);
			btnUpdate.setEnabled(!insertable);
			btnDelete.setEnabled(!insertable);
		} else {
			btnInsert.setEnabled(!insertable);
			btnUpdate.setEnabled(insertable);
			btnDelete.setEnabled(insertable);
		}

		boolean first = this.index > 0;
		boolean last = this.index < tblGridView.getRowCount() - 1;
		btnFirst.setEnabled(!insertable && first);
		btnPrev.setEnabled(!insertable && first);
		btnNext.setEnabled(!insertable && last);
		btnLast.setEnabled(!insertable && last);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	public void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jPanel3 = new javax.swing.JPanel();
		tabs = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		txtMaNV = new javax.swing.JTextField();
		txtMatKhau = new javax.swing.JTextField();
		txtXacNhanMK = new javax.swing.JTextField();
		txtHoTen = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		rdoTruongPhong = new javax.swing.JRadioButton();
		rdoNhanVien = new javax.swing.JRadioButton();
		btnInsert = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();
		btnUpdate = new javax.swing.JButton();
		btnClear = new javax.swing.JButton();
		btnPrev = new javax.swing.JButton();
		btnFirst = new javax.swing.JButton();
		btnLast = new javax.swing.JButton();
		btnNext = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblGridView = new javax.swing.JTable();
		jLabel6 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(new java.awt.Color(0, 102, 102));
		setMinimumSize(null);

		jPanel3.setBackground(new java.awt.Color(0, 0, 102));
		jPanel3.setMaximumSize(null);

		tabs.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabel1.setText("Mã nhân viên");

		jLabel2.setText("Mật khẩu ");

		jLabel3.setText("Xác nhận mật khẩu");

		jLabel4.setText("Họ và tên");

		jLabel5.setText("Vai trò");

		buttonGroup1.add(rdoTruongPhong);
		rdoTruongPhong.setText("Trưởng Phòng");

		buttonGroup1.add(rdoNhanVien);
		rdoNhanVien.setText("Nhân Viên");
		rdoNhanVien.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rdoNhanVienActionPerformed(evt);
			}
		});

		btnInsert.setText("Thêm");
		btnInsert.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnInsertActionPerformed(evt);
			}
		});

		btnDelete.setText("Xóa");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});

		btnUpdate.setText("Sửa");
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUpdateActionPerformed(evt);
			}
		});

		btnClear.setText("Mới");
		btnClear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnClearActionPerformed(evt);
			}
		});

		btnPrev.setText("<<");
		btnPrev.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPrevActionPerformed(evt);
			}
		});

		btnFirst.setText("|<");
		btnFirst.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnFirstActionPerformed(evt);
			}
		});

		btnLast.setText(">|");
		btnLast.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLastActionPerformed(evt);
			}
		});

		btnNext.setText(">>");
		btnNext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNextActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(24, 24, 24)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3)
										.addComponent(jLabel4).addComponent(jLabel5)
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(rdoTruongPhong)
												.addGap(18, 18, 18).addComponent(rdoNhanVien))))
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(btnInsert)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnUpdate)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnDelete)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnClear).addGap(18, 18, 18).addComponent(btnFirst)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnPrev)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnNext)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnLast)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.TRAILING)
				.addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.TRAILING)
				.addComponent(txtXacNhanMK, javax.swing.GroupLayout.Alignment.TRAILING)
				.addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.TRAILING));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(28, 28, 28).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtXacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(rdoTruongPhong).addComponent(rdoNhanVien))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnInsert).addComponent(btnUpdate).addComponent(btnDelete)
								.addComponent(btnClear).addComponent(btnFirst).addComponent(btnNext)
								.addComponent(btnLast).addComponent(btnPrev))
						.addGap(33, 33, 33)));

		tabs.addTab("CẬP NHẬT", jPanel1);

		jPanel2.setBackground(new java.awt.Color(0, 102, 102));

		tblGridView
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "MÃ NV", "MẬT KHẨU", "HỌ VÀ TÊN", "VAI TRÒ" }));
		tblGridView.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblGridViewMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tblGridView);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jScrollPane1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		tabs.addTab("DANH SÁCH", jPanel2);

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(255, 102, 102));
		jLabel6.setText("QUẢN LÝ NHÂN VIÊN QUẢN TRỊ");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(tabs,
								javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(135, 135, 135).addComponent(jLabel6)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel3Layout
				.setVerticalGroup(
						jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel6)
										.addGap(18, 18, 18)
										.addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 393,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(48, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
		delete();

	}// GEN-LAST:event_btnDeleteActionPerformed

	public void rdoNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rdoNhanVienActionPerformed

	}// GEN-LAST:event_rdoNhanVienActionPerformed

	public void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInsertActionPerformed
		if (check()) {
			insert();
		}

	}// GEN-LAST:event_btnInsertActionPerformed

	public void btnClearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnClearActionPerformed
		clear();

	}// GEN-LAST:event_btnClearActionPerformed

	public void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
		if (check()) {
			update();
		}

	}// GEN-LAST:event_btnUpdateActionPerformed

	public void tblGridViewMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblGridViewMouseClicked
		if (evt.getClickCount() == 1) {
			this.index = tblGridView.rowAtPoint(evt.getPoint());
			if (this.index >= 0) {
				this.edit();
				tabs.setSelectedIndex(0);
				txtMaNV.setEditable(false);
				return;
			}
		}
		int a = tblGridView.rowAtPoint(evt.getPoint());
//        System.out.print("aa");
//        txtMaNV.setText((String) tblGridView.getValueAt(a, 0));
//        txtMatKhau.setText((String) tblGridView.getValueAt(a, 1));
//        txtXacNhanMK.setText((String) tblGridView.getValueAt(a, 1));
//        txtHoTen.setText((String) tblGridView.getValueAt(a, 2));
		if ((tblGridView.getValueAt(a, 3)).equals("Trưởng phòng")) {
			rdoTruongPhong.setSelected(true);
		} else {
			rdoNhanVien.setSelected(true);
		}

//        System.out.println(tblGridView.getValueAt(a, 1));
//        System.out.println(tblGridView.getValueAt(a, 2));
//        System.out.println(tblGridView.getValueAt(a, 3));
	}// GEN-LAST:event_tblGridViewMouseClicked

	public void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFirstActionPerformed
		this.index = 0;
		this.edit();
		txtMaNV.setEditable(false);
	}// GEN-LAST:event_btnFirstActionPerformed

	public void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPrevActionPerformed
		this.index--;

		if (this.index < 0) {
			DialogHelper.alert(this, "Đã ở đầu trang!");
			this.index = 0;
			this.edit();
			txtMaNV.setEditable(false);
			return;
		}

		this.edit();
		txtMaNV.setEditable(false);
	}// GEN-LAST:event_btnPrevActionPerformed

	public void btnNextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNextActionPerformed
		this.index++;
		int a = tblGridView.getRowCount();

		if (this.index > a - 1) {
			DialogHelper.alert(this, "Đã cuối trang!");
			this.index = a - 1;
			this.edit();
			txtMaNV.setEditable(false);
			return;
		}
		this.edit();
		txtMaNV.setEditable(false);
	}// GEN-LAST:event_btnNextActionPerformed

	public void btnLastActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLastActionPerformed
		this.index = tblGridView.getRowCount() - 1;
		this.edit();
		txtMaNV.setEditable(false);
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
			java.util.logging.Logger.getLogger(quanlynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(quanlynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(quanlynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(quanlynhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new quanlynhanvien().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	public javax.swing.JButton btnClear;
	public javax.swing.JButton btnDelete;
	public javax.swing.JButton btnFirst;
	public javax.swing.JButton btnInsert;
	public javax.swing.JButton btnLast;
	public javax.swing.JButton btnNext;
	public javax.swing.JButton btnPrev;
	public javax.swing.JButton btnUpdate;
	public javax.swing.ButtonGroup buttonGroup1;
	public javax.swing.JLabel jLabel1;
	public javax.swing.JLabel jLabel2;
	public javax.swing.JLabel jLabel3;
	public javax.swing.JLabel jLabel4;
	public javax.swing.JLabel jLabel5;
	public javax.swing.JLabel jLabel6;
	public javax.swing.JPanel jPanel1;
	public javax.swing.JPanel jPanel2;
	public javax.swing.JPanel jPanel3;
	public javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JRadioButton rdoNhanVien;
	public javax.swing.JRadioButton rdoTruongPhong;
	public javax.swing.JTabbedPane tabs;
	public javax.swing.JTable tblGridView;
	public javax.swing.JTextField txtHoTen;
	public javax.swing.JTextField txtMaNV;
	public javax.swing.JTextField txtMatKhau;
	public javax.swing.JTextField txtXacNhanMK;
	// End of variables declaration//GEN-END:variables
}
