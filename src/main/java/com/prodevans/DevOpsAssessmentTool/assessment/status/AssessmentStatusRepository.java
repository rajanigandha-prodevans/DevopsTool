package com.prodevans.DevOpsAssessmentTool.assessment.status;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentStatusRepository extends CrudRepository<AssessmentStatus, Integer>{

}
