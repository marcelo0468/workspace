package br.com.digitalhouse.marveldesafioapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.marveldesafioapplication.model.Result;
import br.com.digitalhouse.marveldesafioapplication.repository.MarvelRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MarvelViewModel extends AndroidViewModel {

    private MutableLiveData<List<Result>> marvelLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MarvelRepository repository = new MarvelRepository();


    public MarvelViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<Result>> getMarvelLiveData() {
        return marvelLiveData;
    }

    public LiveData<Boolean> getLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getErrorLiveData() {
        return errorLiveData;
    }



    public void buscarMarvel() {

        /*if (AppUtil.isNetworkConnected(getApplication().getApplicationContext())){

        }*/

        disposable.add(repository.obterListaMarvelInternet()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(marvelResposta -> {
                            marvelLiveData.setValue(marvelResposta.getData().getResults());
                        }, throwable -> {
                            errorLiveData.setValue(throwable);
                        })
        );
    }

//    @Override
//    protected void onCleared() {
//        super.onCleared();
//        disposable.clear();
//    }


}
