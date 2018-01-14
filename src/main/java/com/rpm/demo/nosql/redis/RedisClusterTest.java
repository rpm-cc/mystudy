package com.rpm.demo.nosql.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by renpiming on 2017/12/17.
 */
public class RedisClusterTest {


    public JedisCluster getJC() {

        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7379));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7379));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7379));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);

        return jc;
    }
}
