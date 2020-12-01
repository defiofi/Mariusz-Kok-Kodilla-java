package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test: zadanie 17.2";

    @Test
    void testFindByListName(){
        //Given
        TaskList taskList = new TaskList("test1", DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        List<TaskList> readTaskList = taskListDao.findByListName("test1");
        assertEquals("test1" ,readTaskList.get(readTaskList.size()-1).getListName() );
        assertEquals(1, readTaskList.size());

        //CleanUp
        taskListDao.deleteById(id);
    }
}
