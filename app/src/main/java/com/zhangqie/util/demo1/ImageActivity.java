package com.zhangqie.util.demo1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangqie.util.R;
import com.zhangqie.util.demo1.imageutil.CompressHelper;

import java.io.File;
import java.text.DecimalFormat;

/**
 * Created by zhangqie on 2018/10/18
 * Describe:  压缩文件，压缩图片，压缩Bitmap
 *
 *
 * https://github.com/nanchen2251/CompressHelper
 */
public class ImageActivity extends AppCompatActivity {


    ImageView iv1,iv2;
    TextView tv1,tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1_image_activity);
        initView();
    }

    private void initView(){
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent picture = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(picture, 2);
            }
        });


        //自定义属性
       /* File newFile = new CompressHelper.Builder(this)
                .setMaxWidth(720)  // 默认最大宽度为720
                .setMaxHeight(960) // 默认最大高度为960
                .setQuality(80)    // 默认压缩质量为80
                .setFileName(yourFileName) // 文件名称
                .setCompressFormat(CompressFormat.JPEG) // 设置默认压缩为jpg格式
                .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES).getAbsolutePath())//路径
                .build()
                .compressToFile(oldFile);*/

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if (requestCode == 2 && resultCode == Activity.RESULT_OK
                && null != data) {
            try {
                Uri selectedImage = data.getData();
                String[] filePathColumns = {MediaStore.Images.Media.DATA};
                Cursor c = this.getContentResolver().query(selectedImage,
                        filePathColumns, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePathColumns[0]);
                String picturePath = c.getString(columnIndex);

                c.close();
                Bitmap bitmap = BitmapFactory.decodeFile(picturePath);
                File file = new File(picturePath);
                tv1.setText(String.format("图片原质量大小 : %s", getReadableFileSize(file.length())));
                iv1.setImageBitmap(bitmap);

                File oldFile = CompressHelper.getDefault(getApplicationContext()).compressToFile(file);
                Bitmap oldBitmap = BitmapFactory.decodeFile(picturePath);
                tv2.setText(String.format("压缩图片质量大小 : %s", getReadableFileSize(oldFile.length())));
                iv2.setImageBitmap(oldBitmap);


            } catch (Exception e) {

            }
        }

    }


    public String getReadableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

}
