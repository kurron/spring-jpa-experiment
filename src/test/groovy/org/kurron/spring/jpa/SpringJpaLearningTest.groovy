package org.kurron.spring.jpa

import org.junit.Test
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests

/**
 * Learning test to drive the Spring JPA experiments.
 */
@ContextConfiguration
class SpringJpaLearningTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Test
    public void bob() {
        println 'bob called'
    }
}
