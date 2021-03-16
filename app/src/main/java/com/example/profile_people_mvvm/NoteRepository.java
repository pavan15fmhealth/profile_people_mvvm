package com.example.profile_people_mvvm;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;
    private static MutableLiveData<List<Note>> searchedNotes;


    public NoteRepository(Application application){
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void  insert(Note note){
        new  InsertNoteAsyncTask(noteDao).execute(note);

    }

    public void update(Note note){
        new UpdateNoteAsyncTask(noteDao).execute(note);

    }
    public void delete(Note note){
        new DeleteNoteAsyncTask(noteDao).execute(note);

    }

    public void deleteAllNotes(){
        new DeleteAllNotesAsyncTask(noteDao).execute();

    }
    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }

//    public void searchNotes(String keyword){
//        String[] params = { keyword };
//         new searchNotesAsyncTask(noteDao).execute(params);
//    }

    public LiveData<List<Note>> getSearchNotes(String keyWord){
        return noteDao.searchNotes(keyWord);
    }




    private  static class InsertNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private  NoteDao noteDao;

        private InsertNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    private  static class UpdateNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private  NoteDao noteDao;

        private UpdateNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }

    private  static class DeleteNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private  NoteDao noteDao;

        private DeleteNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }
    private  static class DeleteAllNotesAsyncTask extends AsyncTask<Void,Void,Void>{
        private  NoteDao noteDao;

        private DeleteAllNotesAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }

    public int whilsty(int a){
        return a;
    }


//    private class searchNotesAsyncTask extends AsyncTask<String,Void,Void>{
//        private  NoteDao noteDao;
//
//        private searchNotesAsyncTask(NoteDao noteDao){
//            this.noteDao = noteDao;
//        }
//
//
//        @Override
//        protected Void doInBackground(String... strings) {
//             searchedNotes.postValue(noteDao.searchNotes(strings[0]));
//             return  null;
//        }
//    }


}