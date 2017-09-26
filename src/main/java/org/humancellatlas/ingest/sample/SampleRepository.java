package org.humancellatlas.ingest.sample;

import org.humancellatlas.ingest.core.Uuid;
import org.humancellatlas.ingest.submission.SubmissionEnvelope;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Javadocs go here!
 *
 * @author Tony Burdett
 * @date 31/08/17
 */
@CrossOrigin
public interface SampleRepository extends MongoRepository<Sample, String> {
    public Sample findByUuid(@Param("uuid") Uuid uuid);

    public Page<Sample> findBySubmissionEnvelope(SubmissionEnvelope submissionEnvelope, Pageable pageable);
}
