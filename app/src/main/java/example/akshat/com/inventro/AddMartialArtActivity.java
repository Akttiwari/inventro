package example.akshat.com.inventro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMartialArtActivity extends AppCompatActivity implements View.OnClickListener{
      EditText edtName,edtPrice,edtColor;
       Button btnAddMartialArt,btnBack;
      Database databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_martial_art);
                edtName=(EditText)findViewById(R.id.edtName);
            edtPrice=(EditText)findViewById(R.id.edtPrice);
           edtColor=(EditText)findViewById(R.id.edtColor);
//
          btnAddMartialArt=(Button)findViewById(R.id.btnAddMartialArt);
          btnBack=(Button)findViewById(R.id.btnGoBack);

          databaseHandler=new Database(AddMartialArtActivity.this);
//
           btnAddMartialArt.setOnClickListener(AddMartialArtActivity.this);
            btnBack.setOnClickListener(AddMartialArtActivity.this);
    }
     private void addMartialArtObjectToDatabase(){
          String nameValue=edtName.getText().toString();
          String priceValue=edtPrice.getText().toString();
          String colorValue= edtColor.getText().toString();
            try{
               double priceDoubleValue = Double.parseDouble(priceValue);
               MartialArt martialArtObject=new MartialArt(0,nameValue,
                       priceDoubleValue,colorValue);
               databaseHandler.addMartialArt(martialArtObject);
             Toast.makeText(AddMartialArtActivity.this,martialArtObject+"This product is added to list",Toast.LENGTH_SHORT).show();
           }catch (Exception e){
               e.printStackTrace();
           }


     }
////
     @Override
       public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAddMartialArt:
                addMartialArtObjectToDatabase();
                break;
            case R.id.btnGoBack:
                this.finish();
                break;
        }
//
    }
}
