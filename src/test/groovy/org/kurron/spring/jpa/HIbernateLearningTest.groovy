package org.kurron.spring.jpa

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.junit.Test
import org.kurron.domain.Child
import org.kurron.domain.Parent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests

import javax.persistence.EntityManager

/**
 * Learning test to drive the Spring JPA experiments.
 */
@ContextConfiguration
class HibernateLearningTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private SessionFactory sessionFactory

    private final Random random = new Random()

    @Test
    public void persist_parent_and_child_via_hibernate_session() {
        assert null != sessionFactory

        final Parent parent = new Parent()
        parent.name = randomHexString()

        final Child child = new Child()
        child.name = randomHexString()
        child.noise = randomHexString()
        parent.addChild( child )

        currentSession().save( parent )
        currentSession().flush()
    }

    private Session currentSession()
    {
        return sessionFactory.getCurrentSession()
    }

    private String randomHexString()
    {
        return Integer.toHexString( random.nextInt( Integer.MAX_VALUE ) ).toUpperCase()
    }
}
