/*
Напишите класс Student, предоставляющий информацию об имени студента методом
getName() и о его курсе методом getCourse().
Напишите метод printStudents(List students, int course), который получает список
студентов и номер курса и печатает в консоль имена тех студентов из списка, которые
обучаются на данном курсе. Для обхода списка в этом методе используйте итератор.
Протестируйте ваш метод (для этого предварительно придется создать десяток объектов
класса Student и поместить их в список)
Напишите методы union(Set set1, Set set2) и intersect(Set set1, Set set2),
реализующих операции объединения и пересечения двух множеств. Протестируйте работу этих
методах на двух предварительно заполненных множествах. (Вам понадобится написать
вспомогательный метод, выводящий все элементы множества в консоль).
*/
fun main() {
    val students = mutableListOf<Student>()
    students.add(Student("Den",1))
    students.add(Student("Joe",3))
    students.add(Student("Vasya",2))
    students.add(Student("Geralt",5))
    students.add(Student("Aysultan",1))
    students.add(Student("Kobe",5))
    students.add(Student("Tony",4))
    students.add(Student("Eliabeth",2))
    students.add(Student("Cheburek",4))
    students.add(Student("Ivan",3))
    printStudents(students, 1)

    val stud1 = setOf(
        ("Kyle"),
        ("Charlie"),
        ("Jessica"),
        ("Damian"),
        ("Michael"),
        ("Luka"))
    val stud2 = setOf(
        ("Kyle"),
        ("Kareem"),
        ("Charlie"),
        ("Jessica"),
        ("Paige"))
    union(stud1, stud2)
    intersect(stud1, stud2)
}

class Student(private var name: String, private var course:Int) {
    init{
        this.name = name
        this.course = course
    }

    fun getName():String = name

    fun getCourse():Int = course

}

fun printStudents(student: MutableList<Student>, course:Int) {
    val itr = student.iterator()
    while (itr.hasNext()) {
        val tmp = itr.next()
        if (tmp.getCourse() == course) println(tmp.getName())
    }
}


fun union(set1: Set<Any>, set2: Set<Any>) {
    val set3 = mutableSetOf<Any>()
    set3.addAll(set1)
    set3.addAll(set2)

    println(set3)
}

fun intersect(set1: Set<Any>, set2: Set<Any>) {
    val set3 = mutableSetOf<Any>()

    for (i in set1) {
        for (j in set2) {
            if (i == j) set3.add(i)
        }
    }
    println(set3)
}

fun intersectStudents(set1: Set<Student>, set2: Set<Student>) {
    val set3 = mutableSetOf<Student>()
    val itr1 = set1.iterator()
    val itr2 = set2.iterator()

    while (itr1.hasNext()) {
        val std1 = itr1.next()
        while(itr2.hasNext()){
            val std2 = itr2.next()
            if (std1.getName() == std2.getName() && std1.getCourse() == std2.getCourse()) {
                set3.add(std1)
                break
            }
        }
    }
    for (i in set3) println("${i.getName()} ${i.getCourse()}")
}