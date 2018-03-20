package si.um.feri.aiv;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.test.EnMaliEjb;
import si.test.EnMaliEjbLocal;

@ManagedBean(name="demo")
@SessionScoped
public class DemoBean {

	Logger log=LoggerFactory.getLogger(DemoBean.class);
	
	private OsebaDao dao=new OsebaDao();

	private Oseba novaOseba=new Oseba();

	private Oseba izbranaOseba=new Oseba();
	
	private String izbranEmail;
	
	public void setIzbranEmail(String email) {
		log.info("JSF BEAN: setIzbranEmail");
		izbranEmail=email;
		try {
			izbranaOseba=dao.najdi(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getIzbranEmail() {
		return izbranEmail;
	}

	@EJB
	EnMaliEjbLocal ejb;
	
	public void dodajOsebo() {
		
		System.out.println(
				ejb.pozdraviMe(novaOseba.getIme())
		);
		
		log.info("JSF BEAN: dodajOsebo");
		try {
			dao.shrani(novaOseba);
			novaOseba=new Oseba();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Oseba getNovaOseba() {
		return novaOseba;
	}
	
	public void setNovaOseba(Oseba novaOseba) {
		this.novaOseba = novaOseba;
	}

	public Oseba getIzbranaOseba() {
		return izbranaOseba;
	}

	public void setIzbranaOseba(Oseba izbranaOseba) {
		this.izbranaOseba = izbranaOseba;
	}

}
