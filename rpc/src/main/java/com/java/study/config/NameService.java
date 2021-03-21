package java.com.java.study.config;

import java.net.URI;

/**
 * <Description>
 * 注册中心
 * @author hushiye
 * @since 2020-12-12 23:18
 */
public interface NameService {

    /**
     * 注册服务
     * @param serviceName 服务名称
     * @param uri 服务地址
     */
    void registerService(String serviceName, URI uri);


    /**
     * 查询服务地址
     * @param serviceName 服务名称
     * @return 服务地址
     */
    URI lookupService(String serviceName);
}
