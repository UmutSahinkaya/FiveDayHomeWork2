package GoogleAuth;

import Entities.Concretes.User;

public class GoogleAuthManager {
    public void register(User user){
        System.out.println("Sayın "+user.getName()+" "+user.getSurname()+" Google posta adresiniz doğrulanmıştır.");
    }

    public void login(User user) {
        System.out.println("Sayın "+user.getName()+" "+user.getSurname()+"Google hesabınızla giriş yaptınız.");
    }
}
