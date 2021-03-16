package com.example.profile_people_mvvm;

import android.app.Application;

import androidx.lifecycle.LiveData;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NoteViewModelTest {

    @Mock
    Application application = new Application();

    @Mock
    NoteRepository noteRepositoryMock = new NoteRepository(application);

//    @Mock
//    NoteDao notedaomock = new NoteDao();

//    @Test
//    public void  funnn(){
//        Note note = new Note("NAME","available",1);
//
//        when(notedaomock.insert(note)).thenReturn();
//    }


    @Test()
    public void checkInsertFunctionality(){

        Note note = new Note("NAME","available",1);

        when(noteRepositoryMock.whilsty(1)).thenReturn(1);
        assertEquals(1,noteRepositoryMock.whilsty(1));
        verify(noteRepositoryMock).whilsty(1);


    }




}