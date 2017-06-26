package com.unstablebrainiac.githubapisample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void search(View view) {
        EditText searchQueryEditText = (EditText) findViewById(R.id.search_query_et);
        String searchQuery = searchQueryEditText.getText().toString();
        Intent intent = new Intent(this, SearchUserActivity.class);
        intent.putExtra("SEARCH_QUERY", searchQuery);
        startActivity(intent);
    }
}
