package com.bmc.truesight.wscommon.itda.to;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonWriteNullProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonWriteNullProperties(false)
@JsonSerialize(include=Inclusion.NON_NULL)
public class ItdaCollectorConsumptionInfo implements Serializable {
	
	private static final long serialVersionUID = 2120209080705072704L;

	@JsonProperty(value="collector_name")
	private String collectorName;
	
	@JsonProperty(value="messagess")
	private long messages;
	
	public ItdaCollectorConsumptionInfo(){
		
	}
		
	public ItdaCollectorConsumptionInfo(String collectorName, long messages) {
		this.collectorName = collectorName;
		this.messages = messages;
	}

	public long getMessages() {
		return messages;
	}
	
	public void setMessages(long messages) {
		this.messages = messages;
	}
	
	public String getCollectorName() {
		return collectorName;
	}
	
	public void setCollectorName(String collectorName) {
		this.collectorName = collectorName;
	}
	
	public String toString() {
		return "{ collectorName: "+collectorName+
				" , messages: "+messages+" }";
	}
}
