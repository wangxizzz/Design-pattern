package com.code.refactoring.demo03;

import com.code.refactoring.demo01.重构后.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <Description>
 *
 * @author wangxi
 */
public class UserService03 {
    private User[] getUsersFromDatabase(){return null;};  // 测试使用

    public List<User> getUsers() {
        User[] usersFromDb = getUsersFromDatabase();
        if (usersFromDb == null) {
            // No users found in database
            return Collections.emptyList();
            // 或者返回 return new ArrayList<>();
        }
        else {
            return Arrays.asList(usersFromDb);
        }
    }

    public static void main(String[] args) {
        UserService03 service = new UserService03();
        List<User> users = service.getUsers();
        for (User user: users) {
            System.out.println("User found: " + user.getUsername());
        }
    }
}

