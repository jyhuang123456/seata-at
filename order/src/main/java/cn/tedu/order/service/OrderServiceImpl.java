package cn.tedu.order.service;

import cn.tedu.order.entity.Order;
import cn.tedu.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void create(Order order) {
        // TODO: 从全局唯一id发号器获得id，这里暂时随机产生一个 orderId
        Long orderId = Long.valueOf(new Random().nextInt(Integer.MAX_VALUE));
        order.setId(orderId);

        orderMapper.create(order);

        // TODO: 调用storage，修改库存

        // TODO: 调用account，修改账户余额

    }
}
