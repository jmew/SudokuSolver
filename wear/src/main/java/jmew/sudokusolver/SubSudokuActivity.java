package jmew.sudokusolver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Mew on 2015-06-21.
 */
public class SubSudokuActivity extends Activity {

    public int gridNumber;
    public int[][] subSudoku;
    public int[][] sudoku;
    public boolean onDestroy;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_sudoku_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {

                onDestroy = false;

                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                subSudoku = (int[][]) bundle.getSerializable("sub sudoku");
                sudoku = (int[][]) bundle.getSerializable("sudoku");
                gridNumber = (int) bundle.getSerializable("grid number");

                TextView tv0 = (TextView) findViewById(R.id.textView0);
                TextView tv1 = (TextView) findViewById(R.id.textView1);
                TextView tv2 = (TextView) findViewById(R.id.textView2);
                TextView tv3 = (TextView) findViewById(R.id.textView3);
                TextView tv4 = (TextView) findViewById(R.id.textView4);
                TextView tv5 = (TextView) findViewById(R.id.textView5);
                TextView tv6 = (TextView) findViewById(R.id.textView6);
                TextView tv7 = (TextView) findViewById(R.id.textView7);
                TextView tv8 = (TextView) findViewById(R.id.textView8);

                tv0.setText(String.valueOf(subSudoku[0][0]));
                tv1.setText(String.valueOf(subSudoku[0][1]));
                tv2.setText(String.valueOf(subSudoku[0][2]));
                tv3.setText(String.valueOf(subSudoku[1][0]));
                tv4.setText(String.valueOf(subSudoku[1][1]));
                tv5.setText(String.valueOf(subSudoku[1][2]));
                tv6.setText(String.valueOf(subSudoku[2][0]));
                tv7.setText(String.valueOf(subSudoku[2][1]));
                tv8.setText(String.valueOf(subSudoku[2][2]));

                tv0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent keyPad = new Intent(getApplicationContext(), KeypadActivity.class);
                        Bundle keyPadBundle = new Bundle();
                        keyPadBundle.putSerializable("sub sudoku", subSudoku);
					    keyPadBundle.putSerializable("grid number", gridNumber);
                        keyPadBundle.putSerializable("sudoku", sudoku);
                        keyPadBundle.putSerializable("row", 0);
                        keyPadBundle.putSerializable("col", 0);
                        keyPad.putExtras(keyPadBundle);
                        startActivity(keyPad);
                        onDestroy = true;
                        finish();
                    }
                });

                tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent keyPad = new Intent(getApplicationContext(), KeypadActivity.class);
                        Bundle keyPadBundle = new Bundle();
                        keyPadBundle.putSerializable("sub sudoku", subSudoku);
					    keyPadBundle.putSerializable("grid number", gridNumber);
                        keyPadBundle.putSerializable("sudoku", sudoku);	
                        keyPadBundle.putSerializable("row", 0);
                        keyPadBundle.putSerializable("col", 1);
                        keyPad.putExtras(keyPadBundle);
                        startActivity(keyPad);
                        onDestroy = true;
                        finish();
                    }
                });

                tv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent keyPad = new Intent(getApplicationContext(), KeypadActivity.class);
                        Bundle keyPadBundle = new Bundle();
                        keyPadBundle.putSerializable("sub sudoku", subSudoku);
					    keyPadBundle.putSerializable("grid number", gridNumber);
                        keyPadBundle.putSerializable("sudoku", sudoku);	
                        keyPadBundle.putSerializable("row", 0);
                        keyPadBundle.putSerializable("col", 2);
                        keyPad.putExtras(keyPadBundle);
                        startActivity(keyPad);
                        onDestroy = true;
                        finish();
                    }
                });

                tv3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent keyPad = new Intent(getApplicationContext(), KeypadActivity.class);
                        Bundle keyPadBundle = new Bundle();
                        keyPadBundle.putSerializable("sub sudoku", subSudoku);
					    keyPadBundle.putSerializable("grid number", gridNumber);
                        keyPadBundle.putSerializable("sudoku", sudoku);	
                        keyPadBundle.putSerializable("row", 1);
                        keyPadBundle.putSerializable("col", 0);
                        keyPad.putExtras(keyPadBundle);
                        startActivity(keyPad);
                        onDestroy = true;
                        finish();
                    }
                });

                tv4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent keyPad = new Intent(getApplicationContext(), KeypadActivity.class);
                        Bundle keyPadBundle = new Bundle();
                        keyPadBundle.putSerializable("sub sudoku", subSudoku);
					    keyPadBundle.putSerializable("grid number", gridNumber);
                        keyPadBundle.putSerializable("sudoku", sudoku);	
                        keyPadBundle.putSerializable("row", 1);
                        keyPadBundle.putSerializable("col", 1);
                        keyPad.putExtras(keyPadBundle);
                        startActivity(keyPad);
                        onDestroy = true;
                        finish();
                    }
                });

                tv5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent keyPad = new Intent(getApplicationContext(), KeypadActivity.class);
                        Bundle keyPadBundle = new Bundle();
                        keyPadBundle.putSerializable("sub sudoku", subSudoku);
					    keyPadBundle.putSerializable("grid number", gridNumber);
                        keyPadBundle.putSerializable("sudoku", sudoku);	
                        keyPadBundle.putSerializable("row", 1);
                        keyPadBundle.putSerializable("col", 2);
                        keyPad.putExtras(keyPadBundle);
                        startActivity(keyPad);
                        onDestroy = true;
                        finish();
                    }
                });

                tv6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent keyPad = new Intent(getApplicationContext(), KeypadActivity.class);
                        Bundle keyPadBundle = new Bundle();
                        keyPadBundle.putSerializable("sub sudoku", subSudoku);
					    keyPadBundle.putSerializable("grid number", gridNumber);
                        keyPadBundle.putSerializable("sudoku", sudoku);	
                        keyPadBundle.putSerializable("row", 2);
                        keyPadBundle.putSerializable("col", 0);
                        keyPad.putExtras(keyPadBundle);
                        startActivity(keyPad);
                        onDestroy = true;
                        finish();
                    }
                });

                tv7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent keyPad = new Intent(getApplicationContext(), KeypadActivity.class);
                        Bundle keyPadBundle = new Bundle();
                        keyPadBundle.putSerializable("sub sudoku", subSudoku);
					    keyPadBundle.putSerializable("grid number", gridNumber);
                        keyPadBundle.putSerializable("sudoku", sudoku);	
                        keyPadBundle.putSerializable("row", 2);
                        keyPadBundle.putSerializable("col", 1);
                        keyPad.putExtras(keyPadBundle);
                        startActivity(keyPad);
                        onDestroy = true;
                        finish();
                    }
                });

                tv8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent keyPad = new Intent(getApplicationContext(), KeypadActivity.class);
                        Bundle keyPadBundle = new Bundle();
                        keyPadBundle.putSerializable("sub sudoku", subSudoku);
					    keyPadBundle.putSerializable("grid number", gridNumber);
                        keyPadBundle.putSerializable("sudoku", sudoku);	
                        keyPadBundle.putSerializable("row", 2);
                        keyPadBundle.putSerializable("col", 2);
                        keyPad.putExtras(keyPadBundle);
                        startActivity(keyPad);
                        onDestroy = true;
                        finish();
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!onDestroy) {
            Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
            Bundle mainBundle = new Bundle();
            mainBundle.putSerializable("sub sudoku", subSudoku);
            mainBundle.putSerializable("grid number", gridNumber);
            mainBundle.putSerializable("sudoku", sudoku);
            mainIntent.putExtras(mainBundle);
            startActivity(mainIntent);
        }
    }
}
