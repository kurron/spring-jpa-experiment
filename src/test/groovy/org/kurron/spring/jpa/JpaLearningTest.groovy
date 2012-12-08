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
import javax.persistence.PersistenceContext

/**
 * Learning test to drive the Spring JPA experiments.
 */
@ContextConfiguration
class JpaLearningTest extends AbstractTransactionalJUnit4SpringContextTests {

    @PersistenceContext
    private EntityManager entityManager

    private final Random random = new Random()

    @Test
    public void persist_parent_and_child_via_jpa_entity_manager() {
        assert null != entityManager

    }

    private String randomHexString()
    {
        return Integer.toHexString( random.nextInt( Integer.MAX_VALUE ) ).toUpperCase()
    }
}
