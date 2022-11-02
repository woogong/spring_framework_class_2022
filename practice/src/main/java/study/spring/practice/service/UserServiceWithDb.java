package study.spring.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import study.spring.practice.domain.User;
import study.spring.practice.entity.UserEntity;
import study.spring.practice.repository.UserRepository;

import java.util.Date;
import java.util.Optional;

@Service(value = "userService")
public class UserServiceWithDb implements UserService {
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User read(Long userIdx) {
        Optional<UserEntity> optional = userRepository.findById(userIdx);
        if (optional.isPresent()) {
            return User.build(optional.get());
        } else {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }
    }

    @Override
    public User read(String email) {
        Optional<UserEntity> optional = userRepository.findByEmail(email);
        if (optional.isPresent()) {
            return User.build(optional.get());
        } else {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }
    }

    @Override
    public User register(User user) {
        UserEntity entity = UserEntity.build(user);
        entity.setRegisterTime(new Date());
        entity.setPassword(passwordEncoder.encode(user.getPassword()));
        entity.setWithdrawed(false);

        userRepository.save(entity);

        return read(entity.getUserIdx());
    }
}
