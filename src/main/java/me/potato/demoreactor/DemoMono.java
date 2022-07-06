package me.potato.demoreactor;

import me.potato.demoreactor.courseutil.Util;
import reactor.core.publisher.Mono;

public class DemoMono {

    public static void main(String[] args) {
        var mono01 = Mono.just(getGreeting());
        mono01.subscribe(Util.subscriber());
        mono01.subscribe(Util.subscriber());

        System.out.println("");

        var mono02 = Mono.fromSupplier(() -> getGreeting());
        System.out.println("Mono02 Created");
        mono02.subscribe(Util.subscriber());
        mono02.subscribe(Util.subscriber());

        Util.sleepSeconds(2);
    }

    // get greeting
private static String getGreeting() {
        Util.sleepSeconds(1);
        System.out.println("Generating greeting.." + Thread.currentThread().getName());
        return "Hello world!";
    }
}