package com.awesomeproject.CustomVIdeoPlayer;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class LoadedEvent extends Event<LoadedEvent> {
    public LoadedEvent(int surfaceId, int viewId) {
        super(surfaceId, viewId);
    }

    @Override
    public String getEventName() {
        return "onLoaded";
    }

    @Override
    public boolean canCoalesce() {
        // We don't want to miss any event, as event data is incremental.
        return false;
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        WritableMap eventData = Arguments.createMap();
        eventData.putBoolean("loaded", true);
        return eventData;
    }
}
