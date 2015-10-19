package com.countrytable.remote.handler;

import com.countrytable.remote.IRemoteServiceCallback;
import com.countrytable.remote.model.JSONRestResponse;
import com.countrytable.remote.service.AbstractRestService;

public abstract class AbstractSimpleRemoteHandler<T> extends AbstractRemoteHandler<T> {

    public AbstractSimpleRemoteHandler(IRemoteServiceCallback<T> callback) {
        super(callback);
    }

    public <V> JSONRestResponse<V> executeService(AbstractRestService<V> abstractRPCService) {
        abstractRPCService.run();
        return abstractRPCService.getServiceResponseObject();
    }
}
