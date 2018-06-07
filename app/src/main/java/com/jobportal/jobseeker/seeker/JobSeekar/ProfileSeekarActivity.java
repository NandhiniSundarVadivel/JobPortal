package com.jobportal.jobseeker.seeker.JobSeekar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jobportal.jobseeker.seeker.Global.ImageFilePath;
import com.jobportal.jobseeker.seeker.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by uniflyn on 26/4/18.
 */

public class ProfileSeekarActivity extends AppCompatActivity {
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_profile_edit)
    Button btnProfilrEdit;
    @BindView(R.id.img_edit_profile_pic)
    ImageView imgEditProfilePic;
    @BindView(R.id.btn_add_experience)
    Button btnAddExperience;
    @BindView(R.id.btn_edit_experience)
    Button btnEditExperience;
    @BindView(R.id.btn_add_education)
    Button btnAddEducation;
    @BindView(R.id.btn_edit_education)
    Button btnEditEducation;
    @BindView(R.id.btn_add_accomplishment)
    Button btnAddAccomplishment;
    @BindView(R.id.btn_edit_language)
    Button btnEditLanguage;
    @BindView(R.id.btn_edit_project)
    Button btnEditProject;
    @BindView(R.id.btn_edit_organization)
    Button btnEditOrganization;
    @BindView(R.id.btn_edit_certificate)
    Button btnEditCertificate;
    @BindView(R.id.prfPic)
    CircleImageView prfPic;
    @BindView(R.id.relativeCVUpload)
    RelativeLayout relativeCVUpload;
    @BindView(R.id.btn_edit_prf)
    Button btnEditPrf;
    @BindView(R.id.relativeEditprf)
    RelativeLayout relativeEditprf;
    @BindView(R.id.btn_upload_cv)
    Button btnUploadCv;
    @BindView(R.id.relativeEditUpload)
    LinearLayout relativeEditUpload;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    Bitmap rotatedBitmap = null;
    Uri uri;
    boolean flg = false;
    //testing
    //hi how are you shankari

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_seeker);
        ButterKnife.bind(this);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }

    @OnClick({R.id.btn_edit_prf, R.id.btn_upload_cv,R.id.relativeCVUpload, R.id.btn_back, R.id.btn_profile_edit, R.id.img_edit_profile_pic, R.id.btn_add_experience, R.id.btn_edit_experience, R.id.btn_add_education, R.id.btn_edit_education, R.id.btn_add_accomplishment, R.id.btn_edit_language, R.id.btn_edit_project, R.id.btn_edit_organization, R.id.btn_edit_certificate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relativeCVUpload:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeCVUpload.setBackground(getResources().getDrawable(R.drawable.background_rounded_sp_two));
                }
                break;
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_profile_edit:
                if(!flg){
                    relativeEditUpload.setVisibility(View.VISIBLE);
                    flg = true;
                }else {
                    flg = false;
                    relativeEditUpload.setVisibility(View.GONE);
                }
                break;
            case R.id.img_edit_profile_pic:
                callImagePic();
                break;
            case R.id.btn_add_experience:
                Intent add_experience = new Intent(ProfileSeekarActivity.this, AddExperienceActivity.class);
                add_experience.putExtra("edit_add", "add");
                startActivity(add_experience);
                break;
            case R.id.btn_edit_experience:
                Intent edit_experience = new Intent(ProfileSeekarActivity.this, AddExperienceActivity.class);
                edit_experience.putExtra("edit_add", "edit");
                startActivity(edit_experience);
                break;
            case R.id.btn_add_education:
                Intent add_education = new Intent(ProfileSeekarActivity.this, AddEducationActivity.class);
                add_education.putExtra("edit_add", "add");
                startActivity(add_education);
                break;
            case R.id.btn_edit_education:
                Intent edit_education = new Intent(ProfileSeekarActivity.this, AddEducationActivity.class);
                edit_education.putExtra("edit_add", "edit");
                startActivity(edit_education);
                break;
            case R.id.btn_add_accomplishment:
                Intent add_accomplishment = new Intent(ProfileSeekarActivity.this, AddAccomplishmentActivity.class);
                startActivity(add_accomplishment);
                break;
            case R.id.btn_edit_language:
                break;
            case R.id.btn_edit_project:
                break;
            case R.id.btn_edit_organization:
                break;
            case R.id.btn_edit_certificate:
                break;
            case R.id.btn_edit_prf:
                relativeEditUpload.setVisibility(View.GONE);
                flg = false;
                Intent edit_profile = new Intent(ProfileSeekarActivity.this, EditProfileSeekerActivity.class);
                startActivity(edit_profile);
                break;
            case R.id.btn_upload_cv:
                break;
        }
    }

    private void callImagePic() {

        final Dialog dialog = new Dialog(ProfileSeekarActivity.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
        dialog.setContentView(R.layout.dialog_image_options);
        dialog.show();
        Button btnCamera = (Button) dialog.findViewById(R.id.btn_camera);
        Button btnGallery = (Button) dialog.findViewById(R.id.btn_gallery);
        Button btncancel = (Button) dialog.findViewById(R.id.btn_cancel);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File f = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
//        File f = new File(android.os.Environment.getExternalStorageDirectory().getPath(), "temp.jpg");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                startActivityForResult(intent, REQUEST_CAMERA);
              /*  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CAMERA);*/
            }
        });
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, SELECT_FILE);
            }
        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE) {


                Uri pickedImage = data.getData();
                // Let's read picked image path using content resolver
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
                cursor.moveToFirst();
                String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);
                Log.e("bitmapdecode", String.valueOf(bitmap));
                String realPath = ImageFilePath.getPath(ProfileSeekarActivity.this, data.getData());
                Log.e("pathofgallery", realPath);

                ExifInterface ei = null;
                try {
                    ei = new ExifInterface(realPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                        ExifInterface.ORIENTATION_UNDEFINED);


                switch (orientation) {

                    case ExifInterface.ORIENTATION_ROTATE_90:
                        rotatedBitmap = rotateImage(bitmap, 90);
                        break;

                    case ExifInterface.ORIENTATION_ROTATE_180:
                        rotatedBitmap = rotateImage(bitmap, 180);
                        break;

                    case ExifInterface.ORIENTATION_ROTATE_270:
                        rotatedBitmap = rotateImage(bitmap, 270);
                        break;

                    case ExifInterface.ORIENTATION_NORMAL:
                    default:
                        rotatedBitmap = bitmap;
                }
                Log.e("bitmapgalleryu", rotatedBitmap + "");

                prfPic.setImageBitmap(rotatedBitmap);
                uri = getImageUri(getApplicationContext(), rotatedBitmap);


            } else if (requestCode == REQUEST_CAMERA) {
               /* Bitmap photo = (Bitmap) data.getExtras().get("data");
                imgUser.setImageBitmap(photo);*/

                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);
                    Log.e("paht", f.getAbsolutePath());

                    ExifInterface ei = new ExifInterface(f.getAbsolutePath());
                    int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                            ExifInterface.ORIENTATION_UNDEFINED);


                    switch (orientation) {

                        case ExifInterface.ORIENTATION_ROTATE_90:
                            rotatedBitmap = rotateImage(bitmap, 90);
                            break;

                        case ExifInterface.ORIENTATION_ROTATE_180:
                            rotatedBitmap = rotateImage(bitmap, 180);
                            break;

                        case ExifInterface.ORIENTATION_ROTATE_270:
                            rotatedBitmap = rotateImage(bitmap, 270);
                            break;

                        case ExifInterface.ORIENTATION_NORMAL:
                        default:
                            rotatedBitmap = bitmap;
                    }

                    uri = getImageUri(getApplicationContext(), rotatedBitmap);

                    prfPic.setImageBitmap(rotatedBitmap);
                    String path = Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
    }

    private String getRealPathFromURIPath(Uri contentURI, Activity activity) {
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }

    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(),
                matrix, true);
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

}
