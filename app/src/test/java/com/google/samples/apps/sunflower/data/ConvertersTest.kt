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
import org.junit.Test
import java.util.Calendar
import java.util.Calendar.DAY_OF_MONTH
import java.util.Calendar.MONTH
import java.util.Calendar.SEPTEMBER
import java.util.Calendar.YEAR

class ConvertersTest {

    private val cal = Calendar.getInstance().apply {
        set(YEAR, 1998)
        set(MONTH, SEPTEMBER)
        set(DAY_OF_MONTH, 4)
    }

    @Test fun calendarToDatestamp() {
        assertEquals(cal.timeInMillis, Converters().calendarToDatestamp(cal))
    }

    @Test fun datestampToCalendar() {
        assertEquals(Converters().datestampToCalendar(cal.timeInMillis), cal)
    }
}
