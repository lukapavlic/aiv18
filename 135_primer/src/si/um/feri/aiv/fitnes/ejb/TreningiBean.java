package si.um.feri.aiv.fitnes.ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import si.um.feri.aiv.fitnes.vao.Trening;

@LocalBean
@Stateless
public class TreningiBean {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Trening> vsiTreningi(){
		return em.createQuery("select t from Trening t").getResultList();
	}
	
	public Trening najdi(long id) {
		return em.find(Trening.class, id);
	}
	
	public void shrani(Trening t) {
		em.persist(t);
	}
	
}
