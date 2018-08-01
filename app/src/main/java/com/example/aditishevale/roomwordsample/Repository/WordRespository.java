package com.example.aditishevale.roomwordsample.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.aditishevale.roomwordsample.Database.Word;
import com.example.aditishevale.roomwordsample.Database.WordDao;
import com.example.aditishevale.roomwordsample.Database.WordRoomDatabase;

import java.util.List;

public class WordRespository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;


   public WordRespository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }
   public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }
    public void insert (Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;



        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }


        @Override
        protected Void doInBackground(Word... params) {

            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
