package main;

public class ListaDS {
	
	CvorDSListe prvi;
	
	public void ubaciNaPocetak(int podatak) {
		prvi = new CvorDSListe(podatak, null, prvi);
		if (prvi.sledeci != null) {
			prvi.sledeci.prethodni = prvi;
		}
	}
	
	public void ubaciNaKraju(int podatak) {
		CvorDSListe novi = new CvorDSListe(podatak, null, null); // kad bi ovo moglo drugacije :(
		CvorDSListe pom = prvi;
		if (prvi == null) {
			prvi = novi;
		} else {
			while (pom.sledeci != null) {
				pom = pom.sledeci;
			}
			novi.prethodni = pom;
			novi.podatak = podatak;
			pom.sledeci = novi;
		}
	}
	
	public void ispisiObrnuto() {
		CvorDSListe pom = prvi;
		while (pom.sledeci != null) {
			pom = pom.sledeci;
		}
		while (pom != null) {
			System.out.print(pom.podatak + " ");
			pom = pom.prethodni;
		}
		System.out.println();
	}
	
	public void ispisiObrnuto(CvorDSListe pom) {
		if (pom == null) {
			return;
		}
		ispisiObrnuto(pom.sledeci);
		System.out.println(pom.podatak);
	}
	
	public void ispisi() {
		CvorDSListe pom = prvi;
		while (pom != null) {
			System.out.print(pom.podatak + " ");
			pom = pom.sledeci;
		}
		System.out.println();
	}
	
	public void ubaciNakonStoJeVeciOdSumePrethodnih(int podatak) {
		if (prvi == null) {
			CvorDSListe novi = new CvorDSListe(podatak, null, prvi);
			if (novi.sledeci != null) {
				novi.sledeci.prethodni = novi;
			}
			prvi = novi;
			return;
		}
		CvorDSListe pom = prvi;
		int suma = prvi.podatak;
		while (pom.sledeci != null) {
			if (suma < podatak) {
				CvorDSListe novi = new CvorDSListe(podatak, pom, pom.sledeci);
				pom.sledeci = novi;
				if (novi.sledeci != null) {
					novi.sledeci.prethodni = novi;
				}
				return;
			}
			suma = suma + pom.sledeci.podatak;
			pom = pom.sledeci;
		}
		CvorDSListe novi = new CvorDSListe(podatak, pom, null);
		pom.sledeci = novi;
	}
	
	public int proizvodNeparnih() {
		int proizvod = -1;
		CvorDSListe pom = prvi;
		pom = prvi.sledeci;
		while (pom.sledeci != null) {
			if (pom.podatak % 2 == 1 && pom.sledeci.podatak % 2 == 0 && pom.prethodni.podatak % 2 == 0) {
				proizvod *= pom.podatak;
			}
			pom = pom.sledeci;
		}
		return proizvod; //moze rekurzivno isto
	}
	
	public int proizvodNeparnihRekurzivno(CvorDSListe prvi2) {
		if (prvi2 == null) {
			return 1;
		}
		if (prvi2.podatak % 2 == 1) {
			return prvi2.podatak * proizvodNeparnihRekurzivno(prvi2.sledeci);
		}
		return 1 * proizvodNeparnihRekurzivno(prvi2.sledeci);
	}
	
	public int brojParnihNaParnimPozicijamaRekurzivno(CvorDSListe prvi) {
		int brojac = 0;
		CvorDSListe pom = prvi;
		if (pom == null) {
			return 0;
		}
		if (pom.podatak % 2 == 0) {
			brojac++;
		}
		if (prvi.sledeci == null) { //provjeravamo zadnji element jer se ne moze preskakati za dva mjestaa
			if (prvi.podatak % 2 == 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return brojac + brojParnihNaParnimPozicijamaRekurzivno(prvi.sledeci.sledeci);
		}
	}
	
	double prosjekPozitivnihElemenata() {
		if (prvi == null) {
			return -1;
		}
		int suma = 0;
		int brojac = 0;
		CvorDSListe pom = prvi;
		while (pom != null) {
			if (pom.podatak > 0) {
				suma = suma + pom.podatak;
				brojac++;
			}
			pom = pom.sledeci;
		}
		if (brojac == 0) {
			return -1;
		}
		double prosjek = (double) suma / brojac;
		return prosjek;
	}
	
	public void invertovanjeDSliste() {
		CvorDSListe nova = null;
		CvorDSListe pom = prvi;
		while (pom != null) {
			nova = new CvorDSListe(pom.podatak, null, nova);
			if (nova.sledeci != null) {
				nova.sledeci.prethodni = nova;
			}
			pom = pom.sledeci;
		}
		prvi = nova;
	}
	
	public CvorDSListe vratiPokazivacNaPrviElementUCiklicnojSortiranoj() {
		if (prvi == null || (prvi.sledeci == prvi && prvi.prethodni == prvi)) {
			return prvi;
		}
		CvorDSListe pom = prvi;
		while (pom.sledeci.podatak > pom.podatak && pom.prethodni.podatak < pom.podatak) {
			pom = pom.sledeci;
		}
		return pom.sledeci;
	}
	
	public int brojParnihNaParnimPozicijama() {
		int brojac = 0;
		int brojNeparnih = 0;
		CvorDSListe pom = prvi;
		while (pom != null) {
			if (brojac % 2 == 0) { // znaci da je parna pozicija
				if (pom.podatak % 2 == 0) {
					brojNeparnih++;
				}
			}
			pom = pom.sledeci;
			brojac++;
		}
		return brojNeparnih;
	}
	
	/*
	
	public void sortiranjeRekurzivno(CvorDSListe cvorZaUbacit, int brojac) {
		if (cvorZaUbacit == null) {
			return;
		}
		CvorDSListe pom = prvi;
		CvorDSListe pom1 = prvi;
		CvorDSListe nzm1 = null;
		CvorDSListe nzm2 = null;
		int prevezan = 0;
		int pomjeraj = brojac;
		while (pomjeraj > 0) {
			if (pom1.sledeci.podatak > cvorZaUbacit.podatak) {
				if (condition) {
					
				}
			}
			pom1 = pom1.sledeci;
		}
		
	} */
	
	public void izbaciDuplikate() {
		if (prvi == null) {
			System.out.println("jbg");
		}
		CvorDSListe pom = prvi;
		CvorDSListe prethodni = prvi;
		CvorDSListe unutrasnji = prvi;
		while (prethodni.sledeci != null) {
			pom = prethodni;
			while (pom.sledeci != null) {
				unutrasnji = pom.sledeci;
				if (unutrasnji.podatak == prethodni.podatak) {
					unutrasnji.prethodni.sledeci = unutrasnji.sledeci;
					if (unutrasnji.sledeci != null) {
						unutrasnji.sledeci.prethodni = unutrasnji.prethodni;
					}
				} else {
					pom = pom.sledeci;
				}
			}
			prethodni = prethodni.sledeci;
		}
	}
	
	public void zamjeniPozicijePrvaDvaDS() {
		CvorDSListe jedan = prvi;
		CvorDSListe dva = prvi.sledeci;
		jedan.sledeci = dva.sledeci;
		dva.sledeci = jedan;
		dva.prethodni = null;
		jedan.sledeci.prethodni = jedan;
		prvi = dva; // bez ovoga ne radi, mora se 'prvi' staviti odje inace ce ispisati samo 'jedan'
	}
	
	public void prvoParniPaNeparni() {
		CvorDSListe pom = prvi.sledeci;
		CvorDSListe pom2 = prvi.sledeci;
		while (pom != null) {
			if (pom.podatak % 2 == 0) {
				pom2 = pom.sledeci;
				pom.prethodni.sledeci = pom.sledeci;
				if (pom.sledeci != null) {
					pom.sledeci.prethodni = pom.prethodni;
				}
				pom.prethodni = null;
				pom.sledeci = prvi;
				pom.sledeci.prethodni = pom;
				prvi = pom;
				pom = pom2;
			} else {
				pom = pom.sledeci;
			}
		}
	}
	
	public CvorDSListe dvijeUJednuSortiranu(CvorDSListe jedna, CvorDSListe druga) {
		CvorDSListe pom1 = jedna;
		CvorDSListe pom2 = druga;
		CvorDSListe novi = null;
		while (pom1 != null && pom2 != null) {
			if (pom1.podatak <= pom2.podatak) {
				novi = new CvorDSListe(pom1.podatak, null, novi);
				if (novi.sledeci != null) {
					novi.sledeci.prethodni = novi;
				}
				pom1 = pom1.sledeci;
			} else {
				novi = new CvorDSListe(pom2.podatak, null, novi);
				if (novi.sledeci != null) {
					novi.sledeci.prethodni = novi;
				}
				pom2 = pom2.sledeci;
			}
			if (pom1 == null) {
				while (pom2 != null) {
					novi = new CvorDSListe(pom2.podatak, null, novi);
					novi.sledeci.prethodni = novi;
					pom2 = pom2.sledeci;
				}
			}
			if (pom2 == null) {
				while (pom1 != null) {
					novi = new CvorDSListe(pom1.podatak, null, novi);
					novi.sledeci.prethodni = novi;
					pom1 = pom1.sledeci;
				}
			}
		}
		return novi;
	}
	
	public void sumaLijevoDesno() {
		CvorDSListe pom = prvi;
		CvorDSListe max = new CvorDSListe(0, null, null);
		int sumaL;
		int sumaD;
		int maxRazlikeSuma = 0;
		while (pom != null) {
			sumaL = 0;
			sumaD = 0;
			CvorDSListe pomL = pom.prethodni;
			CvorDSListe pomD = pom.sledeci;
			if (pomL != null && pomD != null) {
				while (pomL != null) {
					sumaL += pomL.podatak;
					pomL = pomL.prethodni;
				}
				while (pomD != null) {
					sumaD += pomD.podatak;
					pomD = pomD.sledeci;
				}
				if (sumaL - sumaD > maxRazlikeSuma) {
					max = pom;
				}
			}
			pom = pom.sledeci;
		}
		System.out.println("Element na kojem je pokazivac je " + max.podatak);
	}
	
	public void maxCvorNaPocetku() {
		if (prvi == null) {
			throw new RuntimeException("bang");
		}
		CvorDSListe pom = prvi;
		CvorDSListe max = prvi;
		while (pom != null) {
			if (pom.podatak > max.podatak) {
				max = pom;
			}
			pom = pom.sledeci;
		}
		if (max == null || max == prvi) {
			return;
		}
		if (max.sledeci != null) {
			max.sledeci.prethodni = max.prethodni;
		}
		max.prethodni.sledeci = max.sledeci;
		max.prethodni = null;
		max.sledeci = prvi;
		prvi.prethodni = max;
		prvi = max;
	}
	
	public boolean praznaLista() {
		return prvi == null;
	}
	
	public void ispisiListu() {
		if (prvi == null) {
			return;
		}
		CvorDSListe pom = prvi;
		while (pom != null) {
			System.out.println(pom.podatak);
			pom = pom.sledeci;
		}
	}
	
	public void ubaciUSortiranu(int podatak) {
		if (prvi == null || prvi.podatak > podatak) {
			CvorDSListe novi = new CvorDSListe(podatak, null, prvi);
			prvi = novi;
			if (prvi.sledeci != null) {
				prvi.sledeci.prethodni = prvi;
			}
			return;
		}
		CvorDSListe pom = prvi;
		while (pom.sledeci != null && pom.sledeci.podatak < podatak) {
			pom = pom.sledeci;
		}
		CvorDSListe novi = new CvorDSListe(podatak, pom, pom.sledeci);
		novi.prethodni.sledeci = novi;
		if (novi.sledeci != null) {
			novi.sledeci.prethodni = null;
		}
		
	}
	
	public void ubaciNakonStoJeVeciOdSvihSvojihPrethodnika(int podatak) {
		if (prvi == null) {
			CvorDSListe novi = new CvorDSListe(podatak, null, prvi);
			prvi = novi;
			if (prvi.sledeci != null) {
				prvi.sledeci.prethodni = prvi;
			}
			return;
		}
		if (prvi.sledeci == null) {
			if (prvi.podatak < podatak) {
				CvorDSListe novi = new CvorDSListe(podatak, prvi, null);
				prvi.sledeci = novi;
			} else {
				CvorDSListe novi = new CvorDSListe(podatak, null, prvi);
				prvi.prethodni = novi;
				prvi = novi;
			}
			return;
		}
		int suma = prvi.podatak;
		CvorDSListe pom = prvi;
		while (pom.sledeci != null && suma < podatak) {
			pom = pom.sledeci;
			suma += pom.podatak;
		}
		CvorDSListe novi = new CvorDSListe(podatak, pom.prethodni, pom);
		if (novi.prethodni != null) {
			novi.prethodni.sledeci = novi;
		} else {
			prvi = novi;
		}
		if (novi.sledeci != null) {
			novi.sledeci.prethodni = novi;
		}
		ispisi(); /////neeeeee valjaaaaaaaaaaa!!!!!!!!!!!!!!!!
	}
	
	public void ubaciPrijePrvogVeceg(int element) {
		if (prvi == null || prvi.podatak > element) {
			CvorDSListe novi = new CvorDSListe(element, null, prvi);
			if (novi.sledeci != null) {
				novi.sledeci.prethodni = novi;
			}
			prvi = novi;
			return;
		}
		CvorDSListe pom = prvi;
		while (pom.sledeci != null && pom.sledeci.podatak < element) {
			pom = pom.sledeci;
		}
		CvorDSListe novi = new CvorDSListe(element, pom, pom.sledeci);
		if (novi.sledeci != null) {
			novi.sledeci.prethodni = novi;
		}
		pom.sledeci = novi;
	}
	
	public int proizvodSvihNeparnihOkruzenihParnim() {
		if (prvi == null || prvi.sledeci == null) {
			return -1;
		}
		int proizvod = 1;
		CvorDSListe pom = prvi.sledeci;
		while (pom.sledeci != null) {
			if (pom.podatak % 2 != 0 && pom.prethodni.podatak % 2 == 0 && pom.sledeci.podatak % 2 == 0) {
				proizvod *= pom.podatak;
			}
			pom = pom.sledeci;
		}
		return proizvod;
	}
	
	public void prebaciMinNaPocetak() {
		if (prvi != null) {
			return;
		}
		CvorDSListe min = prvi;
		CvorDSListe pom = prvi;
		while (pom != null) {
			if (pom.podatak < min.podatak) {
				min = pom;
			}
			pom = pom.sledeci;
		}
		if (min == prvi || prvi.sledeci == null) {
			return;
		}
		min.prethodni.sledeci = min.sledeci;
		if (min.sledeci != null) {
			min.sledeci.prethodni = min.prethodni;
		}
		min.sledeci = prvi;
		prvi.prethodni = min;
		min.prethodni = null;
		prvi = min;
	}
	
	public void popuniListu() {
		if (prvi == null) {
			return;
		}
		CvorDSListe pom = prvi;
		while (pom.sledeci != null) {
			if (pom.sledeci.podatak - pom.podatak > 1) {
				CvorDSListe novi = new CvorDSListe(pom.podatak + 1, pom, pom.sledeci);
				if (pom.sledeci != null) {
					pom.sledeci.prethodni = novi;
				}
				pom.sledeci = novi;
			}
			pom = pom.sledeci;
		}
	}
	
	public void ispisiListuObrnuto() {
		if (prvi == null) {
			return;
		}
		CvorDSListe pom = prvi;
		while (pom.sledeci != null) {
			pom = pom.sledeci;
		}
		while (pom != null) {
			System.out.println(pom.podatak);
			pom = pom.prethodni;
		}
	}
	
	public void ovajSjebanKodSaTeoretskogPitanja() {
		CvorDSListe x = prvi.sledeci.sledeci;
		x.sledeci = x.prethodni.sledeci;
		x.prethodni = x.sledeci.prethodni;
	}
	
	public void sortiranje() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe spori = prvi;
		CvorDSListe brzi = null;
		CvorDSListe pom = null;											//U sustini primjenjujemo insertion sort
		while (spori != null) {
			brzi = spori;
			spori = spori.sledeci;										//CUVAMO ADRESU SLEDECEG ELEMENTA KOJI TREBA DA SE UBACI
			pom = prvi;
			while (pom != brzi) {
				if (pom.podatak > brzi.podatak) {                      
					brzi.prethodni.sledeci = brzi.sledeci;				// RAZVEZIVANJE SA PROSLE POZICIJE
					if (brzi.sledeci != null) {							//
						brzi.sledeci.prethodni = brzi.prethodni;		//
					}														
					brzi.sledeci = pom;                                 //
					brzi.prethodni = pom.prethodni;						//
					pom.prethodni = brzi;								// PREVEZIVANJE NA NOVU
					if (brzi.prethodni != null) {						//
						brzi.prethodni.sledeci = brzi;					//
					} else {
						prvi = brzi;
					}
					break;
				}
				pom = pom.sledeci;
			}
		}
	}
	
	public void sortiranjeBetaRADINAPOKON() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe prolazak = prvi;
		CvorDSListe pom = prvi;
		CvorDSListe pom1 = null;
		while (prolazak != null) {
			pom = prolazak;
			prolazak = prolazak.sledeci;
			pom1 = prvi;
			while (pom1 != pom) {
				if (pom1.podatak >= pom.podatak) {
					if (pom1.sledeci != pom) {
						pom.prethodni.sledeci = pom.sledeci;
						if (pom.sledeci != null) {
							pom.sledeci.prethodni = pom.prethodni;
						}
						pom.sledeci = pom1;
						pom.prethodni = pom1.prethodni;
						pom.sledeci.prethodni = pom;
						if (pom.prethodni != null) {
							pom.prethodni.sledeci = pom;
						}
						if (pom.prethodni == null) {
							prvi = pom;
						}
						prvi = pom;
						break;
					} else {
						CvorDSListe nzm = pom1.prethodni;
						pom1.sledeci = pom.sledeci;
						if (pom1.sledeci != null) {
							pom1.sledeci.prethodni = pom1;
						}
						pom1.prethodni = pom;
						pom.sledeci = pom1;
						pom.prethodni = nzm;
						if (nzm != null) {
							pom.prethodni.sledeci = pom;
						}
						if (pom.prethodni == null) {
							prvi = pom;
						}
						break;
					}
				}
				pom1 = pom1.sledeci;
			}
		}
	}
	
	public void dodajBrojeveDaSePopuni() {
		if (prvi == null) {
			return;
		}
		CvorDSListe pom = prvi;
		while (pom.sledeci != null) {
			if (pom.sledeci.podatak - pom.podatak > 1) {
				CvorDSListe novi = new CvorDSListe(pom.podatak + 1, pom, pom.sledeci);
				pom.sledeci = novi;
				if (novi.sledeci != null) {
					novi.sledeci.prethodni = novi;
				}
			}
			pom = pom.sledeci;
		}
	}
	
	public void izbaciElementNakonNajmanjeg() {
		CvorDSListe min = null;
		if (prvi == null) {
			return;
		}
		if (prvi.sledeci == null) {
			return;
		}
		min = prvi;
		CvorDSListe pom = prvi.sledeci;
		while (pom != null) {
			if (pom.podatak < min.podatak) {
				min = pom;
			}
			pom = pom.sledeci;
		}
		if (min.sledeci == null) {
			return;
		}
		if (min.sledeci.sledeci != null) {
			min.sledeci.sledeci.prethodni = min;
		}
		min.sledeci = min.sledeci.sledeci;
	}
	
	/*
	public void sortiraj() {
		CvorDSListe jedan = prvi;
		CvorDSListe dva = prvi;
		CvorDSListe nzm = prvi;
		CvorDSListe nzm2 = prvi;
		CvorDSListe pom = prvi;
		CvorDSListe pom2 = prvi.sledeci;
		CvorDSListe pom3 = prvi;
		while (pom.sledeci != null) {
			while (pom2 != null) {
				if (pom.podatak > pom2.podatak) {
					jedan = pom3;
					dva = pom2;
					nzm = jedan.sledeci;
					nzm2 = jedan.prethodni;
					jedan.sledeci = dva.sledeci;
					if (jedan.sledeci != null) {
						jedan.sledeci.prethodni = jedan;
					}
					if (dva.prethodni != jedan) {
						dva.prethodni.sledeci = jedan;
						dva.sledeci = nzm;
						jedan.prethodni = dva.prethodni;
					}  else {
						jedan.prethodni = dva;
						dva.sledeci = jedan;
					}
					dva.prethodni = nzm2;
					dva.sledeci.prethodni = dva;
					if (dva.prethodni != null) {
						dva.prethodni.sledeci = dva;
					}
					if (dva.prethodni == null) {
						prvi = dva;
					}
					pom2 = jedan.sledeci;
					pom3 = dva.sledeci;
				} else {
					pom2 = pom2.sledeci;
				}
				ispisi();
			}
			pom = pom.sledeci;
		}
	}
	*/
	
	public void invertujBezPomocne() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe tek = prvi;
		CvorDSListe pom = prvi;
		
		while (pom.sledeci != null) {
			tek = pom.sledeci;
			pom.sledeci = tek.sledeci;
			tek.sledeci = prvi;
			prvi.prethodni = tek;
			prvi = tek;
		}
	}
	
	public void zamjeniMjestaDvaParna() throws Exception {
		if (prvi == null) {
			throw new Exception();
		}
		CvorDSListe jedan = prvi;
		CvorDSListe dva = prvi;
		CvorDSListe pom = prvi;
		CvorDSListe pom2 = null;
		while (pom != null) {
			if (pom.podatak % 2 == 0) {
				jedan = pom;
				break;
			}
			pom = pom.sledeci;
		}
		pom = prvi;
		while (pom != null) {
			if (pom.podatak % 2 == 0 && pom.podatak != jedan.podatak) {
				dva = pom;
			}
			pom = pom.sledeci;
		}
		pom = jedan.sledeci;
		pom2 = jedan.prethodni;
		jedan.sledeci = dva.sledeci;
		if (jedan.sledeci != null) {
			jedan.sledeci.prethodni = jedan;
		}
		dva.prethodni.sledeci = jedan;
		jedan.prethodni = dva.prethodni;
		dva.sledeci = pom;
		dva.sledeci.prethodni = dva;
		dva.prethodni = pom2;
		if (dva.prethodni != null) {
			dva.prethodni.sledeci = dva;
		}
	}
	
	public void najveciNaPocetakListe() {
		if (prvi == null) {
			return;
		}
		CvorDSListe pom = prvi;
		CvorDSListe max = prvi;
		while (pom != null) {
			if (pom.podatak > max.podatak) {
				max = pom;
			}
			pom = pom.sledeci;
		}
		if (max == prvi) {
			return;
		}
		max.prethodni.sledeci = max.sledeci;
		if (max.sledeci != null) {
			max.sledeci.prethodni = max.prethodni;
		}
		max.prethodni = null;
		max.sledeci = prvi;
		prvi.prethodni = max;
		prvi = max;
	}
	
	public void stampajVeciDioListe(CvorDSListe prvi) {
		if (prvi == null) {
			return;
		}
		CvorDSListe pom = prvi;
		int sumaL = 0;
		int sumaD = 0;
		while (pom != null) {
			sumaL += pom.podatak;
			pom = pom.prethodni;
		}
		pom = prvi;
		while (pom != null) {
			sumaD += pom.podatak;
			pom = pom.sledeci;
		}
		pom = prvi;
		if (sumaL < sumaD) {
			while (pom != null) {
				System.out.println(pom.podatak);
				pom = pom.sledeci;
			} 
		} else {
			while (pom != null) {
				System.out.println(pom.podatak);
				pom = pom.prethodni;
			}
		}
	}
	
	public void izbaciNajmanji() {
		if (prvi == null) {
			return;
		}
		CvorDSListe pom = prvi;
		CvorDSListe min = prvi;
		while (pom != null) {
			if (pom.podatak < min.podatak) {
				pom = min;
			}
			pom = pom.sledeci;
		}
		if (min.sledeci != null) {
			min.sledeci.prethodni = min.prethodni;
		}
		if (min.prethodni != null) {
			min.prethodni.sledeci = min.sledeci;
		}
	}
	
	public void izbaciSaParnih() {
		if (prvi == null) {
			throw new RuntimeException("Nah");
		}
		prvi = prvi.sledeci;
		prvi.prethodni = null;
		CvorDSListe pom = prvi;
		while (pom.sledeci != null) {
			pom.sledeci = pom.sledeci.sledeci;
			if (pom.prethodni != null && pom.prethodni.prethodni != null) {
				pom.prethodni = pom.prethodni.prethodni;
				pom.prethodni.sledeci = pom;
			}
			pom = pom.sledeci;
			if (pom.sledeci == null) {
				pom.prethodni = pom.prethodni.prethodni;
			}
		}
	}
	
	public void invertujSaPomocnom() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe novi = null;
		CvorDSListe pom = prvi;
		while (pom != null) {
			novi = new CvorDSListe(pom.podatak, null, novi);
			pom = pom.sledeci;
			novi.prethodni = pom; //ovdje radimo pokazivac u jednom smjeru
		}
		pom = novi;
		while (pom.sledeci != null) { 
			pom.sledeci.prethodni = pom;
			pom = pom.sledeci; // ovdje pokazivace u drugom smjeru
		}
		prvi = novi; //najgori kod ikad ali radi ko ga jebe
	}
	
	public boolean paranBrojParnihNaParnimPozicijama() {
		int brojac = 0;
		int brojParnih = 0;
		CvorDSListe pom = prvi;
		while (pom != null) {
			if (pom.podatak % 2 == 0 && brojac % 2 == 0) {
				brojParnih++;
			}
			pom = pom.sledeci;
			brojac++;
		}
		if (brojParnih % 2 == 0 && brojParnih > 0) {
			return true;
		}
		return false;
	}
	
	public void zamjenaMjestaPrvaDvaElementa() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe drugi = prvi.sledeci;
		prvi.sledeci = drugi.sledeci;
		drugi.prethodni = null;
		prvi.prethodni = drugi;
		drugi.sledeci = prvi;
		prvi = drugi;
	}
	
	public CvorDSListe klonirajRekurzivno(CvorDSListe prvi) {
		if (prvi == null) {
			return null;
		}
		return new CvorDSListe(prvi.podatak, prvi.prethodni, klonirajRekurzivno(prvi.sledeci));  //ok kod
	}
	
	public int vratiElementUSredini() {
		if (prvi == null) {
			return -1;
		}
		CvorDSListe pom1 = prvi;
		CvorDSListe pom2 = prvi;
		while (pom2.sledeci != null) {
			pom2 = pom2.sledeci;
		}
		while (pom1 != null && pom2 != null) {
			if (pom1 == pom2 || pom1.sledeci == pom2) {
				return pom1.podatak;
			}
			pom1 = pom1.sledeci;
			pom2 = pom2.prethodni;
		}
		return -1;
	}
	
	public void izbaciSveSaParnihPozicija() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		prvi.sledeci.prethodni = null;
		prvi = prvi.sledeci;
		CvorDSListe pom = prvi;
		while (pom.sledeci != null && pom.sledeci.sledeci != null) {
			pom.sledeci = pom.sledeci.sledeci;
			pom.sledeci.prethodni = pom;
			System.out.println(pom.podatak);
			pom = pom.sledeci;
		}
		if (pom.sledeci != null) {
			pom.sledeci.prethodni = null;
			pom.sledeci = null;
		}
	}
	
	public void ubaciNaNtuPoziciju(int podatak, int pozicija) {
		if (prvi == null) {
			return;
		}
		CvorDSListe pom = prvi;
		CvorDSListe novi = new CvorDSListe(podatak, null, null);
		if (pozicija < 0) {
			return;
		}
		if (pozicija == 0) {
			novi.sledeci = prvi;
			if (novi.sledeci != null) {
				novi.sledeci.prethodni = novi;
			}
			prvi = novi;
			return;
		}
		while (pozicija > 0) {
			if (pom.sledeci == null) {
				return;
			}
			pom = pom.sledeci;
			pozicija--;
		}
		novi.sledeci = pom;
		novi.prethodni = pom.prethodni;
		if (novi.sledeci != null) {
			novi.sledeci.prethodni = novi;
		}
		novi.prethodni.sledeci = novi;
	}
	
	public void izbaciDuplikate2() {
		if (prvi == null) {
			return;
		}
		CvorDSListe spori = prvi;
		CvorDSListe pom = prvi;
		while (spori != null) {
			pom = spori.sledeci;
			while (pom != null) {
				if (pom.podatak == spori.podatak) {
					CvorDSListe pom1 = pom.sledeci;
					pom.prethodni.sledeci = pom.sledeci;
					if (pom.sledeci != null) {
						pom.sledeci.prethodni = pom.prethodni;
					}
					pom = pom1;
				} else {
					pom = pom.sledeci;
				}
			}
			spori = spori.sledeci;
		}
	}
	

	
	public void prebaciMinNaKraj() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe pom = prvi;
		CvorDSListe min = prvi;
		while (pom != null) {
			if (pom.podatak < min.podatak) {
				min = pom;
			}
			pom = pom.sledeci;
		}
		pom = prvi;
		while (pom.sledeci != null) {
			pom = pom.sledeci;
		}
		if (min == pom) {
			return;
		}
		if (min == prvi) {
			prvi = min.sledeci;
			prvi.prethodni = null;
			min.prethodni = pom;
			pom.sledeci = min;
			min.sledeci = null;
			return;
		}
		min.prethodni.sledeci = min.sledeci;
		min.sledeci.prethodni = min.prethodni;
		min.sledeci = null;
		min.prethodni = pom;
		pom.sledeci = min;
	}
	
	public CvorDSListe vratiPokNaNajmanji() {
		if (prvi == null) {
			return null;
		}
		CvorDSListe pom = prvi;
		CvorDSListe min = prvi;
		while (pom != null) {
			if (pom.podatak < min.podatak) {
				min = pom;
			}
			pom = pom.sledeci;
		}
		return min;
	}
	
	public CvorDSListe dvijeRastuceUOpadajucu(CvorDSListe prvi, CvorDSListe drugi) {
		if (prvi == null || drugi == null) {
			return null;
		}
		CvorDSListe novi = null;
		CvorDSListe pom1 = prvi;
		while (pom1.sledeci != null) {
			pom1 = pom1.sledeci;
		}
		CvorDSListe pom2 = drugi;
		while (pom2.sledeci != null) {
			pom2 = pom2.sledeci;
		}
		while (pom1 != null && pom2 != null) {
			if (pom1.podatak > pom2.podatak) {
				novi = new CvorDSListe(pom1.podatak, null, novi);
				if (novi.sledeci != null) {
					novi.sledeci.prethodni = novi;
				}
				pom1 = pom1.prethodni;
			} else {
				novi = new CvorDSListe(pom2.podatak, null, novi);
				if (novi.sledeci != null) {
					novi.sledeci.prethodni = novi;
				}
				pom2 = pom2.prethodni;
			}
			if (pom1 == null) {
				while (pom2 != null) {
					novi = new CvorDSListe(pom2.podatak, null, novi);
					if (novi.sledeci != null) {
						novi.sledeci.prethodni = novi;
					}
					pom2 = pom2.prethodni;
				}
			}
			if (pom2 == null) {
				while (pom1 != null) {
					novi = new CvorDSListe(pom1.podatak, null, novi);
					if (novi.sledeci != null) {
						novi.sledeci.prethodni = novi;
					}
					pom1 = pom1.prethodni;
				}
			}
		}
		return novi;
	}
	
	public int vratiElementKojiJeUsrediniJedanProlaz() {
		if (prvi == null || prvi.sledeci == null || prvi.sledeci.sledeci == null) {
			return -1;
		}
		CvorDSListe pom = prvi;
		CvorDSListe pom1 = prvi;
		while (pom.sledeci != null && pom.sledeci.sledeci != null) {
			pom = pom.sledeci.sledeci;
			pom1 = pom1.sledeci;
		}
		return pom1.podatak;
	}
	
	public boolean postoji(CvorDSListe prvi, int podatak) {
		while (prvi != null) {
			if (prvi.podatak == podatak) {
				return true;
			}
			prvi = prvi.sledeci;
		}
		return false;
	}
	
	public CvorDSListe razlikaDvijeListe(CvorDSListe prva, CvorDSListe druga) {
		if (prva == null || druga == null) {
			return null;
		}
		CvorDSListe novi = null;
		CvorDSListe pom = prva;
		while (pom != null) {
			if (!postoji(druga, pom.podatak)) {
				novi = new CvorDSListe(pom.podatak, null, novi);
				if (novi.sledeci != null) {
					novi.sledeci.prethodni = novi;
				}
			}
			pom = pom.sledeci;
		}
		return novi;
	}
	/*
	public void ubaciNoviUsortiranu(int podatak) {
		if (prvi == null) {
			prvi = new CvorDSListe(podatak, null, null);
			return;
		}
		if (prvi.sledeci == null) {
			if (prvi.podatak > podatak) {
				CvorDSListe novi = new CvorDSListe(podatak, null, prvi);
				prvi.prethodni = novi;
				prvi = novi;
			} else {
				CvorDSListe novi = new CvorDSListe(podatak, prvi, null);
				prvi.sledeci = novi;
			}
			return;
		}
		CvorDSListe pom = prvi;
		int ubacen = 0;
		while (pom.sledeci != null) {
			if (pom.podatak > podatak) {
				break;
			}
			pom = pom.sledeci;
		}
		CvorDSListe novi = new CvorDSListe(podatak, pret, sled);
	}
	*/
	
	public void zamjeniMjestaMaxIMin() {
		if (prvi == null && prvi.sledeci == null) {
			return;
		}
		if (prvi.sledeci.sledeci == null) {
			CvorDSListe drugi = prvi.sledeci;
			prvi.sledeci = drugi.sledeci;
			drugi.sledeci = prvi;
			drugi.prethodni = null;
			prvi.prethodni = drugi;
			prvi = drugi;
			return;
		}
		CvorDSListe pom = prvi;
		CvorDSListe pom1 = prvi;
		CvorDSListe min = prvi;
		CvorDSListe max = prvi;
		while (pom != null) {						//
			if (pom.podatak > max.podatak) {		//
				max = pom;							//	
			}										//
			if (pom.podatak < min.podatak) {		//Ovdje trazimo najveci i najmanji
				min = pom;							//	
			}										//
			pom = pom.sledeci;						//
		}
		pom = max.sledeci;							//
		pom1 = max.prethodni;						//Pamtimo sledeci i prethodni od maxa
		if (pom != null) {
			pom.prethodni = max.prethodni;  		//
		}											//Razvezivanje maxa sa svoje pozicije
		max.prethodni.sledeci = pom;
		if (min.prethodni != null) {				//
			min.prethodni.sledeci = max;			//Ubacivanje maxa na prvu poziciju iza mina
		} else {									//
			prvi = max;								//Postavljanje maxa da je prvi element ako iza njega nema ni jedan
		}											//
		max.sledeci = min.sledeci;					//
		max.sledeci.prethodni = max;				
		if (pom1 != min) {							//
			pom1.sledeci = min;						//
			min.prethodni = pom1;					// OVA PROVJERA JE VAZNA ZATO STO ALGORITAM NECE RADITI 
		} else {									// KADA SU ELEMENTI JEDAN DO DRUGOG I KADA NISU
			max.sledeci = min;						// i tu sredjujemo min i njegovog prethodnika
			min.prethodni = max;					//
		}
		min.sledeci = pom; 							// Sredjujemo min i njegovog sledbenika
		if (min.sledeci != null) {					//
			pom.prethodni = min;					//
		}
	}
	
	public CvorDSListe kloniraj2(CvorDSListe prvi) {
		if (prvi == null) {
			return null;
		}
		return new CvorDSListe(prvi.podatak, prvi.prethodni, kloniraj2(prvi.sledeci));
	}
	
	public void sortirajPo666Put() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe spori = prvi;
		CvorDSListe brzi = prvi;
		CvorDSListe pom = prvi;
		while (spori != null) {
			brzi = spori;
			spori = spori.sledeci;
			pom = prvi;
			while (pom != brzi) {
				if (pom.podatak > brzi.podatak) {
					brzi.prethodni.sledeci = brzi.sledeci;
					if (brzi.sledeci != null) {
						brzi.sledeci.prethodni = brzi.prethodni;
					}
					brzi.sledeci = pom;
					brzi.prethodni = pom.prethodni;
					if (brzi.prethodni != null) {
						brzi.prethodni.sledeci = brzi;
					} else {
						prvi = brzi;
					}
					pom.prethodni = brzi;
					break; //// BITNOOOOOOO!!!!!!!!!! ! ! !  ! ! !  ! !  ! ! !  ! ! !
				}
				pom = pom.sledeci;
			}
		}
	}
	
	public void izbaciSvakiTreci() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe pom = prvi;
		while (pom != null && pom.sledeci != null && pom.sledeci.sledeci != null) {
			pom = pom.sledeci;
			pom.sledeci = pom.sledeci.sledeci;
			if (pom.sledeci != null) {
				pom.sledeci.prethodni = pom;
			}
			pom = pom.sledeci;
			
		}
	}
	
	public void izbaciSvakiDrugi() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe pom = prvi;
		while (pom != null && pom.sledeci != null) {
			pom.sledeci = pom.sledeci.sledeci;
			if (pom.sledeci != null) {
				pom.sledeci.prethodni = pom;
			}
			pom = pom.sledeci;
		}
	}
	
	public CvorDSListe klloniraj(CvorDSListe prvi) {
		if (prvi == null) {
			return null;
		}
		return new CvorDSListe(prvi.podatak, prvi.prethodni, klloniraj(prvi.sledeci));
	}
	
	public int izbaciUSrediniBINARYBIOSKOP() {
		if (prvi == null || prvi.sledeci == null) {
			return -1;
		}
		int brojac = 0;
		int suma = 0;
		CvorDSListe pom = prvi;
		while (pom != null) {
			brojac++;
			pom = pom.sledeci;
		}
		System.out.println(brojac);
		pom = prvi;
		int koraci = brojac / 2 - 2;
		while (koraci > 0) {
			pom = pom.sledeci;
			koraci--;
		}
		if (brojac % 2 == 1) {
			suma = suma + pom.sledeci.podatak;
			pom.sledeci = pom.sledeci.sledeci;
			pom.sledeci.prethodni = pom;
			return suma;
		} else {
			suma = suma + pom.sledeci.podatak + pom.sledeci.sledeci.podatak;
			pom.sledeci = pom.sledeci.sledeci.sledeci;
			pom.sledeci.prethodni = pom;
			return suma;
		}
	}
	
	public void kodSaTesta() {
		CvorDSListe x = prvi.sledeci.sledeci;
		x.sledeci = x.prethodni.sledeci;
		x.prethodni = x.sledeci.prethodni;
	}
	
	public void zamjeniNajveciSaPrvim() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe pom = prvi;
		CvorDSListe max = prvi;
		while (pom != null) {
			if (pom.podatak > max.podatak) {
				max = pom;
			}
			pom = pom.sledeci;
		}
		if (max == prvi) {
			return;
		}
		CvorDSListe pom1 = max.prethodni;
		CvorDSListe pom2 = max.sledeci;
		CvorDSListe pom3 = prvi.sledeci;
		max.prethodni.sledeci = max.sledeci;
		if (max.sledeci != null) {
			max.sledeci.prethodni = max.prethodni;
		}
		if (prvi != pom1) {
			prvi.prethodni = pom1;
			pom1.sledeci = prvi;
			prvi.sledeci = pom2;
			if (pom2 != null) {
				pom2.prethodni = prvi;
			}
		} else {
			prvi.sledeci = pom2;
			if (pom2 != null) {
				pom2.prethodni = prvi;
			}
		}
		max.sledeci = pom3;
		max.sledeci.prethodni = max;
		prvi = max;
	}
	
	public void proslaGodinaDrugi() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe novi = null;
		CvorDSListe pom = prvi;
		while (pom != null) {
			if (pom.podatak % 2 == 0) {
				novi = new CvorDSListe(pom.podatak, null, novi);
				if (novi.sledeci != null) {
					novi.sledeci.prethodni = novi;
				}
			}
			pom = pom.sledeci;
		}
		pom = prvi;
		while (pom != null) {
			if (pom.podatak % 2 == 1) {
				novi = new CvorDSListe(pom.podatak, null, novi);
				if (novi.sledeci != null) {
					novi.sledeci.prethodni = novi;
				}
			}
			pom = pom.sledeci;
		}
		prvi = novi;
	}
	
	public void izbaciDuplikate202() {
		if (prvi == null) {
			return;
		}
		CvorDSListe spori = prvi;
		CvorDSListe pom = prvi;
		while (spori != null) {
			pom = spori.sledeci;
			while (pom != null) {
				if (pom.podatak == spori.podatak) {
					CvorDSListe pom1 = pom.sledeci;
					pom.prethodni.sledeci = pom.sledeci;
					if (pom.sledeci != null) {
						pom.sledeci.prethodni = pom.prethodni;
					}
					pom = pom1;
				} else {
					pom = pom.sledeci;
				}
			}
			spori = spori.sledeci;
		}
	}
	
	public void izbaciDuplikate303() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe spori = prvi;
		CvorDSListe pom = prvi;
		while (spori != null) {
			pom = spori.sledeci;
			while (pom != null) {
				if (pom.podatak == spori.podatak) {
					CvorDSListe pom1 = pom.sledeci;
					pom.prethodni.sledeci = pom.sledeci;
					if (pom.sledeci != null) {
						pom.sledeci.prethodni = pom.prethodni;
					}
					pom = pom1;
				} else {
					pom = pom.sledeci;
				}
			}
			spori = spori.sledeci;
		}
	}
	
	public void sortirrraj() {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}
		CvorDSListe spori = prvi;
		CvorDSListe brzi = prvi;
		CvorDSListe pom = prvi;
		while (spori != null) {
			brzi = spori;
			spori = spori.sledeci;
			pom = prvi;
			while (pom != brzi) {
				if (pom.podatak > brzi.podatak) {
					if (brzi.prethodni != null) {
						brzi.prethodni.sledeci = brzi.sledeci;
					}
					if (brzi.sledeci != null) {
						brzi.sledeci.prethodni = brzi.prethodni;
					}
					brzi.sledeci = pom;
					brzi.prethodni = pom.prethodni;
					if (brzi.prethodni != null) {
						brzi.prethodni.sledeci = brzi;
					} else {
						prvi = brzi;
					}
					pom.prethodni = brzi;
					break;
				} else {
					pom = pom.sledeci;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ListaDS l2 = new ListaDS();
		l2.ubaciNaKraju(4);
		l2.ubaciNaKraju(-3);
		l2.sortirrraj();
		l2.ispisi();
		l2.ispisi();
		
	}
}
