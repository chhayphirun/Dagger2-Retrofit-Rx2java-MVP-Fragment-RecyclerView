package com.kshrd.dagger2.ui.detail.mvp;

import com.kshrd.dagger2.api.ArticleApi;
import com.kshrd.dagger2.entity.Article;
import com.kshrd.dagger2.entity.response.ArticleResponse;
import com.kshrd.dagger2.listener.CallbackWithList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by pirang on 7/19/17.
 */

public class DetailInteractor implements DetailContract.Interactor {

    private ArticleApi articleApi;
    private CompositeDisposable compositeDisposable;

    @Inject
    public DetailInteractor(
            ArticleApi articleApi,
            CompositeDisposable compositeDisposable
    ){
        this.articleApi = articleApi;
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void findAllArticle(final CallbackWithList<Article> callback) {
        compositeDisposable.add(
            articleApi.findAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Response<ArticleResponse>>() {
                    @Override
                    public void onSuccess(Response<ArticleResponse> res) {
                        if (res.isSuccessful()){
                            callback.onSuccess(res.body().getArticleList());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                })
        );
    }

}
