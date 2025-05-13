package com.backendspa.controller;

import com.backendspa.entity.Reserva;
import com.backendspa.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recepcionista")
public class RecepcionistaController {

    private final ReservaService reservaService;

    public RecepcionistaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/reservas")
    @PreAuthorize("hasRole('ROLE_RECEPCIONISTA')")
    public ResponseEntity<List<Reserva>> getReservasForRecepcionista() {
        return ResponseEntity.ok(reservaService.getAllReservas());
    }
}
