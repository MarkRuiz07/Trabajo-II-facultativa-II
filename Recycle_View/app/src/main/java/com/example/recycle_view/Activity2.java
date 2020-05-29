package com.example.recycle_view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    TextView mtitleView, mDescriptionView, mProfesorView, mDiaView, mHoraView, mFechaEntregaView;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);

        ActionBar actionBar=getSupportActionBar();

        mtitleView=findViewById(R.id.titleView);
        mDescriptionView=findViewById(R.id.descriptionView);
        mImageView=findViewById(R.id.imageView);
        mProfesorView= findViewById(R.id.profesorView);
        mDiaView=findViewById(R.id.diaView);
        mHoraView=findViewById(R.id.horaView);
        mFechaEntregaView=findViewById(R.id.fechaEntregaView);


        Intent intent= getIntent();
        String mTitle=intent.getStringExtra("iTitle"); //Se obtiene los datos que fueron enviados desde el MainActivity
        String mDesc=intent.getStringExtra("iDesc");
        String mProf=intent.getStringExtra("iProfe");
        String mDia=intent.getStringExtra("iDia");
        String mHora=intent.getStringExtra("iHora");
        String mFechEntrg= intent.getStringExtra("iFechEntrg");

        byte[] mBytes=getIntent().getByteArrayExtra("iImage");
        Bitmap bitmap= BitmapFactory.decodeByteArray(mBytes, 0,mBytes.length);

        actionBar.setTitle(mTitle);
        mtitleView.setText(mTitle);
        mDescriptionView.setText(mDesc);
        mImageView.setImageBitmap(bitmap);
        mProfesorView.setText(mProf);
        mDiaView.setText(mDia);
        mHoraView.setText(mHora);
        mFechaEntregaView.setText(mFechEntrg);

    }
}
