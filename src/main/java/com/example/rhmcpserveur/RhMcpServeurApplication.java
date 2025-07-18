package com.example.rhmcpserveur;

import com.example.rhmcpserveur.service.*;
import com.example.rhmcpserveur.tools.*;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RhMcpServeurApplication {

    public static void main(String[] args) {
        SpringApplication.run(RhMcpServeurApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider rhTools(EducationTool educationTool, ExperienceTool experienceTool,
                                        EmployeeTool employeeTool, JobSeekerTool jobSeekerTool,
                                        PersonTool personTool, SkillTool skillTool) {
        return MethodToolCallbackProvider.builder().toolObjects(
                                                        educationTool ,employeeTool,experienceTool,
                                                        jobSeekerTool,personTool,skillTool)
                                                    .build();
    }

}
