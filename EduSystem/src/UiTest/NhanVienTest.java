package UiTest;

import org.testng.annotations.Test;

import Helper.DialogHelper;
import UI.quanlynhanvien;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class NhanVienTest {
	private JTextField txtHoTen;
	private JTextField txtMaNV;
	private JTextField txtMatKhau;
	private JTextField txtXacNhanMK;
	private quanlynhanvien qlnv;

	@BeforeClass
	public void beforeClass() {
		qlnv = new quanlynhanvien();
		txtHoTen = qlnv.txtHoTen;
		txtMaNV = qlnv.txtMaNV;
		txtMatKhau = qlnv.txtMatKhau;
		txtXacNhanMK = qlnv.txtXacNhanMK;
	}

	// Test thêm nhân viên với thông tin bị bỏ trống
	@Test(priority = 1)
	public void testTrongThongTin() {
		txtHoTen.setText("");
		txtMaNV.setText("");
		txtMatKhau.setText("");
		txtXacNhanMK.setText("");
		qlnv.setVisible(true);

		qlnv.btnInsert.doClick();
		String expectedMessage = "Mã nhân viên không được để trống";
		String actualMessage = qlnv.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlnv.dispose();
	}

	// Test tên nhân viên có ký tự đặc biệt hoặc số
	@Test(priority = 2)
	public void testTenSai() {
		txtHoTen.setText("123//...");
		txtMaNV.setText("Cuongtest");
		txtMatKhau.setText("test");
		txtXacNhanMK.setText("test");
		qlnv.setVisible(true);

		qlnv.btnInsert.doClick();
		String expectedMessage = "Họ tên chỉ được chứa chữ cái và khoảng trắng";
		String actualMessage = qlnv.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlnv.dispose();
	}

	//Test thêm thành công
		@Test(priority = 9)
		public void testThemThanhCong() {
			txtHoTen.setText("Ngo Quoc Cuong");
			txtMaNV.setText("Cuongtest");
		    txtMatKhau.setText("test");
		    txtXacNhanMK.setText("test");
		    qlnv.setVisible(true);
		    
		    qlnv.btnInsert.doClick();
		    String expectedMessage = "Thêm mới thành công!";
		    String actualMessage = qlnv.ErrorMes;
		    Assert.assertEquals(actualMessage, expectedMessage);
		    qlnv.dispose();
		}

	// Test thêm nhân viên trùng mã nhân viên
	@Test(priority = 3)
	public void testTrungMaNV() {
		txtHoTen.setText("Ngo Quoc Cuong");
		txtMaNV.setText("TeoNV");
		txtMatKhau.setText("test");
		txtXacNhanMK.setText("test");
		qlnv.setVisible(true);

		qlnv.btnInsert.doClick();
		String expectedMessage = "Mã nhân viên đã tồn tại! thao tác thêm thất bại!";
		String actualMessage = qlnv.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlnv.dispose();
	}

	// Xóa nhân viên để trống mã nhân viên
	@Test(priority = 4)
	public void testXoaNVTrongMaNV() {

		txtMaNV.setText("");

		qlnv.setVisible(true);

		qlnv.btnDelete.doClick();
		String expectedMessage = "Mã nhân viên trống!";
		String actualMessage = qlnv.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlnv.dispose();
	}

	// Sửa nhân viên có mã nhân viên không tồn tại
	@Test(priority = 5)
	public void testSuaNVSaiMaNV() {

		txtMaNV.setText("TestFail");
		txtHoTen.setText("Ngo Quoc Cuong");
		txtMatKhau.setText("test");
		txtXacNhanMK.setText("test");
		qlnv.setVisible(true);

		qlnv.btnUpdate.doClick();
		String expectedMessage = "Cập nhật thất bại!";
		String actualMessage = qlnv.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlnv.dispose();
	}

	// Thêm nhân viên với mã trùng nhau
	@Test(priority = 7)
	public void testThemNVTrungMa() {

		txtMaNV.setText("TeoNV");
		txtHoTen.setText("Ngo Quoc Cuong");
		txtMatKhau.setText("test");
		txtXacNhanMK.setText("test");
		qlnv.setVisible(true);

		qlnv.btnInsert.doClick();
		String expectedMessage = "Mã nhân viên đã tồn tại! thao tác thêm thất bại!";
		String actualMessage = qlnv.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlnv.dispose();
	}

	// Thêm nhân viên với mã trùng nhau
	@Test(priority = 8)
	public void testMatKhauKhongTrung() {

		txtMaNV.setText("Test2");
		txtHoTen.setText("Ngo Quoc Cuong");
		txtMatKhau.setText("test");
		txtXacNhanMK.setText("test-fail");
		qlnv.setVisible(true);

		qlnv.btnInsert.doClick();
		String expectedMessage = "Xác nhận mật khẩu không đúng!";
		String actualMessage = qlnv.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlnv.dispose();
	}
	
	//Xóa nhân viên với thông tin đúng
	@Test(priority = 6)
	public void testXoaThanhCong() {

		txtMaNV.setText("Cuongtest");
		txtHoTen.setText("Test-Succes");
		txtMatKhau.setText("Test-Succes");
		txtXacNhanMK.setText("Test-Succes");
		qlnv.setVisible(true);

		qlnv.btnDelete.doClick();
		String expectedMessage = "Xóa thành công!";
		String actualMessage = qlnv.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlnv.dispose();
	}
	
}