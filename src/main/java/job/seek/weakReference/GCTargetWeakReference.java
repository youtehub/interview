package job.seek.weakReference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class GCTargetWeakReference extends WeakReference<GCTarget> {
    // 弱引用的ID
    public String id;

    public GCTargetWeakReference(GCTarget gcTarget,
                                 ReferenceQueue<? super GCTarget> queue) {
        super(gcTarget, queue);
        this.id = gcTarget.id;
    }

    @Override
    protected void finalize() {
        System.out.println("Finalizing GCTargetWeakReference " + id);
    }
}
