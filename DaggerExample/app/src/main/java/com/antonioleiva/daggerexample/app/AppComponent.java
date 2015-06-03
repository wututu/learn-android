package com.antonioleiva.daggerexample.app;

import com.antonioleiva.daggerexample.app.domain.AnalyticsManager;
import com.antonioleiva.daggerexample.app.domain.DomainModule;
import com.antonioleiva.daggerexample.app.interactors.FindItemsInteractor;
import com.antonioleiva.daggerexample.app.interactors.InteractorsModule;
import com.antonioleiva.daggerexample.app.interactors.LoginInteractor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Miroslaw Stanek on 17.03.15.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                DomainModule.class,
                InteractorsModule.class
        }
)
public interface AppComponent {
    void inject(App app);

    AnalyticsManager getAnalyticsManager();
    LoginInteractor getLoginInteractor();
    FindItemsInteractor getFindItemsInteractor();
}
