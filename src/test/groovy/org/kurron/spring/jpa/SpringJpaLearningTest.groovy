package org.kurron.spring.jpa

import org.junit.Test
import org.kurron.domain.Child
import org.kurron.domain.Parent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests

/**
 * Learning test to drive the Spring JPA experiments.
 */
@ContextConfiguration
class SpringJpaLearningTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    private final Random random = new Random()

    @Test
    public void persist_parent_and_child_via_spring_jpa_repository() {

        assert null != parentRepository

        final Parent parent = new Parent()
        parent.name = randomHexString()

        final Child child = new Child()
        child.name = randomHexString()
        child.noise = randomHexString()
        parent.addChild( child )

        parentRepository.save( parent )

    }

    @Test
    public void exercise_parent_finders() {

        assert null != parentRepository
        assert null != childRepository

        def parents = populateDatabase()

        println 'There are ' + parentRepository.count() + ' parent records in the system.'
        parentRepository.findAll().each {
            println it
        }

        if ( parentRepository.exists( parents[0].id ) )
        {
            parentRepository.delete( parents[0].id )
        }
        println 'There are now ' + parentRepository.count() + ' parent records in the system.'

        parentRepository.deleteAll()
        println 'There are now ' + parentRepository.count() + ' parent records in the system.'

    }

    @Test
    public void exercise_child_finders() {

        assert null != parentRepository
        assert null != childRepository

        def parents = populateDatabase()

        println 'There are ' + childRepository.count() + ' child records in the system.'
        childRepository.findAll().each {
            println it
        }

        parentRepository.deleteAll()
        println 'There are now ' + childRepository.count() + ' child records in the system.'

    }

    private def populateDatabase() {
        def parents = []
        5.times {
            final Parent parent = new Parent()
            parent.name = randomHexString()

            5.times {
                final Child child = new Child()
                child.name = randomHexString()
                child.noise = randomHexString()
                parent.addChild(child)
            }
            parents << parentRepository.save(parent)
        }
        return parents
    }

    private String randomHexString()
    {
        return Integer.toHexString( random.nextInt( Integer.MAX_VALUE ) ).toUpperCase()
    }
}
