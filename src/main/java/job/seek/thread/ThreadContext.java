package job.seek.thread;

/**
 * @author Yiuahm
 */
public class ThreadContext {
    private String userId;
    private Long transactionId;
    private static ThreadLocal threadLocal = ThreadLocal.withInitial(() -> new ThreadContext());

    public static ThreadContext get() {
        return (ThreadContext) threadLocal.get();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}