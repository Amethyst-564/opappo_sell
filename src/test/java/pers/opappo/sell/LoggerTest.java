package pers.opappo.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Luvoratorrrrry on 2018/3/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
//@Data
public class LoggerTest {

    //private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {

        String name = "opappo";
        String password = "123456";
        log.debug("debug....");
        log.info("info....");
        log.info("name: " + name + ", password: " + password);
        //第二种写法在变量多的时候，拼接起来更加方便
        log.info("name: {}, password: {}", name, password);
        log.error("error....");
    }
}
