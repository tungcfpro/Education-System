package HelperTest;

import static org.testng.Assert.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.annotations.Test;
import Helper.JdbcHelper;

public class JdbcHelperTest {

    @Test(priority = 1)
    public void testPrepareStatement() throws SQLException {
        String sql = "SELECT * FROM NguoiHoc WHERE MaNH = ?";
        JdbcHelper.prepareStatement(sql, 1);
        // Nếu không bị lỗi thì test case pass
        assertTrue(true);
    }

    @Test(priority = 2)
    public void testExecuteUpdate() {
        String sql = "INSERT INTO NguoiHoc((MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV,NgayDK) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] args = { 101, "Nguyễn Văn A", "2000-01-01", true,  "0987654321", "nva@gmail.com", null,"2023-01-01" };
        JdbcHelper.executeUpdate(sql, args);
        // Nếu không bị lỗi thì test case pass
        assertTrue(true);
    }

    @Test(priority = 3)
    public void testExecuteQuery() throws SQLException {
        String sql = "SELECT * FROM NguoiHoc WHERE MaNH = ?";
        ResultSet rs = JdbcHelper.executeQuery(sql, 1);
        if (rs.next()) {
            // Nếu có kết quả trả về thì test case pass
            assertTrue(true);
        } else {
            fail("Không có bản ghi nào được trả về");
        }
    }
}

