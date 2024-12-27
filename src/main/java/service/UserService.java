package service;
import com.workify.agence_recrut.entites.Users;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UsersRepository;

@Service
@Transactional

public class UserService {
    @Autowired
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
