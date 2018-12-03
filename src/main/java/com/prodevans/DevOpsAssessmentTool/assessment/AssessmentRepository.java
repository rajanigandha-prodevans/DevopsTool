package com.prodevans.DevOpsAssessmentTool.assessment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends CrudRepository<Assessment, Integer>{

	/**
	 * This method is defined for getting the  assess by passing the email address.
	 * It returns the Set of optional collection
	 * @param user_id : get the user information
	 * @return - List of user having the address.
	 */
	@Query("SELECT a FROM com.prodevans.DevOpsAssessmentTool.assessment.Assessment a JOIN a.user u WHERE u.user_id=:user_id order by a.created_date desc")
	public List<Assessment> getAssessmentByUserId(@Param("user_id")int user_id); 
	
	@Query("SELECT a FROM com.prodevans.DevOpsAssessmentTool.assessment.Assessment a JOIN a.user u WHERE u.user_id=:user_id and a.assessment_id=:assessment_id")
	Optional<Assessment> getAssessment(@Param("user_id")Integer user_id, @Param("assessment_id")Integer assessment_id);
}
