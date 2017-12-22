package eu.telecomnancy.pcd2k17;

public class RecupEleve {

	
	private Integer tabId;
	private String tabNom;
	private String tabPromo;
	private String tabGroupe;
	private String tabPrenom;
	
	public RecupEleve () {
		this.tabId = null;
		this.tabGroupe = null;
		this.tabNom = null;
		this.tabPromo = null;
		this.tabPrenom = null;
	}
	
	public RecupEleve(String tabId, String tabPromo, String tabPrenom, String tabNom, String tabGroupe) {
		this.tabGroupe = new String(tabGroupe);
		this.tabId = new Integer(tabId);
		this.tabNom = new String(tabNom);
		this.tabPromo = new String(tabPromo);
		this.tabPrenom = new String(tabPrenom);
		
	}
	
	public Integer getTabId() {
		return tabId;
	}
	public void setTabId(Integer tabId) {
		this.tabId = tabId;
	}
	public String getTabNom() {
		return tabNom;
	}
	public void setTabNom(String tabNom) {
		this.tabNom = tabNom;
	}
	public String getTabPromo() {
		return tabPromo;
	}
	public void setTabPromo(String tabPromo) {
		this.tabPromo = tabPromo;
	}
	public String getTabGroupe() {
		return tabGroupe;
	}
	public void setTabGroupe(String tabGroupe) {
		this.tabGroupe = tabGroupe;
	}
	public String getTabPrenom() {
		return tabPrenom;
	}

	public void setTabPrenom(String tabPrenom) {
		this.tabPrenom = tabPrenom;
	}
}