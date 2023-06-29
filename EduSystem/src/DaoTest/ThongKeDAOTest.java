package DaoTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import DAO.ThongKeDAO;

public class ThongKeDAOTest {

    private ThongKeDAO thongKeDAO;

    @BeforeClass
    public void setUp() {
        thongKeDAO = new ThongKeDAO();
    }

    @Test(priority = 1)
    public void testGetNguoiHoc() {
        // Test the number of rows returned by the method
        Assert.assertEquals(thongKeDAO.getNguoiHoc().size(), 5);
        
        // Test the data of the first row returned by the method
        Object[] expected = {2020, 20, "2020-01-01", "2020-12-31"};
        Assert.assertEquals(thongKeDAO.getNguoiHoc().get(0), expected);
    }

    @Test(priority = 2)
    public void testGetBangDiem() {
        // Test the number of rows returned by the method
        Assert.assertEquals(thongKeDAO.getBangDiem(1).size(), 10);
        
        // Test the data of the first row returned by the method
        Object[] expected = {"NH001", "Nguyen Van A", 8.0, "Giỏi"};
        Assert.assertEquals(thongKeDAO.getBangDiem(1).get(0), expected);
    }

    @Test(priority = 3)
    public void testGetDiemTheoChuyenDe() {
        // Test the number of rows returned by the method
        Assert.assertEquals(thongKeDAO.getDiemTheoChuyenDe().size(), 3);
        
        // Test the data of the first row returned by the method
        Object[] expected = {"Lập trình Java", 25, 3.5, 9.0, 6.5};
        Assert.assertEquals(thongKeDAO.getDiemTheoChuyenDe().get(0), expected);
    }

    @Test(priority = 4)
    public void testGetDoanhThu() {
        // Test the number of rows returned by the method
        Assert.assertEquals(thongKeDAO.getDoanhThu(2021).size(), 3);
        
        // Test the data of the first row returned by the method
        Object[] expected = {"Lập trình Java", 10, 50, 250000000.0, 10000000.0, 50000000.0, 25000000.0};
        Assert.assertEquals(thongKeDAO.getDoanhThu(2021).get(0), expected);
    }
}

