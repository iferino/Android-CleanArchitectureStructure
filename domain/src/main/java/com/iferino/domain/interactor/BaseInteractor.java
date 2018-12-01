package com.iferino.domain.interactor;

import com.iferino.domain.executor.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public abstract class BaseInteractor {

    public static final String SUBSCRIBER_ON = "subscriberOn";
    public static final String OBSERVER_ON = "observerOn";

    protected ThreadExecutor subscriberOn;
    protected ThreadExecutor observerOn;

    private ListCompositeDisposable disposables = new ListCompositeDisposable();
    private Observable observable;

    public BaseInteractor(final ThreadExecutor subscriberOn, final ThreadExecutor observerOn) {
        this.subscriberOn = subscriberOn;
        this.observerOn = observerOn;
    }

    protected Observable withObservable(final Observable observable) {
        this.observable = observable;
        return this.observable;
    }

    public void execute(final Subscriber subscriber) {
        getSubscription(observable, subscriber);
    }

    private <T> void getSubscription(Observable<T> observable, final Subscriber<T> subscriber) {
        observable
                .subscribeOn(subscriberOn.getScheduler())
                .observeOn(observerOn.getScheduler())
                .doOnSubscribe(this::addSubscription)
                .safeSubscribe(subscriber);

    }

    private void addSubscription(Disposable disposable) {
        if (disposables.isDisposed()) {
            disposables = new ListCompositeDisposable();
        }
        if (disposable != null) {
            disposables.add(disposable);
        }
    }

    public void unsubscribe() {
        if(!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    public static class Subscriber<T> extends DisposableObserver<T> {

        @Override
        public void onNext(@NonNull T t) {
        }

        @Override
        public void onError(@NonNull Throwable e) {

        }

        @Override
        public void onComplete() {

        }

    }
}
