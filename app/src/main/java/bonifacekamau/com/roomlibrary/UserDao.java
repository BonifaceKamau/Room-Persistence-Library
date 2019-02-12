package bonifacekamau.com.roomlibrary;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User x);

    @Query("select * from users")
    List<User> getAllUsers();

    @Delete
    void deleteUser(User x);

    @Update
    void updateUser(User y);

    @Query("select * from users where id=:id")
    User getUser(int id);

    @Query("select count(id) from users")
    LiveData<Integer> getCount();




}
