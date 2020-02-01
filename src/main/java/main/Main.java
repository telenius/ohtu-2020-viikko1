package main;
import ohtu.ohtuvarasto.*;

public class Main {
    
    private static void varastokokeilu1(Varasto mehua, Varasto olutta){
        
        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);
        
    }

    private static void varastokokeilu2(Varasto mehua, Varasto olutta){
        
        System.out.println("Mehusetterit:");
        System.out.println("Lisätään 50.7");
        mehua.lisaaVarastoon(50.7);
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Otetaan 3.14");
        mehua.otaVarastosta(3.14);
        System.out.println("Mehuvarasto: " + mehua);
        
    }

    private static void varastovirheily1(){
        
        System.out.println("new Varasto(-100.0);");
        Varasto huono = new Varasto(-100.0);
        System.out.println(huono);
        
        System.out.println("new Varasto(100.0, -50.7)");
        huono = new Varasto(100.0, -50.7);
        System.out.println(huono);

    }

    private static void varastovirheily2(Varasto mehua, Varasto olutta){
        
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.lisaaVarastoon(1000.0)");
        olutta.lisaaVarastoon(1000.0);
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.lisaaVarastoon(-666.0)");
        mehua.lisaaVarastoon(-666.0);
        System.out.println("Mehuvarasto: " + mehua);

    }

    private static void varastovirheily3(Varasto mehua, Varasto olutta){
        
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.otaVarastosta(1000.0)");
        double saatiin = olutta.otaVarastosta(1000.0);
        System.out.println("saatiin " + saatiin);
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.otaVarastosta(-32.9)");
        saatiin = mehua.otaVarastosta(-32.9);
        System.out.println("saatiin " + saatiin);
        System.out.println("Mehuvarasto: " + mehua);

    }

    public static void main(String[] args) {

        Varasto mehua = new Varasto(100.0);
        Varasto olutta = new Varasto(100.0, 20.2);
        
        varastokokeilu1(mehua, olutta);
        varastokokeilu2(mehua, olutta);

        System.out.println("Virhetilanteita:");

        varastovirheily1();
        varastovirheily2(mehua, olutta);
        varastovirheily3(mehua, olutta);
        
    }
}
