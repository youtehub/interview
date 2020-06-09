package job.seek.thread;

/**
 * @author Yiuahm
 */
public class HibernateUtil {
//    private static Log log = LogFactory.getLog(HibernateUtil.class);
//    private static final SessionFactory sessionFactory; //定义 SessionFactory
//
//    static {
//        try {
//// 通过默认配置文件 hibernate.cfg.xml 创建 SessionFactory
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            log.error("初始化 SessionFactory 失败！", ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    //创建线程局部变量 session，用来保存 Hibernate 的 Session
//    public static final ThreadLocal session = new ThreadLocal();
//
//    /**
//     * 获取当前线程中的 Session
//     *
//     * @return Session
//     * @throws HibernateException
//     */
//    public static Session currentSession() throws HibernateException {
//        Session s = (Session) session.get();
//// 如果 Session 还没有打开，则新开一个 Session
//        if (s == null) {
//            s = sessionFactory.openSession();
//            session.set(s); //将新开的 Session 保存到线程局部变量中
//        }
//        return s;
//    }
//
//    public static void closeSession() throws HibernateException {
////获取线程局部变量，并强制转换为 Session 类型
//        Session s = (Session) session.get();
//        session.set(null);
//        if (s != null)
//            s.close();
//    }
}