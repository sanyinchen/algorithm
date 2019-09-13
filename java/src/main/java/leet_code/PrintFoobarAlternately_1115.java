package leet_code;

public class PrintFoobarAlternately_1115 {
    static class FooBar {
        private int n;
        private volatile boolean fooFirst = false;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (fooFirst) {
                    // just run
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooFirst = true;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (!fooFirst) {
                    // just run
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooFirst = false;
            }
        }
    }


    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

}
