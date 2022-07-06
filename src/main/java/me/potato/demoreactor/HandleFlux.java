package me.potato.demoreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class HandleFlux {

    public Flux<Integer> getAFlux() {
        return Flux.generate(handleStart(0), handleProcess(), handleComplete());
    }

    private Consumer<Integer> handleComplete() {
        return count -> {
            System.out.println(count + " has Complete");
        };
    }

    private BiFunction<Integer, SynchronousSink<Integer>, Integer> handleProcess() {
        return (count, sink) -> {
            System.out.println("Processing " + count);
            sink.next(getRandomNumber());
            return count + 1;
        };
    }

    private Integer getRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private Callable<Integer> handleStart(Integer count) {
        System.out.println("Start");
        return () -> count;
    }

}
