package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum aForum = new Forum();
        Map<Integer , ForumUser> result = aForum.getUserList().stream()
                .filter(ForumUser -> ForumUser.getSex() == 'M')
                .filter(ForumUser -> ForumUser.getNumberOfPostsPublished()>0)
                .filter(ForumUser -> ForumUser.getDateOfBirth().getYear()<2000)
                .collect(Collectors.toMap(ForumUser::getUserIdentyfier,ForumUser -> ForumUser));
        System.out.println("Ilość uzytkowników: "+result.entrySet().size());
        result.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
                //.collect(Collectors.joining("/n","<",">"));   -   To mi się nie udało i nie wiem czemu.

    }
}
