package com.pyh.ribbonrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRibbonRule extends AbstractLoadBalancerRule {

    private AtomicInteger visitCounter=new AtomicInteger(0);
    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }

    private Server choose(ILoadBalancer loadBalancer, Object key) {

        if (loadBalancer==null)
        {
            System.out.println("负载均衡器为空哦！");
            return null;
        }

        List<Server> upList=loadBalancer.getReachableServers();
        List<Server> allList=loadBalancer.getAllServers();

        if (upList.size()==0||allList.size()==0)
        {
            System.out.println("没有一个可用的服务！");
            return null;
        }

        Server server=null;
        while (server==null)
        {
            server= upList.get(getServerIndex(upList.size()));
            if (server.isAlive())
            {
                System.out.printf("这是%d次调用此接口   此次轮到的服务的端口为：%s\n",visitCounter.get(),
                        server.getHostPort());

                return server;
            }
            else
            {
                System.out.println("完蛋了，这个服务是死的！");
                server=null;
            }
        }
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    private int getServerIndex(int serversCounter)
    {
        int current=visitCounter.get()%(3*serversCounter);
        int index=(current+1)/3;
        visitCounter.getAndIncrement();
        if (index>=serversCounter)
        {
            index=0;
            return 0;
        }
        return index;
    }
}
