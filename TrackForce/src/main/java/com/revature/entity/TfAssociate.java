package com.revature.entity;
// Generated Nov 2, 2017 9:19:06 AM by Hibernate Tools 5.2.5.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TfAssociate generated by hbm2java
 */
@Entity
@Table(name = "TF_ASSOCIATE", schema = "ADMIN")
public class TfAssociate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6402610995778836801L;
	private BigDecimal tfAssociateId;
	private TfBatch tfBatch;
	private TfMarketingStatus tfMarketingStatus;
	private String tfAssociateFirstName;
	private String tfAssociateLastName;
	private Set<TfInterview> tfInterviews = new HashSet<TfInterview>(0);
	private Set<TfPlacement> tfPlacements = new HashSet<TfPlacement>(0);

	public TfAssociate() {
	}

	public TfAssociate(BigDecimal tfAssociateId) {
		this.tfAssociateId = tfAssociateId;
	}

	public TfAssociate(BigDecimal tfAssociateId, TfBatch tfBatch, TfMarketingStatus tfMarketingStatus,
			String tfAssociateFirstName, String tfAssociateLastName, Set<TfInterview> tfInterviews,
			Set<TfPlacement> tfPlacements) {
		this.tfAssociateId = tfAssociateId;
		this.tfBatch = tfBatch;
		this.tfMarketingStatus = tfMarketingStatus;
		this.tfAssociateFirstName = tfAssociateFirstName;
		this.tfAssociateLastName = tfAssociateLastName;
		this.tfInterviews = tfInterviews;
		this.tfPlacements = tfPlacements;
	}

	@Id

	@Column(name = "TF_ASSOCIATE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getTfAssociateId() {
		return this.tfAssociateId;
	}

	public void setTfAssociateId(BigDecimal tfAssociateId) {
		this.tfAssociateId = tfAssociateId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TF_BATCH_ID")
	public TfBatch getTfBatch() {
		return this.tfBatch;
	}

	public void setTfBatch(TfBatch tfBatch) {
		this.tfBatch = tfBatch;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TF_MARKETING_STATUS_ID")
	public TfMarketingStatus getTfMarketingStatus() {
		return this.tfMarketingStatus;
	}

	public void setTfMarketingStatus(TfMarketingStatus tfMarketingStatus) {
		this.tfMarketingStatus = tfMarketingStatus;
	}

	@Column(name = "TF_ASSOCIATE_FIRST_NAME", length = 30)
	public String getTfAssociateFirstName() {
		return this.tfAssociateFirstName;
	}

	public void setTfAssociateFirstName(String tfAssociateFirstName) {
		this.tfAssociateFirstName = tfAssociateFirstName;
	}

	@Column(name = "TF_ASSOCIATE_LAST_NAME", length = 30)
	public String getTfAssociateLastName() {
		return this.tfAssociateLastName;
	}

	public void setTfAssociateLastName(String tfAssociateLastName) {
		this.tfAssociateLastName = tfAssociateLastName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tfAssociate")
	public Set<TfInterview> getTfInterviews() {
		return this.tfInterviews;
	}

	public void setTfInterviews(Set<TfInterview> tfInterviews) {
		this.tfInterviews = tfInterviews;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tfAssociate")
	public Set<TfPlacement> getTfPlacements() {
		return this.tfPlacements;
	}

	public void setTfPlacements(Set<TfPlacement> tfPlacements) {
		this.tfPlacements = tfPlacements;
	}

//	@Override
//	public String toString() {
//		return "TfAssociate [tfAssociateId=" + tfAssociateId + ", tfBatch=" + tfBatch + ", tfMarketingStatus="
//				+ tfMarketingStatus + ", tfAssociateFirstName=" + tfAssociateFirstName + ", tfAssociateLastName="
//				+ tfAssociateLastName + ", tfInterviews=" + tfInterviews + ", tfPlacements=" + tfPlacements + "]";
//	}
	
	

}
