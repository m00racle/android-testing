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
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
//        Test when the list have no active task (all done)
//        It should return 0% to active task and 100% to completed task
    }

    @Test
    fun getActiveAndCompletedStats_error_null_returnsZeros() {
//        Test when there are errors in the task List (in this case null errors)
//        It should returns 0% for active task and completed task
    }

    @Test
    fun  getActiveAndCompletedStats_both_returnsFortySixty() {
//        Test when we have 5 tasks and 3 completed while 2 still active
//        It should returns 40% to active tasks and 60% to completed tasks
    }
}