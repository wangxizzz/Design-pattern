package com.code.refactoring.demo.demo01.重构后;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * <Description>
 *
 * @author wangxi
 */
@RequestMapping("/v1/api/")
@RestController
@Validated
public class UserApiController {
    @Autowired
    private UserService userService;

    /**
     *
     * @param userInputDTO 表示前端封装的User
     * @return
     */
    @PostMapping("user")
    public User addUser(@Valid UserInputDTO userInputDTO, BindingResult bindingResult){
        // bindingResult 是Spring MVC 验证 DTO 后的一个结果集，
        // 如果@Valid验证参数不合法，那么就全部记载到bindingResult中
        if(!checkDTOParams(bindingResult)) {
            return null;
        }
        checkDTOParams(bindingResult);
        User user = userInputDTO.convertToUser();
        return userService.addUser(user);
    }

    // 测试@RequestParam的参数validator
    // 注意：在@RequestParam进行validator时是没有bindingResult.
    @GetMapping("user1")
    public String fun(@NotBlank(message = "username不能为空！") @RequestParam String username) {
        return username;
    }


    private boolean checkDTOParams(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //throw new 带验证码的验证错误异常(注意配置了快速失败的validation)
            for (ObjectError error : bindingResult.getAllErrors()) {
                // 打印错误日志
                System.out.println(error.getDefaultMessage());
            }
            return false;
        }
        return true;
    }
}

