package leet_code;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

import sun.misc.Lock;
import sun.misc.Unsafe;

/**
 * Created b sanyinchen on 19-9-10.
 * <p>
 * from https://leetcode-cn.com/problems/building-h2o/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-10
 */

class Concurrency_1117 {
    public static class H2O {

        private static final Object ATOMIC_LOCK = new Object();

        public H2O() {

        }

        private volatile AtomicInteger HNumber = new AtomicInteger(0);
        private volatile AtomicInteger ONumber = new AtomicInteger(0);

        private final Object hGenLock = new Object();
        private final Object oGenLock = new Object();
        private final Object wholeGen = new Object();


        private boolean hGenAble() {
            return HNumber.get() < 2;
        }

        private boolean oGenAble() {
            return ONumber.get() < 1;
        }


        private boolean h2oGenned() {
            if (!hGenAble() && !oGenAble()) {

                synchronized (hGenLock) {
                    HNumber.clear();
                    hGenLock.notifyAll();
                }
                synchronized (oGenLock) {
                    ONumber.clear();
                    oGenLock.notifyAll();
                }
                synchronized (wholeGen) {
                    wholeGen.notifyAll();
                }
                return true;
            }
            return false;
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            synchronized (hGenLock) {
                if (!hGenAble()) {
                    while (!hGenAble()) {
                        hGenLock.wait();
                    }

                }
                releaseHydrogen.run();
                HNumber.incrementAndGet();
            }
            if (!h2oGenned() && !hGenAble()) {
                synchronized (wholeGen) {
                    while (!h2oGenned() && !hGenAble()) {
                        wholeGen.wait();
                    }
                }
            }

        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            synchronized (oGenLock) {
                if (!oGenAble()) {
                    while (!oGenAble()) {
                        oGenLock.wait();
                    }
                }

                releaseOxygen.run();
                ONumber.incrementAndGet();

            }

            if (!h2oGenned() && !hGenAble()) {
                synchronized (wholeGen) {
                    while (!h2oGenned() && !hGenAble()) {
                        wholeGen.wait();
                    }
                }
            }
        }


        public class AtomicInteger {

            private volatile int value;


            public AtomicInteger(int var1) {
                this.value = var1;
            }

            public final int get() {
                return this.value;
            }

            public final void clear() {
                synchronized (ATOMIC_LOCK) {
                    this.value = 0;
                }
            }


            public final int incrementAndGet() {
                synchronized (ATOMIC_LOCK) {
                    value++;
                    return value;
                }

            }


        }

    }

    public static final H2O foo = new H2O();

    public static void main(String[] args) {

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    foo.hydrogen(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("[H]");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {

                try {
                    foo.oxygen(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("[O]");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        StringBuilder input = new StringBuilder();
        List<Thread> list = new ArrayList<>();
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable1));
        input.append("[H]").append("[O]").append("[H]");

        list.add(new Thread(runnable2));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        input.append("[O]").append("[H]").append("[H]");

        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable2));
        input.append("[H]").append("[H]").append("[O]");

        list.add(new Thread(runnable1));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable1));
        input.append("[H]").append("[O]").append("[H]");

        list.add(new Thread(runnable2));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        input.append("[O]").append("[H]").append("[H]");

        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable2));
        input.append("[H]").append("[H]").append("[O]");

        list.add(new Thread(runnable1));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable1));
        input.append("[H]").append("[O]").append("[H]");

        list.add(new Thread(runnable2));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        input.append("[O]").append("[H]").append("[H]");

        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable2));
        input.append("[H]").append("[H]").append("[O]");


        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        input.append("[H]").append("[H]").append("[H]").append("[H]");
        input.append("[H]").append("[H]").append("[H]").append("[H]");
        input.append("[H]").append("[H]").append("[H]").append("[H]");
        input.append("[H]").append("[H]").append("[H]").append("[H]");
        input.append("[H]").append("[H]").append("[H]").append("[H]");
        input.append("[H]").append("[H]").append("[H]").append("[H]");

        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        input.append("[O]").append("[O]");
        input.append("[O]").append("[O]");
        input.append("[O]").append("[O]");
        input.append("[O]").append("[O]");
        input.append("[O]").append("[O]");
        input.append("[O]").append("[O]");

        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        list.add(new Thread(runnable2));
        input.append("[O]").append("[O]");
        input.append("[O]").append("[O]");
        input.append("[O]").append("[O]");
        input.append("[O]").append("[O]");
        input.append("[O]").append("[O]");
        input.append("[O]").append("[O]");

        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        list.add(new Thread(runnable1));
        input.append("[H]").append("[H]").append("[H]").append("[H]");
        input.append("[H]").append("[H]").append("[H]").append("[H]");
        input.append("[H]").append("[H]").append("[H]").append("[H]");
        input.append("[H]").append("[H]").append("[H]").append("[H]");
        input.append("[H]").append("[H]").append("[H]").append("[H]");
        input.append("[H]").append("[H]").append("[H]").append("[H]");

        System.out.println(input);
        for (int i = 0; i <= list.size() - 1; i++) {
            list.get(i).start();
        }

    }

}
