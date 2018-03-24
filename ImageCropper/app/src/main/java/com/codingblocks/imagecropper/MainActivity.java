package com.codingblocks.imagecropper;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnSelect;
    private Uri mImageCaptureUri;
    ImageView finalImageView;
    static String fileNameNew;
    private static final int REQUEST_CODE_CAMERA = 123;
    private static final int REQUEST_CODE_CROP = 219;
    private static final int REQUEST_CODE_FILE = 345;
    private static final int REQUEST_CODE_PERMISSIONS = 893;

    EditText et1cropX, et2cropY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        finalImageView = (ImageView) findViewById(R.id.final_image_view);
        et1cropX = (EditText) findViewById(R.id.etCropX);
        et2cropY = (EditText) findViewById(R.id.etCropY);

        requestPermissions();
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (requestPermissions())
                    createMyDialog();
            }
        });
        if(savedInstanceState != null)
             fileNameNew =  savedInstanceState.getString("KEY");

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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSIONS) {

        }
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
                    finalImageView.setImageURI(mImageCaptureUri);
                    if(mImageCaptureUri==null)
                        Toast.makeText(this, "filrname null", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(this, ": "+fileNameNew, Toast.LENGTH_SHORT).show();
                    cropImage(true);
                }
                break;
            case REQUEST_CODE_CROP:
                if (resultCode != Activity.RESULT_OK)
                    Toast.makeText(this, "Error in cropping", Toast.LENGTH_SHORT).show();
                else {
                    Bundle extras = data.getExtras();
                    Uri imageUri = data.getData();
                    if (extras != null) {
                        Uri photo = extras.getParcelable("data");
                    }
                    File f = null;

                    if (imageUri != null) {
                        finalImageView.setImageURI(imageUri);
                        try {
                            String path = imageUri.getPath();
                            f = new File(path);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    if (f != null && f.exists())
                        Toast.makeText(this, "Cropped image saved to " + f.getAbsolutePath(),
                                Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_CODE_FILE:
                if (resultCode != Activity.RESULT_OK)
                    Toast.makeText(this, "Error in getting file", Toast.LENGTH_SHORT).show();
                else {
                    mImageCaptureUri = data.getData();
                    cropImage(false);
                }
                break;
        }

    }

    public class CropOption {
        public CharSequence title;
        public String packagename;
        public Drawable icon;
        public Intent appIntent;
    }

    private void cropImage(final boolean fromcamera) {
        final ArrayList<CropOption> cropOptions = new ArrayList<CropOption>();
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setType("image/*");

        List<ResolveInfo> list = getPackageManager().queryIntentActivities(
                intent, 0);
        int size = list.size();

        if (size == 0) {
            Toast.makeText(this, "Can not find image crop app",
                    Toast.LENGTH_SHORT).show();
            return;
        } else {

            if (fromcamera) {
                File f = new File(fileNameNew);
                Uri mImageCropUri2 =
                        FileProvider.getUriForFile(MainActivity.this,
                                getPackageName() + ".provider",
                                f);
                intent.setData(mImageCropUri2);
                //  intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            } else {
                intent.setData(mImageCaptureUri);
            }
            int x = 200, y = 200;
            try {
                x = Integer.parseInt(et1cropX.getText().toString());
                y = Integer.parseInt(et2cropY.getText().toString());
            } catch (Exception e) {
                e.printStackTrace();
                x = 200;
                y = 200;
            }
            intent.putExtra("outputX", x);
            intent.putExtra("outputY", y);
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("scale", true);
            intent.putExtra("return-data", true);

            File f2 = new File(Environment
                    .getExternalStorageDirectory(), "crop_version"
                    + String.valueOf(System.currentTimeMillis())
                    + ".jpg");
            final Uri mImageCropUri =
                    FileProvider.getUriForFile(MainActivity.this,
                            getPackageName() + ".provider",
                            f2);
            //To save:
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageCropUri);
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            if (size == 1) {
                Intent i = new Intent(intent);
                ResolveInfo res = list.get(0);
                i.setComponent(new ComponentName(res.activityInfo.packageName,
                        res.activityInfo.name));
                startActivityForResult(i, REQUEST_CODE_CROP);
            } else {

                for (ResolveInfo res : list) {
                    final CropOption co = new CropOption();

                    co.title = getPackageManager().getApplicationLabel(
                            res.activityInfo.applicationInfo);
                    co.icon = getPackageManager().getApplicationIcon(
                            res.activityInfo.applicationInfo);
                    co.packagename = res.activityInfo.packageName;
                    co.appIntent = new Intent(intent);
                    co.appIntent
                            .setComponent(new ComponentName(
                                    res.activityInfo.packageName,
                                    res.activityInfo.name));
                    cropOptions.add(co);
                }

                CropOptionAdapter adapter = new CropOptionAdapter(
                        getApplicationContext(), cropOptions);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Choose Crop App");
                builder.setAdapter(adapter,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int item) {
                                grantUriPermission(cropOptions.get(item).packagename,
                                        mImageCropUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION |
                                                Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                grantUriPermission(cropOptions.get(item).packagename,
                                        cropOptions.get(item).appIntent.getData(),
                                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION |
                                                Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                startActivityForResult(
                                        cropOptions.get(item).appIntent,
                                        REQUEST_CODE_CROP);
                            }
                        });

                builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {

                        if (mImageCaptureUri != null && fromcamera) {
                            getContentResolver().delete(mImageCaptureUri, null,
                                    null);
                            mImageCaptureUri = null;
                        }
                    }
                });

                AlertDialog alert = builder.create();

                alert.show();
            }
        }
    }

    public class CropOptionAdapter extends ArrayAdapter<CropOption> {
        private ArrayList<CropOption> mOptions;
        private LayoutInflater mInflater;

        public CropOptionAdapter(Context context, ArrayList<CropOption> options) {
            super(context, R.layout.crop_selector, options);
            mOptions = options;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup group) {
            if (convertView == null)
                convertView = mInflater.inflate(R.layout.crop_selector, null);

            CropOption item = mOptions.get(position);

            if (item != null) {
                ((ImageView) convertView.findViewById(R.id.iv_icon))
                        .setImageDrawable(item.icon);
                ((TextView) convertView.findViewById(R.id.tv_name))
                        .setText(item.title);

                return convertView;
            }

            return null;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("KEY",fileNameNew);

    }
}
