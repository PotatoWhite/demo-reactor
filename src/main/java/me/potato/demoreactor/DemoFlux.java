package me.potato.demoreactor;

import me.potato.demoreactor.courseutil.Util;
import reactor.core.publisher.Flux;

public class DemoFlux {
    public static void main(String[] args) {
        // create를 사용하면 실제 subscriber의 요청량과 관계없이 Emitting 될 수 있다.
        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                int random = getRandomNumber();
                System.out.println("Emitting");

                sink.next(random);

                if (random > 8) {
                    sink.error(new RuntimeException("Hello Error"));
                }
            }

            sink.complete();
        }).take(3).subscribe(Util.subscriber());


        // generter를 사용하면 실제 subscriber의 요청량 만큼 Emitting 될 수 있다.
        var aFlux = new HandleFlux();
        aFlux.getAFlux()
                .take(10)
                .subscribe(Util.subscriber());
    }


    // random number 생성
    private static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
