package com.example.vladyslav.mishchuk.quotationappv2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuoteDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_detail);

        TextView tvQuoteBig = findViewById(R.id.tvQuoteBig);
        TextView tvAuthorBig = findViewById(R.id.tvAuthorBig);

        String quote = getIntent().getStringExtra("EXTRA_QUOTE");
        String author = getIntent().getStringExtra("EXTRA_AUTHOR");

        if (quote == null) quote = "";
        if (author == null) author = "";

        tvQuoteBig.setText(quote);
        tvAuthorBig.setText(author);
    }
}
