package com.example.test;

import java.io.IOException;

class JMainB {
	public static void main(String[] args) throws IOException {
		JGradeCollectorB J_GradeCollector_B = new JGradeCollectorB(); // Create new instance of JGradeCollector and collect student data
		JProcessApplicationsB J_ProcessApplications_B = new JProcessApplicationsB(J_GradeCollector_B.JgetStudentDataB(), J_GradeCollector_B.JgetCutoffB()); // Create new instance of JProcessApplications and pass student data and cutoff
		J_ProcessApplications_B.JclearUniversityResponsesB(); // Clear university responses file
		J_ProcessApplications_B.JwriteStudentAveragesB(); // Write student averages to file
		J_ProcessApplications_B.JwriteStudentStatusesB(); // Write student statuses to file
		J_ProcessApplications_B.JwriteUniversityResponsesB(); // Write university responses to file
	}
}