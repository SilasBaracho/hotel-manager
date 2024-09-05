package br.com.baracho.hm.core.application.gateway;

import br.com.baracho.hm.core.domain.model.entities.BookingDomain;

public interface BookingCreatedPendingProcessingProducerGateway<Avro> {
    void execute(BookingDomain bookingDomain);
}
