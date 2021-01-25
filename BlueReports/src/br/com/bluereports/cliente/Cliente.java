package br.com.bluereports.cliente;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_cliente")
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5307325780902033144L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_cliente", nullable=false)
	private int idCliente;
	
	@Column(name="nome_razao", nullable = false)
	private String nomeCliente;
	
	@Column(name="fantasia_apelido")
	private String fantasiaApelido;
	
	@Column(name="num_cpf_cnpj")
	private String numCpfCnpj;
	
	private String endereco;
	
	@Column(name="num_endereco")
	private String numEndereco;
	
	private String email;
	private String bairro;
	private String cidade;
	
	@Column(name="num_cep")
	private String cep;
	
	@Column(name="sigla_uf")
	private String siglaUf;
	
	private String telefone;
	
	@Column(name="complemento_endereco")
	private String complemento;
	
	@Column(name="status_cad")
	private String statusCad;

	public Cliente(int idCliente, String nomeCliente, String fantasiaApelido, String numCpfCnpj, String endereco,
			String numEndereco, String email, String bairro, String cidade, String cep, String siglaUf, String telefone,
			String complemento, String statusCad) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.fantasiaApelido = fantasiaApelido;
		this.numCpfCnpj = numCpfCnpj;
		this.endereco = endereco;
		this.numEndereco = numEndereco;
		this.email = email;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.siglaUf = siglaUf;
		this.telefone = telefone;
		this.complemento = complemento;
		this.statusCad = statusCad;
	}

	public Cliente(String nomeCliente, String fantasiaApelido, String numCpfCnpj, String endereco, String numEndereco,
			String email, String bairro, String cidade, String cep, String siglaUf, String telefone, String complemento,
			String statusCad) {
		this.nomeCliente = nomeCliente;
		this.fantasiaApelido = fantasiaApelido;
		this.numCpfCnpj = numCpfCnpj;
		this.endereco = endereco;
		this.numEndereco = numEndereco;
		this.email = email;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.siglaUf = siglaUf;
		this.telefone = telefone;
		this.complemento = complemento;
		this.statusCad = statusCad;
	}

	public Cliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getFantasiaApelido() {
		return fantasiaApelido;
	}

	public void setFantasiaApelido(String fantasiaApelido) {
		this.fantasiaApelido = fantasiaApelido;
	}

	public String getNumCpfCnpj() {
		return numCpfCnpj;
	}

	public void setNumCpfCnpj(String numCpfCnpj) {
		this.numCpfCnpj = numCpfCnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumEndereco() {
		return numEndereco;
	}

	public void setNumEndereco(String numEndereco) {
		this.numEndereco = numEndereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getSiglaUf() {
		return siglaUf;
	}

	public void setSiglaUf(String siglaUf) {
		this.siglaUf = siglaUf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getStatusCad() {
		return statusCad;
	}

	public void setStatusCad(String statusCad) {
		this.statusCad = statusCad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((fantasiaApelido == null) ? 0 : fantasiaApelido.hashCode());
		result = prime * result + idCliente;
		result = prime * result + ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
		result = prime * result + ((numCpfCnpj == null) ? 0 : numCpfCnpj.hashCode());
		result = prime * result + ((numEndereco == null) ? 0 : numEndereco.hashCode());
		result = prime * result + ((siglaUf == null) ? 0 : siglaUf.hashCode());
		result = prime * result + ((statusCad == null) ? 0 : statusCad.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (fantasiaApelido == null) {
			if (other.fantasiaApelido != null)
				return false;
		} else if (!fantasiaApelido.equals(other.fantasiaApelido))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (nomeCliente == null) {
			if (other.nomeCliente != null)
				return false;
		} else if (!nomeCliente.equals(other.nomeCliente))
			return false;
		if (numCpfCnpj == null) {
			if (other.numCpfCnpj != null)
				return false;
		} else if (!numCpfCnpj.equals(other.numCpfCnpj))
			return false;
		if (numEndereco == null) {
			if (other.numEndereco != null)
				return false;
		} else if (!numEndereco.equals(other.numEndereco))
			return false;
		if (siglaUf == null) {
			if (other.siglaUf != null)
				return false;
		} else if (!siglaUf.equals(other.siglaUf))
			return false;
		if (statusCad == null) {
			if (other.statusCad != null)
				return false;
		} else if (!statusCad.equals(other.statusCad))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", fantasiaApelido="
				+ fantasiaApelido + ", numCpfCnpj=" + numCpfCnpj + ", endereco=" + endereco + ", numEndereco="
				+ numEndereco + ", email=" + email + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep
				+ ", siglaUf=" + siglaUf + ", telefone=" + telefone + ", complemento=" + complemento + ", statusCad="
				+ statusCad + "]";
	}
	
	
	
}
