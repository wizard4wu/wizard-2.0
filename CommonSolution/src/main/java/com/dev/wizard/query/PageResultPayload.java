package com.dev.wizard.query;

public interface PageResultPayload<T> extends PageQuery<T>{
   default T retrieveNextPageToken(){
       return null;
   };
}
