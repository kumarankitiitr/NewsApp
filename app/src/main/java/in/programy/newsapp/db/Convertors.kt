package `in`.programy.newsapp.db

import `in`.programy.newsapp.model.Source
import androidx.room.TypeConverter

class Convertors {

    @TypeConverter
    fun fromSource(source: Source): String?{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name,name)
    }
}