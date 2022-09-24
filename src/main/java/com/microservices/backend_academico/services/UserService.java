package com.microservices.backend_academico.services;

import com.microservices.backend_academico.models.UserModel;
import com.microservices.backend_academico.repositories.UserRepository;
import com.microservices.backend_academico.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserSession userSession;

    @Autowired
    UserRepository userRepository;

    public UserModel create(UserModel userModel){
        return userRepository.save(userModel);
    }

    public Boolean login(String username, String password){
        UserModel userModel = userRepository.login(username,password);

        if (userModel == null)
            return false;

        userSession.setAuth(true);

        return true;
    }

    public Boolean logout(){
        if (userSession.getAuth() == false || userSession.getAuth() == null)
            return false;
        else if(userSession.getAuth() == true)
            userSession.setAuth(false);

        return true;
    }
}
