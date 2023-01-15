package com.example.programmingapp.util
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import com.example.programmingapp.R
import com.example.programmingapp.model.Button
import com.example.programmingapp.model.ButtonLesson
import com.example.programmingapp.model.Lesson
import com.example.programmingapp.model.Programming
import java.io.ByteArrayOutputStream

object Constants {
    fun names(): MutableList<String>{
        return mutableListOf(
            "Kotlin Basic",
            "Kotlin OOP",
            "Kotlin Advanced",
            "Android Basic",
            "Android Difficult UI Elements"
        )
    }

    fun programmingReturn(): MutableList<Programming>{
        return mutableListOf(
            Programming("Android Development", names()),
            Programming("Java Development", names()),
            Programming("Frontend Development", names()),
            Programming("IOS Development", names()),
            Programming("BackEnd Development", names())
        )
    }

    fun lessonsReturn(): MutableList<Lesson>{
        return mutableListOf(
            Lesson("Kotlin Basic", 10, R.drawable.ic_android_black_24dp),
            Lesson("Kotlin OOP", 10, R.drawable.ic_android_black_24dp),
            Lesson("Kotlin Advanced", 10, R.drawable.ic_android_black_24dp),
            Lesson("Android Basic", 10, R.drawable.ic_android_black_24dp),
            Lesson("Android Difficult UI Elements", 10, R.drawable.ic_android_black_24dp)
        )
    }

    fun buttonLessonReturn(): MutableList<ButtonLesson>{
        return mutableListOf(
            ButtonLesson(1),
            ButtonLesson(2),
            ButtonLesson(3),
            ButtonLesson(4),
            ButtonLesson(5),
            ButtonLesson(6),
            ButtonLesson(7),
            ButtonLesson(8),
            ButtonLesson(9),
            ButtonLesson(10)
        )
    }

    fun buttonsReturn(): MutableList<Button>{
        return mutableListOf(
            Button("Kotlin Basic"),
            Button("Kotlin OOP"),
            Button("Kotlin Advanced"),
            Button("Android Basic"),
            Button("Android Difficult UI Elements")
        )
    }
}

fun ImageView.toByteArray(): ByteArray {
    val bitmap = (this.drawable as BitmapDrawable).bitmap
    val stream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
    return stream.toByteArray()
}

fun ByteArray.toBitmap(): Bitmap? {
    return BitmapFactory.decodeByteArray(this, 0, this.size)
}