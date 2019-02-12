package bonifacekamau.com.roomlibrary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class} , version = 1)

public abstract class MyDatabase extends RoomDatabase{

    public abstract UserDao getUserDao();

    private  static MyDatabase instance;

    public  static MyDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room
                        .databaseBuilder(context, MyDatabase.class, "my_db")
                        .allowMainThreadQueries()
                        .build();
        }
        return instance;
    }


}
