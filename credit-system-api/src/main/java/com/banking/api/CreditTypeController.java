package com.banking.api;

import com.banking.business.CreditTypeService;
import com.banking.dto.credit.CreditTypeDTO;
import com.banking.dto.credit.CreditTypeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credit-types")
public class CreditTypeController {

    private final CreditTypeService creditTypeService;

    @Autowired
    public CreditTypeController(CreditTypeService creditTypeService) {
        this.creditTypeService = creditTypeService;
    }

    @GetMapping
    public ResponseEntity<List<CreditTypeDTO>> getAllCreditTypes() {
        return ResponseEntity.ok(creditTypeService.getAllCreditTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditTypeDTO> getCreditTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(creditTypeService.getCreditTypeById(id));
    }

    @PostMapping
    public ResponseEntity<CreditTypeDTO> createCreditType(@RequestBody CreditTypeRequestDTO requestDTO) {
        return ResponseEntity.ok(creditTypeService.createCreditType(requestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditTypeDTO> updateCreditType(@PathVariable Long id, @RequestBody CreditTypeRequestDTO requestDTO) {
        return ResponseEntity.ok(creditTypeService.updateCreditType(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreditType(@PathVariable Long id) {
        creditTypeService.deleteCreditType(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<CreditTypeDTO>> getActiveCreditTypes() {
        return ResponseEntity.ok(creditTypeService.getActiveCreditTypes());
    }

    @PostMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateCreditType(@PathVariable Long id) {
        creditTypeService.deactivateCreditType(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/activate")
    public ResponseEntity<Void> activateCreditType(@PathVariable Long id) {
        creditTypeService.activateCreditType(id);
        return ResponseEntity.ok().build();
    }
} 