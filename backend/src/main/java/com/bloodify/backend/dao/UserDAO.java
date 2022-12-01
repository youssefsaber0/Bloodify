package com.bloodify.backend.dao;

import com.bloodify.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Required Services:
 * at sign in --> find user with email 'bla', match username with password
 * at sign up --> check that username is not repeated, insert new user (saveUser)
 * get users with blood type 'bla'
 */
@Service
public class UserDAO {
    @Autowired
    UserRepository userRepo;

    public boolean saveUser (User newUser) {
        List<User> foundUsersByMail = userRepo.findByEmail(newUser.getEmail());
        List<User> foundUsersByNID = userRepo.findByNationalID(newUser.getNationalID());

        if(foundUsersByMail.isEmpty() && foundUsersByNID.isEmpty()) {
            userRepo.save(newUser);
            return true;
        }
        if(!foundUsersByMail.isEmpty())
            System.out.println("Email is taken, try another one!");
        else
            System.out.println("User is already signed in with another mail (same National ID)");
        return false;
    }

    public User findUserByEmail(String email) {
        List<User> foundUsers = userRepo.findByEmail(email);

        if(foundUsers.isEmpty())
            return null;
        else if(foundUsers.size() == 1)
            return foundUsers.get(0);
        else {
            System.out.println("Database is inconsistent");
            return null;
        }
    }


    public boolean isUsernameAndPasswordMatching(String email, String password) {
        User signingIn = findUserByEmail(email);
        if(signingIn!=null){
            String currentPassword = signingIn.getPassword();
            return currentPassword.equals(password);
        }
        return false;
    }

    public List<User> getUsersByBloodType (String bloodType, char bloodSign) {
        return userRepo.findByBloodType(bloodType, bloodSign);
    }

}
