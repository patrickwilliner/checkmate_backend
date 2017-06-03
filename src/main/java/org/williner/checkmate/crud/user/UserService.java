package org.williner.checkmate.crud.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDO createUser(UserDO user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public UserDO getUser(Long id) {
        return userRepository.findOne(id);
    }
}
