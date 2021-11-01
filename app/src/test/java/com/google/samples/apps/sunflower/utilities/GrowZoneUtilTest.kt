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

package com.google.samples.apps.sunflower.utilities

import org.junit.Assert.assertEquals
import org.junit.Test

class GrowZoneUtilTest {

    @Test fun getZoneForLatitude() {
        assertEquals(13, getZoneForLatitude(0.0))
        assertEquals(13, getZoneForLatitude(7.0))
        assertEquals(12, getZoneForLatitude(7.1))
        assertEquals(1, getZoneForLatitude(84.1))
        assertEquals(1, getZoneForLatitude(90.0))
    }

    @Test fun getZoneForLatitude_negativeLatitudes() {
        assertEquals(13, getZoneForLatitude(-7.0))
        assertEquals(12, getZoneForLatitude(-7.1))
        assertEquals(1, getZoneForLatitude(-84.1))
        assertEquals(1, getZoneForLatitude(-90.0))
    }

    // Bugfix test for https://github.com/android/sunflower/issues/8
    @Test fun getZoneForLatitude_GitHub_issue8() {
        assertEquals(9, getZoneForLatitude(35.0))
        assertEquals(8, getZoneForLatitude(42.0))
        assertEquals(7, getZoneForLatitude(49.0))
        assertEquals(6, getZoneForLatitude(56.0))
        assertEquals(5, getZoneForLatitude(63.0))
        assertEquals(4, getZoneForLatitude(70.0))
    }
}
