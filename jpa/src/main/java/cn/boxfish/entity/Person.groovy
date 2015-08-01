package cn.boxfish.entity

import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass

/**
 * Created by LuoLiBing on 15/7/31.
 */
@Entity
class Person {

    @EmbeddedId
    IdClass idClass

    int time

    @Embeddable
    class IdClass {
        int id;
        int version;
    }

}
