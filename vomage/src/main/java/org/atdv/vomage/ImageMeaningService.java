package org.atdv.vomage;

import android.content.Context;
import android.media.Image;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by matsumotius on 15/05/06.
 */
public class ImageMeaningService {

    private static final String TAG = ImageMeaningService.class.getSimpleName();

    public interface ImageMeaningServiceSearchListener {

        void onSuccess(List<ImageMeaning> imageMeanings);

        void onFailure();

    }

    public static void search(Context context, EnglishWord englishWord, int count, final ImageMeaningServiceSearchListener listener) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(buildApiUrl(context, englishWord), buildParams(englishWord, count), new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // do nothing
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    ImageMeaningJsonConverter converter = new ImageMeaningJsonConverter();
                    listener.onSuccess(converter.convert(response));
                } catch (JSONException e) {
                    Log.e(TAG, "Failed to search => " + e.getMessage());
                    listener.onFailure();
                }
            }

        });
    }

    private static final RequestParams buildParams(EnglishWord englishWord, int count) {
        RequestParams params = new RequestParams();
        params.add("q", englishWord.getText());
        params.add("n", String.valueOf(count));
        return params;
    }

    private static final String buildApiUrl(Context context, EnglishWord englishWord) {
        return context.getText(R.string.vomage_api_host) + "images";
    }

}
