package cn.clvstudio.easemob.body;

import com.fasterxml.jackson.databind.node.ContainerNode;

public interface BodyWrapper {	
	ContainerNode<?> getBody();
	Boolean validate();
}
