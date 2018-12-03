package com.prodevans.DevOpsAssessmentTool.assessment.result_maturity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentResultMaturityRepository extends CrudRepository<AssessmentResultMaturity, Integer> {

}
