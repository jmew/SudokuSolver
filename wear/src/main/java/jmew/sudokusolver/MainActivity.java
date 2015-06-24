package jmew.sudokusolver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public int[][] sudoku = new int[9][9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {

                Intent sudokuIntent = getIntent();
                Bundle sudokuBundle = sudokuIntent.getExtras();

                if (sudokuBundle != null) {
                    sudoku = (int[][]) sudokuBundle.getSerializable("sudoku");
                    int[][] subSudoku = (int[][]) sudokuBundle.getSerializable("sub sudoku");
                    int gridNumber = (int) sudokuBundle.getSerializable("grid number");

                    switch (gridNumber) {
                        case 1:
                            sudoku[0][0] = subSudoku[0][0];
                            sudoku[0][1] = subSudoku[0][1];
                            sudoku[0][2] = subSudoku[0][2];
                            sudoku[1][0] = subSudoku[1][0];
                            sudoku[1][1] = subSudoku[1][1];
                            sudoku[1][2] = subSudoku[1][2];
                            sudoku[2][0] = subSudoku[2][0];
                            sudoku[2][1] = subSudoku[2][1];
                            sudoku[2][2] = subSudoku[2][2];
                            break;
                        case 2:
                            sudoku[0][3] = subSudoku[0][0];
                            sudoku[0][4] = subSudoku[0][1];
                            sudoku[0][5] = subSudoku[0][2];
                            sudoku[1][3] = subSudoku[1][0];
                            sudoku[1][4] = subSudoku[1][1];
                            sudoku[1][5] = subSudoku[1][2];
                            sudoku[2][3] = subSudoku[2][0];
                            sudoku[2][4] = subSudoku[2][1];
                            sudoku[2][5] = subSudoku[2][2];
                            break;
                        case 3:
                            sudoku[0][6] = subSudoku[0][0];
                            sudoku[0][7] = subSudoku[0][1];
                            sudoku[0][8] = subSudoku[0][2];
                            sudoku[1][6] = subSudoku[1][0];
                            sudoku[1][7] = subSudoku[1][1];
                            sudoku[1][8] = subSudoku[1][2];
                            sudoku[2][6] = subSudoku[2][0];
                            sudoku[2][7] = subSudoku[2][1];
                            sudoku[2][8] = subSudoku[2][2];
                            break;
                        case 4:
                            sudoku[3][0] = subSudoku[0][0];
                            sudoku[3][1] = subSudoku[0][1];
                            sudoku[3][2] = subSudoku[0][2];
                            sudoku[4][0] = subSudoku[1][0];
                            sudoku[4][1] = subSudoku[1][1];
                            sudoku[4][2] = subSudoku[1][2];
                            sudoku[5][0] = subSudoku[2][0];
                            sudoku[5][1] = subSudoku[2][1];
                            sudoku[5][2] = subSudoku[2][2];
                            break;
                        case 5:
                            sudoku[3][3] = subSudoku[0][0];
                            sudoku[3][4] = subSudoku[0][1];
                            sudoku[3][5] = subSudoku[0][2];
                            sudoku[4][3] = subSudoku[1][0];
                            sudoku[4][4] = subSudoku[1][1];
                            sudoku[4][5] = subSudoku[1][2];
                            sudoku[5][3] = subSudoku[2][0];
                            sudoku[5][4] = subSudoku[2][1];
                            sudoku[5][5] = subSudoku[2][2];
                            break;
                        case 6:
                            sudoku[3][6] = subSudoku[0][0];
                            sudoku[3][7] = subSudoku[0][1];
                            sudoku[3][8] = subSudoku[0][2];
                            sudoku[4][6] = subSudoku[1][0];
                            sudoku[4][7] = subSudoku[1][1];
                            sudoku[4][8] = subSudoku[1][2];
                            sudoku[5][6] = subSudoku[2][0];
                            sudoku[5][7] = subSudoku[2][1];
                            sudoku[5][8] = subSudoku[2][2];
                            break;
                        case 7:
                            sudoku[6][0] = subSudoku[0][0];
                            sudoku[6][1] = subSudoku[0][1];
                            sudoku[6][2] = subSudoku[0][2];
                            sudoku[7][0] = subSudoku[1][0];
                            sudoku[7][1] = subSudoku[1][1];
                            sudoku[7][2] = subSudoku[1][2];
                            sudoku[8][0] = subSudoku[2][0];
                            sudoku[8][1] = subSudoku[2][1];
                            sudoku[8][2] = subSudoku[2][2];
                            break;
                        case 8:
                            sudoku[6][3] = subSudoku[0][0];
                            sudoku[6][4] = subSudoku[0][1];
                            sudoku[6][5] = subSudoku[0][2];
                            sudoku[7][3] = subSudoku[1][0];
                            sudoku[7][4] = subSudoku[1][1];
                            sudoku[7][5] = subSudoku[1][2];
                            sudoku[8][3] = subSudoku[2][0];
                            sudoku[8][4] = subSudoku[2][1];
                            sudoku[8][5] = subSudoku[2][2];
                            break;
                        case 9:
                            sudoku[6][6] = subSudoku[0][0];
                            sudoku[6][7] = subSudoku[0][1];
                            sudoku[6][8] = subSudoku[0][2];
                            sudoku[7][6] = subSudoku[1][0];
                            sudoku[7][7] = subSudoku[1][1];
                            sudoku[7][8] = subSudoku[1][2];
                            sudoku[8][6] = subSudoku[2][0];
                            sudoku[8][7] = subSudoku[2][1];
                            sudoku[8][8] = subSudoku[2][2];
                            break;
                    }
                    populateSudoku();
                }

                GridLayout mainGrid = (GridLayout) findViewById(R.id.grid);
                GridLayout gl1 = (GridLayout) findViewById(R.id.grid1);
                GridLayout gl2 = (GridLayout) findViewById(R.id.grid2);
                GridLayout gl3 = (GridLayout) findViewById(R.id.grid3);
                GridLayout gl4 = (GridLayout) findViewById(R.id.grid4);
                GridLayout gl5 = (GridLayout) findViewById(R.id.grid5);
                GridLayout gl6 = (GridLayout) findViewById(R.id.grid6);
                GridLayout gl7 = (GridLayout) findViewById(R.id.grid7);
                GridLayout gl8 = (GridLayout) findViewById(R.id.grid8);
                GridLayout gl9 = (GridLayout) findViewById(R.id.grid9);

                gl1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int[][] threeByThree = new int[3][3];
                        threeByThree[0][0] = sudoku[0][0];
                        threeByThree[0][1] = sudoku[0][1];
                        threeByThree[0][2] = sudoku[0][2];
                        threeByThree[1][0] = sudoku[1][0];
                        threeByThree[1][1] = sudoku[1][1];
                        threeByThree[1][2] = sudoku[1][2];
                        threeByThree[2][0] = sudoku[2][0];
                        threeByThree[2][1] = sudoku[2][1];
                        threeByThree[2][2] = sudoku[2][2];

                        Intent intent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("sudoku", sudoku);
                        bundle.putSerializable("sub sudoku", threeByThree);
                        bundle.putSerializable("grid number", 1);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    }
                });

                gl2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int[][] threeByThree = new int[3][3];
                        threeByThree[0][0] = sudoku[0][3];
                        threeByThree[0][1] = sudoku[0][4];
                        threeByThree[0][2] = sudoku[0][5];
                        threeByThree[1][0] = sudoku[1][3];
                        threeByThree[1][1] = sudoku[1][4];
                        threeByThree[1][2] = sudoku[1][5];
                        threeByThree[2][0] = sudoku[2][3];
                        threeByThree[2][1] = sudoku[2][4];
                        threeByThree[2][2] = sudoku[2][5];

                        Intent intent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("sudoku", sudoku);
                        bundle.putSerializable("sub sudoku", threeByThree);
                        bundle.putSerializable("grid number", 2);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    }
                });

                gl3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int[][] threeByThree = new int[3][3];
                        threeByThree[0][0] = sudoku[0][6];
                        threeByThree[0][1] = sudoku[0][7];
                        threeByThree[0][2] = sudoku[0][8];
                        threeByThree[1][0] = sudoku[1][6];
                        threeByThree[1][1] = sudoku[1][7];
                        threeByThree[1][2] = sudoku[1][8];
                        threeByThree[2][0] = sudoku[2][6];
                        threeByThree[2][1] = sudoku[2][7];
                        threeByThree[2][2] = sudoku[2][8];

                        Intent intent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("sudoku", sudoku);
                        bundle.putSerializable("sub sudoku", threeByThree);
                        bundle.putSerializable("grid number", 3);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    }
                });

                gl4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int[][] threeByThree = new int[3][3];
                        threeByThree[0][0] = sudoku[3][0];
                        threeByThree[0][1] = sudoku[3][1];
                        threeByThree[0][2] = sudoku[3][2];
                        threeByThree[1][0] = sudoku[4][0];
                        threeByThree[1][1] = sudoku[4][1];
                        threeByThree[1][2] = sudoku[4][2];
                        threeByThree[2][0] = sudoku[5][0];
                        threeByThree[2][1] = sudoku[5][1];
                        threeByThree[2][2] = sudoku[5][2];

                        Intent intent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("sudoku", sudoku);
                        bundle.putSerializable("sub sudoku", threeByThree);
                        bundle.putSerializable("grid number", 4);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    }
                });

                gl5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int[][] threeByThree = new int[3][3];
                        threeByThree[0][0] = sudoku[3][3];
                        threeByThree[0][1] = sudoku[3][4];
                        threeByThree[0][2] = sudoku[3][5];
                        threeByThree[1][0] = sudoku[4][3];
                        threeByThree[1][1] = sudoku[4][4];
                        threeByThree[1][2] = sudoku[4][5];
                        threeByThree[2][0] = sudoku[5][3];
                        threeByThree[2][1] = sudoku[5][4];
                        threeByThree[2][2] = sudoku[5][5];

                        Intent intent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("sudoku", sudoku);
                        bundle.putSerializable("sub sudoku", threeByThree);
                        bundle.putSerializable("grid number", 5);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    }
                });

                gl6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int[][] threeByThree = new int[3][3];
                        threeByThree[0][0] = sudoku[3][6];
                        threeByThree[0][1] = sudoku[3][7];
                        threeByThree[0][2] = sudoku[3][8];
                        threeByThree[1][0] = sudoku[4][6];
                        threeByThree[1][1] = sudoku[4][7];
                        threeByThree[1][2] = sudoku[4][8];
                        threeByThree[2][0] = sudoku[5][6];
                        threeByThree[2][1] = sudoku[5][7];
                        threeByThree[2][2] = sudoku[5][8];

                        Intent intent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("sudoku", sudoku);
                        bundle.putSerializable("sub sudoku", threeByThree);
                        bundle.putSerializable("grid number", 6);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    }
                });

                gl7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int[][] threeByThree = new int[3][3];
                        threeByThree[0][0] = sudoku[6][0];
                        threeByThree[0][1] = sudoku[6][1];
                        threeByThree[0][2] = sudoku[6][2];
                        threeByThree[1][0] = sudoku[7][0];
                        threeByThree[1][1] = sudoku[7][1];
                        threeByThree[1][2] = sudoku[7][2];
                        threeByThree[2][0] = sudoku[8][0];
                        threeByThree[2][1] = sudoku[8][1];
                        threeByThree[2][2] = sudoku[8][2];

                        Intent intent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("sudoku", sudoku);
                        bundle.putSerializable("sub sudoku", threeByThree);
                        bundle.putSerializable("grid number", 7);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    }
                });

                gl8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int[][] threeByThree = new int[3][3];
                        threeByThree[0][0] = sudoku[6][3];
                        threeByThree[0][1] = sudoku[6][4];
                        threeByThree[0][2] = sudoku[6][5];
                        threeByThree[1][0] = sudoku[7][3];
                        threeByThree[1][1] = sudoku[7][4];
                        threeByThree[1][2] = sudoku[7][5];
                        threeByThree[2][0] = sudoku[8][3];
                        threeByThree[2][1] = sudoku[8][4];
                        threeByThree[2][2] = sudoku[8][5];

                        Intent intent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("sudoku", sudoku);
                        bundle.putSerializable("sub sudoku", threeByThree);
                        bundle.putSerializable("grid number", 8);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    }
                });

                gl9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int[][] threeByThree = new int[3][3];
                        threeByThree[0][0] = sudoku[6][6];
                        threeByThree[0][1] = sudoku[6][7];
                        threeByThree[0][2] = sudoku[6][8];
                        threeByThree[1][0] = sudoku[7][6];
                        threeByThree[1][1] = sudoku[7][7];
                        threeByThree[1][2] = sudoku[7][8];
                        threeByThree[2][0] = sudoku[8][6];
                        threeByThree[2][1] = sudoku[8][7];
                        threeByThree[2][2] = sudoku[8][8];

                        Intent intent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("sudoku", sudoku);
                        bundle.putSerializable("sub sudoku", threeByThree);
                        bundle.putSerializable("grid number", 9);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    }
                });

                mainGrid.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                        long[] vibrationPattern = {0, 300, 25, 300};
                        //-1 - don't repeat
                        final int indexInPatternToRepeat = -1;
                        vibrator.vibrate(vibrationPattern, indexInPatternToRepeat);
                        Sudoku.SolveSudoku(sudoku);
                        populateSudoku();
                        return true;
                    }
                });
            }
        });
    }

    public void populateSudoku() {
        TextView tv0 = (TextView) findViewById(R.id.textView0);
        TextView tv1 = (TextView) findViewById(R.id.textView1);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        TextView tv3 = (TextView) findViewById(R.id.textView3);
        TextView tv4 = (TextView) findViewById(R.id.textView4);
        TextView tv5 = (TextView) findViewById(R.id.textView5);
        TextView tv6 = (TextView) findViewById(R.id.textView6);
        TextView tv7 = (TextView) findViewById(R.id.textView7);
        TextView tv8 = (TextView) findViewById(R.id.textView8);
        TextView tv9 = (TextView) findViewById(R.id.textView9);
        TextView tv10 = (TextView) findViewById(R.id.textView10);
        TextView tv11 = (TextView) findViewById(R.id.textView11);
        TextView tv12 = (TextView) findViewById(R.id.textView12);
        TextView tv13 = (TextView) findViewById(R.id.textView13);
        TextView tv14 = (TextView) findViewById(R.id.textView14);
        TextView tv15 = (TextView) findViewById(R.id.textView15);
        TextView tv16 = (TextView) findViewById(R.id.textView16);
        TextView tv17 = (TextView) findViewById(R.id.textView17);
        TextView tv18 = (TextView) findViewById(R.id.textView18);
        TextView tv19 = (TextView) findViewById(R.id.textView19);
        TextView tv20 = (TextView) findViewById(R.id.textView20);
        TextView tv21 = (TextView) findViewById(R.id.textView21);
        TextView tv22 = (TextView) findViewById(R.id.textView22);
        TextView tv23 = (TextView) findViewById(R.id.textView23);
        TextView tv24 = (TextView) findViewById(R.id.textView24);
        TextView tv25 = (TextView) findViewById(R.id.textView25);
        TextView tv26 = (TextView) findViewById(R.id.textView26);
        TextView tv27 = (TextView) findViewById(R.id.textView27);
        TextView tv28 = (TextView) findViewById(R.id.textView28);
        TextView tv29 = (TextView) findViewById(R.id.textView29);
        TextView tv30 = (TextView) findViewById(R.id.textView30);
        TextView tv31 = (TextView) findViewById(R.id.textView31);
        TextView tv32 = (TextView) findViewById(R.id.textView32);
        TextView tv33 = (TextView) findViewById(R.id.textView33);
        TextView tv34 = (TextView) findViewById(R.id.textView34);
        TextView tv35 = (TextView) findViewById(R.id.textView35);
        TextView tv36 = (TextView) findViewById(R.id.textView36);
        TextView tv37 = (TextView) findViewById(R.id.textView37);
        TextView tv38 = (TextView) findViewById(R.id.textView38);
        TextView tv39 = (TextView) findViewById(R.id.textView39);
        TextView tv40 = (TextView) findViewById(R.id.textView40);
        TextView tv41 = (TextView) findViewById(R.id.textView41);
        TextView tv42 = (TextView) findViewById(R.id.textView42);
        TextView tv43 = (TextView) findViewById(R.id.textView43);
        TextView tv44 = (TextView) findViewById(R.id.textView44);
        TextView tv45 = (TextView) findViewById(R.id.textView45);
        TextView tv46 = (TextView) findViewById(R.id.textView46);
        TextView tv47 = (TextView) findViewById(R.id.textView47);
        TextView tv48 = (TextView) findViewById(R.id.textView48);
        TextView tv49 = (TextView) findViewById(R.id.textView49);
        TextView tv50 = (TextView) findViewById(R.id.textView50);
        TextView tv51 = (TextView) findViewById(R.id.textView51);
        TextView tv52 = (TextView) findViewById(R.id.textView52);
        TextView tv53 = (TextView) findViewById(R.id.textView53);
        TextView tv54 = (TextView) findViewById(R.id.textView54);
        TextView tv55 = (TextView) findViewById(R.id.textView55);
        TextView tv56 = (TextView) findViewById(R.id.textView56);
        TextView tv57 = (TextView) findViewById(R.id.textView57);
        TextView tv58 = (TextView) findViewById(R.id.textView58);
        TextView tv59 = (TextView) findViewById(R.id.textView59);
        TextView tv60 = (TextView) findViewById(R.id.textView60);
        TextView tv61 = (TextView) findViewById(R.id.textView61);
        TextView tv62 = (TextView) findViewById(R.id.textView62);
        TextView tv63 = (TextView) findViewById(R.id.textView63);
        TextView tv64 = (TextView) findViewById(R.id.textView64);
        TextView tv65 = (TextView) findViewById(R.id.textView65);
        TextView tv66 = (TextView) findViewById(R.id.textView66);
        TextView tv67 = (TextView) findViewById(R.id.textView67);
        TextView tv68 = (TextView) findViewById(R.id.textView68);
        TextView tv69 = (TextView) findViewById(R.id.textView69);
        TextView tv70 = (TextView) findViewById(R.id.textView70);
        TextView tv71 = (TextView) findViewById(R.id.textView71);
        TextView tv72 = (TextView) findViewById(R.id.textView72);
        TextView tv73 = (TextView) findViewById(R.id.textView73);
        TextView tv74 = (TextView) findViewById(R.id.textView74);
        TextView tv75 = (TextView) findViewById(R.id.textView75);
        TextView tv76 = (TextView) findViewById(R.id.textView76);
        TextView tv77 = (TextView) findViewById(R.id.textView77);
        TextView tv78 = (TextView) findViewById(R.id.textView78);
        TextView tv79 = (TextView) findViewById(R.id.textView79);
        TextView tv80 = (TextView) findViewById(R.id.textView80);

        tv0.setText(String.valueOf(sudoku[0][0]));
        tv1.setText(String.valueOf(sudoku[0][1]));
        tv2.setText(String.valueOf(sudoku[0][2]));
        tv3.setText(String.valueOf(sudoku[0][3]));
        tv4.setText(String.valueOf(sudoku[0][4]));
        tv5.setText(String.valueOf(sudoku[0][5]));
        tv6.setText(String.valueOf(sudoku[0][6]));
        tv7.setText(String.valueOf(sudoku[0][7]));
        tv8.setText(String.valueOf(sudoku[0][8]));
        tv9.setText(String.valueOf(sudoku[1][0]));
        tv10.setText(String.valueOf(sudoku[1][1]));
        tv11.setText(String.valueOf(sudoku[1][2]));
        tv12.setText(String.valueOf(sudoku[1][3]));
        tv13.setText(String.valueOf(sudoku[1][4]));
        tv14.setText(String.valueOf(sudoku[1][5]));
        tv15.setText(String.valueOf(sudoku[1][6]));
        tv16.setText(String.valueOf(sudoku[1][7]));
        tv17.setText(String.valueOf(sudoku[1][8]));
        tv18.setText(String.valueOf(sudoku[2][0]));
        tv19.setText(String.valueOf(sudoku[2][1]));
        tv20.setText(String.valueOf(sudoku[2][2]));
        tv21.setText(String.valueOf(sudoku[2][3]));
        tv22.setText(String.valueOf(sudoku[2][4]));
        tv23.setText(String.valueOf(sudoku[2][5]));
        tv24.setText(String.valueOf(sudoku[2][6]));
        tv25.setText(String.valueOf(sudoku[2][7]));
        tv26.setText(String.valueOf(sudoku[2][8]));
        tv27.setText(String.valueOf(sudoku[3][0]));
        tv28.setText(String.valueOf(sudoku[3][1]));
        tv29.setText(String.valueOf(sudoku[3][2]));
        tv30.setText(String.valueOf(sudoku[3][3]));
        tv31.setText(String.valueOf(sudoku[3][4]));
        tv32.setText(String.valueOf(sudoku[3][5]));
        tv33.setText(String.valueOf(sudoku[3][6]));
        tv34.setText(String.valueOf(sudoku[3][7]));
        tv35.setText(String.valueOf(sudoku[3][8]));
        tv36.setText(String.valueOf(sudoku[4][0]));
        tv37.setText(String.valueOf(sudoku[4][1]));
        tv38.setText(String.valueOf(sudoku[4][2]));
        tv39.setText(String.valueOf(sudoku[4][3]));
        tv40.setText(String.valueOf(sudoku[4][4]));
        tv41.setText(String.valueOf(sudoku[4][5]));
        tv42.setText(String.valueOf(sudoku[4][6]));
        tv43.setText(String.valueOf(sudoku[4][7]));
        tv44.setText(String.valueOf(sudoku[4][8]));
        tv45.setText(String.valueOf(sudoku[5][0]));
        tv46.setText(String.valueOf(sudoku[5][1]));
        tv47.setText(String.valueOf(sudoku[5][2]));
        tv48.setText(String.valueOf(sudoku[5][3]));
        tv49.setText(String.valueOf(sudoku[5][4]));
        tv50.setText(String.valueOf(sudoku[5][5]));
        tv51.setText(String.valueOf(sudoku[5][6]));
        tv52.setText(String.valueOf(sudoku[5][7]));
        tv53.setText(String.valueOf(sudoku[5][8]));
        tv54.setText(String.valueOf(sudoku[6][0]));
        tv55.setText(String.valueOf(sudoku[6][1]));
        tv56.setText(String.valueOf(sudoku[6][2]));
        tv57.setText(String.valueOf(sudoku[6][3]));
        tv58.setText(String.valueOf(sudoku[6][4]));
        tv59.setText(String.valueOf(sudoku[6][5]));
        tv60.setText(String.valueOf(sudoku[6][6]));
        tv61.setText(String.valueOf(sudoku[6][7]));
        tv62.setText(String.valueOf(sudoku[6][8]));
        tv63.setText(String.valueOf(sudoku[7][0]));
        tv64.setText(String.valueOf(sudoku[7][1]));
        tv65.setText(String.valueOf(sudoku[7][2]));
        tv66.setText(String.valueOf(sudoku[7][3]));
        tv67.setText(String.valueOf(sudoku[7][4]));
        tv68.setText(String.valueOf(sudoku[7][5]));
        tv69.setText(String.valueOf(sudoku[7][6]));
        tv70.setText(String.valueOf(sudoku[7][7]));
        tv71.setText(String.valueOf(sudoku[7][8]));
        tv72.setText(String.valueOf(sudoku[8][0]));
        tv73.setText(String.valueOf(sudoku[8][1]));
        tv74.setText(String.valueOf(sudoku[8][2]));
        tv75.setText(String.valueOf(sudoku[8][3]));
        tv76.setText(String.valueOf(sudoku[8][4]));
        tv77.setText(String.valueOf(sudoku[8][5]));
        tv78.setText(String.valueOf(sudoku[8][6]));
        tv79.setText(String.valueOf(sudoku[8][7]));
        tv80.setText(String.valueOf(sudoku[8][8]));
    }
}
