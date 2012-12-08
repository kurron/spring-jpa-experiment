package org.kurron.spring.jpa

import org.junit.Test
import org.kurron.domain.Child
import org.kurron.domain.Parent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * Learning test to drive the Spring JPA experiments.
 */
@ContextConfiguration
class SpringJpaLearningTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ParentRepository repository;

    private final Random random = new Random()

    @Test
    public void persist_parent_and_child_via_spring_jpa_repository() {

        assert null != repository

        final Parent parent = new Parent()
        parent.name = randomHexString()

        final Child child = new Child()
        child.name = randomHexString()
        child.noise = randomHexString()
        parent.addChild( child )

        repository.save( parent )

    }

    private String randomHexString()
    {
        return Integer.toHexString( random.nextInt( Integer.MAX_VALUE ) ).toUpperCase()
    }
}
