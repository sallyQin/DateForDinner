package com.example.a1.datefordinner;


import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 * Created by 1 on 2017/9/10.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> implements LoaderManager.LoaderCallbacks {
    MainActivity mMainActivity;
    private Cursor mCursor;
    CursorLoader loader;
    int mSelected = -1;
    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        if (null == loader) {
            loader = new CursorLoader(mMainActivity, MyContentProvider.URI, null, null, null, null);
        } else {
            loader = new CursorLoader(mMainActivity, MyContentProvider.URI, null, loader.getSelection(), loader.getSelectionArgs(), null);
        }
        return loader;
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        if (mCursor != data) {
            if (mCursor != null) {
                mCursor.close();
            }
            mCursor = (Cursor) data;
        }
        notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader loader) {
        if (mCursor != null) {
            mCursor.close();
        }
        mCursor = null;
    }

    public MyAdapter(Activity activity) {
        mMainActivity = (MainActivity) activity;
        ((MainActivity) activity).getSupportLoaderManager().restartLoader(0, null, MyAdapter.this);


    }
    public static class Holder extends RecyclerView.ViewHolder{
        SimpleDraweeView avatar_show;
        TextView nickname_show_txt,age_txt,explain_show_txt,date_show_txt,time_show_txt,personNum_show_txt,cost_show_txt,location_show_txt,myDate_show_txt;
        LinearLayout sex_bg_linear,likes_linear;
        ImageView sex_show_pic,location_logo_pic,likes_show_pic;
        public Holder(View itemView) {
            super(itemView);
            avatar_show = (SimpleDraweeView) itemView.findViewById(R.id.avatar_show_pic);
            nickname_show_txt = (TextView) itemView.findViewById(R.id.nickname_show_txt);
            sex_show_pic = (ImageView) itemView.findViewById(R.id.sex_show_pic);
            age_txt = (TextView) itemView.findViewById(R.id.age_txt);
            explain_show_txt = (TextView) itemView.findViewById(R.id.explain_show_txt);
            date_show_txt = (TextView) itemView.findViewById(R.id.date_show_txt);
            time_show_txt = (TextView) itemView.findViewById(R.id.time_show_txt);
            personNum_show_txt = (TextView) itemView.findViewById(R.id.personNum_show_txt);
            cost_show_txt = (TextView) itemView.findViewById(R.id.cost_show_txt);
            location_show_txt  = (TextView) itemView.findViewById(R.id.location_show_txt);
            myDate_show_txt = (TextView) itemView.findViewById(R.id.myDate_show_txt);
            sex_bg_linear = (LinearLayout) itemView.findViewById(R.id.sex_bg_linear);
            location_logo_pic = (ImageView) itemView.findViewById(R.id.location_logo_pic);
            likes_show_pic = (ImageView) itemView.findViewById(R.id.likes_show_pic);
            likes_linear = (LinearLayout) itemView.findViewById(R.id.likes_linear);
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mMainActivity).inflate(R.layout.recyclerview_myadapter,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        if (mCursor.moveToPosition(position)) {
            holder.avatar_show.setImageURI(Uri.parse("res://x/"+ mMainActivity.getResources().getIdentifier(mCursor.getString(mCursor.getColumnIndex("avatar_show_pic")),"drawable",mMainActivity.getPackageName())));
            holder.nickname_show_txt.setText(mCursor.getString(mCursor.getColumnIndex("nickname_show_txt")));
            holder.sex_show_pic.setImageResource(mMainActivity.getResources().getIdentifier(mCursor.getString(mCursor.getColumnIndex("sex_show_pic")),"drawable",mMainActivity.getPackageName()));
            holder.age_txt.setText(mCursor.getString(mCursor.getColumnIndex("age_show_txt")));
            holder.age_txt.setTextColor(mCursor.getInt(mCursor.getColumnIndex("age_text_color")));
            holder.explain_show_txt.setText(mCursor.getString(mCursor.getColumnIndex("explain_show_txt")));
            holder.date_show_txt.setText(mCursor.getString(mCursor.getColumnIndex("date_show_txt")));
            holder.time_show_txt.setText(mCursor.getString(mCursor.getColumnIndex("time_show_txt")));
            holder.personNum_show_txt.setText(mCursor.getString(mCursor.getColumnIndex("personNum_show_txt")));
            holder.cost_show_txt.setText(mCursor.getString(mCursor.getColumnIndex("cost_show_txt")));
            holder.location_show_txt.setText(mCursor.getString(mCursor.getColumnIndex("location_show_txt")));
            holder.myDate_show_txt.setText(mCursor.getString(mCursor.getColumnIndex("myDate_show_txt")));
            holder.sex_bg_linear.setBackgroundResource(mMainActivity.getResources().getIdentifier(mCursor.getString(mCursor.getColumnIndex("sex_bg")),"drawable",mMainActivity.getPackageName()));
            holder.location_logo_pic.setImageResource(mMainActivity.getResources().getIdentifier(mCursor.getString(mCursor.getColumnIndex("location_logo_pic")),"drawable",mMainActivity.getPackageName()));
            holder.likes_show_pic.setImageResource(mMainActivity.getResources().getIdentifier(mCursor.getString(mCursor.getColumnIndex("likes_show_pic")),"drawable",mMainActivity.getPackageName()));

            holder.likes_linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int positions = holder.getAdapterPosition();
                    mCursor.moveToPosition(positions);
                    ContentValues cv = new ContentValues();
                    if(mSelected == positions){
                        mSelected = -1;
                        cv.put("likes_show_pic","likes_button_unpressed");//更新数据
                        mMainActivity.getContentResolver().update(MyContentProvider.URI,cv,"id = ?",new String[]{String.valueOf((mCursor.getInt(mCursor.getColumnIndex("id"))))});//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                    }else{
                        mSelected = positions;
                        cv.put("likes_show_pic","likes_button_pressed");  //更新数据
                        mMainActivity.getContentResolver().update(MyContentProvider.URI,cv,"id = ?",new String[]{String.valueOf((mCursor.getInt(mCursor.getColumnIndex("id"))))});
                    }
                    notifyDataSetChanged();
                }
            });
        }
    }



    @Override
    public int getItemCount() {
        if (mCursor != null) {  /** normal case */
            return mCursor.getCount();
        } else {                /** mCursor == null, rare case */
            return 0;
        }
    }
}
