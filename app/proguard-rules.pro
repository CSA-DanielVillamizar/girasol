# Agregue reglas ProGuard específicas del proyecto aquí.
# De forma predeterminada, los indicadores de este archivo se anexan a los indicadores especificados
# en /usr/local/google/home/tiem/Android/Sdk/tools/proguard/proguard-android.txt
# Puede editar la ruta de inclusión y el orden cambiando los proguardFiles
# directiva en build.gradle.
#
# Para más detalles, ver
# http://developer.android.com/guide/developing/tools/proguard.html

# Agregue cualquier opción de mantener específica del proyecto aquí:

# Si su proyecto utiliza WebView con JS, quite los comentarios de lo siguiente
# y especifique el nombre de clase completo en la interfaz de JavaScript
# clase:
#-keepclassmembers clase fqcn.of.javascript.interface.for.webview {
# público *;
#}

# Quite el comentario de esto para conservar la información del número de línea para
# depuración de trazas de pila.
#-keepattributes SourceFile,LineNumberTable

# Si mantiene la información del número de línea, quite los comentarios a
# ocultar el nombre del archivo de origen original.
#-renamesourcefileattribute SourceFile

# ServiceLoader support
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}

# Most of volatile fields are updated with AFU and should not be mangled
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}