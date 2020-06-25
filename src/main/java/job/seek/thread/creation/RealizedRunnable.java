package job.seek.thread.creation;

public class RealizedRunnable {

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        System.out.println(Thread.currentThread().getName() + " main()方法执行结束");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--Runnable--run()方法执行中...");
    }
}