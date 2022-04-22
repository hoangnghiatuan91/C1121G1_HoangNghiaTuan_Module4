package com.casestudy.service.impl.user;

import com.casestudy.model.user.User;
import com.casestudy.repository.user.IUserRepository;
import com.casestudy.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void remove(Long id) {

    }
}
