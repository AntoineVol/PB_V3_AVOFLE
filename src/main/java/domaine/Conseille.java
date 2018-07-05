package domaine;

import java.util.List;

/**
 * Classe des conseillés. 
 * @author LENOIR et VOLATRON
 */
public class Conseille extends Personne {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String login;
	private String password;
	private List<Client> listClient;
	
	/**
	 * Constructeur par defaut
	 */
	public Conseille() {
		super();
	}
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}
}
