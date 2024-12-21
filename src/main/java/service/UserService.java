package service;
import com.workify.agence_recrut.entites.Users;
import repository.UsersRepository;

public class UserService {
    private UsersRepository userRepository;

    public Users login(String email, String password){

        Users user = userRepository.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("Utilisateur non trouvé !");
        }
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Mot de passe incorrect !");
        }
        return user;
    }


}
