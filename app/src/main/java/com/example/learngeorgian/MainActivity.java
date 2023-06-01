package com.example.learngeorgian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    ImageButton arrow1, arrow2, arrow3;
    LinearLayout hiddenView1, hiddenView2, hiddenView3;
    CardView cardView1, cardView2, cardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrow1 = findViewById(R.id.arrow_button);
        arrow2 = findViewById(R.id.arrow_button2);
        arrow3 = findViewById(R.id.arrow_button3);
        cardView1 = findViewById(R.id.base_cardview);
        cardView2 = findViewById(R.id.base_cardview2);
        cardView3 = findViewById(R.id.base_cardview3);
        hiddenView1 = findViewById(R.id.hidden_view);
        hiddenView2 = findViewById(R.id.hidden_view2);
        hiddenView3 = findViewById(R.id.hidden_view3);

        arrow1.setOnClickListener(v -> {
            Expansion(hiddenView1, cardView1);
        });
        arrow2.setOnClickListener(v -> {
            Expansion(hiddenView2, cardView2);
        });
        arrow3.setOnClickListener(v -> {
            Expansion(hiddenView3, cardView3);
        });


    }

//    public void Test(View view) {
//        ImageButton arrow = (ImageButton) view;
//        CardView hv = (CardView) arrow.getParentForAccessibility().getParentForAccessibility();
//
//    }

    public void Expansion(View hiddenView, View cardView) {
        // If the CardView is already expanded, set its visibility
        // to gone and change the expand less icon to expand more.
        if (hiddenView.getVisibility() == View.VISIBLE) {
            // The transition of the hiddenView1 is carried out by the TransitionManager class.
            // Here we use an object of the AutoTransition Class to create a default transition
            TransitionManager.beginDelayedTransition((ViewGroup) cardView, new AutoTransition());
            hiddenView.setVisibility(View.GONE);
        }

        // If the CardView is not expanded, set its visibility to
        // visible and change the expand more icon to expand less.
        else {
            TransitionManager.beginDelayedTransition((ViewGroup) cardView, new AutoTransition());
            hiddenView.setVisibility(View.VISIBLE);
        }
    }

    public void showTranslation(View view) {
        TextView tv = (TextView) view;

        Toast.makeText(this, tv.getHint(), Toast.LENGTH_SHORT).show();
    }

    public void SayTheWord(View view) {
        ImageButton btn = (ImageButton) view;

        MediaPlayer mediaPlayer = MediaPlayer.create(this,
                getResources().getIdentifier(btn.getTag().toString(), "raw", getPackageName())
        );
        mediaPlayer.start();

        //all that's left is to add the tags and OnClick to each ImageView
    }
}