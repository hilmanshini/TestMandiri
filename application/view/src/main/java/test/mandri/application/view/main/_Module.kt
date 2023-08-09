package test.mandri.application.view.main

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
class _Module {

    @Provides
    fun provideMainView(@ActivityContext context:Context):MainView = MainViewImpl(context as Activity)
}