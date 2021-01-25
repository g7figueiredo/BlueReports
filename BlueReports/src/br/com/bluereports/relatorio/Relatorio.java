package br.com.bluereports.relatorio;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.bluereports.cliente.Cliente;

@Entity
@Table(name="tbl_relatorio")
public class Relatorio implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5139883327894369645L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_relatorio", nullable=false)
	private int idRelatorio;
	
	@Column(name="num_pedido")
	private String numPedido;
	
	@Column(name="data_emissao")
	private Date dataEmissao;
	
	@Column(name="nome_responsavel")
	private String responsavel;
	
	@Column(name="desc_equipamento")
	private String equipamento;
	
	@Column(name="potencia_equipamento")
	private String potenciaEquipamento;
	
	@Column(name="marca_equipamento")
	private String marcaEquipamento;
	
	@Column(name="tipo_equipamento")
	private String tipoEquipamento;
	
	@Column(name="id_equipamento")
	private String idEquipamento;
	
	@Column(name="desc_diagnostico")
	private String diagnostico;
	
	@Column(name="desc_corretiva")
	private String corretiva;
	
	@Column(name="desc_observacoes")
	private String observacoes;
	
	@Column(name="status_cad")
	private String statusCad;
	
	@Lob
	@Column(name="img_ps1", columnDefinition="longblob")
	private byte[] img1;
	
	@Lob
	@Column(name="img_ps2", columnDefinition="longblob")
	private byte[] img2;
	
	@Lob
	@Column(name="img_pos1", columnDefinition="longblob")
	private byte[] img3;
	
	@Lob
	@Column(name="img_pos2", columnDefinition="longblob")
	private byte[] img4;
	
	@Column(name="legenda_ps1")
	private String legenda1;
	
	@Column(name="legenda_ps2")
	private String legenda2;
	
	@Column(name="legenda_pos1")
	private String legenda3;
	
	@Column(name="legenda_pos2")
	private String legenda4;
	
	@Lob
	@Column(name="doc_complementar", columnDefinition="longblob")
	private byte[] documento;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_cliente", nullable = false)
	private Cliente cliente;

	public Relatorio() {
		// TODO Auto-generated constructor stub
	}

	public int getIdRelatorio() {
		return idRelatorio;
	}

	public void setIdRelatorio(int idRelatorio) {
		this.idRelatorio = idRelatorio;
	}

	public String getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(String numPedido) {
		this.numPedido = numPedido;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getPotenciaEquipamento() {
		return potenciaEquipamento;
	}

	public void setPotenciaEquipamento(String potenciaEquipamento) {
		this.potenciaEquipamento = potenciaEquipamento;
	}

	public String getMarcaEquipamento() {
		return marcaEquipamento;
	}

	public void setMarcaEquipamento(String marcaEquipamento) {
		this.marcaEquipamento = marcaEquipamento;
	}

	public String getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(String tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}

	public String getIdEquipamento() {
		return idEquipamento;
	}

	public void setIdEquipamento(String idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getCorretiva() {
		return corretiva;
	}

	public void setCorretiva(String corretiva) {
		this.corretiva = corretiva;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getStatusCad() {
		return statusCad;
	}

	public void setStatusCad(String statusCad) {
		this.statusCad = statusCad;
	}

	public byte[] getImg1() {
		return img1;
	}

	public void setImg1(byte[] img1) {
		this.img1 = img1;
	}

	public byte[] getImg2() {
		return img2;
	}

	public void setImg2(byte[] img2) {
		this.img2 = img2;
	}

	public byte[] getImg3() {
		return img3;
	}

	public void setImg3(byte[] img3) {
		this.img3 = img3;
	}

	public byte[] getImg4() {
		return img4;
	}

	public void setImg4(byte[] img4) {
		this.img4 = img4;
	}

	public String getLegenda1() {
		return legenda1;
	}

	public void setLegenda1(String legenda1) {
		this.legenda1 = legenda1;
	}

	public String getLegenda2() {
		return legenda2;
	}

	public void setLegenda2(String legenda2) {
		this.legenda2 = legenda2;
	}

	public String getLegenda3() {
		return legenda3;
	}

	public void setLegenda3(String legenda3) {
		this.legenda3 = legenda3;
	}

	public String getLegenda4() {
		return legenda4;
	}

	public void setLegenda4(String legenda4) {
		this.legenda4 = legenda4;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((corretiva == null) ? 0 : corretiva.hashCode());
		result = prime * result + ((dataEmissao == null) ? 0 : dataEmissao.hashCode());
		result = prime * result + ((diagnostico == null) ? 0 : diagnostico.hashCode());
		result = prime * result + Arrays.hashCode(documento);
		result = prime * result + ((equipamento == null) ? 0 : equipamento.hashCode());
		result = prime * result + ((idEquipamento == null) ? 0 : idEquipamento.hashCode());
		result = prime * result + idRelatorio;
		result = prime * result + Arrays.hashCode(img1);
		result = prime * result + Arrays.hashCode(img2);
		result = prime * result + Arrays.hashCode(img3);
		result = prime * result + Arrays.hashCode(img4);
		result = prime * result + ((legenda1 == null) ? 0 : legenda1.hashCode());
		result = prime * result + ((legenda2 == null) ? 0 : legenda2.hashCode());
		result = prime * result + ((legenda3 == null) ? 0 : legenda3.hashCode());
		result = prime * result + ((legenda4 == null) ? 0 : legenda4.hashCode());
		result = prime * result + ((marcaEquipamento == null) ? 0 : marcaEquipamento.hashCode());
		result = prime * result + ((numPedido == null) ? 0 : numPedido.hashCode());
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + ((potenciaEquipamento == null) ? 0 : potenciaEquipamento.hashCode());
		result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
		result = prime * result + ((statusCad == null) ? 0 : statusCad.hashCode());
		result = prime * result + ((tipoEquipamento == null) ? 0 : tipoEquipamento.hashCode());
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
		Relatorio other = (Relatorio) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (corretiva == null) {
			if (other.corretiva != null)
				return false;
		} else if (!corretiva.equals(other.corretiva))
			return false;
		if (dataEmissao == null) {
			if (other.dataEmissao != null)
				return false;
		} else if (!dataEmissao.equals(other.dataEmissao))
			return false;
		if (diagnostico == null) {
			if (other.diagnostico != null)
				return false;
		} else if (!diagnostico.equals(other.diagnostico))
			return false;
		if (!Arrays.equals(documento, other.documento))
			return false;
		if (equipamento == null) {
			if (other.equipamento != null)
				return false;
		} else if (!equipamento.equals(other.equipamento))
			return false;
		if (idEquipamento == null) {
			if (other.idEquipamento != null)
				return false;
		} else if (!idEquipamento.equals(other.idEquipamento))
			return false;
		if (idRelatorio != other.idRelatorio)
			return false;
		if (!Arrays.equals(img1, other.img1))
			return false;
		if (!Arrays.equals(img2, other.img2))
			return false;
		if (!Arrays.equals(img3, other.img3))
			return false;
		if (!Arrays.equals(img4, other.img4))
			return false;
		if (legenda1 == null) {
			if (other.legenda1 != null)
				return false;
		} else if (!legenda1.equals(other.legenda1))
			return false;
		if (legenda2 == null) {
			if (other.legenda2 != null)
				return false;
		} else if (!legenda2.equals(other.legenda2))
			return false;
		if (legenda3 == null) {
			if (other.legenda3 != null)
				return false;
		} else if (!legenda3.equals(other.legenda3))
			return false;
		if (legenda4 == null) {
			if (other.legenda4 != null)
				return false;
		} else if (!legenda4.equals(other.legenda4))
			return false;
		if (marcaEquipamento == null) {
			if (other.marcaEquipamento != null)
				return false;
		} else if (!marcaEquipamento.equals(other.marcaEquipamento))
			return false;
		if (numPedido == null) {
			if (other.numPedido != null)
				return false;
		} else if (!numPedido.equals(other.numPedido))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (potenciaEquipamento == null) {
			if (other.potenciaEquipamento != null)
				return false;
		} else if (!potenciaEquipamento.equals(other.potenciaEquipamento))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		if (statusCad == null) {
			if (other.statusCad != null)
				return false;
		} else if (!statusCad.equals(other.statusCad))
			return false;
		if (tipoEquipamento == null) {
			if (other.tipoEquipamento != null)
				return false;
		} else if (!tipoEquipamento.equals(other.tipoEquipamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Relatorio [idRelatorio=" + idRelatorio + ", numPedido=" + numPedido + ", dataEmissao=" + dataEmissao
				+ ", responsavel=" + responsavel + ", equipamento=" + equipamento + ", potenciaEquipamento="
				+ potenciaEquipamento + ", marcaEquipamento=" + marcaEquipamento + ", tipoEquipamento="
				+ tipoEquipamento + ", idEquipamento=" + idEquipamento + ", diagnostico=" + diagnostico + ", corretiva="
				+ corretiva + ", observacoes=" + observacoes + ", statusCad=" + statusCad + ", img1="
				+ Arrays.toString(img1) + ", img2=" + Arrays.toString(img2) + ", img3=" + Arrays.toString(img3)
				+ ", img4=" + Arrays.toString(img4) + ", legenda1=" + legenda1 + ", legenda2=" + legenda2
				+ ", legenda3=" + legenda3 + ", legenda4=" + legenda4 + ", documento=" + Arrays.toString(documento)
				+ ", cliente=" + cliente + "]";
	}

	
}
