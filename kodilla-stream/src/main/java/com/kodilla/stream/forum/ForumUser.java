package com.kodilla.stream.forum;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ForumUser {
    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();

    public ForumUser(final String username, final String realName, final String location) {
        this.username = username;
        this.realName = realName;
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public String getLocation() {
        return location;
    }

    public Set<ForumUser> getFriends() {
        return friends;
    }
    public void addFriend(ForumUser user) {
        friends.add(user);
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;

        if (!username.equals(forumUser.username)) return false;
        if (!realName.equals(forumUser.realName)) return false;
        return location.equals(forumUser.location);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + realName.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }
    public Set<String> getLocationsOfFriends() {
        return friends.stream()
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }
    public Set<String> getLocationsOfFriendsOfFriends() {
        return friends.stream()
                .flatMap(user -> user.getFriends().stream())
                .filter(user -> user != this)
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }
}
