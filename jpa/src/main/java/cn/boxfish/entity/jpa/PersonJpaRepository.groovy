package cn.boxfish.entity.jpa

import cn.boxfish.entity.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import javax.transaction.Transactional

/**
 * Created by LuoLiBing on 15/7/31.
 */
@Repository
@Transactional
interface PersonJpaRepository extends JpaRepository<Person, Person.IdClass> {

}