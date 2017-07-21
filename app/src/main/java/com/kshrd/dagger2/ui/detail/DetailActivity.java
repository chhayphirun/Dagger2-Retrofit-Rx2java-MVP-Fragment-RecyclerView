package com.kshrd.dagger2.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kshrd.dagger2.R;
import com.kshrd.dagger2.api.ArticleApi;
import com.kshrd.dagger2.app.di.component.ActivityComponent;
import com.kshrd.dagger2.base.BaseActivity;
import com.kshrd.dagger2.data.PreferenceHelper;
import com.kshrd.dagger2.listener.MyclickListener;

import javax.inject.Inject;

public class DetailActivity extends BaseActivity implements MyclickListener {

    @Inject
    PreferenceHelper preferenceHelper;

    @Inject
    ArticleApi articleApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

    }

    @Override
    public void onInject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void onClicked(int position, View v) {
        Toast.makeText(this, position+" Clirck More", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetailclick(int position, View v) {
        Toast.makeText(this, position+" Click Detail", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, position+" Click Detail", Toast.LENGTH_SHORT).show();

    }
}
