package io.github.shadowcreative.eunit

import com.google.gson.GsonBuilder
import org.junit.Assert
import org.junit.Test

class FinalSample : Sample() {
    private val final_value_1 : List<String> = arrayOf("The final class", "Woo!").asList()
    private val final_value_2 : Set<String> = HashSet(arrayOf("This is set type test", "it works!").asList())
    @Transient private val final_value_except : String = "I'm excepted"

}

open class Sample : EntityUnit<Sample>() {
    private val value : String = "Hello world"
    private val value_2 : Int = 10000
    private val value_3 : Double = -3.141592
    private val value_4 : Array<Int> = arrayOf(10,20,30,40,50)
    private val value_5 : Float = 22.15f
    private val value_6 : Char = 'z'
    private val value_7 : Array<Char> = arrayOf('a','b','c','d','e')
}

class SampleTest {
    @Test
    fun testFunction()
    {
        var sample = Sample().create()
        var serializeResult = sample.toSerialize()
        var gson = GsonBuilder().setPrettyPrinting().serializeNulls().create()
        var result = gson.toJson(serializeResult)
        Assert.assertEquals(true, result != "")
        println("result= $result")

        sample = FinalSample().create()
        serializeResult = sample.toSerialize()
        gson = GsonBuilder().setPrettyPrinting().serializeNulls().create()
        result = gson.toJson(serializeResult)
        Assert.assertEquals(true, result != "")
        println("result 2 = $result")
    }

}
