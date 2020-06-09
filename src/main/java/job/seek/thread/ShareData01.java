package job.seek.thread;

/**
 * @author Yiuahm
 */
public class ShareData01 {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                new Thread(new RunnableCusToInc(shareData), "Thread " + i).start();
            } else {
                new Thread(new RunnableCusToDec(shareData), "Thread " + i).start();
            }
        }
    }

    //封装共享数据类
    static class RunnableCusToInc implements Runnable {
        //封装共享数据
        private ShareData shareData;

        public RunnableCusToInc(ShareData data) {
            this.shareData = data;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                shareData.inc();
            }
        }
    }

    //封装共享数据类
    static class RunnableCusToDec implements Runnable {
        //封装共享数据
        private ShareData shareData;

        public RunnableCusToDec(ShareData data) {
            this.shareData = data;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                shareData.dec();
            }
        }
    }

    /**
     * 共享数据类
     **/
    static class ShareData {
        private int num = 10;

        public synchronized void inc() {
            num++;
            System.out.println(Thread.currentThread().getName() + ": invoke inc method num =" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void dec() {
            num--;
            System.out.println(Thread.currentThread().getName() + ": invoke inc method num =" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}