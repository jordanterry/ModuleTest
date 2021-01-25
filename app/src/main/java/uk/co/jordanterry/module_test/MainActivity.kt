package uk.co.jordanterry.module_test

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import dagger.Binds
import dagger.Subcomponent
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import uk.co.jordanterry.api.Feature1
import uk.co.jordanterry.api.Feature2
import uk.co.jordanterry.impl_wiring.Feature2Module
import uk.co.jordanterry.impl_wiring.FeatureOneModule
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var feature1: Feature1

    @Inject
    lateinit var feature2: Feature2

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        Log.d("DI_TEST", feature1.doSomething())
        feature2.doSomething()

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

@Subcomponent(modules = [
    FeatureOneModule::class,
    Feature2Module::class
])
interface MainActivitySubComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}

@dagger.Module(subcomponents = [
    MainActivitySubComponent::class
])
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindMainActivity(factory: MainActivitySubComponent.Factory): AndroidInjector.Factory<*>
}