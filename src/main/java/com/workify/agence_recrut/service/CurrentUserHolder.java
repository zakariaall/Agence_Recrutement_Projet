package com.workify.agence_recrut.service;
import com.workify.agence_recrut.entites.Users;
import org.springframework.stereotype.Component;

@Component
public class CurrentUserHolder {
    private static final ThreadLocal<Users> currentUser = new ThreadLocal<>();

    public void setCurrentUser(Users user) {
        currentUser.set(user);
    }

    public Users getCurrentUser() {
        return currentUser.get();
    }

    public void clear() {
        currentUser.remove();
    }
}
