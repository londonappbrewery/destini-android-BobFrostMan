package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView storyTextView;
    private Button buttonTop;
    private Button buttonBottom;

    private int storyPathIndex;

    private StoryWithAnswers[] storyWithAnswers = new StoryWithAnswers[] {
      new StoryWithAnswers(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
      new StoryWithAnswers(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
      new StoryWithAnswers(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
      new StoryWithAnswers(R.string.T4_End, null, null),
      new StoryWithAnswers(R.string.T5_End, null, null),
      new StoryWithAnswers(R.string.T6_End, null, null),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyTextView = findViewById(R.id.storyTextView);
        buttonTop = findViewById(R.id.buttonTop);
        buttonBottom = findViewById(R.id.buttonBottom);

        setInitialViewValues();

        buttonTop.setOnClickListener(buttonTopListener());
        buttonBottom.setOnClickListener(buttonBottomListener());
    }

    private void setInitialViewValues() {
        storyPathIndex = 0;
        buttonTop.setEnabled(true);
        buttonTop.setVisibility(View.VISIBLE);
        buttonBottom.setEnabled(true);
        buttonBottom.setVisibility(View.VISIBLE);
    }

    private void updateStory(int storyPathIndex) {
        int storyId = storyWithAnswers[storyPathIndex].getStoryTextId();
        storyTextView.setText(storyId);
        Integer answer1Id = storyWithAnswers[storyPathIndex].getStoryAnswer1Id();
        if (answer1Id != null) {
            buttonTop.setText(answer1Id);
        } else {
            buttonTop.setEnabled(false);
            buttonTop.setVisibility(View.INVISIBLE);
        }
        Integer answer2Id = storyWithAnswers[storyPathIndex].getStoryAnswer2Id();
        if (answer2Id != null) {
            buttonBottom.setText(answer2Id);
        } else {
            buttonBottom.setEnabled(false);
            buttonBottom.setVisibility(View.INVISIBLE);
        }
    }

    private View.OnClickListener buttonTopListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (storyPathIndex) {
                    case 0:
                    case 1:
                        storyPathIndex = 2;
                        break;
                    case 2:
                        storyPathIndex = 5;
                }
                updateStory(storyPathIndex);
            }
        };
    }

    private View.OnClickListener buttonBottomListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (storyPathIndex) {
                    case 0:
                        storyPathIndex = 1;
                        break;
                    case 1:
                        storyPathIndex = 3;
                        break;
                    case 2:
                        storyPathIndex = 4;
                        break;
                }
                updateStory(storyPathIndex);
            }
        };
    }
}
