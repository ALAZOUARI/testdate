package lendemain;


public class Date {
	int jour;
	int mois;
	int annee;

	public Date() {
	}

	public Date(int jour, int mois, int annee) {
		
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public static void ValiditeDate(int jour, int mois, int annee) throws Exception {

		if (jour < 1)
			throw new Exception("jour < 1");

		if (jour > 31)
			throw new Exception("jour > 31");

		if (mois < 1)
			throw new Exception("mois < 1");

		if (mois > 12)
			throw new Exception("mois > 12");

		if (annee < 1000)
			throw new Exception("annee < 1000");

		if (annee > 3000)
			throw new Exception("annee > 3000");

		if (!bissextile(annee) && mois == 2 && jour > 28)
			throw new Exception("Fevrier n'a que 28 jours");
		if (bissextile(annee) && mois == 2 && jour > 29)
			throw new Exception("Annee Bissextile Fevrier n'a que 29 jours");
		if (maxDayInMonth(mois,annee) == 30 && jour > 30)
			throw new Exception("ce mois ne contient que 30 jours ");
	}

	public static int maxDayInMonth(int mois,int annee) {
		switch (mois) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if (bissextile(annee)) {
				return 29;
			} else {
				return 28;
			}
		default:
			return -1;
		}
	}

	public static boolean bissextile(int annee) {
		if (annee % 4 == 0) {
			if (annee % 400 == 0) {
				return true;
			} else if (annee % 100 == 0) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	public static Date Lendemain(Date DateCourant) throws Exception {
		ValiditeDate(DateCourant.getJour(), DateCourant.getMois(), DateCourant.getAnnee());
		if (DateCourant.getJour() == maxDayInMonth(DateCourant.getMois(),DateCourant.getAnnee())) {
			if (DateCourant.getMois() == 12) {
				DateCourant.setAnnee(DateCourant.getAnnee() + 1);
				DateCourant.setMois(1);
				DateCourant.setJour(1);
			} else {
				DateCourant.setMois(DateCourant.getMois() + 1);
				DateCourant.setJour(1);
			}
		} else {
			DateCourant.setJour(DateCourant.getJour() + 1);
		}
		return DateCourant;
	}
}
