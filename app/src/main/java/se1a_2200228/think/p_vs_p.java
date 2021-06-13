package se1a_2200228.think;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import pl.droidsonroids.gif.GifImageView;

public class p_vs_p extends AppCompatActivity {
    boolean p1visible = true, p2visible = true;
    TextView player1CatchCoin, player2CatchCoin;
    TextView coinNumber1, coinNumber2;
    TextView p1name, p2name;
    TextView P1Choice1, P1Choice2, P1Choice3, P1Choice4, P1Choice5;
    // TextView[] p1 = {P1Choice1,P1Choice2,P1Choice3,P1Choice4,P1Choice5};
    TextView P2Choice1, P2Choice2, P2Choice3, P2Choice4, P2Choice5;
    TextView showResult, resultTotalNumber, next;
    TextView hideTotal1, hideTotal2;
    TextView totalText1Here,totalText2Here;
    TextView totalNumber1Here,totalNumber2Here;
    GifImageView gifQuestionMarkP1, gifQuestionMarkP2;
    GifImageView gifPlayer1, gifPlayer2;
    ImageView questionMarkImage, helpIcon, settingIcon;
    ImageView p1Active, p2Active;
    ImageView panel1, panel2;
    Dialog mDialog, sDialog;
    int mainPoint = 10, catchCoin1, catchCoin2, add, total_1, total_2, choice1, choice2, choice3, choice4, choice5, mainCoin1, mainCoin2;
    String p1 = "", p2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_vs_p);
        player1CatchCoin = findViewById(R.id.player1CatchCoin);
        player2CatchCoin = findViewById(R.id.player2CatchCoin);
        coinNumber1 = findViewById(R.id.coinNumber1);
        coinNumber2 = findViewById(R.id.coinNumber2);

        P1Choice1 = findViewById(R.id.P1Choice1);
        P1Choice2 = findViewById(R.id.P1Choice2);
        P1Choice3 = findViewById(R.id.P1Choice3);
        P1Choice4 = findViewById(R.id.P1Choice4);
        P1Choice5 = findViewById(R.id.P1Choice5);

        P2Choice1 = findViewById(R.id.P2Choice1);
        P2Choice2 = findViewById(R.id.P2Choice2);
        P2Choice3 = findViewById(R.id.P2Choice3);
        P2Choice4 = findViewById(R.id.P2Choice4);
        P2Choice5 = findViewById(R.id.P2Choice5);

        showResult = findViewById(R.id.showResult);
        hideTotal1 = findViewById(R.id.hideTotal1);
        hideTotal2 = findViewById(R.id.hideTotal2);
        resultTotalNumber = findViewById(R.id.resultTotalNumber);
        next = findViewById(R.id.next);
        helpIcon = findViewById(R.id.helpIcon);
        settingIcon = findViewById(R.id.settingIcon);
        panel1 = findViewById(R.id.nextPanel1);
        panel2 = findViewById(R.id.nextPanel2);
        totalText1Here = findViewById(R.id.totalText1);
        totalText2Here = findViewById(R.id.totalText2);
        totalNumber1Here = findViewById(R.id.totalNumber1);
        totalNumber2Here = findViewById(R.id.totalNumber2);
        p1name = findViewById(R.id.playerText1);
        p2name = findViewById(R.id.playerText2);
        questionMarkImage = findViewById(R.id.questionMarkImage);
        gifQuestionMarkP1 = findViewById(R.id.gifQuestionMarkP1);
        gifQuestionMarkP2 = findViewById(R.id.gifQuestionMarkP2);
        gifPlayer1 = findViewById(R.id.gifPlayer1);
        gifPlayer2 = findViewById(R.id.gifPlayer2);
        mDialog = new Dialog(this);
        sDialog = new Dialog(this);


        helpIcon.setOnClickListener(v -> {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setTitle("ルール");
                    dialog.setMessage(getString(R.string.help_text));
                    dialog.setPositiveButton("OK",
                            (dialog1, which) -> {
                            });
                    AlertDialog alertDialog = dialog.create();
                    alertDialog.show();
        });
        settingIcon.setOnClickListener(v -> settingDialog());
        next_round();
    }
    public void game_reset_round_start(){
        p1choice_true();
        p2choice_true();
        totalNumber1Here.setVisibility(View.INVISIBLE);
        totalNumber2Here.setVisibility(View.INVISIBLE);
        player1CatchCoin.setText(String.valueOf(0));
        player2CatchCoin.setText(String.valueOf(0));
        resultTotalNumber.setText(String.valueOf(0));
        totalNumber1Here.setTextColor(getColor(R.color.black));
        totalNumber2Here.setTextColor(getColor(R.color.black));
        resultTotalNumber.setTextColor(getColor(R.color.cray_incorrect));
        panel1.setVisibility(View.INVISIBLE);
        panel2.setVisibility(View.INVISIBLE);
        p1visible = true;
        p2visible = true;
        next.setVisibility(View.INVISIBLE);
    }

    public void next_round(){
        showResult.setEnabled(false);
        p1choice();
        p2choice();
        totalText1Here.setVisibility(View.INVISIBLE);
        totalText2Here.setVisibility(View.INVISIBLE);
    }
    /////////////////// player1 choiceCoin ///////////////////
    public void  p1choice(){
        int p1 = 1;
        mainCoinCheck(p1);
        P1Choice1.setOnClickListener(v -> {
            choice1 = Integer.parseInt(P1Choice1.getText().toString());
                catchCoin1 = choice1;
                player1CatchCoin.setText(String.valueOf(catchCoin1));
                totalText1Here(p1);
        });
        P1Choice2.setOnClickListener(v -> {
            choice2 = Integer.parseInt(P1Choice2.getText().toString());
                catchCoin1 = choice2;
                player1CatchCoin.setText(String.valueOf(catchCoin1));
                totalText1Here(p1);
        });
        P1Choice3.setOnClickListener(v -> {
            choice3 = Integer.parseInt(P1Choice3.getText().toString());
                catchCoin1 = choice3;
                player1CatchCoin.setText(String.valueOf(catchCoin1));
                totalText1Here(p1);
        });
        P1Choice4.setOnClickListener(v -> {
            choice4 = Integer.parseInt(P1Choice4.getText().toString());
                catchCoin1 = choice4;
                player1CatchCoin.setText(String.valueOf(catchCoin1));
                totalText1Here(p1);
        });
        P1Choice5.setOnClickListener(v -> {
            choice5 = Integer.parseInt(P1Choice5.getText().toString());
                catchCoin1 = choice5;
                player1CatchCoin.setText(String.valueOf(catchCoin1));
                totalText1Here(p1);
        });
        totalText1Here.setOnClickListener(v -> numberPicker_onClick(p1));
        hide(p1);
    }

    /////////////////// player2 choiceCoin ///////////////////
    public void p2choice(){
        int p2 = 2;
        mainCoinCheck(p2);
        P2Choice1.setOnClickListener(v -> {
            choice1 = Integer.parseInt(P2Choice1.getText().toString());
                catchCoin2 = choice1;
                player2CatchCoin.setText(String.valueOf(catchCoin2));
                totalText1Here(p2);
        });
        P2Choice2.setOnClickListener(v -> {
            choice2 = Integer.parseInt(P2Choice2.getText().toString());
                catchCoin2 = choice2;
                player2CatchCoin.setText(String.valueOf(catchCoin2));
                totalText1Here(p2);
        });
        P2Choice3.setOnClickListener(v -> {
            choice3 = Integer.parseInt(P2Choice3.getText().toString());
                catchCoin2 = choice3;
                player2CatchCoin.setText(String.valueOf(catchCoin2));
                totalText1Here(p2);
        });
        P2Choice4.setOnClickListener(v -> {
            choice4 = Integer.parseInt(P2Choice4.getText().toString());
                catchCoin2 = choice4;
                player2CatchCoin.setText(String.valueOf(catchCoin2));
                totalText1Here(p2);
        });
        P2Choice5.setOnClickListener(v -> {
            choice5 = Integer.parseInt(P2Choice5.getText().toString());
                catchCoin2 = choice5;
                player2CatchCoin.setText(String.valueOf(catchCoin2));
                totalText1Here(p2);
        });
        totalText2Here.setOnClickListener(v -> numberPicker_onClick(p2));
        hide(p2);
    }

    public void hide(int p){
        int hide1 = 1, hide2 = 2;
        if(p == hide1){
            hideTotal1.setOnClickListener(v -> {
                int p1 = 1;
                gifQuestionMarkP1.setVisibility(View.VISIBLE);
                player1CatchCoin.setVisibility(View.INVISIBLE);
                gifPlayer1.setVisibility(View.VISIBLE);
                totalNumber1Here.setVisibility(View.INVISIBLE);
                totalText1Here.setVisibility(View.INVISIBLE);
                p1choice_false();
                p1visible = false;
                active_showTotal(p1);
            });
        }
        if(p == hide2){
            hideTotal2.setOnClickListener(v -> {
                int p2 = 2;
                gifQuestionMarkP2.setVisibility(View.VISIBLE);
                player2CatchCoin.setVisibility(View.INVISIBLE);
                gifPlayer2.setVisibility(View.VISIBLE);
                totalNumber2Here.setVisibility(View.INVISIBLE);
                totalText2Here.setVisibility(View.INVISIBLE);
                p2choice_false();
                p2visible = false;
                active_showTotal(p2);
            });
        }
    }
    public void p1choice_false(){
        P1Choice1.setEnabled(false);
        P1Choice2.setEnabled(false);
        P1Choice3.setEnabled(false);
        P1Choice4.setEnabled(false);
        P1Choice5.setEnabled(false);
    }
    public void p1choice_true(){
        P1Choice1.setEnabled(true);
        P1Choice2.setEnabled(true);
        P1Choice3.setEnabled(true);
        P1Choice4.setEnabled(true);
        P1Choice5.setEnabled(true);
    }
    public void p2choice_false(){
        P2Choice1.setEnabled(false);
        P2Choice2.setEnabled(false);
        P2Choice3.setEnabled(false);
        P2Choice4.setEnabled(false);
        P2Choice5.setEnabled(false);
    }
    public void p2choice_true(){
        P2Choice1.setEnabled(true);
        P2Choice2.setEnabled(true);
        P2Choice3.setEnabled(true);
        P2Choice4.setEnabled(true);
        P2Choice5.setEnabled(true);
    }
    /////////////////// totalTextHereActive ///////////////////
    public void totalText1Here(int p){
        int textHere_p1 = 1, textHere_p2 = 2;
        if(p == textHere_p1) {
            totalText1Here.setVisibility(View.VISIBLE);
        }
        if(p == textHere_p2){
            totalText2Here.setVisibility(View.VISIBLE);
        }
    }

    ////////////////////// numberChoice_onClick && total text here //////////////////////
    void numberPicker_onClick(int p){
        NumberPicker numberPicker = new NumberPicker(this);
        numberPicker.setMinValue(2);
        numberPicker.setMaxValue(10);
        numberPicker.setValue(5);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(numberPicker)
                .setPositiveButton("OK", (dialog, which) -> {
                    String.valueOf(numberPicker.getValue());
                    numberPicker.getValue();
                    int p1 = 1;
                    int p2 = 2;
                    if(p == p1){
                        totalNumber1Here.setText(String.valueOf(numberPicker.getValue()));
                        totalNumber1Here.setVisibility(View.VISIBLE);
                        hideTotal1.setVisibility(View.VISIBLE);
                        hideTotal1.setTextColor(getColor(R.color.active));
                    }
                    if(p == p2){
                        totalNumber2Here.setText(String.valueOf(numberPicker.getValue()));
                        totalNumber2Here.setVisibility(View.VISIBLE);
                        hideTotal2.setVisibility(View.VISIBLE);
                       hideTotal2.setTextColor(getColor(R.color.active));
                    }
                })
                .show();
    }

    public void active_showTotal(int hiding){
        int hid1 = 1, hid2 = 2;
        if(hid1 == hiding) {
            hideTotal1.setVisibility(View.INVISIBLE);
        }
        if(hid2 == hiding) {
            hideTotal2.setVisibility(View.INVISIBLE);
        }
        if (!p1visible && !p2visible) {
            showResult.setEnabled(true);
            showTotal_onClick();
        }
    }
    ////////////////////// show result   //////////////////////
    public void showTotal_onClick(){
        MediaPlayer correct =  MediaPlayer.create(this, R.raw.correct);
        MediaPlayer win =  MediaPlayer.create(this, R.raw.kids_cheering);

        ////////////////////// show result  //////////////////////
        showResult.setOnClickListener(v -> {
            total_1 = Integer.parseInt(totalNumber1Here.getText().toString());
            total_2 = Integer.parseInt(totalNumber2Here.getText().toString());
            mainCoin1 = Integer.parseInt(coinNumber1.getText().toString());
            mainCoin2 = Integer.parseInt(coinNumber2.getText().toString());
            add = catchCoin1 + catchCoin2;
            questionMarkImage.setVisibility(View.INVISIBLE);
            resultTotalNumber.setText((String.valueOf(add)));
            if (add == total_1 || add == total_2) {
                resultTotalNumber.setTextColor(getColor(R.color.green_correct));
                if (add == total_1) {
                    totalNumber1Here.setTextColor(getColor(R.color.green_correct));
                    mainCoin1 += catchCoin2;
                    mainCoin2 -= catchCoin2;
                } else {
                    totalNumber1Here.setTextColor(getColor(R.color.black));
                }
                if (add == total_2) {
                    totalNumber2Here.setTextColor(getColor(R.color.green_correct));
                    mainCoin2 += catchCoin1;
                    mainCoin1 -= catchCoin1;
                } else {
                    totalNumber2Here.setTextColor(getColor(R.color.black));
                }
                correct.start();
                coinNumber1.setText(String.valueOf(mainCoin1));
                coinNumber2.setText(String.valueOf(mainCoin2));
            } else {
                resultTotalNumber.setTextColor(getColor(R.color.cray_incorrect));
            }
            if(mainCoin1 == mainPoint*2 || mainCoin2 == mainPoint*2){
                win.start();
                win();
            }
            gifQuestionMarkP1.setVisibility(View.INVISIBLE);
            player1CatchCoin.setVisibility(View.VISIBLE);
            gifPlayer1.setVisibility(View.INVISIBLE);
            totalNumber1Here.setVisibility(View.VISIBLE);
            panel1.setVisibility(View.VISIBLE);
            p1choice_false();
            gifQuestionMarkP2.setVisibility(View.INVISIBLE);
            player2CatchCoin.setVisibility(View.VISIBLE);
            gifPlayer2.setVisibility(View.INVISIBLE);
            totalNumber2Here.setVisibility(View.VISIBLE);
            panel2.setVisibility(View.VISIBLE);
            p2choice_false();
            next();
            showResult.setEnabled(false);
            next.setVisibility(View.VISIBLE);
        });
    }
    ////////////////////////////// CoinCheck //////////////////////////////
    public void mainCoinCheck(int p){
        int p1 = 1, p2 = 2;
        if(p1 == p) {
            if (mainCoin1 == 4) {
                P1Choice5.setEnabled(false);
            } else if (mainCoin1 == 3) {
                P1Choice5.setEnabled(false);
                P1Choice4.setEnabled(false);
            } else if (mainCoin1 == 2) {
                P1Choice5.setEnabled(false);
                P1Choice4.setEnabled(false);
                P1Choice3.setEnabled(false);
            } else if (mainCoin1 == 1) {
                P1Choice5.setEnabled(false);
                P1Choice4.setEnabled(false);
                P1Choice3.setEnabled(false);
                P1Choice2.setEnabled(false);
            }
        }
        if(p2 == p) {
            if (mainCoin2 == 4) {
                P2Choice5.setEnabled(false);
            } else if (mainCoin2 == 3) {
                P2Choice5.setEnabled(false);
                P2Choice4.setEnabled(false);
            } else if (mainCoin2 == 2) {
                P2Choice5.setEnabled(false);
                P2Choice4.setEnabled(false);
                P2Choice3.setEnabled(false);
            } else if (mainCoin2 == 1) {
                P2Choice5.setEnabled(false);
                P2Choice4.setEnabled(false);
                P2Choice3.setEnabled(false);
                P2Choice2.setEnabled(false);
            }
        }
    }

    //////////////// mode change ////////////////


    /////////////// next ///////////////
    public void next(){
        next.setVisibility(View.VISIBLE);
        next.setTextColor(getColor(R.color.dark));
        next.setOnClickListener(v -> {
            game_reset_round_start();
            next_round();
        });
    }
    public void settingDialog(){
        sDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        sDialog.setContentView(R.layout.setting);

        TextView reset = sDialog.findViewById(R.id.resetButton);
        TextView home = sDialog.findViewById(R.id.homeButton);
        reset.setOnClickListener(v -> {
            coinNumber2.setText(String.valueOf(mainPoint));
            coinNumber1.setText(String.valueOf(mainPoint));
            sDialog.dismiss();
        });
        home.setOnClickListener(v -> {
            EditText p1nameEt = sDialog.findViewById(R.id.editTextTextPersonName1);
            String changeP1name = p1nameEt.getText().toString();
            p1name.setText(changeP1name);
            p1 = changeP1name;
            EditText p2nameEt = sDialog.findViewById(R.id.editTextTextPersonName2);
            String changeP2name = p2nameEt.getText().toString();
            p2name.setText(changeP2name);
            p2 = changeP2name;
            sDialog.dismiss();
        });
        sDialog.show();
    }

    public void win(){
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.setContentView(R.layout.winpopup);
        TextView home = mDialog.findViewById(R.id.homeButton);
        TextView winName = mDialog.findViewById(R.id.winnerName);
//        boolean win = true;
        if(mainCoin1 == mainPoint * 2){
            if(!p1.equals("")){
                winName.setText(p1);
            }else {
                winName.setText(getText(R.string.player1));
            }
        }
        if(mainCoin2 == mainPoint * 2){
            if(!p2.equals("")){
                winName.setText(p2);
            }
           winName.setText(getText(R.string.player2));
        }
        home.setOnClickListener(v -> {
            game_reset_round_start();
            coinNumber2.setText(String.valueOf(mainPoint));
            coinNumber1.setText(String.valueOf(mainPoint));
            mDialog.dismiss();
        });
        mDialog.show();
    }
}
