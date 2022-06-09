package karpenko.diploma.mycontacts;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDAO {

    @Insert
    void insertContact(Contact contact);

    @Update
    void updateContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);

    @Query("select * from contacts_table")
    List<Contact> getAllContacts();

    @Query("select * from contacts_table where id ==:contactId")
    Contact getContact(long contactId);


}
