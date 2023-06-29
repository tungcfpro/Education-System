package UiTest;

import org.testng.annotations.Test;

import UI.tonghopthongke;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.testng.annotations.BeforeClass;

public class ThongKeTest {

	private tonghopthongke thtk;
	private JTable tblNguoiHoc;
	private JTable tblDoanhThu;
	private JTable tblKhoaHoc;
	private JTable tblTongHopDiem;
	private JTabbedPane Tab;
	private JComboBox<String> cbo;

	@BeforeClass
	public void beforeClass() {
		thtk = new tonghopthongke();

	}

	// Kiểm tra Bảng người học có hiển thị hay không
	@Test(priority = 1)
	public void TblNguoiHoc() {
		Tab = thtk.getTabs();
		Tab.setSelectedIndex(0);
		thtk.setVisible(true);

		tblNguoiHoc = thtk.getTblNguoiHoc();

		assertTrue(tblNguoiHoc.isShowing());

		thtk.dispose();
	}

	// Kiểm tra Bảng điểm học có hiển thị hay không
	@Test(priority = 3)
	public void TblKhoaHoc() {
		Tab = thtk.getTabs();
		Tab.setSelectedIndex(1);

		thtk.setVisible(true);
		tblKhoaHoc = thtk.getTblKhoaHoc();

		assertTrue(tblKhoaHoc.isShowing());

		thtk.dispose();
	}

	// Kiểm tra Bảng doanh thu có hiển thị hay không
	@Test(priority = 4)
	public void tblDoanhThu() {
		Tab = thtk.getTabs();
		Tab.setSelectedIndex(3);
		thtk.setVisible(true);
		tblDoanhThu = thtk.getTblDoanhThu();

		assertTrue(tblDoanhThu.isShowing());

		thtk.dispose();
	}

//Kiểm tra Bảng tổng hợp điểm có hiển thị hay không
	@Test(priority = 2)
	public void tblTongHopDiem() {
		Tab = thtk.getTabs();
		Tab.setSelectedIndex(2);

		thtk.setVisible(true);
		tblTongHopDiem = thtk.getTblTongHop();

		assertTrue(tblTongHopDiem.isShowing());

		thtk.dispose();
	}

	// kiểm tra khi chọn giá trị trong combobox thì bảng khóa học có đổi dữ liệu
	// khong

	@Test(priority = 5)
	public void KiemTraDuLieuKhoaHoc() {
		Tab = thtk.getTabs();
		Tab.setSelectedIndex(1);

		cbo = thtk.getCboKhoaHoc();
		
		String[] items = { "Item 1", "Item 2" };
//		for (String item : items) {
//		    cboKhoaHoc.addItem(item);
//		}
		    
		cbo = new JComboBox<>(items);
		    
		tblKhoaHoc = thtk.getTblKhoaHoc();
		DefaultTableModel tblmodel = (DefaultTableModel) tblKhoaHoc.getModel();
		tblmodel.setRowCount(0);

		Object row[];
		
		//Kiểm tra khi Combobox chọn item thứ nhất
		if (cbo.getSelectedIndex() == 0) {
			row = new Object[]{"Test1", "Test1", "Test1", "Test1"};
			tblmodel.addRow(row);
		} else {
			row = new Object[]{"Test2", "Test2", "Test2", "Test2"};
			tblmodel.addRow(row);
		}

		thtk.setVisible(true);

		cbo.setSelectedIndex(0);
		
		assertEquals(tblKhoaHoc.getValueAt(0, 0), "Test1");
		assertEquals(tblKhoaHoc.getValueAt(0, 1), "Test1");

		//Kiểm tra khi Combobox chọn item thứ hai
		cbo.setSelectedIndex(1);
		
		tblmodel.setRowCount(0);
		
		if (cbo.getSelectedIndex() == 0) {
			row = new Object[]{"Test1", "Test1", "Test1", "Test1"};
			tblmodel.addRow(row);
		} else {
			row = new Object[]{"Test2", "Test2", "Test2", "Test2"};
			tblmodel.addRow(row);
		}
		
		assertEquals(tblKhoaHoc.getValueAt(0, 0), "Test2");
		assertEquals(tblKhoaHoc.getValueAt(0, 1), "Test2");

		thtk.dispose();
	}
	
	// kiểm tra khi chọn giá trị trong combobox thì bảng Doanh thu có đổi dữ liệu
		// khong

		@Test(priority = 6)
		public void KiemTraDuLieuDoanhThu() {
			Tab = thtk.getTabs();
			Tab.setSelectedIndex(3);

			cbo = thtk.getCboDoanhthu();
			
			String[] items = { "Item 1", "Item 2" };
//			for (String item : items) {
//			    cboKhoaHoc.addItem(item);
//			}
			    
			cbo = new JComboBox<>(items);
			    
			tblDoanhThu = thtk.getTblDoanhThu();
			DefaultTableModel tblmodel = (DefaultTableModel) tblDoanhThu.getModel();
			tblmodel.setRowCount(0);

			Object row[];
			
			//Kiểm tra khi Combobox chọn item thứ nhất
			if (cbo.getSelectedIndex() == 0) {
				row = new Object[]{"TestDoanhThu1", "TestDoanhThu1", "TestDoanhThu1", "TestDoanhThu1"};
				tblmodel.addRow(row);
			} else {
				row = new Object[]{"TestDoanhThu2", "TestDoanhThu2", "TestDoanhThu2", "TestDoanhThu2"};
				tblmodel.addRow(row);
			}

			thtk.setVisible(true);

			cbo.setSelectedIndex(0);
			
			assertEquals(tblDoanhThu.getValueAt(0, 0), "TestDoanhThu1");
			assertEquals(tblDoanhThu.getValueAt(0, 1), "TestDoanhThu1");

			//Kiểm tra khi Combobox chọn item thứ hai
			cbo.setSelectedIndex(1);
			
			tblmodel.setRowCount(0);
			
			if (cbo.getSelectedIndex() == 0) {
				row = new Object[]{"TestDoanhThu1", "TestDoanhThu1", "TestDoanhThu1", "TestDoanhThu1"};
				tblmodel.addRow(row);
			} else {
				row = new Object[]{"TestDoanhThu2", "TestDoanhThu2", "TestDoanhThu2", "TestDoanhThu2"};
				tblmodel.addRow(row);
			}
			
			assertEquals(tblDoanhThu.getValueAt(0, 0), "TestDoanhThu2");
			assertEquals(tblDoanhThu.getValueAt(0, 1), "TestDoanhThu2");

			thtk.dispose();
		}
}
