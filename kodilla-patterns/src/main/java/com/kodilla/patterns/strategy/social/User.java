package com.kodilla.patterns.strategy.social;

public class User {
    private String userName;
    protected SocialPublisher socialPublisher;
    User(String name){
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }

    public String Publisher() {
        return socialPublisher.share();
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
