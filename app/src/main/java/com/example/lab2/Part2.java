package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.lab2.model.Question;

public class Part2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Question question = new Question("Сколько будет 2 * 2?", 1, "3", "4", "5");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        TextView textView = (TextView)findViewById(R.id.textViewQuestion);
        textView.setText(question.getQuestionText());
        RadioButton button1 = (RadioButton)findViewById(R.id.button1);
        RadioButton button2 = (RadioButton)findViewById(R.id.button2);
        RadioButton button3 = (RadioButton)findViewById(R.id.button3);
        button1.setText(question.getAnswers()[0]);
        button2.setText(question.getAnswers()[1]);
        button3.setText(question.getAnswers()[2]);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.part2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_par2) {
            // Handle the camera action
        } else if (id == R.id.nav_par1) {
            startActivity(new Intent(this, MainActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void toAnswerClick(View view) {
        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra("answer", getAnswer((RadioButton)findViewById(
                        ((RadioGroup)findViewById(R.id.radioGroup)).getCheckedRadioButtonId())));
        startActivity(intent);
    }

    private String getAnswer(RadioButton button) {
        StringBuilder text = new StringBuilder("Відповідь ");
        if (button == null) {
            text.append(getString(R.string.nothing_selected));
        } else {
            if (button.getText().equals(question.getProperAnswer())) {
                text.append(getString(R.string.correct));
            } else {
                text.append(getString(R.string.wrong))
                    .append(question.getAnswers()[question.getIndexOfProperAnswer()]);
            }
        }
        return text.toString();
    }
}
