package org.atdv.vomage;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.etsy.android.grid.StaggeredGridView;
import com.google.common.collect.Lists;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends Activity {

    private static String TAG = MainActivity.class.getSimpleName();

    @InjectView(R.id.main_view_english_word_view)
    TextView englishWordTextView;

    @InjectView(R.id.main_view_japanese_meaning_view)
    TextView japaneseWordTextView;

    @InjectView(R.id.main_view_image_meaning_view)
    StaggeredGridView imageMeaningGridView;

    // TODO: paging管理的なのをするクラスつくる
    private List<VomageWord> vomageWords = Lists.newArrayList();

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initWords();
    }

    @Override
    protected void onStart() {
        super.onStart();
        applyCurrentVomageWord();
    }

    @OnClick(R.id.main_view_next_button)
    void onClickNextButton() {
        if (vomageWords.size() - 1 > currentIndex) {
            currentIndex++;
            applyCurrentVomageWord();
        }
    }

    @OnClick(R.id.main_view_prev_button)
    void onClickPrevButton() {
        if (currentIndex > 0) {
            currentIndex--;
            applyCurrentVomageWord();
        }
    }

    private void applyCurrentVomageWord() {
        if (vomageWords.isEmpty() || currentIndex < 0 || currentIndex >= vomageWords.size()) {
            return;
        }
        VomageWord currentVomageWord = vomageWords.get(currentIndex);
        englishWordTextView.setText(currentVomageWord.getEnglishWord().getText());
        japaneseWordTextView.setText(currentVomageWord.getJapaneseMeaning().getText());
        ImageMeaningService.search(getApplicationContext(), currentVomageWord.getEnglishWord(), 9, new ImageMeaningService.ImageMeaningServiceSearchListener() {
            @Override
            public void onSuccess(List<ImageMeaning> imageMeanings) {
                Log.d(TAG, "Succeeded to search image meanings.");
                ImageMeaningGridAdapter imageMeaningGridAdapter = new ImageMeaningGridAdapter(getApplicationContext(), imageMeanings);
                imageMeaningGridView.setAdapter(imageMeaningGridAdapter);
            }

            @Override
            public void onFailure() {
                Log.d(TAG, "Failed to search image meanings.");
            }
        });
    }

    private void initWords() {
        vomageWords.add(new VomageWord(new EnglishWord("cat"), new JapaneseMeaning("猫")));
        vomageWords.add(new VomageWord(new EnglishWord("dog"), new JapaneseMeaning("犬")));
    }


}
