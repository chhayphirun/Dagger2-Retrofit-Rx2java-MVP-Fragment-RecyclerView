package com.kshrd.dagger2.ui.detail.mvp;

import com.kshrd.dagger2.base.BaseMvpPresenter;
import com.kshrd.dagger2.base.BaseMvpView;
import com.kshrd.dagger2.entity.Article;
import com.kshrd.dagger2.listener.CallbackWithList;

import java.util.List;

/**
 * Created by pirang on 7/19/17.
 */

public interface DetailContract {

    interface View extends BaseMvpView {
        void updateRecyclerView(List<Article> articleList);
    }

    interface Presenter extends BaseMvpPresenter<DetailContract.View> {
        void findAllArticle();
    }

    interface Interactor {
        void findAllArticle(CallbackWithList<Article> callback);
    }

}
