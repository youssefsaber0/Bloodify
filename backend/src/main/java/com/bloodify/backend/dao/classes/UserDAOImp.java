package com.bloodify.backend.dao.classes;

import com.bloodify.backend.dao.interfaces.UserDAO;
import com.bloodify.backend.dao.interfaces.UserRepository;
import com.bloodify.backend.model.entities.User;
import com.bloodify.backend.model.entities.UserAuthentication;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Required Services:
 * at sign in --> find user with email 'bla', match username with password
 * at sign up --> check that username is not repeated, insert new user (saveUser)
 * get users with blood type 'bla'
 */
@Slf4j
@Service
public class UserDAOImp implements UserDAO {
    @Autowired
    UserRepository userRepo;


    public boolean saveUser(User newUser) {
        try {
            userRepo.save(newUser);
            return true;
        } catch (Exception e) {
            log.info(e.getMessage());
            return false;
        }
    }

    public User findUserByEmail(String email) {
        List<User> foundUsers = userRepo.findByEmail(email);

        if (foundUsers.isEmpty())
            return null;
        else if (foundUsers.size() == 1)
            return foundUsers.get(0);
        else {
            System.out.println("Database is inconsistent");
            return null;
        }
    }

    public User findUserByNationalID(String nationalID) {
        List<User> foundUsers = userRepo.findByNationalID(nationalID);

        if (foundUsers.isEmpty())
            return null;
        else
            return foundUsers.get(0);
    }

    public boolean isUsernameAndPasswordMatching(String email, String password) {
        User signingIn = findUserByEmail(email);
        if (signingIn != null) {
            String currentPassword = signingIn.getPassword();
            return currentPassword.equals(password);
        }
        return false;
    }

    public List<User> getUsersByBloodType(String bloodType, char bloodSign) {
        return userRepo.findByBloodType(bloodType, bloodSign);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(username + " user");
        User user = this.findUserByEmail(username);
        if(user == null)    throw new UsernameNotFoundException(username + " not found");
        log.info(user.getEmail());
        // if(!username.equals("foo")) throw new UsernameNotFoundException(username + " not found");
        UserAuthentication userAuth = new UserAuthentication(user);
        return userAuth;
        // return new User("foo", "foo", List.of());
    }


}
