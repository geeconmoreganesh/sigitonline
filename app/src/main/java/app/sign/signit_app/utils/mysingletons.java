package app.sign.signit_app.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class mysingletons {
    private static mysingletons mInstance;
    private RequestQueue requestQueue;
    private static Context mCtx;

    private mysingletons(Context context) {
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized mysingletons getmInstance(Context context) {
        if (mInstance == null) {
            mInstance = new mysingletons(context);
        }
        return mInstance;
    }

    public <T> void addToRequestque(Request<T> request) {
        requestQueue.add(request);
    }
}
