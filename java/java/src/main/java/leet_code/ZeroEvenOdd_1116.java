package leet_code;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;


/**
 * Created by sanyinchen on 19-9-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-11
 */

class ZeroEvenOdd_1116 {

    static class ZeroEvenOdd {
        private final int maxLimit;
        private final Pair[] invokeTable;
        private static final int ZERO_INVOKE = 0;
        private static final int ODD_INVOKE = 1;
        private static final int EVEN_INVOKE = 2;

        private AtomicInteger index = new AtomicInteger(0);
        private Lock mLock = new ReentrantLock();

        private Condition zeroLock = mLock.newCondition();
        private Condition evenLock = mLock.newCondition();
        private Condition oddLock = mLock.newCondition();

        public ZeroEvenOdd(int n) {
            maxLimit = 2 * n - 1;
            invokeTable = new Pair[2 * n];
            // zero
            for (int i = 0; i < invokeTable.length; i += 2) {
                invokeTable[i] = new Pair(ZERO_INVOKE, 0);
            }
            // odd
            for (int i = 1, j = 1; i < invokeTable.length; i += 4, j += 2) {
                invokeTable[i] = new Pair(ODD_INVOKE, j);
            }
            // even
            for (int i = 3, j = 2; i < invokeTable.length; i += 4, j += 2) {
                invokeTable[i] = new Pair(EVEN_INVOKE, j);
            }

        }

        private Pair invokeValue() {
            if (index.get() > maxLimit) {
                return null;
            }

            return invokeTable.clone()[index.get()];
        }

        private void numberPrint(IntConsumer printNumber, String lbl, Condition condition, int lockType) throws InterruptedException {
            while (true) {
                try {

                    mLock.lock();
                    Pair value = invokeValue();

                    if (value == null) {
                        return;
                    }

                    if (value.f != lockType) {

                        while (value != null && value.f != lockType) {
                            condition.await();
                            value = invokeValue();
                            if (value == null) {
                                return;
                            }
                        }
                        printNumber.accept(value.s);
                        unLock(-1);
                    } else {
                        printNumber.accept(value.s);
                        unLock(-1);
                    }

                } finally {
                    mLock.unlock();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            // just zero
            numberPrint(printNumber, "zero", zeroLock, ZERO_INVOKE);
        }


        public void odd(IntConsumer printNumber) throws InterruptedException {
            numberPrint(printNumber, "odd", oddLock, ODD_INVOKE);
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            // just even
            numberPrint(printNumber, "even", evenLock, EVEN_INVOKE);

        }


        private final void unLock(int unLockType) {
            index.incrementAndGet();
            switch (unLockType) {
                case ZERO_INVOKE:
                    zeroLock.signalAll();
                    break;
                case ODD_INVOKE:
                    oddLock.signalAll();
                    break;
                case EVEN_INVOKE:
                    evenLock.signalAll();
                    break;
                default:
                    zeroLock.signalAll();
                    oddLock.signalAll();
                    evenLock.signalAll();
            }


        }

        public static class Pair {
            private int f;
            private int s;

            public Pair(int f, int s) {
                this.f = f;
                this.s = s;
            }

        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntConsumer zero = new IntConsumer() {
            @Override
            public void accept(int i) {
                if (i != 0) {
                    System.out.println(" i:" + i + " is not zero");
                } else {
                    System.out.println(i);
                }
            }
        };
        IntConsumer even = new IntConsumer() {
            @Override
            public void accept(int i) {
                if (i % 2 != 0) {
                    System.out.println(" i:" + i + " is not even");
                } else {
                    System.out.println(i);
                }
            }
        };
        IntConsumer odd = new IntConsumer() {
            @Override
            public void accept(int i) {
                if (i % 2 == 0) {
                    System.out.println(" i:" + i + " is not odd ");
                } else {
                    System.out.println(i);
                }
            }
        };

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(zero);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(odd);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(even);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread3.start();
        thread1.start();
        thread2.start();

    }
}
