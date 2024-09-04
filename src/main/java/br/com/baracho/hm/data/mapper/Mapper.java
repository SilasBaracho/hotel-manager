package br.com.baracho.hm.data.mapper;

public interface Mapper<Domain, Schema> {
    Domain toDomain(Schema schema);

    Schema toSchema(Domain domain);
}
