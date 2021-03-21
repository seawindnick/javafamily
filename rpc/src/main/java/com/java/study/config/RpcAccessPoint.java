package java.com.java.study.config;

import java.io.Closeable;
import java.net.URI;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-12-12 23:11
 */
public interface RpcAccessPoint extends Closeable {


    /**
     * 客户端获取远程服务的引用
     * @param uri 远程服务地址
     * @param serviceClass 远程服务类接口
     * @param <T> 服务接口类型
     * @return 远程服务引用
     */
    <T> T getRemoteService(URI uri,Class<T> serviceClass);


    /**
     * 服务端注册服务的实现实例
     * @param service 实现实例
     * @param serviceClass 服务的接口类class
     * @param <T> 服务接口类型
     * @return 服务地址
     */
    <T> URI addServiceProvider(T service,Class<T> serviceClass);


    /**
     * 服务端启动RPC框架，监听接口，开始提供远程服务
     * @return 服务实例，用于停止的时候安全关闭服务
     * @throws Exception
     */
    Closeable startServer() throws Exception;

}
