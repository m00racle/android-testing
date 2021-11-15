package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
//        Create an active task
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false),
            Task("title2", "desc2", false)
        )
//        Call your function
        val result = getActiveAndCompletedStats(tasks)

//        Check the result now using Hamcrest matchers:
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnZeros() {
//        Test when the list is empty meaning not even completed task in it
//        It should return zero percentage for both active task and completed task
//        arrange: nothing to arrange because we will put empty list to the function

//        action: pass empty list to the function
        val result = getActiveAndCompletedStats(emptyList())

//        assert: it should return 0% active task percent, 0% completed task percent
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
//        Test when the list have no active task (all done)
//        It should return 0% to active task and 100% to completed task
//        arrange: make list of task with all isCompleted = true
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true),
            Task("title2", "desc2", true)
        )
//        action: put the tasks to the function
        val result = getActiveAndCompletedStats(tasks)
//        assert:
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_error_null_returnsZeros() {
//        Test when there are errors in the task List (in this case null errors)
//        It should returns 0% for active task and completed task
//        arrange: nothing we will just pass null into the function to invoke null exception
//        action: pass null to the function
        val result = getActiveAndCompletedStats(null)
//        assert:
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun  getActiveAndCompletedStats_both_returnsFortySixty() {
//        Test when we have 5 tasks and 3 completed while 2 still active
//        It should returns 40% to active tasks and 60% to completed tasks
//        arrange: make 5 tasks 3 completed 2 active
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true),
            Task("title2", "desc2", true),
            Task("title3", "desc3", isCompleted = false),
            Task("title2", "desc2", true),
            Task("title3", "desc3", isCompleted = false)
        )
//        action: pass the tasks list to the function
        val result = getActiveAndCompletedStats(tasks)
//        asserts:
        assertThat(result.activeTasksPercent, `is`(40f))
        assertThat(result.completedTasksPercent, `is`(60f))
    }
}