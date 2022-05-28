package com.example.daniwebandroidcountingidlingresource

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.daniwebandroidcountingidlingresource.IdlingResourceCounter.countingIdlingResource
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

private const val TAG = "EXAMPLE_TEST"

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    //Gets the IdlingRegistry singleton
    private val idlingResourceRegistry = IdlingRegistry.getInstance()

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun doAsyncTest(){
        //Register the CountingIdlingResource before click()
        idlingResourceRegistry.register(countingIdlingResource)

        onView(withId(R.id.textView_helloWorld))
            .perform(click())
            .check(matches(withText("WorldHello!")))
    }

    @After
    fun unregisterIdlingResources(){
        //Unregisters the CountingIdlingResource
        idlingResourceRegistry.resources.forEach {
            idlingResourceRegistry.unregister(it)
        }
    }
}