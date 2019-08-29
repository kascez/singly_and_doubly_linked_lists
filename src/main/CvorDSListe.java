package main;

public class CvorDSListe {
	
	public int podatak;

	public CvorDSListe prethodni;

	public CvorDSListe sledeci;

	public CvorDSListe(int p, CvorDSListe pret, CvorDSListe sled) {
		podatak = p;
		prethodni = pret;
		sledeci = sled;
	}

}
