package dev.patika.ecommerce.core.utilies;

import dev.patika.ecommerce.core.result.ResultData;

public class ResultHelper {
    public static <T>ResultData<T>  created(T data){
        return new ResultData(true , Msg.CREATED, "201" , data);
    }  // her created olıuştuğunda bu mesajları goster

    public static <T> ResultData<T> validateError(T data){
       return new ResultData<>(false, Msg.VALIDATE_ERROR,"404",data);
    }
}
