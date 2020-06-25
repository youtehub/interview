package job.seek.thread.creation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Yiuahm
 */
public class ExecutorsCreate {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyRunnable runnableTest = new MyRunnable();
        FutureTask<Integer> myCallable = new FutureTask<>(new MyCallable());
        MyThread myThread = new MyThread();
        for (int i = 0; i < 5; i++) {
            executorService.execute(runnableTest);
            executorService.execute(myThread);
            executorService.execute(myCallable);
        }

        System.out.println("线程任务开始执行");
        executorService.shutdown();
    }
}

class MyRunnable01 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--Runnable--run()方法执行中...");
    }
}