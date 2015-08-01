package jpa

import cn.boxfish.Application
import cn.boxfish.entity.Person
import cn.boxfish.entity.jpa.PersonJpaRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by LuoLiBing on 15/7/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
class JpaUtils {

    @Autowired
    private PersonJpaRepository jpaRepository;

    @Test
    void save() {
        def p = new Person(time: 344343, id: 2, version: 1)
        jpaRepository.save(p)
    }

    @Test
    void getone() {

    }

}
