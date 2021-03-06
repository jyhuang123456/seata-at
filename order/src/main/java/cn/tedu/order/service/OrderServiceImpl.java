package cn.tedu.order.service;

import cn.tedu.order.entity.Order;
import cn.tedu.order.feign.AccountClient;
import cn.tedu.order.feign.EasyIdGeneratorClient;
import cn.tedu.order.feign.StorageClient;
import cn.tedu.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Autowired
    EasyIdGeneratorClient easyIdGeneratorClient;
    @Autowired
    private AccountClient accountClient;
    @Autowired
    private StorageClient storageClient;


    @Override
    public void create(Order order) {
        // TODO: 从全局唯一id发号器获得id，这里暂时随机产生一个 orderId
//        Long orderId = Long.valueOf(new Random().nextInt(Integer.MAX_VALUE));
        // 从全局唯一id发号器获得id
        Long orderId = easyIdGeneratorClient.nextId("order_business");
        order.setId(orderId);

        orderMapper.create(order);

        // TODO: 调用storage，修改库存
        storageClient.decrease(order.getProductId(), order.getCount());
        // TODO: 调用account，修改账户余额
        accountClient.decrease(order.getUserId(), order.getMoney());

    }
}
