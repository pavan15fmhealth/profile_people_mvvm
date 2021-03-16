package com.example.profile_people_mvvm;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;


    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
//        context = application.getApplicationContext();

//        repository.getSearchNotes().observe((LifecycleOwner) this, new Observer<List<Note>>() {
//            @Override
//            public void onChanged(List<Note> notes) {
//                searchedNotes.postValue(notes);
//            }
//        });
    }
    public boolean insert(Note note){
        repository.insert(note);
        return true;
    }
    public void update(Note note){
        repository.update(note);
    }
    public void delete(Note note){
        repository.delete(note);
    }
    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }
    public LiveData<List<Note>> getAllNotes()
    {
        return allNotes;
    }
    public LiveData<List<Note>> searchNotes(String keyword){
        return repository.getSearchNotes(keyword);
    }



}