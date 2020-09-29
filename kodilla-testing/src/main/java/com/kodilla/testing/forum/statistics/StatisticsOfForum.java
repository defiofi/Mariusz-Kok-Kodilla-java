package com.kodilla.testing.forum.statistics;

public class StatisticsOfForum {
    private int numberOfUsers;                          //liczba użytkowników,
    private int numberOfPosts;                          //liczba postów,
    private int numberOfComments;                       //liczba komentarzy,
    private double averageNumberOfPostsPerUser;         //średnią liczba postów na użytkownika,
    private double averageNumbersOfCommentsPerUser;     //średnią liczbę komentarzy na użytkownika,
    private double averageNumbersOfCommentsPerPosts;    //średnią liczbę komentarzy na post.

    private Statistics statistics;

    public void calculateAdvStatistics(Statistics statistics){
        this.statistics = statistics;
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();
        averageNumberOfPostsPerUser = (numberOfUsers != 0 ? (double) numberOfPosts/numberOfUsers : 0);
        averageNumbersOfCommentsPerUser = (numberOfUsers != 0 ? (double) numberOfComments/numberOfUsers : 0);
        averageNumbersOfCommentsPerPosts = (numberOfPosts != 0 ? (double) numberOfComments/numberOfPosts : 0);
    }
    public void showStatistics(){
        System.out.println("Statistics of forum:");
        System.out.println("Number of users = "+numberOfUsers);
        System.out.println("Number of posts = "+numberOfPosts);
        System.out.println("Number of comments = "+numberOfComments);
        System.out.println("Average number of posts per user = "+averageNumberOfPostsPerUser);
        System.out.println("Average numbers of comments per user = "+averageNumbersOfCommentsPerUser);
        System.out.println("Average numbers of comments per posts = "+averageNumbersOfCommentsPerPosts);
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumbersOfCommentsPerUser() {
        return averageNumbersOfCommentsPerUser;
    }

    public double getAverageNumbersOfCommentsPerPosts() {
        return averageNumbersOfCommentsPerPosts;
    }
}
