package hr.unidu.kz.pokemoni_recyclerview;
// pomoćna POJO klasa koja čuva podatke o jednom Pokemonu
public class Pokemon {
    private String ime;
    private String slika;
    private String vrsta;
    public Pokemon(String i, String v){
        ime = i;
        slika = i.toLowerCase();
        vrsta = v;
    }
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String toString(){
        return ime + ":" + vrsta;
    }
}
