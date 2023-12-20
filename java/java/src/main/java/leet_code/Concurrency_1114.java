package leet_code;


/**
 * Created by sanyinchen on 19-9-10.
 * <p>
 * from https://leetcode-cn.com/problems/print-in-order/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-10
 */

class Concurrency_1114 {
    public static class Foo {

        private volatile Runnable secondPending = null;
        private volatile Runnable thirdPending = null;
        private volatile boolean firstStared = false;
        private volatile boolean secondStarted = false;

        public Foo() {

        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {
            // System.out.println("first " + "first:" + firstStared + " second:" + secondStarted);

            printFirst.run();
            firstStared = true;
            if (secondPending != null) {
                secondPending.run();
                secondStarted = true;
                if (thirdPending != null) {
                    thirdPending.run();
                }
            }
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {
            //  System.out.println("second " + "first:" + firstStared + " second:" + secondStarted);

            if (firstStared) {
                printSecond.run();
                secondStarted = true;
                secondPending = null;
                if (thirdPending != null) {
                    thirdPending.run();
                }
            } else {
                secondPending = new Runnable() {
                    @Override
                    public void run() {
                        printSecond.run();
                    }
                };
            }

        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            //  System.out.println("third " + "first:" + firstStared + " second:" + secondStarted);
            if (secondStarted) {
                printThird.run();
                // thirdPending = null;
            } else {
                thirdPending = new Runnable() {
                    @Override
                    public void run() {
                        printThird.run();
                    }
                };
            }
        }


    }


    public static void main(String[] args) {
        Foo foo = new Foo();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("[one]");
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
                    foo.second(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("[two]");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("[three]");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);
        Thread[] threads = new Thread[]{thread1, thread2, thread3};
        int[] startOrder = new int[]{2, 1, 3};
        for (int i = 0; i < 3; i++) {
            threads[startOrder[i] - 1].start();
        }

    }

}
