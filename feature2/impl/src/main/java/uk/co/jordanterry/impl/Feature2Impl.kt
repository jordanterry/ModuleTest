package uk.co.jordanterry.impl

import android.util.Log
import uk.co.jordanterry.api.Feature1
import uk.co.jordanterry.api.Feature2
import javax.inject.Inject

class Feature2Impl @Inject constructor(
    private val feature1: Feature1
) : Feature2 {
    override fun doSomething() {
        Log.d("DI_TEST", "Feature 2 doing something with ${feature1.doSomething()}")
    }
}