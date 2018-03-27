package si.um.feri.aiv.fitnes.vao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trening {
	
	private long id;
	
	private String naziv;
	
	private Calendar ustvarjen=new GregorianCalendar();
	
	private String trener;
	
	private String stranka;
	
	private int dniVCiklu;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Calendar getUstvarjen() {
		return ustvarjen;
	}

	public void setUstvarjen(Calendar ustvarjen) {
		this.ustvarjen = ustvarjen;
	}

	public String getTrener() {
		return trener;
	}

	public void setTrener(String trener) {
		this.trener = trener;
	}

	public String getStranka() {
		return stranka;
	}

	public void setStranka(String stranka) {
		this.stranka = stranka;
	}

	public int getDniVCiklu() {
		return dniVCiklu;
	}

	public void setDniVCiklu(int dniVCiklu) {
		this.dniVCiklu = dniVCiklu;
	}
	
	public void setJavaReference(String s) {
	}

	public String getJavaReference() {
		return super.toString();
	}
	
	private static SimpleDateFormat sdf=new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");

	@Override
	public String toString() {
		return id+": "+naziv + " (" + trener + "; "+stranka+"); vpis: "+sdf.format(ustvarjen.getTime())+"; "+dniVCiklu+" dni na cikel ["+super.toString()+"]";
	}
	
}
