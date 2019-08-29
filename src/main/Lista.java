package main;

import java.nio.channels.NetworkChannel;

public class Lista {
	
	CvorJSListe prvi;
	
	public void ubaciNaPocetak(int podatak) {
		prvi = new CvorJSListe(podatak, prvi);
	}
	
	public void izbaciTrenutni(CvorJSListe trenutni) {
		if (trenutni == null) {
			return;
		}
		if (trenutni == prvi) {
			prvi = prvi.sledeci;
			return;
		}
		CvorJSListe pom = prvi;
		while (pom.sledeci != trenutni) {
			pom = pom.sledeci;
		}
		pom.sledeci = trenutni.sledeci;
	}
	
	public void sortiranje() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorJSListe pom = prvi;
		while (pom.sledeci != null) {
			boolean sorted = false;
			if (prvi.podatak > prvi.sledeci.podatak) {
				CvorJSListe pom1 = prvi.sledeci.sledeci;
				CvorJSListe pom2 = prvi.sledeci;
				prvi.sledeci = pom1;
				pom2.sledeci = prvi;
				prvi = pom2;
				sorted = true;
			}
			if (pom.sledeci != null && pom.sledeci.sledeci != null) {
				CvorJSListe pom1 = pom.sledeci.sledeci;
				CvorJSListe pom2 = pom.sledeci;
				if (pom2.podatak > pom1.podatak) {
					pom2.sledeci = pom1.sledeci;
					pom1.sledeci = pom2;
					pom.sledeci = pom1;
					sorted = true;
				}
			}
			if (sorted == true) {
				pom = prvi;
			} else {
				pom = pom.sledeci;
			}
		}
	}
	
	public void sortiranjeSelection() {
		if (prvi == null && prvi.sledeci == null) {
			return;
		}
		CvorJSListe min = prvi;
		CvorJSListe minPrethodni = null;
		CvorJSListe pom = prvi;
		CvorJSListe pratiPom = null;
		CvorJSListe tek = prvi;
		while (pom != null) {
			//NIJE DOBRO
		}
	}
	
	public void ispisi() {
		CvorJSListe pom = prvi;
		while (pom != null) {
			System.out.print(pom.podatak + " ");
			pom = pom.sledeci;
		}
		System.out.println();
	}
	
	public int[] pretvoriListuUNiz(CvorJSListe prvi) {
		int n = 0;
		CvorJSListe pom = prvi;
		if (prvi == null) {
			return null;
		}
		while (pom != null) {
			n++;
			pom = pom.sledeci;
		}
		pom = prvi;
		int[] niz = new int[n];
		for (int i = 0; i < niz.length; i++) {
			niz[i] = pom.podatak;
			pom = pom.sledeci;
		}
		return niz;
	}
	
	public void ubaciNaKraju(int podatak) {
		CvorJSListe novi = new CvorJSListe(podatak, null);
		CvorJSListe pom = prvi;
		if (prvi == null) {
			prvi = new CvorJSListe(podatak, prvi);
		} else {
			while (pom.sledeci != null) {
				pom = pom.sledeci;
			}
			pom.sledeci = novi; // nemo zaboravit ovo ko sto vazda zaboravis
		}
		
	}
	
	private int brojPozitivnihElemenataRekurzivno(CvorJSListe prvi) {
		if (prvi == null) {
			return 0;
		}
		if (prvi.podatak > 0) {
			return 1 + brojPozitivnihElemenataRekurzivno(prvi.sledeci);
		} else {
			return brojPozitivnihElemenataRekurzivno(prvi.sledeci);
		}
	}
	
	public int pozivOveGore() {
		if (prvi == null) {
			return -1;
		}
		return brojPozitivnihElemenataRekurzivno(prvi);
	}
	
	public boolean daLiJeUListi(CvorJSListe glava, int podatak) {
		CvorJSListe pom = glava;
		while (pom != null) {
			if (pom.podatak == podatak) {
				return true;
			}
			pom = pom.sledeci;
		}
		return false;
	}
	
	public void izbaciDrugiITreciOdKraja() {
		CvorJSListe pom = prvi;
		while (pom.sledeci != null) {
			if (pom.sledeci.sledeci != null) {
				if (pom.sledeci.sledeci.sledeci != null) {
					if (pom.sledeci.sledeci.sledeci.sledeci == null) {
						pom.sledeci = pom.sledeci.sledeci.sledeci;
					}
				} else {
					prvi = pom.sledeci.sledeci;
				}
			}
			pom = pom.sledeci;
		}
	}
	
	public void unakrsno(CvorJSListe glava) {
		CvorJSListe pom = prvi;
		CvorJSListe pom1 = pom;
		CvorJSListe pom2 = glava;
		while (pom.sledeci != null) {
			pom1 = pom1.sledeci;
			if (pom2 == null) {
				while (pom.sledeci != null) {
					pom = pom.sledeci;
				}
				break;
			}
			pom.sledeci = pom2;
			pom2 = pom2.sledeci;
			pom = pom.sledeci;
			if (pom1 == null) {
				while (pom.sledeci != null) {
					pom = pom.sledeci;
				}
				break;
			}
			pom.sledeci = pom1;
			pom = pom.sledeci;
		}
		pom.sledeci = pom2;
	}
	
	public void invertovanjeBezPomocne() throws Exception {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorJSListe tek = prvi;
		CvorJSListe pom = prvi;
		
		while (pom.sledeci != null) {
			 tek = pom.sledeci;
			 pom.sledeci = tek.sledeci;
			 tek.sledeci = prvi;
			 prvi = tek; 
		}
	}
	
	public int vratiElementUSredini() {
		if (prvi == null || prvi.sledeci == null) {
			return prvi.podatak;
		}

		CvorJSListe spori = prvi;
		CvorJSListe brzi = prvi;

		while (brzi.sledeci != null && brzi.sledeci.sledeci != null) {
			brzi = brzi.sledeci.sledeci; // jako korisna
			spori = spori.sledeci;       // fora za koristit
		}

		return spori.podatak;
	}
	
	public void invertovanaNeopadajucaBezDuplikata() { // ne radi dobro za zadnji element RADI OPET
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorJSListe tek = prvi;
		CvorJSListe pom = prvi;
		while (pom.sledeci != null) {
			if (tek.podatak == tek.sledeci.podatak) {
				tek.sledeci = tek.sledeci.sledeci; //ni slucajno ne pomjerat 'pom' odje, nece povezati zadnji broj, iako mozda djeluje nebitno da li cemo ga pomjeriti
			} else {
				tek = pom.sledeci;
				pom.sledeci = tek.sledeci;
				tek.sledeci = prvi;
				prvi = tek;
			}
		}
	}
	
	public int brojPojavljivanjaDoCvora(int broj, int podatak) {
		int brojac = 0;
		CvorJSListe pom = prvi;
		while (broj >= 0) {
			if (pom.podatak == podatak) {
				brojac++;
			}
			broj--;
			pom = pom.sledeci;
		}
		return brojac;
	}
	
	public void invertovanaNeopadajucaBezDuplikata2() {
		if (prvi == null) {
			return;
		}
		CvorJSListe tek = prvi;
		CvorJSListe pom = prvi;
		while (pom.sledeci != null) {
			if (tek.podatak == tek.sledeci.podatak) {
				tek.sledeci = tek.sledeci.sledeci;
			} else {
				tek = pom.sledeci;
				pom.sledeci = tek.sledeci;
				if (tek.sledeci == null && tek.podatak == prvi.podatak) {
					return;
				}
				tek.sledeci = prvi;
				prvi = tek;
			}
		}
	}
	
	public void izbaciDuplikate() {
		CvorJSListe pom = prvi;
		int broj = 1;
		while (pom.sledeci != null) {
			if (brojPojavljivanjaDoCvora(broj, pom.sledeci.podatak) > 1) {
				pom.sledeci = pom.sledeci.sledeci;
			} else {
				pom = pom.sledeci;
				broj++;
			}
		}
	}
	
	public void izbaciDuplikatePonovo() {
		if (prvi == null) {
			return;
		}
		CvorJSListe prethodni = prvi;
		CvorJSListe pom = prvi;
		CvorJSListe unutrasnji = prvi;
		while (prethodni != null) {
			unutrasnji = prethodni;
			while (unutrasnji.sledeci != null) {
				pom = unutrasnji.sledeci;
				if (prethodni.podatak == pom.podatak) {
					unutrasnji.sledeci = pom.sledeci;
				} else {
					unutrasnji = unutrasnji.sledeci;
				}
			}
			prethodni = prethodni.sledeci;
		}
	}
	
	public void izbaciDuplikate101() {
		CvorJSListe prethodni = prvi;
		CvorJSListe pomocni = prvi;
		CvorJSListe unutrasnji = prvi;
		while (prethodni != null) {
			unutrasnji = prethodni;
			while (unutrasnji.sledeci != null) {
				pomocni = unutrasnji.sledeci;
				if (pomocni.podatak == prethodni.podatak) {
					unutrasnji.sledeci = pomocni.sledeci;
				} else {
					unutrasnji = unutrasnji.sledeci;
				}
			}
			prethodni = prethodni.sledeci;
		}
	}
	
	public void izbaciDuplikate2() { //nah nije dobro gledaj ovu gore
		CvorJSListe pom = prvi;
		CvorJSListe pret = prvi;
		CvorJSListe unutrasnji = prvi;
		while (pret.sledeci != null) {
			unutrasnji = pret.sledeci;
			while (unutrasnji.sledeci != null) {
				pom = unutrasnji.sledeci;
				if (pret.podatak == pom.podatak) {
					unutrasnji.sledeci = pom.sledeci;
				} else {
					unutrasnji = unutrasnji.sledeci;
				}
			}
			pret = pret.sledeci; //bio sam pametniji kad sam pisao ovo, nzm zasto radi
		}
	}
	
	public void napraviTrecu(CvorJSListe jedna, CvorJSListe druga) {
		CvorJSListe pom1 = jedna;
		CvorJSListe pom2 = druga;
		while (pom1 != null) {
			if (daLiJeUListi(prvi, pom1.podatak) == false) {
				prvi = new CvorJSListe(pom1.podatak, prvi);
			}
			pom1 = pom1.sledeci;
		}
		while (pom2 != null) {
			if (daLiJeUListi(prvi, pom2.podatak) == false) {
				prvi = new CvorJSListe(pom2.podatak, prvi);
			}
			pom2 = pom2.sledeci;
		}
	}
	
	public void izbaciVeceOdPredhodnika() {
		CvorJSListe pom = prvi;
		CvorJSListe pret = prvi;
		while (pom.sledeci != null) {
			pom = pom.sledeci;
			if (pret.podatak < pom.podatak) {
				pret.sledeci = pom.sledeci;
			} else {
				pret = pret.sledeci;
			}
		}
	}
	
	public int neparanBrojNeparnih(CvorJSListe jedna) {
		int brojac = 0;
		CvorJSListe pom = jedna;
		if (pom == null) {
			return 0;
		} else {
			if (pom.podatak % 2 == 1) {
				brojac++;
			}
		}
		return brojac + neparanBrojNeparnih(pom.sledeci);
	}
	
	public void invertujBezPomocne2() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorJSListe pom = prvi;
		CvorJSListe tek = prvi;
		while (pom.sledeci != null) {
			tek = pom.sledeci;
			pom.sledeci = tek.sledeci;
			tek.sledeci = prvi;
			prvi = tek;
		}
	}
	
	public void invertujSaPomocnom() {
		if (prvi == null || prvi.sledeci == null) {
			throw new RuntimeException("Bang");
		}
		CvorJSListe nova = null;
		
		CvorJSListe pom = prvi;
		while (pom != null) {
			nova = new CvorJSListe(pom.podatak, nova);
			pom = pom.sledeci;
		}
		prvi = nova;
	}
	
	public int prebrojVeceOdPrvog() {
		if (prvi == null) {
			return -1;
		}
		int brojac = 0;
		CvorJSListe pom = prvi.sledeci;
		while (pom != null) {
			if (pom.podatak > prvi.podatak) {
				brojac++;
			}
			pom = pom.sledeci;
		}
		return brojac;
	}
	
	public int frekvencija(int podatak) {
		if (prvi == null) {
			return -1;
		}
		int brojac = 0;
		CvorJSListe pom = prvi;
		while (pom != null) {
			if (pom.podatak == podatak) {
				brojac++;
			}
			pom = pom.sledeci;
		}
		return brojac;
	}
	
	public void izbaciElementNakonNajmanjeg() {
		if (prvi == null) {
			return;
		}
		CvorJSListe pom = prvi;
		CvorJSListe min = prvi;
		while (pom != null) {
			if (pom.podatak < min.podatak) {
				min = pom;
			}
			pom = pom.sledeci;
		}
		min.sledeci = min.sledeci.sledeci;
	}
	
	public int brojPozitivnihElemenataRek(CvorJSListe prvi) {
		if (prvi == null) {
			return -1;
		}
		if (prvi.podatak > 0) {
			return 1 + brojPozitivnihElemenataRek(prvi.sledeci);
		} else {
			return brojPozitivnihElemenataRek(prvi.sledeci);
		}
	}
	
	public int[] napraviNizOdListe() {
		int n = 0;
		CvorJSListe pom = prvi;
		while (pom != null) {
			n++;
			pom = pom.sledeci;
		}
		pom = prvi;
		int[] niz = new int[n];
		for (int i = 0; i < niz.length; i++) {
			niz[i] = pom.podatak;
			pom = pom.sledeci;
		}
		return niz;
	}
	
	public boolean postojiElement(CvorJSListe prvi, int element) {
		if (prvi == null) {
			return false;
		}
		CvorJSListe pom = prvi;
		while (pom != null) {
			if (pom.podatak == element) {
				return true;
			}
			pom = pom.sledeci;
		}
		return false;
	}
	
	public CvorJSListe unija(CvorJSListe prvi, CvorJSListe drugi) {
		if (prvi == null && drugi == null) {
			return null;
		}
		CvorJSListe nova = null;
		while (prvi != null) {
			if (!postojiElement(nova, prvi.podatak)) {
				nova = new CvorJSListe(prvi.podatak, nova);
			}
			prvi = prvi.sledeci;
		}
		while (drugi != null) {
			if (!postojiElement(nova, drugi.podatak)) {
				nova = new CvorJSListe(drugi.podatak, nova);
			}
			drugi = drugi.sledeci;
		}
		return nova;
	}
	
	public void ubaciPoslePredhodnikaCijiJeZbirVeciOdElementa(int podatak) {
		if (prvi == null) {
			prvi = new CvorJSListe(podatak, null);
			return;
		}
		if (prvi.sledeci == null) {
			CvorJSListe novi = new CvorJSListe(podatak, null);
			prvi.sledeci = novi;
			return;
		}
		CvorJSListe pom = prvi;
		int suma = 0;
		while (pom.sledeci != null) {
			suma += pom.podatak;
			if (suma > podatak) {
				CvorJSListe novi = new CvorJSListe(podatak, pom.sledeci);
				pom.sledeci = novi;
				return;
			}
			pom = pom.sledeci;
		}
		CvorJSListe novi = new CvorJSListe(podatak, null);
		pom.sledeci = novi;
	}
	
	public CvorJSListe klonirajRekurzivno(CvorJSListe prvi) {
		if (prvi == null) {
			return null;
		}
		return new CvorJSListe(prvi.podatak, klonirajRekurzivno(prvi.sledeci));
	}
	
	public void ispisiObrnuto(CvorJSListe prvi) {
		if (prvi == null) {
			return;
		}
		ispisiObrnuto(prvi.sledeci);
		System.out.print(prvi.podatak + " ");
	}
	
	public void invertujSaPomocnom2() {
		if (prvi == null) {
			return;
		}
		if (prvi.sledeci == null) {
			return;
		}
		CvorJSListe pom = prvi;
		CvorJSListe novi = null;
		while (pom != null) {
			novi = new CvorJSListe(pom.podatak, novi);
			pom = pom.sledeci;
		}
		prvi = novi;
	}
	
	public CvorJSListe pozivKloniranja() {
		CvorJSListe novi = klonirajRekurzzivno(prvi);
		return novi;
	}
	
	private CvorJSListe klonirajRekurzzivno(CvorJSListe prvi) {
		if (prvi == null) {
			return null;
		}
		return new CvorJSListe(prvi.podatak, klonirajRekurzivno(prvi.sledeci));
	}
	
	public boolean fibonaci() {
		if (prvi == null) {
			return true;
		}
		CvorJSListe pom = prvi;
		while (pom.sledeci.sledeci != null) {
			if (pom.podatak + pom.sledeci.podatak != pom.sledeci.sledeci.podatak) {
				return false;
			}
			pom = pom.sledeci;
		}
		return true;
	}
	
	public boolean postojiElement1(CvorJSListe prvi, int element) {
		if (prvi == null) {
			return false;
		}
		CvorJSListe pom = prvi;
		while (pom != null) {
			if (pom.podatak == element) {
				return true;
			}
			pom = pom.sledeci;
		}
		return false;
	}
	
	public CvorJSListe simetricnaRazlikaDvijeListe(CvorJSListe prva, CvorJSListe druga) {
		CvorJSListe nova = null;
		CvorJSListe pom = prva;
		while (pom != null) {
			if (!postojiElement1(druga, pom.podatak) && !postojiElement(nova, pom.podatak)) {
				nova = new CvorJSListe(pom.podatak, nova);
			}
			pom = pom.sledeci;
		}
		pom = druga;
		while (pom != null) {
			if (!postojiElement1(prva, pom.podatak) && !postojiElement(nova, pom.podatak)) {
				nova = new CvorJSListe(pom.podatak, nova);
			}
			pom = pom.sledeci;
		}
		return nova;
	}
	
	public CvorJSListe invertovanjeNeopadajuceBezDuplikata() {
		CvorJSListe pom = prvi;
		CvorJSListe novi = null;
		while (pom != null) {
			if (pom.sledeci == null) {
				novi = new CvorJSListe(pom.podatak, novi);
				break;
			}
			if (pom.podatak == pom.sledeci.podatak) {
				
			} else {
				novi = new CvorJSListe(pom.podatak, novi);
			}
			pom = pom.sledeci;
		}
		return novi;
	}
	
	public int zbirElemenataCiklicna() {
		if (prvi == null) {
			throw new RuntimeException("Bang");
		}
		int zbir = prvi.podatak;
		CvorJSListe pom = prvi.sledeci;
		while (pom != prvi) {
			zbir += pom.podatak;
			pom = pom.sledeci;
		}
		return zbir;
	}
	
	public void sortiraj() {
		if (prvi == null && prvi.sledeci == null) {
			return;
		}
		CvorJSListe pom = prvi;
		boolean sorted = false;
		while (pom.sledeci != null) {
			sorted = false;
			if (prvi.podatak > prvi.sledeci.podatak) {
				CvorJSListe pom1 = prvi.sledeci;
				CvorJSListe pom2 = prvi.sledeci.sledeci;
				pom1.sledeci = prvi;
				prvi.sledeci = pom2;
				prvi = pom1;
				sorted = true;
			}
			if (pom.sledeci != null && pom.sledeci.sledeci != null) {
				CvorJSListe pom1 = prvi.sledeci;
				CvorJSListe pom2 = prvi.sledeci.sledeci;
				if (pom1.podatak > pom2.podatak) {
					pom.sledeci = pom2;
					pom1.sledeci = pom2.sledeci;
					pom2.sledeci = pom1;
					sorted = true;
				}
			}
			if (sorted) {
				pom = prvi;
			} else {
				pom = pom.sledeci;
			}
		}
	}
	
	public void sortirajNzmKojiPut() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorJSListe pom = prvi;
		boolean sorted = false;
		while (pom.sledeci != null) {
			sorted = false;
			if (prvi.podatak > prvi.sledeci.podatak) {
				CvorJSListe pom1 = prvi.sledeci;
				CvorJSListe pom2 = prvi.sledeci.sledeci;
				prvi.sledeci = pom2;
				pom1.sledeci = prvi;
				prvi = pom1;
				sorted = true;
			}
			if (pom.sledeci != null && pom.sledeci.sledeci != null) {
				CvorJSListe pom1 = pom.sledeci;
				CvorJSListe pom2 = pom.sledeci.sledeci;
				if (pom1.podatak > pom2.podatak) {
					pom.sledeci = pom2;
					pom1.sledeci = pom2.sledeci;
					pom2.sledeci = pom1;
					sorted = true;
				}
			}
			if (sorted) {
				pom = prvi;
			} else {
				pom = pom.sledeci;
			}
		}
	}
	
	public void izbaciSvakiTreci() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorJSListe pom = prvi;
		while (pom != null && pom.sledeci != null && pom.sledeci.sledeci != null) {
			pom = pom.sledeci;
			pom.sledeci = pom.sledeci.sledeci;
			pom = pom.sledeci;
		}
	}
	
	public void ubaciPrijePrvogVeceg(int podatak) {
		if (prvi == null || podatak < prvi.podatak) {
			CvorJSListe novi = new CvorJSListe(podatak, prvi);
			prvi = novi;
			return;
		}
		CvorJSListe pom = prvi;
		CvorJSListe novi = new CvorJSListe(podatak, null);
		while (pom.sledeci != null && pom.sledeci.podatak < podatak) {
			pom = pom.sledeci;
		}
		novi.sledeci = pom.sledeci;
		pom.sledeci = novi;
	}
	
	public void prosliKlkPrvi() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorJSListe pom = prvi;
		while (pom.sledeci != null) {
			if (pom.podatak == pom.sledeci.podatak) {
				pom.sledeci = pom.sledeci.sledeci;
			} else {
				pom = pom.sledeci;
			}
		}
	}
	
	public int sumaSvihKojiSuVeciOdSvojihPrethodnika() {
		if (prvi == null) {
			return -1;
		}
		if (prvi.sledeci == null) {
			return prvi.podatak;
		}
		CvorJSListe pom = prvi;
		CvorJSListe max = prvi;
		int suma = 0;
		while (pom != null) {
			if (pom.podatak > max.podatak) {
				suma += pom.podatak;
				max = pom;
			}
			pom = pom.sledeci;
		}
		return suma;
	}
	
	public void izbaciSveManjeOdZadatog(int element) {
		if (prvi == null) {
			return;
		}
		while (prvi.podatak < element) {
			prvi = prvi.sledeci;
			if (prvi == null) {
				return;
			}
		}
		CvorJSListe pom = prvi;
		while (pom.sledeci != null) {
			if (pom.sledeci.podatak < element) {
				pom.sledeci = pom.sledeci.sledeci;
			} else {
				pom = pom.sledeci;
			}
		}
	}
	
	public static void main(String[] args) {
		Lista l = new Lista();
		Lista l2 = new Lista();
		l.ubaciNaKraju(2);
		l.ubaciNaKraju(1);
		l2.ubaciNaKraju(3);
		l2.ubaciNaKraju(3);
		l2.ubaciNaKraju(3);
		l.unakrsno(l2.prvi);
		l.ispisi();
	}

}
