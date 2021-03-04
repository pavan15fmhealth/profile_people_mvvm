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
    private MutableLiveData<List<Note>> searchedNotes;

    Context context;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
        context = application.getApplicationContext();

        repository.getSearchNotes().observe((LifecycleOwner) context, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                searchedNotes.postValue(notes);
            }
        });
    }
    public void insert(Note note){
        repository.insert(note);
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
    public void searchNotes(String keyword){
        repository.searchNotes(keyword);

    }

    public LiveData<List<Note>> getSearchNotes()
    {
        return searchedNotes;
    }



}
