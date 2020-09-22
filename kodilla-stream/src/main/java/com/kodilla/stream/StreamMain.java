package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;

public class StreamMain {
    public static void main(String[] args) {
        Forum aForum = new Forum();

        Map<Integer , ForumUser> par = aForum.getUserList().stream()
                .filter(ForumUser -> ForumUser.getSex() == 'M')
                .filter(ForumUser -> ForumUser.getNumberOfPostsPublished()>0)
                .filter(ForumUser -> (LocalDate.now().getYear() - ForumUser.getDateOfBirth().getYear())>20)
                .collect(Collectors.toMap(ForumUser::getUserIdentyfier,ForumUser -> ForumUser));
        System.out.println("Ilość uzytkowników: "+par.entrySet().size());
        String mapText = par.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("\n" , "<" , ">"));
        System.out.println(mapText);
                //.forEach(System.out::println);    - inny sposób wyświetlenia Stream

    }
}
