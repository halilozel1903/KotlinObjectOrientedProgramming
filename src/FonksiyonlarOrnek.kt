import java.util.*

fun main(args: Array<String>) {

    while (true) { // kullanıcı secimleri sonsuza kadar dönecek

        var kullaniciSecim = menuSec() // secim değeri

        if (kullaniciSecim == 5) { // eğer secim 5 ise bitecek.

            break // uygulamayı sonlandır.
        }

        // kullanıcı bunlardan birini secerse bu islemleri yap.
        if (kullaniciSecim in 1..4) {

            // birinci sayıyı al
            print("Birinci sayıyı giriniz : ")
            var sayi1 = readLine()!!.toInt()

            // ikinci sayıyı al
            print("İkinci sayıyı giriniz : ")
            var sayi2 = readLine()!!.toInt()


            // kullanıcı secimlerini karşılaştır.
            when (kullaniciSecim) {

                1 -> toplama(sayi1, sayi2) // topla
                2 -> cikarma(sayi1, sayi2) // cikar
                3 -> carpma(sayi1, sayi2) // carp
                4 -> bolme(sayi1, sayi2) // bol


                else -> { // baska bir değer ise
                    println("Hatalı giriş yaptınız !!!") // hata
                }
            }

        }


    }


}

// bolme metodu
fun bolme(sayi1: Int, sayi2: Int) {

    if (sayi2 != 0) {
        println("Sayıların bolumu : ${sayi1 / sayi2}")

    } else {
        println("Bölünen sayı sıfır olamaz !!")
    }


}

// carpma metodu
fun carpma(sayi1: Int, sayi2: Int) {
    println("Sayıların carpımı : ${sayi1 * sayi2}")
}

// çikarma metodu
fun cikarma(sayi1: Int, sayi2: Int) {
    println("Sayıların cikarimi : ${sayi1 - sayi2}")
}

// toplama metodu
fun toplama(sayi1: Int, sayi2: Int) {

    println("Sayıların toplamı : ${sayi1 + sayi2}")
}


// mini hesap makinesi için menu olusturuldu.
fun menuSec(): Int {

    var tarih = tarihGoster()

    println("----------- MENU  $tarih ------------")
    println("1 - Topla")
    println("2 - Çıkar")
    println("3 - Çarp")
    println("4 - Böl")
    println("5 - Cikis")

    print("Seçiminiz :") // secim

    var secim = readLine()!!.toInt() // kullanıcının secimi

    return secim // secim geriye donduruluyor.

}

fun tarihGoster(): String {

    val calendar = Calendar.getInstance()
    var saat = calendar.get(Calendar.HOUR)
    var dakika = calendar.get(Calendar.MINUTE)
    var saniye = calendar.get(Calendar.SECOND)

    return "$saat:$dakika:$saat"
}
