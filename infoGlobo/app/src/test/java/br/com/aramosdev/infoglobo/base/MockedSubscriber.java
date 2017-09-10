package br.com.aramosdev.infoglobo.base;

import br.com.aramosdev.infoglobo.core.BaseContract;
import br.com.aramosdev.infoglobo.model.api.ApiSubscriber;
import io.reactivex.Flowable;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public class MockedSubscriber extends ApiSubscriber {

    boolean subscribed = false;

    protected final Flowable mObservableMock;
    private BaseContract.BaseInteraction interactionMock;

    public MockedSubscriber(Flowable observable, BaseContract.BaseInteraction interaction) {
        super(observable, interaction);
        this.mObservableMock = observable;
        this.interactionMock = interaction;

    }

    @Override
    public void execute() {
        mObservableMock.subscribe(this);
    }

    @Override
    public void onComplete() {
        super.onComplete();

        cancel();
    }
}