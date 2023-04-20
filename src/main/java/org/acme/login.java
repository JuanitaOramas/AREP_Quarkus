package org.acme;

import org.acme.entities.user;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Path("/login")

public class login {

    private static final Map<String, String> users = new HashMap<>();
    static { users.put ("admin", "password");}


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean validateLogin(user user) throws NoSuchAlgorithmException {
        String password = users.get(user.getUsername());
        if (password == null){return false;}
        String hashedPassword = hashPassword(user.getPassword());
        return password.equals(hashedPassword);
    }
    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashedPassword = bigInt.toString(16);
        return hashedPassword;
    }


}
