package com.example.gaspar.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "com.example.gaspar.sharedpreferences.preferences";
    private static final String KEY_EDIT_TEXT = "key_edit_text" ;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private EditText mEditText;

    @Override
    protected void onPause() {
        super.onPause();
        mEditor.putString(KEY_EDIT_TEXT, mEditText.getText().toString());
        mEditor.apply();
        //you can use clear o remove(KEY) to remove a preference.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        String editextString = mSharedPreferences.getString(KEY_EDIT_TEXT,"");
        mEditText.setText(editextString);
    }
}
