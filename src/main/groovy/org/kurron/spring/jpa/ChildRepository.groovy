package org.kurron.spring.jpa

import org.kurron.domain.Child
import org.springframework.data.repository.CrudRepository

/**
 * Spring JPA will use this interface to auto-generate the Child repository.
 */
interface ChildRepository extends CrudRepository<Child,Long> {
}
