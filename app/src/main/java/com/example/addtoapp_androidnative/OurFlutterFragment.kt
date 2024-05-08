package com.example.addtoapp_androidnative

import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.android.FlutterSurfaceView

class OurFlutterFragment : FlutterFragment() {
    override fun onFlutterSurfaceViewCreated(flutterSurfaceView: FlutterSurfaceView) {
        flutterSurfaceView.setSecure(true)
    }
}