package com.test.mytestframework.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.test.mytestframework.data.Entity;
import com.test.mytestframework.data.Repository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private SavedStateHandle mHandle;
    private Repository mRepository;
    private MutableLiveData<Entity> mEntityMutableLiveData = new MutableLiveData<>();
    private ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    @Inject
    public MainViewModel(SavedStateHandle handle, Repository repository) {
        mHandle = handle;
        mRepository = repository;
    }

    public LiveData<Entity> getEntity(){
        return mEntityMutableLiveData;
    }

    public void fetch(String id) {
        mExecutorService.execute(() -> {
            Entity entity = mRepository.getEntity(id);
            mEntityMutableLiveData.postValue(entity);
        });
    }
}