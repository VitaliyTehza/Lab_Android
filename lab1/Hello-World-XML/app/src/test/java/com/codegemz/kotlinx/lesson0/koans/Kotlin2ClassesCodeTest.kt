package com.codegemz.kotlinx.lesson0.koans

import org.junit.*
import org.junit.Assert.*

class Pet{
    val name = "fido"
    val bred = "pug"
}

class SmartPet(name: String, bred: String){ // primary constructor
    val name = name
    val bred = bred
}

class SmarterPet(val name : String, val bred : String) // only proomary constructor - no body needed

data class DataPet(val name : String, val bred : String) // equals, hashcode, toString generated!

var dogsInTheHouse = 0

class InitPet(val name : String, val bred : String) {
    init{
        dogsInTheHouse++;           // extend primary constructor with some logic
    }
}

class SecondaryConstructorPet(val name : String, val bred : String) {

    var hasFriends = false

    constructor(name : String, bred : String, friend : SecondaryConstructorPet) : this(name, bred){
        friend.play()               // or use secondary constructor
        hasFriends = true
    }

    fun play(){
        print("Woof")
    }
}

class PropertyPet(name: String, bred: String){
    var name = name
    var bred = bred
}

class SmartPropertyPet(name: String, bred: String){
    var name = name
        set(value){
            field = value
            dogsInTheHouse++
        }

    var bred = bred

}


class Kotlin2ClassesCodeTest {

    @Before
    fun setUp(){
        dogsInTheHouse = 0
    }

    @Ignore
    @Test
    fun simpleNotUsefulClass() {

        val fido = Pet()

        assertEquals("fido", fido.name)

        val rufus = Pet()

        assertEquals(FIX_ME, rufus.name)

    }

    @Ignore
    @Test
    fun weNeedAConstructor() {

        val fido = SmartPet("fido", "pug")

        assertEquals("fido", fido.name)

        val rufus = SmartPet("rufus", "labrador")

        assertEquals(FIX_ME, rufus.name)

    }

    @Ignore
    @Test
    fun evenSmatter() {

        val fido = SmarterPet("fido", "pug")

        assertEquals("fido", fido.name)

        val rufus = SmarterPet("rufus", "labrador")

        assertEquals(FIX_ME, rufus.name)

    }

    @Ignore
    @Test
    fun dataPet() {

        val fido = DataPet("fido", "pug")
        val rufus = DataPet("rufus", "labrador")

        assertEquals("fido", fido.name)

        assertEquals(97538100, fido.hashCode())

        assertFalse(fido.equals(rufus))

        assertEquals(FIX_ME, fido.toString())
    }

    @Ignore
    @Test
    fun initPet() {

        assertEquals(0, dogsInTheHouse);

        val fido = InitPet("fido", "pug")

        assertEquals(FIX_ME, dogsInTheHouse);

        val rufus = InitPet("rufus", "labrador")

        assertEquals(FIX_ME, dogsInTheHouse);

    }

    @Ignore
    @Test
    fun secondaryConstructorPet() {

        val fido = SecondaryConstructorPet("fido", "pug")

        assertFalse(fido.hasFriends);

        val rufus = SecondaryConstructorPet("rufus", "labrador", fido)

        assertEquals(FIX_ME, rufus.hasFriends);

    }

    @Ignore
    @Test
    fun propertiesUseInvisibleSettersAndGetters() {

        val fido = PropertyPet("fido", "pug")

        assertEquals(FIX_ME, fido.name);

        fido.name = "fido I"

        assertEquals(FIX_ME, fido.name);

    }

    @Ignore
    @Test
    fun yourLogicForSettersGetters() {

        val fido = SmartPropertyPet("fido", "pug")

        assertEquals("fido", fido.name);

        assertEquals(FIX_ME, dogsInTheHouse);

        fido.name = "fido I"

        assertEquals("fido I", fido.name);

        assertEquals(FIX_ME, dogsInTheHouse); // please rename your dog before use ;)

    }


}
