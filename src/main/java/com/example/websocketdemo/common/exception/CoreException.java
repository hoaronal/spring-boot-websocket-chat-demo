package com.example.websocketdemo.common.exception;

import com.example.websocketdemo.web.support.ParamError;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CoreException extends RuntimeException {

    private HttpStatus apiStatus;
    private List<ParamError> data;

    public CoreException(HttpStatus apiStatus) {
        this.apiStatus = apiStatus;
    }

    /**
     * @param apiStatus
     * @param data
     */
    public CoreException(HttpStatus apiStatus, List<ParamError> data) {
        this(apiStatus);
        this.data = data;
    }

    public CoreException(Throwable cause) {
        super(cause);
    }

    public HttpStatus getApiStatus() {
        return apiStatus;
    }

    public List<ParamError> getData() {
        return data;
    }

}
