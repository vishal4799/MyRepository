package com.bmc.truesight.wscommon.itda.to;
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/

import com.bmc.sms.wscommon.client.ClientResponseTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonWriteNullProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonWriteNullProperties(false)
@JsonSerialize(include=Inclusion.NON_NULL)
public class ItdaConsumptionResponseTO extends ClientResponseTO {

	private static final long serialVersionUID = 1919815486348001866L;

	@JsonProperty(value = "total_collectors")
	private long totalCollectors;
	
	@JsonProperty(value = "total_messages")
	private long totalMessages;
	
	@JsonProperty(value = "collector_consumption")
	private List<ItdaCollectorConsumptionInfo> collectors;
	
	@JsonProperty(value="tenant_name")
	private String tenantName;
	
	@JsonProperty(value="host_name")
	private String hostName;

	private String statusMessage;
	
	
	public long getTotalCollectors() {
		return totalCollectors;
	}

	public void setTotalCollectors(long totalCollectors) {
		this.totalCollectors = totalCollectors;
	}

	public long getTotalMessages() {
		return totalMessages;
	}

	public void setTotalMessages(long totalMessages) {
		this.totalMessages = totalMessages;
	}

	public List<ItdaCollectorConsumptionInfo> getCollectors() {
		return collectors;
	}

	public void setCollectors(List<ItdaCollectorConsumptionInfo> collectors) {
		this.collectors = collectors;
	}
	
	public void addcollector(ItdaCollectorConsumptionInfo collector) {
		if(Objects.isNull(this.collectors )) {
			this.collectors = new ArrayList<>();
		}
		this.collectors.add(collector);
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	
	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Override
	public String toString() {
		return "ItdaConsumptionResponseTO [totalCollectors=" + totalCollectors + ", totalMessages=" + totalMessages
				+", tenantName=" + tenantName + ", hostName=" + hostName
				+ ", statusMessage=" + statusMessage + "]";
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
		this.setStatusMsg(statusMessage);
	}

}
