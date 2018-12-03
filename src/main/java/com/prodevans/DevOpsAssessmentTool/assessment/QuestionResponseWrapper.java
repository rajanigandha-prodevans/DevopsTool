package com.prodevans.DevOpsAssessmentTool.assessment;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "question_id",
        "question",
        "question_type",
        "category_name",
        "questionOptions"
})
public class QuestionResponseWrapper {

    @JsonProperty("question_id")
    private Integer questionId;
    @JsonProperty("question")
    private String question;
    @JsonProperty("question_type")
    private String questionType;
    @JsonProperty("category_name")
    private String categoryName;
    @JsonProperty("questionOptions")
    private List<QuestionOptionWrapper> questionOptions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("question_id")
    public Integer getQuestionId() {
        return questionId;
    }

    @JsonProperty("question_id")
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @JsonProperty("question")
    public String getQuestion() {
        return question;
    }

    @JsonProperty("question")
    public void setQuestion(String question) {
        this.question = question;
    }

    @JsonProperty("question_type")
    public String getQuestionType() {
        return questionType;
    }

    @JsonProperty("question_type")
    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    @JsonProperty("category_name")
    public String getCategoryName() {
        return categoryName;
    }

    @JsonProperty("category_name")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @JsonProperty("questionOptions")
    public List<QuestionOptionWrapper> getQuestionOptions() {
        return questionOptions;
    }

    @JsonProperty("questionOptions")
    public void setQuestionOptions(List<QuestionOptionWrapper> questionOptions) {
        this.questionOptions = questionOptions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "question_option",
        "question_option_id",
        "is_selected"
})
class QuestionOptionWrapper {

    @JsonProperty("question_option")
    private String questionOption;
    @JsonProperty("question_option_id")
    private Integer questionOptionId;
    @JsonProperty("is_selected")
    private Boolean isSelected;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("question_option")
    public String getQuestionOption() {
        return questionOption;
    }

    @JsonProperty("question_option")
    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }

    @JsonProperty("question_option_id")
    public Integer getQuestionOptionId() {
        return questionOptionId;
    }

    @JsonProperty("question_option_id")
    public void setQuestionOptionId(Integer questionOptionId) {
        this.questionOptionId = questionOptionId;
    }

    @JsonProperty("is_selected")
    public Boolean getIsSelected() {
        return isSelected;
    }

    @JsonProperty("is_selected")
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}