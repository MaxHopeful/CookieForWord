package com.jarvis.twoword;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button addBut,check;
    EditText rusWord,engWord;

    DBHelper dbHelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBut = (Button) findViewById(R.id.addBut);
        addBut.setOnClickListener(this);

        rusWord = (EditText) findViewById(R.id.rusWord);
        engWord = (EditText) findViewById(R.id.engWord);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {

        String rus = rusWord.getText().toString();
        String eng = engWord.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

                contentValues.put(DBHelper.KEY_RUS, rus);
                contentValues.put(DBHelper.KEY_ENG, eng);
                database.insert(DBHelper.TABLE_WORDS, null, contentValues);


        dbHelper.close();
    }
}
