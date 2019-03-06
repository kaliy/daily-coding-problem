package org.kaliy.dailycodingproblem;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair.
 * For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
 * <p>
 * Given this implementation of cons:
 *
 * <pre>{@code
 * def cons(a, b):
 *     def pair(f):
 *         return f(a, b)
 *     return pair
 * }</pre>
 * <p>
 * Implement car and cdr.
 */
public class FunctionalPairs {
//    I don't know python well but managed to do this in 4 LOC so the real purpose of the problem is to check how well
//    does person know lambda functions. As I implement all my solutions in Java, I've decided to implement the java
//    solution as well.
//    Here is my python implementation of the code:
//    def cons(a, b):
//        def pair(f):
//            return f(a, b)
//    return pair
//
//    def car(f):
//        return f(lambda a, b: a)
//    def cdr(f):
//        return f(lambda a, b: b)

    public static <T> Function<BiFunction<T, T, T>, T> cons(T a, T b) {
        // pair is a function that takes a function with 2 arguments and returns a result of this function
        return (f) -> f.apply(a, b);
    }

    public static <T> T car(Function<BiFunction<T, T, T>, T> cons) {
        return cons.apply((a, b) -> a);
    }

    public static <T> T cdr(Function<BiFunction<T, T, T>, T> cons) {
        return cons.apply((a, b) -> b);
    }
}
