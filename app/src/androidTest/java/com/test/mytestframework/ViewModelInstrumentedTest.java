package com.test.mytestframework;

import androidx.lifecycle.SavedStateHandle;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.test.mytestframework.data.Repository;
import com.test.mytestframework.viewmodel.MainViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(AndroidJUnit4.class)
public class ViewModelInstrumentedTest {

    @Test
    public void testViewModel() {
        Repository repository = Mockito.mock(Repository.class);
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        MainViewModel mainViewModel = new MainViewModel(savedStateHandle, repository);
    }
}
