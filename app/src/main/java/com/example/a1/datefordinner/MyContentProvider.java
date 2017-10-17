package com.example.a1.datefordinner;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by 1 on 2017/9/13.
 */

public class MyContentProvider extends ContentProvider {
    public static  final Uri URI = Uri.parse("content://sally.dinnerDateProvider");
    MySQLiteOpenHelper mySQLiteOpenHelper;
    @Override
    public boolean onCreate() {
        mySQLiteOpenHelper = new MySQLiteOpenHelper(getContext());
        return true ;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor = mySQLiteOpenHelper.getWritableDatabase().query(MySQLiteOpenHelper.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long lon = mySQLiteOpenHelper.getWritableDatabase().insert(MySQLiteOpenHelper.TABLE_NAME,null,values);
        getContext().getContentResolver().notifyChange(uri,null);
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        mySQLiteOpenHelper.getWritableDatabase().delete(MySQLiteOpenHelper.TABLE_NAME,selection,selectionArgs);
        getContext().getContentResolver().notifyChange(uri,null);
        return  mySQLiteOpenHelper.getWritableDatabase().delete(MySQLiteOpenHelper.TABLE_NAME,selection,selectionArgs);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        mySQLiteOpenHelper.getWritableDatabase().update(MySQLiteOpenHelper.TABLE_NAME,values,selection,selectionArgs);
        getContext().getContentResolver().notifyChange(uri,null);
        return mySQLiteOpenHelper.getWritableDatabase().update(MySQLiteOpenHelper.TABLE_NAME,values,selection,selectionArgs);
    }
}
