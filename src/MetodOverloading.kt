


fun main(args: Array<String>) {


    toplam(12,34)
    toplam(1,3,4)
    toplam(9,8,7,6)

    toplamlar(1,2,3,4,5,6)

    toplam(1.2,3.4)

    var sayilarDizisi = arrayOf(1,2,3,4,5,6,7,8,9,10)

    toplam(sayilarDizisi)
}

// array tipinde bir overload metod tanımlandı.
fun toplam(sayilarDizisi: Array<Int>) {

    var toplam = 0

    for (sayi in sayilarDizisi){
        toplam+=sayi
    }
    println("Toplamı : $toplam")

}

// metod overloading : metod isimleri aynı parametre sayıları ya da parametre tipleri farklı

fun toplam(n1:Int,n2:Int){
    println("toplamları : ${n1+n2}")
}

fun toplam(n1:Double,n2:Double){
    println("toplamları : ${n1+n2}")
}

fun toplam(n1:Int,n2:Int,n3:Int){
    println("toplamları : ${n1+n2+n3}")
}


fun toplam(n1:Int,n2:Int,n3:Int,n4:Int){
    println("toplamları : ${n1+n2+n3+n4}")
}

// vararg :  herhangibir koşul bildirmeden istenildiği kadar sayı ile işlem yapılabilir.

fun toplamlar(vararg n5:Int){

    var toplam = 0

    for (top in n5){ // sanki bir dizi gibi davranır ve toplama işlemleri yapılır.
        toplam += top
    }

    println("Toplamlar : $toplam")
}