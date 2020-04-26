package com.codegemz.kotlinx.lesson3

class Converter {
    companion object {
        private fun celsiusToFahrenheit(value: Double): Double = value * 9 / 5 + 32
        private fun celsiusToKelvin(value: Double): Double = value + 273.15

        private fun fahrenheitToCelsius(value: Double): Double = (value - 32) * 5 / 9
        private fun fahrenheitToKelvin(value: Double): Double = (value - 32) * 5 / 9 + 273.15

        private fun kelvinToFahrenheit(value: Double): Double = (value - 273.15) * 9 / 5 + 32
        private fun kelvinToCelsius(value: Double): Double = (value - 273.15) * 9 / 5 + 32

        public fun convert(first: String, second: String, value: Double): Double {
            when (first) {
                "Celsius" -> return when (second) {
                    "Fahrenheit" -> celsiusToFahrenheit(value)
                    "Kelvin" -> celsiusToKelvin(value)
                    else -> value
                }
                "Fahrenheit" -> return when (second) {
                    "Celsius" -> fahrenheitToCelsius(value)
                    "Kelvin" -> fahrenheitToKelvin(value)
                    else -> value
                }
                "Kelvin" -> return when (second) {
                    "Fahrenheit" -> kelvinToFahrenheit(value)
                    "Celsius" -> kelvinToCelsius(value)
                    else -> value
                }
                else -> return 0.0
            }
        }
    }
}
