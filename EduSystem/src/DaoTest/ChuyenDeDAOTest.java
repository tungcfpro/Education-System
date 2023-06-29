package DaoTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DAO.ChuyenDeDAO;
import Model.ChuyenDe;

public class ChuyenDeDAOTest {

    private ChuyenDeDAO chuyenDeDAO;
    private ChuyenDe chuyenDe;

    @BeforeClass
    public void setUp() {
        chuyenDeDAO = new ChuyenDeDAO();
        chuyenDe = new ChuyenDe();
        chuyenDe.setMaCD("CD001");
        chuyenDe.setTenCD("Chuyen de Test");
        chuyenDe.setHocPhi(1000000);
        chuyenDe.setThoiLuong(24);
        chuyenDe.setHinh("hinhtest.jpg");
        chuyenDe.setMoTa("Mo ta test");
    }

    @AfterClass
    public void tearDown() {
        chuyenDeDAO.delete(chuyenDe.getMaCD());
    }

    @Test(priority = 1)
    public void testInsert() {
        chuyenDeDAO.insert(chuyenDe);
        ChuyenDe insertedChuyenDe = chuyenDeDAO.findById(chuyenDe.getMaCD());
        Assert.assertEquals(chuyenDe.getTenCD(), insertedChuyenDe.getTenCD());
        Assert.assertEquals(chuyenDe.getHocPhi(), insertedChuyenDe.getHocPhi());
        Assert.assertEquals(chuyenDe.getThoiLuong(), insertedChuyenDe.getThoiLuong());
        Assert.assertEquals(chuyenDe.getHinh(), insertedChuyenDe.getHinh());
        Assert.assertEquals(chuyenDe.getMoTa(), insertedChuyenDe.getMoTa());
    }

    @Test(priority = 2)
    public void testUpdate() {
        chuyenDe.setTenCD("Chuyen de Test Update");
        chuyenDeDAO.update(chuyenDe);
        ChuyenDe updatedChuyenDe = chuyenDeDAO.findById(chuyenDe.getMaCD());
        Assert.assertEquals(chuyenDe.getTenCD(), updatedChuyenDe.getTenCD());
    }

    @Test(priority = 3)
    public void testDelete() {
        chuyenDeDAO.delete(chuyenDe.getMaCD());
        ChuyenDe deletedChuyenDe = chuyenDeDAO.findById(chuyenDe.getMaCD());
        Assert.assertNull(deletedChuyenDe);
    }

    @Test(priority = 4)
    public void testSelect() {
        chuyenDeDAO.insert(chuyenDe);
        Assert.assertTrue(chuyenDeDAO.select().size() > 0);
    }

    @Test(priority = 5)
    public void testFindById() {
        chuyenDeDAO.insert(chuyenDe);
        ChuyenDe foundChuyenDe = chuyenDeDAO.findById(chuyenDe.getMaCD());
        Assert.assertEquals(chuyenDe.getTenCD(), foundChuyenDe.getTenCD());
        Assert.assertEquals(chuyenDe.getHocPhi(), foundChuyenDe.getHocPhi());
        Assert.assertEquals(chuyenDe.getThoiLuong(), foundChuyenDe.getThoiLuong());
        Assert.assertEquals(chuyenDe.getHinh(), foundChuyenDe.getHinh());
        Assert.assertEquals(chuyenDe.getMoTa(), foundChuyenDe.getMoTa());
    }
}