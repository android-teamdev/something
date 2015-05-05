package org.atdv.vomage;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.common.collect.Lists;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends Activity {

    @InjectView(R.id.main_view_word_in_english_text)
    TextView englishWordTextView;

    @InjectView(R.id.main_view_word_in_japanese_text)
    TextView japaneseWordTextView;

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
        if (vomageWords.size() > currentIndex) {
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
        japaneseWordTextView.setText(currentVomageWord.getJapaneseWord().getText());
    }

    private void initWords() {
        vomageWords.add(new VomageWord(new EnglishWord("cat"), new JapaneseWord("猫")));
        vomageWords.add(new VomageWord(new EnglishWord("dog"), new JapaneseWord("犬")));
    }


}
