package com.example.profile_people_mvvm;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;

import androidx.transition.Visibility;

import com.google.errorprone.annotations.DoNotMock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.*;

import static com.google.common.base.CharMatcher.any;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class MainActivityTest {


    @Mock
    MainActivity MA;

    @Mock
    private Application mockApplicationContext;

    @Mock
    private Resources mockContextResources;
    @Mock
    private SharedPreferences mockSharedPreferences;

    @Mock
    NoteViewModel noteViewModelMock;

    @Mock
    Menu menu;

    @Before
    public void SetUp(){
        MA = new MainActivity();
        MockitoAnnotations.initMocks(this);

        // During unit testing sometimes test fails because of your methods
        // are using the app Context to retrieve resources, but during unit test the Context is null
        // so we can mock it.

        when(mockApplicationContext.getResources()).thenReturn(mockContextResources);
        when(mockApplicationContext.getSharedPreferences(anyString(), anyInt())).thenReturn(mockSharedPreferences);
        noteViewModelMock = new NoteViewModel(mockApplicationContext);

    }


    @Test
    public void checkViewmodel(){

        Note note = new Note("NAME","available",1);


        when(noteViewModelMock.insert(note)).thenReturn(true);
        MA.onActivityResult(anyInt(),anyInt(),anyObject());
        verify(noteViewModelMock).insert(note);

        assert(noteViewModelMock.insert(note));
    }
}