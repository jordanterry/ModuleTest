package uk.co.jordanterry.module_test

import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        MainActivityModule::class
    ]
)
interface ApplicationComponent {
    fun inject(application: ModuleTestApplication)
}