package com.prodevans.DevOpsAssessmentTool.user.industry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndustryTypeRepository extends CrudRepository<IndustryType, Integer> {

}
