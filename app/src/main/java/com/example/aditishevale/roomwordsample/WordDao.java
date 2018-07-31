package com.example.aditishevale.roomwordsample;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;


@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

      @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    List<Word> getAllWords();
}
