package com.codegemz.kotlinx.lesson0.koans

import org.junit.Test

import org.junit.*
import org.junit.Assert.*

class Kotlin3NullSafetyTest {

    @Ignore
    @Test
    fun assignNullToNullableOnly() {

        var nullable : String?
        var notNullable: String

        nullable = null

        // notNullable = null   // uncomment and see compilation error

        assertEquals(null, nullable)

    }

    @Ignore
    @Test
    fun noCallsOnNullable() {
        var nullable : String? = null
        var notNullable: String = "good long string"

        assertEquals(FIX_ME, notNullable.length)

        // assertEquals(0, nullable.length)  // uncomment to see compilation error

    }

    @Ignore
    @Test
    fun ifNotNull() {

        var nullable : String? = null
        var notNullable: String = "good long string"

        assertEquals(FIX_ME, notNullable.length)

        if (nullable != null) {
            assertEquals(0, nullable.length)  // but now no compilation errors!
        }

    }

    @Ignore
    @Test
    fun npeJavaWay() {

        // NullPointerException (NPE) is most "popular" Java error and bug source

        var nullable : String? = null
        var notNullable: String = "good long string"

        assertEquals(FIX_ME, notNullable.length)

        try{
            nullable!!.length
        }
        catch (npe : KotlinNullPointerException){
            // process npe java way
        }

    }

    @Ignore
    @Test
    fun callWithCheckOnNullable() {

        var nullable : String? = null

        var l : Int? = nullable?.length    // nullable?.length returns null if nullable is null

        assertEquals(FIX_ME, l)

    }

    @Ignore
    @Test
    fun safeCalls() {

        var nullable : String? = null

        var l : Int? = nullable?.length ?: 0

        assertEquals(FIX_ME, l)

    }
}
