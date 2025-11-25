package com.example.vladyslav.mishchuk.quotationappv2;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rvQuotes);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));

        List<Quote> quotes = loadQuotesFromAssets("quotations.txt");

        QuoteAdapter adapter = new QuoteAdapter(quotes, quote -> {
            Intent intent = new Intent(MainActivity.this, QuoteDetailActivity.class);
            intent.putExtra("EXTRA_QUOTE", quote.text);
            intent.putExtra("EXTRA_AUTHOR", quote.author);
            startActivity(intent);
        });

        rv.setAdapter(adapter);
    }

    private List<Quote> loadQuotesFromAssets(String fileName) {
        List<Quote> list = new ArrayList<>();

        try (InputStream stream = getAssets().open(fileName);
             InputStreamReader streamReader = new InputStreamReader(stream);
             BufferedReader read = new BufferedReader(streamReader)) {

            String line;
            String currentQuote = null;

            while ((line = read.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (currentQuote == null) {
                    currentQuote = line;
                } else {
                    String author = line;
                    list.add(new Quote(currentQuote, author));
                    currentQuote = null;
                }
            }

            if (currentQuote != null) {
                list.add(new Quote(currentQuote, ""));
            }

        } catch (IOException exception) {
            Log.e("file", exception.toString());
        }
        return list;
    }
}
