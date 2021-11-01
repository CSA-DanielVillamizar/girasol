/*
 * Derechos de autor 2021 Google LLC
 *
 * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia");
 * no puede utilizar este archivo excepto en cumplimiento con la Licencia.
 * Puede obtener una copia de la Licencia en
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que lo exija la ley aplicable o se acuerde por escrito, el software
 * distribuido bajo la Licencia se distribuye "TAL CUAL",
 * SIN GARANTÍAS NI CONDICIONES DE NINGÚN TIPO, ya sean expresas o implícitas.
 * Consulte la Licencia para conocer el idioma específico que rige los permisos y
 * limitaciones bajo la Licencia.
 */

package com.google.samples.apps.sunflower.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.util.Calendar
import java.util.Calendar.DAY_OF_YEAR

class PlantTest {

    private lateinit var plant: Plant

    @Before fun setUp() {
        plant = Plant("1", "Tomate", "A red vegetable", 1, 2, "")
    }

    @Test fun test_default_values() {
        val defaultPlant = Plant("2", "Manzana", "Description", 1)
        assertEquals(7, defaultPlant.wateringInterval)
        assertEquals("", defaultPlant.imageUrl)
    }

    @Test fun test_shouldBeWatered() {
        Calendar.getInstance().let { now ->
            // Generar lastWateringDate a partir de ser como copia de ahora.
            val lastWateringDate = Calendar.getInstance()

            // La prueba para el últimoWateringDate es hoy.
            lastWateringDate.time = now.time
            assertFalse(plant.shouldBeWatered(now, lastWateringDate.apply { add(DAY_OF_YEAR, -0) }))

            // La prueba para el últimoWateringDate es ayer.
            lastWateringDate.time = now.time
            assertFalse(plant.shouldBeWatered(now, lastWateringDate.apply { add(DAY_OF_YEAR, -1) }))

            // La prueba para el últimoWateringDate es anteayer.
            lastWateringDate.time = now.time
            assertFalse(plant.shouldBeWatered(now, lastWateringDate.apply { add(DAY_OF_YEAR, -2) }))

            // La prueba para el últimoWateringDate es hace algunos días, hace tres días, hace cuatro días, etc.
            lastWateringDate.time = now.time
            assertTrue(plant.shouldBeWatered(now, lastWateringDate.apply { add(DAY_OF_YEAR, -3) }))
        }
    }

    @Test fun test_toString() {
        assertEquals("Tomato", plant.toString())
    }
}
