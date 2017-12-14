package com.sandeepshabd.popularmovies.presenter;

import android.content.Context;
import android.content.Intent;

import com.sandeepshabd.popularmovies.activity.ISplashInvoker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This tests Splash Presenter.
 */
@RunWith(MockitoJUnitRunner.class)
public class SplashPresenterTest {

    @Mock
    ISplashInvoker splashInvoker;

    @Mock
    Context context;

    @Test
    public void testSuccessResponse_emptyDataAfterDelay() {
        when(splashInvoker.getActivityContext()).thenReturn(context);
        SplashPresenter splashPresenter = new SplashPresenter(splashInvoker);
        splashPresenter.onSuccessResponse("");
        try {
            Thread.sleep(2000);
        }catch (Exception e){}
        verify(context, times(1)).startActivity(any(Intent.class));
        verify(splashInvoker, times(1)).finishTheActivity();
    }
}
