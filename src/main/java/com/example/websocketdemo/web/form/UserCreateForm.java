package com.example.websocketdemo.web.form;

import com.example.websocketdemo.common.constant.Constants;
import com.example.websocketdemo.web.form.validator.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;


@FieldMatch.List({
        @FieldMatch(first = "loginPassword", second = "reLoginPassword", message = "The password fields must match")
})
public class UserCreateForm implements Serializable {

    @Size(min = 6, message = "Tài khoản tối thiểu 6 kí tự!")
    private String loginId;

    @Size(min = 8, message = "Mật khẩu đăng nhập tối thiểu 8 kí tự!")
    private String loginPassword;

    private String reLoginPassword;

    @Email(regexp = Constants.EMAIL_PATTERN, message = "Email không đúng định dạng!")
    private String email;

    /*@NotNull
    @Size(min=8, max=25)
    private String password;

    @NotNull
    @Size(min=8, max=25)
    private String confirmPassword;*/



    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getReLoginPassword() {
        return reLoginPassword;
    }

    public void setReLoginPassword(String reLoginPassword) {
        this.reLoginPassword = reLoginPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}