package UiTest;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import UI.quanlykhoahoc;

public class KhoaHocTest {
	private JTextField txtNgayKG;
    private JTextField txtNgayTao;
    private JTextField txtNguoiTao;
    private JTextArea txtGhiChu;
    private JTextField txtThoiLuong;
    private JTextField txtHocPhi;
    private quanlykhoahoc qlkh;

    @BeforeClass
    public void beforeClass() {
        qlkh = new quanlykhoahoc();
        txtNgayKG = ((quanlykhoahoc) qlkh).txtNgayKG;
        txtNgayTao = ((quanlykhoahoc) qlkh).txtNgayTao;
        txtNguoiTao = ((quanlykhoahoc) qlkh).txtNguoiTao;
        txtGhiChu = ((quanlykhoahoc) qlkh).txtGhiChu;
        txtThoiLuong = ((quanlykhoahoc) qlkh).txtThoiLuong;
        txtHocPhi = ((quanlykhoahoc) qlkh).txtHocPhi;
        ;
    }

    // Test thêm khoá học với thông tin bị bỏ trống
    @Test(priority = 1)
	public void testTrongThongTinInsert() {
		txtNgayKG.setText("");
	    txtNgayTao.setText("12/4/2023");
	    txtNguoiTao.setText("TeoNV");
	    txtThoiLuong.setText("20");
	    txtHocPhi.setText("20000000");
		qlkh.setVisible(true);

		((quanlykhoahoc) qlkh).btnInsert.doClick();
		String expectedMessage = "Không bỏ trống ngày khai giảng!";
		String actualMessage = qlkh.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlkh.dispose();
	}

    
    // Test thêm khoá học với thông tin bị bỏ trống
    @Test(priority = 2)
	public void testTrongThongTinInsert2() {
		txtNgayKG.setText("12/4/2023");
	    txtNgayTao.setText("");
	    txtNguoiTao.setText("TeoNV");
	    txtThoiLuong.setText("20");
	    txtHocPhi.setText("20000000");
		qlkh.setVisible(true);

		((quanlykhoahoc) qlkh).btnInsert.doClick();
		String expectedMessage = "Không bỏ trống ngày tạo!";
		String actualMessage = qlkh.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlkh.dispose();
	}

    
    // Test thêm khoá học với thông tin bị bỏ trống
    @Test(priority = 3)
	public void testTrongThongTinInsert3() {
		txtNgayKG.setText("13/4/2023");
	    txtNgayTao.setText("12/3/2023");
	    txtNguoiTao.setText("TeoNV");
	    txtThoiLuong.setText("");
	    txtHocPhi.setText("20000000");
		qlkh.setVisible(true);

		((quanlykhoahoc) qlkh).btnInsert.doClick();
		String expectedMessage = "Không bỏ trống thời lượng!";
		String actualMessage = qlkh.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlkh.dispose();
	}

    
    // Test thêm khoá học với thông tin bị bỏ trống
    @Test(priority = 4)
	public void testTrongThongTinInsert4() {
		txtNgayKG.setText("13/4/2023");
	    txtNgayTao.setText("12/3/2023");
	    txtNguoiTao.setText("TeoNV");
	    txtThoiLuong.setText("20");
	    txtHocPhi.setText("");
		qlkh.setVisible(true);

		((quanlykhoahoc) qlkh).btnInsert.doClick();
		String expectedMessage = "Không bỏ trống học phí!";
		String actualMessage = qlkh.ErrorMes;
		Assert.assertEquals(actualMessage, expectedMessage);
		qlkh.dispose();
	}

      // Test thời lương 
      @Test(priority = 5)
      public void testSaiThoiLuongInsert() {
          txtNgayKG.setText("13/4/2023");
          txtNgayTao.setText("12/3/2023");
          txtNguoiTao.setText("TeoNV");
          txtThoiLuong.setText("-20");
          txtHocPhi.setText("20000000");
          qlkh.setVisible(true);
  
          ((quanlykhoahoc) qlkh).btnInsert.doClick();
          String expectedMessage = "Thời lượng là số dương và phải lớn hơn 0";
          String actualMessage = qlkh.ErrorMes;
          Assert.assertEquals(actualMessage, expectedMessage);
          qlkh.dispose();
      }

          // Test thời lương 
          @Test(priority = 6)
          public void testSaiThoiLuongUpdate() {
              txtNgayKG.setText("13/4/2023");
              txtNgayTao.setText("12/3/2023");
              txtNguoiTao.setText("TeoNV");
              txtThoiLuong.setText("-20");
              txtHocPhi.setText("20000000");
              qlkh.setVisible(true);
      
              ((quanlykhoahoc) qlkh).btnUpdate.doClick();
              String expectedMessage = "Thời lượng là số dương và phải lớn hơn 0";
              String actualMessage = qlkh.ErrorMes;
              Assert.assertEquals(actualMessage, expectedMessage);
              qlkh.dispose();
          }

       // Test học phí
       @Test(priority = 7)
       public void testSaiHocPhiInsert() {
           txtNgayKG.setText("13/4/2023");
           txtNgayTao.setText("12/3/2023");
           txtNguoiTao.setText("TeoNV");
           txtThoiLuong.setText("20");
           txtHocPhi.setText("-20000000");
           qlkh.setVisible(true);
   
           ((quanlykhoahoc) qlkh).btnInsert.doClick();
           String expectedMessage = "Học phí là số dương và phải lớn hơn 0";
           String actualMessage = qlkh.ErrorMes;
           Assert.assertEquals(actualMessage, expectedMessage);
           qlkh.dispose();
       }
 
         // Test học phí
         @Test(priority = 8)
         public void testSaiHocPhiUpdate() {
             txtNgayKG.setText("13/4/2023");
             txtNgayTao.setText("12/3/2023");
             txtNguoiTao.setText("TeoNV");
             txtThoiLuong.setText("20");
             txtHocPhi.setText("-20000000");
             qlkh.setVisible(true);
     
             ((quanlykhoahoc) qlkh).btnUpdate.doClick();
             String expectedMessage = "Học phí là số dương và phải lớn hơn 0";
             String actualMessage = qlkh.ErrorMes;
             Assert.assertEquals(actualMessage, expectedMessage);
             qlkh.dispose();
         }

          // Test ngày khai giảng > ngày tạo
          @Test(priority = 9)
          public void testSaiNgayUpdate() {
              txtNgayKG.setText("12/1/2023");
              txtNgayTao.setText("13/3/2023");
              txtNguoiTao.setText("TeoNV");
              txtThoiLuong.setText("20");
              txtHocPhi.setText("200");
              qlkh.setVisible(true);
      
              ((quanlykhoahoc) qlkh).btnUpdate.doClick();
              String expectedMessage = "Ngày khai giảng phai sau ngày hiện tại!";
              String actualMessage = qlkh.ErrorMes;
              Assert.assertEquals(actualMessage, expectedMessage);
              qlkh.dispose();
          }

            // Test ngày khai giảng > ngày tạo
            @Test(priority = 10)
            public void testSaiNgayInsert() {
                txtNgayKG.setText("12/4/2023");
                txtNgayTao.setText("13/3/2023");
                txtNguoiTao.setText("TeoNV");
                txtThoiLuong.setText("20");
                txtHocPhi.setText("200");
                qlkh.setVisible(true);
        
                ((quanlykhoahoc) qlkh).btnInsert.doClick();
                String expectedMessage = "Ngày khai giảng phai sau ngày hiện tại!";
                String actualMessage = qlkh.ErrorMes;
                Assert.assertEquals(actualMessage, expectedMessage);
                qlkh.dispose();
            }

            @Test(priority = 11)
            public void testInsert() {
                txtNgayKG.setText("13/4/2023");
                txtNgayTao.setText("12/3/2023");
                txtNguoiTao.setText("TeoNV");
                txtThoiLuong.setText("20");
                txtHocPhi.setText("200");
                qlkh.setVisible(true);
        
                ((quanlykhoahoc) qlkh).btnInsert.doClick();
                String expectedMessage = "Thêm mới thành công!";
                String actualMessage = qlkh.ErrorMes;
                Assert.assertEquals(actualMessage, expectedMessage);
                qlkh.dispose();
            }

            @Test(priority = 12)
            public void testUpdate() {
                txtNgayKG.setText("13/4/2023");
                txtNgayTao.setText("12/3/2023");
                txtNguoiTao.setText("TeoNV");
                txtThoiLuong.setText("20");
                txtHocPhi.setText("200");
                qlkh.setVisible(true);
        
                ((quanlykhoahoc) qlkh).btnUpdate.doClick();
                String expectedMessage = "Cập nhật thành công!";
                String actualMessage = qlkh.ErrorMes;
                Assert.assertEquals(actualMessage, expectedMessage);
                qlkh.dispose();
            }
}
