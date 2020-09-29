package es.codeurjc.functional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactivePlayground13 {

    public static void main(String[] args) throws InterruptedException {

        Flux<Integer> valuesWithError = Flux.just(1, 2, 3)
            .flatMap(v -> {
                if (v != 3) {
                    return Mono.just(v);
                } else {
                    return Mono.error(new IllegalArgumentException());
                }
            });

        Flux<Integer> values = valuesWithError
            .onErrorResume(IllegalArgumentException.class, e -> Flux.just(3, 2, 1));

        values.subscribe(System.out::println);

        // 1, 2, 3, 2, 1
    }

}
