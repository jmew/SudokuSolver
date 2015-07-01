package jmew.sudokusolver;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.wearable.view.BoxInsetLayout;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mew on 2015-06-21.
 */
public class SubSudokuActivity extends Activity implements View.OnClickListener {

    public int gridNumber;
    public int[][] subSudoku;
    public int[][] sudoku;
    public boolean onStop;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_sudoku_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {

                onStop = false;

                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                subSudoku = (int[][]) bundle.getSerializable("sub sudoku");
                sudoku = (int[][]) bundle.getSerializable("sudoku");
                gridNumber = (int) bundle.getSerializable("grid number");

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

                GridLayout gridLayout = (GridLayout) findViewById(R.id.grid);
//                GridLayout gridLayout = new GridLayout(getApplicationContext());
//                gridLayout.setBackgroundResource(R.drawable.thickborder);
//                gridLayout.setPadding(10, 10, 10, 10);
//                gridLayout.setColumnCount(3);
//                gridLayout.setRowCount(3);

                int row = 0;
                int col = 0;
                for (int i = 0; i < 9; i++) {
                    TextView textView = new TextView(getApplicationContext());
                    textView.setId(i);
                    textView.setHeight(65);
                    textView.setWidth(65);
                    textView.setGravity(Gravity.CENTER);
                    textView.setBackgroundResource(R.drawable.thickborder);
                    textView.setTextColor(getResources().getColorStateList(R.color.black));
                    textView.setTextSize(35);
                    textView.setTypeface(null, Typeface.BOLD);
                    textView.setOnClickListener(SubSudokuActivity.this);

                    if (col == 3) {
                        col = 0;
                        row++;
                    }
                    if (subSudoku[row][col] != 0) {
                        textView.setText(String.valueOf(subSudoku[row][col]));
                    }

//                    GridLayout.LayoutParams param = new GridLayout.LayoutParams();
//                    param.columnSpec = GridLayout.spec(col);
//                    param.rowSpec = GridLayout.spec(row);
//                    param.setGravity(Gravity.CENTER);
//                    textView.setLayoutParams(param);
                    gridLayout.addView(textView);
                    col++;
                }
                //stub.addView(gridLayout);
            }
        });
    }

    public void onClick(View v) {
        Intent keyPad = new Intent(getApplicationContext(), KeypadActivity.class);
        Bundle keyPadBundle = new Bundle();
        keyPadBundle.putSerializable("sub sudoku", subSudoku);
        keyPadBundle.putSerializable("grid number", gridNumber);
        keyPadBundle.putSerializable("sudoku", sudoku);

        switch(v.getId()) {
            case 0:
                keyPadBundle.putSerializable("row", 0);
                keyPadBundle.putSerializable("col", 0);
                break;
            case 1:
                keyPadBundle.putSerializable("row", 0);
                keyPadBundle.putSerializable("col", 1);
                break;
            case 2:
                keyPadBundle.putSerializable("row", 0);
                keyPadBundle.putSerializable("col", 2);
                break;
            case 3:
                keyPadBundle.putSerializable("row", 1);
                keyPadBundle.putSerializable("col", 0);
                break;
            case 4:
                keyPadBundle.putSerializable("row", 1);
                keyPadBundle.putSerializable("col", 1);
                break;
            case 5:
                keyPadBundle.putSerializable("row", 1);
                keyPadBundle.putSerializable("col", 2);
                break;
            case 6:
                keyPadBundle.putSerializable("row", 2);
                keyPadBundle.putSerializable("col", 0);
                break;
            case 7:
                keyPadBundle.putSerializable("row", 2);
                keyPadBundle.putSerializable("col", 1);
                break;
            case 8:
                keyPadBundle.putSerializable("row", 2);
                keyPadBundle.putSerializable("col", 2);
                break;
        }

        keyPad.putExtras(keyPadBundle);
        startActivity(keyPad);
        onStop = true;
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!onStop) {
            Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
            Bundle mainBundle = new Bundle();
            mainBundle.putSerializable("sudoku", sudoku);
            mainBundle.putSerializable("sudoku2", sudoku);
            mainIntent.putExtras(mainBundle);
            startActivity(mainIntent);
        }
    }
}
