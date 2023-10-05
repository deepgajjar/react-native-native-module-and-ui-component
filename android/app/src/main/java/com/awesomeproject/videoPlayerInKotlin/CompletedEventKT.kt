package com.awesomeproject.videoPlayerInKotlin

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event
import androidx.annotation.Nullable

class CompletedEventKT(surfaceId: Int,viewId: Int): Event<CompletedEventKT>(surfaceId,viewId) {
    override fun getEventName(): String {
        return "onCompleted"
    }

    override fun canCoalesce(): Boolean {
        return false
    }

    @Nullable
    override fun getEventData(): WritableMap? {
        val eventData = Arguments.createMap()
        eventData.putBoolean("completed", true)
        return eventData
    }

}