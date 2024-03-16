package wesley.avengers.api.application.web.resource.request

import jakarta.validation.constraints.NotEmpty
import wesley.avengers.api.domain.avenger.Avenger

data class AvengerRequest(
    @field:NotEmpty
    val nick: String,
    @field:NotEmpty
    val person: String,
    val desc: String?,
    val history: String?
) {
    fun toAvenger() = Avenger(
        nick,
        person,
        desc,
        history
    )
}
