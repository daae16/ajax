package service.Impl;

import java.util.HashMap;
import java.util.Map;

import dao.impl.UserInfoDAOImpl;
import service.UserService;

public class UserServiceImpl implements UserService{
	private UserInfoDAOImpl uiDao = new UserInfoDAOImpl();
	public Map<String, Object> doLogin(Map<String, String> user) {
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("result", "fail");
		rMap.put("msg", "아이디를 확인해주세요");
		String uiId = user.get("ui_id");
		Map<String,Object> tmpUser = uiDao.selectUserInfoByUiId(uiId);
	    if(tmpUser!=null) {
	    	String tmpUiPwd = tmpUser.get("ui_password").toString();
	    	String uiPwd = user.get("ui_password");
	    	rMap.put("result","fail");
	    	rMap.put("msg","비밀번호를 확인 해주세요");
	    	if(tmpUiPwd.equals(uiPwd)) {
	    		rMap.put("result","ok");
	    		rMap.put("msg","로그인 완료");
	    		rMap.put("user",tmpUser);
	    		
	    	}
	    }
		return rMap;
	}

	public Map<String, Object> joinUserInfo(Map<String, Object> user) {
		int result = uiDao.insertUserInfo(user);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("result", result);
		rMap.put("msg","가입실패");
		rMap.put("url", "/views/user/login");
		if(result==1) {
			rMap.put("msg", "가입성공");
			rMap.put("url", "/views/user/login");
		}
		return rMap;
	}

	public Map<String, String> checkId(String uiId) {
		Map<String,String> rMap = new HashMap<>();
		rMap.put("msg","이미 있는 아이디입니다.");
		rMap.put("result","flase");
		if(uiDao.selectUserInfoByUiId(uiId)==null) {
			rMap.put("msg","가입이 가능한 아이디입니다.");
			rMap.put("result", "ture");
			
		}
		return rMap;
	}

}


