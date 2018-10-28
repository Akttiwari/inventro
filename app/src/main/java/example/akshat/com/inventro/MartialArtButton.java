package example.akshat.com.inventro;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

public class MartialArtButton extends AppCompatButton {
    private MartialArt martialArtObject;
    public MartialArtButton(Context context,MartialArt martialArt){
        super(context);
        martialArtObject=martialArt;
    }
    public String getMartialArtColor(){
        return martialArtObject.getMartialArtColor();
    }
    public double getMartialArtPrice(){

        return martialArtObject.getMaritalArtPrice();
    }

}
