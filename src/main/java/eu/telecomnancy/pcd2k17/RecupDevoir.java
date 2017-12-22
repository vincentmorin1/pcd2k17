package eu.telecomnancy.pcd2k17;

public class RecupDevoir {

	
	private String tabTitle;
	private String tabMatier;
	private String tabStart;
	private String tabEnd;
	private String tabListee;
	
	public RecupDevoir () {
		this.tabTitle = null;
		this.tabMatier = null;
		this.tabEnd = null;
		this.tabStart = null;
		this.tabListee = null;
	}
	
	public RecupDevoir(String tabTitle, String tabMatier, String tabStart, String tabEnd, String tabListee) {
	
		this.tabEnd = tabEnd;
		this.tabStart = tabStart;
		this.tabListee = tabListee;
		this.tabMatier = tabMatier;
		this.tabTitle = tabTitle;
		
	}

	public String getTabTitle() {
		return tabTitle;
	}

	public void setTabTitle(String tabTitle) {
		this.tabTitle = tabTitle;
	}

	public String getTabMatier() {
		return tabMatier;
	}

	public void setTabMatier(String tabMatier) {
		this.tabMatier = tabMatier;
	}

	public String getTabStart() {
		return tabStart;
	}

	public void setTabStart(String tabStart) {
		this.tabStart = tabStart;
	}

	public String getTabEnd() {
		return tabEnd;
	}

	public void setTabEnd(String tabEnd) {
		this.tabEnd = tabEnd;
	}

	public String getTabListee() {
		return tabListee;
	}

	public void setTabListee(String tabListee) {
		this.tabListee = tabListee;
	}
	
}