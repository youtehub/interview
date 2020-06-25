package job.seek.thread.creation;

public class ExtendsThread {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        System.out.println(Thread.currentThread().getName() + " main()方法执行结束");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--Thread--run()方法正在执行...");
    }
}
