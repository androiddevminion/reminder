package com.yesh.reminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioButton;

/**
 * Created by yesh on 3/11/17.
 */

public class AmountSelectionScreen extends AppCompatActivity {

    private RadioButton eieghtozButton;
    private RadioButton twelveozButton;
    private RadioButton sixteenozButton;
    private int totalAmount;
    private int previousAmount;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amount_selection_layout);

        previousAmount = Utils.readSharedAmount(AmountSelectionScreen.this,MainActivity.PREF_USER_AMOUNT,0);

        eieghtozButton = (RadioButton)findViewById(R.id.radioButton1);
        twelveozButton = (RadioButton)findViewById(R.id.radioButton2);
        sixteenozButton = (RadioButton)findViewById(R.id.radioButton3);

        eieghtozButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                totalAmount = previousAmount + 8;
                Utils.saveSharedAmount(AmountSelectionScreen.this, MainActivity.PREF_USER_AMOUNT, totalAmount);
            }
        });

        twelveozButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                totalAmount = previousAmount + 12;
                Utils.saveSharedAmount(AmountSelectionScreen.this, MainActivity.PREF_USER_AMOUNT, totalAmount);
            }
        });

        sixteenozButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                totalAmount = previousAmount + 16;
                Utils.saveSharedAmount(AmountSelectionScreen.this, MainActivity.PREF_USER_AMOUNT, totalAmount);
            }
        });
    }
}
