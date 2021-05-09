package org.reg.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.reg.exceptions.PasswordIncorrectException;
import org.reg.model.User;
import org.reg.exceptions.WrongPasswordException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.reg.services.FileSystemService.getPathToFile;

public class UserService {
    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Air BejiZescu.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String username, String password, String role, String name, String eMail, String phoneNumber) {
        userRepository.insert(new User(username, encodePassword(username, password), role, name, eMail, phoneNumber));
    }

    public static void addUser(String username, String password, String role, String name, String eMail, String phoneNumber, String personalKey) {
        userRepository.insert(new User(username, encodePassword(username, password), role, name, eMail, phoneNumber, personalKey));
    }

    public static void loginUser(String username, String password) throws WrongPasswordException {
        checkPassword(password, username);
    }

    public static boolean checkUserDoesAlreadyExist(String username, String password) throws PasswordIncorrectException{
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                if(!Objects.equals(user.getPassword(), encodePassword(username,password)))
                    throw new PasswordIncorrectException(password);
                else return true;
            }
        }
        return false;
    }

    public static void checkPassword(String password, String username) throws WrongPasswordException {
        int ok = 0;
        for(User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                if (Objects.equals(encodePassword(username, password), user.getPassword())) {
                    ok = 1;
                }
            }
        }
        if (ok == 0) {
            throw new WrongPasswordException();
        }
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }
    public static ObjectRepository<User> getUsers() {return userRepository;}
}