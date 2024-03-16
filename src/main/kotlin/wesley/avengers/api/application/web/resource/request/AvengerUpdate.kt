package wesley.avengers.api.application.web.resource.request

import jakarta.validation.constraints.NotEmpty
import wesley.avengers.api.domain.avenger.Avenger

data class AvengerUpdate (
    @field:NotEmpty
    val nick: String,
    @field:NotEmpty
    val person: String,
    val desc: String?,
    val history: String?
) {
    fun toEntity(avenger: Avenger): Avenger {
        avenger.nick = nick
        avenger.person = person
        avenger.description = desc
        avenger.history = history

        return avenger
    }
}