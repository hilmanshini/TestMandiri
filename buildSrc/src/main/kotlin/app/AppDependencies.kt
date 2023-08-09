package app

import core
import koil
import daggerHilt
import moshi
import okhttp
import org.gradle.api.artifacts.dsl.DependencyHandler
import retrofit
import room
import workManager
import viewModel
import paging
import mapStruct
import ytPlayer

fun DependencyHandler.appDependencies() {
    core()
    koil()
    moshi()
    okhttp()
    retrofit()
    room()
    viewModel()
    daggerHilt()
    workManager()
    paging()
    mapStruct()
    ytPlayer()
}