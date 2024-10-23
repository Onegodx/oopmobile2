
open class TimeConverter(private var minutes: Int, private var seconds: Int) {


    open fun info(): String {
        return "Минуты: $minutes, Секунды: $seconds"
    }


    fun totalSeconds(): Int {
        return minutes * 60 + seconds
    }
}

class ObservationObject(
    minutes: Int,
    seconds: Int,
    private var speed: Double 
) : TimeConverter(minutes, seconds) {


    fun calculateDistance(): Double {
        val totalSeconds = totalSeconds()
        return speed * totalSeconds 
    }


    override fun info(): String {
        return super.info() + ", Скорость: $speed м/сек"
    }
}

fun main() {

    println("Введите количество минут:")
    val minutes = readLine()?.toIntOrNull() ?: 0

    println("Введите количество секунд:")
    val seconds = readLine()?.toIntOrNull() ?: 0

    println("Введите скорость движения объекта наблюдения (в м/сек):")
    val speed = readLine()?.toDoubleOrNull() ?: 0.0


    val observationObject = ObservationObject(minutes, seconds, speed)


    println(observationObject.info())


    val distance = observationObject.calculateDistance()
    println("Расстояние, пройденное объектом наблюдения: $distance метров")
}
