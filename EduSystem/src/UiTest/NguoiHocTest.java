package UiTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Helper.DateHelper;
import UI.quanlynguoihoc;

public class NguoiHocTest {
  private quanlynguoihoc qlnh;
  
  @BeforeTest
  public void setUp() {
	  qlnh = new quanlynguoihoc();
  }
  
  @Test
  //Các trường liệu rỗng
  public void EmTy() {
	  qlnh.txtMaNH.setText("");
	  qlnh.txtHoTen.setText("");
	  qlnh.txtNgaySinh.setText("");
	  qlnh.txtEmail.setText("");
	  qlnh.txtGhiChu.setText("");
	  qlnh.btnInsert.doClick();
	  String actual = qlnh.ErrolMessage;
	  String expected = "Mã người học không được để trống";
	  Assert.assertEquals(actual, expected);
	  
  }
  
  @Test
  //Người học với thông tin sai
  public void WrongInfomation() {
	  qlnh.txtMaNH.setText("NH12345");
	  qlnh.txtHoTen.setText("Nguyễn Văn Minh");
	  qlnh.txtNgaySinh.setText("10-09-2003");
	  qlnh.txtEmail.setText("Thanhtpps22219@fpt.edu.vn");
	  qlnh.txtGhiChu.setText("hihi");
	  qlnh.txtDienThoai.setText("09828");
	  qlnh.btnInsert.doClick();
	  String actual = qlnh.ErrolMessage;
	  String expected = "Số điện thoại phải nhập đủ 10 hoặc 11 số.";
	  Assert.assertEquals(actual, expected);
	  
  }
  
  @Test
  //Người học với thông tin đúng
  public void CorrectInfomation() {
	  qlnh.txtMaNH.setText("NH12309");
	  qlnh.txtHoTen.setText("Nguyễn Văn Minh");
	  qlnh.txtNgaySinh.setText("10-09-2003");
	  qlnh.txtEmail.setText("Thanhtpps22219@fpt.edu.vn");
	  qlnh.txtGhiChu.setText("hihi");
	  qlnh.txtDienThoai.setText("0982868735");
	  qlnh.btnInsert.doClick();
	  String actual = qlnh.CorrectMessage;
	  String expected = "Thêm mới thành công!";
	  Assert.assertEquals(actual, expected);
	  
  }
  
  @AfterTest
  public void TestDeleteNguoiHoc() {
	  qlnh.txtMaNH.setText("NH12346");
	  qlnh.btnDelete.doClick();
	  String actual = qlnh.CorrectMessage;
	  String expected = "Xóa thành công";
	  Assert.assertEquals(actual, expected);
  }
  
  
  
}
