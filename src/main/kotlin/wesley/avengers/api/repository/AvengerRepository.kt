package wesley.avengers.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import wesley.avengers.api.domain.avenger.Avenger

@Repository
interface AvengerRepository: JpaRepository<Avenger, Long>{
}