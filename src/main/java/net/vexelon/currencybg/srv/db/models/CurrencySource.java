package net.vexelon.currencybg.srv.db.models;

import java.util.Date;

public class CurrencySource {

	public static final int STATUS_ENABLED  = 0;
	public static final int STATUS_DISABLED = 1;

	private int                      sourceId;
	private String                   sourceName;
	private int                      status;
	private int                      updatePeriod;
	private Date                     lastUpdate;
	private SourceUpdateRestrictions updateRestrictions;

	public CurrencySource() {
		// empty
	}

	public CurrencySource(int sourceId, String sourceName, int status, int updatePeriod, Date lastUpdate) {
		this.sourceId = sourceId;
		this.sourceName = sourceName;
		this.status = status;
		this.updatePeriod = updatePeriod;
		this.lastUpdate = lastUpdate;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUpdatePeriod() {
		return updatePeriod;
	}

	public void setUpdatePeriod(int updatePeriod) {
		this.updatePeriod = updatePeriod;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public SourceUpdateRestrictions getUpdateRestrictions() {
		return updateRestrictions;
	}

	public void setUpdateRestrictions(SourceUpdateRestrictions updateInfo) {
		this.updateRestrictions = updateInfo;
	}

	@Override
	public String toString() {
		return "CurrencySource [sourceId=" + sourceId + ", sourceName=" + sourceName + ", status=" + status
				+ ", updatePeriod=" + updatePeriod + ", lastUpdate=" + lastUpdate + ", updateRestrictions=" + (
				updateRestrictions != null ?
						updateRestrictions.toString() :
						"") + "]";
	}

}
