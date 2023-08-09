package test.mandri.application.view.main

import android.app.Activity
import android.view.View
import androidx.databinding.DataBindingUtil
import test.mandiri.application.view.R
import test.mandiri.application.view.databinding.MainBinding

class MainViewImpl(val activity: Activity) : MainView {
    override fun provideMainView(): View =
        DataBindingUtil.setContentView<MainBinding>(
            activity,
            R.layout.main
        ).root

}