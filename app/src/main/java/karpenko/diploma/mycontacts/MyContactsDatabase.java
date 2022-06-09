package karpenko.diploma.mycontacts;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class}, version = 1)
public abstract class MyContactsDatabase extends RoomDatabase {

    public abstract ContactDAO getContactDao();

}
