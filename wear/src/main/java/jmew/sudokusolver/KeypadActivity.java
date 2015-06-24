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
public class KeypadActivity extends Activity {

    public int gridNumber;
    public int[][] subSudoku;
    public int[][] sudoku;

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
                final int row = (int) bundle.getSerializable("row");
                final int col = (int) bundle.getSerializable("col");

                Button key1 = (Button) findViewById(R.id.key1);
                Button key2 = (Button) findViewById(R.id.key2);
                Button key3 = (Button) findViewById(R.id.key3);
                Button key4 = (Button) findViewById(R.id.key4);
                Button key5 = (Button) findViewById(R.id.key5);
                Button key6 = (Button) findViewById(R.id.key6);
                Button key7 = (Button) findViewById(R.id.key7);
                Button key8 = (Button) findViewById(R.id.key8);
                Button key9 = (Button) findViewById(R.id.key9);

                key1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        subSudoku[row][col] = 1;
                        Intent subSudokuIntent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle subSudokuBundle = new Bundle();
                        subSudokuBundle.putSerializable("sub sudoku", subSudoku);
                        subSudokuBundle.putSerializable("sudoku", sudoku);
                        subSudokuBundle.putSerializable("grid number", gridNumber);
                        subSudokuIntent.putExtras(subSudokuBundle);
                        startActivity(subSudokuIntent);
                        finish();
                    }
                });

                key2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        subSudoku[row][col] = 2;
                        Intent subSudokuIntent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle subSudokuBundle = new Bundle();
                        subSudokuBundle.putSerializable("sub sudoku", subSudoku);
                        subSudokuBundle.putSerializable("sudoku", sudoku);
                        subSudokuBundle.putSerializable("grid number", gridNumber);
                        subSudokuIntent.putExtras(subSudokuBundle);
                        startActivity(subSudokuIntent);
                        finish();
                    }
                });

                key3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        subSudoku[row][col] = 3;
                        Intent subSudokuIntent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle subSudokuBundle = new Bundle();
                        subSudokuBundle.putSerializable("sub sudoku", subSudoku);
                        subSudokuBundle.putSerializable("sudoku", sudoku);
                        subSudokuBundle.putSerializable("grid number", gridNumber);
                        subSudokuIntent.putExtras(subSudokuBundle);
                        startActivity(subSudokuIntent);
                        finish();
                    }
                });

                key4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        subSudoku[row][col] = 4;
                        Intent subSudokuIntent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle subSudokuBundle = new Bundle();
                        subSudokuBundle.putSerializable("sub sudoku", subSudoku);
                        subSudokuBundle.putSerializable("sudoku", sudoku);
                        subSudokuBundle.putSerializable("grid number", gridNumber);
                        subSudokuIntent.putExtras(subSudokuBundle);
                        startActivity(subSudokuIntent);
                        finish();
                    }
                });

                key5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        subSudoku[row][col] = 5;
                        Intent subSudokuIntent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle subSudokuBundle = new Bundle();
                        subSudokuBundle.putSerializable("sub sudoku", subSudoku);
                        subSudokuBundle.putSerializable("sudoku", sudoku);
                        subSudokuBundle.putSerializable("grid number", gridNumber);
                        subSudokuIntent.putExtras(subSudokuBundle);
                        startActivity(subSudokuIntent);
                        finish();
                    }
                });

                key6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        subSudoku[row][col] = 6;
                        Intent subSudokuIntent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle subSudokuBundle = new Bundle();
                        subSudokuBundle.putSerializable("sub sudoku", subSudoku);
                        subSudokuBundle.putSerializable("sudoku", sudoku);
                        subSudokuBundle.putSerializable("grid number", gridNumber);
                        subSudokuIntent.putExtras(subSudokuBundle);
                        startActivity(subSudokuIntent);
                        finish();
                    }
                });

                key7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        subSudoku[row][col] = 7;
                        Intent subSudokuIntent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle subSudokuBundle = new Bundle();
                        subSudokuBundle.putSerializable("sub sudoku", subSudoku);
                        subSudokuBundle.putSerializable("sudoku", sudoku);
                        subSudokuBundle.putSerializable("grid number", gridNumber);
                        subSudokuIntent.putExtras(subSudokuBundle);
                        startActivity(subSudokuIntent);
                        finish();
                    }
                });

                key8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        subSudoku[row][col] = 8;
                        Intent subSudokuIntent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle subSudokuBundle = new Bundle();
                        subSudokuBundle.putSerializable("sub sudoku", subSudoku);
                        subSudokuBundle.putSerializable("sudoku", sudoku);
                        subSudokuBundle.putSerializable("grid number", gridNumber);
                        subSudokuIntent.putExtras(subSudokuBundle);
                        startActivity(subSudokuIntent);
                        finish();
                    }
                });

                key9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        subSudoku[row][col] = 9;
                        Intent subSudokuIntent = new Intent(getApplicationContext(), SubSudokuActivity.class);
                        Bundle subSudokuBundle = new Bundle();
                        subSudokuBundle.putSerializable("sub sudoku", subSudoku);
                        subSudokuBundle.putSerializable("sudoku", sudoku);
                        subSudokuBundle.putSerializable("grid number", gridNumber);
                        subSudokuIntent.putExtras(subSudokuBundle);
                        startActivity(subSudokuIntent);
                        finish();
                    }
                });
            }
        });
    }
}
