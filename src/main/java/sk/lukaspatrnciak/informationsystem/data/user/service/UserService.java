package sk.lukaspatrnciak.informationsystem.data.user.service;

import org.springframework.stereotype.Service;
import sk.lukaspatrnciak.informationsystem.data.user.domain.User;
import sk.lukaspatrnciak.informationsystem.data.user.domain.Address;
import sk.lukaspatrnciak.informationsystem.data.web.request.UserRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<Long, User> users;

    public UserService() {
        users = new HashMap<>();
    }

    // Map<String, User> users = new HashMap<>();
    ArrayList<User> usersArray = new ArrayList<>();

    public User addNewUser(long userId, String name, String surname, String identificationNumber, String email, Address deliveryAddress, Address correspondenceAddress) {
        User user = new User(userId, name, surname, identificationNumber, email, deliveryAddress, correspondenceAddress);

        users.put(userId, user);
        usersArray.add(user);

        return user;
    }

    public void editUser(User user, String newName, String newSurname, String newEmail, Address newDeliveryAddress, Address newCorrespondenceAddress) {
        user.setName(newName);
        user.setSurname(newSurname);
        user.setEmail(newEmail);
        user.setDeliveryAddress(newDeliveryAddress);
        user.setCorrespondenceAddress(newCorrespondenceAddress);
    }

    public User findByUserId(long userId) {
        return users.get(userId);
    }

    public Map<Long, User> listAllUsers() {
        return users;
    }

    public User registerRequest(UserRequest userRequest) {
        users.put(userRequest.getUserId(), userRequest.returnUser());

        return userRequest.returnUser();
    }
}
