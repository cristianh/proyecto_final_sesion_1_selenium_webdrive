package io.demo.evershop.utils;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();

    public static int generateInt(int bound) {
        return random.nextInt(bound); // genera entre 0 (inclusive) y bound (exclusivo)
    }
}
