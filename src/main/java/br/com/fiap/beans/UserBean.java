package br.com.fiap.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.model.User;
import br.com.fiap.util.EntityManagerFacade;

@Named
@RequestScoped
public class UserBean {
	private User user = new User();

	private EntityManager manager = new EntityManagerFacade().getEntityManager();
	
	private UserDAO userDAO = new UserDAO(manager);
	
	public String save(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			userDAO.insert(this.user);
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Usuário cadastrado com sucesso"));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Ocorreu um erro no cadastro de usuário"));
		}
		return "login?faces-redirect=true";
	}
	
	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		User user =  userDAO.findByEmailAndPassword(this.user.getEmail(), this.user.getPassword());
		
		if (user != null) {
			context.getExternalContext().getSessionMap().put("user", user);
			return "index?faces-redirect=true";
		}
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login inválido", "erro"));
		return "login?faces-redirect=true";
		
	}
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("user");
		return "login?faces-redirect=true";

	}
	
	public void update(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			User user = (User) context.getExternalContext().getSessionMap().get("user");
			this.user.setId(user.getId());
			userDAO.update(this.user);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário atualizado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro na atualização do usuário"));
		}
	}

	public String delete(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			User user = (User) context.getExternalContext().getSessionMap().get("user");
			userDAO.delete(user.getId());
			context.getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário removido com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro para remover usuário"));
		}
		return logout();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
