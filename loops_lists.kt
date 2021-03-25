// Для заданного числа n определить, содержит ли оно различающиеся цифры.
// Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
//Использовать операции со строками в этой задаче запрещается.
import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    //task2()
    task3()
}


fun task2() {
    for (element in arrayOf(54, 323, 111, 0)) {
        if (sameNumbers(element)) {
            println("$element - одинаковые цифры")
        }
        else println("$element - различающиеся")
    }
}

fun sameNumbers(element: Int): Boolean {
    val listNumber = ArrayList<Int>()

    var number = element.absoluteValue

    while(number>0) {
        val lastNumber = number % 10
        if (listNumber.size > 0 && listNumber[listNumber.size - 1] != lastNumber)
            return false

        listNumber.add(lastNumber)
        number /= 10
    }
    return true
}


/*Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 Если список пуст, не делать ничего. Вернуть изменённый список.
  Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.

*/
fun task3() {

    val l = mutableListOf(-1.9, 5.4, -7.3, 8.1, 5.3, 8.9, 6.4)
    val s:Int = l.size - 1

        if (l.any()) {

            for (i in 0..s) {
                l[i] -= l.sum()/l.size

            }
        } else println("список пуст")

    println(l)
}

