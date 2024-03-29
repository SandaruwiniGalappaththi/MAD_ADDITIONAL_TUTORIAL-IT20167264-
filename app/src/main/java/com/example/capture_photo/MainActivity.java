package com.example.capture_photo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = (ImageView) this.findViewById(R.id.img_vv1);
        Button photoBtn = (Button) this.findViewById(R.id.btn_takephoto);

        photoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }
          @Override
               protected void onActivityResult(int requestCode,int resultCode,Intent data){
                    super.onActivityResult(requestCode,resultCode,data);
                    if (requestCode == CAMERA_REQUEST){
                        Bitmap photo = (Bitmap) data.getExtras().get("data");
                        imageview.setImageBitmap(photo);
            }
        }

}