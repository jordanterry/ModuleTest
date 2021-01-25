package uk.co.jordanterry.impl_wiring

import dagger.Binds
import uk.co.jordanterry.api.Feature2
import uk.co.jordanterry.impl.Feature2Impl

@dagger.Module
abstract class Feature2Module {

    @Binds
    abstract fun bindsFeature2(feature2Impl: Feature2Impl): Feature2
}