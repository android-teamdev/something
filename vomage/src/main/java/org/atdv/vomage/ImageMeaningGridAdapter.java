package org.atdv.vomage;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by matsumotius on 15/05/05.
 */
public class ImageMeaningGridAdapter extends ArrayAdapter<ImageMeaning> {

    public ImageMeaningGridAdapter(Context context, List<ImageMeaning> imageMeanings) {
        super(context, R.layout.image_meaning_item_view, imageMeanings);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View itemView;
        if (convertView != null) {
            itemView = convertView;
        } else {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.image_meaning_item_view, null);
        }
        ImageView imageView = (ImageView) itemView.findViewById(R.id.image_meaning_item_view_image);
        Picasso.with(getContext()).load(getItem(position).getImageUrl()).into(imageView);

        return itemView;
    }

}
