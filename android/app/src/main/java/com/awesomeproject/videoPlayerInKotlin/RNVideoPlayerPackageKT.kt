package com.awesomeproject.videoPlayerInKotlin

import android.view.View
import androidx.annotation.NonNull
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ReactShadowNode
import com.facebook.react.uimanager.ViewManager
import java.util.Arrays
import java.util.Collections

class RNVideoPlayerPackageKT : ReactPackage {
    //    @NonNull
//    override fun createNativeModules(@NonNull reactApplicationContext: ReactApplicationContext): List<NativeModule> {
//        return Collections.emptyList()
//    }
//
//    @NonNull
//    override fun createViewManagers(@NonNull reactApplicationContext: ReactApplicationContext): List<ViewManager> {
//        return Arrays.asList(
//            RNVideoPlayerManager(reactApplicationContext)
//        )
//    }
    override fun createNativeModules(p0: ReactApplicationContext): MutableList<NativeModule> {
        return Collections.emptyList()
    }

    override fun createViewManagers(reactApplicationContext: ReactApplicationContext) = listOf(RNVideoPlayerManagerKT(reactApplicationContext))
}