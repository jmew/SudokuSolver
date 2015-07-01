package jmew.sudokusolver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;

/**
 * Created by Mew on 2015-06-21.
 */
public class KeypadActivity extends Activity implements View.OnClickListener {

    public int gridNumber;
    public int[][] subSudoku;
    public int[][] sudoku;
    public int row;
    public int col;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keypad_activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {

                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                subSudoku = (int[][]) bundle.getSerializable("sub sudoku");
                sudoku = (int[][]) bundle.getSerializable("sudoku");
                gridNumber = (int) bundle.getSerializable("grid number");
                row = (int) bundle.getSerializable("row");
                col = (int) bundle.getSerializable("col");

                Button key1 = (Button) findViewById(R.id.key1);
                key1.setOnClickListener(KeypadActivity.this);
                Button key2 = (Button) findViewById(R.id.key2);
                key2.setOnClickListener(KeypadActivity.this);
                Button key3 = (Button) findViewById(R.id.key3);
                key3.setOnClickListener(KeypadActivity.this);
                Button key4 = (Button) findViewById(R.id.key4);
                key4.setOnClickListener(KeypadActivity.this);
                Button key5 = (Button) findViewById(R.id.key5);
                key5.setOnClickListener(KeypadActivity.this);
                Button key6 = (Button) findViewById(R.id.key6);
                key6.setOnClickListener(KeypadActivity.this);
                Button key7 = (Button) findViewById(R.id.key7);
                key7.setOnClickListener(KeypadActivity.this);
                Button key8 = (Button) findViewById(R.id.key8);
                key8.setOnClickListener(KeypadActivity.this);
                Button key9 = (Button) findViewById(R.id.key9);
                key9.setOnClickListener(KeypadActivity.this);
            }
        });
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.key1:
                subSudoku[row][col] = 1;
                break;
            case R.id.key2:
                subSudoku[row][col] = 2;
                break;
            case R.id.key3:
                subSudoku[row][col] = 3;
                break;
            case R.id.key4:
                subSudoku[row][col] = 4;
                break;
            case R.id.key5:
                subSudoku[row][col] = 5;
                break;
            case R.id.key6:
                subSudoku[row][col] = 6;
                break;
            case R.id.key7:
                subSudoku[row][col] = 7;
                break;
            case R.id.key8:
                subSudoku[row][col] = 8;
                break;
            case R.id.key9:
                subSudoku[row][col] = 9;
                break;
        }
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Intent subSudokuIntent = new Intent(getApplicationContext(), SubSudokuActivity.class);
        Bundle subSudokuBundle = new Bundle();
        subSudokuBundle.putSerializable("sub sudoku", subSudoku);
        subSudokuBundle.putSerializable("sudoku", sudoku);
        subSudokuBundle.putSerializable("grid number", gridNumber);
        subSudokuIntent.putExtras(subSudokuBundle);
        startActivity(subSudokuIntent);
    }
}
