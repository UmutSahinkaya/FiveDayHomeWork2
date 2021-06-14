package Business.Concretes;

import Business.Abstracts.UserService;
import Core.AuthService;
import Dataaccess.Abstracts.UserDao;
import Entities.Concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {
    private UserDao userdao;
    private AuthService authService;

    public UserManager(UserDao userdao,AuthService authService) {
        this.userdao = userdao;
        this.authService=authService;
    }

    @Override
    public void register(User user) {
        if(user.getPassword().length()<=6){
            System.out.println("Şifre en az 6 karakterden oluşmalıdır! ");
        }
        final String EMAIL_PATTERN="^[A-Za-z0-9+_.-]+@(.+)$";
        final Pattern pattern= Pattern.compile(EMAIL_PATTERN);
        Matcher matcher= pattern.matcher(user.getEmail());
        if(!matcher.matches()){
            System.out.println(user.getEmail()+"Bu Email formata uygun değil");
        }
        for(User users:userdao.getAll()){
            if(users.getEmail().equals(user.getEmail())){
                System.out.println(user.getEmail()+"bu e-posta daha önceden kullanılmış");
            }
        }
        if(user.getName().length()<2 && user.getSurname().length()<2){
            System.out.println("Ad-Soyad en az 2 karakterden oluşmalıdır");
        }


    }

    @Override
    public void login(User user) {
    if(user.isVerify()==true){
        userdao.login(user);
    }else{
        System.out.println("giriş başarısız. E-Mail adresinizi kontrol ediniz.");
    }
    }

    @Override
    public void confirm(User user) {
    if(user.isVerify()==true){
        userdao.confirm(user);
        System.out.println("Sayın "+user.getName()+" "+user.getSurname()+" e-posta adresiniz doğrulanmıştır.");
    }else{
        System.out.println("Sayın "+user.getName()+" "+user.getSurname()+" e-posta adresiniz doğrulanamamıştır.");
    }
    }

    @Override
    public void registerWithAccount(User user) {
    user.setVerify(true);
    this.authService.register(user);
    }

    @Override
    public void loginWithAccount(User user) {
        if(user.isVerify()==true){
            this.authService.login(user);
        }else{
            System.out.println("Henüz kayıt olunmamış.");
        }

    }
}
