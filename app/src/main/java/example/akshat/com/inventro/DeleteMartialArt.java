package example.akshat.com.inventro;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteMartialArt extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener{


     private Database databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_martial_art);

        databaseHandler = new Database(DeleteMartialArt.this);


        updateTheUserInterface();
    }

    private void updateTheUserInterface(){
        ArrayList<MartialArt>allMartialArtObjects=
                databaseHandler.returnAllMartialArtObjects();
        RelativeLayout relativeLayout=new RelativeLayout(DeleteMartialArt.this);
        ScrollView scrollView=new ScrollView(DeleteMartialArt.this);
        RadioGroup radioGroup=new RadioGroup(DeleteMartialArt.this);
        for(MartialArt martialArt: allMartialArtObjects){
            RadioButton currentRadioButton = new RadioButton(DeleteMartialArt.this);
            currentRadioButton.setId(martialArt.getMartialArtID());
            currentRadioButton.setText(martialArt.toString());
            radioGroup.addView(currentRadioButton);
        }
        radioGroup.setOnCheckedChangeListener(DeleteMartialArt.this);
        Button btnBack = new Button(DeleteMartialArt.this);
        btnBack.setText("Go Back");
        btnBack.setOnClickListener(DeleteMartialArt.this);
        scrollView.addView(radioGroup);

        RelativeLayout.LayoutParams buttonParams=new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0,0,0,70);


        relativeLayout.addView(btnBack,buttonParams);
        ScrollView.LayoutParams scrollViewParams = new ScrollView.LayoutParams(
          ScrollView.LayoutParams.MATCH_PARENT,
          ScrollView.LayoutParams.MATCH_PARENT
        );
        relativeLayout.addView(scrollView,scrollViewParams);


        setContentView(relativeLayout);
    }

    @Override
    public void onCheckedChanged(RadioGroup group,@IdRes int checkedId) {

        databaseHandler.deleteMartialArtObjectFromDatabaseByID(checkedId);
        Toast.makeText(DeleteMartialArt.this,"the martial art activity is deleted",Toast.LENGTH_SHORT).show();
        updateTheUserInterface();
    }

    @Override
    public void onClick(View v) {

        finish();
    }
}
