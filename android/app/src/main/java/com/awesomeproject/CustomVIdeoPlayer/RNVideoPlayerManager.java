package com.awesomeproject.CustomVIdeoPlayer;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

public class RNVideoPlayerManager extends SimpleViewManager<RNVideoPlayer> {
    public static final String REACT_CLASS = "RNVideoPlayer";
    ReactApplicationContext mCallerContext;

    public RNVideoPlayerManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }
    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Nullable
    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put(
                        "onLoaded",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onLoaded")
                        )
                )
                .put(
                        "onCompleted",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onCompleted")
                        )
                )
                .build();
    }

    @NonNull
    @Override
    protected RNVideoPlayer createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new RNVideoPlayer(reactContext);
    }
    @ReactProp(name = "source")
    public void setVideoSource(RNVideoPlayer view, @Nullable String source) {
        view.setVideoURI(Uri.parse(source));
        view.requestFocus();
    }

    @ReactProp(name = "autoPlay")
    public void setVideoAutoPlay(RNVideoPlayer view, @Nullable Boolean autoPlay) {
        view.setAutoPlay(autoPlay);
    }

    @ReactProp(name = "paused")
    public void setVideoPaused(RNVideoPlayer view, @Nullable Boolean paused) {
        view.setPaused(paused);
    }
}
