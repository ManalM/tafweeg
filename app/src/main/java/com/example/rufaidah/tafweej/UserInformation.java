package com.example.rufaidah.tafweej;

public class UserInformation {
    public String userId;
    public String gid;
    public String email;
    public  String oname;
    public String password;
    public String mobile;
    public String gname;


    public UserInformation(String userId, String gid , String email, String oname, String gname, String password, String mobile ) {
        this.email = email;
        this.oname = oname;
        this.gname = gname;
        this.password = password;
        this.mobile = mobile;
        this.userId = userId;
        this.gid = gid;
    }
}
