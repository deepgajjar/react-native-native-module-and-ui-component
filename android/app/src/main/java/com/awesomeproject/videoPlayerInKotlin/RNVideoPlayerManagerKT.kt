package com.awesomeproject.videoPlayerInKotlin

import android.net.Uri

import androidx.annotation.NonNull
import androidx.annotation.Nullable

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

import java.util.Map

class RNVideoPlayerManagerKT(private val reactContext : ReactApplicationContext): SimpleViewManager<RNVideoPlayerKT>() {
    override fun getName(): String {
        return "RNVideoPlayerKT"
    }

    override fun createViewInstance(reactContext: ThemedReactContext): RNVideoPlayerKT {
        return RNVideoPlayerKT(reactContext)
    }

    override fun getExportedCustomBubblingEventTypeConstants(): MutableMap<String, Any>? {
        return MapBuilder.builder<String, Any?>()
            .put("onLoaded",
                MapBuilder.of("phasedRegistrationNames",
                    MapBuilder.of("bubbled", "onLoaded"))
            )
            .put("onCompleted",
                MapBuilder.of("phasedRegistrationNames",
                    MapBuilder.of("bubbled", "onCompleted"))
            )
            .build()
    }

    @ReactProp(name = "source")
    fun setVideoSource(view: RNVideoPlayerKT, @Nullable source: String?) {
        view.setVideoURI(Uri.parse(source))
        view.requestFocus()
    }

    @ReactProp(name = "autoPlay")
    fun setVideoAutoPlay(view: RNVideoPlayerKT, @Nullable autoPlay: Boolean?) {
        if (autoPlay != null) {
            view.setAutoPlay(autoPlay)
        }
    }

    @ReactProp(name = "paused")
    fun setVideoPaused(view: RNVideoPlayerKT, @Nullable paused: Boolean?) {
        if (paused != null) {
            view.setPaused(paused)
        }
    }

}