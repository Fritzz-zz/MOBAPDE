package com.example.admin.mobapde;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mobapde.BrowseRecycler.BrowseModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;

public class SellActivity extends AppCompatActivity {

    private EditText editTextModel,editTextPrice,TypeTxt,QtyTxt,DescTxt;
    private ImageView imageView;
    private Button AddProdBtn,SelectImgBtn;
    private ProgressBar progressBar;
    private static final int GALLERY_INTENT = 2;
    private Uri mImageUri;

    private DatabaseReference mRootRef;
    private StorageReference mStorage;

    private StorageTask mStorageTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        imageView = findViewById(R.id.imageView2);
        editTextModel = findViewById(R.id.editTextModel);
        editTextPrice = findViewById(R.id.editTextPrice);
        DescTxt = findViewById(R.id.DescTxt);
        AddProdBtn = findViewById(R.id.AddProdBtn);
        SelectImgBtn = findViewById(R.id.SelectImgBtn);
        TypeTxt = findViewById(R.id.TypeTxt);
        QtyTxt = findViewById(R.id.QtyTxt);
        progressBar = findViewById(R.id.progress_bar);

        mStorage = FirebaseStorage.getInstance().getReference("Products");

        mRootRef = FirebaseDatabase.getInstance().getReference("Products");

        AddProdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStorageTask != null && mStorageTask.isInProgress()) {
                    Toast.makeText(SellActivity.this,"Upload in Progress",Toast.LENGTH_LONG).show();
                }
                else{
                    uploadFile();
                }
            }
        });

        SelectImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);

                intent.setType("image/*");

                startActivityForResult(intent,GALLERY_INTENT);
            }
        });
        //String Type = spinnerType.getSelectedItem().toString();

    }

    /*private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, GALLERY_INTENT);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERY_INTENT && resultCode == RESULT_OK
                && data !=null && data.getData() != null){
            mImageUri = data.getData();

            Picasso.get().load(mImageUri).into(imageView);
        }
    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile(){
        //check if user picked an image
        if(mImageUri != null){
            StorageReference fileReference = mStorage.child(System.currentTimeMillis()
                    +"."+ getFileExtension(mImageUri));

            mStorageTask = fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            //Delays setting the progress of the progressbar so that
                            // user can see the progress bar at 100
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(0);
                                }
                            }, 5000);

                            Toast.makeText(SellActivity.this,"Upload successful", Toast.LENGTH_LONG).show();
                            BrowseModel product = new BrowseModel(editTextModel.getText().toString().trim(),
                                    taskSnapshot.getUploadSessionUri().toString(),TypeTxt.getText().toString(),
                                    Float.valueOf(editTextPrice.getText().toString()),DescTxt.getText().toString(),Integer.valueOf(QtyTxt.getText().toString()));

                            String uploadID = mRootRef.push().getKey();
                            mRootRef.child(uploadID).setValue(product);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SellActivity.this, e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 *taskSnapshot.getBytesTransferred()
                                    / taskSnapshot.getTotalByteCount());
                            progressBar.setProgress((int)progress);
                        }
                    });
        }
        else{
            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
        }
    }
}

