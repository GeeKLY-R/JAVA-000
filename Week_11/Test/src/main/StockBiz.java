package main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class StockBiz {
public int decrement(int amount){
    amount -= 1;
    log.info("库存减一，操作线程：{}，剩余：{}",Thread.currentThread().getName(),amount);
    return  amount;
}
}