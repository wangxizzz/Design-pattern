package com.code.refactoring.demo01.重构后;

import org.springframework.stereotype.Component;

/**
 * <Description>
 *
 * @author wangxi
 */
@Component
public class UserService {
    public User addUser(User user) {
        return user;
    }
}

