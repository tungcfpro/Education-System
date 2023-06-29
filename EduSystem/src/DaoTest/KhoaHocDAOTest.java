package DaoTest;

import static org.testng.AssertJUnit.assertNull;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import DAO.KhoaHocDAO;
import Model.KhoaHoc;

import static org.testng.Assert.assertEquals;

import java.util.Date;
import java.util.List;

@Test
public class KhoaHocDAOTest {
    KhoaHocDAO khoaHocDAO = new KhoaHocDAO();

    @Test(priority = 1)
    public void testInsert() {
        // Tạo mới một khóa học
        KhoaHoc khoaHoc = new KhoaHoc();
        khoaHoc.setMaCD("CD100");
        khoaHoc.setHocPhi(1000000);
        khoaHoc.setThoiLuong(24);
        khoaHoc.setNgayKG(new Date());
        khoaHoc.setGhiChu("Khóa học mới");
        khoaHoc.setMaNV("NV01");

        // Thêm khóa học vào cơ sở dữ liệu
        khoaHocDAO.insert(khoaHoc);

        // Kiểm tra xem khóa học đã được thêm vào cơ sở dữ liệu chưa
        KhoaHoc insertedKhoaHoc = khoaHocDAO.findById(khoaHoc.getMaKH());
        AssertJUnit.assertEquals(khoaHoc, insertedKhoaHoc);
    }
    
    @Test(priority = 2)
    public void testUpdate() {
        System.out.println("update");
        // Tạo một đối tượng KhoaHoc và lưu giữ thông tin cũ của nó
        KhoaHocDAO instance = new KhoaHocDAO();
        KhoaHoc kh = new KhoaHoc();
        kh.setMaKH(1);
        kh.setMaCD("CD02");
        kh.setHocPhi(5000000);
        kh.setThoiLuong(30);
        kh.setNgayKG(new Date());
        kh.setGhiChu("Khóa học mới");

        // Thay đổi một số thông tin của đối tượng KhoaHoc
        String newMaCD = "CD03";
        kh.setMaCD(newMaCD);

        // Gọi phương thức update để cập nhật thông tin của đối tượng KhoaHoc trong CSDL
        instance.update(kh);

        // Lấy lại thông tin của đối tượng KhoaHoc từ CSDL
        KhoaHoc updatedKH = instance.findById(kh.getMaKH());

        // So sánh thông tin mới của đối tượng KhoaHoc với thông tin trong CSDL
        AssertJUnit.assertEquals(newMaCD, updatedKH.getMaCD());
    }
    @Test(priority = 3)
    public void testDelete() {
        KhoaHocDAO khoaHocDAO = new KhoaHocDAO();
        
        // Tạo mới một khóa học
        KhoaHoc khoaHoc = new KhoaHoc();
        khoaHoc.setMaKH(1);
        khoaHoc.setMaCD("CD100");
        khoaHoc.setHocPhi(1000000);
        khoaHoc.setThoiLuong(30);
//        khoaHoc.setNgayKG(Date.valueOf("2023-04-07"));
        khoaHoc.setGhiChu("Khóa học lập trình Java căn bản");
        khoaHoc.setMaNV("NV001");
        khoaHocDAO.insert(khoaHoc);
        
        // Xóa khóa học
        khoaHocDAO.delete(khoaHoc.getMaKH());
        
        // Kiểm tra xem khóa học đã được xóa chưa
        assertNull(khoaHocDAO.findById(khoaHoc.getMaKH()));
    }
    





    @Test(priority = 4)
    public void testFindByIdWithInvalidId() {
        // Arrange
        KhoaHocDAO dao = new KhoaHocDAO();
        KhoaHoc expected = new KhoaHoc();
        expected.setMaKH(1);
        expected.setMaCD("CD100");
        expected.setHocPhi(10000000);
        expected.setThoiLuong(48);
        expected.setNgayKG(new Date(12122023));
        expected.setGhiChu(null);
        expected.setMaNV("NV001");
        expected.setNgayKG(new Date(12334455));
        // Act
        KhoaHoc result = dao.findById(1000);
        
        // Assert
        assertEquals(expected, result);
    }

    @Test(priority = 4)
    public void testFindByIdWithInvalidId2() {
        // Arrange
        KhoaHocDAO dao = new KhoaHocDAO();
        
        // Act
        KhoaHoc result = dao.findById(1000);
        
        // Assert
        assertNull(result);
    }


}