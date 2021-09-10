package main;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Flux.just("red", "white", "blue")
                .log()
                .flatMap(value ->
                                Mono.just(value.toUpperCase())
                                        .subscribeOn(Schedulers.parallel()),
                        2)
                .subscribe(value -> {
                    System.out.println("Consumed: " + value);
                });

        Thread.sleep(3333);
//        Flux.just("red", "white", "blue")
//                .log()
//                .map(String::toUpperCase)
//                .subscribe(null, 2);

        System.out.println("-------------------------------------------------------------");
        Flux.just("red", "white", "blue")
                .log()
                .map(value -> value.toUpperCase())
                .subscribe(v->System.out.println("Consumed: " + v)
                );

//        List<Integer> elements = new ArrayList<>();
//        List<Integer> elements1 = new ArrayList<>();
//        BlockingQueue<Integer > queue = new LinkedBlockingDeque<>();
//
//        queue.add(66);
//        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
//                    while(true) {
//                        try {
//                            fluxSink.next(queue.take());
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                })
//                .publish();
//
//        queue.add(77);
//        publish.subscribe(item->elements.add((Integer)item));
//        publish.subscribe(item->elements1.add((Integer)item));
//        publish.connect();
//
//        queue.add(88);
//        Thread.sleep(1000);
//        System.out.println(elements);
//        System.out.println(elements1);
        Thread.sleep(8000);
    }
}
