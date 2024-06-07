package com.example.test;

import java.io.IOException;

class JMainB {
	public static void main(String[] args) throws IOException {
		JGradeCollectorB J_GradeCollector_B = new JGradeCollectorB();
		JProcessApplicationsB J_ProcessApplications_B = new JProcessApplicationsB(J_GradeCollector_B.JgetStudentDataArrayB(), J_GradeCollector_B.JgetCutoffB());
		J_ProcessApplications_B.JclearUniversityResponsesB();
		J_ProcessApplications_B.JwriteStudentAveragesB();
		J_ProcessApplications_B.JwriteUniversityResponsesB();
		J_ProcessApplications_B.JwriteStudentStatusesB();
	}
}