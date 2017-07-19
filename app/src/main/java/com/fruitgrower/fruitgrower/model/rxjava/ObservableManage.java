package com.fruitgrower.fruitgrower.model.rxjava;

import com.fruitgrower.fruitgrower.model.bmob.Message;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Function;

/**
 * Created by lgq on 2017/7/18.
 */

public class ObservableManage {

    public static Flowable messageLists(List<Message> list) {
        return Flowable.just(list)
                .flatMap(new Function<List<Message>, Publisher<?>>() {
                    @Override
                    public Publisher<?> apply(List<Message> messages) throws Exception {
                        return Flowable.fromIterable(messages);
                    }
                });

    }

    public static Observable messageObserable(final List<Message> list) {
        return new Observable() {
            @Override
            protected void subscribeActual(Observer observer) {
                observer.onNext(list);
            }
        };
    }

}
