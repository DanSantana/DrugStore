package ca.com.durgstore.bean;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import ca.com.drugstore.DAO.SupplierDAO;
import ca.com.drugstore.domain.Supplier;

@ManagedBean(name = "MBSupplier")
@ViewScoped
public class SupplierBean {
	private ListDataModel<Supplier> itens;
	public ListDataModel<Supplier> getItens() {
		return itens;
	}
	public void setItens(ListDataModel<Supplier> itens) {
		this.itens = itens;
	}
@PostConstruct
	// carrregar tabela
	public void prepareSearch() {
		try {
			// criar o DAO objeto de acesso
			SupplierDAO sDao = new SupplierDAO();
			// capturar os dados do procedimento lista e carregar na variável
			// lista
			ArrayList<Supplier> listing = sDao.listing();
			// converter o Array list em um list data Model
			itens = new ListDataModel<Supplier>(listing);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
