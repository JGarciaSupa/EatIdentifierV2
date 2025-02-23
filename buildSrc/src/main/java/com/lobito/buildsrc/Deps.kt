package com.lobito.buildsrc


object Deps {

    val endpointsGlobal = mutableListOf(
//        Pair("HOST_WEBAPI_SCAN", "\"" + "https://apiinventariologistica.lacalera.pe:8081" + "\""),
        Pair("API_SEGURIDAD_DEV", "\"" + "https://apiseguridadtest.lacalera.pe:8082" + "\""),
        Pair("API_SEGURIDAD_PROD", "\"" + "https://apiseguridad.lacalera.pe:8092" + "\""),
        Pair("API_BUSES_DEV", "\"" + "https://apibusestest.lacalera.pe:9194" + "\""),
        Pair("API_BUSES_PROD", "\"" + "https://apibuses.lacalera.pe:8092" + "\""),
        Pair("API_EMPLOYEE_PROD", "\"" + "https://apiemployee.lacalera.pe:9090" + "\""),
        Pair("API_INVENTARIO_PROD", "\"" + "https://apiinventario.lacalera.pe:9088" + "\""),
        Pair("API_DNI_PROD", "\"" + "https://api.apirestperu.com" + "\""),

        // AQUI SON LOS TOKENS DE LOS USUARIOS
        Pair("USER_TOKEN_BUSES", "\"" + "USER1" + "\""),
        Pair("PASSWORD_TOKEN_BUSES", "\"" + "\$USER1.CALERA23" + "\""),
        Pair("USER_TOKEN_EMPLOYEE", "\"" + "naosolution" + "\""),
        Pair("PASSWORD_TOKEN_EMPLOYEE", "\"" + "@r1st0t3l3s" + "\""),

    )
}
