package com.countrytable.remote;

import com.countrytable.remote.model.Fail;

/**
 * Interface for callback async operations
 *
 * @param <E>
 */
public interface IRemoteServiceCallback<E> {
    /**
     * Start remote call process
     */
    void onStartTask();

    void onSuccess(E result);

    void onFailure(Fail fail);

    /**
     * End remote call process, call in any case after onStart,onSuccess,onFailure,onServerError
     */
    void onFinishTask();
}
