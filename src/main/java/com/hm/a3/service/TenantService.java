package com.hm.a3.service;

import com.hm.a3.dao.TenantRepository;
import com.hm.a3.model.entity.Tenant;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TenantService {

	private final TenantRepository tenantRepository;

	public Tenant save( Tenant tenant ) {
		return tenantRepository.save( tenant );
	}

	public Page<Tenant> findAll( Pageable pageRequest ){
		return tenantRepository.findAll(pageRequest);
	}

}
