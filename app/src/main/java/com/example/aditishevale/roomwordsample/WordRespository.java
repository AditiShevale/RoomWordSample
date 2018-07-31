package com.example.aditishevale.roomwordsample;

import android.arch.lifecycle.LiveData;

import java.util.List;

public class WordRespository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;
}
