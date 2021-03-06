package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ViewScoreBoardActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private UserManager userManager;
    private String[] arr = new String[]{"Overall Score" ,"Moles Hit", "Num MazeGames Played",
            "Num MazeItems Collected", "TypeRacerStreak", "Mole All Time High"};
    private List<User> ArrayOfUsers;
    private  TextView[] ArrayOfTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score_board);
        Intent intent = getIntent();
        UserManager userManager1 = (UserManager) intent.getSerializableExtra(GameConstants.USERMANAGER);
        if (userManager1 != null){
            setUserManager(userManager1);
            ArrayOfUsers = userManager.getListOfAllUsers(getApplicationContext(), userManager.getUser());
            ArrayOfUsers.add(userManager.getUser());
        }

       /* InitializeTextViews arr = new InitializeTextViews(this);
        ArrayOfTextView = arr.getArrayOfTextViews(this);*/

        TextView FirstUserName = findViewById(R.id.FirstUserName);
        TextView SecondUserName = findViewById(R.id.SecondUserName);
        TextView ThirdUserName = findViewById(R.id.ThirdUserName);
        TextView FourthUserName = findViewById(R.id.FourthUserName);
        TextView FifthUserName = findViewById(R.id.FifthUserName);
        TextView SixthUserName = findViewById(R.id.SixthUserName);
        TextView SeventhUserName = findViewById(R.id.SeventhUserName);
        TextView EighthUserName = findViewById(R.id.EighthUserName);
        TextView NinthUserName = findViewById(R.id.NinthUserName);
        TextView TenthUserName = findViewById(R.id.TenthUserName);
        TextView EleventhUserName = findViewById(R.id.EleventhUserName);
        TextView TwelfthUserName = findViewById(R.id.TwelfthUserName);
        TextView ThirteenUserName = findViewById(R.id.ThirteenUserName);
        TextView FourteenUserName = findViewById(R.id.FourteenUserName);
        TextView FifteenUserName = findViewById(R.id.FifteenUserName);
        TextView SixteenUserName = findViewById(R.id.SixteenUserName);
        TextView SeventeenUserName = findViewById(R.id.SeventeenUserName);
        TextView EighteenUserName = findViewById(R.id.EighteenUserName);
        TextView NineteenUserName = findViewById(R.id.NineteenUserName);
        TextView TwentyUserName = findViewById(R.id.TwentyUserName);
        TextView FirstUserStat = findViewById(R.id.FirstUserStat);
        TextView SecondUserStat = findViewById(R.id.SecondUserStat);
        TextView ThirdUserStat = findViewById(R.id.ThirdUserStat);
        TextView FourthUserStat = findViewById(R.id.FourthUserStat);
        TextView FifthUserStat = findViewById(R.id.FifthUserStat);
        TextView SixthUserStat = findViewById(R.id.SixthUserStat);
        TextView SeventhUserStat = findViewById(R.id.SeventhUserStat);
        TextView EighthUserStat = findViewById(R.id.EighthUserStat);
        TextView NinthUserStat = findViewById(R.id.NinthUserStat);
        TextView TenthUserStat = findViewById(R.id.TenthUserStat);
        TextView EleventhUserStat = findViewById(R.id.EleventhUserStat);
        TextView TwelfthUserStat = findViewById(R.id.TwelfthUserStat);
        TextView ThirteenUserStat = findViewById(R.id.ThirteenUserStat);
        TextView FourteenUserStat = findViewById(R.id.FourteenUserStat);
        TextView FifteenUserStat = findViewById(R.id.FifteenUserStat);
        TextView SixteenUserStat = findViewById(R.id.SixteenUserStat);
        TextView SeventeenUserStat = findViewById(R.id.SeventeenUserStat);
        TextView EighteenUserStat = findViewById(R.id.EighteenUserStat);
        TextView NineteenUserStat = findViewById(R.id.NineteenUserStat);
        TextView TwentyUserStat = findViewById(R.id.TwentyUserStat);
        ArrayOfTextView = new TextView[]{FirstUserName, FirstUserStat, SecondUserName,
                SecondUserStat, ThirdUserName, ThirdUserStat, FourthUserName, FourthUserStat,
                FifthUserName, FifthUserStat, SixthUserName, SixthUserStat, SeventhUserName,
                SeventhUserStat, EighthUserName, EighthUserStat, NinthUserName, NinthUserStat,
                TenthUserName, TenthUserStat, EleventhUserName, EleventhUserStat, TwelfthUserName,
                TwelfthUserStat, ThirteenUserName, ThirteenUserStat, FourteenUserName, FourteenUserStat,
                FifteenUserName, FifteenUserStat, SixteenUserName, SixteenUserStat, SeventeenUserName,
                SeventeenUserStat, EighteenUserName, EighteenUserStat, NineteenUserName, NineteenUserStat,
                TwentyUserName, TwentyUserStat};

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Statistics, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //setupScoreBoard(ArrayOfUsers, "Overall Score");
    }
    private void setUserManager(UserManager usermanager){
        userManager = usermanager;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        //Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_LONG).show();
        //TextView Header = findViewById(R.id.HeaderUserName);
        TextView Statistic = findViewById(R.id.StatisticName);
        //String header = "     Username" + "          " + text;
        //Header.setText("Username");
        List<User> cloneOfUsers = new ArrayList<>(ArrayOfUsers);
        Statistic.setText(text);
        setupScoreBoard(text, cloneOfUsers);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void setupScoreBoard(String SortingChooser, List<User> clone) {
        if(SortingChooser.equals("Overall Score")){
            Collections.sort(clone);
            List<User> ArrayUser;
            if (GameConstants.NumPeopleOnScoreBoard >= clone.size()) {
                ArrayUser = clone;
            }else{
                ArrayUser = clone.subList(0, GameConstants.NumPeopleOnScoreBoard);
            }
            setupTextViews(ArrayUser, ArrayOfTextView, null, null);
        }else{
            String[] Attributes = getAttributesForSorting(SortingChooser);
            String GameName = Attributes[0];
            String Statistic = Attributes[1];
            List<User> ArrayUser;
            Collections.sort(clone, new SortingUser(GameName, Statistic));
            if (GameConstants.NumPeopleOnScoreBoard >= clone.size()) {
                ArrayUser = clone;
            }else{
                ArrayUser = clone.subList(0, GameConstants.NumPeopleOnScoreBoard);
            }
            setupTextViews(ArrayUser, ArrayOfTextView, GameName, Statistic);

        }
    }

    private void setupTextViews(List<User> arrayUsers, TextView[] arrayOfTextView, String GameName,
                                String Statistic) {
        int i = 0;
        int numbering = 1;
        for(User user: arrayUsers){
            //TextView textViewObject = arrayOfTextView[i];
            if (GameName == null) {
                //String text = "   " + (i + 1) + ". " + user.getEmail() + "                " + user.getOverallScore();
                //textViewObject.setText(text);
                String text = numbering + "." + user.getEmail();
                arrayOfTextView[i].setText(text);
                arrayOfTextView[i + 1].setText(String.valueOf(user.getOverallScore()));
            }else{
                /*String text = "   " + (i + 1) + ". " + user.getEmail() + "                " +
                        user.getStatistic(GameName, Statistic);
                textViewObject.setText(text);*/
                String text = numbering + "." + user.getEmail();
                arrayOfTextView[i].setText(text);
                arrayOfTextView[i + 1].setText(String.valueOf(user.getStatistic(GameName, Statistic)));
            }
            numbering += 1;
            i += 2;
        }

        setupRemainingTextViews(i, numbering);
    }

    private void setupRemainingTextViews(int i, int numbering) {
        int remainingNumbers = numbering;
        for (int n = i; n < ArrayOfTextView.length; n += 2) {
            String text = remainingNumbers + ".";
            ArrayOfTextView[n].setText(text);
            remainingNumbers += 1;
        }
    }

    private String[] getAttributesForSorting(String sortingChooser) {
        switch (sortingChooser){
            case "Moles Hit":
                return new String[]{GameConstants.NameGame1, GameConstants.MoleHit};
            case "Num MazeGames Played":
                return new String[]{GameConstants.NameGame3, GameConstants.NumMazeGamesPlayed};
            case "Num MazeItems Collected":
                return new String[]{GameConstants.NameGame3, GameConstants.NumCollectiblesCollectedMaze};
            case "TypeRacerStreak":
                return new String[]{GameConstants.NameGame2, GameConstants.TypeRacerStreak};
            case "Mole All Time High":
                return new String[]{GameConstants.NameGame1, GameConstants.MoleAllTimeHigh};
        }
        return new String[]{};
    }

    public void GoBackToMainMenu(View view){
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(GameConstants.USERMANAGER, userManager);
        startActivity(intent);
    }
}

/*class InitializeTextViews extends ViewScoreBoardActivity{

    private Context context;

    InitializeTextViews(Context context1){
        this.context = context1;
    }

    public  TextView[] getArrayOfTextViews(Context context){
        TextView[] ArrayOfTextView;
        TextView FirstUserName = findViewById(R.id.FirstUserName);
        TextView SecondUserName = findViewById(R.id.SecondUserName);
        TextView ThirdUserName = findViewById(R.id.ThirdUserName);
        TextView FourthUserName = findViewById(R.id.FourthUserName);
        TextView FifthUserName = findViewById(R.id.FifthUserName);
        TextView SixthUserName = findViewById(R.id.SixthUserName);
        TextView SeventhUserName = findViewById(R.id.SeventhUserName);
        TextView EighthUserName = findViewById(R.id.EighthUserName);
        TextView NinthUserName = findViewById(R.id.NinthUserName);
        TextView TenthUserName = findViewById(R.id.TenthUserName);
        TextView EleventhUserName = findViewById(R.id.EleventhUserName);
        TextView TwelfthUserName = findViewById(R.id.TwelfthUserName);
        TextView ThirteenUserName = findViewById(R.id.ThirteenUserName);
        TextView FourteenUserName = findViewById(R.id.FourteenUserName);
        TextView FifteenUserName = findViewById(R.id.FifteenUserName);
        TextView SixteenUserName = findViewById(R.id.SixteenUserName);
        TextView SeventeenUserName = findViewById(R.id.SeventeenUserName);
        TextView EighteenUserName = findViewById(R.id.EighteenUserName);
        TextView NineteenUserName = findViewById(R.id.NineteenUserName);
        TextView TwentyUserName = findViewById(R.id.TwentyUserName);
        TextView FirstUserStat = findViewById(R.id.FirstUserStat);
        TextView SecondUserStat = findViewById(R.id.SecondUserStat);
        TextView ThirdUserStat = findViewById(R.id.ThirdUserStat);
        TextView FourthUserStat = findViewById(R.id.FourthUserStat);
        TextView FifthUserStat = findViewById(R.id.FifthUserStat);
        TextView SixthUserStat = findViewById(R.id.SixthUserStat);
        TextView SeventhUserStat = findViewById(R.id.SeventhUserStat);
        TextView EighthUserStat = findViewById(R.id.EighthUserStat);
        TextView NinthUserStat = findViewById(R.id.NinthUserStat);
        TextView TenthUserStat = findViewById(R.id.TenthUserStat);
        TextView EleventhUserStat = findViewById(R.id.EleventhUserStat);
        TextView TwelfthUserStat = findViewById(R.id.TwelfthUserStat);
        TextView ThirteenUserStat = findViewById(R.id.ThirteenUserStat);
        TextView FourteenUserStat = findViewById(R.id.FourteenUserStat);
        TextView FifteenUserStat = findViewById(R.id.FifteenUserStat);
        TextView SixteenUserStat = findViewById(R.id.SixteenUserStat);
        TextView SeventeenUserStat = findViewById(R.id.SeventeenUserStat);
        TextView EighteenUserStat = findViewById(R.id.EighteenUserStat);
        TextView NineteenUserStat = findViewById(R.id.NineteenUserStat);
        TextView TwentyUserStat = findViewById(R.id.TwentyUserStat);
        ArrayOfTextView = new TextView[]{FirstUserName, FirstUserStat, SecondUserName,
                SecondUserStat, ThirdUserName, ThirdUserStat, FourthUserName, FourthUserStat,
                FifthUserName, FifthUserStat, SixthUserName, SixthUserStat, SeventhUserName,
                SeventhUserStat, EighthUserName, EighthUserStat, NinthUserName, NinthUserStat,
                TenthUserName, TenthUserStat, EleventhUserName, EleventhUserStat, TwelfthUserName,
                TwelfthUserStat, ThirteenUserName, ThirteenUserStat,  FourteenUserName, FourteenUserStat,
                FifteenUserName, FifteenUserStat, SixteenUserName, SixteenUserStat, SeventeenUserName,
                SeventeenUserStat, EighteenUserName, EighteenUserStat, NineteenUserName, NineteenUserStat,
                TwentyUserName, TwentyUserStat};
        return ArrayOfTextView;
    }

}*/
