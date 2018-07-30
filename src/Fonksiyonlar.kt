fun main(args: Array<String>) {


    // toplama metoduna değer gönderilir ve sonuclar ekrana basılır.
    println("Main metodu : " + topla(12, 34))

    // ekrana name değerini bastırır.
    println("Merhabalar ${isim("Halil")}")

    // println("Faktoriyel : ${faktoriyelHesapla(5)}")

    // faktoriyeli hesaplanacak eleman alınıyor.
    print("Faktoriyeli hesaplanacak değeri giriniz : ")
    val sayi = readLine()!!.toInt()
    println("$sayi faktoriyeli : ${faktoriyelHesapla(sayi)}")
}

// iki sayının toplamını hesaplayan fonksiyon
fun topla(sayi1: Int, sayi2: Int): Int {

    val toplam: Int = sayi1 + sayi2

    println("Toplam metodu : " + toplam)

    return toplam

}


//isim değerini alan bir fonksiyon
fun isim(ad: String): String {

    val name: String = ad

    return name

}


//faktoriyel hesabının yapıldığı fonksiyon
fun faktoriyelHesapla(num: Int): Int {

    val girilenSayi = num
    var sayac = 1
    var faktoriyel = 1


    while (sayac <= girilenSayi) {
        faktoriyel = faktoriyel * sayac
        sayac++
    }

    return faktoriyel
}