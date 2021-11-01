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

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import java.util.Calendar
import java.util.Calendar.DAY_OF_MONTH
import java.util.Calendar.MONTH
import java.util.Calendar.YEAR

class GardenPlantingTest {

    @Test
    fun testDefaultValues() {
        val gardenPlanting = GardenPlanting("1")
        val cal = Calendar.getInstance()
        assertYMD(cal, gardenPlanting.plantDate)
        assertYMD(cal, gardenPlanting.lastWateringDate)
        assertEquals(0L, gardenPlanting.gardenPlantingId)
    }

    // Solo se necesita precisión año/mes/día para comparar las entradas del calendario gardenPlanting
    private fun assertYMD(expectedCal: Calendar, actualCal: Calendar) {
        assertThat(actualCal.get(YEAR), equalTo(expectedCal.get(YEAR)))
        assertThat(actualCal.get(MONTH), equalTo(expectedCal.get(MONTH)))
        assertThat(actualCal.get(DAY_OF_MONTH), equalTo(expectedCal.get(DAY_OF_MONTH)))
    }
}
