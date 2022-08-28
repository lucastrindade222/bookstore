package br.com.lucas.bookstore.security;

public class SecurityConstants {

    public static final String SECRET = "fac6dd3590b19f71d916bdaacb211750d288f6006d4b30806310682143a502eabb68a4225cdcd8a25f3bee2e193d6642d9b847ec80d5ca986955b6d56420bb15";
    public static final String TOKEN_PREXI = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 86400000L;

    public static final String[] PUBLIC_MATCHERS = { "/public/**", "api/notification/**", "/transaction/**",
            "/not-restricted", "/oauth/**", "/login/oauth2/**" ,"/login/**","/static/**"

    };
    public static final String[] PUBLIC_MATCHERS_GET = {

            "https://pagseguro.uol.com.br/**", "api/categoria/**", "api/subcategoria/**", "api/trabalho/**",
            "api/regiao/subCategoria/**", "api/ibg/estado/**", "api/portfolio/**", "api/prestador/page/filter",
            "api/cliente/pagsuro/self/**","/api/auth/new"

    };
    public static final String[] PUBLIC_MATCHERS_POST = { "api/cliente/**", "api/prestador/**", "api/auth/forgot/**",
            "api/tpm/gabay/**", "/pagseguro.uol.com.br/**", "/authorizations/**", "api/users", "api/auth/forgot/**",
            "api/stransaction/**", "api/directPayment/**", "/api/compra/pagseguro/**"

    };

}
