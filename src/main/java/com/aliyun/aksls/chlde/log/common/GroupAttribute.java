package com.aliyun.aksls.chlde.log.common;

import java.io.Serializable;

import com.aliyun.aksls.chlde.log.exception.LogException;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class GroupAttribute implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -537679331882943768L;
	protected String externalName = "";
	protected String groupTopic = "";
	
	public GroupAttribute() {
	}
	
	public GroupAttribute(String externalName, String groupTopic) {
		super();
		this.externalName = externalName;
		this.groupTopic = groupTopic;
	}
	
	public GroupAttribute(GroupAttribute groupAttribute) {
		super();
		this.externalName = groupAttribute.GetExternalName();
		this.groupTopic = groupAttribute.GetGroupTopic();
	}
	
	public String GetExternalName() {
		return externalName;
	}
	public void SetExternalName(String externalName) {
		this.externalName = externalName;
	}
	
	public String GetGroupTopic() {
		return groupTopic;
	}
	public void SetGroupTopic(String groupTopic) {
		this.groupTopic = groupTopic;
	}
	
	public JSONObject ToJsonObject() {
		JSONObject groupAttributeDict = new JSONObject();
		
		groupAttributeDict.put("groupTopic", GetGroupTopic());
		groupAttributeDict.put("externalName", GetExternalName());
		
		return groupAttributeDict;
	}
	
	public String ToJsonString() {
		return ToJsonObject().toString();
	}
	
	public void FromJsonObject(JSONObject groupAttribute) throws LogException {
		try {
			this.externalName = groupAttribute.getString("externalName");
			this.groupTopic = groupAttribute.getString("groupTopic");
		} catch (JSONException e) {
			throw new LogException("FailToGenerateGroupAttribute", e.getMessage(), e, "");
		}
	}
	
	public void FromJsonString(String groupAttributeString) throws LogException {
		try {
			JSONObject groupAttribute = JSONObject.fromObject(groupAttributeString);
			FromJsonObject(groupAttribute);
		} catch (JSONException e) {
			throw new LogException("FailToGenerateGroupAttribute", e.getMessage(), e, "");
		}
	}
}
