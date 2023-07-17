import com.jsoniter.JsonIterator
import com.jsoniter.output.JsonStream

data class Person(val name: String="", val age: Int=0, val city: String="")

fun main() {

    //json parsing
    val jsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}"
    val person = JsonIterator.deserialize(jsonString, Person::class.java)
    println("Name: ${person.name}, Age: ${person.age}, City: ${person.city}")

        //json serialization
    val personToSerialize = Person("Alice", 25, "London")
    val jsonOutput = JsonStream.serialize(personToSerialize)
    println(jsonOutput)

}