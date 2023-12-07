package view;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBC_DangNhap;

public class QLBHDatabase{
	
	public QLBHDatabase() {
	}

	public static void HienThiBang() {
		try {
			Connection con;
			con = JDBC_DangNhap.getConnection();
			String sql = "select * from HangHoa";
			Statement statement= con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String maSanPham=rs.getString(1);
				String tenSanPham=rs.getString(2);
				String nhaSanXuat=rs.getString(3);
				int soLuong=rs.getInt(4);
				int gia=rs.getInt(5);
				Date ngaySanXuat = rs.getDate(6);
				Date hanSuDung = rs.getDate(7);
				model_HangHoaThanhToan.addRow(new Object[]{maSanPham, tenSanPham, nhaSanXuat, soLuong,gia,ngaySanXuat,hanSuDung});	
				
			}
			JDBC_DangNhap.closeConnection(con);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}
}
