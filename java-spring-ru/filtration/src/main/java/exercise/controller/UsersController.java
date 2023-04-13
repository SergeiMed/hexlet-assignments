package exercise.controller;
import exercise.model.User;
import exercise.model.QUser;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// Зависимости для самостоятельной работы
// import org.springframework.data.querydsl.binding.QuerydslPredicate;
// import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    // BEGIN
    @GetMapping(path = "")
    public Iterable<User> findByParams(
            @RequestParam (required = false) String firstName,
            @RequestParam (required = false) String lastName) {
        if (firstName != null && lastName == null) {
            return this.userRepository.findAll(
                    QUser.user.firstName.containsIgnoreCase(firstName)
            );
        } else if (firstName == null && lastName != null) {
            return this.userRepository.findAll(
                    QUser.user.lastName.containsIgnoreCase(lastName)
            );
        } else if (firstName != null && lastName != null) {
            return this.userRepository.findAll(
                    QUser.user.firstName.containsIgnoreCase(firstName)
                            .and(QUser.user.lastName.containsIgnoreCase(lastName))
            );
        }
        return this.userRepository.findAll();
    }
    // END
}

