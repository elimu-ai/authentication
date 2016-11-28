package org.literacyapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

public class CustomDaoMaster extends DaoMaster {

    public CustomDaoMaster(SQLiteDatabase db) {
        super(db);
        Log.i(getClass().getName(), "CustomDaoMaster");
    }

    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name) {
            super(context, name);
        }

        public DevOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            Log.i(getClass().getName(), "Upgrading schema from version " + oldVersion + " to " + newVersion);

//            if (newVersion == 1001018) {
//                // Add new tables and/or columns automatically (include only the DAO classes that have been modified)
//                DbMigrationHelper.migrate(db,
//                        DeviceDao.class,
//                        StudentImageDao.class
//                );
//            }

            if (newVersion == 1001021) {
                // Drop all tables
                dropAllTables(db, true);
                onCreate(db);
            }

            // If tables and/or columns have been renamed, add custom script.
//            db.execSQL("...");
        }
    }
}