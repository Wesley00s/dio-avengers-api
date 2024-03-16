package wesley.avengers.api.service

import wesley.avengers.api.domain.avenger.Avenger

interface IAvengerService {
    fun getDetail(id: Long): Avenger
    fun getAvengers(): List<Avenger>
    fun create(avenger: Avenger): Avenger
    fun deleteById(id: Long)
}