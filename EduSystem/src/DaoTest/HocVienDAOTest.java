package DaoTest;

import DAO.HocVienDAO;
import Model.HocVien;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HocVienDAOTest {

    private HocVienDAO hocVienDAO;
    private HocVien hocVien;


    @AfterClass
    public void tearDown() {
        hocVienDAO.delete(hocVien.getMaHV());
    }

    @Test(priority = 1)
    public void testInsert() {
        HocVien expectedHocVien = new HocVien();
        expectedHocVien.setMaHV(100);
        expectedHocVien.setMaKH(2);
        expectedHocVien.setMaNH("NH02");
        expectedHocVien.setDiem(8.0);
        hocVienDAO.insert(expectedHocVien);

        HocVien actualHocVien = hocVienDAO.findById(expectedHocVien.getMaHV());
        assertEquals(actualHocVien, expectedHocVien);
    }

    @Test(priority = 2)
    public void testUpdate() {
        hocVien.setMaKH(2);
        hocVien.setMaNH("NH02");
        hocVien.setDiem(8.0);
        hocVienDAO.update(hocVien);

        HocVien actualHocVien = hocVienDAO.findById(hocVien.getMaHV());
        assertEquals(actualHocVien, hocVien);
    }

    @Test(priority = 3)
    public void testDelete() {
        HocVien expectedHocVien = new HocVien();
        expectedHocVien.setMaHV(3);
        expectedHocVien.setMaKH(3);
        expectedHocVien.setMaNH("NH03");
        expectedHocVien.setDiem(7.5);
        hocVienDAO.insert(expectedHocVien);

        hocVienDAO.delete(expectedHocVien.getMaHV());

        HocVien actualHocVien = hocVienDAO.findById(expectedHocVien.getMaHV());
        assertNull(actualHocVien);
    }

    @Test(priority = 4)
    public void testSelect() {
        List<HocVien> actualList = hocVienDAO.select();
        assertEquals(actualList.size(), 1);
        assertEquals(actualList.get(0), hocVien);
    }

    @Test(priority = 5)
    public void testFindById() {
        HocVien actualHocVien = hocVienDAO.findById(hocVien.getMaHV());
        assertEquals(actualHocVien, hocVien);
    }
}
