package com.antonioleiva.daggerexample.app.ui.main;

import com.antonioleiva.daggerexample.app.ActivityScope;
import com.antonioleiva.daggerexample.app.AppComponent;

import dagger.Component;

/**
 * Created by Miroslaw Stanek on 17.03.15.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class
)
public interface MainComponent {
    void inject(MainActivity activity);

    MainPresenter getLoginPresenter();
}
