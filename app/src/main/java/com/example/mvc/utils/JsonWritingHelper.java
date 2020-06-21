package com.example.mvc.utils;

public class JsonWritingHelper<CLASS_TYPE> {
    interface SaveListener{
        void jsonWriteSuccess();
        void jsonWriteFailed(String  error);
    }
    interface ReadListener{
        void jsonReadSuccess();
        void jsonReadFailed(String  error);
    }
    public void writeToJson(CLASS_TYPE model){
    }
    public CLASS_TYPE readFromJson(){
        return null;
    }
}
