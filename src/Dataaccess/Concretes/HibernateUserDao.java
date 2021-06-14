package Dataaccess.Concretes;

import Dataaccess.Abstracts.UserDao;
import Entities.Concretes.User;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserDao implements UserDao {
    List<User> users=new ArrayList<User>();
    @Override
    public void register(User user) {
        System.out.println(user.getName()+"İsimli kullanıcı başarılı bir şekilde kaydoldu ");
        users.add(user);
    }

    @Override
    public void login(User user) {
    System.out.println(user.getName()+" adlı kullanıcı giriş yaptı.");
    }

    @Override
    public void confirm(User user) {
        System.out.println(user.getEmail()+"email afresiniz onaylanmıştır.");
    user.setVerify(true);

    }

    @Override
    public List<User> getAll() {
        return this.users;
    }
}
