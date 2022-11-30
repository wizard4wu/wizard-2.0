package com.dev.wizard;

import com.dev.wizard.many.implement.ManyImplementsStarter;
import com.dev.wizard.many.implement.service.People;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManyImplementsStarter.class) //这个注解只会在测试包下面有效
public class ManyImplementsTest {

    @Autowired
    private List<People> peopleList;

    @Autowired
    private Map<String, People> map;

    @Test
    public void testServiceList(){
        peopleList.forEach( p -> p.speak());
    }


}
