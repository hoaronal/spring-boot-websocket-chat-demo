package com.example.websocketdemo.web.form;


import com.example.websocketdemo.web.form.validator.Phone;

import javax.validation.constraints.*;


public class Customer {

    @Size(min=2, max=30)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Min(18)
    @Max(100)
    private Integer age;

    @Phone(message = "Số điện thoại không hợp lệ!")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    public Integer getAge() {
        return age;
    }

    public void setAge(@NotNull Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}