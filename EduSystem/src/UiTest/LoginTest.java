package UiTest;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import UI.login;

public class LoginTest {

	public static void writeResultsToExcel(String[][] data) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Test Results");

		// Add header row
		String[] headers = { "Test Step No", "Action", "Expected Output", "Actual Output" };
		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headers[i]);
		}

		// Add data rows
		for (int i = 0; i < data.length; i++) {
			Row row = sheet.createRow(i + 1);
			for (int j = 0; j < data[i].length; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(data[i][j]);
			}
		}

		// Write data to file
		try {
			FileOutputStream outputStream = new FileOutputStream("D:\\Excel\\test_results.xls");
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
			System.out.println("xuất thành công");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private login loginPage;

	@BeforeTest
	public void setUp() {
		loginPage = new login();
	}

	@Test
	public void LoginWithAdmin() {
		loginPage.txtMaNV.setText("admin");
		loginPage.txtmatkhau.setText("123");
		loginPage.btndangnhap.doClick();
		String actual = loginPage.CorrectMessage;
		String expected = "Đăng nhập thành công";
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void LoginWithUser() {
		loginPage.txtMaNV.setText("PS23893");
		loginPage.txtmatkhau.setText("123");
		loginPage.btndangnhap.doClick();
		String actual = loginPage.CorrectMessage;
		String expected = "Đăng nhập thành công";
		Assert.assertEquals(actual, expected);
	}

	// Bỏ 1 rỗng bất kì và cả hai username và password
	@Test
	public void TestUsernameAndPasswordEmty() {
		loginPage.txtMaNV.setText("");
		loginPage.txtmatkhau.setText("");
		loginPage.btndangnhap.doClick();
		String actual = loginPage.lblErrManv.getText();
		String expected = "Tên đăng nhập không được để rỗng";

		Assert.assertEquals(actual, expected);

	}

	@Test
	public void TestUsernameEmty() {
		loginPage.txtMaNV.setText("");
		loginPage.txtmatkhau.setText("abc123");
		loginPage.btndangnhap.doClick();
		String actual = loginPage.lblErrManv.getText();
		String expected = "Tên đăng nhập không được để rỗng";

		Assert.assertEquals(actual, expected);

	}

	@Test
	public void TestPasswordEmty() {
		loginPage.txtMaNV.setText("PS23893");
		loginPage.txtmatkhau.setText("");
		loginPage.btndangnhap.doClick();
		String actual = loginPage.lblErrPassword.getText();
		String expected = "Mật khẩu không được để rỗng";

		Assert.assertEquals(actual, expected);

	}

}
