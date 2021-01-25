package uk.co.jordanterry.impl

import uk.co.jordanterry.api.Feature1
import javax.inject.Inject

class Feature1Impl @Inject constructor() : Feature1 {
    override fun doSomething(): String = "FeatureOne"
}