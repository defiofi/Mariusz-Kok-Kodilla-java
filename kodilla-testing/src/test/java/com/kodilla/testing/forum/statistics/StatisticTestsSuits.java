package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticTestsSuits {
    @Mock
    private Statistics statisticsMock ;
    public static List<String> listOfUsers(int number) {
        List<String> listOfUsers = new ArrayList<>();
        for(int i = 0 ; i < number; i++){
            listOfUsers.add("Aaa");
        }
        return listOfUsers;
    }
    @DisplayName("gdy liczba postow = 0")
    @Test
    void TestOfZeroPosts(){
        //Given
        StatisticsOfForum test = new StatisticsOfForum();
        when(statisticsMock.usersNames()).thenReturn(listOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(1);
        //When
        test.calculateAdvStatistics(statisticsMock);
        //Then
        test.showStatistics();
        assertEquals(0,test.getAverageNumberOfPostsPerUser());
        assertEquals(0,test.getAverageNumbersOfCommentsPerPosts());
        assertEquals(0.1,test.getAverageNumbersOfCommentsPerUser());
    }
    @DisplayName("gdy liczba postow = 1000")
    @Test
    void TestOfThousandPosts(){
        //Given
        StatisticsOfForum test = new StatisticsOfForum();
        when(statisticsMock.usersNames()).thenReturn(listOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);
        //When
        test.calculateAdvStatistics(statisticsMock);
        //Then
        test.showStatistics();
        assertEquals(100 , test.getAverageNumberOfPostsPerUser());
        assertEquals(0.1 , test.getAverageNumbersOfCommentsPerPosts());
        assertEquals(10 , test.getAverageNumbersOfCommentsPerUser());
    }
    @DisplayName("gdy liczba komentarzy = 0")
    @Test
    void TestOfZeroComments(){
        //Given
        StatisticsOfForum test = new StatisticsOfForum();
        when(statisticsMock.usersNames()).thenReturn(listOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        test.calculateAdvStatistics(statisticsMock);
        //Then
        test.showStatistics();
        assertEquals(10 , test.getAverageNumberOfPostsPerUser());
        assertEquals(0 , test.getAverageNumbersOfCommentsPerPosts());
        assertEquals(0 , test.getAverageNumbersOfCommentsPerUser());
    }
    @DisplayName("gdy liczba komentarzy < liczba postow")
    @Test
    void TestOfLessCommentsThanPosts(){
        //Given
        StatisticsOfForum test = new StatisticsOfForum();
        when(statisticsMock.usersNames()).thenReturn(listOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(10);
        //When
        test.calculateAdvStatistics(statisticsMock);
        //Then
        test.showStatistics();
        assertEquals(10 , test.getAverageNumberOfPostsPerUser());
        assertEquals(0.1 , test.getAverageNumbersOfCommentsPerPosts());
        assertEquals(1 , test.getAverageNumbersOfCommentsPerUser());
    }
    @DisplayName("gdy liczba komentarzy > liczba postow")
    @Test
    void TestOfMoreCommentsThanPosts(){
        //Given
        StatisticsOfForum test = new StatisticsOfForum();
        when(statisticsMock.usersNames()).thenReturn(listOfUsers(10));
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(500);
        //When
        test.calculateAdvStatistics(statisticsMock);
        //Then
        test.showStatistics();
        assertEquals(5 , test.getAverageNumberOfPostsPerUser());
        assertEquals(10 , test.getAverageNumbersOfCommentsPerPosts());
        assertEquals(50 , test.getAverageNumbersOfCommentsPerUser());
    }
    @DisplayName("gdy liczba uzytkownikow = 0")
    @Test
    void TestOfZeroUsers(){
        //Given
        StatisticsOfForum test = new StatisticsOfForum();
        when(statisticsMock.usersNames()).thenReturn(listOfUsers(0));
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(100);
        //When
        test.calculateAdvStatistics(statisticsMock);
        //Then
        test.showStatistics();
        assertEquals(0 , test.getAverageNumberOfPostsPerUser());
        assertEquals(5 , test.getAverageNumbersOfCommentsPerPosts());
        assertEquals(0 , test.getAverageNumbersOfCommentsPerUser());
    }
    @DisplayName("gdy liczba uzytkownikow = 100")
    @Test
    void TestOfHundredUsers(){
        //Given
        StatisticsOfForum test = new StatisticsOfForum();
        when(statisticsMock.usersNames()).thenReturn(listOfUsers(100));
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(80);
        //When
        test.calculateAdvStatistics(statisticsMock);
        //Then
        test.showStatistics();
        assertEquals(0.2 , test.getAverageNumberOfPostsPerUser());
        assertEquals(4 , test.getAverageNumbersOfCommentsPerPosts());
        assertEquals(0.8 , test.getAverageNumbersOfCommentsPerUser());
    }

}
