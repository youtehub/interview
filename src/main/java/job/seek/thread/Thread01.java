package job.seek.thread;

/**
 * @author Yiuahm
 */
public class Thread01 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    class NewThread extends Thread {
        @Override
        public void run() {
            super.run();
        }

        public void main(String[] args) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }).start();
        }
    }
}

class Test{
    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
    }
}