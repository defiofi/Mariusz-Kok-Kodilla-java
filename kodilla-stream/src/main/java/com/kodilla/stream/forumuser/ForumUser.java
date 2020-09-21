package com.kodilla.stream.forumuser;

import com.kodilla.stream.beautifier.LambdaText;

import java.time.LocalDate;

public class ForumUser {
    private final int userIdentyfier;
    private final String userName;
    private final char sex;         // 'M' / 'F'
    private final LocalDate DateOfBirth;
    private final int numberOfPostsPublished;

    public ForumUser(final int userIdentyfier, final String userName, final char sex, final LocalDate dateOfBirth, final int numberOfPostsPublished) {
        this.userIdentyfier = userIdentyfier;
        this.userName = userName;
        this.sex = sex;
        DateOfBirth = dateOfBirth;
        this.numberOfPostsPublished = numberOfPostsPublished;
    }

    public int getUserIdentyfier() {
        return userIdentyfier;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public int getNumberOfPostsPublished() {
        return numberOfPostsPublished;
    }
    @Override
    public String toString() {
        return "ForumUser{" +
                "userIdentyfier=" + userIdentyfier +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", DateOfBirth=" + DateOfBirth +
                ", numberOfPostsPublished=" + numberOfPostsPublished +
                '}';
    }
}
