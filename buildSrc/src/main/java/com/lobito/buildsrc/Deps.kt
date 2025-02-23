package com.lobito.buildsrc


object Deps {

    val endpointsGlobal = mutableListOf(
//        Pair("HOST_WEBAPI_SCAN", "\"" + "https://apiinventariologistica.lacalera.pe:8081" + "\""),
        Pair("API_SEGURIDAD_DEV", "\"" + "https://apst.lac.pe:8082" + "\""),
        Pair("API_SEGURIDAD_PROD", "\"" + "https://ad.la.pe:8092" + "\""),
        Pair("API_BUSES_DEV", "\"" + "https://apibest.lacra.pe:9194" + "\""),
        Pair("API_BUSES_PROD", "\"" + "https://apib.lra.pe:8092" + "\""),
        Pair("API_EMPLOYEE_PROD", "\"" + "https://apee.lara.pe:9090" + "\""),
        Pair("API_INVENTARIO_PROD", "\"" + "https://apio.laa.pe:9088" + "\""),
        Pair("API_DNI_PROD", "\"" + "https://api.apirestperu.com" + "\""),

        // AQUI SON LOS TOKENS DE LOS USUARIOS
        Pair("USER_TOKEN_BUSES", "\"" + "US1" + "\""),
        Pair("PASSWORD_TOKEN_BUSES", "\"" + "\$USEA23" + "\""),
        Pair("USER_TOKEN_EMPLOYEE", "\"" + "naoon" + "\""),
        Pair("PASSWORD_TOKEN_EMPLOYEE", "\"" + "@r13s" + "\""),

        // ENDPOINT DE EAT IDENTIFIER
        Pair("API_EATIDENTIFIER", "\"" + "https://eatidentifier.techjrstar.com" + "\""),

    )
}
