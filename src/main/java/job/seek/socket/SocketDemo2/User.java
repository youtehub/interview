package job.seek.socket.SocketDemo2;

import java.io.Serializable;

/**
 * 用户类
 * @author Administrator
 *
 */
class User implements Serializable{
    private String name;
    private String pwd;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
