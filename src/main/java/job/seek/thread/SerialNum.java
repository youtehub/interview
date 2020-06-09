package job.seek.thread;

/**
 * @author Yiuahm
 */
public class SerialNum {
    // The next serial number to be assigned
    private static int nextSerialNum = 0;
    private static ThreadLocal serialNum = new ThreadLocal() {
        @Override
        protected synchronized Object initialValue() {
            return new Integer(nextSerialNum++);
        }
    };

    public static int get() {
        return ((Integer) (serialNum.get())).intValue();
    }
}