package com.ai.common.bpmn.repository.impl;

import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ai.common.bpmn.model.Activity;
import com.ai.common.bpmn.model.BaseEvent;
import com.ai.common.bpmn.model.EventListenerSet;
import com.ai.common.bpmn.repository.interfaces.IBpmnRepository;

@Component
public class BpmnRepository implements IBpmnRepository {

	public BpmnRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<Activity> getActivitiesByOutputEvent(BaseEvent event) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEventListenerSetToFile(EventListenerSet eventListenerSet) throws Exception {
		String location = BpmnRepository.class.getProtectionDomain().getCodeSource().getLocation().toString();
		String path=location.toString();
		path=path.replace("file:/","");
		path=path.replace("target/classes", "src/main/groovy/com/ai/eventlistener");
		String fileName=eventListenerSet.getCode();
		String fullFileName=path+"/"+fileName+".groovy";
		Path file = Paths.get(fullFileName);
		List<String> lines = Arrays.asList(eventListenerSet.toGroovyString());
		Files.write(file, lines, Charset.forName("UTF-8"));
	}

}
