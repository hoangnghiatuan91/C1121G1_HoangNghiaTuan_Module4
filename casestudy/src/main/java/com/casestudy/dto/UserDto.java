package com.casestudy.dto;

import com.casestudy.model.user.User;
import com.casestudy.service.user.IUserService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class UserDto implements Validator {

    private Long userId;
    @NotBlank(message = "Can not be null")
    private String userName;
    @NotBlank(message = "Can not be null")
    private String password;
    IUserService iUserService;

    private String currentPassword;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IUserService getiUserService() {
        return iUserService;
    }

    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String currentPassword = userDto.getCurrentPassword();
            User user = this.iUserService.findById(userDto.getUserId()).orElse(null);
            if(user!=null){
                if(user.getPassword().equals(userDto.getPassword()))
                    errors.rejectValue("currentPassword", "", "Wrong password");
            }
        }
}
