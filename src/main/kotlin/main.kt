fun main() {
    while (true) {
        println("введите номер задачи")
        when (readln()) {
            "1" -> agoToText()
            "2" -> feeCalculate(
                readln().toInt(), readln(), try {
                    readln().toInt()
                } catch (_: NumberFormatException) {
                    0
                }
            )
            else -> break
        }
    }
}

fun feeCalculate(amount: Int, card: String = "мир", limit: Int = 0) {
    if (amount > 150000 || limit >= 600000) {
        println("карта заблокирована")
    } else {
        val fee = when (card) {
            "мир" -> 0
            "visa" -> if (amount * 0.0075 >= 35) {
                0
            } else {
                amount * 0.0075
            }
            "mastercard" -> if (limit <= 75000 && amount <= 75000) {
                0
            } else {
                (amount - 75000) * 0.006 + 20
            }
            else -> 0
        }
        println(fee)
    }
}

fun minutes(num: Int): String {
    val num1 = num / 60
    if (num1 % 10 == 1 || num1 == 1) {
        return "минуту"
    } else if ((num1 % 10 == 5) || (11 <= num1 && num1 <= 14)) {
        return "минут"
    } else {
        return "минуты"
    }
}

fun hours(num: Int): String {
    val num1 = num / (60 * 60)
    if (num1 % 10 == 1) {
        return "час"
    } else if ((num1 % 10 == 2) || (num1 % 10 == 3) || (num1 % 10 == 4)) {
        return "часа"
    } else {
        return "часов"
    }
}

fun agoToText() {
    val seconds = readln().toInt()
    when (seconds) {
        in 0..60 -> println("Был(а) только что")
        in 61..60 * 60 -> println("Был(а) " + (seconds / 60) + " " + minutes(seconds) + " " + "назад")
        in 60 * 60 + 1..60 * 60 * 24 -> println("Был(а) " + (seconds / (60 * 60)) + " " + hours(seconds) + " " + "назад")
        in 60 * 60 * 24..60 * 60 * 48 -> println("Был(а) вчера")
        in 60 * 60 * 48..60 * 60 * 72 -> println("Был(а) позавчера")
        in 60 * 60 * 72..Int.MAX_VALUE -> println("Был(а) давно")
    }
}