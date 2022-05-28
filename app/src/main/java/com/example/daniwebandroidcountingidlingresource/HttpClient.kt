package com.example.daniwebandroidcountingidlingresource

import android.widget.TextView
import androidx.test.espresso.idling.CountingIdlingResource
import com.example.daniwebandroidcountingidlingresource.IdlingResourceCounter.countingIdlingResource
import kotlinx.coroutines.*

class HttpClient {
    fun doLongAsync(textView: TextView) {
        //Incrementing counter when work starts
        countingIdlingResource.increment()

        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            textView.text = "WorldHello!"
            countingIdlingResource.decrement()
        }
    }
}

/*
We can use a global singleton for this project because
We don't have more than one test using this IdlingResourceCounter
It is recommended to add IdlingResourceCounter directly into your
Production code
*/
object IdlingResourceCounter {
    private const val IDLING_RESOURCE_NAME = "GlobalIdlingResourceCounter"
    val countingIdlingResource = CountingIdlingResource(IDLING_RESOURCE_NAME)
}