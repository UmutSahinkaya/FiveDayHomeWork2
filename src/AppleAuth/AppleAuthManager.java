package AppleAuth;

import Entities.Concretes.User;

public class AppleAuthManager {
    public void register(User user){
        System.out.println("Sayın "+user.getName()+" "+user.getSurname()+" Apple adresiniz doğrulanmıştır.");
    }

    public void login(User user) {
        System.out.println("Sayın "+user.getName()+" "+user.getSurname()+"apple hesabınız giriş yaptınız.");
    }
}
