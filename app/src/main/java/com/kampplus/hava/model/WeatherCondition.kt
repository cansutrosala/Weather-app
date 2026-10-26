package com.kampplus.hava.model

/**
 * Hava durumunun ekrandaki karşılığı: bir emoji ve Türkçe bir etiket.
 *
 * Open-Meteo, sıcaklığın yanında bir de `weather_code` gönderir. Bu kod WMO 4677
 * standardındadır ve tek başına bir sayıdır (0, 61, 95...). Kullanıcıya sayı
 * gösteremeyiz; [fromWeatherCode] ile anlaşılır bir görünüme çeviririz.
 */
enum class WeatherCondition(val emoji: String, val label: String, val advice: String) {
    CLEAR("☀️", "Açık", "Hava pırıl pırıl, güneş kremini sürmeyi unutma! 😎"),
    MAINLY_CLEAR("🌤️", "Az bulutlu", "Güneş yüzünü gösterdi, keyfini çıkar! ✨"),
    PARTLY_CLOUDY("⛅", "Parçalı bulutlu", "Ne sıcak ne soğuk, yürüyüş için ideal! 🚶‍♂️"),
    OVERCAST("☁️", "Kapalı", "Hava biraz kapalı ama senin enerjin buraları ısıtır! ⛅"),
    FOG("🌫️", "Sisli", "Önünü iyi seç, simit alırken kaybolma! 🥯"),
    DRIZZLE("🌦️", "Çisenti", "Hafiften çiseliyor, şemsiye opsiyonel! ☔"),
    RAIN("🌧️", "Yağmurlu", "Şemsiyeni almadan dışarı çıkma, sırılsıklam olursun! ☂️"),
    SNOW("🌨️", "Karlı", "Kartopu savaşı vakti, sıkı giyin! ⛄"),
    RAIN_SHOWERS("🌦️", "Sağanak yağış", "Ani suya yakalanma, koşarak eve git! 🏃‍♂️"),
    SNOW_SHOWERS("🌨️", "Kar sağanağı", "Lapa lapa kar var, salep içmek için harika gün! ☕"),
    THUNDERSTORM("⛈️", "Gök gürültülü fırtına", "Şimşekler çakıyor, elektronikleri kapatıp evde oturma vakti! ⚡"),
    UNKNOWN("🌡️", "Bilinmiyor", "Hava nasıl olursa olsun keyfin yerinde olsun! 😊");

    companion object {
        fun fromWeatherCode(code: Int): WeatherCondition = when (code) {
            0 -> CLEAR
            1 -> MAINLY_CLEAR
            2 -> PARTLY_CLOUDY
            3 -> OVERCAST
            45, 48 -> FOG
            51, 53, 55, 56, 57 -> DRIZZLE
            61, 63, 65, 66, 67 -> RAIN
            71, 73, 75, 77 -> SNOW
            80, 81, 82 -> RAIN_SHOWERS
            85, 86 -> SNOW_SHOWERS
            95, 96, 99 -> THUNDERSTORM
            else -> UNKNOWN
        }
    }
}
