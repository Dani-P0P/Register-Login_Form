package com.example.loginform.dbRunTime;

import com.example.loginform.model.User;

import java.util.Vector;

public class Users {
    private Vector<User> users;

    public Users() {
        this.users = new Vector<>();
    }


    public void addUser(User user) {
        this.users.add(user);
    }

    public boolean findUser(User user) {
        for (User iterator : users) {
            if (iterator.getUsername().equals(user.getUsername()) &&
                    iterator.getPass().equals(user.getPass()))
                return true;
        }
        return false;
    }

    public User findUserByUsername(String username) {
        for (User iterator : users) {
            if (iterator.getUsername().equals(username))
                return iterator;
        }
        return null;
    }
}
