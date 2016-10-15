package com.example.jack.mylibrary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jack on 14/10/2016.
 */

public class CustomAdapter extends ArrayAdapter<String>{

    public CustomAdapter(Context context, String[] achievements) {
        super(context,R.layout.custom_achievement ,achievements);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater achievementInflater = LayoutInflater.from(getContext());
        View customView = achievementInflater.inflate(R.layout.custom_achievement, parent, false);

        String achievementItem = getItem(position);
        TextView achievementTitle = (TextView) customView.findViewById(R.id.achievement_title);
        ImageView achievementScoreImage = (ImageView) customView.findViewById(R.id.achievement_score_image);
        TextView achievementDescription = (TextView) customView.findViewById(R.id.achievement_description);
//
//        //set paint
//        Paint paint= new Paint();
//        paint.setColor(Color.YELLOW);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//
//        //set bitmap
//        Bitmap bmp = Bitmap.createBitmap(500,500,Bitmap.Config.ARGB_8888);
//
//        //Canvas
//        Canvas canvas = new Canvas(bmp);
//        canvas.drawCircle(bmp.getWidth()/2, bmp.getHeight()/2, 20, paint );
//
//        //output circle
//        achievementScoreImage.setImageBitmap(bmp);
//

        achievementTitle.setText(achievementItem);
        achievementScoreImage.setImageResource(R.drawable.filler);
        achievementDescription.setText("Descriptions blah blahh fgiuhgiu isu diuh dfi gihdfigu dfh igdfhg di ddfuh ");
        return customView;
    }
}

