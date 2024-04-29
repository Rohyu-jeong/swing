package userInfo;

public class UserInfoManager {
	
    private static UserInfoManager instance;
    private UserInfo userInfo;

    public UserInfoManager() {
        userInfo = new UserInfo();
    }

    public static UserInfoManager getInstance() {
        if (instance == null) {
            instance = new UserInfoManager();
        }
        return instance;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

}
