package com.Tamazj.TamazjApp.Model;

import com.Tamazj.TamazjApp.Activity.SignUpActivity;

public interface AppConstants {
    String KEY_SIGN_UP = "KEY_SIGN_UP";
    String EMAIL = "EMAIL";
    String PASSWORD = "PASSWORD";
    String ACCOUNT_TYPE = "ACCOUNT_TYPE";
    String Beneficiary = "Beneficiary";
    String Advisor = "Advisor";
    String HAPPY = "HAPPY";
    String SATISFIED = "SATISFIED";
    String NOT_SATISFIED = "NOT_SATISFIED";
    String CONSULT_TYPE = "CONSULT_TYPE";
    String SESSION_TYPE = "SESSION_TYPE";
    String FIRST_SESSION = "FIRST_SESSION";
    String SECOND_SESSION = "SECOND_SESSION";
    String THIRD_SESSION = "THIRD_SESSION";
    String SPECIAL_SESSION = "SPECIAL_SESSION";
    String toolbartiltle = "toolbartiltle";
    String ADVISORS_CONSULTANTS = "ADVISORS_CONSULTANTS";
    String ACTIVE = "الحساب مفعل ";
    String NOT_ACTIVE = "الحساب غير مفعل";
    
    //-----------------------------APIs-------------------------------------------------------------

    String USER_REGISTER = "http://salahalimohamed.website/tmajog/api/v1/user/register";
    String ISLOGIN = "ISLOGIN";
    String USER_LOGIN = "http://salahalimohamed.website/tmajog/api/v1/user/login";
    String activateCode = "http://salahalimohamed.website/tmajog/api/v1/user/activateCode";
    String token = "token";
    String USER_LOGOUT = "http://salahalimohamed.website/tmajog/api/v1/user/logout";
    String resetPass ="http://salahalimohamed.website/tmajog/api/v1/user/resetPass" ;
    String USER_PROFILE="http://salahalimohamed.website/tmajog/api/v1/user/profile";
    String updateProfile="http://salahalimohamed.website/tmajog/api/v1/user/updateProfile";
    String resetCode="http://salahalimohamed.website/tmajog/api/v1/user/resetCode";

    //----------------------------------------------------------------------------------------------
}
