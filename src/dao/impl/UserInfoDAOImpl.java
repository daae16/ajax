package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.apache.catalina.connector.Connector;

import common.Conn;
import dao.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO {
	Connection con = null;
	PreparedStatement ps = null;
	int result = 0;

	public int insertUserInfo(Map<String, Object> ui) {
		try {
			con = Conn.open();
			String sql = "insert into user_info(";
			sql += "UI_NAME\r\n";
			sql += "UI_AGE\r\n";
			sql += "UI_BIRTH\r\n";
			sql += "UI_ID\r\n";
			sql += "UI_PASSWORD\r\n";
			sql += "UI_PHONE\r\n";
			sql += "UI_EMAIL\r\n";
			sql += "UI_CREDAT\r\n";
			sql += "UI_NICKNAME)";
			sql += " values(seq_ui_num.nextval, ?,?,?,?,?,?,?,sysdata,?)";
			ps.setString(1, ui.get("ui_name").toString());
			ps.setInt(2, (int)ui.get("ui_age"));
			ps.setString(3, ui.get("ui_birth").toString());
			ps.setString(4, ui.get("ui_id").toString());
			ps.setString(5, ui.get("ui_name").toString());
			ps.setString(6, ui.get("ui_name").toString());
			ps.setString(7, ui.get("ui_name").toString());
			ps.setString(8, ui.get("ui_name").toString());
			
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int UpdateUserInfo(Map<String, Object> ui) {
		
		try {
			con = Conn.open();
		
		String sql = "Update user_info set " ;
			 sql+= "ui_name=? ui_age=?, ui_birth=?, ui_id, ui_password,";
		     sql+= "ui_phone=?, ui_nickname=? where ";
				
		
		}
		return 0;
	}

	@Override
	public int deleteUserInfo(Map<String, Object> ui) {
		return 0;
	}

	@Override
	public Map<String, Object> selectUserInfoList(Map<String, Object> ui) {
		return null;
	}

}
