package se1a_2200228.think;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class p_vs_c extends AppCompatActivity {

    TextView PChoice1,PChoice2,PChoice3,PChoice4,PChoice5;
    TextView playerCatchCoin, hide, totalHere, pMainCoin, comMainCoin,computerCatchCoin,resultTotalNumber;
    TextView pTotalNumber, comTotalNumber ,next,showResult;
    GifImageView gifPlayer,gifComputer,gifQuestionMarkP1,gifQuestionMarkP2;
    ImageView helpIcon;
    int choice1,choice2,choice3,choice4,choice5, playerCatch, comCatch, total, comTotal, pTotal, comMainCoinInt, pMainCoinInt;
    Dialog mDialog, sDialog;
    boolean hide_button = false, comWin = false, pWin = false;
    boolean gone = false;
    final  int mainPoint = 10;
    String p1 = "", p2 = "";
    public Choice_p_vs_c choice_p_vs_c;
    //    Choice_p_vs_c choice_p_vs_c = new Choice_p_vs_c();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_vs_c);
        PChoice1 = findViewById(R.id.PChoice1);
        PChoice2 = findViewById(R.id.PChoice2);
        PChoice3 = findViewById(R.id.PChoice3);
        PChoice4 = findViewById(R.id.PChoice4);
        PChoice5 = findViewById(R.id.PChoice5);
        hide = findViewById(R.id.hideTotal);
        pMainCoin = findViewById(R.id.pMaiCoin);
        comMainCoin = findViewById(R.id.comMainCoin);
        totalHere = findViewById(R.id.totalHereText);
        playerCatchCoin = findViewById(R.id.playerCatchCoin);
        computerCatchCoin = findViewById(R.id.ComputerCatchCoin);
        gifPlayer = findViewById(R.id.gifPlayer);
        gifComputer = findViewById(R.id.gifComputer);
        resultTotalNumber = findViewById(R.id.resultTotalNumber);
        gifQuestionMarkP1 = findViewById(R.id.gifQuestionMarkP1);
        gifQuestionMarkP2 = findViewById(R.id.gifQuestionMarkP2);
        pTotalNumber = findViewById(R.id.pTotalNumber);
        comTotalNumber = findViewById(R.id.comTotalNumber);
        next = findViewById(R.id.next);
        showResult = findViewById(R.id.showResult);
        helpIcon = findViewById(R.id.helpIcon);
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
        pChoice();

    }
    public void pChoice(){
        hide_button = true;
        PChoice1.setOnClickListener(v -> {
            choice1 = Integer.parseInt(PChoice1.getText().toString());
            playerCatch = choice1;
            playerCatchCoin.setText(String.valueOf(playerCatch));
            hide();
        });
        PChoice2.setOnClickListener(v -> {
//            choice_p_vs_c.pChoice2();
            choice2 = Integer.parseInt(PChoice2.getText().toString());
            playerCatch = choice2;
            playerCatchCoin.setText(String.valueOf(playerCatch));
            hide();
        });
        PChoice3.setOnClickListener(v -> {
            choice3 = Integer.parseInt(PChoice3.getText().toString());
            playerCatch = choice3;
            playerCatchCoin.setText(String.valueOf(playerCatch));
            hide();
        });
        PChoice4.setOnClickListener(v -> {
            choice4 = Integer.parseInt(PChoice4.getText().toString());
            playerCatch = choice4;
            playerCatchCoin.setText(String.valueOf(playerCatch));
            hide();
        });
        PChoice5.setOnClickListener(v -> {
            choice5= Integer.parseInt(PChoice5.getText().toString());
            playerCatch = choice5;
            playerCatchCoin.setText(String.valueOf(playerCatch));
            hide();
        });
    }
    ///////////////////////////// hide /////////////////////////////
    public  void hide(){
        if(hide_button){
            hide.setVisibility(View.VISIBLE);
            hide.setOnClickListener(v -> {
                gifPlayer.setVisibility(View.VISIBLE);
                hide.setVisibility(View.INVISIBLE);
                playerCatchCoin.setVisibility(View.INVISIBLE);
                totalHere.setVisibility(View.VISIBLE);
                totalHere();
                p1choice_false();
                comTotalNumber.setVisibility(View.VISIBLE);
                computer();
            });
        }else{
            hide.setVisibility(View.INVISIBLE);
        }
    }

    public void totalHere(){
        totalHere.setOnClickListener(v -> {
            numberPicker();
            showResult.setVisibility(View.VISIBLE);
            showResult();
        });
    }

    public void computer(){
        Random rd = new Random();
        comCatch = rd.nextInt(5) + 1;
        computerCatchCoin.setText(String.valueOf(comCatch));
        new  Thread(() -> {
            for(int i = 0; i<50;i++) {
                try {
                    Thread.sleep(50);
                    Random rand = new Random();
                    int min = comCatch + 1, max = comCatch + 5;
                    comTotal = rand.nextInt(max - min + 1) + min;
                    comTotalNumber.post(() -> comTotalNumber.setText(String.valueOf(comTotal)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void numberPicker(){
        NumberPicker numberPicker = new NumberPicker(this);
        numberPicker.setMinValue(2);
        numberPicker.setMaxValue(10);
        numberPicker.setValue(5);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(numberPicker)
                .setPositiveButton("OK", (dialog, which) -> {
                    String.valueOf(numberPicker.getValue());
                    numberPicker.getValue();
                    pTotalNumber.setText(String.valueOf(numberPicker.getValue()));
                    pTotalNumber.setVisibility(View.VISIBLE);
                    pTotal = Integer.parseInt(pTotalNumber.getText().toString());
                })
                .show();
    }
    public void showResult(){
        showResult.setOnClickListener(v -> {
            playerCatchCoin.setVisibility(View.VISIBLE);
            computerCatchCoin.setVisibility(View.VISIBLE);
            gifPlayer.setVisibility(View.INVISIBLE);
            gifComputer.setVisibility(View.INVISIBLE);
            total = comCatch + playerCatch;
            resultTotalNumber.setText(String.valueOf(total));
            totalHere.setVisibility(View.INVISIBLE);
            pointCalc();
            next.setVisibility(View.VISIBLE);
            showResult.setVisibility(View.INVISIBLE);
            next.setOnClickListener(v1 -> game_end_start_next());
        });
    }
    public void pointCalc(){
        MediaPlayer correct =  MediaPlayer.create(this, R.raw.correct);
        MediaPlayer win =  MediaPlayer.create(this, R.raw.kids_cheering);
        comMainCoinInt = Integer.parseInt(comMainCoin.getText().toString());
        pMainCoinInt = Integer.parseInt(pMainCoin.getText().toString());
        if(total == comTotal || total == pTotal){
            resultTotalNumber.setTextColor(getColor(R.color.green_correct));
            if(total == comTotal){
                comMainCoinInt += playerCatch;
                pMainCoinInt -= playerCatch;
                comTotalNumber.setTextColor(getColor(R.color.green_correct));
            }
            if(total == pTotal){
                pMainCoinInt += comCatch;
                comMainCoinInt -= comCatch;
                pTotalNumber.setTextColor(getColor(R.color.green_correct));
            }
            comMainCoin.setText(String.valueOf(comMainCoinInt));
            pMainCoin.setText(String.valueOf(pMainCoinInt));
            correct.start();
        }else{
            resultTotalNumber.setTextColor(getColor(R.color.cray_incorrect));
        }
        if(comMainCoinInt == mainPoint * 2 || pMainCoinInt == mainPoint * 2){
            win();
            win.start();
        }
    }
    public void playerMainCoinCheck(){
        if (pMainCoinInt == 4) {
            PChoice5.setEnabled(false);
        } else if (pMainCoinInt == 3) {
            PChoice5.setEnabled(false);
            PChoice4.setEnabled(false);
        } else if (pMainCoinInt == 2) {
            PChoice5.setEnabled(false);
            PChoice4.setEnabled(false);
            PChoice3.setEnabled(false);
        } else if (pMainCoinInt == 1) {
            PChoice5.setEnabled(false);
            PChoice4.setEnabled(false);
            PChoice3.setEnabled(false);
            PChoice2.setEnabled(false);
        }
    }
    public void game_end_start_next(){
        comTotalNumber.setVisibility(View.INVISIBLE);
        computerCatchCoin.setVisibility(View.INVISIBLE);
        gifComputer.setVisibility(View.VISIBLE);
        pTotalNumber.setVisibility(View.INVISIBLE);
        playerCatchCoin.setText("0");
        next.setVisibility(View.INVISIBLE);
        resultTotalNumber.setText("0");
        resultTotalNumber.setTextColor(getColor(R.color.cray_incorrect));
        comTotalNumber.setTextColor(getColor(R.color.black));
        pTotalNumber.setTextColor(getColor(R.color.black));
        p1choice_true();
        if(pMainCoinInt <= 5){
            playerMainCoinCheck();
        }
    }

    public void win(){
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.setContentView(R.layout.winpopup);
        TextView home = mDialog.findViewById(R.id.homeButton);
        TextView winName = mDialog.findViewById(R.id.winnerName);
//        boolean win = true;
        if(pMainCoinInt == mainPoint * 2){
            if(!p1.equals("")){
                winName.setText(p1);
            }else {
                winName.setText(getText(R.string.player1));
            }
        }
        if(comMainCoinInt == mainPoint * 2){
            if(!p2.equals("")){
                winName.setText(p2);
            }
            winName.setText(getText(R.string.computer));
        }
        home.setOnClickListener(v -> {
            game_end_start_next();
            pMainCoin.setText(String.valueOf(mainPoint));
            comMainCoin.setText(String.valueOf(mainPoint));
            mDialog.dismiss();
        });
        mDialog.show();
    }
    public void p1choice_false(){
        PChoice1.setEnabled(false);
        PChoice2.setEnabled(false);
        PChoice3.setEnabled(false);
        PChoice4.setEnabled(false);
        PChoice5.setEnabled(false);
    }
    public void p1choice_true(){
        PChoice1.setEnabled(true);
        PChoice2.setEnabled(true);
        PChoice3.setEnabled(true);
        PChoice4.setEnabled(true);
        PChoice5.setEnabled(true);
    }
}