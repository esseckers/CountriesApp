package com.countrytable.controller.error;


import com.countrytable.remote.model.Fail;

public interface ErrorHandler {

    void manageLoadDialog(boolean show);

    void handleFail(Fail fail);

    void handleError(String error);

    void manageLoadDialog(boolean show, String message);

    void addListener(ErrorHandlerListener errorHandlerListener);

    void removeListener(ErrorHandlerListener errorHandlerListener);

}
