package com.nlobo.uploadtos3.services;

import com.nlobo.uploadtos3.models.LoginUser;
import com.nlobo.uploadtos3.models.RegisterUser;
import com.nlobo.uploadtos3.models.User;
import com.nlobo.uploadtos3.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(RegisterUser registerUser, BindingResult bindingResult) {
        Optional<User> optionalUser = this.userRepository.findByEmail(registerUser.getEmail());

        // check if user email in database already
        if (optionalUser.isPresent()) {
            // email is already in database - reject value
            bindingResult.rejectValue("email", "email.exists", "Email already exists.");
        }

        // check if passwords match
        if (!registerUser.getPassword().equals(registerUser.getConfirm())) {
            // passwords don't match - reject value
            bindingResult.rejectValue("confirm", "password.not.match", "Passwords do not match.");
        }

        if (bindingResult.hasErrors()) {
            return null;
        }

        // hash password
        String hashedPassword = BCrypt.hashpw(registerUser.getPassword(), BCrypt.gensalt());
        registerUser.setPassword(hashedPassword);

        User user = new User();
        user.setUsername(registerUser.getUsername());
        user.setEmail(registerUser.getEmail());
        user.setPassword(hashedPassword);
        return this.userRepository.save(user);
    }

    public User login(LoginUser loginUser, BindingResult bindingResult) {
        Optional<User> optionalUser = this.userRepository.findByEmail(loginUser.getLoginEmail());

        // check if user email exists
        if (optionalUser.isEmpty()) {
            // user email does not exist - reject value
            bindingResult.rejectValue("loginEmail", "email.not-found", "Email does not exist.");
            return null;
        }

        // check if password is correct
        User user = optionalUser.get();
        if (!BCrypt.checkpw(loginUser.getLoginPassword(), user.getPassword())) {
            // password is incorrect - reject value
            bindingResult.rejectValue("loginPassword", "password.invalid", "Password incorrect.");
            return null;
        }

        // all is well, return user
        return user;
    }

    public User findById(Long id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public User updateAvatarUrl(Long userId, String avatarUrl) {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return null;
        }

        User userToUpdate = optionalUser.get();
        userToUpdate.setAvatarUrl(avatarUrl);
        return userRepository.save(userToUpdate);
    }
}
