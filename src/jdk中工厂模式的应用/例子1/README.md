**JDK中工厂方法模式的应用：**  
抽象接口：(抽象工厂)
```java
public interface ServerSocketFactory {
// 抽象工厂提供3个创造ServerSocket的重载函数(根据不同的参数)
    public ServerSocket createSocket(int port) throws IOException, KeyStoreException,                       NoSuchAlgorithmException,
                CertificateException, UnrecoverableKeyException,
                KeyManagementException;

    public ServerSocket createSocket(int port, int backlog) throws IOException, KeyStoreException,              NoSuchAlgorithmException,
                    CertificateException, UnrecoverableKeyException,
                    KeyManagementException;

    public ServerSocket createSocket(int port, int backlog,
                                     InetAddress ifAddress) throws IOException, KeyStoreException, NoSuchAlgorithmException,
           CertificateException, UnrecoverableKeyException,
           KeyManagementException;
}

```
具体工厂类：
```java
public final class DefaultServerSocketFactory implements ServerSocketFactory {

    public ServerSocket createSocket (int port)
    throws IOException, KeyStoreException, NoSuchAlgorithmException,
           CertificateException, UnrecoverableKeyException,
           KeyManagementException {

        return (new ServerSocket(port));

    }

    public ServerSocket createSocket (int port, int backlog)
    throws IOException, KeyStoreException, NoSuchAlgorithmException,
           CertificateException, UnrecoverableKeyException,
           KeyManagementException {

        return (new ServerSocket(port, backlog));

    }

    public ServerSocket createSocket (int port, int backlog,
                                      InetAddress ifAddress)
    throws IOException, KeyStoreException, NoSuchAlgorithmException,
           CertificateException, UnrecoverableKeyException,
           KeyManagementException {

        return (new ServerSocket(port, backlog, ifAddress));

    }
}
```
客户端调用(摘录的Tomcat低版本的源码)：
```java
// 在该类方法中调用open()
public final class HttpConnector
    implements Connector, Lifecycle, Runnable {
```
```java
// 通过调用open函数，传入不同参数，就可以在工厂中获取不同的ServerSocket实例。
private ServerSocket open()
    throws IOException, KeyStoreException, NoSuchAlgorithmException,
           CertificateException, UnrecoverableKeyException,
           KeyManagementException
    {

        // Acquire the server socket factory for this Connector
        ServerSocketFactory factory = getFactory();

        // If no address is specified, open a connection on all addresses
        if (address == null) {
            log(sm.getString("httpConnector.allAddresses"));
            try {
                return (factory.createSocket(port, acceptCount));
            } catch (BindException be) {
                throw new BindException(be.getMessage() + ":" + port);
            }
        }

        // Open a server socket on the specified address
        try {
            InetAddress is = InetAddress.getByName(address);
            log(sm.getString("httpConnector.anAddress", address));
            try {
                return (factory.createSocket(port, acceptCount, is));
            } catch (BindException be) {
                throw new BindException(be.getMessage() + ":" + address +
                                        ":" + port);
            }
        } catch (Exception e) {
            log(sm.getString("httpConnector.noAddress", address));
            try {
                return (factory.createSocket(port, acceptCount));
            } catch (BindException be) {
                throw new BindException(be.getMessage() + ":" + port);
            }
        }

    }

// getFactory()分析：
/**
 * 此方法这样写的应用场景：
 *  此方法所在的类为final类型，并且在调用方创建的对象应该是static类型，然后才可以得到
 *   单例的factory实例。
 */
public ServerSocketFactory getFactory() {
    // 创建出factory的单例模式
    if (this.factory == null) {
        synchronized (this) {
            this.factory = new DefaultServerSocketFactory();
        }
    }
    return (this.factory);

}
```