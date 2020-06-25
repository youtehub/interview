package job.seek.thread.creation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class RealizedCallable {

    public static void main(String[] args) throws Exception {
        FutureTask<Integer> myCallable = new FutureTask<>(new MyCallable());
        Thread MyCallableThread = new Thread(myCallable);
        MyCallableThread.setPriority(Thread.MAX_PRIORITY);
        MyCallableThread.start();
        Integer integer = myCallable.get();

        FutureTask<Integer> myRunnable = new FutureTask(new MyRunnable(),1);
        Thread myRunnableThread = new Thread(myRunnable);
        myRunnableThread.setPriority(Thread.MAX_PRIORITY);
        myRunnableThread.start();
        Integer integer1 = myRunnable.get();

        System.out.println(Thread.currentThread().getName() + " main()方法执行结束");
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "--Callable--run()方法执行中...");
        return 1;
    }
}