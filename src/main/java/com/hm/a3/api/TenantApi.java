package com.hm.a3.api;

import com.hm.a3.model.entity.Tenant;
import com.hm.a3.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping( "/api/v1/tenant" )
@RequiredArgsConstructor
public class TenantApi {

	private final TenantService tenantService;

	@PostMapping( "" ) public ResponseEntity<Void> save( @RequestBody Tenant tenant ) {
		tenantService.save( tenant );
		return ResponseEntity.ok().build();
	}

	@GetMapping( "" ) public ResponseEntity<Map<String, Object>> findAll( @RequestParam( defaultValue = "0" ) int page, @RequestParam( defaultValue = "10" ) int size ) {
		Page<Tenant> tenants = tenantService.findAll( PageRequest.of( page, size ) );
		Map<String, Object> response = new HashMap<>();
		response.put("tenants", tenants.getContent());
		response.put("currentPage", tenants.getNumber());
		response.put("totalItems", tenants.getTotalElements());
		response.put("totalPages", tenants.getTotalPages());

		return ResponseEntity.ok(response);
	}
}
