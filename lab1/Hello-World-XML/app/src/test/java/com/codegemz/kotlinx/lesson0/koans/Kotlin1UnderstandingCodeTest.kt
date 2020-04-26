package com.codegemz.kotlinx.lesson0.koans

import org.junit.*
import org.junit.Assert.*
import java.util.*

val FIX_ME : Any = "FIX ME"
val FIX_ME_ = LinkedList<Int>()

fun max(a : Int, b: Int) : Int {
    if(a > b) return a
    else return b
}

class Kotlin1UnderstandingCodeTest {

    @Ignore
    @Test
    fun commentingTheCode() {

        // you can put any textual comment into your code after `//`

        // comment the next line to prevent this test from failing:
        fail()

    }

    @Ignore
    @Test
    fun simpleVariable() {

        // you can create a variable using `var` syntax:
        var str : String = "abc"
        // you can provide a type to your variable
        // most popular types are String, Int, Float and Boolean

        // you should fix this line:
        assertEquals(FIX_ME, str)  // replace `FIX_ME` with the value of variable `str`

    }

    @Ignore
    @Test
    fun simpleVariable_canGuessTheType() {

        // you can omit declaration of variable type if you have got it's value from the beginning:
        var str = "abc"

        str = "123"

        assertEquals(FIX_ME, str)

    }

    @Ignore
    @Test
    fun valueCanNotBeModified() {

        // except `var` you can use `val` for creation of variable
        val strVal = "abc"

        // but var and val are different!

        // strVal = "123"

        // As a part of this Koan, do this :
        // 1: uncomment line `strVal = "123"`
        // 2: run build-test
        // 3: notice failed build with the error: 'Val cannot be reassigned'
        // 4: meditate about this fact
        // 5: comment line 'strVal = "123"' back and proceed with the rest of this Koan.

        assertEquals(FIX_ME, strVal)

    }

    @Ignore
    @Test
    fun val_canBeAssigned_afterDeclaration() {

        val str : String

        str = "abc"

        assertEquals(FIX_ME, str)

    }

    @Ignore
    @Test
    fun stringInterpolation() {

        val x = 2 + 3
        val str = "2 + 3 = $x"

        assertEquals(FIX_ME, str)

    }

    private fun sum(a : Int, b : Int) : Int {
        return a + b
    }

    @Ignore
    @Test
    fun simpleFunction() {

        assertEquals(FIX_ME, sum(2, 3))

    }

    private fun <T> myListOf(vararg elements : T) : List<T> {

        val ret = LinkedList<T>()

        for(el in elements) {
            ret.add(el)
        }

        return ret
    }

    @Ignore
    @Test
    fun functionWithGenericTypeDeclaration() {

        var listOfStrings = myListOf("abc", "ABC", "123")

        assertEquals(FIX_ME, listOfStrings.size)

        // notice 3 different ways to get a list element

        assertEquals(FIX_ME, listOfStrings[0])

        assertEquals(FIX_ME, listOfStrings.get(1))

        assertEquals(FIX_ME, listOfStrings.last())

    }

    @Ignore
    @Test
    fun functionWithGenericTypeDeclaration_integerValues() {

        var listOfInts = myListOf(1, 2, 3)

        assertEquals(FIX_ME, listOfInts.size)

        // notice 3 different ways to get a list element

        assertEquals(FIX_ME, listOfInts[0])

        assertEquals(FIX_ME, listOfInts.get(1))

        assertEquals(FIX_ME, listOfInts.last())

    }

    @Ignore
    @Test
    fun topLevelFunction() {

        // find max() function declaration and mediate

        assertEquals(FIX_ME, max(2, 3))

    }

    @Ignore
    @Test
    fun higherOrderFunctions() {

        // Higher order functions returns or accepts other functions as variables

        val listOfStrings = myListOf("Hello", "Kotlin", "!")

        val lengths = listOfStrings.map {it.length}

        checkLengths(FIX_ME_) // check real object: replace `FIX_ME_` with `lengths`

        // meditate on checkLengths function

        // meditate on this code: `listOfStrings.map {it.length}`, don't worry if you did not get it -
        // we will investigate this code in the next several tests.

    }

    // How it works?
    // lets rework the previous test and feed `myLengthOfString` function as a parameter to `map` function:
    
    val myLengthOfString = fun(s : String) : Int {
        return s.length
    }

    @Ignore
    @Test
    fun higherOrderFunctions_simplifiedVersion() {

        val listOfStrings = myListOf("Hello", "Kotlin", "!")

        val lengths = listOfStrings.map(myLengthOfString)

        // the secret is in `map` function
        // it's higher order function
        // which are declared for List type
        // it is gives each element of the list and performs the function given by parmeter,
        // in our example this function is `myLengthOfString`

        checkLengths(FIX_ME_)  // check real object: replace `FIX_ME_` with `lengths`

    }

    @Ignore
    @Test
    fun higherOrderFunctions2_inlineVersion() {

        val listOfStrings = myListOf("Hello", "Kotlin", "!")

        // let's feed just body of `myLengthOfString` - this also works!
        val lengths = listOfStrings.map(fun(s : String) : Int {
            return s.length
        })

        checkLengths(FIX_ME_)  // check real object: replace `FIX_ME_` with `lengths`

    }

    @Ignore
    @Test
    fun higherOrderFunctions2_inlineVersion_withoutName_orLambda() {

        val listOfStrings = myListOf("Hello", "Kotlin", "!")

        // let's rework previous test with Lambda (function as an object in many programming languages)
        val lengths = listOfStrings.map(
            {str : String -> str.length})

        checkLengths(FIX_ME_)  // check real object: replace `FIX_ME_` with `lengths`

    }

    @Ignore
    @Test
    fun higherOrderFunctions2_inlineVersion_withutName_orLambda_shorter() {

        val listOfStrings = myListOf("Hello", "Kotlin", "!")

        // shorter Lambda in Kotlin:
        val lengths = listOfStrings.map(
            {str -> str.length})

        checkLengths(FIX_ME_)  // check real object: replace `FIX_ME_` with `lengths`

    }

    @Ignore
    @Test
    fun higherOrderFunctions2_inlineVersion_withoutName_orLambda_evenShorter() {

        val listOfStrings = myListOf("Hello", "Kotlin", "!")

        // with `it` object in the context of code block:
        val lengths = listOfStrings.map({it.length})

        checkLengths(FIX_ME_)  // check real object: replace `FIX_ME_` with `lengths`

    }

    @Ignore
    @Test
    fun higherOrderFunctions2_inlineVersion_withutName_orLambda_evenShorter_externalCodeBlock() {

        val listOfStrings = myListOf("Hello", "Kotlin", "!")

        // we can provide code block outside ():
        val lengths = listOfStrings.map(){it.length}

        checkLengths(FIX_ME_)  // check real object: replace `FIX_ME_` with `lengths`

        // we can omit the empty () and rewrite the last version even shortly 
        // so we came up exactly to the version of higherOrderFunctions test

    }

    private fun checkLengths(lengths : List<Int>){
        assertEquals(3, lengths.size)

        assertEquals(5, lengths[0])

        assertEquals(6, lengths[1])

        assertEquals(1, lengths[2])
    }
}
