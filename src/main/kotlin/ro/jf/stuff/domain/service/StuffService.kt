package ro.jf.stuff.domain.service

import ro.jf.stuff.domain.command.CreateStuffCommand
import ro.jf.stuff.domain.command.UpdateStuffCommand
import ro.jf.stuff.domain.model.Stuff
import java.util.UUID

class StuffService {

    private val db = generateSequence { Stuff.random() }
        .take(3)
        .associateBy { it.id }
        .toMutableMap()

    fun list() = db.values.toList()

    fun get(id: UUID): Stuff = db[id] ?: throw RuntimeException("Stuff not found by id $id")

    fun create(command: CreateStuffCommand): Stuff {
        val stuff = command.toModel()
        db[stuff.id] = stuff
        return stuff
    }

    fun update(command: UpdateStuffCommand): Stuff {
        val stuff = get(command.id)
        val newStuff = stuff.copy(name = command.name)
        db[stuff.id] = newStuff
        return newStuff
    }

    fun delete(id: UUID) {
        db.remove(id)
    }
}
