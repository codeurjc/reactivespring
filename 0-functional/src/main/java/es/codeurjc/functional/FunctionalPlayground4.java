package es.codeurjc.functional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

public class FunctionalPlayground4 {

    public static void main(String[] args) {

        Stream<String> nums = Stream.of("one","two","three");
        nums.forEach(value -> System.out.println(value));

        Flux<String> nums2 = Flux.just("one","two","three");
        nums2.subscribe(value -> System.out.println(value));

        Flux<Integer> nums3 = Flux.just(4,5,6,7,8);
        nums3.subscribe(System.out::println);

        Mono<String> name = Mono.just("Pepe");
        name.subscribe(System.out::println);

    }


}
