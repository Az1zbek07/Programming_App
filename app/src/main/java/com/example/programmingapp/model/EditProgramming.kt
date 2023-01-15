package com.example.programmingapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class EditProgramming(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    var img: ByteArray
): Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EditProgramming

        if (id != other.id) return false
        if (name != other.name) return false
        if (!img.contentEquals(other.img)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + img.contentHashCode()
        return result
    }
}
