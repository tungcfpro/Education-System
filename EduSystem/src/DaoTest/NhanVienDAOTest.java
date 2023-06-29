package DaoTest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import DAO.NhanVienDAO;
import Model.NhanVien;

public class NhanVienDAOTest {
    
    @Test(priority = 1)
    public void testInsert() {
        NhanVienDAO dao = new NhanVienDAO();
        NhanVien model = new NhanVien();
        model.setMaNV("NV001");
        model.setMatKhau("123456");
        model.setHoTen("Nguyen Van A");
        model.setVaiTro(false);
        
        dao.insert(model);
        
        NhanVien result = dao.findById("NV001");
        
        Assert.assertEquals(result.getMaNV(), "NV001");
        Assert.assertEquals(result.getMatKhau(), "123456");
        Assert.assertEquals(result.getHoTen(), "Nguyen Van A");
        Assert.assertEquals(result.getVaiTro(), false);
    }
    
    @Test(priority = 2)
    public void testUpdate() {
        NhanVienDAO dao = new NhanVienDAO();
        NhanVien model = new NhanVien();
        model.setMaNV("NV001");
        model.setMatKhau("654321");
        model.setHoTen("Nguyen Van B");
        model.setVaiTro(true);
        
        dao.update(model);
        
        NhanVien result = dao.findById("NV001");
        
        Assert.assertEquals(result.getMaNV(), "NV001");
        Assert.assertEquals(result.getMatKhau(), "654321");
        Assert.assertEquals(result.getHoTen(), "Nguyen Van B");
        Assert.assertEquals(result.getVaiTro(), true);
    }
    
    @Test(priority = 3)
    public void testDelete() {
        NhanVienDAO dao = new NhanVienDAO();
        dao.delete("NV001");
        NhanVien result = dao.findById("NV001");
        Assert.assertNull(result);
    }
    
    @Test(priority = 4)
    public void testFindById() {
        NhanVienDAO dao = new NhanVienDAO();
        NhanVien result = dao.findById("NV001");
        
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getMaNV(), "NV001");
        Assert.assertEquals(result.getMatKhau(), "654321");
        Assert.assertEquals(result.getHoTen(), "Nguyen Van B");
        Assert.assertEquals(result.getVaiTro(), true);
    }
    
    @Test(priority = 5)
    public void testSelect() {
        NhanVienDAO dao = new NhanVienDAO();
        List<NhanVien> result = dao.select();
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(result.get(0).getMaNV(), "NV001");
        Assert.assertEquals(result.get(0).getMatKhau(), "654321");
        Assert.assertEquals(result.get(0).getHoTen(), "Nguyen Van B");
        Assert.assertEquals(result.get(0).getVaiTro(), true);
    }
}
