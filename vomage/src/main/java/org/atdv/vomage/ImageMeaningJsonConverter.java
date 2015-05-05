package org.atdv.vomage;

import android.media.Image;
import android.util.Log;

import com.google.common.collect.Lists;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by matsumotius on 15/05/06.
 */
public class ImageMeaningJsonConverter {

    public List<ImageMeaning> convert(JSONArray jsonArray) throws JSONException {
        List<ImageMeaning> results = Lists.newArrayList();
        for (int index = 0; index < jsonArray.length(); index++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(index);
            String url = jsonObject.getString("url");
            int width = jsonObject.getInt("width");
            int height = jsonObject.getInt("height");
            results.add(new ImageMeaning(url, width, height));
        }
        return results;
    }

}
