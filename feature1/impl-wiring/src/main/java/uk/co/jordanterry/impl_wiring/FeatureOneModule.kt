package uk.co.jordanterry.impl_wiring

import dagger.Binds
import dagger.Module
import uk.co.jordanterry.api.Feature1
import uk.co.jordanterry.impl.Feature1Impl

@Module
abstract class FeatureOneModule {

    @Binds
    abstract fun bindsFeatureOne(featureOneModuleImpl: Feature1Impl): Feature1
}