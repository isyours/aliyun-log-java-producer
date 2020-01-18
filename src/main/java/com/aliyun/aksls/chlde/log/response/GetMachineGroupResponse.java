package com.aliyun.aksls.chlde.log.response;

import java.util.Map;

import com.aliyun.aksls.chlde.log.common.MachineGroup;
import com.aliyun.aksls.chlde.log.exception.LogException;

public class GetMachineGroupResponse extends Response {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9132526915584919104L;
	MachineGroup machineGroup = new MachineGroup();

	public GetMachineGroupResponse(Map<String, String> headers, MachineGroup machineGroup) throws LogException {
		super(headers);
		SetMachineGroup(machineGroup);
	}

	public MachineGroup GetMachineGroup() {
		return machineGroup;
	}

	public void SetMachineGroup(MachineGroup machineGroup) throws LogException {
		this.machineGroup = new MachineGroup(machineGroup);
	}
	
}
