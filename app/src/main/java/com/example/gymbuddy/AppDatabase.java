//package com.example.gymbuddy;
//
//import android.content.Context;
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//@Database(entities = {User.class}, version = 1)
//public abstract class AppDatabase extends RoomDatabase {
//    public abstract UserDao userDao();
//    private static AppDatabase sInstance;
//    public static final String DATABASE_NAME = "gymbuddy";
//
//    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();
//
//    private static AppDatabase buildDatabase(final Context appContext) {
//        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
//                .build();
//    }
//
//    public static AppDatabase getInstance(final Context context) {
//        if (sInstance == null) {
//            synchronized (AppDatabase.class) {
//                if (sInstance == null) {
//                    sInstance = buildDatabase(context.getApplicationContext());
//                }
//            }
//        }
//        return sInstance;
//    }
//
//    private void updateDatabaseCreated(final Context context) {
//        if (context.getDatabasePath(DATABASE_NAME).exists()) {
//            setDatabaseCreated();
//        }
//    }
//
//    private void setDatabaseCreated(){
//        mIsDatabaseCreated.postValue(true);
//    }
//
//    public LiveData<Boolean> getDatabaseCreated() {
//        return mIsDatabaseCreated;
//    }
//}
