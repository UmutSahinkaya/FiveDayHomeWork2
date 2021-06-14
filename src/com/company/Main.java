package com.company;

import AppleAuth.AppleAuthManager;
import Business.Abstracts.UserService;
import Business.Concretes.UserManager;
import Core.AppleAuthManagerAdapter;
import Dataaccess.Concretes.HibernateUserDao;
import Entities.Concretes.User;

public class Main {

    public static void main(String[] args) {
        //UserService userService=new UserManager(new HibernateUserDao(),new GoogleAuthManagerAdapter(new GoogleAuthManager()));
        UserService userService=new UserManager(new HibernateUserDao(),new AppleAuthManagerAdapter(new AppleAuthManager()));
        User user=new User("Umut","Şahinkaya","umutsahinkaya1@gmail.com","123456",true);
        User user1=new User("Nihan","Şahin","nihan1234@gmail.com","123321",true);
        userService.register(user);
        userService.login(user);
        userService.confirm(user);
        userService.registerWithAccount(user1);
        userService.loginWithAccount(user1);
    }
}
