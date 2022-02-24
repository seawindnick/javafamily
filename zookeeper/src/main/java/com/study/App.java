package com.study;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static final String ADDRESS = "10.26.15.26:2183";

    public static void main(String[] args) throws Exception {


        List<ACL> acls = new ArrayList<ACL>(2);
        Id id1 = new Id("digest", DigestAuthenticationProvider.generateDigest("admin:jiadianxia"));
        ACL acl1 = new ACL(ZooDefs.Perms.ALL, id1);

        Id id2 = new Id("digest", DigestAuthenticationProvider.generateDigest("guest:jiadianxia"));
        ACL acl2 = new ACL(ZooDefs.Perms.READ, id2);

//        ZooKeeper zooKeeper = new ZooKeeper();
        ZooKeeper zooKeeper = new ZooKeeper(ADDRESS, 5000, null);
        zooKeeper.addAuthInfo("digest", getDigestUserPwd("jiadianxia:jiadianxia").getBytes());
        List<String> list = zooKeeper.getChildren("/peizhi/17", null);
//

        for (String s : list) {
//
//
//            try {
//                zooKeeper.delete("/peizhi/17/"+s,-1);
//            }catch (Exception ex){
//
//            }
            List<String> temp = zooKeeper.getChildren("/peizhi/17/" + s, null);

            for (String s1 : temp) {
                try {
                    zooKeeper.delete("/peizhi/17/" + s + "/" + s1, -1);
                }catch (Exception ex) {
                }
                }
//
//            }



        }
    }

    public static String getDigestUserPwd(String id) throws Exception {
        // 加密明文密码
        return DigestAuthenticationProvider.generateDigest(id);
    }

}
