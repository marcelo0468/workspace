package br.com.digitalhouse.filmesmvvp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.filmesmvvp.model.Filme;
import br.com.digitalhouse.filmesmvvp.repository.FilmesRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FilmesViewModel extends AndroidViewModel {

    private MutableLiveData<List<Filme>> filmesLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    //dependece injection (para ver depois sobre injeção de dependência)
    private FilmesRepository repository = new FilmesRepository();

    public FilmesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Filme>> getfilmesLiveData() {
        return filmesLiveData;
    }

    public LiveData<Boolean> getLoadingLiveData(){
        return loadingLiveData;
    }

    public LiveData<Throwable> getErrorLiveData(){
        return errorLiveData;
    }

    public void buscarfilmes() {

        disposable.add(
                repository.obterListafilmesDoArquivo(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> {
                            loadingLiveData.setValue(true);
                        })
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(filmesResposta -> {
                            filmesLiveData.setValue(filmesResposta.getFilmes());
                        }, throwable -> {
                            errorLiveData.setValue(throwable);
                        })
        );

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}