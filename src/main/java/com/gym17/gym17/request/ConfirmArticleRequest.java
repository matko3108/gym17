package src.main.java.com.gym17.gym17.request;

public class ConfirmArticleRequest {
	public int idOrganisation;
	public int idChannel;
	public String voucherCode;
	
	public ConfirmArticleRequest() {
		super();
	}

	public ConfirmArticleRequest(int idOrganisation, int idChannel, String voucherCode) {
		super();
		this.idOrganisation = idOrganisation;
		this.idChannel = idChannel;
		this.voucherCode = voucherCode;
	}


	public int getIdOrganisation() {
		return idOrganisation;
	}

	public void setIdOrganisation(int idOrganisation) {
		this.idOrganisation = idOrganisation;
	}

	public int getIdChannel() {
		return idChannel;
	}
	public void setIdChannel(int idChannel) {
		this.idChannel = idChannel;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	
	@Override
	public String toString() {
		return "ConfirmArticleRequest [idOrganisation=" + idOrganisation + ", idChannel=" + idChannel + ", voucherCode="
				+ voucherCode + "]";
	}
}
