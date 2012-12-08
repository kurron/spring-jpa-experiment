package org.kurron.spring.jpa

import org.kurron.domain.Parent
import org.springframework.data.repository.CrudRepository

/**
 * Spring JPA will use this interface to auto-generate the Parent repository.
 */
interface ParentRepository extends CrudRepository<Parent,Long> {
}
