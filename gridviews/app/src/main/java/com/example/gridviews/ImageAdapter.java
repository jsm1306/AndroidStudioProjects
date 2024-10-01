package com.example.gridviews;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private int[] mImageIds;
        public ImageAdapter(Context context, int[] imageIds) {
            mContext = context;
            mImageIds = imageIds;
        }
        @Override
        public int getCount() {
            return mImageIds.length;
        }
        @Override
        public Object getItem(int position) {
            return mImageIds[position];
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView,
                            ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new
                        GridView.LayoutParams(200, 200));

                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mImageIds[position]);
            return imageView;
        }
    }
