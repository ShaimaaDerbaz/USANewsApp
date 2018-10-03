package com.example.shaimaaderbaz.raye7task.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Shaimaa Derbaz on 2/6/2018.
 */

public final class FavoriteContract {

    private FavoriteContract() {}

    public static class FavoriteEntry implements BaseColumns {
        public static final String TABLE_NAME = "favorites";

        public static final String _ID= BaseColumns._ID;
        public static final String COLUMN_FAVORITE_TITLE="favoritetitle";
        public static final String COLUMN_TIME ="time";
        public static final String COLUMN_URL="url";
        public static final String COLUMN_IMAGE_UrL="imageurl";


        public static final String CONTENT_AUTHORITY = "com.example.shaimaaderbaz.favortie";
        public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);//the basic to use and mke append to it
        public static final String PATH_PRODUCTS = "favorties";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PRODUCTS);

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact";
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;




    }
    }
