package com.awesomeproject.videoPlayerInKotlin

import android.content.Context
import android.widget.MediaController
import android.widget.VideoView
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.UIManagerHelper
import com.facebook.react.uimanager.events.EventDispatcher

class RNVideoPlayerKT(context: Context) : VideoView(context) {
    private val videoView = this
    private var autoPlay = true
    private var paused = true
    private val reactContext: ReactContext

    private val mEventDispatcher: EventDispatcher
    init {
        reactContext = context as ReactContext
        mEventDispatcher = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getId())!!

        val mediaController = MediaController(context)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        setupListeners()
    }

    fun setAutoPlay(autoPlay: Boolean) {
        this.autoPlay = autoPlay
    }

    fun setPaused(paused: Boolean) {
        this.paused = paused
        if (videoView.canPause() && paused) {
            videoView.pause()
        } else if (!paused) {
            videoView.resume()
        }
    }

    private fun setupListeners() {
        videoView.setOnCompletionListener { mp ->
            onVideoCompleted()
        }

        videoView.setOnPreparedListener { mp ->
            onVideoLoaded()

            if (autoPlay) {
                videoView.start()
            }
        }
    }

    private fun onVideoCompleted() {
        mEventDispatcher.dispatchEvent(CompletedEventKT(UIManagerHelper.getSurfaceId(reactContext), getId()))
    }

    private fun onVideoLoaded() {
        mEventDispatcher.dispatchEvent(LoadedEventKT(UIManagerHelper.getSurfaceId(reactContext), getId()))
    }

}