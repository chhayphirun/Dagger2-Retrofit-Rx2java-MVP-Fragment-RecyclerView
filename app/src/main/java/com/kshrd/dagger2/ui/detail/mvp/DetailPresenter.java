package com.kshrd.dagger2.ui.detail.mvp;

import com.kshrd.dagger2.base.BasePresenter;
import com.kshrd.dagger2.entity.Article;
import com.kshrd.dagger2.listener.CallbackWithList;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pirang on 7/19/17.
 */

public class DetailPresenter extends BasePresenter<DetailContract.View> implements
        DetailContract.Presenter
{

    private DetailContract.Interactor interactor;

    @Inject
    public DetailPresenter(DetailInteractor interactor){
        this.interactor = interactor;
    }

    @Override
    public void findAllArticle() {
        interactor.findAllArticle(new CallbackWithList<Article>() {
            @Override
            public void onSuccess(List<Article> list) {
                getMvpView().updateRecyclerView(list);
            }

            @Override
            public void onFailed() {

            }

            @Override
            public void onError() {

            }

            @Override
            public void onComplete() {

            }
        });
    }

}
