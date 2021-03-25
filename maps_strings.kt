package lab03
/*
 3. Определить, входит ли ассоциативный массив a в ассоциативный массив b;
 это выполняется, если все ключи из a содержатся в b с такими же значениями.
   Например:    containsIn(mapOf("a" to "z"), mapOf("a" to "z", "b" to "sweet")) -> true
    containsIn(mapOf("a" to "z"), mapOf("a" to "zee", "b" to "sweet")) -> false
*/
fun containsIn(map1:Map<Any, Any>, map2: Map<Any, Any>):Boolean {
    val result = mutableMapOf<Any, Any>()
    result.putAll(map2)

    map1.forEach{ (key2, value2) -> result[key2] = value2}
    if (result != map2) return false
    return true
}

fun main(args: Array<String>){
    //println(containsIn(mapOf("a" to "z", "b" to "sweet"), mapOf("a" to "zee", "b" to "sweet", "c" to "cookie")))
    //println(containsIn(mapOf(1 to 5, 3 to 10), mapOf(1 to 5, 3 to 10, 4 to 55)))
    validNumber()
}

/*
3. Номер телефона задан строкой вида "+7 (921) 123-45-67".
Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
Может присутствовать неограниченное количество пробелов и чёрточек,
например, номер 12 --  34- 5 -- 67 -89 тоже следует считать легальным.
Перевести номер в формат без скобок, пробелов и чёрточек (но с +),
например, "+79211234567" или "123456789" для приведённых примеров.
Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
При неверном формате вернуть пустую строку
 */
fun validNumber() {
    println("Введите номер")
    val str = readLine().toString()
    val allowedSymbols1: String = "0123456789"
    val plus:Char = '+'
    val allowedSymbols2 = "-()+ "
    var result: String = ""
    if (str[0] == plus) {
        result += plus
    }
    for (index in str) {
        if (allowedSymbols2.indexOf(index) != -1) {
            result += ""
        } else {
            if (allowedSymbols1.indexOf(index) != -1) {
                result += index
            } else {
                result = ""
                break
            }
        }
    }
    println(result)
}

