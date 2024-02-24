package dev.kutuphane.kutuphane.core.result;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;

@Getter
public class ResultData<T> extends Result{

    private T data;

    public ResultData(boolean status, String message, String code,T data) {
        super(status, message, code);
        this.data = data;
    }

}
