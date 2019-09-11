package leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


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

        public H2O() {

        }

        private volatile AtomicInteger HNumber = new AtomicInteger(0);
        private volatile AtomicInteger ONumber = new AtomicInteger(0);


        private final ReentrantLock mLock = new ReentrantLock();
        private final Condition hGenLock = mLock.newCondition();
        private final Condition oGenLock = mLock.newCondition();


        private boolean hGenAble() {
            return HNumber.get() < 2;
        }

        private boolean oGenAble() {
            return ONumber.get() < 1;
        }


        private boolean h2oGenned() {
            if (!hGenAble() && !oGenAble()) {
                try {
                    mLock.lock();
                    HNumber.set(0);
                    hGenLock.signalAll();

                    ONumber.set(0);
                    oGenLock.signalAll();
                } finally {
                    if (mLock.isHeldByCurrentThread()) {
                        mLock.unlock();
                    }
                }
                return true;
            }
            return false;
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            try {
                mLock.lock();
                if (!hGenAble()) {
                    while (!hGenAble()) {
                        hGenLock.await();
                    }

                }
                releaseHydrogen.run();
                HNumber.incrementAndGet();
            } finally {

                if (mLock.isHeldByCurrentThread()) {
                    mLock.unlock();
                }
            }
            h2oGenned();

        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            try {
                mLock.lock();
                if (!oGenAble()) {
                    while (!oGenAble()) {
                        oGenLock.await();
                    }
                }

                releaseOxygen.run();
                ONumber.incrementAndGet();
            } finally {
                if (mLock.isHeldByCurrentThread()) {
                    mLock.unlock();
                }
            }
            h2oGenned();
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
