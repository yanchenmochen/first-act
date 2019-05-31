package org.crazit.act.c3;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

public class First {
	public static void main(String[] args) {
		
		//������������
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		//�õ����̴洢�������
		RepositoryService repositoryService = engine.getRepositoryService();
		//��ȡ�����������
		TaskService taskService = engine.getTaskService();
		//��ȡ��������ʱ�������
		RuntimeService runtimeService = engine.getRuntimeService();
		//���������ļ�
		repositoryService.createDeployment().addClasspathResource("first.bpmn").deploy();
		//��������
		runtimeService.startProcessInstanceByKey("myProcess");
		
		Task task =  taskService.createTaskQuery().singleResult();
		System.out.println("��һ���������ǰ����ǰ�������ƣ� "+task.getName());
		System.out.println(task.getExecutionId());
		taskService.complete(task.getId());
		//��ɵ�һ������
		task = taskService.createTaskQuery().singleResult();
		System.out.println("�ڶ����������ǰ����ǰ��������: "+task.getName());
		taskService.complete(task.getId());
		
		task = taskService.createTaskQuery().singleResult();
		System.out.println("���̽����󣬲�������: "+ task);
		//�˳�
		System.exit(0);
	}
}
