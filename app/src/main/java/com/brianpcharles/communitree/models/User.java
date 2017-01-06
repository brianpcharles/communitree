package com.brianpcharles.communitree.models;

import com.brianpcharles.communitree.models.Status;

import io.realm.RealmObject;
import io.realm.Realm;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {

    @PrimaryKey
    String userID;

    String name;

    String email;

    String password;

    Boolean isAdmin = false;

    int isActive;

    /****************
    * Static init and query methods.
    ****************/

    public static User create(String email, String name, String password, Boolean admin) {
        final String uuid = Utils.getUniqueID();
        final String hashPassword = getHashPassword(password);
        Realm realm = Realm.getDefaultInstance();

        try {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    User user = realm.createObject(User.class, uuid);
                    user.setName(name);
                    user.setPassword(hashPassword);
                    user.setAdmin(admin);
                }
            });
            return realm.where(User.class).equalTo("userID", uuid).findFirst();
        } catch (InvalidUserException iue) {
            throw iue;
        } catch (InvalidEmailException iee) {
            throw iee;
        }
    }

    private static String getHashPassword(String password) {
        return Utils.SHA1(password);
    }

    private static Boolean isUniqueEmail(String email) throws InvalidUserException, InvalidEmailException {
        if (Utils.isValidEmailAddress(email)) {
            Realm realm = Realm.getDefaultInstance();
            User user = realm.where(User.class).equalTo("email", email).findFirst();

            if (user != null) {
                throw new InvalidUserException();
            }
            return true;
        } else {
            throw new InvalidEmailException();
        }

        return false;
    }

    /******************
     * Getters & setters
     *****************/

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public class InvalidUserException extends Exception {}
    public class InvalidPasswordException extends Exception {}
    public class InvalidEmailException extends Exception {}
}
