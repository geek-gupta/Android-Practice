package com.example.gaurav.hypemessanger.MainUI;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gaurav.hypemessanger.DataReceiver.ReceiveMessageActivity;
import com.example.gaurav.hypemessanger.R;
import com.example.gaurav.hypemessanger.Register.LoginActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    ImageButton textUpload,imageUpload;
    ImageView newView;
    private Uri mImageCaptureUri;
    FirebaseAuth AuthUi;
    static String fileNameNew;
    private static final int REQUEST_CODE_CAMERA = 123;
    private static final int REQUEST_CODE_FILE = 345;
    private static final int REQUEST_CODE_PERMISSIONS = 893;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textUpload = (ImageButton) findViewById(R.id.textUpload);
        imageUpload = (ImageButton) findViewById(R.id.imageUpload);
        newView = (ImageView) findViewById(R.id.newView);
        textUpload.setOnClickListener(this);
        imageUpload.setOnClickListener(this);
        if(savedInstanceState != null)
            fileNameNew =  savedInstanceState.getString("KEY");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.msgReceivedItem) {
            Intent intent = new Intent(this, ReceiveMessageActivity.class);
            startActivity(intent);
            return true;
        }
            if (item.getItemId() == R.id.signOutUser) {
                FirebaseAuth.getInstance().signOut();
                Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent1);
                finish();
                return true;
            }
            if(item.getItemId() == R.id.AboutUsSection){

                Intent intent = new Intent(MainActivity.this,AboutSectionUI.class);
                startActivity(intent);
                return true;
            }
            else
                return super.onOptionsItemSelected(item);
        }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.textUpload:
                    Intent intent = new Intent(MainActivity.this, TextSenderActivity.class);
                    startActivity(intent);
                break;
            case R.id.imageUpload:
                requestPermissions();
                if (requestPermissions()){
                    createMyDialog();
                    }
                break;
        }
    }
    boolean requestPermissions() {
        boolean result = true;
        int filePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int camePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (filePermission == PackageManager.PERMISSION_DENIED || camePermission == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions
                    (this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                    Manifest.permission.CAMERA},
                            REQUEST_CODE_PERMISSIONS);
            result = false;
        }
        return result;
    }
    private void createMyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Image Source");
        builder.setItems(new String[]{"Camera", "File"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                        File f = new File(Environment
                                .getExternalStorageDirectory(), "tmp_avatar_"
                                + String.valueOf(System.currentTimeMillis())
                                + ".jpg");
                        fileNameNew = f.getAbsolutePath();
                        mImageCaptureUri =
                                FileProvider.getUriForFile(MainActivity.this,
                                        getPackageName() + ".provider",
                                        f);

                        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
                        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        try {
                            startActivityForResult(intent, REQUEST_CODE_CAMERA);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 1:
                        Intent intentFile = new Intent();
                        intentFile.setType("image/*");
                        intentFile.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intentFile,
                                "Complete action using"), REQUEST_CODE_FILE);
                        break;
                }
            }
        });
        AlertDialog dialog;
        dialog = builder.create();
        dialog.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_CAMERA:

                if (resultCode != Activity.RESULT_OK)
                    Toast.makeText(this, "Error from camera", Toast.LENGTH_SHORT).show();
                else {
                    File f = new File(fileNameNew);
                    mImageCaptureUri =
                            FileProvider.getUriForFile(MainActivity.this,
                                    getPackageName() + ".provider",
                                    f);
                    newView.setVisibility(View.VISIBLE);
                    newView.setImageURI(mImageCaptureUri);
                    newView.setRotation(90);
                    if (mImageCaptureUri == null)
                        Toast.makeText(this, "filrname null", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(this, ": " + fileNameNew, Toast.LENGTH_SHORT).show();
                }
                break;

            case REQUEST_CODE_FILE:
                if (resultCode != Activity.RESULT_OK)
                    Toast.makeText(this, "Error in getting file", Toast.LENGTH_SHORT).show();
                else{
                    mImageCaptureUri = data.getData();
                    newView.setVisibility(View.VISIBLE);
                    newView.setImageURI(mImageCaptureUri);
                    newView.setRotation(90);
                    Log.d("KEY", "onActivityResult: "+mImageCaptureUri.getPath());

                }
                break;
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("KEY",fileNameNew);

    }

}
