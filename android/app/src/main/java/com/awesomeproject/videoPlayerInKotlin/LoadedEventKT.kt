package com.awesomeproject.videoPlayerInKotlin

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event;
import androidx.annotation.Nullable

class LoadedEventKT(surfaceId: Int, viewId: Int) : Event<LoadedEventKT>(surfaceId, viewId) {
    override fun getEventName(): String {
       return "onLoaded"
    }
    override fun canCoalesce(): Boolean {
        // We don't want to miss any event, as event data is incremental.
        return false
    }

    @Nullable
    override fun getEventData(): WritableMap? {
        val eventData = Arguments.createMap()
        eventData.putBoolean("loaded", true)
        return eventData
    }
}