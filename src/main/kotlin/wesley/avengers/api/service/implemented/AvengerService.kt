package wesley.avengers.api.service.implemented;

import org.springframework.stereotype.Service
import wesley.avengers.api.domain.avenger.Avenger
import wesley.avengers.api.repository.AvengerRepository
import wesley.avengers.api.service.IAvengerService

@Service
class AvengerService(
    private val avengerRepository: AvengerRepository
) : IAvengerService{
    override fun getDetail(id: Long): Avenger =
        this.avengerRepository.findById(id).orElseThrow {
            throw RuntimeException("Avenger with id $id not found")
        }

    override fun getAvengers(): List<Avenger> =
        this.avengerRepository.findAll()

    override fun create(avenger: Avenger): Avenger =
        this.avengerRepository.save(avenger)

    override fun deleteById(id: Long) =
        this.avengerRepository.deleteById(id)
}
