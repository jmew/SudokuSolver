package jmew.sudokusolver;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener{

    public int[][] sudoku = new int[9][9];
    public int[][] sudokuSolved = new int[9][9];
    private long[] vibrationPattern = {0, 500, 25, 300};
    private long[] errorvibrationPattern = {500};
    private int indexInPatternToRepeat = -1;
    private List<GridLayout> grids = new ArrayList<>();
    private List<TextView> textViews = new ArrayList<>();
    private int col = 0;
    private int row = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {

                int subcol;
                int subrow;

                Intent sudokuIntent = getIntent();
                Bundle sudokuBundle = sudokuIntent.getExtras();

                if (sudokuBundle != null) {
                    sudokuSolved = (int[][]) sudokuBundle.getSerializable("sudoku");
                    sudoku = (int[][]) sudokuBundle.getSerializable("sudoku2");
                }
                GridLayout gridMain = (GridLayout) findViewById(R.id.grid);
                for (int i = 0; i < 9; i++) {
                    GridLayout gridLayout = new GridLayout(getApplicationContext());
                    gridLayout.setId(i);
                    grids.add(gridLayout);
                    gridLayout.setBackgroundResource(R.color.black);
                    gridLayout.setPadding(2, 2, 2, 2);
                    gridLayout.setColumnCount(3);
                    gridLayout.setRowCount(3);
                    gridLayout.setOnClickListener(MainActivity.this);
                    if (col == 1 && row == 1) {
                        gridLayout.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                                vibrator.vibrate(vibrationPattern, indexInPatternToRepeat);
                                if (Sudoku.SolveSudoku(sudokuSolved)) {
                                    vibrator.vibrate(vibrationPattern, indexInPatternToRepeat);
                                    populateSudoku();
                                } else {
                                    vibrator.vibrate(errorvibrationPattern, indexInPatternToRepeat);
                                    Toast.makeText(getApplicationContext(), "Sudoku Is Not Solvable", Toast.LENGTH_SHORT).show();
                                }
                                return true;
                            }
                        });
                    }
                    if (col == 1 && row == 2) {
                        gridLayout.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                                vibrator.vibrate(vibrationPattern, indexInPatternToRepeat);
                                sudoku = new int[9][9];
                                sudokuSolved = new int[9][9];;
                                populateSudoku();
                                return true;
                            }
                        });
                    }
                    if (col == 3) {
                        col = 0;
                        row++;
                    }
                    GridLayout.LayoutParams param = new GridLayout.LayoutParams();
                    param.columnSpec = GridLayout.spec(col);
                    param.rowSpec = GridLayout.spec(row);
                    param.setGravity(Gravity.CENTER);
                    gridLayout.setLayoutParams(param);
                    gridMain.addView(gridLayout);
                    col++;
                }

                row = 0;
                col = 0;
                for (int i = 0; i < 81; i++) {
                    TextView textView = new TextView(getApplicationContext());
                    textView.setId(i);
                    textView.setHeight(23);
                    textView.setWidth(23);
                    textView.setBackgroundResource(R.drawable.border);
                    textView.setGravity(Gravity.CENTER);
                    textView.setTextSize(14);
                    textView.setTypeface(null, Typeface.BOLD);

                    if (col == 9) {
                        col = 0;
                        row++;
                    }

                    subcol = col % 3;
                    subrow = row % 3;

                    GridLayout.LayoutParams param = new GridLayout.LayoutParams();
                    param.columnSpec = GridLayout.spec(subcol);
                    param.rowSpec = GridLayout.spec(subrow);
                    param.setGravity(Gravity.CENTER);
                    textView.setLayoutParams(param);
                    textViews.add(textView);
                    switch (Sudoku.subSquareCheck(row, col)) {
                        case 1:
                            grids.get(0).addView(textView);
                            break;
                        case 2:
                            grids.get(1).addView(textView);
                            break;
                        case 3:
                            grids.get(2).addView(textView);
                            break;
                        case 4:
                            grids.get(3).addView(textView);
                            break;
                        case 5:
                            grids.get(4).addView(textView);
                            break;
                        case 6:
                            grids.get(5).addView(textView);
                            break;
                        case 7:
                            grids.get(6).addView(textView);
                            break;
                        case 8:
                            grids.get(7).addView(textView);
                            break;
                        case 9:
                            grids.get(8).addView(textView);
                            break;
                    }
                    col++;
                }
                populateSudoku();
            }
        });
    }

    public void populateSudoku() {
        row = 0;
        col = 0;
        for (int i = 0; i < 81; i++) {
            if (col == 9) {
                col = 0;
                row++;
            }
            if (sudoku[row][col] != 0) {
                textViews.get(i).setText(String.valueOf(sudoku[row][col]));
                textViews.get(i).setTextColor(getResources().getColorStateList(R.color.black));
            }
            else if (sudoku[row][col] == 0 && sudokuSolved[row][col] != 0) {
                textViews.get(i).setText(String.valueOf(sudokuSolved[row][col]));
                textViews.get(i).setTextColor(getResources().getColorStateList(R.color.red));
            }
            else {
                textViews.get(i).setText(null);
            }
            col++;
        }
    }

    public void onClick(View v){
        Intent intent = new Intent(getApplicationContext(), SubSudokuActivity.class);
        Bundle bundle = new Bundle();
        int[][] threeByThree = new int[3][3];
        switch(v.getId()) {
            case 0:
                threeByThree[0][0] = sudoku[0][0];
                threeByThree[0][1] = sudoku[0][1];
                threeByThree[0][2] = sudoku[0][2];
                threeByThree[1][0] = sudoku[1][0];
                threeByThree[1][1] = sudoku[1][1];
                threeByThree[1][2] = sudoku[1][2];
                threeByThree[2][0] = sudoku[2][0];
                threeByThree[2][1] = sudoku[2][1];
                threeByThree[2][2] = sudoku[2][2];
                bundle.putSerializable("grid number", 1);
                break;
            case 1:
                threeByThree[0][0] = sudoku[0][3];
                threeByThree[0][1] = sudoku[0][4];
                threeByThree[0][2] = sudoku[0][5];
                threeByThree[1][0] = sudoku[1][3];
                threeByThree[1][1] = sudoku[1][4];
                threeByThree[1][2] = sudoku[1][5];
                threeByThree[2][0] = sudoku[2][3];
                threeByThree[2][1] = sudoku[2][4];
                threeByThree[2][2] = sudoku[2][5];
                bundle.putSerializable("grid number", 2);
                break;
            case 2:
                threeByThree[0][0] = sudoku[0][6];
                threeByThree[0][1] = sudoku[0][7];
                threeByThree[0][2] = sudoku[0][8];
                threeByThree[1][0] = sudoku[1][6];
                threeByThree[1][1] = sudoku[1][7];
                threeByThree[1][2] = sudoku[1][8];
                threeByThree[2][0] = sudoku[2][6];
                threeByThree[2][1] = sudoku[2][7];
                threeByThree[2][2] = sudoku[2][8];
                bundle.putSerializable("grid number", 3);
                break;
            case 3:
                threeByThree[0][0] = sudoku[3][0];
                threeByThree[0][1] = sudoku[3][1];
                threeByThree[0][2] = sudoku[3][2];
                threeByThree[1][0] = sudoku[4][0];
                threeByThree[1][1] = sudoku[4][1];
                threeByThree[1][2] = sudoku[4][2];
                threeByThree[2][0] = sudoku[5][0];
                threeByThree[2][1] = sudoku[5][1];
                threeByThree[2][2] = sudoku[5][2];
                bundle.putSerializable("grid number", 4);
                break;
            case 4:
                threeByThree[0][0] = sudoku[3][3];
                threeByThree[0][1] = sudoku[3][4];
                threeByThree[0][2] = sudoku[3][5];
                threeByThree[1][0] = sudoku[4][3];
                threeByThree[1][1] = sudoku[4][4];
                threeByThree[1][2] = sudoku[4][5];
                threeByThree[2][0] = sudoku[5][3];
                threeByThree[2][1] = sudoku[5][4];
                threeByThree[2][2] = sudoku[5][5];
                bundle.putSerializable("grid number", 5);
                break;
            case 5:
                threeByThree[0][0] = sudoku[3][6];
                threeByThree[0][1] = sudoku[3][7];
                threeByThree[0][2] = sudoku[3][8];
                threeByThree[1][0] = sudoku[4][6];
                threeByThree[1][1] = sudoku[4][7];
                threeByThree[1][2] = sudoku[4][8];
                threeByThree[2][0] = sudoku[5][6];
                threeByThree[2][1] = sudoku[5][7];
                threeByThree[2][2] = sudoku[5][8];
                bundle.putSerializable("grid number", 6);
                break;
            case 6:
                threeByThree[0][0] = sudoku[6][0];
                threeByThree[0][1] = sudoku[6][1];
                threeByThree[0][2] = sudoku[6][2];
                threeByThree[1][0] = sudoku[7][0];
                threeByThree[1][1] = sudoku[7][1];
                threeByThree[1][2] = sudoku[7][2];
                threeByThree[2][0] = sudoku[8][0];
                threeByThree[2][1] = sudoku[8][1];
                threeByThree[2][2] = sudoku[8][2];
                bundle.putSerializable("grid number", 7);
                break;
            case 7:
                threeByThree[0][0] = sudoku[6][3];
                threeByThree[0][1] = sudoku[6][4];
                threeByThree[0][2] = sudoku[6][5];
                threeByThree[1][0] = sudoku[7][3];
                threeByThree[1][1] = sudoku[7][4];
                threeByThree[1][2] = sudoku[7][5];
                threeByThree[2][0] = sudoku[8][3];
                threeByThree[2][1] = sudoku[8][4];
                threeByThree[2][2] = sudoku[8][5];
                bundle.putSerializable("grid number", 8);
                break;
            case 8:
                threeByThree[0][0] = sudoku[6][6];
                threeByThree[0][1] = sudoku[6][7];
                threeByThree[0][2] = sudoku[6][8];
                threeByThree[1][0] = sudoku[7][6];
                threeByThree[1][1] = sudoku[7][7];
                threeByThree[1][2] = sudoku[7][8];
                threeByThree[2][0] = sudoku[8][6];
                threeByThree[2][1] = sudoku[8][7];
                threeByThree[2][2] = sudoku[8][8];
                bundle.putSerializable("grid number", 9);
                break;
        }
        bundle.putSerializable("sudoku", sudoku);
        bundle.putSerializable("sub sudoku", threeByThree);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}