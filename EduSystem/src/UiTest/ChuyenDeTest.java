package UiTest;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import UI.quanlychuyende;

public class ChuyenDeTest {

	private JTextField txtMaCD;
	private JTextField txtTenCD;
	private JTextField txtHocPhi;
	private JTextArea txtMoTa;
	private JTextField txtThoiLuong;
	private quanlychuyende qlcd;

	@BeforeClass
	public void beforeClass() {
		qlcd = new quanlychuyende();
		txtMaCD = ((quanlychuyende) qlcd).txtMaCD;
		txtTenCD = ((quanlychuyende) qlcd).txtTenCD;
		txtHocPhi = ((quanlychuyende) qlcd).txtHocPhi;
		txtMoTa = ((quanlychuyende) qlcd).txtMoTa;
		txtThoiLuong = ((quanlychuyende) qlcd).txtThoiLuong ;
		;
	}

	// Test thêm nhân viên với thông tin bị bỏ trống
	@Test(priority = 1)
	public void testTrongThongTinInsert() {
		txtMaCD.setText("");
		txtTenCD.setText("Tesst11");
		txtHocPhi.setText("");
		txtThoiLuong.setText("");
		txtMoTa.setText("");
		qlcd.setVisible(true);

		((quanlychuyende) qlcd).btnInsert.doClick();
		String expectedMessage = "Mã chuyên đề không được bỏ trống";
		String actualMessage = qlcd.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlcd.dispose();
	}

	// Test trùng mã CD
	@Test(priority = 2)
	public void testTrungMaCD() {
		txtMaCD.setText("JAV01");
		txtTenCD.setText("test");
		txtHocPhi.setText("20");
		txtThoiLuong.setText("20");
		txtMoTa.setText("test");
		qlcd.setVisible(true);

		((quanlychuyende) qlcd).btnInsert.doClick();
		String expectedMessage = "Mã chuyên đề đã tồn tại";
		String actualMessage = qlcd.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlcd.dispose();
	}

//	// Update thông tin chuyên đề
	@Test(priority = 3)
	public void testTrongThongTinUpdate() {
		txtMaCD.setText("");
		txtTenCD.setText("test");
		txtHocPhi.setText("20");
		txtThoiLuong.setText("20");
		txtMoTa.setText("test");
		qlcd.setVisible(true);

		((quanlychuyende) qlcd).btnUpdate.doClick();
		String expectedMessage = "Mã chuyên đề không được bỏ trống";
		String actualMessage = qlcd.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlcd.dispose();
	}

	// Nhập mã cd nhỏ hơn 5 kí tự
	@Test(priority = 4)
	public void testSaiMaCDInsert() {
		txtMaCD.setText("JA12");
		txtTenCD.setText("test");
		txtHocPhi.setText("20");
		txtThoiLuong.setText("20");
		txtMoTa.setText("test");
		qlcd.setVisible(true);

		((quanlychuyende) qlcd).btnInsert.doClick();
		String expectedMessage = "Mã chuyên đề phải nhập đúng 5 ký tự";
		String actualMessage = qlcd.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlcd.dispose();
	}

	// Nhập sai thời lượng
	@Test(priority = 5)
	public void testSaiThoiGianInsert() {		
		txtMaCD.setText("JAV20");
		txtTenCD.setText("test");
		txtHocPhi.setText("20");
		txtThoiLuong.setText("-3");
		txtMoTa.setText("test");
		qlcd.setVisible(true);

		((quanlychuyende) qlcd).btnInsert.doClick();
		String expectedMessage = "Thời lượng là số dương và phải lớn hơn 0";
		String actualMessage = qlcd.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlcd.dispose();
	}

//	// Nhập sai thời lượng
	@Test(priority = 6)
	public void testSaiThoiGianInsert2() {
		txtMaCD.setText("JAV21");
		txtTenCD.setText("test");
		txtHocPhi.setText("20");
		txtThoiLuong.setText("-20");
		txtMoTa.setText("test");
		qlcd.setVisible(true);

		((quanlychuyende) qlcd).btnInsert.doClick();
		String expectedMessage = "Thời lượng là số dương và phải lớn hơn 0";
		String actualMessage = qlcd.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlcd.dispose();
	}

	// Nhập sai học phi
	@Test(priority = 7)
	public void testSaiHocPhiInsert() {
		txtMaCD.setText("JAV23");
		txtTenCD.setText("test");
		txtHocPhi.setText("-2");
		txtThoiLuong.setText("20");
		txtMoTa.setText("test");
		qlcd.setVisible(true);

		((quanlychuyende) qlcd).btnInsert.doClick();
		String expectedMessage = "Học phí là số dương và phải lớn hơn 0";
		String actualMessage = qlcd.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlcd.dispose();
	}
	
	@Test(priority = 8)
	public void testSaiThoiGianUpdate() {
		txtMaCD.setText("JAV01");
		txtTenCD.setText("test");
		txtHocPhi.setText("20");
		txtThoiLuong.setText("-20");
		txtMoTa.setText("test");
		qlcd.setVisible(true);

		((quanlychuyende) qlcd).btnUpdate.doClick();
		String expectedMessage = "Thời lượng là số dương và phải lớn hơn 0";
		String actualMessage = qlcd.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlcd.dispose();
	}

	// Nhập sai học phi
	@Test(priority = 9)
	public void testSaiHocPhiUpdate() {
		txtMaCD.setText("JAV01");
		txtTenCD.setText("test");
		txtHocPhi.setText("-20000000");
		txtThoiLuong.setText("20");
		txtMoTa.setText("test");
		qlcd.setVisible(true);

		((quanlychuyende) qlcd).btnUpdate.doClick();
		String expectedMessage = "Học phí là số dương và phải lớn hơn 0";
		String actualMessage = qlcd.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlcd.dispose();
	}
	
	// Nhập sai học phi
		@Test(priority = 10)
		public void testUpdateSuccess() {
			txtMaCD.setText("JAV23");
			txtTenCD.setText("test");
			txtHocPhi.setText("20000000");
			txtThoiLuong.setText("20");
			txtMoTa.setText("test");
			qlcd.setVisible(true);

			((quanlychuyende) qlcd).btnInsert.doClick();
			String expectedMessage = "Thêm mới thành công!";
			String actualMessage = qlcd.ErrorMes;
			Assert.assertEquals(actualMessage, expectedMessage);
			qlcd.dispose();
		}
		
		// Nhập sai học phi
		@Test(priority = 11)
		public void testInsertSuccess() {
			txtMaCD.setText("JAV23");
			txtTenCD.setText("test");
			txtHocPhi.setText("2");
			txtThoiLuong.setText("20");
			txtMoTa.setText("test");
			qlcd.setVisible(true);

			((quanlychuyende) qlcd).btnInsert.doClick();
			String expectedMessage = "Cập nhật thành công!";
			String actualMessage = qlcd.ErrorMes;
			Assert.assertEquals(actualMessage, expectedMessage);
			qlcd.dispose();
		}
}
