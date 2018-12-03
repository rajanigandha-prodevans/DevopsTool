package com.prodevans.DevOpsAssessmentTool.user.companysize;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySizeRepository extends CrudRepository<CompanySize, Integer> {

}
