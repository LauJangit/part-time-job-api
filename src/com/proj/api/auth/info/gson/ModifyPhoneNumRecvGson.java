package com.proj.api.auth.info.gson;

/**
 * Created by jangitlau on 2017/12/6.
 */
public class ModifyPhoneNumRecvGson {
    private String login_id;
    private String phone_checkcode;
    private String check_code;

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getPhone_checkcode() {
        return phone_checkcode;
    }

    public void setPhone_checkcode(String phone_checkcode) {
        this.phone_checkcode = phone_checkcode;
    }

    public String getCheck_code() {
        return check_code;
    }

    public void setCheck_code(String check_code) {
        this.check_code = check_code;
    }
}
