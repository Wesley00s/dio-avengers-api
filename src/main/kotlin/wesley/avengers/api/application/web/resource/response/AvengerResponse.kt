package wesley.avengers.api.application.web.resource.response

import wesley.avengers.api.domain.avenger.Avenger

data class AvengerResponse(
    val id: Long?,
    val nick: String,
    val person: String,
    val desc: String?,
    val history: String?
) {
    companion object {
        fun from(avenger: Avenger) = AvengerResponse(
            id = avenger.id,
            nick = avenger.nick,
            person = avenger.person,
            desc = avenger.description,
            history = avenger.history
        )
    }
}