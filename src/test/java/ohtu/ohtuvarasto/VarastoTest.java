package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto kustomoituVarasto;
    Varasto kustomoituLiiantaysiVarasto;
    Varasto miinusVarasto;
    Varasto miinusKustomoituVarasto;
    
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        kustomoituVarasto = new Varasto(20,5);
        kustomoituLiiantaysiVarasto = new Varasto(20,25);
        miinusVarasto = new Varasto(-10);
        miinusKustomoituVarasto = new Varasto(-5,-5);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoMiinusVaraston() {
        assertEquals(0, miinusVarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void miinusVarastollaOikeaTilavuus() {
        assertEquals(0, miinusVarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoKustomiVaraston() {
        assertEquals(5, kustomoituVarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoLiiantaydenKustomiVaraston() {
        assertEquals(20, kustomoituLiiantaysiVarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void kustomiVarastollaOikeaTilavuus() {
        assertEquals(20, kustomoituVarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoMiinusKustomiVaraston() {
        assertEquals(0, miinusKustomoituVarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void miinusKustomiVarastollaOikeaTilavuus() {
        assertEquals(0, miinusKustomoituVarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void yritetaanOttaaEnemmanKuinOn() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(10);

        assertEquals(8, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void yritetaanOttaaEnemmanKuinOnMenikoMiinukselle() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(10);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void yritetaanLaittaaEnemmanKuinMahtuu() {
        varasto.lisaaVarastoon(8);
        
        varasto.lisaaVarastoon(3);

        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void yritetaanLaittaaNegatiivinenMaara() {
        varasto.lisaaVarastoon(8);
        
        varasto.lisaaVarastoon(-3);

        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void yritetaanOttaaNegatiivinenMaara() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(-2);

        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void tekstimuodossaTulostus() {
        varasto.lisaaVarastoon(8);

        assertEquals("saldo = 8.0, vielä tilaa 2.0", varasto.toString());
    }
    
}