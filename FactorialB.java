package models;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
    same as FactorialA, I think it is the most efficient method
 */
public class FactorialB {
    public final static int MAX_CACHE_SIZE = 512;
    private static boolean cacheIsEnabled = true;

    private static Map<Short, BigInteger> map = new HashMap<>();
    private static Map<Short, BigInteger> cache = Collections.synchronizedMap(map);

    public static BigInteger calculate(short n, boolean cached) {
        if (cached) cacheIsEnabled = true;
        else cacheIsEnabled = false;

        return calculate(n);
    }

    public static  BigInteger calculate(short n) {

        if (n < 1) return new BigInteger("0");
        else if (n < 2) return new BigInteger("1");

        BigInteger result = new BigInteger("1");

        short start = 2;
        if (cacheIsEnabled) {
            start = cache.keySet().stream()
                    .sorted(Comparator.reverseOrder())
                    .filter(i -> i <= n)
                    .findFirst()
                    .orElse((short) 2);

        }
        if (start != 2 && start <= n) {

            result = cache.get(start);
            System.out.println("could hit the cache for: " + start + "...start from the cache value... " +
                    "cache size is" + cache.size());
        }
        for (short i = start; i <= n; i++) {
            result = result.multiply(new BigInteger(i + ""));
            if (cacheIsEnabled && i > n / 2 && cache.size() < MAX_CACHE_SIZE)
                cache.put(i, result);
        }
        return result;

    }
    public static void main(String[] args) {
        Long start = System.nanoTime();
        System.out.println(calculate((short)35, false));
        long finish = System.nanoTime();
        System.out.println("Time spent for 35 " + (finish - start) + "nano Seconds");
        cacheIsEnabled = true;
        System.out.println(calculate((short)5));
        System.out.println(calculate((short)10));
        System.out.println(calculate((short)15));
        System.out.println(calculate((short)25));
        System.out.println(calculate((short)35));
    }
}
