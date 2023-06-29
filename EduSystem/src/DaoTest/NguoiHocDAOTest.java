package DaoTest;
import static org.testng.Assert.*;
import org.testng.annotations.*;

import DAO.NguoiHocDAO;
import Model.NguoiHoc;

import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NguoiHocDAOTest {
    private NguoiHocDAO nguoiHocDAO;
    private Connection conn;

    public static Date parse(String dateString) {
        try {
            return (Date) new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    

    @Test(priority = 1)
    public void testInsert() throws SQLException {
        NguoiHoc nguoiHoc = new NguoiHoc();
        nguoiHocDAO.insert(nguoiHoc);
        PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM NguoiHoc WHERE MaNH = ?");
        ps.setString(1, "NH001");
        ResultSet rs = ps.executeQuery();
        assertTrue(rs.next());
        assertEquals(rs.getInt(1), 1);
    }

    @Test(priority = 2)
    public void testUpdate() throws SQLException {
        NguoiHoc nguoiHoc = new NguoiHoc();
        nguoiHocDAO.insert(nguoiHoc);
        nguoiHoc.setHoTen("Nguyen Van B");
        nguoiHocDAO.update(nguoiHoc);
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM NguoiHoc WHERE MaNH = ?");
        ps.setString(1, "NH001");
        ResultSet rs = ps.executeQuery();
        assertTrue(rs.next());
        assertEquals(rs.getString("HoTen"), "Nguyen Van B");
    }

    @Test(priority = 3)
    public void testDelete() throws SQLException {
        NguoiHoc nguoiHoc = new NguoiHoc();
        nguoiHocDAO.insert(nguoiHoc);
        nguoiHocDAO.delete("NH001");
        PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM NguoiHoc WHERE MaNH = ?");
        ps.setString(1, "NH001");
        ResultSet rs = ps.executeQuery();
        assertTrue(rs.next());
        
    }
}

