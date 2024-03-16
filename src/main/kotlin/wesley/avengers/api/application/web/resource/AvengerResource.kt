package wesley.avengers.api.application.web.resource

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import wesley.avengers.api.application.web.resource.request.AvengerRequest
import wesley.avengers.api.application.web.resource.request.AvengerUpdate
import wesley.avengers.api.application.web.resource.response.AvengerResponse
import wesley.avengers.api.service.implemented.AvengerService
import java.net.URI

private const val API_PATH = "v1/api/avenger"

@RestController
@RequestMapping(API_PATH)
class AvengerResource (
    private val avengerService: AvengerService
) {
    @PostMapping
    fun postAvenger(@Valid @RequestBody avenger: AvengerRequest) =

        avenger.toAvenger().run {
            avengerService.create(this)
        }.let {
            ResponseEntity
                .created(URI("$API_PATH/${it.id}"))
                .body(AvengerResponse.from(it))
        }

    @GetMapping
    fun getAvengers() =
        this.avengerService.getAvengers()
            .map { AvengerResponse.from(it) }
            .let { ResponseEntity.ok().body(it) }

    @GetMapping("{id}/details")
    fun getAvengerDetails(@PathVariable("id") id: Long) =
        this.avengerService.getDetail(id)
            .let { ResponseEntity.ok().body(AvengerResponse.from(it)) }

    @PutMapping("{id}")
    fun update(
        @PathVariable("id") id: Long,
        @RequestBody @Valid avengerUpdate: AvengerUpdate
    ): ResponseEntity<AvengerResponse> {
        val avenger = this.avengerService.getDetail(id)
        val avengerToUpdate = avengerUpdate.toEntity(avenger)
        val avengerUpdated = this.avengerService.create(avengerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(AvengerResponse.from(avengerUpdated))
    }

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable("id") id: Long) =
        this.avengerService.deleteById(id).let {
            ResponseEntity.accepted().build<Void>()
        }
}

