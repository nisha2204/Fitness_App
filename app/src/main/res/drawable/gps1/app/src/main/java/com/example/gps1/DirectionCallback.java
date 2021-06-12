package com.example.gps1;

import android.graphics.Path;

interface DirectionCallback {
    void onDirectionSuccess(Path.Direction direction, String rawBody);

    void onDirectionFailure(Throwable t);
}
