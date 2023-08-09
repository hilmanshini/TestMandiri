package test.mandiri.module.rest

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import test.mandiri.module.rest.service.MovieRestService
import test.mandiri.module.rest.service.remote.RemoteMovieService
import javax.inject.Inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MovieTest {


    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Inject
    lateinit var moveRestService: MovieRestService

    @Inject
    lateinit var RemoteMovieService: RemoteMovieService

    @Test
    fun useAppContext() {
        // Context of the app under test.
        runBlocking {
            val z = RemoteMovieService.getGenre()
//            val a = RemoteMovieService.getMovieByGenre(1, "18")
        }
    }
}