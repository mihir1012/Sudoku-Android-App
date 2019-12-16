package com.mihir1012.marudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int[][][] matrix = new int[][][]{{
            {3, 4, 5, 8, 7, 1, 6, 9, 2},
            {8, 1, 6, 2, 5, 9, 3, 7, 4},
            {7, 9, 2, 3, 4, 6, 5, 1, 8},
            {6, 2, 7, 9, 3, 8, 1, 4, 5},
            {4, 5, 1, 6, 2, 7, 8, 3, 9},
            {9, 8, 3, 4, 1, 5, 2, 6, 7},
            {5, 7, 4, 1, 8, 3, 9, 2, 6},
            {1, 6, 8, 7, 9, 2, 4, 5, 3},
            {2, 3, 9, 5, 6, 4, 7, 8, 1}
    },{     {1, 3, 9, 4, 8, 5, 7, 6, 2},
            {7, 6, 2, 1, 9, 3, 8, 4, 5},
            {4, 5, 8, 6, 7, 2, 9, 3, 1},
            {2, 9, 5, 7, 6, 8, 4, 1, 3},
            {6, 8, 1, 2, 3, 4, 5, 7, 9},
            {3, 7, 4, 9, 5, 1, 2, 8, 6},
            {5, 4, 6, 8, 1, 9, 3, 2, 7},
            {9, 2, 7, 3, 4, 6, 1, 5, 8},
            {8, 1, 3, 5, 2, 7, 6, 9, 4}
    }};
    int boxid[][] = new int[9][9];
    int buttonid[] = new int[9];
    int selectedNumber,prevSelectedNumber = 0;
    boolean isSelected = false;
    int completed = 0,mistake = 0;
    TextView textView, tv[][] = new TextView[9][9], buttonview[] = new TextView[9];
    Random r = new Random();
    int SelectedMatrix = (new Random()).nextInt(matrix.length);
    boolean flag[] = new boolean[81];
    int countNumber[]= new int[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.Hello);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boxid[i][j] = getResources().getIdentifier("r" + (i + 1) + "c" + (j+ 1), "id", getPackageName());
                tv[i][j] = findViewById(boxid[i][j]);
            }
        }

        for (int i = 0 ; i< 9 ; i++) {
            buttonid[i] = getResources().getIdentifier("button" + (i + 1), "id", getPackageName());
            buttonview[i] = findViewById(buttonid[i]);
        }
        for(int k = 0; k <= 80; k++)
            flag[k] = false;

        for(int i = 0 ;i < 9; i++)
            countNumber[i] = 0;
        /*tv[0][1]= findViewById(R.id.r1c2);
        tv[0][2]= findViewById(R.id.r1c3);
        tv[0][3]= findViewById(R.id.r1c4);
        tv[0][4]= findViewById(R.id.r1c5);
        tv[0][5]= findViewById(R.id.r1c6);
        tv[0][6]= findViewById(R.id.r1c7);
        tv[0][7]= findViewById(R.id.r1c8);
        tv[0][8]= findViewById(R.id.r1c9);
        tv[1][0]= findViewById(R.id.r2c1);
        tv[1][1]= findViewById(R.id.r2c2);
        tv[1][2]= findViewById(R.id.r2c3);
        tv[1][3]= findViewById(R.id.r2c4);
        tv[1][4]= findViewById(R.id.r2c5);
        tv[1][5]= findViewById(R.id.r2c6);
        tv[1][6]= findViewById(R.id.r2c7);
        tv[1][7]= findViewById(R.id.r2c8);
        tv[1][8]= findViewById(R.id.r2c9);
        tv[2][0]= findViewById(R.id.r3c1);
        tv[2][1]= findViewById(R.id.r3c2);
        tv[2][2]= findViewById(R.id.r3c3);
        tv[2][3]= findViewById(R.id.r3c4);
        tv[2][4]= findViewById(R.id.r3c5);
        tv[2][5]= findViewById(R.id.r3c6);
        tv[2][6]= findViewById(R.id.r3c7);
        tv[2][7]= findViewById(R.id.r3c8);
        tv[2][8]= findViewById(R.id.r3c9);
        tv[3][0]= findViewById(R.id.r4c1);
        tv[3][1]= findViewById(R.id.r4c2);
        tv[3][2]= findViewById(R.id.r4c3);
        tv[3][3]= findViewById(R.id.r4c4);
        tv[3][4]= findViewById(R.id.r4c5);
        tv[3][5]= findViewById(R.id.r4c6);
        tv[3][6]= findViewById(R.id.r4c7);
        tv[3][7]= findViewById(R.id.r4c8);
        tv[3][8]= findViewById(R.id.r4c9);
        tv[4][0]= findViewById(R.id.r5c1);
        tv[4][1]= findViewById(R.id.r5c2);
        tv[4][2]= findViewById(R.id.r5c3);
        tv[4][3]= findViewById(R.id.r5c4);
        tv[4][4]= findViewById(R.id.r5c5);
        tv[4][5]= findViewById(R.id.r5c6);
        tv[4][6]= findViewById(R.id.r5c7);
        tv[4][7]= findViewById(R.id.r5c8);
        tv[4][8]= findViewById(R.id.r5c9);
        tv[5][0]= findViewById(R.id.r6c1);
        tv[5][1]= findViewById(R.id.r6c2);
        tv[5][2]= findViewById(R.id.r6c3);
        tv[5][3]= findViewById(R.id.r6c4);
        tv[5][4]= findViewById(R.id.r6c5);
        tv[5][5]= findViewById(R.id.r6c6);
        tv[5][6]= findViewById(R.id.r6c7);
        tv[5][7]= findViewById(R.id.r6c8);
        tv[5][8]= findViewById(R.id.r6c9);
        tv[6][0]= findViewById(R.id.r7c1);
        tv[6][1]= findViewById(R.id.r7c2);
        tv[6][2]= findViewById(R.id.r7c3);
        tv[6][3]= findViewById(R.id.r7c4);
        tv[6][4]= findViewById(R.id.r7c5);
        tv[6][5]= findViewById(R.id.r7c6);
        tv[6][6]= findViewById(R.id.r7c7);
        tv[6][7]= findViewById(R.id.r7c8);
        tv[6][8]= findViewById(R.id.r7c9);
        tv[7][0]= findViewById(R.id.r8c1);
        tv[7][1]= findViewById(R.id.r8c2);
        tv[7][2]= findViewById(R.id.r8c3);
        tv[7][3]= findViewById(R.id.r8c4);
        tv[7][4]= findViewById(R.id.r8c5);
        tv[7][5]= findViewById(R.id.r8c6);
        tv[7][6]= findViewById(R.id.r8c7);
        tv[7][7]= findViewById(R.id.r8c8);
        tv[7][8]= findViewById(R.id.r8c9);
        tv[8][0]= findViewById(R.id.r9c1);
        tv[8][1]= findViewById(R.id.r9c2);
        tv[8][2]= findViewById(R.id.r9c3);
        tv[8][3]= findViewById(R.id.r9c4);
        tv[8][4]= findViewById(R.id.r9c5);
        tv[8][5]= findViewById(R.id.r9c6);
        tv[8][6]= findViewById(R.id.r9c7);
        tv[8][7]= findViewById(R.id.r9c8);
        tv[8][8]= findViewById(R.id.r9c9);*/
        SetGrid();
    }

    public void ValueChange(View view) {
//        switch (view.getId()){
//            case R.id.r1c1:
//                d = r.nextInt(numbers.length);
//                tv[0][0].setText(Integer.toString(numbers[d]));
//                break;
//            case R.id.r1c2:
//                d = r.nextInt(numbers.length);
//                tv[0][1].setText(Integer.toString(numbers[d]));
//                break;
//            case R.id.r1c3:
//                d = r.nextInt(numbers.length);
//                tv[0][2].setText(Integer.toString(numbers[d]));
//               break;
//            case R.id.r1c4:
//                d = r.nextInt(numbers.length);
//                tv[0][3].setText(Integer.toString(numbers[d]));
//                break;
//        }

        if(isSelected) {
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++) {
                    if (view.getId() == boxid[i][j] && !flag[(i*9)+j]) {
                        isSelected = false;
                        tv[i][j].setText(Integer.toString(selectedNumber));
                        if(selectedNumber==matrix[SelectedMatrix][i][j]){
                            tv[i][j].setTextColor(Color.rgb(150,180,255));
                            countNumber[selectedNumber - 1 ]++;
                            completed++;
                        }
                        else{
                            tv[i][j].setTextColor(Color.rgb(255,105,97));
                            mistake++;
                            textView.setText(Integer.toString(mistake));
                        }
                    }
                    resetBackground(i,j,selectedNumber);

                }
//            for (int i = 0 ; i < 9 ; i++)
//                for (int j = 0 ; j< 9 ;j++){
//                    if(Integer.parseInt(tv[i][j].getText().toString())==selectedNumber){
//                        tv[i][j].setBackground(getResources().getDrawable(R.drawable.backgroundstrokes) );
//                    }
//                }
        }

        if (countNumber[selectedNumber - 1] == 9){
            buttonview[selectedNumber -1].setText("  ");
            buttonview[selectedNumber -1].setClickable(false);
        }

        if (completed == 81){
            textView.setText("Winner");
        }
    }
    public void resetBackground(int i , int j, int NumberSelected){
        if(!tv[i][j].getText().toString().equals("") && Integer.parseInt(tv[i][j].getText().toString()) == NumberSelected){

            if(i < 3 || i > 5){
                if ( j > 2 && j < 6){

                    tv[i][j].setBackground(getResources().getDrawable(R.drawable.lightgreenbackground));
                }
                else{
                    tv[i][j].setBackground(getResources().getDrawable(R.drawable.darkgreenbackground));
                }
            }
            else{
                if ( j < 3  || j > 5 ){
                    tv[i][j].setBackground(getResources().getDrawable(R.drawable.lightgreenbackground));
                }
                else{
                    tv[i][j].setBackground(getResources().getDrawable(R.drawable.darkgreenbackground));
                }
            }
        }
    }
    public void SelectValue(View view) {
        if (isSelected){
            for ( int i  = 0 ; i < 9 ; i++) {
                for (int j = 0; j < 9; j++) {
                    resetBackground(i,j,prevSelectedNumber);
                }
            }
        }
        isSelected = false;
        for (int i = 0 ; i < 9 ; i++ ){
            if(view.getId() == buttonid[i]){
                selectedNumber = i+1;
                break;
            }
        }
        for ( int i  = 0 ; i < 9 ; i++){
            for ( int j = 0 ; j < 9 ; j++ )
            {
                if( !isSelected && !tv[i][j].getText().toString().equals("") && Integer.parseInt(tv[i][j].getText().toString()) == selectedNumber){
                    tv[i][j].setBackground(getResources().getDrawable(R.drawable.whitebackground));
                }
            }
        }
        isSelected = true;
        prevSelectedNumber = selectedNumber;
//        switch (view.getId()) {
//            case R.id.button1:
//                selectedNumber = 1;
//                isSelected = true;
//                break;
//            case R.id.button2:
//                selectedNumber = 2;
//                isSelected = true;
//                break;
//            case R.id.button3:
//                selectedNumber = 3;
//                isSelected = true;
//                break;
//            case R.id.button4:
//                selectedNumber = 4;
//                isSelected = true;
//                break;
//            case R.id.button5:
//                selectedNumber = 5;
//                isSelected = true;
//                break;
//            case R.id.button6:
//                selectedNumber = 6;
//                isSelected = true;
//                break;
//            case R.id.button7:
//                selectedNumber = 7;
//                isSelected = true;
//                break;
//            case R.id.button8:
//                selectedNumber = 8;
//                isSelected = true;
//                break;
//            case R.id.button9:
//                selectedNumber = 9;
//                isSelected = true;
//                break;
//        }
    }

    void SetGrid() {
        int TotalVisible = (new Random()).nextInt(45-25+1)+25;
//        TotalVisible =5;
        int VisibleCount = 0;

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                tv[i][j].setText("");
        while (VisibleCount <= TotalVisible) {
            int k = 0;
            int RandomPlace = (new Random()).nextInt(81 - 1 + 1) + 1;
            for( int i = 0 ;i < 9  ; i++)
                for (int j = 0 ; j < 9; j++) {
                    if(k==RandomPlace && !flag[k]){
                        tv[i][j].setText(Integer.toString(matrix[SelectedMatrix][i][j]));
                        tv[i][j].setTextColor(Color.DKGRAY);
                        flag[k] = true;
                        countNumber[matrix[SelectedMatrix][i][j]-1]++;
                        VisibleCount++;

                    }
                    k++;
                }
//                    tv[0][8].setText(Integer.toString(matrix[SelectedMatrix][0][8]));
//                    tv[0][8].setTextColor(Color.DKGRAY);
//                    tv[0][8].setClickable(false);
//                    flag[8] = true;
//                    break;

        }
//        for (int i = 0 ; i < 9 ; i++) {
//         for (int j = 0; j < 9; j++) {
//                tv[i][j].setText(Integer.toString(matrix[(new Random()).nextInt(matrix.length)][i][j]));
//            }
//        }
//       tv[8][8].setText(Integer.toString(matrix[0][8][8]));
        completed = VisibleCount;
    }

}