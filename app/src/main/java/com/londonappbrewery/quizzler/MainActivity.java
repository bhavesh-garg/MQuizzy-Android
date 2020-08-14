package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.AlertDialogLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:

    Button mTrueB;
    Button mfalseB;
    int index=0;
    TextView mQText;
     int score =0;

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13, true)
    };
     TextView mScoreText;
     ProgressBar mProgressBar;
     int mProgressNo = (int) Math.ceil(100.0/mQuestionBank.length);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText = findViewById(R.id.score);
        mProgressBar = findViewById(R.id.progress_bar);


        mQText = findViewById(R.id.question_text_view);
        mQText.setText(mQuestionBank[index].getQestionId());

        mTrueB = findViewById(R.id.true_button);
        mTrueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAns(true);
                updateQuestion();
            }
        });

        mfalseB = findViewById(R.id.false_button);
        mfalseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAns(false);
                updateQuestion();
            }
        });
    }

   void updateQuestion()
   {
       index= (index+1) % mQuestionBank.length;
       if(index==0)
       {
           AlertDialog.Builder builder
                   = new AlertDialog
                   .Builder(MainActivity.this);

           // Set the message show for the Alert time
           builder.setMessage("Total Score    " + score);

           // Set Alert Title
           builder.setTitle("Quiz End");

           // Set Cancelable false
           // for when the user clicks on the outside
           // the Dialog Box then it will remain show
           builder.setCancelable(false);

           // Set the positive button with yes name
           // OnClickListener method is use of
           // DialogInterface interface.

           builder.setPositiveButton(
                           "Exit",
                           new DialogInterface
                                   .OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog,
                                                   int which)
                               {

                                   // When the user click yes button
                                   // then app will close
                                   finish();
                               }
                           });
           // Create the Alert dialog
           AlertDialog alertDialog = builder.create();

           // Show the Alert Dialog box
           alertDialog.show();

       }

       mQText.setText(mQuestionBank[index].getQestionId());
       mScoreText.setText("Score "+ score +"/"+ mQuestionBank.length);
       mProgressBar.incrementProgressBy(mProgressNo);

   }
  void checkAns(Boolean selestAns)
  {
      boolean correctAns = mQuestionBank[index].isAns();
      if (correctAns==selestAns){
          Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
          score = score+1;
      }
      else{
          Toast.makeText(getApplicationContext(),R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
      }
  }





//    public void pressf(View v)
//    {
//        Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
//
//    }
//    TrueFalse q1 = new TrueFalse(R.string.question_1,true);


}
