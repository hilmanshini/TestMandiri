package test.mandiri.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import test.mandri.application.view.main.MainView
import javax.inject.Inject

@AndroidEntryPoint
class AppActivity: AppCompatActivity() {

    @Inject
    lateinit var mainView:MainView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainView.provideMainView()
    }
}