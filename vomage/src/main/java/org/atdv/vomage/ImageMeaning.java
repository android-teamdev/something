package org.atdv.vomage;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matsumotius on 15/05/05.
 */
public class ImageMeaning {

    private List<String> urls;

    public ImageMeaning(List<String> urls) {
        this.urls = ImmutableList.copyOf(urls);
    }

    public List<String> getImageUrls() {
        return urls;
    }

}
