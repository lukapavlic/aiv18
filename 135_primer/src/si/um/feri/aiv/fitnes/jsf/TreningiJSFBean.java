package si.um.feri.aiv.fitnes.jsf;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import si.um.feri.aiv.fitnes.ejb.TreningiBean;
import si.um.feri.aiv.fitnes.vao.Trening;

@Named("treningi")
@SessionScoped
public class TreningiJSFBean implements Serializable {

	private static final long serialVersionUID = 997614964798652139L;

	@EJB
	TreningiBean ejb;
	
	private Trening izbranTrening=new Trening();
	
	private String treningId;
	
	public Trening getIzbranTrening() {
		return izbranTrening;
	}

	public void setIzbranTrening(Trening izbranTrening) {
		this.izbranTrening = izbranTrening;
	}
	
	public String getTreningId() {
		return treningId;
	}

	public void setTreningId(String id) {
		this.treningId = id;
		izbranTrening=ejb.najdi(Long.parseLong(id));
	}

	public void shraniIzbranTrening() {
		ejb.shrani(izbranTrening);
	}
	
	public String getNov() {
		return "";
	}

	public void setNov(String nov) {
		izbranTrening=new Trening();
	}
	
}
