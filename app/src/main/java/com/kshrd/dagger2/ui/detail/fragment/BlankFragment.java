package com.kshrd.dagger2.ui.detail.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kshrd.dagger2.R;
import com.kshrd.dagger2.adapter.ArticleAdapter;
import com.kshrd.dagger2.api.ArticleApi;
import com.kshrd.dagger2.base.BaseActivity;
import com.kshrd.dagger2.base.BaseFragment;
import com.kshrd.dagger2.data.PreferenceHelper;
import com.kshrd.dagger2.entity.Article;
import com.kshrd.dagger2.ui.detail.mvp.DetailContract;
import com.kshrd.dagger2.ui.detail.mvp.DetailPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment implements DetailContract.View {

    @Inject
    PreferenceHelper preferenceHelper;
    @Inject
    ArticleApi articleApi;
    @Inject
    DetailPresenter detailPresenter;
    RecyclerView recyclerViewArticle;
    ArticleAdapter articleAdapter;
    private List<Article> articleList;
    private ProgressDialog progressDialog;
    AlertDialog.Builder showInternetConnectionDialog;



    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        setUnbinder(ButterKnife.bind(this, view));
        return view;
    }

    @Override
    public void onInject(BaseActivity activity) {
        activity.getActivityComponent().inject(this);
    }

    @Override
    public void setUp(View view, Bundle savedInstanceState) {
        Toast.makeText(getBaseActivity(), preferenceHelper.getUserId() + "", Toast.LENGTH_SHORT).show();
        setupListView();
        articleList=new ArrayList<>();
        recyclerViewArticle= (RecyclerView) view.findViewById(R.id.rvArticle);
        recyclerViewArticle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        articleAdapter=new ArticleAdapter(getActivity(),articleList);
        recyclerViewArticle.setAdapter(articleAdapter);

        detailPresenter.onAttach(this);
        detailPresenter.findAllArticle();

    }

    private void setupListView() {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {


    }

    @Override
    public void updateRecyclerView(List<Article> articleList) {
    this.articleList.addAll(articleList);
        articleAdapter.notifyDataSetChanged();
    }
}
