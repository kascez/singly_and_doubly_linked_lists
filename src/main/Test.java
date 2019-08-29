package main;

public class Test {

	public static void main(String[] args) {
		ListaDS l1 = new ListaDS();
		ListaDS l2 = new ListaDS();
		ListaDS l3 = new ListaDS();
		l2.ubaciNaKraju(4);
		l2.ubaciNaKraju(2);
		l2.ubaciNaKraju(4);
		l2.ubaciNaKraju(4);
		l2.ubaciNaKraju(4);
		l2.ubaciNaKraju(5);
		l2.izbaciDuplikate();
		l2.ispisi();
	}

}
