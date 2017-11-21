package com.proj.api.user.gson;
/**
 *author:Jerry
 */

import com.proj.api.exception.error.Reason;

public class InformationCheckRetGson {
    private int err_code=0;
    private String reason= Reason.getReason(0);
    private InnerData data;
    private String check_code;
    public InformationCheckRetGson(String user_id,String username,String phone_num,int type,int authority,int status,String check_code) {
        this.data=new InnerData(user_id,username,phone_num,type,authority,status);
        this.check_code=check_code;
    }

    public int getErr_code() {
        return err_code;
    }

    public String getReason() {
        return reason;
    }

    public InnerData getData() {
        return data;
    }

    public String getCheck_code() {
        return check_code;
    }

    public class InnerData{
        String user_id;
        String username;
        String phone_num;
        int type;
        int authority;
        int status;

        public InnerData(String user_id,String username,String phone_num,int type,int authority,int status) {
            this.user_id = user_id;
            this.username = username;
            this.phone_num = phone_num;
            this.type = type;
            this.authority = authority;
            this.status = status;
        }

        public String getUser_id() {
            return user_id;
        }

        public String getUsername() {
            return username;
        }

        public String getPhone_num() {
            return phone_num;
        }

        public int getType() {
            return type;
        }

        public int getAuthority() {
            return authority;
        }

        public int getStatus() {
            return status;
        }
    }
}
