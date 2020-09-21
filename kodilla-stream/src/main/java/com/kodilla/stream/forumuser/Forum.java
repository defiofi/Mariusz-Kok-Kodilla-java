package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    List<ForumUser> listOfUsers = new ArrayList<>();
    public Forum(){
        listOfUsers.add(new ForumUser(1754, "Kot w butach", 'M' , LocalDate.of(1980, 9,25), 7));
        listOfUsers.add(new ForumUser(2051, "Królewna Sniezka", 'F' , LocalDate.of(1985, 3,15), 17));
        listOfUsers.add(new ForumUser(754, "Krasnoludek", 'M' , LocalDate.of(1990, 12,03), 72));
        listOfUsers.add(new ForumUser(2734, "Czarownica", 'F' , LocalDate.of(1987, 1,12), 42));
        listOfUsers.add(new ForumUser(1981, "Wiedzmin", 'M' , LocalDate.of(1991, 7,13), 0));
        listOfUsers.add(new ForumUser(3791, "Mirmil", 'M' , LocalDate.of(1995, 6,11), 170));
        listOfUsers.add(new ForumUser(2701, "Kokosz", 'M' , LocalDate.of(1993, 2,28), 35));
        listOfUsers.add(new ForumUser(3052, "Kajko", 'M' , LocalDate.of(2005, 4,1), 105));
    }
    public List<ForumUser> getUserList(){
    return listOfUsers;
    }
}
