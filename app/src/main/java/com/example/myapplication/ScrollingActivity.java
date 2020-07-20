package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Html;
import android.view.View;
import android.widget.TextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle("Vicars Desk");

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Vicars Desk");
        TextView vicarsDeskText=(TextView) findViewById(R.id.vicarsDeskID);
        //vicarsDeskText.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        String data = "<br><br><i>Greetings to all in the matchless name of our Lord and Savior Jesus Christ..</i>" +
                " <br><br><strong> <i> Church a Called out Community of Disciples </i> </strong> <b>(I Cor.12:27)</b> <br><br>"+
                " The word ‘church’ in the Bible comes from the Greek word <i>'ecclesia'</i>, which means, a called out community or assembly. We see the word ‘church’ used in three different ways in the Bible:"+
                "<li> <i> First </i>, as the body of Christ, in which the church is often defined as a local assembly or a group of believers (1 Corinthians 1:2; 2 Corinthians 1:1; Galatians 1:1-2). </li>"+
                "<li> <i> Secondly </i>, it is defined as the body of individual living believers (1 Corinthians 15:9; Galatians 1:13). </li>"+
                "<li> <i> Finally </i>, it is defined as the universal group of all people who have trusted Christ as their Lord and Savior through the ages (Matthew 16:18; Ephesians 5:23-27). </li>"+
                " Having stated what it means to be a church, let us briefly see the inevitable components of a Living and Healthy Church. The purpose of the church is to carry on the mission of proclaiming the gospel of Christ to make disciples who in turn become the light and the salt of the world. Therefore, gospel and its life transforming character must be the heart of the church and should be reflected in the lifestyle and mindset of its members. The church is to have God-ward focus in her worship, works and witness and her prime focus should be given for the glory of God (1 Pet.4:11). God’s love, grace and mercy are the reasons in which Church exist. Without God being central to our actions, attitudes, decisions and conversations it is impossible to see a living and healthy Church. What water and food is to the human body, God is to the Living and Healthy Church. <br><br>"+
                " I strongly believe that the church should be a hospital where Jesus is our master physician and people who are physically, mentally, emotionally and spiritually wounded can check in and when they leave they are either healed or on their road to recovery. Abigail Van Buren says <i> “Church should be a Hospital for sinners, not a Museum for Saints.”</i> I strongly desire that our parish should function as a hospital where many are healed, restored to the joy of living and become a magnetic force for the broken hearted and to the hostile community in this great city of Mumbai. Yes, church is the salt of the earth and we as a parish have to be conscious to retain the saltiness of the church with the help of the Holy Spirit, because what good is salt if it loses its saltiness? (Mtt.5:13) <br><br>"+
                " In addition to what is been said, another inevitable component of the church is the Fellowship among the body of Christ which primarily focuses on the inward ministry of the Church. Therefore, we need to be reconciled and strengthened in our relationship with one another to experience the inner healing for a vibrant and healthy living. Mending broken relationship is the responsibility of each member of the parish and God has given us a lot of opportunities to be a blessing. Let us wisely use these as stepping stones to enter into the lives of others and influence them with the joy of the Lord. What we do not have, we cannot give to the world outside. Be different and make a difference. (Jn.17:23) Let the world know that we are the disciples of our Master by our harmonious living. <br><br>"+
                " The idea of having an electronic application for the parish is the brain child of our youth secretary Mr. Joe Thomas. He shared this idea with our secretary Mr. George Eapen, who has been an inspiration for us always, especially for the youth. The trio, (Mr. Boney T Reji, Mr. Joe Thomas and Mr. Abin Varghese Jacob) with the help of others worked as a team and have relentlessly pursued towards the fulfillment of this project in the midst of their hectic work schedule. Thus, their endeavor has become a benchmark for the youths of STECI. On this momentous occasion, I congratulate the team for their dedicated efforts and noble intention in bringing out this piece of information as a significant milestone in the history of Bhandup Parish. This is prepared as a tool, to connect with everyone easily. Remember, we are not an island but a vibrant community of God’s people with compassion and love. Let us use our talents and skills for the edification of our community and also to reach out other communities with the gospel of Jesus Christ. By doing this we become the partners of God’s mission to fulfill the Great Commission.<br><br>"+
                " Let us pray to the Lord of the Church to build us as a living and healthy parish to impact the generations to come with the footprints of godly legacies. <br> <br>"+
                " With Love and Prayers,<br> <br>"+
                " <b>Rejiachen..</b><br> ";

        vicarsDeskText.setText (Html.fromHtml(data));
    }
}