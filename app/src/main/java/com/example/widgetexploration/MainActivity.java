package com.example.widgetexploration;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);

        // Get a reference to all our widgets
        RadioGroup radioGroup = (RadioGroup)
                findViewById(R.id.radioGroup);
        final EditText editText =
                (EditText) findViewById(R.id.editText);
        final Button button =
                (Button) findViewById(R.id.button);
        final TextClock tClock =
                (TextClock) findViewById(R.id.textClock);
        final CheckBox cbTransparency =
                (CheckBox) findViewById(R.id.checkBoxTransparency);
        final CheckBox cbTint =
                (CheckBox) findViewById(R.id.checkBoxTint);
        final CheckBox cbReSize =
                (CheckBox) findViewById(R.id.checkBoxReSize);
        final ImageView imageView =
                (ImageView) findViewById(R.id.imageView);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        final TextView textView =
                (android.widget.TextView) findViewById(R.id.textView);
// Hide the TextView at the start of the app
        textView.setVisibility(View.INVISIBLE);

        // First the check boxes using an anonymous class
        cbTransparency.setOnCheckedChangeListener(new
                                                          CompoundButton.OnCheckedChangeListener() {
                                                              public void onCheckedChanged(
                                                                      CompoundButton buttonView, boolean isChecked) {
                                                                  if (cbTransparency.isChecked()) {
                                                                      // Set some transparency
                                                                      imageView.setAlpha(.1f);
                                                                  } else {
                                                                      imageView.setAlpha(1f);
                                                                  }
                                                              }
                                                          });


// Now the next checkbox
        cbTint.setOnCheckedChangeListener(new
                                                  CompoundButton.OnCheckedChangeListener() {
                                                      public void onCheckedChanged(CompoundButton
                                                                                           buttonView, boolean isChecked) {
                                                          if (cbTint.isChecked()) {
                                                              // Checked so set some tint
                                                              imageView.setColorFilter(
                                                                      Color.argb(150, 255, 0, 0));
                                                          } else {
                                                              // No tint needed
                                                              imageView.setColorFilter(Color.argb(0, 0, 0, 0));
                                                          }
                                                      }
                                                  });

        // And the last check box
        cbReSize.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (cbReSize.isChecked()) {
                            // It's checked so make bigger
                            imageView.setScaleX(2);
                            imageView.setScaleY(2);
                        } else {
                            // It's not checked make regular size
                            imageView.setScaleX(1);
                            imageView.setScaleY(1);
                        }
                    }
                });

        // Now for the radio buttons
// Uncheck all buttons
        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.
                OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(
                    RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton)
                        group.findViewById(checkedId);

                switch (rb.getId()) {
                    case R.id.radioButtonLondon:
                        tClock.setTimeZone("Europe/London");
                        break;
                    case R.id.radioButtonBeijing:
                        tClock.setTimeZone("CST6CDT");
                        break;
                    case R.id.radioButtonNewYork:

                        tClock.setTimeZone(
                                "America/New_York");
                        break;
                    case R.id.radioButtonEuropeanEmpire:
                        tClock.setTimeZone(
                                "Europe/Brussels");
                        break;

                }// End switch block
            }
        });

        /*
 Let's listen for clicks on our "Capture" Button.
 We can do this with an anonymous class as well.
 An interface seems a bit much for one button.
*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We only handle one button
                // So, no switching required

                // Change the text on the TextView
                // to whatever is currently in the EditText
                textView.setText(editText.getText());
            }
        });

        // Show or hide the TextView
        switch1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {

                    public void onCheckedChanged(
                            CompoundButton buttonView, boolean isChecked) {

                        if(isChecked){
                            textView.setVisibility(View.VISIBLE);
                        }else{
                            textView.setVisibility(View.INVISIBLE);
                        }
                    }
                });
    }
}