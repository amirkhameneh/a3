package com.hm.a3.dao;

import com.hm.a3.model.entity.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends MongoRepository<Tenant, Long> {
	Page<Tenant> findAll( Pageable pageable);

}

