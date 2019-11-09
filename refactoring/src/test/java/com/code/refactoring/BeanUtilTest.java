package com.code.refactoring;

import com.code.refactoring.重构demo.demo01.重构后.User;
import com.code.refactoring.重构demo.demo01.重构后.UserInputDTO;
import org.junit.Test;

/**
 * <Description>
 *
 * @author wangxi
 */
public class BeanUtilTest {
    @Test
    public void test01() {
        UserInputDTO userInputDTO = new UserInputDTO("wangxi", 20);
        User user = userInputDTO.convertToUser();
        System.out.println(user);

    }
}

