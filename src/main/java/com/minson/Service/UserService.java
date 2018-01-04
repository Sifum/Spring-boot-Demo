package com.minson.Service;

import com.minson.repository.UserRepository;
import com.minson.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pocan on 2018/1/3.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByName(String name){
        User user = null;
        try{
            user = userRepository.findByUserName(name);
        }catch (Exception e){}
        return user;
    }
}
