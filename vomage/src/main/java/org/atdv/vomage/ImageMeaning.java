package org.atdv.vomage;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matsumotius on 15/05/05.
 */
public class ImageMeaning {

    private final String url;

    private final int width;

    private final int height;

    public ImageMeaning(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getImageUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
