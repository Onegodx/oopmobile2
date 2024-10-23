// Родительский класс
open class TimeConverter(private var minutes: Int, private var seconds: Int) {

    // Метод для формирования строки с информацией об объекте
    open fun info(): String {
        return "Минуты: $minutes, Секунды: $seconds"
    }

    // Метод для вычисления общего количества секунд
    fun totalSeconds(): Int {
        return minutes * 60 + seconds
    }
}

// Класс-потомок
class ObservationObject(
    minutes: Int,
    seconds: Int,
    private var speed: Double // скорость в м/сек
) : TimeConverter(minutes, seconds) {

    // Метод для вычисления расстояния, пройденного объектом наблюдения
    fun calculateDistance(): Double {
        val totalSeconds = totalSeconds()
        return speed * totalSeconds // расстояние = скорость * время
    }

    // Переопределение метода info для добавления информации о скорости
    override fun info(): String {
        return super.info() + ", Скорость: $speed м/сек"
    }
}

fun main() {
    // Ввод значений полей
    println("Введите количество минут:")
    val minutes = readLine()?.toIntOrNull() ?: 0

    println("Введите количество секунд:")
    val seconds = readLine()?.toIntOrNull() ?: 0

    println("Введите скорость движения объекта наблюдения (в м/сек):")
    val speed = readLine()?.toDoubleOrNull() ?: 0.0

    // Создание объекта класса ObservationObject
    val observationObject = ObservationObject(minutes, seconds, speed)

    // Вывод информации об объекте
    println(observationObject.info())

    // Вычисление расстояния
    val distance = observationObject.calculateDistance()
    println("Расстояние, пройденное объектом наблюдения: $distance метров")
}