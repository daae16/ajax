package dao;


import java.util.*;

public interface UserInfoDAO {
	int insertUserInfo(Map<String,Object> ui);
	int UpdateUserInfo(Map<String,Object> ui);
	int deleteUserInfo(Map<String,Object> ui);
	Map<String,Object> selectUserInfoList (Map<String,Object> ui);
	

}
