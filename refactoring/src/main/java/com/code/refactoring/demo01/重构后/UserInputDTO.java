package com.code.refactoring.demo01.重构后;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <Description>
 *
 * @author wangxi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInputDTO {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotNull
    @Range(min = 1, max = 120, message = "年龄错误")    // 年龄1-120之间
    private int age;

    public User convertToUser() {
        DTOConvert<UserInputDTO, User> userInputDTO = new UserInputDTOConvert();
        return userInputDTO.convert(this);
    }

    private class UserInputDTOConvert implements DTOConvert<UserInputDTO, User> {
        @Override
        public User convert(UserInputDTO userInputDTO) {
            User user = new User();
            BeanUtils.copyProperties(userInputDTO, user);
            return user;
        }
    }
}

