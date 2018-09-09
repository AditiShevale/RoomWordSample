package com.example.aditishevale.roomwordsample.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.aditishevale.roomwordsample.Database.Word;
import com.example.aditishevale.roomwordsample.Repository.WordRespository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRespository mRepository;

    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {

        super(application);

        mRepository = new WordRespository(application);

        mAllWords = mRepository.getAllWords();
    }

   public LiveData<List<Word>> getAllWords() {

        return mAllWords;

    }

    public void insert(Word word) {

        mRepository.insert(word);
    }
}
