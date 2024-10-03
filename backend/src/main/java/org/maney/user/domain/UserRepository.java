package org.maney.user.domain;

public interface UserRepository {
    boolean doesUserExist(String ownerId);

    String createUser(String ownerId, String firstName, String lastName);
}
