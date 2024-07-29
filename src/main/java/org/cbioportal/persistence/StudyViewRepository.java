package org.cbioportal.persistence;

import org.cbioportal.model.AlterationCountByGene;
import org.cbioportal.model.ClinicalAttribute;
import org.cbioportal.model.CaseListDataCount;
import org.cbioportal.model.ClinicalData;
import org.cbioportal.model.ClinicalDataCount;
import org.cbioportal.model.ClinicalEventTypeCount;
import org.cbioportal.model.CopyNumberCountByGene;
import org.cbioportal.model.GenericAssayDataCountItem;
import org.cbioportal.model.GenomicDataCount;
import org.cbioportal.model.PatientTreatment;
import org.cbioportal.model.PatientTreatmentReport;
import org.cbioportal.model.Sample;
import org.cbioportal.web.parameter.ClinicalDataType;
import org.cbioportal.web.parameter.StudyViewFilter;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StudyViewRepository {
    List<Sample> getFilteredSamples(StudyViewFilter studyViewFilter);

    List<ClinicalData> getSampleClinicalData(StudyViewFilter studyViewFilter, List<String> attributeIds);
    
    List<ClinicalData> getPatientClinicalData(StudyViewFilter studyViewFilter, List<String> attributeIds);
    
    List<AlterationCountByGene> getMutatedGenes(StudyViewFilter studyViewFilter);
    
    List<AlterationCountByGene> getStructuralVariantGenes(StudyViewFilter studyViewFilter);
    List<CopyNumberCountByGene> getCnaGenes(StudyViewFilter studyViewFilter);
    
    List<ClinicalDataCount> getClinicalDataCounts(StudyViewFilter studyViewFilter, List<String> filteredAttributes);
    
    List<GenomicDataCount> getGenomicDataCounts(StudyViewFilter studyViewFilter);
    
    List<ClinicalAttribute> getClinicalAttributes();

    Map<String, ClinicalDataType> getClinicalAttributeDatatypeMap();

    List<CaseListDataCount> getCaseListDataCounts(StudyViewFilter studyViewFilter);

    Map<String, Integer> getTotalProfiledCounts(StudyViewFilter studyViewFilter, String alterationType);
    
    int getFilteredSamplesCount(StudyViewFilter studyViewFilter);
    
    Map<String, Set<String>> getMatchingGenePanelIds(StudyViewFilter studyViewFilter, String alterationType);
    
    int getTotalProfiledCountsByAlterationType(StudyViewFilter studyViewFilter, String alterationType);
    
    int getSampleProfileCountWithoutPanelData(StudyViewFilter studyViewFilter, String alterationType);
    
    List<ClinicalEventTypeCount> getClinicalEventTypeCounts(StudyViewFilter studyViewFilter);

    List<GenericAssayDataCountItem> getGenericAssayDataCounts(StudyViewFilter studyViewFilter,
                                                              List<String> stableId, List<String> profileType);
    
    
    
    List<PatientTreatment> getPatientTreatments(StudyViewFilter studyViewFilter);
    
    PatientTreatmentReport getPatientTreatmentReport(StudyViewFilter studyViewFilter);
}
