package com.proj.api.auth.controller;
/**
 * author:Jerry
 */
import com.proj.api.database.RelationalDatabase;
import com.proj.api.exception.database.NonRelationalDatabaseException;
import com.proj.api.exception.database.RelationalDatabaseException;
import com.proj.api.exception.other.InvalidCheckCodeException;
import com.proj.api.exception.auth.*;
import com.proj.api.exception.other.InvalidParamsException;
import com.proj.api.exception.utils.MalformedJsonException;
import com.proj.api.utils.AuthorizationUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUserInfo {
    private String sUserId;
    private String sUserName;
    private String sPhoneNum;
    private int iType;
    private int iAuthority;
    private int iStatus;
    private String sCheckCode;

    public LoginUserInfo(String login_id, String check_code) throws RelationalDatabaseException, InvalidOperationException, UserNotAuthorizedException, UserDisableException, NonRelationalDatabaseException, MalformedJsonException, InvalidCheckCodeException, UserNotExistException, InvalidBackstageOperationException, InvalidParamsException {
        if(login_id==null||login_id==""){
            throw new InvalidParamsException();
        }
        if(check_code==null||check_code==""){
            throw new InvalidParamsException();
        }
        AuthorizationUtils authorizationUtils = new AuthorizationUtils(login_id);
        authorizationUtils.checkParams(login_id, check_code);
        this.sUserId = authorizationUtils.getsId();
        this.sUserName = authorizationUtils.getsUserName();
        this.sPhoneNum = authorizationUtils.getsPhoneNum();
        this.iType = authorizationUtils.getiType();
        this.iAuthority = authorizationUtils.getiAuthority();
        this.iStatus = authorizationUtils.getiStatus();
        this.sCheckCode = authorizationUtils.getCheckCode(
                String.valueOf(iAuthority) +
                sPhoneNum +
                String.valueOf(iStatus) +
                String.valueOf(iType) +
                sUserId +
                sUserName
        );
    }

    public String getsUserId() {
        return sUserId;
    }

    public String getsUserName() {
        return sUserName;
    }

    public String getsPhoneNum() {
        return sPhoneNum;
    }

    public int getiType() {
        return iType;
    }

    public int getiAuthority() {
        return iAuthority;
    }

    public int getiStatus() {
        return iStatus;
    }

    public String getsCheckCode() {
        return sCheckCode;
    }
}